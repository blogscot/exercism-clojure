(ns atbash-cipher
  (:require [clojure.string :refer [join lower-case]]))

(def alphabet "abcdefghijklmnopqrstuvwxyz")
(def reverse-alphabet (reverse alphabet))
(def cipher (zipmap alphabet reverse-alphabet))

(defn encode [text]
  (->> text
      lower-case
      (filter #(Character/isLetterOrDigit %))
      (map #(cipher % %))   ;; digits pass through as default values
      (partition-all 5)
      (map (partial apply str))
      (join " ")))
