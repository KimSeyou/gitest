arr = [
    list(map(int, input().split()))
    for _ in range(4)
]

for i in range(4):
    hap = 0
    for j in range(4):
        hap += arr[i][j]
    print(hap)