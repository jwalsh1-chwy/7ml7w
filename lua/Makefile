repl:
	lua -i repl.lua

init:
	brew install lua cmake rtmidi
	luarocks install luarepl busted
	brew cask install SimpleSynth

init-wasm:
	brew install emscripten

ast:
	node ast.js | jq

rebuild:
	cat ast-example.lua
	lua ast-example.lua
	node ast.js
	node render-ast.js
	lua rebuilt.lua
