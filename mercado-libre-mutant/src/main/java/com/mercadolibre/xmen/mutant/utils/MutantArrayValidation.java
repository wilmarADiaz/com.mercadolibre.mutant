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
			secuence = numSecuencesDiagonalHighRightLeft(dna);
			break;
		case 6:
			secuence = numSecuencesDiagonalLowRightLeft(dna);
			break;
		case 7:
			secuence = numSecuencesDiagonalHighLeftRight(dna);
			break;
		case 8:
			secuence = numSecuencesDiagonalLowLeftRight(dna);
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
				if(protein == init) {
					protein = dna.get(i).charAt(j);
					proteinNum ++;
				}else if(protein == dna.get(i).charAt(j)) {
					proteinNum ++;
				}else {
					protein = init;
					proteinNum = 0;
				}
				
			}
			if(proteinNum >= numMaxProtein) {
				secuence++;
			}
		}
		return secuence;
		
	}
	public static int numSecuencesVertical(List<String> dna, int initI, int intitJ, int endI, int endJ) {
		char protein = init;
		int proteinNum = 0;
		int secuence = 0;
		for(int j=intitJ; j<endJ && secuence < numMaxSecuences; j++) {			
			for(int i=initI; i<endI &&  proteinNum < numMaxProtein; i++) {				
				if(protein == init) {
					protein = dna.get(i).charAt(j);
					proteinNum ++;
				}else if(protein == dna.get(i).charAt(j)) {
					proteinNum ++;
				}else {
					protein = init;
					proteinNum = 0;
				}
				
			}
			if(proteinNum >= numMaxProtein) {
				secuence++;
			}
		}
		return secuence;
	}
	
	public static int numSecuencesDiagonalHighRightLeft(List<String> dna) {
		char protein = init;
		int proteinNum = 0;
		int secuence = 0;
		for (int i=0;i<dna.size() && secuence < numMaxSecuences;i++) {
			for (int j=0;j<=i && proteinNum < numMaxProtein; j++) {
				if(protein == init) {
					protein = dna.get(j).charAt((dna.size()-1-i)+j);
					proteinNum ++;
				}else if(protein == dna.get(j).charAt((dna.size()-1-i)+j)) {
					proteinNum ++;
				}else {
					protein = init;
					proteinNum = 0;
				}
				
			}
			if(proteinNum >= numMaxProtein) {
				secuence++;
			}

		}
		return secuence;
	}
	
	public static int numSecuencesDiagonalLowRightLeft(List<String> dna) {
		char protein = init;
		int proteinNum = 0;
		int secuence = 0;
		for (int i=0;i<dna.size()-1 && secuence < numMaxSecuences; i++) {
			for (int j=0;j<dna.size()-i-1 && proteinNum < numMaxProtein; j++) {
				if(protein == init) {
					protein = dna.get(j+i+1).charAt(j);
					proteinNum ++;
				}else if(protein == dna.get(j+i+1).charAt(j)) {
					proteinNum ++;
				}else {
					protein = init;
					proteinNum = 0;
				}
			}
			if(proteinNum >= numMaxProtein) {
				secuence++;
			}
		}
		return secuence;
	}
	
	public static int numSecuencesDiagonalHighLeftRight(List<String> dna) {
		char protein = init;
		int proteinNum = 0;
		int secuence = 0;
		for (int i=0;i<dna.size() && secuence < numMaxSecuences;i++) {
			for (int j=0;j<=i && proteinNum < numMaxProtein; j++) {
				if(protein == init) {
					protein = dna.get(i-j).charAt(i);
					proteinNum ++;
				}else if(protein == dna.get(i-j).charAt(i)) {
					proteinNum ++;
				}else {
					protein = init;
					proteinNum = 0;
				}
				
			}
			if(proteinNum >= numMaxProtein) {
				secuence++;
			}

		}
		return secuence;
	}
	
	public static int numSecuencesDiagonalLowLeftRight(List<String> dna) {
		char protein = init;
		int proteinNum = 0;
		int secuence = 0;
		for (int i=0;i<dna.size() && secuence < numMaxSecuences;i++) {
			for (int j=0;j<dna.size()-i-1 && proteinNum < numMaxProtein;j++) {
				if(protein == init) {
					protein = dna.get(dna.size()-j-1).charAt(j+i+1);
					proteinNum ++;
				}else if(protein == dna.get(dna.size()-j-1).charAt(j+i+1)) {
					proteinNum ++;
				}else {
					protein = init;
					proteinNum = 0;
				}
			}
			if(proteinNum >= numMaxProtein) {
				secuence++;
			}
		}
		return secuence;
	}
	
	
	
	
}
