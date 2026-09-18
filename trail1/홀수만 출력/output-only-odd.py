a, b = map(int, input().split())

for i in range(1, 101, 2):
    if i >= a and i <= b:
        print(i, end=" ")