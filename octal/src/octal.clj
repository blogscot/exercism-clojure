(ns octal
  (:require [clojure.math.numeric-tower :refer [expt]]))

(defn to-decimal [tri-seq]
  (loop [octal (reverse tri-seq)
          position 0
          acc 0]
         (let [head (first octal)
               tail (rest octal)]
           (case head
             \7 (recur tail (inc position) (+ acc (* 7 (expt 8 position))))
             \6 (recur tail (inc position) (+ acc (* 6 (expt 8 position))))
             \5 (recur tail (inc position) (+ acc (* 5 (expt 8 position))))
             \4 (recur tail (inc position) (+ acc (* 4 (expt 8 position))))
             \3 (recur tail (inc position) (+ acc (* 3 (expt 8 position))))
             \2 (recur tail (inc position) (+ acc (* 2 (expt 8 position))))
             \1 (recur tail (inc position) (+ acc (* 1 (expt 8 position))))
             \0 (recur tail (inc position) acc)
             nil acc
             0))))
