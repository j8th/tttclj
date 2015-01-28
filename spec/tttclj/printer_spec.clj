(ns tttclj.printer-spec
  (:require [speclj.core :refer :all]
            [tttclj.printer :refer :all]
            [tttclj.board :refer [new-board]]
            [tttclj.fixtures.test-boards :refer :all]))

(describe "(print-board)"
  (it "prints an empty board"
    (should= (str " 0 | 1 | 2 \n"
                  "-----------\n"
                  " 3 | 4 | 5 \n"
                  "-----------\n"
                  " 6 | 7 | 8 \n") (with-out-str (print-board new-board))))

  (it "prints a non-empty board"
    (should= (str " X | 1 | 2 \n"
                  "-----------\n"
                  " 3 | O | 5 \n"
                  "-----------\n"
                  " 6 | 7 | X \n") (with-out-str (print-board board-x-corners-o-mid))))
)
