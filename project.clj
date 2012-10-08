(defproject quota "0.1.0-SNAPSHOT"
  :description "An Online Quoteboard"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [com.datomic/datomic-free "0.8.3511"]
                 [compojure "1.1.1"]]
  :plugins [[lein-ring "0.7.3"]]
  :ring {:handler quota.handler/app}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.3"]]}})
