package Main;

import java.io.File;

public class Organizer  {
	
	public void organizeFile(String path) {
		
		File directory = new File(path);
		if(!directory.isDirectory()) {
			System.out.println("The path is not valid");
			return;
		}
		
		File[] files= directory.listFiles();
		if(files==null) {
			System.out.println ("The directory is empty or cannot be read");
			return;
		}
		for(File file: files) {
			if(file.isFile()) {
			String fileName = file.getName();
			String fileExtension = getFileExtension(fileName);
			System.out.println(fileName);
			}
		}
	}
	
	private String getFileExtension(String fileName) {
		int lastIndexDot = fileName.lastIndexOf(".");
		if(lastIndexDot == -1 || lastIndexDot == fileName.length()-1) {
			return"";
		}
		return fileName.substring(lastIndexDot+1).toLowerCase();
	}
}
