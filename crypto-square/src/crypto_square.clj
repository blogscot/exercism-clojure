(ns crypto-square
  (:require [clojure.string :refer [join lower-case split]]))

(defn normalize-plaintext [text]
  (->> text
       lower-case
       (filter #(Character/isLetterOrDigit %))
       (apply str)))

(defn square-size [text]
  (-> text count Math/sqrt Math/ceil int))

(defn plaintext-segments [text]
  (let [cleaned-text (-> text normalize-plaintext)
        chunk-size (-> cleaned-text square-size)]
    (->> cleaned-text 
        (partition-all chunk-size)
        (mapv (partial apply str)))))

(defn transpose   ;; a port of Haskell transpose
  ([] [])
  ([col] 
   (if (empty? (first col))
     [] 
     (let [h (ffirst col)
           s (vec (rest (first col)))
           xss (vec (rest col))
           a (vec (conj (for [x xss] (first x)) h))
           b (vec (conj (for [x xss] (vec (rest x))) s))]
       (cons a (transpose b))))))

(defn ciphertext [text]
  (apply str 
         (let [cleaned-text (normalize-plaintext text)
               v (square-size cleaned-text)]
           (for [z (range v) [pos c] (map-indexed vector cleaned-text) 
                 :when (= z (rem pos v))] c))))

(defn normalize-ciphertext [text]
  (->> text plaintext-segments transpose (map #(join "" %)) (join " ")))

