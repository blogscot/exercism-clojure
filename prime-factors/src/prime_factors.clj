(ns prime-factors)

(defn of [num]
  (loop [num num div 2 acc []]
    (cond
      (zero? (rem num div)) (recur (quot num div) div (conj acc div))
      (< num 2) acc
      :else (recur num (inc div) acc))))
