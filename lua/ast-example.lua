local a = {} ; a.b = a a.b[#a.b + 1], d = function(e) return e end, "f" for k, v in pairs(a.b) do print(k .. "h", #a) end return { a = a}
