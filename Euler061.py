def Tri(n):	return n*(n+1)/2
def Sqr(n):	return n**2
def Pen(n):	return n*(3*n-1)/2
def Hex(n):	return n*(2*n-1)
def Hep(n):	return n*(5*n-3)/2
def Oct(n):	return n*(3*n-2)

def P(p,n):
	Plist = [None, None, None, Tri, Sqr, Pen, Hex, Hep, Oct]
	return Plist[p](n)

def Pgen(_p):
	n = 1
	p = P(_p,n)
	while(p <= 9999):
		if p >= 1000:
			yield p
		n += 1
		p = P(_p, n)

def fitsChain(existing, new):
	return existing%100 == (new - new%100)/100

def getNextLink(chain, availible_ps):
	if not availible_ps:
		if fitsChain(chain[-1], chain[0]):
			print chain, sum(chain)
	for _p in availible_ps:
		aps = [i for i in availible_ps if not i == _p]
		for p in Pgen(_p):
			if not chain or fitsChain(chain[-1], p):
				chain.append(p)
				getNextLink(chain, aps)
				chain.remove(chain[-1])

def main():
	chain = []
	availible_ps = [3,4,5,6,7,8]
	getNextLink(chain, availible_ps)

if __name__ == '__main__':
	main()
