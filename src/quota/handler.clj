(ns quota.handler
  (:use compojure.core)
  (:use [ring.util.json-response :only [json-response]]
        [ring.adapter.jetty :only [run-jetty]])
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [quota.quote :as quote]
            [quota.board :as board]))

(defroutes app-routes
  (GET "/" [] "Hello World")

  (GET "/boards/:id/quotes" [id]
       (if-let [board (board/find-with-quotes id)]
         (json-response (:quotes board))
         []))

  (GET "/boards/:id/quotes/random" [id]
       (if-let [board (board/find-with-quotes id)]
         (json-response (rand-nth (:quotes board)))))

  (POST "/boards/:name/quotes" [name body]
        (if-let [board (board/find-by :name name)]
          (let [attrs { :body body :boards_id (:id board) }]
            (do (quote/create attrs)
              "Well done! Maybe"))
          "No good!"))

  (POST "/boards" [name]
        (do (board/create { :name name })
            "Well done! Maybe"))

  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

(defn start [port]
    (defonce server (run-jetty (var app) {:port port :join? false})))

(defn -main []
    (let [port (Integer. (or (System/getenv "PORT") 8080))]
          (start port)))
