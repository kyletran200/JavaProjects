
public class HandSign {
	private String type;
	public HandSign(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public boolean isWinner(HandSign opponent) {
		if (this.getType().equals("rock") && opponent.getType().equals("paper")) {
			return false;
		}
		else if (this.getType().equals("rock") && opponent.getType().equals("scissor")) {
			return true;
		}
		else if (this.getType().equals("paper") && opponent.getType().equals("rock")) {
			return true;
		}
		else if (this.getType().equals("paper") && opponent.getType().equals("scissor")) {
			return false;
		}
		else if (this.getType().equals("scissor") && opponent.getType().equals("paper")) {
			return true;
		}
		else if (this.getType().equals("scissor") && opponent.getType().equals("rock")) {
			return false;
		}
		else {
			return false;
		}
	}
	public String toString() {
		return type;
	}
}
