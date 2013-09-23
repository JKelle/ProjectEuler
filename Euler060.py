from math import sqrt
import EulerUtils, sortedList

maxSize = 1000000
sieve = EulerUtils.sieve(maxSize)
primes = [i for i in xrange(len(sieve)) if sieve[i]]
pairs = []

def isPrime(num):
	if num >= len(sieve):
		for n in xrange(2, int(sqrt(num))):
			if num % n == 0:
				return False
		return not num % int(sqrt(num)) == 0
	else:
		return sieve[num]

def can_split_into_primes(num):
	digits = EulerUtils.getDigits(num)
	for i in xrange(1, len(digits)):
		a = EulerUtils.getNumFromDigits(digits[:i])
		b = EulerUtils.getNumFromDigits(digits[i:])
	#	print "%s:" % num
		if isPrime(a) and isPrime(b):
			if isPrime( EulerUtils.concat(b,a) ):
	#			print "\t%s, %s" % (a,b)
				pair = tuple(sorted((a,b)))
				if not pair in pairs:
					#sortedList.sorted_add(pairs, pair)
					pairs.append(pair)
	#print
"""
num = 7109
can_split_into_primes(num)
"""
def main():
	for num in primes:
		can_split_into_primes(num)
	print len(pairs)

if __name__ == '__main__':
	print EulerUtils.timeit(main)
	"""
	for a in xrange(len(primes)):
		for b in xrange(a+1, len(primes)):
			for c in xrange(b+1, len(primes)):
				for d in xrange(c+1, len(primes)):
					print primes[a], primes[b], primes[c], primes[d]
	"""
