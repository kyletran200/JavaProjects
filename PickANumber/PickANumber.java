
// Kyle Tran
import java.util.Random;
import java.util.Scanner;

public class PickANumber {
	public static final Random _RANDOM = new Random();

	/**
	 * Takes a name, removes any leading or trailing spaces
	 * ensures the first letter is the only letter capitalized.
	 * If it finds any thing but letters, hyphen or spaces it returns 
	 * any empty string (for an invalid name)
	 * @param name
	 * @return name
	 */
	public static String fixName(String name)
	{
		String fixedName = "";
		Scanner sc = new Scanner (name.toLowerCase());

		while (sc.hasNext()) {
			String word = sc.next();
			boolean shouldUpperCase = true;

			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (c == '-') {
					shouldUpperCase = true;
				} else if (Character.isLetter(c)) {
					if (shouldUpperCase) {
						c = Character.toUpperCase(c);
						shouldUpperCase = false;
					}
				} else {
					System.out.println("You entered an invalid name: " + name);
					sc.close();
					return ""; // found a non letter
				}
				fixedName += c;
			}
			fixedName += " ";
		}
		sc.close();
		return fixedName.trim();
	}


	/**
	 * Prompts the user to enter their userName. 
	 * keeps asking until a valid name is entered
	 * uses fixName to validate and ensure the name is correct
	 * @param sc 
	 * @return the name you read in
	 */
	public static String getUserName(Scanner sc)
	{
		String name;

		do {
			System.out.print("Please enter your name: ");
			name = sc.nextLine();
			name = fixName(name);
		} while (name.length() == 0);

		return name; 
	}


	/**
	 * 
	 * @return a number between 1 - 100 inclusive
	 */
	public static int pickNumber ()
	{
		return _RANDOM.nextInt(100) + 1;
	}


	/**
	 * Guesses a number between 1 and 100 and repeatedly asks
	 * the users to guess that number until they get it.  Give Higher / lower hints.
	 * @param sc scanner to read in the users's guesses
	 * @param name user's name
	 */
	public static void playGameComputerPicks(Scanner sc, String name)
	{
		int answer = pickNumber();
		int guess = -1;
		int numGuesses = 0;

		System.out.println("\n" + name + " I've picked a number between 1 and 100.");
		while (guess != answer) {
			System.out.print("guess my number: ");
			if (sc.hasNextInt()) {
				guess = sc.nextInt();
				numGuesses++;
				if (guess < answer) {
					System.out.print("Try again but higher. ");
				} else if (guess > answer) {
					System.out.print("Try again but lower. ");
				} else { // guess == answer
					System.out.println("You got it in " + numGuesses + " guesses.  The answer was " + answer + "\n");
				}
			} else {
				sc.next();
				System.out.println("That's not a number! Try again.");
			}

		} 

	}
	public static void playGameUserPicks(Scanner sc) {
		int computerguess = 50;
		int numberofguesses = 0;
		System.out.println("Choose a number from 1 to 100. Hit enter when you have your number");
		String answer = sc.nextLine();
		int min = 1;
		int max = 100;
		while (!answer.equals("correct")) {
			System.out.println("Is your number " + computerguess + "?");
			answer = sc.next();
			if (answer.equalsIgnoreCase("higher")) {
				min = computerguess + 1;
				computerguess = (max + min) / 2;
			}
			else if (answer.equalsIgnoreCase("lower")) {
				max = computerguess - 1;
				computerguess = (max + min)/ 2;
			}
			else if (!answer.equalsIgnoreCase("lower") && !answer.equalsIgnoreCase("higher") && !answer.equalsIgnoreCase("correct")){
				System.out.println("I'm sorry, I couldn't understand you. Please answer with higher, lower or yes.");

			}

			numberofguesses ++;
			
		}
		System.out.println("I got your number in " + numberofguesses + " guesses!");
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = getUserName(sc);


		System.out.print(name + ", do you want to play a guessing game?");
		String answer = sc.nextLine().trim().toLowerCase();
		while (answer.startsWith("y")) {
			System.out.print("Do you want to pick or should I? (" + name + " or computer pick):");
			String answer2 = sc.next();
			if (answer2.equals("computer") || answer2.equals("Computer") || answer2.equals("COMPUTER")) {
				playGameComputerPicks(sc, name);
			}
			else {
				playGameUserPicks(sc);
			}

			System.out.print("Do you want to play again?");
			answer = sc.nextLine();
		} 

		sc.close();
	}

}

