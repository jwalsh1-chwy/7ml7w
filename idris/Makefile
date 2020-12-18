repl:
	idris

init:
	brew install ghc cabal-install
	cabal update; cabal install idris

list-libs:
	idris --listlibs

hello:
	export IDRIS_LIBRARY_PATH="/usr/local/share/x86_64-osx-ghc-8.6.5/idris-1.3.3/libs/"
	idris hello.idr -o hello

functions:
	echo ':l functions' | idris

map-type:
	echo ':t map' | idris
