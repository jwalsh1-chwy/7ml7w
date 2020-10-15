-- utils = require('util.lua')
function print_table(t)
   for k, v in pairs(t) do
      print(k .. ': ' .. v)
   end
end

-- find
-- luarocks install loop

-- Easy

a1 = {
   'foo',
   'bar'
}

a2 = {
   'baz',
   'biz'
}

-- concatenate
function concatenate(a1, a2)
   local result = a1
   for k, v in pairs(a2) do
      result[#result + 1] = v
   end
   return result
end

function contact_rm(a1, a2)
   -- https://developer.roblox.com/en-us/api-reference/lua-docs/table
   local result = a1
   for k, v in pairs(a2) do
      result[#result + 1] = table.remove(a2, 1)
   end
   return result

end

-- print_table(a1)

b1 = concatenate(a1, a2)

print_table(b1)

-- support delete
function strict_read()

end

-- Medium

mt = {}

Queue = {
   new = function()
      queue = {}
   end,
   add = function(item)
      queue[#queue  + 1] = item
   end,
   remove = function()
      item = queue[0]
      queue[0] = nil
   end
}


-- Hard

function retry(count, body)

end
