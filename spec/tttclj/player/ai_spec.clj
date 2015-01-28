(ns tttclj.player.ai-spec
  (:require [speclj.core :refer :all]
            [tttclj.player.ai :refer :all]
            [tttclj.board :refer :all]))

(describe "(move)"
  (it "returns an integer that fits on the board"
    (should (< 0 (move new-board) board-size)))

  (it "returns a random integer"
    (should= (set (range 0 board-size)) (set (take 1000 (repeatedly #(move new-board))))))
)
