local a = {"c"} ; a.b = a a.b[#a.b + 1], d = function(e) return e end, "f" for k, v in pairs(a.b) do print("- " .. k, #a) end return { a = a}
