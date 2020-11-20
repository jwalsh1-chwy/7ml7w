(ns logical.reasoned-schemer
  (:require [clojure.string :as s]
            [clojure.set]
            [clojure.core.logic.pldb]
            [clojure.core.logic :refer :all]
            [clojure.core.logic.fd :as fd]))

(defn -main
  "Petstore example"
  [& args]
  (println "The Reasoned Schemer"))


;; ((1. Playthings))
true

(run* [q]
  (== true q))

;; todo: validate succeed
;; (run 1 [q]
;;   (succeed q)
;;   (== q true))



;; ((2. Teaching Old Toys New Tricks))

;; ((3. Seeing Old Friends in New Ways))

;; ((4. Members Only))

;; ((5. Double Your Fun))

;; ((6. The Fun Never Ends...))

;; ((7. A Bit Too Much))

;; ((8. Just a Bit More))

;; ((9. Under the Hood))

;; ((10. Thin Ice))
