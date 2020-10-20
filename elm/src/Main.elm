module Main exposing (..)

a = [1, 2, 3]
-- a[2] = 4
-- a[5] = 6

b = [1, 2] ++ [3, 4]

-- case b of \
--     head::tail -> tail \
--     [] -> []

getWidth maybeWidth =
    case maybeWidth of
        Just width ->
            width + 200

        Nothing ->
          400

greet : String -> String
greet name =
    "Hello " ++ name ++ "!"

type User = Anonymous | LoggedIn String

x = 0

if x < 0 -> "too small"
   | x > 0 -> "too large"
   | otherwise -> "just right"

type Color = Black  | White
type Piece = Pawn | Knight | Bishop | Rook | Queen | King
type ChessPiece = CP Color Piece

-- color = case piece of  | CP White _ -> White | CP Black _ -> Black
