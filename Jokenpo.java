import java.util.Scanner;

public class Jokenpo {
    private static int playerScore = 0;
    private static int computerScore = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (playerScore < 3 && computerScore < 3) {
            System.out.println("Jokenpô - Escolha uma opção: 1 - Pedra, 2 - Papel, 3 - Tesoura");
            int playerChoice = scanner.nextInt();
            int computerChoice = (int) (Math.random() * 3) + 1;

            System.out.println("Você escolheu: " + convertChoice(playerChoice));
            System.out.println("O computador escolheu: " + convertChoice(computerChoice));

            String result = determineWinner(playerChoice, computerChoice);
            System.out.println(result);

            System.out.println("Placar: Jogador " + playerScore + " x " + computerScore + " Computador");
            System.out.println("-------------------------------------------");
        }

        if (playerScore > computerScore) {
            System.out.println("Você venceu a melhor de 5!");
        } else {
            System.out.println("O computador venceu a melhor de 5!");
        }

        scanner.close();
    }

    private static String convertChoice(int choice) {
        switch (choice) {
            case 1:
                return "Pedra";
            case 2:
                return "Papel";
            case 3:
                return "Tesoura";
            default:
                return "Escolha inválida";
        }
    }

    private static String determineWinner(int playerChoice, int computerChoice) {
        if (playerChoice == computerChoice) {
            return "Empate!";
        } else if ((playerChoice == 1 && computerChoice == 3)
                || (playerChoice == 2 && computerChoice == 1)
                || (playerChoice == 3 && computerChoice == 2)) {
            playerScore++;
            return "Você ganhou essa rodada!";
        } else {
            computerScore++;
            return "O computador ganhou essa rodada!";
        }
    }
}
