package assign3;
public class Goat extends Creature{
		int age;
		int point;
		int id;
		int act;

public Goat(int nowage,int nowpoint,int i){
	super(1);
	age = nowage;
	point = nowpoint;
	act = i;
}
public int getage(){
	return age;
}
public void updateage(){
	age = age + 1;
}
public int getpoint(){
	return point;
}
public void updatepoint(int p){
	point = point + p;
}
public void updateaction(){
 	act = act+1;
}
public int getaction(){
	return act;
}
}
