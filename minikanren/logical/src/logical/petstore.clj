(ns logical.petstore
  (:require [clojure.set]
            [clojure.core.logic.pldb]
            [clojure.core.logic :refer :all]))

(defn -main
  "Petstore example"
  [& _args]
  (println "Petstore"))

(def om {:F "forward"
         :L "left"
         :R "right"})

(defn rtr [ops]
  (let [orientation 0
        position [0 0]
        opmap {
               :F "forward"
               :L orientation
               :R orientation
               }
        orientationmap
        [[1 0]
         [0 1]
         [-1 0]
         [0 1]]
        ]
    (map print-str (map #(opmap (keyword (str %))) ops))
    )
  )

(rtr "LLFRRF")

(def position [0 0])
(def orientation-seq  [[1 0]
                       [0 1]
                       [-1 0]
                       [0 1]])
(def orientation 3)


(vec (map + position (nth orientation-seq orientation)))

(def s "LRLFFFFRRFFFF")

(reduce #(assoc %1 %2 (inc (%1 %2 0)))
        {}
        s)

(defn my-reverse [l]
  (if (empty? l)
    l
    (cons (my-reverse (rest l)) (first l))))


(my-reverse '(a b c d e f g))

(first '(a b c))
