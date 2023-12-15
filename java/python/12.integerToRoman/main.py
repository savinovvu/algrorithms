values = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]
symbols = ["M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"]

def intToRoman(num):
  result = ""
  for i in range(len(values)):
    while values[i] <= num:
      num -= values[i]
      result += symbols[i]
  return result

def main():
  print(intToRoman(9))

if __name__ == "__main__":
  main()