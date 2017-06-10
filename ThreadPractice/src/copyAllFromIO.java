import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class copyAllFromIO extends Thread {

	public void fillQueue() throws IOException {

		Queue<String> queueA = new LinkedList<String>();

		for (int i = 1; i <= 10; i++) {
			File getListOfFiles = new File("c://temp//dir2/" + i);
			File[] filesList = getListOfFiles.listFiles();
			for (File dir : filesList) {
				File getNextFiles = new File(dir.getAbsolutePath() + "//");
				File[] NextfilesList = getNextFiles.listFiles();
				for (File txtFile : NextfilesList) {
					queueA.add(txtFile.getAbsolutePath());
				}
			}
		}
		for (Object file : queueA) {

			FileReader fr = new FileReader((String) file);
			BufferedReader bufr = new BufferedReader(fr);

			FileWriter fw = new FileWriter("super.txt", true);
			BufferedWriter bufwr = new BufferedWriter(fw);

			String st = "";
			while ((st = bufr.readLine()) != null) {
				bufwr.write(st);
				bufwr.newLine();
			}
			bufr.close();
			bufwr.close();
		}

	}

	public void run() {
		try {
			fillQueue();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
