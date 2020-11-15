repl:
	julia

init:
	brew cask install julia || true

link:
	ln -sf  /usr/local/Caskroom/julia/1.5.3/Julia-1.5.app/Contents/Resources/julia/bin/julia /usr/local/bin/julia || true

deps:
	julia deps.jl

setup: init link deps

johns-hopkins-covid:
	julia johns-hopkins-covid.jl
