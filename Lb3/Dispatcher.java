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
			if(me.health >0) {	//�������� �� ��������
				System.out.println("You WIN!");
			}else {
				System.out.println("You LOSE!");
			}
			System.out.println("\n\n\n");
			//�������� ���������� ����
			System.out.println("1 - ���������� \n2 - �����");
			int temp =scanInt(1,3,0);
			if(temp == 1) {
				System.out.println("\n\n\n");
			}else if(temp == 2) {
				System.out.println("I��� ���������");
				break;
			}
		}
	
	}
	public static void battle(Hero me,Bot enemy) {
		//�������� ����
		System.out.println(me+"\n"+enemy);
		System.out.println("������� i���: \n1 - ��������� ������������ \n2 - �����������'+"+me.defends+"��'");
		System.out.println("Battle Start!");
		
		//�������� ����
		boolean counter =  true;
		boolean exit = true;
		while(exit) {
			System.out.println("��� �i�");
			int action = scanInt(1,3,1);
			switch(action){	//䳿
				case 1: // �����
					me.attack.accept(me, enemy);
					System.out.println(enemy.name + " : health = " + enemy.health);
					break;
				case 2: //������
					me.defend.accept(me);
					System.out.println(me.name + " : health = " + me.health);
					break;
				case 666://��������� ���������
					counter = false;
					System.out.println("�i������� ����� ��i�� ����� �� ���� \n�������� ��������� ��� ��i��\n1 - me \n2 - enemy ");
					int temp = scanInt(1,3,0);
					System.out.println("����i�� �������������� ��� ��i�� \n1 - ������ health \n2 - ������ damage \n3 - ������ defend");
					if(temp == 1) {
						me.changeHero(scanInt(1,4,0));
					}else if(temp == 2) {
						enemy.changeHero(scanInt(1,1,0));
					}
					System.out.println(me+"\n"+enemy);
					break;
				case 101: //�����
					exit = false;
					counter = false;
					break;				
			}
			
			
			//�������� �� ����� ����
			if(me.health <= 0 || enemy.health <= 0) {
				break;
			}
			//ճ� ����
			if(counter) {
				enemy.says(action);
				enemy.play(enemy,me);
			}
			counter = true;
			//�������� �� ����� ����
			if(me.health <= 0 || enemy.health <= 0) {
				break;
			}
			System.out.println("\n\n\n");
		}
			
		
	}
	
	//��� ����� �������� �� ������ � ������
	//�� ����� �������
	//���� 1 - (i = j , exept ����)		��� �����
	//���� 2 - (i != j , ecxept = 0)	    i <= ����� < j 
	//���� 3 - (i = j , ecxept = 1)		��� ���� 2 + ����������(�������� �����);    
	static int scanInt(int i,int j, int except) {
		int num = 0;
		while(true) {
			System.out.print("����i�� ����� : ");
			String ln = scan.nextLine();		
			try {
				num = Integer.parseInt(ln);
				if(i != j ) {
					if( (i <= num && j > num) || ((num == 666 || num == 101) && except == 1)  ) {
						break;	
					}
					System.out.println("�� ����� ������ �� ����� ����������!");
					continue;
				} 
				break;

			}catch(Exception e) {
				System.out.println("�� ����� ������������ ������!");
				num = 0;
			}
		
		}
		return num;
	}
	


}
