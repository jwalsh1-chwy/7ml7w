local a = {} ; a.b = a a.b["c"] = function(d) return d end print(a.b("e"), #a) return { a = a}
