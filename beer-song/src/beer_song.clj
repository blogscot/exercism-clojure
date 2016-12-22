(ns beer-song
  (:require [clojure.string :as string]))

(defmulti action :line)
(defmethod action 1 [_]
  (str "Take it down and pass it around"))
(defmethod action 0 [_]
  (str "Go to the store and buy some more"))
(defmethod action :default [_]
  (str "Take one down and pass it around"))

(defmulti pluralise (fn [map] [(:number map) (:upcase map)]))
(defmethod pluralise [1 true] [_] (str "1 bottle"))
(defmethod pluralise [1 nil] [_] (str "1 bottle"))
(defmethod pluralise [0 true] [_] (str "No more bottles"))
(defmethod pluralise [0 nil] [_] (str "no more bottles"))
(defmethod pluralise [-1 nil] [_] (str "99 bottles"))
(defmethod pluralise :default [props] (str (:number props) " bottles"))

(defn verse [n]
  (str (pluralise {:number n :upcase true}) " of beer on the wall, "
       (pluralise {:number n}) " of beer.\n"
       (action {:line n}) ", " (pluralise {:number (- n 1)}) " of beer on the wall.\n"))

(defn sing
  ([start] (sing start 0))
  ([start end]
    (string/join "\n"
      (for [x (range start (dec end) -1)] (verse x)))))