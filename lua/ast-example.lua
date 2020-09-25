local a = {} ; a.b = a a.b["c"], d = function(e) return e end, "f" print(a.b("g"), #a) return { a = a}
