-- http://lua-users.org/wiki/
-- programming in lua
-- http://www.lua.org/manual/5.1/manual.html#pdf-

-- utilities
function add(prev, cur)
   return prev + cur
end

function mult(prev, cur)
   return prev * cur
end


-- easy
function ends_in_3(num)
   return num % 10 == 3
end

print(ends_in_3(123))
print(ends_in_3(1234))

-- Ignore optimizations for num / 2; 3, 5 optimizatoins
function is_prime(num)
   result = true
   cur = 2
   while(cur < num) do
      if num % cur == 0 then
         result = false
      end
      cur = cur + 1
   end
   return result
end

function n_primes_ending_3(n)
   cur = 3
   count = 0
   while count < n do
      if is_prime(cur) and ends_in_3(cur) then
         print(cur)
         count = count + 1
      end
      cur = cur + 2
   end
end


-- medium
function for_loop(a, b, f)
   cur = a
   while (cur < b) do
      f(cur)
      cur = cur + 1
   end
end


-- hard
function reduce(max, init, f)
   -- print(max, init, f)
   local acc = init
   for i = 1, max do
      acc = f(i, acc)
   end
   return acc
end

print(reduce(5, 0, add))
print(reduce(5, 1, mult))


-- variadic functions
function vadd(...)
   local acc = 0
   for i, v in ipairs{...} do
      acc = acc + v
   end
end

print(vadd(1,4,5,10))
