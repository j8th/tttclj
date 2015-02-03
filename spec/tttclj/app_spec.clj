(ns tttclj.app-spec
  (:require [speclj.core :refer :all]
            [tttclj.app :refer :all]
            [tttclj.player.ai :refer [move]]))



(describe "(app)"
  (around [it]
    (with-out-str (it)))

  (let [counter (atom 0)
        play-again-fn #(<= (swap! counter inc) 3)]
    (it "plays games until the play-again-fn returns false and returns the total number of games played"
      (should= 4 (app [move move] play-again-fn))))

  (it "prints the winner of the games"
    (should-contain "Draw Game." (with-out-str (app [move move] #(= 0 1)))))
)
