const ast = require('./ast.js.json')


const renderVariable = (variable) => {
  console.log(variable)
}

let prefix = ['']

const log = (...args) => {
  console.log(prefix.join(' '), ...args)
}

const render = (block, i) => {
  prefix.push('')
  console.log(prefix.join('*'), block.type ? block.type : block, i ? i : '')
  switch(block.type) {
  case 'Chunk':
    block.body ? block.body.map(render) : log('')
    break;

  case 'AssignmentStatement':
    block.variables ? block.variables.map(render) : log('')
    log('=')
    block.init ? block.init.map(render) : log('')
    break;

  case 'CallExpression':
    block.base ? render(block.base) : log('')
    block.arguments ? block.arguments.map(render) : log('')
    break;

  case 'CallStatement':
    block.expression ? render(block.expression) : log('')
    block.arguments ? block.arguments.map(render) : log('')
    break;

  case 'FunctionDeclaration':
    // log(block.indentifier, block.isLocal)
    log('function(')
    block.parameters ? block.parameters.map(render) : log('')
    log(')')
    block.body ? block.body.map(render) : log('')
    break;

  case 'Identifier':
    block.name ? log(block.name) : log('')
    break;

  case 'IndexExpression':
    block.base ? render(block.base) : log('')
    log('[')
    block.index? render(block.index) : log('')
    log(']')
    break;

  case 'LocalStatement':
    log('local')
    block.variables ? block.variables.map(render) : log('')
    log('=')
    block.init ? block.init.map(render) :  log('')
    break;

  case 'MemberExpression': // Terminating
    log(block.base.name, block.indexer, block.identifier.name)
    break;

  case 'ReturnStatement':
    block['arguments'] ? block['arguments'].map(render) : log('')
    break;

  case 'StringLiteral':
    log(block.value, block.raw)
    break;

  case 'TableConstructorExpression':
    log('{')
    block['arguments'] ? block['arguments'].map(render) : log('')
    block['fields'] ? block['fields'].map(render) : log('')
    log('}')
    break;

  case 'TableKeyString':
    log(block.key.name, '=', block.value.name)
    break;

  case 'UnaryExpression':
    log(block.operator, block.argument.name)
    break;

  default:
    log('UnknownBlock')
    log(block.arguments)
  }
  prefix.pop()

}

render(ast)
