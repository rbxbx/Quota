(defproject quota "0.1.0-SNAPSHOT"
  :description "An Online Quoteboard"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [ring-json-response "0.2.0" :exclusions [ring/ring-core]]
                 [ring/ring-jetty-adapter "1.1.5"]
                 [korma "0.3.0-beta9"]
                 [postgresql/postgresql "8.4-702.jdbc4"]
                 [compojure "1.1.1"]]
  :plugins [[lein-ring "0.7.3"]]
  :ring {:handler quota.handler/app}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.3"]]}}
  :main quota.handler)
