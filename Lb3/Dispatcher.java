package Lb3;
import java.util.Scanner;

public class Dispatcher {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {	
		while(true) {
			Hero me = new Hero(200,55,"Ivan");
			Bot enemy = new Bot(350,25,"DragonNight");
			Bot.fillParametr(200, 350);
			battle(me,enemy);
			if(me.health >0) {	//Перевірка на перемогу
				System.out.println("You WIN!");
			}else {
				System.out.println("You LOSE!");
			}
			System.out.println("\n\n\n");
			//Перевірка продовжити ігру
			System.out.println("1 - продовжити \n2 - вийти");
			int temp =scanInt(1,3,0);
			if(temp == 1) {
				System.out.println("\n\n\n");
			}else if(temp == 2) {
				System.out.println("Iгра завершена");
				break;
			}
		}
	
	}
	public static void battle(Hero me,Bot enemy) {
		//Текстове меню
		System.out.println(me+"\n"+enemy);
		System.out.println("Правила iгри: \n1 - атакувати супротивника \n2 - оборонятись'+"+me.defends+"хп'");
		System.out.println("Battle Start!");
		
		//Головний цикл
		boolean counter =  true;
		boolean exit = true;
		while(exit) {
			System.out.println("Ваш хiд");
			int action = scanInt(1,3,1);
			switch(action){	//дії
				case 1: // Атака
					me.attack.accept(me, enemy);
					System.out.println(enemy.name + " : health = " + enemy.health);
					break;
				case 2: //Захист
					me.defend.accept(me);
					System.out.println(me.name + " : health = " + me.health);
					break;
				case 666://Настройка персонажа
					counter = false;
					System.out.println("Вiдкритий режим змiни героя чи бота \nвиберите персонажа для змiни\n1 - me \n2 - enemy ");
					int temp = scanInt(1,3,0);
					System.out.println("Введiть характеристику для змiни \n1 - змінити health \n2 - змінити damage \n3 - змінити defend");
					if(temp == 1) {
						me.changeHero(scanInt(1,4,0));
					}else if(temp == 2) {
						enemy.changeHero(scanInt(1,1,0));
					}
					System.out.println(me+"\n"+enemy);
					break;
				case 101: //Вихід
					exit = false;
					counter = false;
					break;				
			}
			
			
			//Перевірка на кінець ігри
			if(me.health <= 0 || enemy.health <= 0) {
				break;
			}
			//Хід бота
			if(counter) {
				enemy.says(action);
				enemy.play(enemy,me);
			}
			counter = true;
			//Перевірка на кінець ігри
			if(me.health <= 0 || enemy.health <= 0) {
				break;
			}
			System.out.println("\n\n\n");
		}
			
		
	}
	
	//Цей метод перевіряє чи стрічка є числом
	//Ми можем вводити
	//гілка 1 - (i = j , exept любе)		любі числа
	//гілка 2 - (i != j , ecxept = 0)	    i <= число < j 
	//гілка 3 - (i = j , ecxept = 1)		тоді гілка 2 + виключення(додаткові цифри);    
	static int scanInt(int i,int j, int except) {
		int num = 0;
		while(true) {
			System.out.print("Введiть цифру : ");
			String ln = scan.nextLine();		
			try {
				num = Integer.parseInt(ln);
				if(i != j ) {
					if( (i <= num && j > num) || ((num == 666 || num == 101) && except == 1)  ) {
						break;	
					}
					System.out.println("Ви ввели символ за межою дозволених!");
					continue;
				} 
				break;

			}catch(Exception e) {
				System.out.println("Ви ввели неправильний символ!");
				num = 0;
			}
		
		}
		return num;
	}
	


}
