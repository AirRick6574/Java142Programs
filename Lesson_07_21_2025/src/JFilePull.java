import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class JFilePull {
	public static void main(String[] args) throws FileNotFoundException {
		JFileChooser chooser = new JFileChooser(); //JFileChooser Allows file to be chosen and returns a file path once chosen
		chooser.showOpenDialog(null); //Pops up an "Open File" file chooser dialog. Note that the text that appears in the approve button is determined by the L&F.
		Scanner scanner = new Scanner(chooser.getSelectedFile()); 
		
		//Returns the selected file. This can be set either by the programmer via setSelectedFile or by a user action, 
		//such as either typing the filename into the UI or selecting the file from a list in the UI.
		
		
		// Once we open the file, we have to read the size of the window because it’sthe first thing in the file:
		int width = scanner.nextInt();
		int height = scanner.nextInt();
		
		System.out.println(width);
		System.out.println(height);

	}
}
