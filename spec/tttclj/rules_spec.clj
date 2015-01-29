(ns tttclj.rules-spec
  (:require [speclj.core :refer :all]
            [tttclj.rules :refer :all]
            [tttclj.board :refer [new-board]]
            [tttclj.fixtures.test-boards :refer :all]))

(describe "(xwins?)"
  (it "returns true when x wins"
    (should= true (xwins? board-x-wins)))

  (it "returns false for an empty board"
    (should= false (xwins? new-board)))

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
    (should= false (owins? new-board)))

  (it "returns false for a board x has won"
    (should= false (owins? board-x-wins)))

  (it "returns false for an unfinished board"
    (should= false (owins? board-x-corners-o-mid)))

  (it "returns false for a draw board"
    (should= false (owins? draw-board)))
)

(describe "(finished?)"
  (it "returns false for an unfinished board"
    (should= false (finished? board-x-corners-o-mid)))

  (it "returns false for an empty board"
    (should= false (finished? new-board)))

  (it "returns true for a draw board"
    (should= true (finished? draw-board)))

  (it "returns true when x wins"
    (should= true (finished? board-x-wins)))

  (it "returns true for a board o has won"
    (should= true (finished? board-o-wins)))
)

(describe "(draw?)"
  (it "returns true for a draw board"
    (should= true (draw? draw-board)))

  (it "returns false when x wins"
    (should= false (draw? board-x-wins)))

  (it "returns false for an empty board"
    (should= false (draw? new-board)))

  (it "returns false for a board o has won"
    (should= false (draw? board-o-wins)))

  (it "returns false for an unfinished board"
    (should= false (draw? board-x-corners-o-mid)))
)

(describe "(xturn?)"
  (it "returns true if it is x's turn"
   (should= true (xturn? board-x-0-o-4)))

  (it "returns false if it is o's turn"
    (should= false (xturn? board-x-corners-o-mid)))

  (it "returns true for a new board"
    (should= true (xturn? new-board)))

  (it "returns false for a game that is over"
    (should= false (xturn? board-o-wins)))
)
