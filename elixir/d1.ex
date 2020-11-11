IO.puts "hello" <> " world"

4 > 5 and 6 > 7

austin = {:austin, :tx}

inc = fn(x) -> x + 1 end

inc.(1)

add = &(&1 + &2)

add.(1, 2)

dec = &(add.(&1, -1))

x = 10

dec.(inc.(inc.(10)))

10 |> inc.() |> inc.() |> dec.()

# defmodule Customer do
#   def drive?(%User{age: age}), do: age >= 18
# end


def print(x) do
  Enum.each(x, &(IO.put &1))
end

defmodule Rectangle do
  def area({h, w}) do
    h * w
  end

  def perimeter({h, w}) do
    2 * (w + h)
  end
end

defmodule Square do
  def area({w, h}) when w == h do
    Rectangle.area({w, w})
  end

  def perimeter({w}) do
    Rectangle.perimeter({w, w})
  end

  def perimeter({w, h}) when w == h do
    Rectangle.perimeter({w, w})
  end
end

defmodule Circle do
  def area({r}) do
    3.14 * r^2
  end

  def big?(true) do
    IO.puts "Big"
  end

  def big?(false) do
    IO.puts "Small"
  end
end

defmodule Sum do
  def add([]) do
    0
  end
  def add([head|tail]) do
    head + Sum.add(tail)
    |> IO.inspect
  end
end

defmodule Fib do
  def fib(n) when n <= 1 do
    n
  end
  def fib(n) do
    Fib.fib(n - 2) + Fib.fib(n - 1)
  end
end

defmodule QuickSort do
  def sort([]) do
    []
  end
  def sort([head|tail]) do
    # TODO
  end
end


Enum.map([1, 2, 3], fn x -> x * 2 end)
