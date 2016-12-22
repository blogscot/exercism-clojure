(ns rna-transcription)

(defn to-rna
  [dna]
  {:pre [(re-matches #"^[ACTG]+$" dna)]}

  (def translate {\A \U, \C \G, \T \A, \G \C})

  (->> dna
       (seq)
       (map translate)
       (apply str))
)
