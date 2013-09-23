HIGH_CARD = 0		# 14*0 + [2 - 14] each
PAIR = 1 			# 14*1 + [2 - 14] 
TWO_PAIR = 2		# 14*1 + [2 - 14] SAME AS PAIR, NOT REALLY USED
THREE_KIND = 3		# 14*2 + [2 - 14]
STRAIGHT = 4		# 14*3 + [2 - 14] (highest card in straight)
FLUSH = 5			# 14*4 + [2 - 14] (highest card in flush)
FULL_HOUSE = 6		# 14*5 + [2 - 14] (val of the three of a kind)
FOUR_KIND = 7		# 14*6 + [2 - 14]
STRAIGHT_FLUSH = 8	# 14*8 + []
ROYAL_FLUSH = 9

class Hand:
	def __init__(self, cards):
		self.cards = []
		for card in cards:
			self.addCard(card)

	def __str__(self):
		res = str(self.score) + " ["
		for c in self.highcards:
			res += str(c) + ", "
		res += "]"
		return res

	def addCard(self, card):
		self.cards.append(card)

	def setScore(self):
		royal_flush = False
		straight_flush = False
		fours = False
		fullhouse = False
		flush = False
		straight = False
		threes = False
		twopair = False
		pair = False
		
		cards = sorted(self.cards)
		counts = [0]*15
		flush = True
		cursuit = cards[0].suit
		for c in cards:
			counts[c.val] += 1
			flush = c.suit == cursuit and flush

		straight = self.isStraight(counts)
		if straight or flush:
			if straight and flush:
				print "straight flush", cards[0], cards[1], cards[2], cards[3], cards[4]
				straight = False
				flush = False
				straight_flush = True
				self.mainVals = [cards[-1].val]
			elif straight:
				self.mainVals = [cards[-1].val]
			elif flush:
				self.mainVals = [c.val for c in cards][::-1]
			if straight_flush and cards[-1].val == 14:
				straight_flush = False
				royal_flush = True
				# no need to fix mainVals.
				# if you have a royal flush, you win.
			highcards = []
		else:
			pair = False
			threes = False
			for val in xrange(len(counts)):
				count = counts[val]
				if count == 2:
					if pair:
						self.pairsVals.insert(0,val)
						pair = False
						twopair = True
						highcards = [c for c in highcards if not c.val == val]
					elif threes:
						pair = False
						threes = False
						fullhouse = True
						self.mainVals = [self.threesVals, val]
						highcards = []
					else:
						self.pairsVals = [val]
						pair = True
						highcards = [c for c in cards if not c.val == val]
				if count == 3:
					if not pair:
						threes = True
						self.threesVals = [val]
						highcards = [c for c in cards if not c.val == val]
					else:
						pair = False
						threes = False
						fullhouse = True
						self.mainVals = [val, self.pairsVals[0]]
						highcards = []
				if count == 4:
					fours = True
					self.mainVals = [val]
					highcards = [c for c in cards if not c.val == val]
			if threes:
				self.mainVals = self.threesVals
			if pair:
				self.mainVals = self.pairsVals

		if royal_flush:
			self.score = ROYAL_FLUSH
		elif straight_flush:
			self.score = STRAIGHT_FLUSH
		elif fours:
			self.score = FOUR_KIND
		elif fullhouse:
			self.score = FULL_HOUSE
		elif flush:
			self.score = FLUSH
		elif straight:
			self.score = STRAIGHT
		elif threes:
			self.score = THREE_KIND
		elif twopair:
			self.score = TWO_PAIR
		elif pair:
			self.score = PAIR
		else:
			self.score = HIGH_CARD
			highcards = cards
			self.mainVals = []

		self.highcards = highcards[::-1]

		return self.score, self.highcards

	def beats(self, otherHand):
		if self.score > otherHand.score:
			return True
		elif self.score < otherHand.score:
			return False
		else:
			for i in xrange(len(self.mainVals)):
				if self.mainVals[i] > otherHand.mainVals[i]:
					return True
				if self.mainVals[i] < otherHand.mainVals[i]:
					return False
			for i in xrange(len(self.highcards)):
				if self.highcards[i] > otherHand.highcards[i]:
					return True
				if self.highcards[i] < otherHand.highcards[i]:
					return False
		print "tie"
		raise Exception


	def isStraight(self, counts):
		if 1 in counts:
			start = counts.index(1)
			if start < 11:
				for a in range(1,5):
					if not counts[start+a] == 1:
						return False
				return True
		return False


class Card():
	def __init__(self, valsuit):
		self.val = self.getval(valsuit[0])
		self.suit = valsuit[1]
	
	def __str__(self):
		return str(self.val)+ self.suit

	def getval(self, letter):
		facecards = ['T','J', 'Q', 'K', 'A']
		if letter in facecards:
			return facecards.index(letter) + 10
		return int(letter)

	def __eq__(self, o): return self.val == o.val
	def __ne__(self, o): return not self.__eq__(o)
	def __lt__(self, o): return self.val < o.val
	def __le__(self, o): return self.val <= o.val
	def __gt__(self, o): return self.val > o.val
	def __ge__(self, o): return self.val >= o.val

def main():
	count = 0
	f = open('poker.txt')
	lines = f.readlines()
	#lines = ["TD JC JD TC TS 7C 7D AD AD AD"]
	for line in lines:
		cards = [Card(c) for c in line.split()]
		p1 = Hand(cards[:5])
		p1.setScore()
		
		p2 = Hand(cards[5:])
		p2.setScore()
	
		print p1
		print p2
		print
		if p1.beats(p2):
			count += 1
			print "*"
	print "ans =", count

if __name__ == '__main__':
	main()