(ns kindergarten-garden
  (require [clojure.string :refer [lower-case split]]))

(def children '("alice" "bob" "charlie" "david" 
                "eve" "fred" "ginny" "harriet" 
                "ileana" "joseph" "kincaid" "larry"))

(def flowers {\C :clover \G :grass \R :radishes \V :violets})

(defn- zipm [m n] (map #(hash-map %1 %2) m n))
(defn- update-values [m f & args] (into {} (for [[k v] m] [k (apply f v args)])))
(defn- parse [m] (update-values m (fn [string] (mapv flowers string))))
(defn- to-keyword [s] (if (keyword? s) s (keyword s)))

(defn garden
  ([rows] (garden rows children))
  ([rows students] 
   (let [[row1 row2] (split rows #"\n")
         students (map (comp to-keyword lower-case) (sort students))
         c (flatten (for [child students] [child child]))
         groups (apply merge-with str (concat (zipm c row1) (zipm c row2)))]
     (parse groups))))
