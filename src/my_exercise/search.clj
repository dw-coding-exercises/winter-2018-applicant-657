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

(defn page [request]
  (html5
   (header request)
   (search-header request)
   (display-result request)))