package myMenu;

public class Goal {
private int goal;
private String type;
private String time;

    public Goal() {
    	
    };
	
public void setGoal(int goal) {
	
		this.goal=goal ;
	}
	public int getGoal() {
		int goal=0;
		this.goal = goal++;
		return this.goal;
	}
	public void minusGoal() {
	    this.goal --;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return this.type;
	}
	public void setTime(String time) {
	     this.time = time;
	}
	public String getTime() {
	     return this.time;
	}
	public void addGoal() {
       this.goal = this.goal +1;
	}
}
