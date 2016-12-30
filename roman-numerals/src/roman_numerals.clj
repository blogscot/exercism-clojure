(ns roman-numerals)

(def roman-numerals [[1000 "M"] [900 "CM"] [500 "D"] [400 "CD"] [100 "C"]
                     [90 "XC"] [50 "L"] [40 "XL"] [10 "X"] [9 "IX"] [5 "V"] 
                     [4 "IV"] [1 "I"]])

(defn do-numerals [number numerals current]
  (let [[arabic roman] (first numerals)
        tail (rest numerals)]
    (cond
      (>= number arabic) (do-numerals (- number arabic) numerals (str current roman))
      :else (cond
              (< number 1) current
              :else (do-numerals number tail current)))))

(defn numerals [number]
  (do-numerals number roman-numerals ""))
