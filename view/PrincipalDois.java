package view;
import javax.swing.JOptionPane;
import controller.KillController;

public class PrincipalDois {

	public static void main(String[] args) {
	
		KillController ki = new KillController();
		int opc = 0;
		while(opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Escolha:\n1 - Lista de Processos\n2 - Mata Processo PID\n3 - Mata Processo NOME\n9 - FIM"));
			switch(opc) {
			//Mostrar Lista de Processos
			case 1:
			ki.ListaProcessos("TASKLIST /FO TABLE");
			break;
			//Mata Processo PID
			case 2: 
			ki.mataPid("");//Com o Processo aberto, encontre e digite o PID aqui
			break;
			case 3:
		    //Mata Processo Nome
			ki.mataNome("cmd.exe");
			break;
			case 9:JOptionPane.showMessageDialog(null, "FIM");
			break;
			default:JOptionPane.showMessageDialog(null, "Escolha uma opção Válida");
			}
		}
	}

}
