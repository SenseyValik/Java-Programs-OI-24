package Lb3;
import java.util.Random;

public class Bot extends Hero{
	Random rd = new Random();
	
	static int basic_heals_hero;
	static int basic_heals_enemy;
	static void fillParametr(int bhh,int bhe) {
		basic_heals_hero = bhh;
		basic_heals_enemy = bhe;
	}
	
	Bot(int health, int damage,String name) {
		super(health, damage,name);
	}
	
	//Метод рандомної репліки бота в залежності від зробленої вами дії
	void says(int how) {
		//Двовимірний масив реплік { {РАДІСТЬ} , {СУМНО} , {ЗЛІСТЬ} }
		String[][] replica = {{"Haahahha","Oh Right!","UHOOOOO!","TA DA DA DA!"},{"I`m sad","But Why?","Its imposible"},{"You are stupid!","I WILL KILL YOU!","POOP!"}};
		System.out.print(this.name+" : " );
		//Якшо ми атакуєм то в бота репліка {Сум} або {Злість}
		if(how == 1) {			
			 System.out.println(replica[rd.nextInt(3 - 1) + 1][rd.nextInt(3)]);
		}else {
			 System.out.println(replica[0][rd.nextInt(4)]);
		}
	}
	
	//Автохід бота
	void play(Bot bot,Hero me) {
		switch(rd.nextInt(3-1)+1){
			case 1:
				System.out.println(bot.name + " Attack!");
				this.attack.accept(bot,me);
				System.out.println(me.name + " : health = " + me.health);
				break;
			case 2:
				System.out.println(bot.name + " defend");
				bot.defend.accept(bot);
				System.out.println(bot.name + " : health = " + bot.health);
				break;
		}
	}
	void action_brain() {
		
	}

}
