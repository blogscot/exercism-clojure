(ns bank-account)

(defn open-account [] (atom 0))

(defn get-balance [account] @account)

(defn update-balance [account value]
  (swap! account #(+ % value)))

(defn close-account [account] (reset! account nil))
