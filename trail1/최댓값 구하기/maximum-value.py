a, b, c = map(int, input().split())

if a > b:
    if a > c:
        print(a)
    else:
        print(c)
elif b > c:
    if b > a:
        print(b)
    else:
        print(a)
else:
    if c > a:
        print(c)
    else:
        print(b)