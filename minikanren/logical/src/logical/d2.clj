(ns logical.d2
  (:require [clojure.string :as s]
            [clojure.set]
            [clojure.core.logic.pldb]
            [clojure.core.logic :refer :all]
            [clojure.core.logic.fd :as fd]))

(defn -main
  "Day 2"
  [& args]
  (println "Petstore"))

;; (defn insideo [e l]
;;   (conde
;;    [(fresh [h t]
;;       (conso h t l)
;;       ((== h e)))]
;;    [(fresh [h t]
;;       (conso h t l)
;;       (insideo e t))]))

(defn insideo [e l]
  (matche [l]
          ([[e . _]])
          ([[_ . t]] (insideo e t))))

(run 1 [q]
  (insideo [:a :b :c]))

(defne insideo [e l]
  ([_ [e . _]])
  ([_ [_ . t]] (insideo e t)))

(run* [q]
  (fresh [m]
    (== m {:a 1 :b 2})
    (matche [m]
            ([{:a 1}] (== :found-a q))
            ([{:b 2}] (== :found-b q))
            ([{:a 1 :b 2}] (== :found-both q)))))
