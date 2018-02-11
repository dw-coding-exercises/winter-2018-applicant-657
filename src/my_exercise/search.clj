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
   [:h1 "Search results for elections"]
   [:p "You are in "]])

(defn display-result [request]
  (anti-forgery-field)

  ; learned the following from: https://gist.github.com/zehnpaard/665edf183818b4df707b5f0535ecdc0c
  (let [{:keys [params uri]} request
        param-name (get params "name")
        request-type (if (= uri "/get-submit") "GET" "POST")]
    (str
     "<div>
        <h1>Hello " param-name "!</h1>
        <p>Submitted via a " request-type " request.</p>
        <p><a href='..'>Return to main page</p>
      </div>")))

(defn page [request]
  (html5
   (header request)
   (search-header request)
   (display-result request)))