local pending = {}

local function schedule(time, action)
   pending[#pending + 1] = {
      time = time,
      action = action
   }
end

local function wait(s)
   coroutine.yeild(s)
end

local function sort_by_time(array)
   table.sort(array, function(a, b)
                 return a.time < b.time
   end)
end

local function remove_first(array)
   first = array[1]
   array = array[#array]
   array[#array] = nil
   return first
end

print('first: ' .. remove_first({'first', 'second'}))

local function run()
   while #pending > 0 do
      sort_by_time(pending)
      while os.clock() < pending[1].time do end

      local item = remove_first(pending)
      local _, seconds = coroutine.resume(item.action)

      if seconds then
         later = os.clock() + seconds
         schedule(later, item.action)
      end
   end

end


return {
   schedule = schedule,
   run = run,
   wait = wait,
}
