/* Exercicio 02 - Semana 02 - Sistemas Operacionais I
Professor Leandro Colevati - 3º ADS Noite/2023
 */


package controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {
	
	public KillController() {
		super();
	}
	//Método Nome do SO
	private String os() {
		String os = System.getProperty("os.name");
		return os;
	}
	//Método Lista de Processos
	public void ListaProcessos(String process) {
		os();
		if(os().contains("Windows")) {
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
		}
			}catch(Exception er) {
				String msgerro = er.getMessage();
				System.err.println(msgerro);
			}
		      }else {
				process = "ps -ef";
				try {
					Process p = Runtime.getRuntime().exec(process);
					InputStream fluxo = p.getInputStream();
					InputStreamReader leitor = new InputStreamReader(fluxo);
					BufferedReader buffer = new BufferedReader(leitor);
					String linha = buffer.readLine();
					while(linha != null) {
						System.out.println(linha);
						linha = buffer.readLine();
				}
					}catch(Exception er) {
						String msgerro = er.getMessage();
						System.err.println(msgerro);
					}
				
			}

     }
	//Ativa Processo
	private void AtivaProcesso(String process) {
		try {
			Runtime.getRuntime().exec(process);
		}catch(Exception er) {
			String Msgerr = er.getMessage();
			System.err.println(Msgerr);
		}
	}
	//Mata Processo pelo PID
	public void mataPid(String param) {
		os();
		if(os().contains("Windows")) {
		String MatPid = "TASKKILL /PID";
		int pid = 0;
		StringBuffer buffer = new StringBuffer();
		 try {
		   pid = Integer.parseInt(param);
		   buffer.append(MatPid);
		   buffer.append(" ");
		   buffer.append(pid);
       }catch(NumberFormatException er) {
    	   String MsgErro = er.getMessage();
    	   System.err.println();
       } 
		AtivaProcesso(buffer.toString());
		 }else {
			 String MatPid = "kill -9";
				int pid = 0;
				StringBuffer buffer = new StringBuffer();
				 try {
				   pid = Integer.parseInt(param);
				   buffer.append(MatPid);
				   buffer.append(" ");
				   buffer.append(pid);
		       }catch(NumberFormatException er) {
		    	   String MsgErro = er.getMessage();
		    	   System.err.println();
		       } 
				 AtivaProcesso(buffer.toString());
				 }
			 
   }
	//Mata Processo pelo NOME
	public void mataNome(String param) {
		os();
		if(os().contains("Windows")) {
		String MatNome = "TASKKILL /IM";
		StringBuffer buffer = new StringBuffer();
		 try {
		   buffer.append(MatNome);
		   buffer.append(" ");
		   buffer.append(param);
       }catch(NumberFormatException er) {
    	   String MsgErro = er.getMessage();
    	   System.err.println();
       } 
		 AtivaProcesso(buffer.toString());
		}else {
			String MatNome = "pkill -f";
			StringBuffer buffer = new StringBuffer();
			 try {
			   buffer.append(MatNome);
			   buffer.append(" ");
			   buffer.append(param);
	       }catch(NumberFormatException er) {
	    	   String MsgErro = er.getMessage();
	    	   System.err.println();
	       } 
			 AtivaProcesso(buffer.toString());
			}
			
		}

}