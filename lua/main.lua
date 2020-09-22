for i = 10, 1, -1 do print(i) end

print(math.sin(1))

-- Monster{
--    name = "knight",
--    treasture = {-100, 200}
-- }


function triple(num)
   return 3 * num
end

print(triple(9))



function double(num)
   return 2 * num
end

print(double(2))

print(double(3))

function calltwice(f)
   return function(num)
      return f(f(num))
   end
end

print(calltwice(double)(2))

-- Variadic functions
function print_characters(friend, ...)
   print(friend)
   foes = {...}
   print(foes[0])
end

print_characters('foo', 'bar')

-- TCO

-- Multiple return values
function simple()
   return 'Jason', 'Walsh'
end


first, last = simple()
print(first, last)


-- Keyword arguments through tables
function popcorn_prices(table)
   print('Medium price is ' .. table.medium)
end

popcorn_prices{small=5.0,
               medium=10}

-- Control flow

-- name = 'Jason'
-- if 'Jason' == name then
--    print('Matches')
-- else
--    print('No')
-- end
