(ns quota.persistence
  (:import java.net.URI)
  (:use korma.db))

(defn uri-to-db-spec
  [db-uri]
  (let [uri (URI. db-uri)
        port (.getPort uri)
        host (.getHost uri)
        path (.getPath uri)
        user-info (or (.getUserInfo uri) "")
        [user password] (clojure.string/split user-info #":") ]
    {:classname "org.postgresql.Driver"
     :subprotocol (.getScheme uri)
     :subname (str "//" host
                   (if (= -1 port) "" (str ":" port))
                   path)
     :user user
     :password password}))

(defdb production (uri-to-db-spec (System/getenv "DATABASE_URL")))
