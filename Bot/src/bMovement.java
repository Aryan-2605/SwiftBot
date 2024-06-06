
public class bMovement {
	
	//SwiftBotAPI sb = new SwiftBotAPI();
	private int speed = 100;
	private int duration = 6;
	private boolean cValue = false;
	
	public boolean CheckValue() {
		cValue = false;
		if(speed <= 100  & duration <= 6) {
			cValue = true;
			return true;
			
		}
		else {
			cValue = false;
			return false;
		}
	}
	bMovement(){
	}
	bMovement(int speed, int duration){
		this.speed = speed;
		this.duration = duration;
		
	}
	
	public void cSpeed(){
		switch(duration) {
		
		case 1:
			speed = 32;
			break;
		
		case 2:
			speed = 27;
			break;
			
		case 3:
			speed = 24;
			break;
		
		case 4:
			speed = 24;
			
			break;
		case 5:
			speed = 24;
			
		break;
		case 6:
			speed = 23;
			break;
			
		
		}
		
	}
	


	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public boolean iscValue() {
		return cValue;
	}

	public void setcValue(boolean cValue) {
		this.cValue = cValue;
	}
	
}
