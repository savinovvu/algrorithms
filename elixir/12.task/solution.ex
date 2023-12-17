defmodule Solution do
  def int_to_roman(num) do
    values = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]
    symbols = ["M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"]
    roman = ""

    for {value, symbol} <- Enum.zip(values, symbols) do
      while num >= value do
        num = num - value
        roman = roman <> symbol
      end
    end

    roman
  end

  def main do
    IO.puts(int_to_roman(1990)) # MCMXC
    IO.puts(int_to_roman(2008)) # MMVIII
    IO.puts(int_to_roman(99))   # XCIX
  end
end

Solution.main()
