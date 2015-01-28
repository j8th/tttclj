(ns tttclj.player.ai-spec
  (:require [speclj.core :refer :all]
            [tttclj.player.ai :refer :all]
            [tttclj.board :refer :all]
            [tttclj.fixtures.test-boards :refer :all]))

(describe "(move)"
  (it "returns an integer that fits on the board"
    (should (< -1 (move new-board) board-size)))

  (it "returns a random integer"
    (should= (set (range 0 board-size)) (set (take 1000 (repeatedly #(move new-board))))))

  (it "returns an integer for an open spot on the board"
    (should= #{1 2 3 5 6 7} (set (take 1000 (repeatedly #(move board-x-corners-o-mid))))))
)
