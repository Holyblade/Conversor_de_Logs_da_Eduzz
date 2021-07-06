package Function;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.Scanner;

public class File {

	public String Sobrenome;

	public void readFile(String File, String OutputDirectory) throws Exception {
		BufferedReader Buffer = new BufferedReader(new InputStreamReader(new FileInputStream(File), "UTF-8"));
		String Line = Buffer.readLine();
		while (Line != null) {
			Line = Buffer.readLine();
			Scanner helperScanner = new Scanner(Line);
			helperScanner.useDelimiter(";");
			int usableData = 0;
			while (helperScanner.hasNext()) {
				String WritingData = helperScanner.next();
				if (usableData == 18) {
					helperScanner.next();
					helperScanner.next();
					helperScanner.next();
					helperScanner.next();
					helperScanner.next();
					helperScanner.next();
					helperScanner.next();
					helperScanner.next();
					helperScanner.next();
					helperScanner.next();
					WritingData = WritingData.replaceAll(",", ".");
					String AuxNome = helperScanner.next();
					Scanner ScanName = new Scanner(AuxNome);
					ScanName.useDelimiter(" ");
					String Nome = ScanName.next();
					try {
						Sobrenome = ScanName.next();
						while (ScanName.hasNext()) {
							Sobrenome = Sobrenome + " " + ScanName.next();
						}
					} catch (Exception Ex) {
						Sobrenome = "SemSobrenome";
					}
					ScanName.close();
					String Email = helperScanner.next();
					String Telefone = helperScanner.next();
					String textToWritePreFormated = WritingData + "," + Nome + "," + Sobrenome + "," + Email + ","
							+ Telefone;
					String variableForFormat = Character.toString('"');
					String textToWriteFormated = textToWritePreFormated.replaceAll(variableForFormat, "");
					writeFile(textToWriteFormated, OutputDirectory);
					usableData = 35;
				}
				usableData++;
			}
			helperScanner.close();
		}
		Buffer.close();
	}

	public void writeFile(String Line, String OutputDirectory) throws IOException {
		Writer File = new BufferedWriter(new FileWriter(OutputDirectory + "Compradores_Eduzz.txt", true));
		File.append(Line + "\n");
		File.close();
	}

}
