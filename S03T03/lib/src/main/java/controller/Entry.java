package controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entry {
	
	private static final Scanner scanner = new Scanner(System.in);
	
	public static byte readByte(String missatge) {
		try {
			System.out.println(missatge);
			byte b = scanner.nextByte();
			scanner.nextLine();
			return b;
		}catch(InputMismatchException e) {
			System.out.println("Error de format.");
			scanner.next();
			return readByte(missatge);
		}
	}
	
	public static int readInt(String missatge, int max) {
		try {
			System.out.println(missatge);
			int i = scanner.nextInt();
			scanner.nextLine();
			if (max > 0 && i > max)
				throw new Exception();
			return i;
		}catch(InputMismatchException e) {
			System.out.println("Error de format.");
			scanner.next();
			return readInt(missatge, max);
		}catch(Exception e) {
			System.out.println("Valor fora del rang màxim: " + max);
			scanner.next();
			return readInt(missatge, max);
		}
	}
	
	public static float readFloat(String missatge) {
		try {
			System.out.println(missatge);
			float f = scanner.nextFloat();
			scanner.nextLine();
			return f;
		}catch(InputMismatchException e) {
			System.out.println("Error de format.");
			scanner.next();
			return readFloat(missatge);
		}
	}
	
	public static double readDouble(String missatge) {
		try {
			System.out.println(missatge);
			double d = scanner.nextDouble();
			scanner.nextLine();
			return d;
		}catch(InputMismatchException e) {
			System.out.println("Error de format.");
			scanner.next();
			return readDouble(missatge);
		}
	}
	
	public static char readChar(String missatge) {
		try {
			System.out.println(missatge);
			String out = scanner.nextLine();
			if (out.length() == 1)
				return out.charAt(0);
			else
				throw new Exception();
		}catch(Exception e) {
			System.out.println("Error de format.");
			return readChar(missatge);
		}
	}
	
	public static String readString(String missatge) {
		try {
			System.out.print(missatge);
			String out = scanner.nextLine();
			return out;
		}catch(Exception e) {
			System.out.println("Error de format.");
			return readString(missatge);
		}
	}
	
	public static boolean readSiNo(String missatge) {
		try {
			System.out.println(missatge);
			String out = scanner.nextLine();
			char c;
			if (out.length() == 1)
				c = out.charAt(0);
			else
				throw new Exception();
			
			if (Character.toLowerCase(c) == 's') return true;
			if (Character.toLowerCase(c) == 'n') return false;
			
			throw new Exception();
		}catch(Exception e) {
			System.out.println("Error de format.");
			return readSiNo(missatge);
		}
	}
}
