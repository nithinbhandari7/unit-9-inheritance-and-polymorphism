import java.util.Scanner;

public class FantasyFootballPlayerClient {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String temp = "";
		int choice = 0;
		int qbTier = ((int)(3*Math.random())) + 1;
		int rbTier = ((int)(3*Math.random())) + 1;
		int wrTier = ((int)(3*Math.random())) + 1;
		int[] teamTiers = {qbTier, rbTier, wrTier};
		boolean wantToPlay = true;
		
		System.out.print("Name of the Quaterback: ");
		temp = sc.nextLine();
		FantasyFootballPlayer qb = new Quarterback(temp);
		
		System.out.print("Name of the Running Back: ");
		temp = sc.nextLine();
		FantasyFootballPlayer rb = new RunningBack(temp);
		
		System.out.print("Name of the Wide Reciever: ");
		temp = sc.nextLine();
		FantasyFootballPlayer wr = new WideReciever(temp);
		
		FantasyFootballPlayer[] team = {qb, rb, wr};
		
		
		System.out.println("Your Quarterback (" + qb.getName() + ") was generated as a Tier " + qbTier + " player.");
		System.out.println("Your Running Back (" + rb.getName() + ") was generated as a Tier " + rbTier + " player.");
		System.out.println("Your Wide Reciever (" + wr.getName() + ") was generated as a Tier " + wrTier + " player.");
		
		System.out.println("You can choose a player in a turn and choose between yards or touchdowns for that turn. \nYou will get 5 turns and then the computer will generate 5 turns and whoever has the higher team fantasy points wins.");
		System.out.println("Tier 1 players can get 30 - 40 yards and 2 - 3 touchdowns");
		System.out.println("Tier 2 players can get 20 - 60 yards and 1 - 4 touchdowns");
		System.out.println("Tier 3 players can get 0 - 100 yards and 0 - 5 touchdowns");
		
		for(int i = 0; i < 5; i++) {
		System.out.println("(1) Quarterback (" + qb.getName() + ") \n(2) Running Back (" + rb.getName() + ")\n(3) Wide Reciever (" + wr.getName() + ")");
		System.out.print("Enter the number corresponded to the posititon of the player for their stats or quit: ");
		choice = sc.nextInt();
		
		if(choice == 1 || choice == 2 || choice == 3) {
			int option = 0;
			System.out.println("(1) Touchdowns\n(2) Yards");
			System.out.print("Enter the number corresponded to each option: ");
			option = sc.nextInt();
			
			if(option == 1) {
				tiers(team[choice - 1], teamTiers[choice - 1], "touchdowns");
			} else if(option == 2) {
				tiers(team[choice - 1], teamTiers[choice - 1], "yards");
			}
		}
		}
		System.out.println();
		double teamPoints = ((int)(100 * (qb.getPoints() + rb.getPoints() + wr.getPoints())))/100.0;
		System.out.println("Your team scored " + teamPoints + " fantasy points.");
		System.out.println();
		
		double computerTeamPoints = compPoints();
		
		System.out.println();
		System.out.println("The computer scored " + computerTeamPoints + ".");
		
		if(teamPoints > computerTeamPoints) {
			System.out.println("You won! Thank you for playing!");
		} else if (computerTeamPoints > teamPoints) {
			System.out.println("You lost! Thank you for playing!");
		} else {
			System.out.println("It was a tie! Thank you for playing!");
		}
	}
	
	private static void tiers(FantasyFootballPlayer player, int tier, String play) {
		int num;
		if(tier == 1) {
			if(play.equals("yards")) {
				num = (int)(Math.random() * 11) + 30;
				player.score(0, 0, num);
				System.out.println(player.getName() + " got " + num + " yards.");
				System.out.println(player.toString());
			} else if(play.equals("touchdowns")) {
				num  = ((int)(Math.random() + 0.5)) + 2;
				player.score(0, num, 0);
				System.out.println(player.getName() + " got " + num + " touchdowns.");
				System.out.println(player.toString());
			}
		} else if(tier == 2) {
			if(play.equals("yards")) {
				num = (int)(((Math.random()*40) + 20) + 0.5);
				player.score(0, 0, num);
				System.out.println(player.getName() + " got " + num + " yards.");
				System.out.println(player.toString());
			} else if(play.equals("touchdowns")) {
				num = (int)((Math.random() * 3) + 0.5) + 1;
				player.score(0, num, 0);
				System.out.println(player.getName() + " got " + num + " touchdowns.");
				System.out.println(player.toString());
			}
		} else if(tier == 3) {
			if(play.equals("yards")) {
				num = (int)((Math.random() * 100) + 0.5);
				player.score(0, 0, num);
				System.out.println(player.getName() + " got " + num + " yards.");
				System.out.println(player.toString());
			} else if(play.equals("touchdowns")) {
				num = (int)((Math.random() * 5) + 0.5);
				player.score(0, num, 0);
				System.out.println(player.getName() + " got " + num + " touchdowns.");
				System.out.println(player.toString());
			}
		}
	}
	
	private static double compPoints() {
		FantasyFootballPlayer qbComp =  new Quarterback("The Computer's Quarterback");
		FantasyFootballPlayer wrComp =  new WideReciever("The Computer's Wide Reciever");
		FantasyFootballPlayer rbComp =  new RunningBack("The Computer's Running Back");
		FantasyFootballPlayer[] compTeam = {qbComp, wrComp, rbComp};
		int tier = 0;
		int playerChoice;
		int play;
		String playCall = "";

		for(int i =0; i < 5; i++) {
		play = (int)(Math.random()+ 0.5);
		if(play == 0) {
		playCall = "yards";
		}
		else if(play == 1) {
		playCall = "touchdowns";
		}
		playerChoice = (int)(3*Math.random() + 1);
		tier = (int)(3*Math.random() + 1);
		tiers(compTeam[playerChoice-1], tier, playCall);
		}

		return ((int)(100 *( compTeam[0].getPoints() + compTeam[1].getPoints() + compTeam[2].getPoints())))/100.0;
		}
}