(ns meetup
  (:import (java.util Calendar)))

(defn- get-day 
      [schedule days] 
      (case schedule
        :first (first days)
        :second (second days)
        :third (nth days 2)
        :fourth (nth days 3)
        :last (last days)
        :teenth (first (filter #(and (> % 12) (< % 20)) days))))

(defn meetup
  [month year day schedule]
  (let [weekdays [:sunday :monday :tuesday :wednesday :thursday :friday :saturday]
        calendar (Calendar/getInstance)]
    (.set calendar year (dec month) 1)
    (def last-day (.getActualMaximum calendar (Calendar/DAY_OF_MONTH)))
    (def day-of-week (-> calendar (.get (Calendar/DAY_OF_WEEK)) (dec) ))

    ;; rotate the list of weekdays (:monday, :tuesday, etc.) so that 
    ;; the weekday falls on the correct date (e.g. 1 = :thursday etc.).
    (def month-days  
      (drop day-of-week (take (+ last-day day-of-week) (cycle weekdays))))

    (->> 
     month-days 
     (zipmap (range 1 32))
     (filter (fn [[_ v]] (= day v)))
     (keys)
     (sort)
     (get-day schedule)
     ((fn [x] [year month x])))))
