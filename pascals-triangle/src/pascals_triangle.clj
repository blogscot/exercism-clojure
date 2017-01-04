(ns pascals-triangle)

(defn calculate-pascal-triangle [coll]
  (->> coll (cons 0) (partition 2 1 [0]) (mapv #(reduce + %))))

(def triangle (iterate calculate-pascal-triangle [1N]))

(defn row [n] (last (take n triangle)))
