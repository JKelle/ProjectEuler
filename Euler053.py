import EulerUtils

def buildFactTable(size):
	factTable = [1,1]
	for n in xrange(2, size):
		factTable.append(n*factTable[n-1])
	return factTable

def nCr(n,r,factTable):
	return factTable[n]/(factTable[r]*factTable[n-r])

def main(size):
	count = 0
	factTable = buildFactTable(size)
	for n in xrange(1,size):
		for r in xrange(1,n+1):
			if nCr(n,r,factTable) > 1e6:
				count += 1
	print "ans =", count

if __name__ == '__main__':
	print "time =", EulerUtils.timeit(main, (101,))[0]