
;; Some notes I collected while experimenting with Clojure

(defn zip [m n] (map #(vector %1 %2) m n))
(defn zipm [m n] (map #(hash-map %1 %2) m n))

(zip '(:alice :bob :charlie) (cycle [1 2 3 4 5 6]))
;; ([:alice 1] [:bob 2] [:charlie 3])

(zipm [:a :b :c] "ABC")
;; ({:a \A} {:b \B} {:c \C})

(defn update-values [m f & args] (into {} (for [[k v] m] [k (apply f v args)])))
(def m {:a 1 :b 2 :c 3 :d 3})
(update-values m inc)
;; {:a 2, :b 3, :c 4, :d 4}
