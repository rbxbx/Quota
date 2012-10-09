(ns quota.quote
  (:use quota.persistence)
  (:require [korma.core :as db]))

(db/defentity quotes)

(def base
  "Basic record query for quotes"
  (-> (db/select* quotes)
    (db/fields :body :created_at)
    (db/order :created_at)))

(defn all []
  (db/exec base))

(defn where
  "Apply lookup criteria to our base query"
  [criteria]
  (-> base (db/where criteria)))

(defn find-by-id
  "Finds a quote by id"
  [id]
  (first (db/exec (where { :id id }))))

(defn create
  "Creates a new entry given an attribute map"
  [attributes]
  (let [now (java.util.Date.)
        attrs (assoc attributes :created_at now)]
    (db/insert quotes
             (db/values attrs))))
