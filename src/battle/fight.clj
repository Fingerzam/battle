(ns battle.fight
  (:use midje.sweet)
  (:import java.lang.Math))

(defn make-player [& {:keys [name location]}]
  {:name name
   :hp 12
   :location location
   :reach 2
   :damage 2})

(defn damage [player]
  (:damage player))

(defn make-monster [& {:keys [name location]}]
  {:name name
   :location location
   :hp 12})

(defn hp [entity]
  (:hp entity))

(defn location [entity]
  (:location entity))

(def reach :reach)

(defn reduce-hp [monster damage]
  (assoc monster :hp
         (- (hp monster) damage)))

(defn distance [origin target]
  (let [[x1 y1] (location origin)
        [x2 y2] (location target)]
    (max (Math/abs (- x1 x2))
         (Math/abs (- y1 y2)))))

(defn can-hit [hitter target]
  (< (distance hitter target)
     (reach hitter)))

(defn hit [hitter target]
  (if (can-hit hitter target)
    (reduce-hp target (damage hitter))
    target))

