(ns tttclj.game
  (:require [tttclj.rules :refer [xwins? owins? draw? xturn?]]
            [tttclj.board :refer [board? drop-piece]]
            [tttclj.player.token :refer [token-x token-o]]))

(defn play-game [board player-x player-o]
  {:pre [(board? board) (fn? player-x) (fn? player-o)]
   :post [(board? %)]}
  (if (or (xwins? board) (owins? board) (draw? board))
    board
    (let [player (if (xturn? board) player-x player-o)
          token (if (xturn? board) token-x token-o)]
      (play-game (drop-piece board (player board) token) player-x player-o))))
