import time

def factorial(n):
	if n > 1:
		return n * factorial(n-1)
	return 1

def getDigits(num):
	digits = []
	while num > 0:
		digits.append( num % 10 )
		num /= 10
	return digits[::-1]

def numDigits(num):
	counter = 0
	while num > 0:
		num /= 10
		counter += 1
	return counterp

def getNumFromDigits(digits):
	num = 0
	for digit in digits:
		num *= 10
		num += digit
	return num

def concat(a, b):
	return a*10**numDigits(b)+b

def sieve(size):
	p = [True] * (size+1)
	p[0] = False
	p[1] = False
	for i in xrange(2,size+1):
		if p[i]:
			m = 2
			while i*m <= size:
				p[i*m] = False
				m += 1
	return p

def timeit(func, args=()):
	s = time.time()
	res = func(*args)
	return time.time() - s, res