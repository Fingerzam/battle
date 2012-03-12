(ns battle.test.fight
  (:use midje.sweet
        battle.fight
        battle.test.helpers))

(let [me      (make-player :name "irmeli" :location [0 0])
      monster-next-to-me (make-monster :name "goblin" :location [0 1])
      monster-far-away (make-monster :name "demogorgon" :location [666 0])]

  (facts
    (less-hp-after-action hit me monster-next-to-me) => true
    (less-hp-after-action hit me monster-far-away) => false)

  (facts
    (can-hit me monster-next-to-me) => true
    (can-hit me monster-far-away) => false)

  (facts "distance"
    (distance me monster-next-to-me) => 1
    (distance me monster-far-away) => 666))

