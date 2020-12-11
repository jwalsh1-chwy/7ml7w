(ns logical.core
  (:require [clojure.set]
            [clojure.core.logic.pldb :refer :all]
            [clojure.core.logic :refer :all]
            [clojure.core.logic.fd :as fd]))

(defn -main
  "miniKanren example"
  [& _args]
  (println "miniKanren"))

;; Relations
(quote
 (
  (run* [q]
    (== q 1))

  (run* [q]
    (== 2 1))

  (run* [q]
    (== q 1)
    (== q 2))

  (run 5 [q]
    (membero 1 [5 q 3]))

  (run 3 [q]
    (== q '(1 3 6)))

  (run* [q]
    (== q "corn"))

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
    (fresh [x y]
      (conde
       ((== "lentil" x))
       ((== "minestrone" y))
       ((== "split" x) (== "pea" y))
       ((== "navy" x) (== "bean" y)))
      (== [x y] q)))

  (run* [q]
    (fresh [x y]
      (conde
       ((== 1 x))
       ((== 2 y))
       ((== 3 x) (== 4 y))
       ((== 5 x) (== 2 y)))
      (== (list x y) q)))

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

  (run* [q]
    (conso :a [:b :c] q))

  (run* [q]
    (conso :a q [:a :b :c]))

  ;; (defn insideo [e l]
  ;;   (conde
  ;;    [(fresh [h t]
  ;;       (conso h t l)
  ;;       ((== h e)))]
  ;;    [(fresh [h t]
  ;;       (conso h t l)
  ;;       (insideo e t))]))

  ;; (defn insideo [e l]
  ;;   (matche [l]
  ;;           ([[e . _]])
  ;;           ([[_ . t]] (insideo e t))))

  (defne insideo [e l]
    ([_ [e . _]])
    ([_ [_ . t]] (insideo e t)))

  (run* [q]
    (insideo q [:a :b :c]))

  (run 3 [q]
    (insideo :a q))

  (run* [q]
    (insideo :b [:a q :c]))

  (run 1 [q]
    (success))


  (def teacupo []
    (lambda [x]
       (conde)))

  ))

;; Databases
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


(for [x [1 2 3 4 5 6 7 8 9]
      y [3 5 7 9 11 13]]
  (* x y))
