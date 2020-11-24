(ns logical.sudoku
  (:require [clojure.set]
            [clojure.core.logic.pldb]
            [clojure.core.logic :refer :all]
            [clojure.core.logic.fd :as fd]))

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

  (partition 9 (first (solve puzzle2)))

  (count (solve puzzle3))
  8)

;; Sodoku
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

  (partition 9 (first (solve puzzle2)))

  (count (solve puzzle3))
  8)

