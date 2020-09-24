(ns logical.core
  (:gen-class))

(require '[clojure.core.logic :as logic]
         '[clojure.core.logic.fd :as fd])


(defn -main
  "miniKanren example"
  [& args]
  (println "miniKanren"))

(logic/run* [q] (== q 1))
