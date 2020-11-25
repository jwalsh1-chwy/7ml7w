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