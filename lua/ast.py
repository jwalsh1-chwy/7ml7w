from luaparser import ast

src = """
local a = {} ; a.a = a a.a["a"] = function(a) return a end print(a.a("a"), #a)
"""

tree = ast.parse(src)
print(ast.to_pretty_str(tree))
