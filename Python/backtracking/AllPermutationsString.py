def permute(array, l, r):
    if(l==r):
        print(''.join(array))
        return
    else:
        for i in range(l,r):
            array[l], array[i] = array[i], array[l]
            permute(array, l+1, r)
            array[l], array[i] = array[i], array[l]

def main():
    s = input()
    s = [ i for i in s.strip() ]
    print()
    permute(s, 0, len(s))

if __name__=='__main__':
    main()
