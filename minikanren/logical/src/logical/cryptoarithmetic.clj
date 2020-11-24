(ns logical.cryptoarithmetic
  (:require [clojure.set]
            [clojure.core.logic.pldb]
            [clojure.core.logic :refer :all]
            [clojure.core.logic.fd :as fd]))

;; Cryptoarithmetic 
;; https://stackoverflow.com/questions/55315374/using-apply-in-core-logic-clojure-clp-cryptoarithmetic 

(defn sumo [vars sum]
  (fresh [vhead vtail run-sum]
         (conde
          [(== vars ()) (== sum 0)]
          [(conso vhead vtail vars)
           (fd/+ vhead run-sum sum)
           (sumo vtail run-sum)])))

(defn productsumo [vars dens sum]
  (fresh [vhead vtail dhead dtail product run-sum]
         (conde
          [(emptyo vars) (== sum 0)]
          [(conso vhead vtail vars)
           (conso dhead dtail dens)
           (fd/* vhead dhead product)
           (fd/+ product run-sum sum)
           (productsumo vtail dtail run-sum)])))

(defn magnitudes [n]
  (reverse (take n (iterate #(* 10 %) 1))))

(defn cryptarithmetic [& words]
  (let [distinct-chars (distinct (apply concat words))
        char->lvar (zipmap distinct-chars (repeatedly (count distinct-chars) lvar))
        lvars (vals char->lvar)
        first-letter-lvars (distinct (map #(char->lvar (first %)) words))
        sum-lvars (repeatedly (count words) lvar)
        word-lvars (map #(map char->lvar %) words)]
    (run* [q]
          (everyg #(fd/in % (fd/interval 0 9)) lvars) ;; digits 0-9
          (everyg #(fd/!= % 0) first-letter-lvars) ;; no leading zeroes
          (fd/distinct lvars) ;; only distinct digits
          (everyg (fn [[sum l]] ;; calculate sums for each word
                    (productsumo l (magnitudes (count l)) sum))
                  (map vector sum-lvars word-lvars))
          (fresh [s]
                 (sumo (butlast sum-lvars) s) ;; sum all input word sums
                 (fd/== s (last sum-lvars)))  ;; input word sums must equal last word sum
          (== q char->lvar))))

(cryptarithmetic "send" "more" "money")

(cryptarithmetic "cp" "is" "fun" "true")

(defn pprint-answer [char->digit words]
  (let [nums (map #(apply str (map char->digit %))
                  words)
        width (apply max (map count nums))
        width-format (str "%" width "s")
        pad #(format width-format %)]
    (println
     (clojure.string/join \newline
                          (concat
                           (map #(str "+ " (pad %)) (butlast nums))
                           [(apply str (repeat (+ 2 width) \-))
                            (str "= " (pad (last nums)))]))
     \newline)))

(cryptarithmetic "wrong" "wrong" "right")
(map #(pprint-answer % ["wrong" "wrong" "right"]) *1)


