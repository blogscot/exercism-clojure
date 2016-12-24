(ns flatten-array
  (:refer-clojure :exclude [flatten]))

(defn flatten [x]
  (->>
    x
    (tree-seq sequential? seq)
    (filter (complement sequential?))
    (remove nil?)))