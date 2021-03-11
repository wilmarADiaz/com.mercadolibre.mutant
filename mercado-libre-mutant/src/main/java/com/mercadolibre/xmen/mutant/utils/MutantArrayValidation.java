package com.mercadolibre.xmen.mutant.utils;

import java.util.List;

public class MutantArrayValidation {
	private static int numMaxSecuences = 2;
	private static int numMaxProtein = 4;
	private static char init = '-';
	
	public static int validateArray(List<String> dna, int tipo) {
		int secuence = 0;
		switch (tipo) {
		case 1:
			secuence = numSecuencesVerticalLeft(dna);
			break;
		case 2:
			secuence = numSecuencesVerticalRight(dna);
			break;
		case 3:
			secuence = numSecuencesHorizontalAbove(dna);
			break;
		case 4:
			secuence = numSecuencesHorizontalBelow(dna);
			break;
		case 5:
			secuence = numSecuencesDiagonalAboveRightLeft(dna);
			break;
		case 6:
			secuence = numSecuencesDiagonalBelowRightLeft(dna);
			break;
		case 7:
			secuence = numSecuencesDiagonalAboveLeftRight(dna);
			break;
		case 8:
			secuence = numSecuencesDiagonalBelowLeftRight(dna);
			break;	
			
		default:
			break;
		}
		return secuence;
	}
	
	public static int numSecuencesHorizontalAbove(List<String> dna) {
		int dnaLenght = dna.size();
		int secuence = 0;
		if((dnaLenght%2)==0) {
			int end = dnaLenght/2;
			secuence = numSecuencesHorizontal(dna, 0, 0, end, dna.size());
		}else {
			int end = dnaLenght/2;
			secuence = numSecuencesHorizontal(dna, 0, 0, end +1, dna.size());
		}
		return secuence;
	}
	
	public static int numSecuencesHorizontalBelow(List<String> dna) {
		int dnaLenght = dna.size();
		int secuence = 0;
		if((dnaLenght%2)==0) {
			int end = dnaLenght/2;
			secuence = numSecuencesHorizontal(dna, end, 0, dna.size(), dna.size());
		}else {
			int end = dnaLenght/2;
			secuence = numSecuencesHorizontal(dna, end +1, 0, dna.size(), dna.size());
		}
		return secuence;
	}
	
	public static int numSecuencesVerticalLeft(List<String> dna) {
		int dnaLenght = dna.size();
		int secuence = 0;
		if((dnaLenght%2)==0) {
			int end = dnaLenght/2;
			secuence = numSecuencesVertical(dna, 0, 0, dna.size(), end);
		}else {
			int end = dnaLenght/2;
			secuence = numSecuencesVertical(dna, 0, 0, dna.size(), end +1);
		}
		return secuence;
	}
	
	public static int numSecuencesVerticalRight(List<String> dna) {
		int dnaLenght = dna.size();
		int secuence = 0;
		if((dnaLenght%2)==0) {
			int end = dnaLenght/2;
			secuence = numSecuencesVertical(dna, 0, end, dna.size(), dna.size());
		}else {
			int end = dnaLenght/2;
			secuence = numSecuencesVertical(dna, 0, end +1, dna.size(), dna.size());
		}
		return secuence;
	}
	
	public static int numSecuencesHorizontal(List<String> dna, int initI, int initJ, int endI, int endJ) {
		char protein = init;
		int proteinNum = 0;
		int secuence = 0;
		for(int i=initI; i<endI && secuence < numMaxSecuences; i++) {
			for(int j=initJ; j<endJ && proteinNum < numMaxProtein; j++) {				
				if(protein == dna.get(i).charAt(j)) {
					proteinNum ++;
				}else {
					protein = dna.get(i).charAt(j);
					proteinNum = 1;
				}
			}
			if(proteinNum >= numMaxProtein) {
				secuence++;
			}
			protein = init;
			proteinNum = 0;
		}
		return secuence;
		
	}
	public static int numSecuencesVertical(List<String> dna, int initI, int intitJ, int endI, int endJ) {
		char protein = init;
		int proteinNum = 0;
		int secuence = 0;
		for(int j=intitJ; j<endJ && secuence < numMaxSecuences; j++) {			
			for(int i=initI; i<endI &&  proteinNum < numMaxProtein; i++) {				
				if(protein == dna.get(i).charAt(j)) {
					proteinNum ++;
				}else {
					protein = dna.get(i).charAt(j);
					proteinNum = 1;
				}
				
			}
			if(proteinNum >= numMaxProtein) {
				secuence++;
			}
			protein = init;
			proteinNum = 0;
		}
		return secuence;
	}
	/**
	 * Validation diagonal \
	 * @param dna
	 * @return
	 */
	public static int numSecuencesDiagonalAboveRightLeft(List<String> dna) {
		char protein = init;
		int proteinNum = 0;
		int secuence = 0;
		for (int i=0;i<dna.size() && secuence < numMaxSecuences;i++) {
			for (int j=0;j<=i && proteinNum < numMaxProtein; j++) {
				if(protein == dna.get(j).charAt((dna.size()-1-i)+j)) {
					proteinNum ++;
				}else {
					protein = dna.get(j).charAt((dna.size()-1-i)+j);
					proteinNum = 1;
				}
			}
			if(proteinNum >= numMaxProtein) {
				secuence++;
			}
			protein = init;
			proteinNum = 0;

		}
		return secuence;
	}
	
	/**
	 * Validation diagonal \
	 * @param dna
	 * @return
	 */
	public static int numSecuencesDiagonalBelowRightLeft(List<String> dna) {
		char protein = init;
		int proteinNum = 0;
		int secuence = 0;
		for (int i=0;i<dna.size()-1 && secuence < numMaxSecuences; i++) {
			for (int j=0;j<dna.size()-i-1 && proteinNum < numMaxProtein; j++) {				
				if(protein == dna.get(j+i+1).charAt(j)) {
					proteinNum ++;
				}else {
					protein = dna.get(j+i+1).charAt(j);
					proteinNum = 1;
				}				
			}
			if(proteinNum >= numMaxProtein) {
				secuence++;
			}
			protein = init;
			proteinNum = 0;
		}
		return secuence;
	}
	
	/**
	 * Validation diagonal /
	 * @param dna
	 * @return
	 */
	public static int numSecuencesDiagonalAboveLeftRight(List<String> dna) {
		char protein = init;
		int proteinNum = 0;
		int secuence = 0;
		for (int i=0;i<dna.size() && secuence < numMaxSecuences;i++) {
			for (int j=0;j<=i && proteinNum < numMaxProtein; j++) {				
				if(protein == dna.get(i-j).charAt(j)) {
					proteinNum ++;
				}else {
					protein = dna.get(i-j).charAt(j);
					proteinNum = 1;
				}
			}
			if(proteinNum >= numMaxProtein) {
				secuence++;
			}
			protein = init;
			proteinNum = 0;
		}
		return secuence;
	}
	
	public static int numSecuencesDiagonalBelowLeftRight(List<String> dna) {
		char protein = init;
		int proteinNum = 0;
		int secuence = 0;
		for (int i=0;i<dna.size() && secuence < numMaxSecuences;i++) {
			for (int j=0;j<dna.size()-i-1 && proteinNum < numMaxProtein;j++) {
				if(protein == dna.get(dna.size()-j-1).charAt(j+i+1)) {
					proteinNum ++;
				}else {
					protein = dna.get(dna.size()-j-1).charAt(j+i+1);
					proteinNum = 1;
				}
			}
			if(proteinNum >= numMaxProtein) {
				secuence++;
			}
			protein = init;
			proteinNum = 0;
		}
		return secuence;
	}
	
	
	
	
}
