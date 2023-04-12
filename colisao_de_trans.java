import java.util.InputMismatchException;
import java.util.Scanner;

public class colisaoDeTrens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String escolha;
        int posicaoInicialA, posicaoInicialB;
        double velocidadeTremA, velocidadeTremB, tempo, posicaoFinal, posicaoInicialADouble, posicaoInicialBDouble, minutos, segundos, velocidadeTremBNegativo;
        boolean x = true;

        while (x) {
            while (true) {
                try {
                    System.out.print("Digite a posição inicial do trem A (entre 0km e 10000km): ");
                    posicaoInicialA = sc.nextInt();
                    if (posicaoInicialA < 0 || posicaoInicialA > 10000) {
                        System.out.print("O número deve ser maior ou igual a zero e menor ou igual 10000.");
                        continue;
                    }
                    posicaoInicialADouble = posicaoInicialA;
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("Você digitou um caractere inválido. Por favor, digite novamente.");
                }
                sc.nextLine();
            }

            while (true) {
                try {
                    System.out.print("Digite a posição inicial do trem B (entre 0km e 10000km): ");
                    posicaoInicialB = sc.nextInt();
                    if (posicaoInicialB < 0 || posicaoInicialB > 10000) {
                        System.out.print("O número deve ser maior ou igual a zero e menor ou igual que 10000.");
                        continue;
                    }
                    posicaoInicialBDouble = posicaoInicialB;
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("Você digitou um caractere inválido. Por favor, digite novamente.");
                }
                sc.nextLine();
            }

            while (true) {
                try {
                    System.out.print("Digite a velocidade do trem A (entre 0km/h e 300km/h): ");
                    velocidadeTremA = sc.nextDouble();
                    if (velocidadeTremA < 0 || velocidadeTremA > 300) {
                        System.out.print("O número deve ser maior ou igual a zero e menor ou igual que 300.");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("Você digitou um caractere inválido. Por favor, digite novamente.");
                }
                sc.nextLine();
            }

            while (true) {
                try {
                    System.out.print("Digite a velocidade do trem B (entre 0km/h e 300km/h): ");
                    velocidadeTremB = sc.nextDouble();
                    velocidadeTremBNegativo = velocidadeTremB * -1;
                    if (velocidadeTremBNegativo > 0 || velocidadeTremBNegativo < -300) {
                        System.out.print("O número deve ser maior ou igual a zero e menor ou igual que 300.");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("Você digitou um caractere inválido. Por favor, digite novamente.");
                }
                sc.nextLine();
            }

            tempo = (posicaoInicialADouble - posicaoInicialBDouble) / (velocidadeTremBNegativo - velocidadeTremA);
            System.out.println(tempo);

            minutos = (((tempo % 1) * 100) * 60) / 100;

            segundos = (tempo * 3600) % 60;

            posicaoFinal = posicaoInicialADouble + velocidadeTremA * tempo;

            if (posicaoInicialA >= posicaoInicialB) {
                System.out.println("Os trens não irão colidir.");
            } else {
                System.out.printf("A colisão dos trens acontecerá no KM %.2f e ocorrerá após %.2f segundos, %.0f:%.0f:%.0f", posicaoFinal, tempo * 3600, 17 + tempo, minutos, segundos);
            }

            while (true){
                System.out.println("Deseja continuar? (s/n)");
                escolha = sc.nextLine();

                if (escolha.equalsIgnoreCase("s")) {
                    break;
                } else if (escolha.equalsIgnoreCase("n")) {
                    x = false;
                    break;
                } else {
                    System.out.println("Essa não é uma opção.");
                }
            }
        }
    }
}
