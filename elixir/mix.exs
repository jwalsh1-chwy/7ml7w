defmodule JW.MixProject do
  use Mix.Project

  def project do
    [
      app: :jw,
      version: "0.1.0",
      elixir: "~> 1.9",
      start_permanent: Mix.env == :prod,
      deps: deps()
    ]
  end


  def deps do
    [{:jason, "~> 1.1.2"}]
  end
end
