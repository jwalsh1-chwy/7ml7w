const ast = require('./ast.js.json')


const renderVariable = (variable) => {
  console.log(variable)
}

let prefix = []

const render = (block) => {
  prefix.push('#')
  console.log(prefix.join(''), block.type ? block.type : block)
  switch(block.type) {
  case 'Chunk':
    block.body ? block.body.map(render) : console.log('')
    break;

  case 'AssignmentStatement':
    block.variables ? block.variables.map(render) : console.log('')
    block.init ? block.init.map(render) : console.log('')
    break;

  case 'CallExpression':
    block.base ? render(block.base) : console.log('')
    block.arguments ? block.arguments.map(render) : console.log('')
    break;

  case 'CallStatement':
    block.expression ? render(block.expression) : console.log('')
    block.arguments ? block.arguments.map(render) : console.log('')
    break;

  case 'FunctionDeclaration':
    console.log(block.indentifier, block.isLocal)
    block.parameters ? block.parameters.map(render) : console.log('')
    block.body ? block.body.map(render) : console.log('')
    break;

  case 'Identifier':
    block.name ? console.log(block.name) : console.log('')
    break;

  case 'IndexExpression':
    block.base ? render(block.base) : console.log('')
    block.index? render(block.index) : console.log('')
    break;

  case 'LocalStatement':
    block.variables ? block.variables.map(render) : console.log('')
    block.init ? block.init.map(render) :  console.log('')
    break;

  case 'MemberExpression': // Terminating
    console.log(block.base.name, block.indexer, block.identifier.name)
    break;

  case 'ReturnStatement':
    block['arguments'] ? block['arguments'].map(render) : console.log('')
    break;

  case 'StringLiteral':
    console.log(block.value, block.raw)
    break;

  case 'TableConstructorExpression':
    console.log('{')
    block['arguments'] ? block['arguments'].map(render) : console.log('')
    block['fields'] ? block['fields'].map(render) : console.log('')
    console.log('}')
    break;

  case 'TableKeyString':
    console.log(block.key.name, '=', block.value.name)
    break;

  case 'UnaryExpression':
    console.log(block.operator, block.argument.name)
    break;

  default:
    console.log('UnknownBlock')
    console.log(block.arguments)
  }
  prefix.pop()

}

render(ast)
