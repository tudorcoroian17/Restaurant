package data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

	public File myObj;
	public FileWriter myWriter;
	private int lines = 0;
	private String dataWritten[];
	
	public WriteFile(String fileName) throws IOException {
		this.myObj = new  File (fileName);
		if(!this.myObj.exists()) {
			this.myObj.createNewFile();
		}
		this.myWriter = new FileWriter(myObj.getName());
		this.dataWritten = new String[20];
	}
	
	public void write() throws IOException {
		int i = 0;
		while (i < lines) {
			myWriter.write(getDataWritten(i) + "\n");
			i++;
		}
	}
	
	public String getDataWritten(int index) {
		return this.dataWritten[index];
	}
	public void setDataWritten(String[] dataWritten) {
		this.dataWritten = dataWritten;
	}

	public int getLines() {
		return lines;
	}

	public void setLines(int lines) {
		this.lines = lines;
	}
}
