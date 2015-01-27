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

      o-spots (fn [board] 
                    (set (get-token-indices board token-o)))

      contains-winning-combination? (fn [set-of-tokens]
                                      (not (empty? (filter #(subset? % set-of-tokens) winning-combinations))))
      ]

  (defn xwins? [board]
    (if (contains-winning-combination? (x-spots board))
      true 
      false))

  (defn owins? [board]
    (if (contains-winning-combination? (o-spots board))
      true
      false))

)
