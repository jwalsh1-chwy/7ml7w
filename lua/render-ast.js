const ast = require('./ast.js.json')


const renderVariable = (variable) => {
  console.log(variable)
}

let prefix = ['','']
let source = []
const log = (...args) => {
  console.log(prefix.join(' '), ...args)
  source.push(...args)
}

const render = (block, i) => {
  prefix.push('')
  console.log('')
  console.log(prefix.join('*'), block.type ? block.type : block, i >= 0 ? i : '')
  console.log('')
  if (block.type && !block.type.includes("Statement") && i > 0) log(',')
  switch(block.type) {
  case 'Chunk':
    block.body ? block.body.map(render) : ''
    break;

  case 'AssignmentStatement':
    block.variables ? block.variables.map(render) : ''
    log('=')
    block.init ? block.init.map(render) : ''
    break;

  case 'BinaryExpression':
    // console.log(block)
    block.left.type ? render(block.left) : log(block.left)
    log(block.operator)
    block.right.type ? render(block.right) : log(block.right)
    break;

  case 'CallExpression':
    block.base ? render(block.base) : ''
    log('(')
    block['arguments'] ? block['arguments'].map(render) : ''
    log(')')
    break;

  case 'CallStatement':
    block.expression ? render(block.expression) : ''
    block['arguments'] ? block['arguments'].map(render) : ''
    break;

  case 'ForGenericStatement':
    log('for')
    block['variables'] ? block['variables'].map(render) : ''
    log('in')
    block['iterators'] ? block['iterators'].map(render) : ''
    log('do')
    block['body'] ? block['body'].map(render) : ''
    log('end')
    break;

  case 'FunctionDeclaration':
    // log(block.indentifier, block.isLocal)
    log('function(')
    block.parameters ? block.parameters.map(render) : ''
    log(')')
    block.body ? block.body.map(render) : ''
    log('end')
    break;

  case 'Identifier':
    block.name ? log(block.name) : ''
    break;

  case 'IndexExpression':
    block.base ? render(block.base) : ''
    log('[')
    block.index? render(block.index) : ''
    log(']')
    break;

  case 'LocalStatement':
    log('local')
    block.variables ? block.variables.map(render) : ''
    log('=')
    block.init ? block.init.map(render) :  ''
    break;

  case 'MemberExpression': // Terminating
    log(`${block.base.name}${block.indexer}${block.identifier.name}`)
    break;

  case 'NumericLiteral':
    log(block.value ? block.value : block.raw)
    break;

  case 'ReturnStatement':
    log('return')
    block['arguments'] ? block['arguments'].map(render) : ''
    break;

  case 'StringLiteral':
    log(block.value ? block.value : block.raw)
    break;

  case 'TableConstructorExpression':
    log('{')
    block['arguments'] ? block['arguments'].map(render) : ''
    block['fields'] ? block['fields'].map(render) : ''
    log('}')
    break;

  case 'TableKeyString':
    log(block.key.name, '=', block.value.name)
    break;

  case 'UnaryExpression':
    log(`${block.operator}`)
    block.argument.type  ? render(block.argument) : log(block.argument)
    break;

  default:
    log('UnknownBlock')
    log(block)
  }
  if (block.type && block.type.includes("Statement")) log(';')
  prefix.pop()
}

render(ast)
console.log('')
console.log('** Rebuilt')
console.log('')
console.log(source.join(' '))
