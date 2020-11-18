(ns logical.petstore
  (:require [clojure.string :as s]
            [clojure.set]
            [clojure.core.logic.pldb]
            [clojure.core.logic :refer :all]
            [clojure.core.logic.fd :as fd]))

(defn -main
  "Petstore example"
  [& args]
  (println "Petstore"))
