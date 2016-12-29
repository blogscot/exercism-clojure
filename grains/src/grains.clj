(ns grains
  (:require [clojure.math.numeric-tower :as math]))

(defn square [x] (math/expt 2 (dec x)))
(defn total [] 
  (reduce + (for [x (range 1 65)] (square x))))
