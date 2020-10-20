IN: examples.checkout

CONSTANT: gst-rate 0.05
CONSTANT: pst-rate 0.09975

: gst-pst ( price -- taxes ) [ gst-rate * ] [ pst-rate * ] bi + ;

: sum ( seq -- n ) 0 [ + ] reduce ;

: cart-item-count ( cart -- count ) 0 ;

: cart-item-price ( cart-item -- price ) 0 ;

: cart-base-price ( cart -- price ) 0 ;

: cart-has-items ( cart -- bool ) T
