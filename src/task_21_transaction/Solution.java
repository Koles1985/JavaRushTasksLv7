package task_21_transaction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static List<String> allLines = new ArrayList<String>();
	public static List<String> forRemoveLines = new ArrayList<>();
	
	
	public Solution() {
		try {
			joinData();
		}catch(CorruptedDataException e) {
			e.printStackTrace();
		}
	}
	
	public void joinData() throws CorruptedDataException {
		String[] paths = getPathsToFiles(2);
		try (BufferedReader reader = null){
			readFiles(paths[0], allLines, reader);
			readFiles(paths[1], forRemoveLines, reader);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		removeAll(allLines, forRemoveLines);
		System.out.println(allLines);
		
	}
	
	private String[] getPathsToFiles(int numbersOfFilePaths) {
		String[] path = new String[numbersOfFilePaths];
		try(Scanner scanner = new Scanner(System.in)) {
			for(int i = 0; i < path.length; i++) {
				path[i] = scanner.nextLine();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		
		return path;
	}
	
	@SuppressWarnings("resource")
	private void readFiles(String srcPath, List<String> file, 
			BufferedReader reader)throws IOException{
	
		reader = new BufferedReader(new FileReader(srcPath));
		while(reader.ready()) {
			file.add(reader.readLine());
		}
		reader.close();
		
		System.out.println(file.toString());
		
	}
	
	private void removeAll(List<String> cell, List<String> dst) 
			throws CorruptedDataException {
		if(cell.containsAll(dst)) {
			cell.removeAll(dst);
		}else {
			cell.clear();
			throw new CorruptedDataException();
		}
	}

}

























