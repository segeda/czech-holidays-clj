(ns czech-holidays.easter
    (:require [clj-time.core :as time]))

(defn- sunday
    "Compute Easter Sunday for given year - https://en.wikipedia.org/wiki/Computus#Anonymous_Gregorian_algorithm"
    [year]
    (let [a (mod year 19)
          b (quot year 100)
          c (mod year 100)
          d (quot b 4)
          e (mod b 4)
          f (quot (+ b 8) 25)
          g (quot (+ (- b f) 1) 3)
          h (mod (+ (- (- (+ (* 19 a) b) d) g) 15) 30)
          i (quot c 4)
          k (mod c 4)
          l (mod (- (- (+ (+ 32 (* 2 e)) (* 2 i)) h) k) 7)
          m (quot (+ (+ a (* 11 h)) (* 22 l)) 451)
          n (+ (- (+ h l) (* 7 m)) 114)
          month (quot n 31)
          day (+ (mod n 31) 1)]
    (time/local-date year month day)))

(defn friday
    "Get Good Friday for given year"
    [year]
    (let [easter-sunday (sunday year)
          good-friday (time/minus easter-sunday (time/days 2))]
    {:day (time/day good-friday) :month (time/month good-friday)}))

(defn monday
    "Get Easter Monday for given year"
    [year]
    (let [easter-sunday (sunday year)
          easter-monday (time/plus easter-sunday (time/days 1))]
    {:day (time/day easter-monday) :month (time/month easter-monday)}))
