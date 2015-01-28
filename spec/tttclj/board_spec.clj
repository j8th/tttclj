(ns tttclj.board-spec
  (:require [speclj.core :refer [describe it should= before-all]]
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


