import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Data extends bMovement {
	
	private int speed;
	private int duration;
	private String CMD;
	private int count;
	private  int amount;
	private boolean cAmount = false;
	
	private ArrayList<String> Data = new ArrayList();
	
	public Data () {
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getSize() {
		return Data.size();
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

	public String getCMD() {
		return CMD;
	}

	public void setCMD(String cMD) {
		CMD = cMD;
	}

	public ArrayList getData() {
		return Data;
	}

	public void setData(String data) {
		Data.add(data);
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
	public boolean iscAmount() {
		return cAmount;
	}

	public void setcAmount(boolean cAmount) {
		this.cAmount = cAmount;
	}

	public boolean cAmount() {
		cAmount = false;
		if(count > Data.size()) {
			cAmount = false;
			return false;
		}
		else {
			cAmount = true;
			return true;
		}
	}
	
	public void splitter(int i) {
			String x = Data.get(i);
			String[] split = x.split(" ");
			CMD = split[0];
			duration = Integer.parseInt(split[1]);
			speed = Integer.parseInt(split[2]);
		}
	
	public void logger() {
		 SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		 Date currentTime = new Date();
		 
	       try {
	            FileWriter writer = new FileWriter(timeFormat.format(currentTime) + ".log");

	            for (String x : Data) {
	                writer.write(x + "\n");
	            }

	           
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
	
	public void Order66() throws IOException {
        FileReader fileReader = new FileReader("execute.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            Data.add(line);
        }

        bufferedReader.close();
		
		
		}
	
	public void execute(int i) {
		String x = Data.get(i);
		String[] split = x.split(" ");
		 CMD = split[0];
		if(CMD == "T") {
			
			amount = Integer.parseInt(split[1]);
		}
		else {
			duration = Integer.parseInt(split[1]);
			speed = Integer.parseInt(split[2]);
			}
		}
	}
	

	
	
	

