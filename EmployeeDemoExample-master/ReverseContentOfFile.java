import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class ReverseContentOfFile {
	
	public static void main(String[] args) {
		String str="";
		Reader reader = null;
		Writer writer = null;
		try {
			reader = new FileReader("file.txt");
			int data = reader.read();
			while(data!=-1) {
				char ch=(char) reader.read();
				str+=ch;
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		StringBuffer sb = new StringBuffer(str);
		str = sb.reverse().toString();
		try {
			writer = new FileWriter("file.txt");
			writer.write(str);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
