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


function frequencies(df,vars)
    freqs = combine(DataFrames.groupby(df, vars), nrow)
    freqs = DataFrames.rename(freqs, :nrow => :count);
    freqs[!,:percent] = 100*freqs.count/sum(freqs.count);
    sort!(freqs, [DataFrames.order(:count, rev = true)]);
    return(freqs)
end

function sumna(vec) return(sum(skipmissing(vec))) end

function mknames(df)
    from = names(df);
    to = [Symbol(replace(lowercase(string(f))," " => "")) for f in from];
    to = [Symbol(replace(lowercase(string(t)),"_" => "")) for t in to];
    return(to)
end

start = time()

burl = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/";
fname = "csse_covid_19_time_series/time_series_covid19_confirmed_US.csv";
mv(download(string(burl,fname)), fname, force=true)
@timend
print(fname)

covidcases = CSV.read(fname, DataFrame);
metaj(covidcases)

print(last(covidcases[:,[1,2,3,4,5,6,7,8]],15))
