(ns prime-factors)

(defn of [num]
  (loop [num num current 2 acc []]
    (cond
      (= num 1) []
      (= 1 (/ num current)) (vec (conj acc current))
      (zero? (rem num current)) (recur (quot num current) current (conj acc current))
      :else (recur num (inc current) acc))))
