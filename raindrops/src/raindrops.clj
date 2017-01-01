(ns raindrops)

(defn convert [num]
  (let [s (str
           (when (zero? (rem num 3)) "Pling")
           (when (zero? (rem num 5)) "Plang")
           (when (zero? (rem num 7)) "Plong"))]
    (if (empty? s)
      (str num)
      s)))
