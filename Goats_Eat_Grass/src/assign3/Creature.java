package assign3;
import java.util.Random;
class Creature{
	int act;
	int id;
	int direct;
	public Creature(int whichchild){
		id = whichchild;
	}
	public int getid(){
		return id;
	}
	public int getdirect(){
		Random r1 = new Random();
		direct = r1.nextInt(4);	
		return direct;	
	}

	public int getage(){
		return 0;	
	}
	public void updateage(){
	}
	public int getpoint(){
		return 0;
	}
	public void updatepoint(int p){
	}	
	public void updateaction(){
	}
	public int getaction(){
		return 0;
	}


}
