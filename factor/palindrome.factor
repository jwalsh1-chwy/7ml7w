! Copyright (C) 2012 Your name.
! See http://factorcode.org/license.txt for BSD license.
USING: ;
IN: palindrome

: palindrome? ( string -- ? ) dup reverse = ;
