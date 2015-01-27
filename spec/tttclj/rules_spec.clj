(ns tttclj.rules-spec
  (:require [speclj.core :refer :all]
            [tttclj.rules :refer :all]
            [tttclj.fixtures.test-boards :refer :all]))

(describe "(xwins?)"
  (it "returns true when x wins"
    (should= true (xwins? board-x-wins)))

  (it "returns false for a board x has not won"
    (should= false (xwins? empty-board)))
)
