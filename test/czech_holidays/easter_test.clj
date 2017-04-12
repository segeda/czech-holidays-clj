(ns czech-holidays.easter-test
  (:require [clojure.test :refer :all]
            [czech-holidays.easter :as easter]))

(defn test-good-friday
  [year month day]
  (testing (str "Good Friday for " year " is " day "." month ".")
    (is (= {:day day :month month} (easter/friday year)))))

(defn test-easter-monday
  [year month day]
  (testing (str "Easter Monday for " year " is " day "." month ".")
    (is (= {:day day :month month} (easter/monday year)))))

(deftest good-friday
  (test-good-friday 2001 4 13)
  (test-good-friday 2002 3 29)
  (test-good-friday 2003 4 18)
  (test-good-friday 2004 4 9)
  (test-good-friday 2017 4 14)
  (test-good-friday 2018 3 30)
  (test-good-friday 2019 4 19)
  (test-good-friday 2020 4 10))

(deftest easter-monday
  (test-easter-monday 2001 4 16)
  (test-easter-monday 2002 4 1)
  (test-easter-monday 2003 4 21)
  (test-easter-monday 2004 4 12)
  (test-easter-monday 2017 4 17)
  (test-easter-monday 2018 4 2)
  (test-easter-monday 2019 4 22)
  (test-easter-monday 2020 4 13))
