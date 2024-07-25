package Main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

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
			if(!fileExtension.isEmpty()) {
				moveToDirectory(file, fileExtension);
			}
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
	
	private void moveToDirectory(File file, String directoryName) {
		Path sourcePath = file.toPath();
		Path targetDirectroy = sourcePath.getParent().resolve(directoryName);
		
		try {
			if(!Files.exists(targetDirectroy)) {
				Files.createDirectories(targetDirectroy);
			}
			
			Path targetPath = targetDirectroy.resolve(file.getName());
			Files.move(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Move file : "+file.getName()+" to "+directoryName+" Directory.");
		} catch (IOException e) {
			System.err.println("Error moving file :"+ file.getName());
			e.printStackTrace();
		}
	}
}
