(ns etl
  (:require [clojure.string :refer [lower-case]]))

(defn transform [input]
  (into {}
    (for [[key values] input 
           value values]
    [(lower-case value) key])))
