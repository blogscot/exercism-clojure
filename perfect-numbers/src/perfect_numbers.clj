(ns perfect-numbers)

(defn factors [n]
  (def candidates (range 2 (inc (quot n 2))))
  (for [x candidates :when (zero? (rem n x))] x))

(defn classify [n]
  (when (neg? n)
    (throw (IllegalArgumentException. "Invalid argument!")))
  (def sum (reduce + 1 (factors n)))
  (cond
    (= sum n) :perfect
    (> sum n) :abundant
    :else :deficient))