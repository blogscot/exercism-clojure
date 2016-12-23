(ns grade-school)

(defn add [db student grade]
  (update db grade (comp vec conj) student))

(defn grade [db grade]
  (db grade []))

(defn sorted [db]
  (->>
    db
    (map #(let [[k v] %] [k (sort v)]))
    (into (sorted-map))))
