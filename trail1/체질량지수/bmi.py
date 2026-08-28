import math

h, w = map(int, input().split())
b = (10000*w)/(h*h)


#print("%.0f" % b)
print(math.trunc(b))

if (b >= 25):
    print("Obesity")