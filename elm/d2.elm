module Main exposing (..)

import Html exposing (..)
import Browser
-- import Signal

import Element exposing (..)
import Html.Events.Extra.Mouse as Mouse

-- https://rosettacode.org/wiki/Mouse_position#Elm
-- main =
--     Signal.map show Mouse.position

main : Signal Html
main =
    show "Hello World!"
