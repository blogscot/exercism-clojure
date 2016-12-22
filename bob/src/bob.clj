(ns bob
  (:require [clojure.string :as str]))

(defn- is-shouting?
  [words]
  (and
    (= (str/upper-case words) words)
    (not= (str/lower-case words) words)))

(defn- is-question?
  [words]
  (str/ends-with? words "?"))

(defn response-for
  [input]
  (cond
    (is-shouting? input) "Whoa, chill out!"
    (is-question? input) "Sure."
    (str/blank? input) "Fine. Be that way!"
    :else "Whatever."))
