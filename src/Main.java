import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static ArrayList<Double> historicoPesos = new ArrayList<>();
    public static double alturaGeral = 0.0;
    public static String observacao = "";

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String apresentacao = "Essa e a versão 0.3";

        while (true) {
            for (int i = 0; i <= 22; i++) {
                System.out.printf("=");
            }

            System.out.println("\nBem vindo(a) ao MyDiary");
            System.out.println(apresentacao);

            for (int i = 0; i <= 22; i++) {
                System.out.printf("=");
            }

            System.out.println("\nO que deseja fazer?" + "\n[1]Fazer cadastro [2]Registrar medição [3]Calcular IMC [4]ver resumo [5]Ver Histórico [6]Sair");
            int escolha = input.nextInt();
            input.nextLine();

            if (escolha == 6) {
                System.out.println("Volte sempre!");
                System.out.println(apresentacao);
                break;
            }

            switch (escolha) {
                case 1:
                    cadastrarUsuario(input);
                    System.out.println("Cadastro efetuado com sucesso!");
                    System.out.println(apresentacao);
                    break;
                case 2:
                    registrarMedicao(input);
                    System.out.println("Medição registrada com sucesso!");
                    System.out.println(apresentacao);
                    break;
                case 3:
                    retornarImc();
                    break;
                case 4:
                    mostrarResumo();
                    break;
                case 5:
                    mostrarHistorico();
                    break;
                default:
                    System.out.println("opção inválida, tente novamente!");
            }
        }
    }

    public static void retornarImc() {
        if (alturaGeral != 0.0 && !historicoPesos.isEmpty()) {
            double ultimopeso = historicoPesos.get(historicoPesos.size() - 1);
            double imc = ultimopeso / (alturaGeral * alturaGeral);
            System.out.printf("IMC atual: %.2f\n", imc);
        } else {
            System.out.println("Erro: Você precisa primeiro fazer o cadastro (altura) e registrar uma medição (peso)!");
        }
    }
    public static void cadastrarUsuario(Scanner input) {

        while(true){
            System.out.println("Digite seu nome:");
            String nome = input.nextLine();

            System.out.println("Digite sua idade: ");
            int idade = input.nextInt();

            System.out.println("Digite sua altura(em metros): ");
            double alturadigitada = input.nextDouble();
            input.nextLine();

            System.out.println("Qual o seu objetivo? ");
            String objetivo = input.nextLine();

            if(idade <= 0 || alturadigitada <= 0) {
                System.out.println("Cadastro inválido, tente novamente!!!");
                continue;
            }
            else {

                System.out.println("Bem vindo(a) " + nome + " idade: " + idade + " altura: " + alturadigitada + " objetivo: " + objetivo);
                System.out.println("Confirma? [1] sim [2] nao");
                int confirmacao = input.nextInt();
                input.nextLine();

                if (confirmacao == 2) {
                    continue;
                } else {
                    alturaGeral = alturadigitada;
                    break;
                }
            }
        }
    }

    public static void registrarMedicao(Scanner input) {
        while (true) {

            if (alturaGeral <= 0) {
                System.out.println("É necessário fazer o cadastro primeiro!");
                break;
            }

            System.out.println("Digite seu peso (em kg): ");
            double pesodigitado = input.nextDouble();

            if (pesodigitado <= 0) {
                System.out.println("Peso inválido, tente novamente!");
                continue;
            }

            historicoPesos.add(pesodigitado);

            System.out.println("Deseja registrar alguma observação? [1]sim [2]nao");
            int confirmacao = input.nextInt();
            input.nextLine();

            if (confirmacao == 1) {
                System.out.println("Digite a observação: ");
                observacao = input.nextLine();
            }

            break;
        }
    }

    public static void mostrarResumo() {

        if(alturaGeral != 0.0 && !historicoPesos.isEmpty()) {
            double ultimopeso = historicoPesos.get(historicoPesos.size() - 1);
            double imc = ultimopeso / (alturaGeral * alturaGeral);

            System.out.println("\n========== RESUMO ==========");
            System.out.println("Peso: " + ultimopeso + "kgs");
            System.out.println("IMC: " + imc);
            System.out.println("Data: " + LocalDate.now());
            System.out.println("observacao: " + observacao);
            System.out.println("============================");
        }
        else {
            System.out.println("Erro: Você precisa primeiro fazer o cadastro e registrar uma medição!!!");
        }
    }
    public static void mostrarHistorico() {
        if(historicoPesos.isEmpty()) {
            System.out.println("É necessário fazer uma primeira medição");
        }
        else {
            System.out.println("========== HISTORICO ==========");
            for(int i = 0; i < historicoPesos.size(); i++) {
                System.out.println("Peso: " + historicoPesos.get(i) + " kg");
            }
            System.out.println("============================");
        }
    }
}