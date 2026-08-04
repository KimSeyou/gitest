a, b, c = map(int, input().split())
arr = [a, b, c]
hap = sum(arr)
ave = int(hap / len(arr))
print(hap)
print(ave)
print(hap-ave)