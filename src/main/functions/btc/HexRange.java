package main.functions.btc;

import java.math.BigInteger;

public class HexRange {
	private rangeData data;
	public int bits;
	public BigInteger start;
	public BigInteger end;

	public HexRange() {
		data = new rangeData();
	}

	public HexRange(int bits, String startHex, String endHex) {
		this.bits = bits;
		this.start = new BigInteger(startHex, 16);
		this.end = new BigInteger(endHex, 16);
	}

	public int getBits() {
		return bits;
	}

	public BigInteger getStartHex() {
		return start;
	}

	public BigInteger getEndHex() {
		return end;
	}

	// Método para encontrar o range na matriz correspondente ao número de bits especificado.
	public HexRange findRangeByBits(int bits) {
		for (HexRange range : data.ranges) {
			if (range.getBits() == bits) {
				this.start = range.getStartHex();
				this.end = range.getEndHex();
				return range;
			}
		}
		throw new IllegalArgumentException("Range não encontrado para " + bits + " bits.");
	}

	// Método para converter um BigInteger em uma string hexadecimal
	public String toHexString(BigInteger value) {
		return value.toString(16);
	}

	// Método para gerar um valor aleatório dentro da faixa
	public String getRandomHex(BigInteger start, BigInteger end) {
		BigInteger range = end.subtract(start).add(BigInteger.ONE);
		BigInteger randomValue = new BigInteger(range.bitLength(), new java.security.SecureRandom());
		return start.add(randomValue.mod(range)).toString(16); // Retorna o valor em hexadecimal
	}

	// Método para gerar um número decimal aleatório dentro do range
	public String getRandomDecimal(BigInteger start, BigInteger end) {
		BigInteger range = end.subtract(start).add(BigInteger.ONE);
		BigInteger randomValue = new BigInteger(range.bitLength(), new java.security.SecureRandom());
		return start.add(randomValue.mod(range)).toString(); // Retorna o valor em decimal
	}

	// Método para percorrer a faixa sequencialmente
	public void generateSequentially() {
		BigInteger current = start;
		while (current.compareTo(end) <= 0) {
			System.out.print(" " + current.toString(16));
			current = current.add(BigInteger.ONE);
		}
	}
}