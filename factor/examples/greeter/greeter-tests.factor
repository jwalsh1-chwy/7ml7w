USING: examples.greeter tools.test ;
IN: examples.greeter.tests

{ "Hello, World" } [ "World" greeting ] unit-test
{ "Hello, jwalsh" } [ "jwalsh" greeting ] unit-test
