USE: kernel

IN: examples.tuples

TUPLE: cart-item name price quantity ;

: <dollar-cart-item> ( name -- cart-item ) 100 1 cart-item boa ;

: <one-cart-item> ( -- cart-item ) T{ cart-item { quantity 1 } } ;

: <dollar-store-cart-item ( -- cart-item ) T{ cart-item f 1 1 } ;


TUPLE: user id username firstName lastName email password phone userStatus ;
TUPLE: tag id name ;
TUPLE: order id petId quantity shipDate status complete ;
TUPLE: pet id category name photoUrls items tags ;
TUPLE: category id name ;
