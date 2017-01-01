(ns raindrops
  (:require [clojure.string :refer [join]]))

(defn- my-quot [num div]
  (cond
    (zero? (rem num div)) (recur (quot num div) div)
    :else num))

(defn convert [num]
  (loop [num num acc ()]
    (cond
      (zero? (rem num 7)) (recur (my-quot num 7) (conj acc "Plong"))
      (zero? (rem num 5)) (recur (my-quot num 5) (conj acc "Plang"))
      (zero? (rem num 3)) (recur (my-quot num 3) (conj acc "Pling"))
      (empty? acc) (str num)
      :else (join "" acc))))
