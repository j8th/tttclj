(ns tttclj.player.ai-spec
  (:require [speclj.core :refer :all]
            [tttclj.player.ai :refer :all]
            [tttclj.board :refer :all]))

(describe "(move)"
  (it "returns an integer between 0 and 8"
    (should (< 0 (move (new-board)) 8))))
