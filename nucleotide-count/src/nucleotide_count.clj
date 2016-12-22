(ns nucleotide-count
  (:refer-clojure :exclude [count]))

(def dna-set #{\A \T \C \G})

(defn count [nucleotide strand]
  {:pre [(dna-set nucleotide)]}
  (->>
    strand
    (filter #(= % nucleotide))
    (clojure.core/count)))

(defn nucleotide-counts [strand]
  (->>
    strand
    (frequencies)
    (merge-with + (zipmap dna-set (repeat 0)))))