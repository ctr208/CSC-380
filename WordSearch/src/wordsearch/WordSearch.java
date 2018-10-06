package wordsearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;







public class WordSearch {
	private String[][] puzzleArray;
	private ArrayList<String> wordsList = new ArrayList<String>();
	private int numCols;
	private int numRows;

	
	public static void main(String[] args) {		
		new WordSearch();
	}

	public WordSearch() {
		wordsList = readWords("Resources/Words");
		

		getDemensions("Resources/Puzzle");
		createPuzzleMatrix("Resources/Puzzle");
		
		
		print();
	}

	private void createPuzzleMatrix(String fileName) {
		this.puzzleArray = new String[numRows][numCols];
		Scanner input = null;
		try {
			input = new Scanner(new File(fileName), "UTF-8");
		} catch (FileNotFoundException e) {
			System.out.println("No file found");
		}
		while (input.hasNext()) {
			for (int row = 0; row < puzzleArray.length; row++) {
				for (int col = 0; col < puzzleArray[row].length; col++) {
					String x = input.next();
					puzzleArray[row][col] = x;
				}
			}

		}
		
		
		
	}

	private ArrayList<String> readWords(String fileName) {
		Scanner input = null;
		try {
			input = new Scanner(new File(fileName), "UTF-8");
		} catch (FileNotFoundException e) {
			System.out.println("No file found");
		}
		String currentWord;
		
		while (input.hasNextLine()) {
			currentWord = input.next().trim();
			wordsList.add(currentWord);
		}
		
		input.close();
		
		return wordsList;
		
	}

	
	public void getDemensions(String fileName) {
		Scanner input = null;
		int numRow = 0;
		int numCol = 0;
		
		try {
			input = new Scanner(new File(fileName), "UTF-8");
		} catch (FileNotFoundException e) {
			System.out.println("No file found");
		}
		
		String line = input.nextLine().trim();
		line= line.replace("	", "");
		
		numCol= line.length();
		
		this.numCols = numCol;
		input.close();

		try {
			input = new Scanner(new File(fileName), "UTF-8");
		} catch (FileNotFoundException e) {
			System.out.println("No file found");
		}
		while (input.hasNextLine() == true) {
			numRow++;
			input.nextLine().trim();

		}
		this.numRows = numRow;
		input.close();
	}


	public void print() {
		System.out.println(numRows + "x" + numCols + " Matrix");
		String arrayString = "";

		for (int row = 0; row < puzzleArray.length; row++) {
			for (int col = 0; col < puzzleArray[row].length; col++) {
				String y = String.valueOf(puzzleArray[row][col] + " ");
				arrayString = arrayString.concat(y);
			}
			arrayString.trim();
			arrayString = arrayString.concat("\n");
		}

		System.out.println(arrayString);
	}
}
