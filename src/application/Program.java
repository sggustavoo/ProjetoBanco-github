package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Conta;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		Conta cont;
		
		// Inserindo dados do titular da conta
		
		System.out.println("======== SIMULADOR BANCO ========");
		System.out.println();
		System.out.print("Digite o n�mero da conta: ");
		int numero = sc.nextInt();
		System.out.print("Titular: ");
		sc.nextLine();
		String nome = sc.nextLine();
		System.out.print("Senha: ");
		long senha = sc.nextLong();
		System.out.print("Existe um dep�sito inicial?(s/n) ");
		char resp1 = sc.next(). charAt(0);
		
		if (resp1 != 'n') {
			System.out.print("Valor do dep�sito: ");
			double depositoIncial = sc.nextDouble();
			cont = new Conta(numero, nome, senha, depositoIncial);
		}
		else {
			cont = new Conta(numero, nome, senha);
		}
		
		System.out.println();
		System.out.print("Dados da conta:\n" + cont);
		System.out.println();
		
		char resp2;
		
		// Opera��es de dep�sito e saque
		
		do {
			System.out.println();
			System.out.println("======== OPERA��ES ========");
			System.out.println("Digite 1 para fazer dep�sito");
			System.out.println("Digite 2 para fazer saque");
			System.out.print("Informe a opera��o: ");
			int operacao = sc.nextInt();
			
			while (operacao != 1 && operacao != 2) {
				System.out.println("OPERA��O INV�LIDA!");
				System.out.print("Informe a opera��o: ");
				operacao = sc.nextInt();
			}
			
			// Conferindo senha
			
			System.out.print("Senha: ");
			long num = sc.nextLong();
			
			if (conferindoSenha(num, cont)) {
				
				switch (operacao) {
				
				case 1:
					System.out.println();
					System.out.print("Digite o valor do dep�sito: ");
					double deposito = sc.nextDouble();
					cont.deposito(deposito);
					System.out.println("Dados atualizados:\n" + cont);
					break;
					
				case 2:
					System.out.println();
					System.out.print("Digite o valor do saque: ");
					double saque = sc.nextDouble();
					cont.saque(saque);
					System.out.println("Dados atualizados:\n" + cont);
					
				}
			}
			
			else {
				System.out.println("SENHA INV�LIDA!");
			}
			
			System.out.println();
			System.out.print("Deseja realizar outra opera��o?(s/n) ");
			resp2 = sc.next(). charAt(0);
		
		} while (resp2 != 'n');
		
		System.out.println("Obrigado!");
		
		sc.close();
	}
	
	private static boolean conferindoSenha(long num, Conta conta) {
		if (num == conta.getSenha()) {
			return true;
		}
		else {
			return false;
		}
	}
}
