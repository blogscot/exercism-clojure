(ns leap)

(defn leap-year? [year]
  (and
    (zero? (rem year 4))
    (or
      (not= (rem year 100) 0)
      (zero? (rem year 400)))))