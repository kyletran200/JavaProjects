
/* Kyle Tran
	 * 9/13/16
	 * Period 2
*/
public class HourglassProject {
		public final static int SIZE = 4;
		public static void topandbottom() {
			System.out.print("|");
			for (int i = 1; i <= SIZE*2 +2; i++) {
				System.out.print("\"");
			}
		System.out.println("|");
		}
		public static void middle() {
			for (int i = 0; i<= SIZE; i++) {
				System.out.print(" ");
			}
			System.out.println("||");
		}
		
		public static void main(String[] args) {
			topandbottom();
			for (int i = SIZE; i >=1; i--) {
				for (int x = SIZE-i; x >= 0 ; x--) {
					System.out.print(" ");
				}
				System.out.print("\\");
				for (int y =(2*SIZE)-(2*i); y<=2*SIZE-1;y++) {
					System.out.print(":");
				}
				System.out.print("/");
				System.out.println();
			}
			middle();
			for (int i = 1; i<= SIZE; i++) {
				for (int x = 0; x <= SIZE-i; x++) {
					System.out.print(" ");
				}
				System.out.print("/");
				for (int y = (2*SIZE)-1; y >=(2*SIZE)-(i*2);y--) {
					System.out.print(":");
				}
				System.out.print("\\");
				System.out.println();
			}
			topandbottom();
		}
	}


