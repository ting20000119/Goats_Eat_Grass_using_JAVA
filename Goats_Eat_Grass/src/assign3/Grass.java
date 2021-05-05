package assign3;
public class Grass extends Creature{
	int age;
	int id;
	int point;
	int act;
public Grass(int nowage,int i){
	super(2);
	age = nowage;
	act = i;
}
public int getage(){
	return age;
}
public void updateage(){
	age = age +1;
}
public int getpoint(){
	return point;
}
public void updatepoint(int p){
	point = point + p;
}	
public void updateaction(){
	act = act + 1;
}
public int getaction(){
	return act;
}

} 
