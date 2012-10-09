(ns quota.board
  (:use quota.persistence)
  (:require [korma.core :as db]))

(db/defentity quotes)

(db/defentity boards
  (db/has-many quotes))

(def base
  "Basic record query for board"
  (-> (db/select* boards)
    (db/fields :name :created_at)
    (db/order :created_at)))

(defn all []
  (db/exec base))

(defn where
  "Apply lookup criteria to our base query"
  [criteria]
  (-> base (db/where criteria)))

(defn create
  "Creates a new board given an attribute map"
  [attributes]
  (let [now (java.util.Date.)
        attrs (assoc attributes :created_at now)]
    (db/insert boards
             (db/values attrs))))

(defn find-by
  [attr value]
  (db/exec (where { attr value })))

(defn find-by-id
  "Finds a board by id"
  [id]
  (first (find-by :id id)))

(defn find-by-name
  "Finds a board by name"
  [name]
  (first (find-by :name name)))
