
public class Print {
	
	// HELP COMMAND
	public static void CMDs() {
		System.out.println();
		System.out.println(Colors.GREEN + "CMDS: ");
		System.out.println("F " + Colors.YELLOW + "{Time} {Speed} " + Colors.GREEN + "- To go forwards ");
		System.out.println("B " + Colors.YELLOW + "{Time} {Speed} " + Colors.GREEN +  "- To go backwards ");
		System.out.println("R " + Colors.YELLOW + "{Time} {Speed} " + Colors.GREEN +  "- 90 degrees right turn ");
		System.out.println("L " + Colors.YELLOW + "{Time} {Speed} " + Colors.GREEN + "- 90 degrees left turn ");
		System.out.println("T " + Colors.YELLOW + "{Amount} " + Colors.GREEN + "- Repeat the last amount of moves");
		System.out.println("A  - Toggle forwards movement");
		System.out.println("S - Toggle backwards movement ");
		System.out.println("X - Execute CMDs from a txt file ");
		System.out.println("W - Import CMDs to a txt file ");
		System.out.println("Timeset " + Colors.YELLOW + "{Time} " + Colors.GREEN + "- Change default time ");
		System.out.println("Speedset " + Colors.YELLOW + "{Speed} " + Colors.GREEN + "- Change default speed ");
		System.out.println("Q - Quit the program ");
		System.out.println("Help - Display this message again");

	//SUCCESSFUL COMMANDS
		
	}
	
	public static void Executed() {
		System.out.println();
		System.out.println(Colors.GREEN + "Command Executed!");
		System.out.println(Colors.BLUE_BOLD_BRIGHT);
	}
	
	
	public static  void FRoam() {
		System.out.println();
		System.out.println(Colors.GREEN + "Forward roaming enabled");
		System.out.println(Colors.GREEN + "Press A to toggle off");
		System.out.println(Colors.BLUE_BOLD_BRIGHT);
		//Need to add countdown (Roaming for x seconds)
	}
	public static  void BRoam() {
		System.out.println();
		System.out.println(Colors.GREEN + "Backwards roaming enabled");
		System.out.println(Colors.GREEN + "Press S to toggle off");
		System.out.println(Colors.BLUE_BOLD_BRIGHT);
			//Need to add countdown (Roaming for x seconds)
	}

}
