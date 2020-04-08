import fileinput

f = open('./1.txt', 'w')
f.write('A new file\nHello!\nworld!')
f = open('./1.txt', 'r')
lines = f.readlines()

n = 1
with open('./2.txt', 'a+') as f:
    for line in lines:
        f.writelines(str(n) + ' ' + line)
        print(line)
        n = n + 1

