module Main exposing (..)

import Html exposing (..)
import Browser
import Element exposing (..)
import Html.Events.Extra.Mouse as Mouse


main =
    Signal.map show Mouse.position
