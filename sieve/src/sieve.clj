(ns sieve)

(defn sieve [n]
  (loop [primes [] all-numbers (take (dec n) (iterate inc 2))]
    (if (empty? all-numbers)
      primes
      (recur (conj primes (first all-numbers)) 
             (remove #(zero? (mod % (first all-numbers))) all-numbers)))))
