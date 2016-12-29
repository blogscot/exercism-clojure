(ns meetup
  (:import (java.util Calendar)))

(defn meetup
  [month year day schedule]
  (let [weekdays [:sunday :monday :tuesday :wednesday :thursday :friday :saturday]
        calendar (Calendar/getInstance)]
    (.set calendar year (dec month) 1)
    (def last-day (.getActualMaximum calendar (Calendar/DAY_OF_MONTH)))
    (def day-of-week (.get calendar (Calendar/DAY_OF_WEEK)))

    ;; build list of weekdays (:monday, :tuesday, etc.) for each month day
    (def month-days 
      (let [dow (dec day-of-week)] 
        (drop dow (take (+ last-day dow) (cycle weekdays)))))
    (def with-index (zipmap (range 1 32) month-days))
    ;; get specified days
    (def filtered (filter (fn [[k v]] (= day v)) with-index))
    (def days (sort (keys filtered)))
    (def result (case schedule
       :first (first days)
       :second (second days)
       :third (nth days 2)
       :fourth (nth days 3)
       :last (last days)
       :teenth (first (filter (fn [x] (and (> x 12) (< x 20))) days))))
    [year month result]
))
