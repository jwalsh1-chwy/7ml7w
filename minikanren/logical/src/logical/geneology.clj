(ns logical.geneology
  (:require [clojure.string :as s]
            [clojure.set]
            [clojure.core.logic.pldb]
            [clojure.core.logic :refer :all]
            [clojure.core.logic.fd :as fd]))

(defn -main
  [& args]
  (println "Geneology"))

;; todo
(defn whicho [x s1 s2 r]
  (conde
   [(membero x s1)
    (== r :one)]
   [(membero x s2)
    (== r :two)]
   [(membero x s1)
    (membero x s2)
    (== r :both)]))

(run 1 (whicho :a [:a :b :c] [:d :e :f] q))
