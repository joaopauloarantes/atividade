package apresentacao;

import negocio.Conta;
import negocio.ContaService;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private ContaService contaService;

    public Menu() {
        this.contaService = new ContaService();
    }

    public void exibirMenu() {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("=== Sistema Bancário ===");
            System.out.println("1. Adicionar Conta");
            System.out.println("2. Listar Contas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // Limpa buffer

            switch (opcao) {
                case 1:
                    System.out.print("Titular: ");
                    String titular = sc.nextLine();
                    System.out.print("Saldo inicial: ");
                    double saldo = sc.nextDouble();
                    contaService.adicionarConta(titular, saldo);
                    System.out.println("Conta adicionada!");
                    break;

                case 2:
                    List<Conta> contas = contaService.listarContas();
                    contas.forEach(c -> System.out.println(
                        "ID: " + c.getId() +
                        ", Titular: " + c.getTitular() +
                        ", Saldo: " + c.getSaldo()));
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}
