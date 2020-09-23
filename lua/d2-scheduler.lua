local pending = {}

local function schedule(time, action)
   pending[#pending + 1] = {
      time = time
      action = action
   }
end


local function wait(seconds)
   coroutine.yeild(seconds)
end

local function run()

end

local function sort_by_time(array)

end

local function remove_first(array)

end

return {
   schedule = schedule,
   run = run,
   wair = wait
} 
