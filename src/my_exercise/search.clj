(ns my-exercise.search
  (:require [hiccup.page :refer [html5]]
            [ring.util.anti-forgery :refer [anti-forgery-field]]))

(defn header [_]
  [:head
   [:meta {:charset "UTF-8"}]
   [:meta {:name "viewport"
           :content "width=device-width, initial-scale=1.0, maximum-scale=1.0"}]
   [:title "I am a search page!"]
   [:link {:rel "stylesheet" :href "default.css"}]])

(defn instructions [request]
  [:div {:class "instructions"}
   [:h2 "Current elections"]])

(defn page [request]
  (html5
   (header request)
   (instructions request)))