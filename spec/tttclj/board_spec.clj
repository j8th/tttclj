(ns tttclj.board-spec
  (:require [speclj.core :refer :all]
            [tttclj.board :refer :all]
            [tttclj.player.token :refer [token-x token-o]]
            [tttclj.fixtures.test-boards :refer :all]))

(describe "(drop-piece)"
  (it "returns a board with the given token at the given spot."
    (should= [empty-spot empty-spot empty-spot
              token-x    empty-spot empty-spot
              empty-spot empty-spot empty-spot] (drop-piece new-board 3 token-x))))

(describe "new-board"
  (it "is a vector of nine empty spots."
    (should= [empty-spot empty-spot empty-spot
              empty-spot empty-spot empty-spot
              empty-spot empty-spot empty-spot] new-board))) 

(describe "(x-spots)"
  (it "returns the indices of the x spots"
    (should= #{0 8} (x-spots board-x-corners-o-mid))
    (should= #{3 4} (x-spots board-x-43-o-0))))

(describe "(o-spots)"
  (it "returns the indices of the o spots"
    (should= #{4} (o-spots board-x-corners-o-mid))
    (should= #{0} (o-spots board-x-43-o-0))))

(describe "(open-spots)"
  (it "returns the indices of the open spots"
    (should= #{1 2 3 5 6 7} (open-spots board-x-corners-o-mid))
    (should= #{1 2 5 6 7 8} (open-spots board-x-43-o-0))))

(describe "(board?)"
  (it "returns true for a vector of 9 elements where each element is either an x-token, an o-token, or an empty space"
    (should (board? [empty-spot token-x token-o
                     empty-spot token-x token-o
                     empty-spot empty-spot empty-spot])))

  (it "returns false if any elements are not a legal token (x-token, o-token, or empty-spot)"
    (should= false (board? [empty-spot token-x token-o
                     empty-spot token-x token-o
                     empty-spot token-x 8])))

  (it "returns false for a vector of less than 9 elements or more than 9 elements"
    (should= false (board? [empty-spot token-x token-o
                            empty-spot token-x token-o
                            empty-spot token-x]))
    (should= false (board? [empty-spot token-x token-o
                            empty-spot token-x token-o
                            empty-spot token-x empty-spot empty-spot])))

  (it "returns false for nil"
    (should= false (board? nil)))

  (it "returns true for a draw-board"
    (should= true (board? draw-board)))
)


