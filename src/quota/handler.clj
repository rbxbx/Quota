(ns quota.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [quota.quote :as quote]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (POST "/quotes" [body]
        (do (quote/create { :body body })
            "Well done! Maybe"))
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
