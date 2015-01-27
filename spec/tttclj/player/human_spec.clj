(ns tttclj.player.human-spec
  (:require [speclj.core :refer :all]
            [tttclj.player.human :refer :all]
            [tttclj.board :refer :all]))

(describe "(move)"
  (it "returns an integer that fits on the board"
    (should (< 0 (move new-board) (- size 1)))))
