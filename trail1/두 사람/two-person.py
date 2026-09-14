inp1 = input()
arr1 = inp1.split()
ageA, sexA = int(arr1[0]), str(arr1[1])

inp2 = input()
arr2 = inp2.split()
ageB, sexB = int(arr2[0]), str(arr2[1])

if (ageA >= 19 and sexA == 'M') or (ageB >= 19 and sexB == 'M'):
    print(1)
else:
    print(0)