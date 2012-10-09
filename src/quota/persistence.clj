(ns quota.persistence
  (:use korma.db))

(defdb development { :db "quota_development.db"
                     :classname "org.sqlite.JDBC"
                     :subprotocol "sqlite"
                     :subname "quota_development.db"
                     :username "root"
                     :password "" })
