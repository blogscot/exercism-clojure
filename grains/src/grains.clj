(ns grains
  (:require [clojure.math.numeric-tower :as math]))

(defn square [x] (math/expt 2 (dec x)))
(defn total [] 
  (reduce + (map square (range 1 65))))
