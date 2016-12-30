(ns triangle
  (:refer-clojure :exclude [type]))

(defn type [a b c]
  (let [[x y z] (sort [a b c])]
    (cond
      (= x y z) :equilateral
      (<= (+ x y) z) :illogical
      (or (= x y) (= y z)) :isosceles
      :else :scalene)))
