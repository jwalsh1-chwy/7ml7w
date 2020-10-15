: add-42 ( x -- y) 42 + ;
: sum ( seq -- n ) 0 [ + ] reduce ;

interactive-vocabs get[ print ] each .
