import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class SCChallengeBareBones {
	public static void main(String[] args) {
		SCChallengeBareBones interpreter = new SCChallengeBareBones(args);
	}

	public SCChallengeBareBones(String[] args) {	
		List<String> bareBonesCode = new ArrayList<>();
		String filename;
		if (args.length != 0) {
			filename = args[0];
		} else {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter the file path: ");
				filename = br.readLine();
			} catch (Exception e) {
				e.printStackTrace();
				filename = "";
			} 
		}

		bareBonesCode = readCodeFromFile(filename);
		for (int i = 0; i < bareBonesCode.size(); i++) {
			System.out.println(bareBonesCode.get(i));
		}		

	}

	public List<String> readCodeFromFile(String path) {
		List<String> list = new ArrayList<>();
		File file = new File(path);
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));		
			String line;
			while ((line = reader.readLine()) != null) {
				list.add(line);
			}
			reader.close();
		} catch (Exception e) {
			System.out.println("Error: no file found");
			//e.printStackTrace();
			System.exit(0);
		}
		return list;
	}
}
