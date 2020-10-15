USE: kernel

IN: examples.tuples

TUPLE: cart-item name price quantity ;

: <dollar-cart-item> ( name -- cart-item ) 100 1 cart-item boa ;

: <one-cart-item> ( -- cart-item ) T{ cart-item { quantity 1 } } ;
