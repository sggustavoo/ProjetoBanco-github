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
		System.out.print("Digite o número da conta: ");
		int numero = sc.nextInt();
		System.out.print("Titular: ");
		sc.nextLine();
		String nome = sc.nextLine();
		System.out.print("Senha: ");
		long senha = sc.nextLong();
		System.out.print("Existe um depósito inicial?(s/n) ");
		char resp1 = sc.next(). charAt(0);
		
		if (resp1 != 'n') {
			System.out.print("Valor do depósito: ");
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
		
		// Operações de depósito e saque
		
		do {
			System.out.println();
			System.out.println("======== OPERAÇÕES ========");
			System.out.println("Digite 1 para fazer depósito");
			System.out.println("Digite 2 para fazer saque");
			System.out.print("Informe a operação: ");
			int operacao = sc.nextInt();
			
			while (operacao != 1 && operacao != 2) {
				System.out.println("OPERAÇÃO INVÁLIDA!");
				System.out.print("Informe a operação: ");
				operacao = sc.nextInt();
			}
			
			// Conferindo senha
			
			System.out.print("Senha: ");
			long num = sc.nextLong();
			
			if (conferindoSenha(num, cont)) {
				
				switch (operacao) {
				
				case 1:
					System.out.println();
					System.out.print("Digite o valor do depósito: ");
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
				System.out.println("SENHA INVÁLIDA!");
			}
			
			System.out.println();
			System.out.print("Deseja realizar outra operação?(s/n) ");
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
