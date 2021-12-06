def my_func(l1, l2):
  r = []
  for i in range(len(l1)):
    r.insert(l2[i], l1[i])
  return r


l1 = [0, 1, 2, 3, 4]
l2 = [0, 1, 2, 2, 1]

if __name__ == "__main__":  
  r = my_func(l1, l2)
  print(r)
