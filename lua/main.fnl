(fn print-and-add [a b c]
  (print a)
  (+ b c))

(print-and-add 1 2 3)

(let [x (+ 1 99)
      y (- x 12)
      z 100_000]
  (+ z (/ y 10)))

{"key" value
 "number" 531
 "f" (fn [x] (+ x 2))}


(each [index value (ipairs ["abc" "def" "xyz"])]
  (print index value))
