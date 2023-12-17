def twoSum(nums, target):
  num_map = {}
  for i, num in enumerate(nums):
    complement = target - num
    if complement in num_map:
      return [num_map[complement], i]
    num_map[num] = i
  return []

def main():
  # Тестовый случай
  nums = [2, 7, 11, 15]
  target = 9
  print(twoSum(nums, target))  # Вывод: [0, 1]

if __name__ == "__main__":
  main()