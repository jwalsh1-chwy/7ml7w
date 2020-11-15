using DataFrames
using PyCall
using RCall
using RDatasets
using CSV
using DataFramesMeta
using Base
using Dates
using Feather
using Gadfly
using DataTables
using RollingFunctions
using Printf


macro timend()
    stop = time()
    elapsed = stop-start
    println(elapsed)
end

function pr(howmany)
    for i = 1:howmany
        println()
    end
end

function showln(obj)
    show(obj)
    pr(2)
end

function metaj(df;data=false)
    println(DataFrames.typeof(df))
    println(DataFrames.size(df))
    println(hcat(names(df),eltypes(df)))
    if data
        print(DataFrames.first(df,6))
        pr(1)
        print(DataFrames.last(df,6))
    end
    pr(2)
end

pr(2)
