(ns logical.core
  (:require [clojure.string :as s]
            [clojure.set]
            [clojure.core.logic.pldb]
            [clojure.core.logic :refer :all]
            [clojure.core.logic.fd :as fd]))

(defn -main
  "miniKanren example"
  [& args]
  (println "miniKanren"))

(quote
 (
  (run* [q] (== q 1))

  (run* [q] (== 2 1))

  (run* [q] (== q 1) (== q 2))

  (run 2 [q] (membero q [1 2 3]))

  (run* [q] (== q "corn"))

  (run* [q]
    (let [x "apple"]
      (== q x)))

  (run* [q]
    (fresh [x]
      (== x "peach")
      (== q x)))

  (run* [q]
    (fd/in q (fd/interval 0 10))
    (fd/== 2 q))

  (run* [q]
    (fresh [x y]
      (== q [x y])
      (fd/in x y (fd/interval 8 10))
      (== q [x y])))

  (run* [q]
    (fresh [x y]
      (== q [x y])
      (fd/in x y (fd/interval 0 100))
      (fd/<= x y)
      (fd/* x y 64)))

  (run* [q]
    (fresh [x y]
      (conde
       ((== "split" x) (== "pea" y))
       ((== "navy" x) (== "bean" y)))
      (== (cons x (cons y ())) q)))

  (run* [q]
    (fresh [x y]
      (conde
       ((== "split" x) (== "pea" y))
       ((== "navy" x) (== "bean" y)))
      (== [x y] q)))

  (run* [q]
    (firsto (seq "acorn") q))

  (run 1 [q]
    (fresh [x y]
      (== q (cons x (cons y "grape")))))

  (defn twinso [s]
    (fresh [x]
      (== [x x] s)))

  (run* [q]
    (twinso [q "tofu"]))

  (run 5 [q]
    (firsto q "a"))

  ))

(quote
 (
  (db-rel mano x)
  (db-rel womano x)
  (db-rel languageo p l)
  (db-rel vitalo p v)
  (db-rel turingo y)
  (db-rel systemo p m)
  (def facts
    (db
     [mano :alan-turing]
     [womano :grace-hopper]
     [mano :leslie-lamport]
     [mano :alonzo-church]
     [womano :ada-lovelace]
     [womano :barbara-liskov]
     [womano :frances-allen]
     [mano :john-mccarthy]))

  (with-db facts
    (run* [q]
      (womano q)))

  (def facts
    (-> facts
        (db-fact vitalo :alan-turing :dead)
        (db-fact vitalo :grace-hopper :dead)
        (db-fact vitalo :laverne-cox :alive)
        (db-fact vitalo :leslie-lamport :alive)
        (db-fact vitalo :alonzo-church :dead)
        (db-fact vitalo :ada-lovelace :dead)
        (db-fact vitalo :barbara-liskov :alive)
        (db-fact vitalo :frances-allen :alive)
        (db-fact vitalo :john-mccarthy :dead)
        (db-fact turingo :leslie-lamport :2013)
        (db-fact turingo :barbara-liskov :2008)
        (db-fact turingo :john-mccarthy :1971)
        (db-fact turingo :frances-allen :2006)
        (db-fact languageo :alan-turing :turing)
        (db-fact languageo :grace-hopper :cobol)
        (db-fact languageo :grace-hopper :fortran)
        (db-fact languageo :leslie-lamport :tla)
        (db-fact languageo :alonzo-church :lambda-calculus)
        (db-fact languageo :ada-lovalace :note-g)
        (db-fact languageo :barbara-liskov :clu)
        (db-fact languageo :frances-allen :fortran)
        (db-fact languageo :frances-allen :autocoder)
        (db-fact languageo :john-mccarthy :lisp)
        (db-fact systemo :alan-turing :pilot-ace)
        (db-fact systemo :alan-turing :bombe)
        (db-fact systemo :alan-turing :turing-machine)
        (db-fact systemo :grace-hopper :univac)
        (db-fact systemo :ada-lovelace :analytical-engine)))

  ))


(def pets-dogs
  #{
    {:name "Bella", :parent "acaruso"}
    {:name "Charlie", :parent "bwu"}
    {:name "Luna", :parent "bwu"}
    {:name "Lucy", :parent "chughes"}
    {:name "Max", :parent "cprinos"}
    {:name "Bailey", :parent "ddean"}
    {:name "Cooper", :parent "ddean"}
    {:name "Daisy", :parent "gclements"}
    {:name "Sadie", :parent "gclements"}
    {:name "Molly", :parent "jhodge"}
    {:name "Buddy", :parent "jvincelette"}
    {:name "Lola", :parent "jwalsh"}
    {:name "Stella", :parent "kkumar"}
    {:name "Tucker", :parent "ksullivan"}
    {:name "Bentley", :parent "mveljkovic"}
    {:name "Zoey", :parent "nfoudi"}
    {:name "Harley", :parent "rhaines"}
    {:name "Spot", :parent "xtao"}
    })


(def pets-cats
  #{
    {:name "Garfield", :parent "jwalsh"}
    })


(def blank-board
  (into [] (take 81 (repeat 0))))


;; https://gist.github.com/orb/5884956
(defn init-board [vars puzzle]
  (matche [vars puzzle]
          ([[] []]
           succeed)
          ([[_ . more-vars] [0 . more-puzzle]]
           (init-board more-vars more-puzzle))
          ([[num . more-vars] [num . more-puzzle]]
           (init-board more-vars more-puzzle))))


(defn solve [puzzle]
  (let [sdnum (fd/domain 1 2 3 4 5 6 7 8 9)
        board (repeatedly 81 lvar)
        rows (into [] (map vec (partition 9 board)))
        cols (apply map vector rows)

        get-square (fn [x y]
                     (for [x (range x (+ x 3))
                           y (range y (+ y 3))]
                       (get-in rows [x y])))

        squares (for [x (range 0 9 3)
                      y (range 0 9 3)]
                  (get-square x y))]

    (run* [q]
      (== q board)
      (everyg #(fd/in % sdnum) board)
      (init-board board puzzle)
      (everyg fd/distinct rows)
      (everyg fd/distinct cols)
      (everyg fd/distinct squares))))


(def puzzle1
  [0 0 0 0 0 9 0 6 0
   0 3 8 0 0 5 0 0 4
   0 2 0 0 6 0 0 7 0
   0 0 0 0 0 0 3 9 0
   0 0 0 9 2 6 0 0 0
   0 9 7 0 0 0 0 0 0
   0 4 0 0 7 0 0 3 0
   5 0 0 4 0 0 2 1 0
   0 7 0 8 0 0 0 0 0])

(def puzzle2
  [0 3 0 5 0 0 0 0 0
   7 0 0 0 6 0 9 0 0
   8 2 9 0 0 0 0 0 0
   9 6 0 0 3 0 1 0 0
   3 0 0 6 0 4 0 0 2
   0 0 4 0 8 0 0 7 6
   0 0 0 0 0 0 7 5 3
   0 0 7 0 5 0 0 0 9
   0 0 0 0 0 9 0 1 0])

;; http://www.sudokudragon.com/unsolvable.htm
(def puzzle3
  [0 8 0 0 0 9 7 4 3
   0 5 0 0 0 8 0 1 0
   0 1 0 0 0 0 0 0 0
   8 0 0 0 0 5 0 0 0
   0 0 0 8 0 4 0 0 0
   0 0 0 3 0 0 0 0 6
   0 0 0 0 0 0 0 7 0
   0 3 0 5 0 0 0 8 0
   9 7 2 4 0 0 0 5 0])

(comment
  (partition 9 (first (solve puzzle1)))
  ((7 1 4 2 8 9 5 6 3)
   (6 3 8 7 1 5 9 2 4)
   (9 2 5 3 6 4 1 7 8)
   (8 6 1 5 4 7 3 9 2)
   (4 5 3 9 2 6 7 8 1)
   (2 9 7 1 3 8 4 5 6)
   (1 4 9 6 7 2 8 3 5)
   (5 8 6 4 9 3 2 1 7)
   (3 7 2 8 5 1 6 4 9))

  (partition 9 (first (solve puzzle2)))
  ((4 3 6 5 9 1 2 8 7)
   (7 5 1 8 6 2 9 3 4)
   (8 2 9 4 7 3 5 6 1)
   (9 6 8 2 3 7 1 4 5)
   (3 7 5 6 1 4 8 9 2)
   (2 1 4 9 8 5 3 7 6)
   (6 9 2 1 4 8 7 5 3)
   (1 8 7 3 5 6 4 2 9)
   (5 4 3 7 2 9 6 1 8))

  (count (solve puzzle3))
  8

  )
