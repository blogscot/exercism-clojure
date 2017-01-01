(ns allergies)

(def all-allergies {:eggs 1 :peanuts 2 :shellfish 4 :strawberries 8
                    :tomatoes 16 :chocolate 32 :pollen 64 :cats 128})

(defn allergies [num]
  (vec (for [[k v] all-allergies :when (pos? (bit-and num v))] k)))

(defn allergic-to? [num item]
  (pos? (bit-and num (all-allergies item))))
