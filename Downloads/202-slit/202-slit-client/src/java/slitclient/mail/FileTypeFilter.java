package slitclient.mail;

import java.io.File;
import javax.swing.filechooser.FileFilter;
/**
 * Hentet fra http://www.codejava.net/java-se/swing/file-picker-component-in-swing
 * @author www.codejava.net
 * 
 * Et filetypefilter som brukes av JFileChooser for å laste opp filer.
 */
public class FileTypeFilter extends FileFilter {

	private String extension;
	private String description;
	
	public FileTypeFilter(String extension, String description) {
		this.extension = extension;
		this.description = description;
	}
	
	@Override
	public boolean accept(File file) {
		if (file.isDirectory()) {
			return true;
		}
		return file.getName().toLowerCase().endsWith(extension);
	}
	
	public String getDescription() {
		return description + String.format(" (*%s)", extension);
	}
}
