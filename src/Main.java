import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String apresentacao = "Essa e a versão 0.1";

        for(int i = 0; i<= 22; i++) {
            System.out.printf("=");
        }

        System.out.println("\nBem vindo(a) ao MyDiary");
        System.out.println(apresentacao);

        for(int i = 0; i<= 22; i++) {
            System.out.printf("=");
        }

        System.out.println("\nO que deseja fazer?" + "\n[1]Fazer cadastro [2]Sair");
        int escolha = input.nextInt();

        input.nextLine();

        if(escolha == 1){

            while(true){
                System.out.println("Digite seu nome:");
                String nome = input.nextLine();

                System.out.println("Digite sua idade: ");
                int idade = input.nextInt();

                System.out.println("Digite sua altura(em metros): ");
                double altura = input.nextDouble();
                input.nextLine();

                System.out.println("Qual o seu objetivo? ");
                String objetivo = input.nextLine();

                if(idade <= 0 || altura <= 0) {
                    System.out.println("Cadastro inválido, tente novamente!!!");
                    continue;
                }
                else {

                    System.out.println("Bem vindo(a) "+nome+" idade: "+idade+" altura: "+altura+" objetivo: "+objetivo);
                    System.out.println("Confirma? [1] sim [2] nao");
                    int confirmacao = input.nextInt();
                    input.nextLine();

                    if(confirmacao == 2) {
                        continue;
                    }
                    else {
                        break;
                    }

                }
            }

            System.out.println("Cadastro concluido.");
            System.out.println(apresentacao);
        }
        else{
            System.out.println("Volte sempre!!!");
            System.out.println(apresentacao);
        }
        input.close();
    }
}