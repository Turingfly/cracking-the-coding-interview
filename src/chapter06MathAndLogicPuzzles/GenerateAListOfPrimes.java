package chapter06MathAndLogicPuzzles;

/**
 * 
 * Solution: We cross off all numbers divisible by 2. Then, we look for the next
 * prime(the next non-crossed off number) and cross off all numbers divisible by
 * it.
 *
 */
public class GenerateAListOfPrimes {
	public boolean[] sieveOfEratosthenes(int max) {
		boolean[] flags = new boolean[max + 1];
		for (int i = 0; i <= max; i++) {
			flags[i] = true;
		}
		int prime = 2;
		while (prime <= Math.sqrt(max)) {
			crossOff(flags, prime);
			prime = getNextPrime(flags, prime);
		}
		return flags;
	}

	private void crossOff(boolean[] flags, int prime) {
		// 4, 6, 8..
		// 9, 12, 15...
		for (int i = prime * prime; i < flags.length; i += prime) {
			flags[i] = false;
		}
	}

	private int getNextPrime(boolean[] flags, int prime) {
		int next = prime + 1;
		while (next < flags.length && !flags[next]) {
			next++;
		}
		return next;
	}
}
