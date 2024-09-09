package edu.matheusvanin;

import java.util.Scanner;

public class ContaTerminal {
    private static final Scanner scanner = new Scanner(System.in);

    private int numeroConta;
    private String agencia;
    private String nomeCliente;
    private double saldo;

    /**
     * preenche os dados da conta ao usuário
     */
    private void preencheDadosConta() {
        this.numeroConta = solicitarNumero("Digite o número da conta: ");
        this.agencia = solicitarTexto("Digite a agência: ");
        this.nomeCliente = solicitarTexto("Digite o nome do cliente: ");
        this.saldo = solicitarDouble("Digite o saldo inicial: ");
    }

    /**
     * Solicitar um double ao usuário
     */
    private double solicitarDouble(String mensagem) {
        String entradaUsuario = "";
        do {
            System.out.println(mensagem);
            entradaUsuario = scanner.nextLine();
        } while (!validaDouble(entradaUsuario));
        return Double.parseDouble(entradaUsuario);
    }

    /**
     * Verifica se uma String pode ser convertida para um double
     *
     * @param numero String a ser verificada
     * @return true - Número válido, false - Número inválido
     */
    private boolean validaDouble(String numero) {
        if (!numero.matches("[0-9]+(\\.[0-9]+)?")) {
            System.out.println("Número inválido! Por favor digite novamente.");
            return false;
        }
        return true;
    }

    /**
     * Solicita um texto ao usuário
     */
    private String solicitarTexto(String mensagem) {
        System.out.println(mensagem);
        return scanner.nextLine();
    }

    /**
     * Solicita um número ao usuário
     */
    private int solicitarNumero(String mensagem) {
        String entradaUsuario = "";
        do {
            System.out.println(mensagem);
            entradaUsuario = scanner.nextLine();
        } while (!validaNumero(entradaUsuario));
        return Integer.parseInt(entradaUsuario);
    }

    /**
     * Verifica se uma String pode ser convertida para um número
     *
     * @param numero String a ser verificada
     * @return true - Número válido, false - Número inválido
     */
    private boolean validaNumero(String numero) {
        if (!numero.matches("[0-9]+")) {
            System.out.println("Número inválido! Por favor digite novamente.");
            return false;
        }
        return true;
    }

    /**
     * Exibe mensagem de boas vindas ao usuário
     * @param contaTerminal ContaTerminal a ser exibida
     */
    private void exibeBoasVindas(ContaTerminal contaTerminal) {
        System.out.println("Bem-vindo, " + contaTerminal.nomeCliente + ", obrigado por criar uma conta em nosso " +
                "banco, sua agência é " + contaTerminal.agencia + ", conta " + contaTerminal.numeroConta +
                " e seu saldo " + contaTerminal.saldo + " já está disponível para saque.");
    }

    public static void main(String[] args) {
        ContaTerminal contaTerminal = new ContaTerminal();
        contaTerminal.preencheDadosConta();
        contaTerminal.exibeBoasVindas(contaTerminal);
    }
}