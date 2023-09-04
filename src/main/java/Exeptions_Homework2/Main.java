package Exeptions_Homework2;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
//		Float result = getFloat(); //Задача1
//		System.out.println(result); //Задача1
//		Task2();
//		Task3();
//		NoEmptySpaces();
	}
	
	public static void NoEmptySpaces() { // Задача 4
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите текст: ");
		String input = scanner.nextLine();
		if (input.isEmpty()) {
			throw new IllegalArgumentException("Пустые строки вводить нельзя!");
		}
		System.out.println("Было введено: " + input);
		
	}
	
	public static void Task3() {  //Задача 3
		try {
			int a = 90;
			int b = 3;
			System.out.println(a / b);
			printSum(23, 234);
			int[] abc = {1, 2};
			abc[3] = 9;
		} catch (NullPointerException ex) {
			System.out.println("Указатель не может указывать на null!");
		} catch (IndexOutOfBoundsException ex) {
			System.out.println("Массив выходит за пределы своего размера!");
		} catch (Throwable ex) {
			System.out.println("Что-то пошло не так...");
		}
		
	}
	
	public static void printSum(Integer a, Integer b) throws FileNotFoundException { // Задача 3
		System.out.println(a + b);
	}
	
	
	public static void Task2() { // Задача 2
		int[] intArray = new int[]{2, 4, 7, 8, 2, 11, 2, 9, 1};
		try { // Задача 2
			int d = 0;
			double catchedRes1 = intArray[8] / d;
			System.out.println("catchedRes1 = " + catchedRes1);
		} catch (ArithmeticException e) {
			System.out.println("Catching exception: " + e);
			e.printStackTrace();
		}
	}
	
	public static float getFloat() { // Задача 1
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Введите число: ");
			String input = scanner.nextLine();
			try {
				return Float.parseFloat(input);
			} catch (NumberFormatException e) {
				System.out.println("Введено не число! Повторите попытку");
			}
		}
	}
	
	
}
