
product list =
    case list of
        [] -> 1
        head::tail -> head * product tail

-- first (head:tail) = head

six = product [1,2,3]

multiply x y = x * y

fortyeight = (multiply 6) 8

type alias Person =
    { name : String
    , age : Int
    }

jason = { name = "jwalsh", age = 100 }

under50 {age} =
    age < 50
