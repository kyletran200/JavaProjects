import java.util.Scanner;
public class PlayGame {
	public static void main (String[] args) {
		int playerpoint = 0;
		int computerpoint = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Wana play paper scissors rock? y/n");
		String response = sc.nextLine();
		if (response.equals("y") || response.equals("Y")) {
			System.out.println("lets go");
			System.out.println("Best out of __ ?");
			int bestOutta = sc.nextInt();
			if (bestOutta % 2 == 0) {
				System.out.println("put an odd number dumbass");
			}
			else {
				while ((playerpoint < bestOutta/2 + 1) && (computerpoint < bestOutta/2 + 1)) {
					System.out.println("Choose ur move");
					String playerChoice = sc.next();
					HandSign playermove = new HandSign(playerChoice);
					HandSign computermove;
					int random = (int)(Math.random() * 3);
					if (random == 0) {
						computermove = new Rock();
					}
					else if (random == 1) {
						computermove = new Paper();
					}
					else {
						computermove =  new Scissors();
					}
					System.out.println(playermove.getType() + " vs " + computermove.getType());
					if (playermove.getType().equals(computermove.getType())) {
						System.out.println("tie");
						System.out.println();
					}
					else if (playermove.isWinner(computermove) == true) {
						playerpoint++;
						System.out.println("u got me");
						System.out.println();
					}
					else {
						computerpoint++;
						System.out.println("u lose");
						System.out.println();
					}
					System.out.println("Player: " + playerpoint + "   Computer: " + computerpoint);
				}
			}
			if (playerpoint == bestOutta/2 + 1) {
				System.out.println("You win");
			}
			else if (computerpoint == bestOutta/2 + 1) {
				System.out.println("sit down its over");
			}
			else {
				System.out.println("what");
			}

		}
		else {
			System.out.println("didnt wana play with u anyways");
		}
	}
	}
