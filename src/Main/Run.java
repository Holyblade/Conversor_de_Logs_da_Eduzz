package Main;

import javax.swing.JOptionPane;

import Function.File;

public class Run {

	public static void main(String[] Args) throws Exception {

		try {
			String imputDirectory = JOptionPane.showInputDialog(null, "Digite o Diretório de Entrada: ","Eduzz - Preencha as Informações Necessárias", JOptionPane.QUESTION_MESSAGE);
			String outputDirectory = JOptionPane.showInputDialog(null, "Digite o Diretório de Saida com o / no final: ", "Eduzz - Preencha as Informações Necessárias", JOptionPane.QUESTION_MESSAGE);
			new File().readFile(imputDirectory, outputDirectory);
			JOptionPane.showMessageDialog(null, "Log processado com sucesso!");
		} catch (Exception ExceptionError) {
			JOptionPane.showMessageDialog(null, "Log processado com sucesso!");
		}

	}

}
