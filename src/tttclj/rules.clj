(ns tttclj.rules
  (:require [tttclj.player.token :refer [token-x token-o]]
            [clojure.set :refer [subset?]]))

(let [winning-combinations [#{0 1 2}
                            #{3 4 5}
                            #{6 7 8}
                            #{0 3 6}
                            #{1 4 7}
                            #{2 5 8}
                            #{0 4 8}
                            #{6 4 2}]
      get-token-indices (fn [board, token] 
                     (map first 
                       (filter #(= (second %) token)
                         (map-indexed vector board))))

      x-spots (fn [board] 
                    (set (get-token-indices board token-x)))
      ]

  (defn xwins? [board]
    (if (empty? (filter #(subset? % (x-spots board)) winning-combinations))
      false
      true))

)
