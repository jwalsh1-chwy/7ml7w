\ easy

3 3 * 4 4 * +

USE: math.functions
3 sq 4 sq sqrt

1 2 over swap

"jwalsh" "Hello, " swap append >upper

\ medium

{ 1 2 } 0 [ + ] reduce .

USE: math.ranges
100 [1,b] range >array 0 [ + ] reduce .

USE: math.functions
10 [1,b] range >array [ sq ] map .
