const parser = require('luaparse');
const fs = require('fs');

fs.readFile('ast-example.lua', 'utf8', (err, data) => {
  if (err) throw err;
  const ast = JSON.stringify(parser.parse(data), null, '  ');
  fs.writeFile('ast.js.json', ast, (err) => {
    if (err) throw err;
  });
  console.log(ast);
})
