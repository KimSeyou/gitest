mathA, engA = map(int, input().split())
mathB, engB = map(int, input().split())

if mathA == mathB:
    if engA > engB:
        print("A")
    else:
        print("B")
elif mathA > mathB:
    print("A")
else:
    print("B")
    