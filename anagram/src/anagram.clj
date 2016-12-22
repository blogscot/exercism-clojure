(ns anagram
  (:require [clojure.string :refer [lower-case]]))

(defn same-chars
  [word1 word2]
  (=
    (-> word1 (lower-case) (sort))
    (-> word2 (lower-case) (sort))))

(defn same-words
  [word1 word2]
  (= (lower-case word1) (lower-case word2)))

(defn anagrams-for
  [word, candidates]
  (->> candidates
    (filter (partial same-chars word))
    (remove (partial same-words word)))
)
