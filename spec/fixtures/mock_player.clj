(ns tttclj.fixtures.mock-player
  (:require [tttclj.player.token :refer [token-x token-o]]
            [tttclj.board :refer [open-spots]]))

(defn mock-player [movelist]
  (fn move [board]
    (loop [open-spots (open-spots board)
           movelist movelist]
      (if (contains? open-spots (first movelist))
        (first movelist)
        (recur open-spots (rest movelist))))))
