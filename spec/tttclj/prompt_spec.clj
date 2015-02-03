(ns tttclj.prompt-spec
  (:require [speclj.core :refer :all]
            [tttclj.prompt :refer :all]))



(describe "(prompt)"
  (around [it]
    (with-out-str (it)))

  (it "prompts the user with the provided message"
    (should= "Enter a choice please.\n" (with-out-str (with-in-str "X" (prompt "Enter a choice please." #{"X" "O"})))))

  (it "returns one of the choices from user input"
    (should= "X" (with-in-str "X" (prompt "blah" #{"X" "O"}))))

  (it "prompts until the user enters a valid choice"
    (should= "X" (with-in-str "MY\nTEST\nHI\nX\nNO\n" (prompt "blah" #{"X" "O"}))))
  )
