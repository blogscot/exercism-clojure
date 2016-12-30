(ns trinary
  (:require [clojure.math.numeric-tower :refer [expt]]))

(defn to-decimal [tri-seq]
  (loop [trinary (reverse tri-seq)
          position 0
          acc 0]
         (let [head (first trinary)
               tail (rest trinary)]
           (case head
             \2 (recur tail (inc position) (+ acc (* 2 (expt 3 position))))
             \1 (recur tail (inc position) (+ acc (expt 3 position)))
             \0 (recur tail (inc position) acc)
             nil acc
             0))))
