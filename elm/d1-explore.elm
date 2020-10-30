module DayOne exposing (main, inc, c, add, twelve)

import Html exposing (..)
import Html.Attributes exposing (..)

main =
    div [ class "header" ]
        [
         h1 [] [ text "Seven More Languages in Seven Weeks" ],
         div [] [text "foo"]
        ]


add a b = a + b
inc = (add 1)
double n = 2 * n

twelve = 5 |> inc |> double
tw =  double  <| (5 |> inc)
-- double(inc(5))

l = List.map double [1, 2, 3]

-- True && not (True || False)
-- (2 + 4) * (4^2 - 9)
c = "7ml" ++ "7w"

d = [1,2,3,4]
e = 1 :: [2,3,4]
f = 1 :: 2 :: 3 :: 4 :: []


-- -- case maybeList of
-- --     Just xs -> xs
-- --     Nothing -> []

-- -- case xs of
-- --     [] ->
-- --         Nothing
-- --     first :: rest ->
-- --         Just (first, rest)

-- -- case n of
-- --     0 -> 1
-- --     1 -> 1
-- --     _ -> fib (n-1) + fib (n-2)



-- -- create records
origin = { x = 0, y = 0 }
point = { x = 3, y = 4 }

-- -- access fields
-- -- origin.x == 0
-- -- point.x == 3

-- -- field access function
-- List.map .x [ origin, point ] == [ 0, 3 ]

-- -- update a field
-- -- { point | x = 6 } == { x = 6, y = 4 }

-- -- update many fields
-- -- { point | x = point.x + 1, y = point.y + 1 }

square n =
    n^2

hypotenuse a b =
    sqrt (square a + square b)

distance (a,b) (x,y) =
  hypotenuse (a - x) (b - y)

squares =
    List.map (\n -> n^2) (List.range 1 100)


viewNames1 names =
    String.join ", " (List.sort names)

viewNames2 names =
    names
        |> List.sort
        |> String.join ", "


-- -- let
-- --     twentyFour =
-- --         3 * 8

-- --     sixteen =
-- --         4 ^ 2
-- -- in
-- --     twentyFour + sixteen


-- -- alias for appending lists and two lists
-- append sxs sys = sxs ++ sys

-- xs = [1,2,3]
-- ys = [4,5,6]

-- -- All of the following expressions are equivalent:
-- -- a1 = append xs ys
-- a2 = xs ++ ys

-- b2 = (++) xs ys

-- c1 = (append xs) ys
-- c2 = ((++) xs) ys
