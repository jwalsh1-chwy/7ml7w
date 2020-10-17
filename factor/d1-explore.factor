40 2 + .
5 7 3 1 + - * .
10 [1,b] range >array 1 [ * ] reduce
: fact ( n -- n! ) [1,b] 1 [ * ] reduce ;
4 2 > .

\ { { "one" 1 } { "two" 2 } } "one" of .
\ "two" { { "one" 1 } { "two" 2 } } "one" at .

44.5 dup 0.05 * swap 0.09975 *
