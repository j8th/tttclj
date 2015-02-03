(ns tttclj.prompt-spec
  (:require [speclj.core :refer :all]
            [tttclj.prompt :refer :all]
            [tttclj.player.human :as human]
            [tttclj.player.ai :as ai]))



(describe "(prompt)"
  (around [it]
    (with-out-str (it)))

  (it "prompts the user with the provided message"
    (should= "Enter a choice please.\n" (with-out-str (with-in-str "X" (prompt "Enter a choice please." #{"X" "O"})))))

  (it "returns one of the choices from user input"
    (should= "X" (with-in-str "X" (prompt "blah" #{"X" "O"}))))

  (it "prompts until the user enters a valid choice"
    (should= "X" (with-in-str "MY\nTEST\nHI\nX\nNO\n" (prompt "blah" #{"X" "O"}))))

  (it "works with a vector of choices"
    (should= "O" (with-in-str "O\n" (prompt "blah" ["X" "O"]))))
)

(describe "(set-players)"
  (around [it]
    (with-out-str (it)))

  (it "asks the player to choose between X or O"
    (should-contain "Will you be X or O?" (with-out-str (with-in-str "X" (set-players)))))

  (it "returns [human/(move) ai/(move)] when the player chooses to be X"
    (should= [human/move ai/move] (with-in-str "X" (set-players))))

  (it "returns [ai/(move) human/(move)] when the player chooses to be O"
    (should= [ai/move human/move] (with-in-str "O" (set-players))))
)
