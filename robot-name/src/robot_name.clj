(ns robot-name)

(def letters (map char (range (int \A) (inc (int \Z)))))

(defn generate-numbers [n]
  (apply str (take n (repeatedly #(rand-int 10)))))

(defn generate-letters [n]
  (apply str (take n (repeatedly #(rand-nth letters)))))

(defn generate-name []
  (str (generate-letters 2) (generate-numbers 3)))

(defn robot []
  (atom (generate-name)))

(defn robot-name [machine]
  (deref machine))

(defn reset-name [machine]
  (swap! machine (fn [_] (generate-name))))