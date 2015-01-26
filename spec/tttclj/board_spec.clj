(ns tttclj.board-spec
  (:require [speclj.core :refer [describe it should= before-all]]
            [tttclj.board :refer :all]))

(let [token-x "X"
      token-o "O"
      empty-spot "."
      empty-board [empty-spot empty-spot empty-spot
                   empty-spot empty-spot empty-spot
                   empty-spot empty-spot empty-spot]]


  (describe "(drop-piece)"
    (it "returns a board with the given token at the given spot."
      (should= [empty-spot empty-spot empty-spot
                token-x    empty-spot empty-spot
                empty-spot empty-spot empty-spot] (drop-piece empty-board 3 token-x)))))




