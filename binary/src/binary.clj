(ns binary)

(defn to-decimal [bin-seq]
  (loop [binary (reverse bin-seq)
          position 0
          acc 0]
         (let [head (first binary)
               tail (rest binary)]
           (case head
             \1 (recur tail (inc position) (+ acc (bit-shift-left 1 position)))
             \0 (recur tail (inc position) acc)
             nil acc
             0))))
