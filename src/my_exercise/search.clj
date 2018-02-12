(ns my-exercise.search
  (:require [hiccup.page :refer [html5]]
            [ring.util.anti-forgery :refer [anti-forgery-field]]))

(defn header [_]
  [:head
   [:meta {:charset "UTF-8"}]
   [:meta {:name "viewport"
           :content "width=device-width, initial-scale=1.0, maximum-scale=1.0"}]
   [:title "Search"]
   [:link {:rel "stylesheet" :href "default.css"}]])

(defn search-header [request]
  [:div {:class "search-header"}
   [:h1 "Search results for elections"]])

(defn display-result [request]
  (anti-forgery-field)

  ; learned the following from: https://gist.github.com/zehnpaard/665edf183818b4df707b5f0535ecdc0c
  (let [{:keys [params]} request
        param-street (get params :street)
        param-street2 (get params :street-2)
        param-city (get params :city)
        param-state (get params :state)
        param-zip (get params :zip)]
    (str
     "<div>
        <p> Showing results for " param-street " in " param-city ", " param-state " " param-zip "</p>
      </div>")))

; I'm able to get the results of the API request in my browser and Postman,
; but unfortunately can't determine how to do it in ClojureScript. I think 
; I would need to install libraries like core.async and cljs-http, but am
; not sure how to go about that.

; Thank you so much for this opportunity to do a code challenge for Democracy
; Works! My coding knowledge is currently mostly in JavaScript, and
; translating what I know in JavaScript into Clojure was fun! I will
; definitely learn more Clojure in the future.

(defn page [request]
  (html5
   (header request)
   (search-header request)
   (display-result request)))