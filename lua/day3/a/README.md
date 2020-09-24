``` shell
export LIBRARY_PATH=/usr/local/lib/
```

``` shell
luajit -bl notation.lua
```

``` text
-- BYTECODE -- notation.lua:0-71
0001    KSHORT   0 144
0002    KSHORT   1 128
0003    KSHORT   2 127
0004    FNEW     3   0      ; notation.lua:5
0005    GGET     4   1      ; "print"
0006    MOV      5   3
0007    KSTR     6   2      ; "C"
0008    KSHORT   7   1
0009    CALL     5   0   3
0010    CALLM    4   1   0
0011    FNEW     4   3      ; notation.lua:27
0012    GSET     4   4      ; "duration"
0013    GGET     4   1      ; "print"
0014    GGET     5   4      ; "duration"
0015    KSTR     6   5      ; "ed"
0016    CALL     5   0   2
0017    CALLM    4   1   0
0018    FNEW     4   6      ; notation.lua:42
0019    FNEW     5   7      ; notation.lua:46
0020    FNEW     6   8      ; notation.lua:50
0021    FNEW     7   9      ; notation.lua:54
0022    FNEW     8  10      ; notation.lua:58
0023    TDUP     9  11
0024    TSETS    4   9  12  ; "parse_note"
0025    TSETS    5   9  13  ; "play"
0026    TSETS    6   9  14  ; "part"
0027    TSETS    7   9  15  ; "set_tempo"
0028    TSETS    8   9  16  ; "go"
0029    UCLO     0 => 0030
0030 => RET1     9   2
```
