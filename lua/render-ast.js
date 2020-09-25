const ast = require('./ast.js.json')


const renderVariable = (variable) => {

}

const render = (block) => {
  switch(block.type) {
  case 'Chunk':
    console.log('filename.lua')
    block.body.map(e => {
      render(e)
    })
    break;
  case 'LocalStatement':
    console.log('LocalStatement')
    for (let i = 0; i < block.variables.length; i ++) {
      console.log(block.variables[i].name, '=', block.init[i].type)
    }
    break;
  case 'AssignmentStatement':
    // console.log('AssignmentStatement');
    for (let i = 0; i < block.variables.length; i ++) {
      // console.log('AssignmentStatement', i);
      if (block.variables[i].base) {
        console.log(block.variables[i].base.name)
      }
      console.log(1, block.variables[i].identifier)
      console.log(2, block.init[i].name)
    }
    break;
  case 'CallStatement':
    console.log('CallStatement')
    console.log(block.expression)
    break;
  case 'ReturnStatement':
    console.log('ReturnStatement')
    console.log(block.arguments)
    break;
  default:
    console.log('UnknownBlock')
    console.log(block.arguments)
  }
}

render(ast)
