import EulerUtils

with open('commonEnglishWords.txt') as f:
	commonWords = f.read().split(',')
	#print commonWords

with open('cipher1.txt') as f:
	numbers = [int(x) for x in f.read().split(',')]
	numbers_bythrees = []
	for i in xrange(0,len(numbers)-2,3):
		numbers_bythrees.append( (numbers[i] << 16) | (numbers[i+1] << 8) | numbers[i+2] )
	numbers_bythrees.append( numbers[-1] << 16 )

def decipher(encripted_tiplets, key):
	decripted_triplets = [key^trip for trip in encripted_tiplets]
	msg = []
	for trip in decripted_triplets:
		msg += [trip >> 16, (trip >> 8) & (2**8-1), trip & (2**8-1)]
	return msg[:-2]

def main():
	bestmsg = ("", 0)
	for a in range(ord('a'), ord('z')+1):
		for b in range(ord('a'), ord('z')+1):
			for c in range(ord('a'), ord('z')+1):
				key = (a << 16) | (b << 8) | c
				msg = decipher(numbers_bythrees, key)
				msg = "".join([chr(c) for c in msg])
				count = 0
				for word in msg.split():
					if word in commonWords:
						count += 1
				if count > bestmsg[1]:
					bestmsg = (msg, count)
	print bestmsg[0]	
	ascii_sum = 0
	for c in bestmsg[0]:
		ascii_sum += ord(c)
	print ascii_sum

print EulerUtils.timeit(main)