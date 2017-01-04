(ns sieve
  (require [clojure.set :refer [difference]]))

(defn sieve [n]
  (let [upper-bound (-> n Math/sqrt Math/ceil int)
        factors (range 2 upper-bound)
        limit (inc n)]
    (loop [factors factors acc (set (range 2 limit))]
      (if (empty? factors)
        (-> acc sort vec)
        (let [head (first factors)
              multiples (set (range head limit head))
              primes (difference multiples (set [head]))]
          (recur (rest factors) (difference acc primes)))))))
