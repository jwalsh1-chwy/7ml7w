var parser = require('luaparse');
//  goto isn't supported in luaparse '::g::'
var ast = parser.parse('local a = {} ; a.b = a a.b["c"], d = function(e) return e end, "f" print(a.b("g"), #a) return { a = a}');
console.log(JSON.stringify(ast));
