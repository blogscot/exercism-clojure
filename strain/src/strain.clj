(ns strain)

(defn retain [f coll]
  (loop [coll coll acc []]
    (let [head (first coll)
          tail (rest coll)]
      (cond
        (empty? (seq coll)) acc
        (f head) (recur tail (conj acc head))
        :else (recur tail acc)))))

(defn discard [f coll]
  (retain (complement f) coll))

