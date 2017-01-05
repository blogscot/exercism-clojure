(ns luhn)

(defn ^:private digits [n]
  "Converts a (positive) number into a sequence of digits"
  (cond
    (zero? n) 0
    (pos? n) (->> n str (mapv #(- (int %) 48)))
    :else nil))

(defn ^:private process [index value]
  (if (even? index)
    value
    (cond 
      (>= (* 2 value) 10) (- (* 2 value ) 9)
      :else (* 2 value))))

(defn checksum [n]
  (-> 
   (->> n 
        digits 
        reverse 
        (map-indexed vector) 
        (map #(let [h (first %) t (second %)] (process h t))) 
        (apply +)) 
   (rem 10)))

(defn valid? [n] (-> n checksum zero?))

(defn add-check-digit [n]
  (letfn [(get-check-digit 
            [digit n] 
            (+ (- 10 digit) (* 10 n)))]
    (-> n (* 10) checksum (get-check-digit n))))
