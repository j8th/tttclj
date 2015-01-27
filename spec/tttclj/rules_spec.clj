(ns tttclj.rules-spec
  (:require [speclj.core :refer :all]
            [tttclj.rules :refer :all]
            [tttclj.fixtures.test-boards :refer :all]))

(describe "(xwins?)"
  (it "returns true when x wins"
    (should= true (xwins? board-x-wins)))

  (it "returns false for an empty board"
    (should= false (xwins? empty-board)))

  (it "returns false for a board o has won"
    (should= false (xwins? board-o-wins)))

  (it "returns false for an unfinished board"
    (should= false (xwins? board-x-corners-o-mid)))

  (it "returns false for a draw board"
    (should= false (xwins? draw-board)))
)

(describe "(owins?)"
  (it "returns true when o wins"
    (should= true (owins? board-o-wins)))

  (it "returns false for an empty board"
    (should= false (owins? empty-board)))

  (it "returns false for a board x has won"
    (should= false (owins? board-x-wins)))

  (it "returns false for an unfinished board"
    (should= false (owins? board-x-corners-o-mid)))

  (it "returns false for a draw board"
    (should= false (owins? draw-board)))
)

(describe "(unfinished?)"
  (it "returns true for an unfinished board"
    (should= true (unfinished? board-x-corners-o-mid)))

  (it "returns true for an empty board"
    (should= true (unfinished? empty-board)))

  (it "returns false for a draw board"
    (should= false (unfinished? draw-board)))

  (it "returns false when x wins"
    (should= false (unfinished? board-x-wins)))

  (it "returns false for a board o has won"
    (should= false (unfinished? board-o-wins)))
)

(describe "(draw?)"
  (it "returns true for a draw board"
    (should= true (draw? draw-board)))

  (it "returns false when x wins"
    (should= false (draw? board-x-wins)))

  (it "returns false for an empty board"
    (should= false (draw? empty-board)))

  (it "returns false for a board o has won"
    (should= false (draw? board-o-wins)))

  (it "returns false for an unfinished board"
    (should= false (draw? board-x-corners-o-mid)))
)
