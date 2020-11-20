(ns logical.coderead
  (:require [clojure.string :as s]
            [clojure.set]
            [clojure.core.logic.pldb]
            [clojure.core.logic :refer :all]
            [clojure.core.logic.fd :as fd]))

;; http://mullr.github.io/micrologic/literate.html
(defn -main
  [& args]
  (println "Review the implementation"))


;; These already exist in the core namespace
;; LVar just has an id for the walk
(defrecord JVar [id])
(defn jvar [id] (JVar. id))
(defn jvar? [x] (instance? JVar x))

(def s (jvar 2))
(jvar? s)

(def sm {
         (jvar 0) (jvar 1)
         (jvar 1) :a
         })

;;
(defn jadd-substitution [s-map lvar value]
  (when s-map
    (assoc s-map lvar value)))

(jadd-substitution sm (jvar 3) "j")


;; (extend-protocol IWalk
;;   JVar
;;   (walk [u s-map] (if-let [val (get s-map u)]
;;                     (recur val s-map)
;;                     u))
;;   Object
;;   (walk [u s-map] u)
;;   nil
;;   (walk [u s-map] nil))
