package fag;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aula03 {

    static class Venda {
        int quantidade;
        double valorVenda;
        double desconto;

        public Venda(int quantidade, double valorVenda, double desconto) {
            this.quantidade = quantidade;
            this.valorVenda = valorVenda;
            this.desconto = desconto;
        }

        @Override
        public String toString() {
            return "Quantidade: " + quantidade +
                   ", Valor Venda: R$ " + valorVenda +
                   ", Desconto Aplicado: R$ " + desconto;
        }
    }

    static List<Venda> registrosVendas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Registrar Venda");
            System.out.println("[4] - Exibir Registro de Vendas");
            System.out.println("[5] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    calcularPrecoTotal(scanner);
                    break;
                case 2:
                    calcularTroco(scanner);
                    break;
                case 3:
                    registrarVenda(scanner);
                    break;
                case 4:
                    exibirRegistroDeVendas();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    public static void calcularPrecoTotal(Scanner scanner) {
        System.out.println("Quantas plantas foram vendidas?");
        int quantidade = scanner.nextInt();

        System.out.println("Qual o valor unitário da planta?");
        double precoUnitario = scanner.nextDouble();

        double precoTotal = quantidade * precoUnitario;

        double desconto = 0;
        if (quantidade > 10) {
            desconto = precoTotal * 0.05;
            precoTotal -= desconto;
        }

        System.out.println("O preço total da venda é: R$ " + precoTotal);
        System.out.println("Desconto aplicado: R$ " + desconto);
    }

    public static void calcularTroco(Scanner scanner) {
        System.out.println("Digite o valor total da compra:");
        double totalCompra = scanner.nextDouble();

        System.out.println("Digite o valor recebido pelo cliente:");
        double valorRecebido = scanner.nextDouble();

        if (valorRecebido < totalCompra) {
            System.out.println("Valor insuficiente! O cliente precisa pagar mais R$ " + (totalCompra - valorRecebido));
        } else {
            double troco = valorRecebido - totalCompra;
            System.out.println("O troco ao cliente é: R$ " + troco);
        }
    }

    public static void registrarVenda(Scanner scanner) {
        System.out.println("Quantas plantas foram vendidas?");
        int quantidade = scanner.nextInt();

        System.out.println("Qual o valor unitário da planta?");
        double precoUnitario = scanner.nextDouble();

        double precoTotal = quantidade * precoUnitario;

        double desconto = 0;
        if (quantidade > 10) {
            desconto = precoTotal * 0.05;
            precoTotal -= desconto;
        }

        registrosVendas.add(new Venda(quantidade, precoTotal, desconto));
        System.out.println("Venda registrada com sucesso!");
    }

    public static void exibirRegistroDeVendas() {
        if (registrosVendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
        } else {
            System.out.println("\n--- Registro de Vendas ---");
            for (Venda venda : registrosVendas) {
                System.out.println(venda);
            }
        }
    }
}
