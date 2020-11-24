(defproject logical "0.1.0-SNAPSHOT"
  :description "miniKanren"
  :url "http://wal.sh/"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/core.logic "1.0.0"]]
  :main ^:skip-aot logical.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
  