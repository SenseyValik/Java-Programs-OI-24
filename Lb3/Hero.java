package Lb3;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Hero {
	Scanner scan = new Scanner(System.in);
	String name;
	int health;
	int damage;
	int defends = 30;
	Hero(int health,int damage,String name){
		this.health = health;
		this.damage = damage;
		this.name = name;
	}
	BiConsumer<Hero,Hero> attack = (Hero me,Hero other) ->{
		other.health -= me.damage;
	};
	Consumer<Hero> defend = (Hero me) ->{
		me.health += defends;
	};
	@Override
	public String toString() {
		return this.name+" : health = "+this.health +"\n     damage = "+this.damage +"\n     defend = "+this.defends;			  		
	}
	//«м≥нити характеристики геро€
	void changeHero(int operation) {
		System.out.println("¬ведiть кiлькiсть зм≥ни");
		int num = scan.nextInt();
		switch(operation) {
			case 1:
				this.health = num;
				break;
			case 2:
				this.damage = num;
				break;
			case 3:
				this.defends = num;
				break;
						
		}	

	}
}
