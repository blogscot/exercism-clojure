(ns space-age)

(def year-on-earth 31557600)

(defn on-earth   [seconds] (/ seconds year-on-earth))
(defn on-mercury [seconds] (/ seconds year-on-earth 0.2408467))
(defn on-venus   [seconds] (/ seconds year-on-earth 0.61519726))
(defn on-mars    [seconds] (/ seconds year-on-earth 1.8808158))
(defn on-jupiter [seconds] (/ seconds year-on-earth 11.862615))
(defn on-saturn  [seconds] (/ seconds year-on-earth 29.447498))
(defn on-uranus  [seconds] (/ seconds year-on-earth 84.016846))
(defn on-neptune [seconds] (/ seconds year-on-earth 164.79132))
