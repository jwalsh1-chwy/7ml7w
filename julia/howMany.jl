using Random

function flip_coins(times)
    count = 0
    for i = 1:times
        count += Int(rand(Bool))
    end
    count
end

@time println(flip_coins(10000000))

addprocs(4)
println(workers())

function pflip_coins(times)
    @distributed (+) for i = 1:times
        Int(rand(Bool))
    end
end

@time println(pflip_coins(10000000))
