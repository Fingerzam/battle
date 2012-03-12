(ns battle.test.helpers
  (:require [battle.fight :as fight]))

(defn less-hp-after-action [action subject target]
  (< (fight/hp (action subject target)) (fight/hp target)))
