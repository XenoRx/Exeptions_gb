package Exeptions_Homework3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		int counter = 0;
		Scanner scanner = new Scanner(System.in);
		while (counter <= 2) {
			counter ++;
			
			System.out.print("Введите данные: ");
			String input = scanner.nextLine();
			
			try {
				String[] parts = input.split(" ");
				validateAmount(parts);
				
				String Фамилия = parts[0];
				String Имя = parts[1];
				String Отчество = parts[2];
				
				Date birthDate = parseBirthDate(parts[3]);
				long phoneNumber = parsePhoneNumber(parts[4]);
				Gender gender = parseGender(parts[5]);
				
				String record = generateRecord(Фамилия, Имя, Отчество, birthDate, phoneNumber, gender);
				writeToFile(Фамилия, record);
				
			} catch (WrongAmountException | WrongFormatException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	private static String generateRecord(String lastName, String firstName, String surname, Date birthDate, long phoneNumber, Gender gender) {
		return "Фамилия: " + lastName + "\n" +
				"Имя: " + firstName + "\n" +
				"Отчество: " + surname + "\n" +
				"Дата рождения: " + birthDate + "\n" +
				"Номер телефона: " + phoneNumber + "\n" +
				"Пол: " + gender;
	}
	
	private static void writeToFile(String lastName, String record) {
		String directoryPath = "src/main/java/Exeptions_Homework3/PeopleData";
		String fileName = lastName + ".txt";
		try {
			File directory = new File(directoryPath);
			File file = new File(directory, fileName);
			FileWriter writer = new FileWriter(file);
			writer.write(record);
			writer.close();
			System.out.println("Запись успешно сохранена в файл.");
		} catch (IOException e) {
			System.out.println("Ошибка при записи в файл: " + e.getMessage());
		}
	}
	
	
	// Валидация количества частей
	public static void validateAmount(String[] parts) throws WrongAmountException {
		if (parts.length != 6) {
			throw new WrongAmountException("Должно быть 6 частей данных");
		}
	}
	
	// Парсинг даты
	public static Date parseBirthDate(String date) throws WrongFormatException {
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		try {
			return format.parse(date);
		} catch (ParseException e) {
			throw new WrongFormatException("Неверный формат даты");
		}
	}
	
	// Парсинг номера
	public static long parsePhoneNumber(String number) throws WrongFormatException {
		try {
			return Long.parseLong(number);
		} catch (NumberFormatException e) {
			throw new WrongFormatException("Неверный формат номера телефона");
		}
	}
	
	// Парсинг пола
	public static Gender parseGender(String gender) throws WrongFormatException {
		try {
			return Gender.valueOf(gender.toLowerCase());
		} catch (IllegalArgumentException e) {
			throw new WrongFormatException("Неверный формат пола");
		}
	}
	
	static class WrongAmountException extends Exception {
		public WrongAmountException(String message) {
			super(message);
		}
	}
	
	static class WrongFormatException extends Exception {
		public WrongFormatException(String message) {
			super(message);
		}
	}
	
}