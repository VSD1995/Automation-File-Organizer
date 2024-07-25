package Main;

import java.util.Scanner;

public class FileOrganizer {

	public static void main(String[] args) {
		
		System.out.println("Enter your path");
		
		Scanner sc = new Scanner(System.in);
		String path = sc.nextLine();
		
		Organizer orgPath = new Organizer();
		orgPath.organizeFile(path);
	}

}
