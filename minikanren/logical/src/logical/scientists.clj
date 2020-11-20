(ns logical.scientists
  (:require [clojure.string :as s]
            [clojure.set]
            [clojure.core.logic.pldb]
            [clojure.core.logic :refer :all]
            [clojure.core.logic.fd :as fd]))

(defn -main
  [& args]
  (println "Scientists"))


(reduce + 0 [1 2 3 4 5])

;; frequencies
(def lorem "Proin quam nisl, tincidunt et, mattis eget, convallis nec, purus.")

(defn freq [s]
  (reduce #(assoc %1 %2 (inc (%1 %2 0)))
          {}
          s))


(frequencies lorem)

(freq lorem)


(reduce
 (fn [primes number]
   (if (some zero? (map (partial mod number) primes))
     primes
     (conj primes number)))
 [2]
 (take 1000 (iterate inc 3)))

(reduce
 (fn [a b] (conj a (+' (last a) (last (butlast a)))))
 [0 1]
 (take 20 (range)))

(take 20
      (map first
           (iterate (fn [[a b]] [b (+' a b)])
                    [0 1])))
