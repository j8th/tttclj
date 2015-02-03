(ns tttclj.player.ai
  (:require [tttclj.board :refer [board-size open-spots drop-piece]]
            [tttclj.player.token :refer [token-x token-o]]
            [tttclj.rules :refer [xturn? xwins? owins? draw? finished?]]
            [tttclj.game :refer [play-game]]))

(defn move [board]
  (let [open-spots (open-spots board)
        token (if (xturn? board) token-x token-o)
        score-board (fn [board]
                     (let [final-board (play-game board move move)]
                       (cond
                         (xwins? final-board) 1
                         (draw? final-board) 0
                         (owins? final-board) -1)))
        moves (zipmap open-spots (map #(score-board (drop-piece board % token)) open-spots))
        maxormin (if (= token token-x) max-key min-key)
        choice (key (apply maxormin val moves))]
  choice))

