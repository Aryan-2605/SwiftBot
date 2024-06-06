 
import java.util.Scanner;
import java.util.StringTokenizer;
 
import swiftbot.SwiftBotAPI;
 
public class Main {
 
	public static void main(String[] args) {
		SwiftBotAPI sb = new SwiftBotAPI();
 
		// Welcome Message
		System.out.println();
		System.out.println(Colors.BLUE_BOLD_BRIGHT + "Welcome to Swiftbot!");
		Print.CMDs();
 
			int speed = 100;
	        int time = 6;
	        int amount = 0;
	        int x = 1;
	        bMovement Default = new bMovement();
	        Scanner input = new Scanner(System.in);
	        Data  store = new Data();
	        Data log = new Data();
	        Data execute = new Data();
	        StringTokenizer tokenizer;
	        do {
	            try {
	            	System.out.println(Colors.BLUE_BOLD_BRIGHT);
	                String CMD = input.nextLine();
	                tokenizer = new StringTokenizer(CMD);
	                CMD = tokenizer.nextToken();
	                if (CMD.equals("Help") || CMD.equals("A") || CMD.equals("S")
	                        || CMD.equals("X") || CMD.equals("C") || CMD.equals("W") || CMD.equals("Q")) {
	 
	                } else if (CMD.equals("F") || CMD.equals("B") || CMD.equals("R") || CMD.equals("L")) {
	 
	                    time = Integer.parseInt(tokenizer.nextToken().strip());
	                    speed = Integer.parseInt(tokenizer.nextToken().strip());

	                } else if (CMD.equals("SpeedSet")) {
	 
	                    speed = Integer.parseInt(tokenizer.nextToken().strip());
	                } else if (CMD.equals("TimeSet")) {
	 
	                    time = Integer.parseInt(tokenizer.nextToken().strip());
	                } else if (CMD.equals("T")) {
	 
	                    amount = Integer.parseInt(tokenizer.nextToken().strip());
	                }
	 
	                System.out.println(Colors.GREEN);
	                switch (CMD) {
	                    case "Help": //Lists the commands
	                        Print.CMDs();
	                        
	                        break;
	 
	                    case "A": // Forward Roamer
	    					System.out.println(Colors.GREEN + "Toggle Forwards");
	    					Boolean fw = true;
	    					
	    						log.setData(CMD);
	    						sb.startMove(Default.getSpeed(), Default.getSpeed());
	    						System.out.println("Press A to Toggle off ");
	    						do {
	    						String f = input.nextLine();
	    						switch(f) {
	    						case "A":
	    							sb.stopMove();
	     	    					fw =  false;
	     	    					log.setData(CMD);
	    							break;
	     
	    						default:
	    							try {
	    							throw new InvalidCharacterException(Colors.RED + " ERROR: Please Enter A to Stop" + Colors.BLUE_BOLD_BRIGHT);
	    							}catch(Exception e) {
	    								System.out.println(e);
	    							}

	    						}
	    					}while(fw == true);
	 
	                        break;
	 
	                    case "S": //Roaming BAckwards
	                    	System.out.println("Toggle Backwards");
	    					Boolean bw = true;
	    					
	    						log.setData(CMD);
	    						sb.startMove(-Default.getSpeed(), -Default.getSpeed());
	    						System.out.println("Press S to Toggle off ");
	    						do {
	    						String b = input.nextLine();
	    						switch(b) {
	    						case "S":
	    							sb.stopMove();
	     	    					bw =  false;
	     	    					log.setData(CMD);
	    							break;
	     
	    						default:
	    							try {
	    							throw new InvalidCharacterException("Please Enter S to Stop");
	    							}catch (Exception e) {
	    								System.out.println(e);
	    							}
	     
	    						}
	    					}while(bw == true);
	 
	                        break;
	 
	                    case "X": //Execute from a file
	                    	execute.Order66();
	                    	try {
	                    		if(execute.getSize()<3)
	                    		{
	                    			throw new InvalidNumberException(Colors.RED + "ERROR: X only works for files that have more than 3 CMDs");
	                    		}
	                    		else {
	                    	for(int i = 0; i <= execute.getSize()-1; i++) { 
	                    		execute.execute(i);
	                    		execute.CheckValue();
	                    		if(execute.iscValue() == false) {
	                    			throw new InvalidNumberException(Colors.RED + "Error: Parameters Out of Bounds please check execute.txt" + Colors.BLUE_BRIGHT);
	                    		}
	                    		System.out.println(execute.getCMD() + " " + execute.getDuration() + " " + execute.getSpeed());
	                    		switch(execute.getCMD()) {
	                    		
	                    		case "F": //Forwards Movement
                    				sb.move(execute.getSpeed(), execute.getSpeed(), execute.getDuration()*1000);
                    				break;
                    				
                    			case "B": //Backwards Movement
                    				sb.move(-execute.getSpeed(), -execute.getSpeed(), execute.getDuration()*1000);
                    				break;
                    				
                    			case "L": //Left Movement 
                    				Default.setSpeed(execute.getSpeed());
                    				execute.cSpeed();
                    				sb.move(-execute.getSpeed(), execute.getSpeed(), execute.getDuration()*1000);
                    				break;
                    			 
                    			case "R": //Right Movement
                    				Default.setSpeed(execute.getSpeed());
                    				execute.cSpeed();
                    				sb.move(execute.getSpeed(), -execute.getSpeed(), execute.getDuration()*1000);
                    				break;
	                    		}
	                    		}
	                    	}} catch(Exception e) {
	                    		System.out.println(Colors.RED + "Error: Parameters Out of Bounds please check execute.txt" + Colors.BLUE_BRIGHT);
	                    		
	                    	}
	                    	
	                  
	                        
	                        break;
	 
	                    case "W":
	                    	
	                    	log.logger();
	                        System.out.println("Imported to txt");
	 
	                        break;
	 
	                    case "Q": //Quit Process
	                    	
	                    	boolean q =true;
	                        System.out.println(Colors.ORANGE + "Preparing to Exit SwiftBot...");
	                        
	                        System.out.println(Colors.BLUE + "Would you like to export your CMDs? (Y or N)");
	                        do {
	    						String b = input.nextLine();
	    						switch(b) {
	    						case "Y": //User Input Yes
	    							log.logger();
	    	                        System.out.println("Imported to txt");
	    	                        
	    	                        System.out.println("Exiting... \n Goodbye ");
	    							
	    	                        q =  false;
	     	    					
	    							break;
	    							
	    						case "N": //User Input No
	    							System.out.println("Exiting... \n Goodbye ");
	    							
	    							q = false;
	    							break;
	     
	    						default:
	    							try { 
	    							throw new InvalidCharacterException("Please enter either Y or N");
	    							}catch (Exception e) {
	    								System.out.println(e);
	    							}
	     
	    						}
	    					}while(q == true);
	                        x++;
	                        break;
	                        //Forward Movement 
	                    case "F": 
	                    	 bMovement f = new bMovement(Math.abs(speed), time);
	                        // f.setcValue(false);
	                         f.CheckValue();
	                         
	                         try {
	                         if(f.iscValue() == false) {
	                        	 
		                    	   f.setSpeed(Default.getSpeed());
		                    	   f.setDuration(Default.getDuration());
	                         
	                         throw new InvalidNumberException();
	                         
	                         }
	                         else {
	                        	 log.setData("F " + Integer.toString(f.getDuration()) + " " + Integer.toString(Math.abs(f.getSpeed())));
	                        	 sb.move(f.getSpeed(), f.getSpeed(), f.getDuration()*1000);
	                           	 System.out.println("Command Executed! Speed = " + f.getSpeed() + " Time = " + f.getDuration());
	                         	 store.setData("F " + Integer.toString(f.getDuration()) + " " + Integer.toString(Math.abs(f.getSpeed())));

	                         }
	                         } catch (Exception e) {
	                        	 System.out.println(e);
	                         }
	                        	 
	                         break;
	  
	                         
	                    case "B": //Backwards Movement
	                    	bMovement b = new bMovement(-speed, time);
	                    	
	                    	b.CheckValue();
	                    	
	                    	try {
	                    	if (b.iscValue() == false) {
	                    		
		                    	   b.setSpeed(Default.getSpeed());
		                    	   b.setDuration(Default.getDuration());
	                    		System.out.println("CHANGE SPEED OR TIME");
	                    		throw new InvalidNumberException();
	                    	}
	                    	
	                    	else {
	                    		sb.move(b.getSpeed(), b.getSpeed(), b.getDuration()*1000);
	                    		System.out.println("Command Executed! Speed = " + -b.getSpeed() + " Time = " + b.getDuration());
	                    		store.setData("B " + Integer.toString(b.getDuration()) + " " + Integer.toString(Math.abs(b.getSpeed())));
	                    		log.setData("B " + Integer.toString(b.getDuration()) + " " + Integer.toString(Math.abs(b.getSpeed())));
	                    	}}
	                    	catch(Exception e) {
	                    		System.out.println(e);
	                    	}
	                        break;
	 
	                    case "R": //Right turn movement 
	                       bMovement r = new bMovement(speed, time);
	                       
	                       r.CheckValue();
	                       try {
	                       if (r.iscValue() == false) {
	                    	   
	                    	   r.setSpeed(Default.getSpeed());
	                    	   r.setDuration(Default.getDuration());
	                    	   
	                    	   throw new InvalidNumberException();
	                    	   
	                       }
	                       else {
	                    	   Default.setSpeed(r.getSpeed());
	                    	   r.cSpeed();
	                    	   sb.move(r.getSpeed(), -r.getSpeed(), r.getDuration()*1000);
	                    	   System.out.println("Command Executed! Turning right at Speed: " +  r.getSpeed() +" in Time: "  + r.getDuration());
	                    	   store.setData("R " + Integer.toString(r.getDuration()) + " " + Integer.toString(Math.abs(r.getSpeed())));
	                    	   log.setData("R " + Integer.toString(r.getDuration()) + " " + Integer.toString(Math.abs(r.getSpeed())));

	                       }
	                       }catch(Exception e) {
	                    	   System.out.println(e);
	                       }
	                        	
	                        break;
	 
	                    case "L": //Left Turn Movement
	                    	bMovement l = new bMovement(speed, time);
	                    	
	                    	l.CheckValue();
	                    	 try {
	                    	 if (l.iscValue() == false) {
		                    	   
		                    	   l.setSpeed(Default.getSpeed());
		                    	   l.setDuration(Default.getDuration());
		                    	   
		                    	   throw new InvalidNumberException();
		                    	   
		                       }
		                       else {
		                    	   Default.setSpeed(l.getSpeed());
		                    	   l.cSpeed();
		                    	   sb.move(-l.getSpeed(), l.getSpeed(), l.getDuration()*1000);
		                    	   System.out.println("Command Executed! Turning left at Speed: " +  l.getSpeed() +" in Time: "  + l.getDuration());
		                    	   store.setData("L " + Integer.toString(l.getDuration()) + " " + Integer.toString(Math.abs(l.getSpeed())));
		                    	   log.setData("L " + Integer.toString(l.getDuration()) + " " + Integer.toString(Math.abs(l.getSpeed())));
		                       }}catch(Exception e) {
		                    	   System.out.println(e);
		                       }
	                    	
	                        break;
	 
	                    case "SpeedSet": //Change the default speed
	                       Default.setSpeed(speed);
	                       Default.CheckValue();
	                       try {
	                       if (Default.iscValue() == false) {
	                    	   
	                    	   Default.setSpeed(100);
	                    	   
	                    	   throw new InvalidNumberException();
	                       }
	                       else {
	                    	   System.out.println("Default Speed has now been set to " + Default.getSpeed());
	                    	   log.setData("SpeedSet " + Integer.toString(Default.getSpeed()));
	                       }} catch(Exception e) {
	                    	   System.out.println(e);
	                       }
	 
	                        break;
	 
	                    case "TimeSet": //Change Default Time
	                    	Default.setDuration(time);
	                    	Default.CheckValue();
	                    	try {
	                    	if (Default.iscValue() == false) {
	                    		
	                    		Default.setDuration(6);
	                    		
	                    		throw new InvalidNumberException();
	                    	}
	                    	else {
		                    	   System.out.println("Default time has now been set to " + Default.getDuration());
		                    	   log.setData("TimeSet " + Integer.toString(Default.getDuration()));

	                    	}}catch(Exception e) {
	                    		System.out.println(e);
	                    	}
	 
	                        break;
	 
	                    case "T": //Retrace 
	                    	store.setCount(amount);
	                    	store.cAmount();
	                    //	System.out.println(store.getCount());
	                    	try {
	                    	if(store.iscAmount() == false) {
	                    		store.setCount(0);
	                    		amount = (0);
	                    		throw new InvalidNumberException();	
	                    	}
	                    	else {
	                    		int c = amount;
	                    		int size = store.getSize();
	                    		for(int i = store.getSize() -1; i >= size - c && i >= 0; i--) {
	                    			store.splitter(i);
	                    			System.out.println(store.getCMD() + " " + store.getDuration() + " " +  store.getSpeed());
	                    			log.setData("T " +size);
	                    			switch(store.getCMD()) {
	                    			
	                    			case "F":
	                    				sb.move(store.getSpeed(), store.getSpeed(), store.getDuration()*1000);
	                    				break;
	                    				
	                    			case "B":
	                    				sb.move(-store.getSpeed(), -store.getSpeed(), store.getDuration()*1000);
	                    				break;
	                    				
	                    			case "L":
	                    				Default.setSpeed(store.getSpeed());
	                    				store.cSpeed();
	                    				sb.move(-store.getSpeed(), store.getSpeed(), store.getDuration()*1000);
	                    				break;
	                    			
	                    			case "R":
	                    				Default.setSpeed(store.getSpeed());
	                    				store.cSpeed();
	                    				sb.move(store.getSpeed(), -store.getSpeed(), store.getDuration()*1000);
	                    				break;
	                    			}
	                    			
	                    			sb.stopMove();
	       
	                    		}
	                    	}
	                    	}catch(Exception e) {
	                    		System.out.println(e);
	                    	}
	                    	
	                        System.out.println("Repeat the last " + amount + " moves.");
	 
	                        break;
	 
	 
	                    default:
	                        throw new InvalidCharacterException(Colors.RED + "ERROR: Invalid input entered. All Commands are case-sensitive. " + Colors.BLUE_BOLD_BRIGHT);
	 
	                }
	            } catch (Exception e) { //Main error catcher
	                System.out.println(Colors.RED + "ERROR: Invalid input entered. All Commands are case-sensitive. " + Colors.BLUE_BOLD_BRIGHT);
	            }
	        } while (x == 1); //Main Loop
	        
	}
}