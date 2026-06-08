n = int(input())

arr = list(map(int, input().split()))
new_arr = [x ** 2 for x in arr]
for i in new_arr:
    print(i, end=" ")
