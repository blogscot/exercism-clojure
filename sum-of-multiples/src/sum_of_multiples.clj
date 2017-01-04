(ns sum-of-multiples)

(defn sum-of-multiples [factors, limit]
  (def multiples (for [x (range 1 limit) y factors 
                       :when (zero? (rem x y))] x))
  (apply + (set multiples))
)
