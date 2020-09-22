
function counterGenerator(count)
   local c = count
   return function()
      c = c + 1
      return c
   end
end

local counter = counterGenerator(0)
print(counter())
print(counter())
print(counter())
print(counter())
