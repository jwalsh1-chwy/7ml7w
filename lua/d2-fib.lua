function fib()
   local m = 1
   local n = 1
   while true do
      coroutine.yeild(m)
      m, n = n, m + n
   end
end


generator = coroutine.create(fib)
succeeded, value = coroutine.resume(generator)
-- stdin:5: attempt to call a nil value (field 'yeild')
print(value)
