(ns binary-search)

(defn middle [coll]
  (->
    coll
    (count)
    (quot 2)))

(defn search-for [value coll]
  (let [middle (middle coll)
        current-value (nth coll middle)]
  (cond
    (= current-value value) middle
    (or (= middle (count coll)) (zero? middle))
      (throw (Exception. (format "%s not found." value)))
    (< current-value value) (+ middle (search-for value (drop middle coll)))
    (> current-value value) (search-for value (take middle coll)))))
