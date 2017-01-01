(ns prime-factors)

(defn do-of [num current acc]
  (cond
    (= num 1) []
    (= 1 (/ num current)) (vec (conj acc current))
    (zero? (rem num current)) (recur (quot num current) current (conj acc current))
    :else (recur num (inc current) acc)))

(defn of [num]
  (do-of num 2 []))

(of 1)
