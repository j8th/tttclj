(ns tttclj.board
  (:require [tttclj.player.token :refer [token-x token-o]]))

(let [
      get-token-indices (fn [board, token] 
        (map first 
          (filter #(= (second %) token)
            (map-indexed vector board))))
     ]

  (def empty-spot ".")
  (def board-size 9)
  (def new-board [empty-spot empty-spot empty-spot
                  empty-spot empty-spot empty-spot
                  empty-spot empty-spot empty-spot])

  (defn drop-piece [board spot token]
    (assoc board spot token))

  (defn x-spots [board] 
    (set (get-token-indices board token-x)))

  (defn o-spots [board] 
    (set (get-token-indices board token-o)))

  (defn open-spots [board]
    (set (get-token-indices board empty-spot)))

)
