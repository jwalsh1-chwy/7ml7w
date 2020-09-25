-- Interactive utils for the repl

function table_to_string(t)
   local result = {}
   for k, v in pairs(t) do
      result[#result + 1] = k .. ": " .. v
   end
   return table.concat(result, "|n")
end


function print_array(a)
   local t = a[1] and a or {}
   for i, v in pairs(t) do
      print(v)
   end
end
