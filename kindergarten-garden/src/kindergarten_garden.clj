(ns kindergarten-garden
  (require [clojure.string :refer [lower-case split-lines]]))

(def children '("Alice" "Bob" "Charlie" "David" 
                "Eve" "Fred" "Ginny" "Harriet" 
                "Ileana" "Joseph" "Kincaid" "Larry"))

(def plants {\C :clover \G :grass \R :radishes \V :violets})

(defn- zipm [m n] (map #(hash-map %1 %2) m n))
(defn- update-values [m f & args] (into {} (for [[k v] m] [k (apply f v args)])))
(defn- parse [m] (update-values m (fn [string] (mapv plants string))))

(defn garden
  ([rows] (garden rows children))
  ([rows students] 
   (let [[row1 row2] (split-lines rows)
         students (map (comp keyword lower-case) (sort students))
         c (flatten (for [child students] [child child]))
         cups (apply merge-with str (concat (zipm c row1) (zipm c row2)))]
     (parse cups))))
