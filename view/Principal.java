package view;
import javax.swing.JOptionPane;

import controller.RedesController;

public class Principal {

	public static void main(String[] args) {
		
		RedesController proc = new RedesController();
		int opc = 0;
		while(opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Escolha:\n1 - Exibir IP\n2 - Exibir Ping\n9 - FIM "));
			switch(opc) {

			//Exericio 01
			case 1:
                String processIP = "IPCONFIG";
                proc.ip(processIP);
			 break;

			//Exercício 02
			case 2: 
                String processPing = "PING -4 -n 10 www.google.com.br";
                proc.ping(processPing);
			 break;

             //Encerra Programa
			case 9:JOptionPane.showMessageDialog(null, "Programa Encerrado!");
			break;

            //Exibe mensagem de entrada errada
			default: JOptionPane.showMessageDialog(null, "Opção Inválida! Escolha uma opção válida.");
	        
            }
		}

    }
}
