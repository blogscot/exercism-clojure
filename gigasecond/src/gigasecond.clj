(ns gigasecond
  (import [java.util Calendar]))

(defn from [year month day]
  (def new-calendar 
    (doto (Calendar/getInstance)
      (.set year (dec month) day)
      (.add (Calendar/SECOND) 1000000000)))

  (def new-year  (.get new-calendar (Calendar/YEAR)))
  (def new-month (.get new-calendar (Calendar/MONTH)))
  (def new-day   (.get new-calendar (Calendar/DAY_OF_MONTH)))
  [new-year (inc new-month) new-day]
)
