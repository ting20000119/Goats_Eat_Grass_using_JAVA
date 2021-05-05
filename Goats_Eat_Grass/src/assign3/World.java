package assign3;

import java.util.Random;

/**
 * The World class is used to represent the world for simlation of artificial life
 * with goats and grasses. The world of fixed size (20x35) is expected to be 
 * initialized with the number of passes and the seed for the random number generator 
 * used for the simulation. The class will provide a mainLoop method with an argument 
 * about the interval for displaying the world to the standard output. 
 * The world consists of a 2D grid, in each of which, a creature (a grass or a goat) 
 * may reside. If no creature resides, the slot will be null.   
 * @author li
 *
 */

public class World {

	// TODO: put your data fields here
	int pass;
	Creature [][] map = new Creature [20][35];
	/**
	 * The constructor of the World containing two parameters:
	 * @param numPasses number of passes used for the whole simulation
	 * @param seed the seed to initialize the random number generator for the simulation
	 */
	public World(int numPasses, int seed) {
		// TODO: put your code here
		for(int i=0;i<20;i++){
			for(int j=0;j<35;j++){
				map[i][j] = null;
			}			
		}
		pass=numPasses;
		Random r1 = new Random(seed);
		for(int i=0;i<5;i++){
			int p=r1.nextInt(20), q=r1.nextInt(35);
			if(map[p][q]==null){
				Goat goat = new Goat(0,20,1);
				map[p][q]=goat;
			}
			else{ 
				i--;
			}
		}
		for(int j=0;j<10;j++){
			int p=r1.nextInt(20), q=r1.nextInt(35);
			if(map[p][q]==null){
				Grass grass = new Grass(0,1);
				map[p][q] = grass;
			}
			else{
				j--;
			}
		}

	}

	/** the main loop use for the simulation and showing the result to the screen 
	 * periodically.
	 * @param displayInterval the number of passes for each display of the world
	 */

	public void mainLoop(int displayInterval) {

		// TODO: put your code here
		int dir=0;
		for (int i =0 ;i<pass;i++){
			if(i == 0){
				System.out.println(" 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4");
				for(int a=0;a<20;a++){
					if(a<=9){
						System.out.print(a);
					}
					else if(a>9){
						System.out.print(a%10 );
					}
					for(int b=0;b<70;b++){
						if(b%2==0 && map[a][b/2]!=null && map[a][b/2].getid()==1){
							System.out.print('X');
						}
						else if(b%2==0 && map[a][b/2]!=null && map[a][b/2].getid()==2){
							System.out.print('I');
						}
						else {
							System.out.print(' ');
						}
					}
					System.out.println();
				}
				System.out.println("------------------------------------------------------------------------");
			}


			else{
				for(int a=0;a<20;a++){
					for(int b=0;b<35;b++){
						if(map[a][b]!=null){
							if(map[a][b].getid()==2 && map[a][b].getaction()==i){
								map[a][b].updateage();
							}
							if(map[a][b].getid()==1 && map[a][b].getaction()==i){
								map[a][b].updateage();	
								map[a][b].updatepoint(-1);
							}
							
							dir=map[a][b].getdirect();
							
							if(map[a][b].getid()==1 && (map[a][b].getage()>=50 && map[a][b].getage()<=55)){
								if(a-1>=0 && dir==0){
									if(map[a-1][b]==null){
										Goat goat=new Goat(0,20,i+1);
										map[a-1][b]=goat; //born goat
										map[a][b].updateaction();
									}
									else if(map[a-1][b]!=null && map[a-1][b].getid()==2){
										map[a-1][b]=null;
										Goat goat=new Goat(0,20,i+1);
										map[a-1][b]=goat; //born goat
										map[a][b].updateaction();
										map[a][b].updatepoint(5);
									}
									else if(a-1<0 || (map[a-1][b]!=null && map[a-1][b].getid()==1)){
										dir=map[a][b].getdirect();
									}
								}
								else if(a+1<20 && dir==1){
									if(map[a+1][b]==null ){
										Goat goat=new Goat(0,20,i+1);
										map[a+1][b]=goat; //born goat
										map[a][b].updateaction();
									}
									else if(map[a+1][b]!=null && map[a+1][b].getid()==2){
										map[a+1][b]=null;
										Goat goat=new Goat(0,20,i+1);
										map[a+1][b]=goat; //born goat
										map[a][b].updateaction();
										map[a][b].updatepoint(5);
									}
									else if(a+1>=20 || (map[a+1][b]!=null && map[a+1][b].getid()==1)){
										dir=map[a][b].getdirect();
									}
								}
								else if(b-1>=0 && dir==2){
									if(map[a][b-1]==null ){
										Goat goat=new Goat(0,20,i+1);
										map[a][b-1]=goat; //born goat
										map[a][b].updateaction();
									}
									else if(map[a][b-1]!=null && map[a][b-1].getid()==2){
										map[a][b-1]=null;
										Goat goat=new Goat(0,20,i+1);
										map[a][b-1]=goat; //born goat
										map[a][b].updateaction();
										map[a][b].updatepoint(5);
									}
									else if(b-1<0 || (map[a][b-1]!=null && map[a][b-1].getid()==1)){
										dir=map[a][b].getdirect();
									}
								}
								else if(b+1<35 && dir==3){
									if(map[a][b+1]==null ){
										Goat goat=new Goat(0,20,i+1);
										map[a][b+1]=goat; //born goat
										map[a][b].updateaction();
									}
									else if(map[a][b+1]!=null && map[a][b+1].getid()==2){
										map[a][b+1]=null;
										Goat goat=new Goat(0,20,i+1);
										map[a][b+1]=goat; //born goat
										map[a][b].updateaction();
										map[a][b].updatepoint(5);
									}
									else if(b+1>35 || (map[a][b+1]!=null && map[a][b+1].getid()==1)){
										dir=map[a][b].getdirect();
									}
								}
							} //50 55
							if(map[a][b].getid()==2 && (map[a][b].getage()>=3 && map[a][b].getage()<=5)){
								if(a-1>=0 && map[a-1][b]==null && dir==0){
									Grass grass=new Grass(0,i+1);
									map[a-1][b]=grass;
								}
								else if(a+1<20 && map[a+1][b]==null && dir==1){
									Grass grass=new Grass(0,i+1);
									map[a+1][b]=grass;
								}
								else if(b-1>=0 && map[a][b-1]==null && dir==2){
									Grass grass=new Grass(0,i+1);
									map[a][b-1]=grass;
								}
								else if(b+1<35 && map[a][b+1]==null && dir==3){
									Grass grass=new Grass(0,i+1);
									map[a][b+1]=grass;
								}
								map[a][b].updateaction();
							} // <=5
							if(map[a][b].getid()==2 && map[a][b].getage()<3 && map[a][b].getaction()==i){
								map[a][b].updateaction();
							}
							if(map[a][b]!=null&& map[a][b].getid()==1 && (map[a][b].getage()>=70 || map[a][b].getpoint()<=0)){
								map[a][b]=null; //goat die
							}
							if(map[a][b]!=null && map[a][b].getid()==2 && map[a][b].getage()>=6){
								map[a][b]=null;  //grass die
							}
						}// IF
						if(map[a][b]!=null && map[a][b].getid()==1 && dir==0){  //up
							if(a-1>=0 && ((map[a-1][b]!=null && map[a-1][b].getid()==2 ) || map[a-1][b]==null)){
								if(map[a][b].getaction()==i){
									map[a][b].updateaction();
									if(map[a-1][b]!=null && map[a-1][b].getid()==2){
										map[a][b].updatepoint(5); //eat grass
									}
									map[a-1][b]=map[a][b];
									map[a][b]=null;
								}
							}
							else if((a-1<0 || map[a-1][b].getid()==1) && map[a][b].getaction()==i){
								map[a][b].updateaction();
							}
						}
						else if(map[a][b]!=null && map[a][b].getid()==1 && dir==1){ //down
							if(a+1<20 && ((map[a+1][b]!=null && map[a+1][b].getid()==2) || map[a+1][b]==null)){
								if(map[a][b].getaction()==i){
									map[a][b].updateaction();
									if(map[a+1][b]!=null && map[a+1][b].getid()==2){
										map[a][b].updatepoint(5);
									}
									map[a+1][b]=map[a][b];
									map[a][b]=null;
								}
							}
							else if((a+1>=20 || map[a+1][b].getid()==1) && map[a][b].getaction()==i){
								map[a][b].updateaction();
							}
						}
						else if(map[a][b]!=null && map[a][b].getid()==1 && dir==2){ //left
							if(b-1>=0 && ((map[a][b-1]!=null && map[a][b-1].getid()==2) || map[a][b-1]==null)){
								if(map[a][b].getaction()==i){
									map[a][b].updateaction();
									if(map[a][b-1]!=null && map[a][b-1].getid()==2){
										map[a][b].updatepoint(5);
									}
									map[a][b-1]=map[a][b];
									map[a][b]=null;
								}
							}
							else if((b-1<0 || map[a][b-1].getid()==1) && map[a][b].getaction()==i){
								map[a][b].updateaction();
							}
						}
						else if(map[a][b]!=null && map[a][b].getid()==1 && dir==3){ //right
							if(b+1<35 && ((map[a][b+1]!=null && map[a][b+1].getid()==2) || map[a][b+1]==null)){
								if(map[a][b].getaction()==i){
									map[a][b].updateaction();
									if(map[a][b+1]!=null && map[a][b+1].getid()==2){
										map[a][b].updatepoint(5);
									}
									map[a][b+1]=map[a][b];
									map[a][b]=null;
								}
							}
							else if((b+1>=35 || map[a][b+1].getid()==1) && map[a][b].getaction()==i){
								map[a][b].updateaction();
							}
						}
					}
				}
				if(i%displayInterval==0){ //when i need to print
					System.out.println(" 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4");
					for(int a=0;a<20;a++){
						if(a<=9){
							System.out.print(a );
						}
						else if(a>9){
							System.out.print( a%10 );
						}
						for(int b=0;b<70;b++){
							if(b%2==0 && map[a][b/2]!=null && map[a][b/2].getid()==1){
								System.out.print('X');
							}
							else if(b%2==0 && map[a][b/2]!=null && map[a][b/2].getid()==2){
								System.out.print('I');
							}
							else {
								System.out.print(' ');
							}
						}
						System.out.println();
					}
					System.out.println("------------------------------------------------------------------------");
				}
			}

		}
	}
}
