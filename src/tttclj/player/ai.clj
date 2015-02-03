(ns tttclj.player.ai
  (:require [tttclj.board :refer [board-size open-spots drop-piece new-board]]
            [tttclj.player.token :refer [token-x token-o]]
            [tttclj.rules :refer [xturn? xwins? owins? draw? finished?]]
            [tttclj.game :refer [play-game]]
            [clojure.set :refer [intersection]]))

(defn move [board]
  (cond
    (= new-board board) 4
    (= (count (open-spots board)) 8) (apply max (intersection #{0 4} (open-spots board)))
    :else 
    (let [
          open-spots (open-spots board)
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
    choice)))

