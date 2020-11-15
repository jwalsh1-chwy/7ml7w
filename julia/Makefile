repl:
	julia

init:
	brew cask install julia || true
	brew reinstall julia || true
	brew install r || true
	/usr/local/bin/julia --version

notebook-julia:
	julia notebook.jl

notebook:
	pip3 install notebook
	jupyter notebook

deps:
	julia deps.jl

setup: init deps

johns-hopkins-covid:
	julia johns-hopkins-covid.jl
