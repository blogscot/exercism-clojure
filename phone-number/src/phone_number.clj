(ns phone-number
  (:require [clojure.string :as string]))

(def invalid-number "0000000000")

(defn number [text]
  (def cleaned (string/join (re-seq #"\d+" text)))
  (case (count cleaned)
    9 invalid-number
    10 cleaned
    11 (if (string/starts-with? cleaned "1")
        (apply str (next cleaned))
        invalid-number)))

(defn area-code [text]
  (-> text (number) (subs 0 3)))

(defn pretty-print [text]
  (def phone (number text))
  (str "(" (subs phone 0 3) ") " (subs phone 3 6) "-" (subs phone 6)))
