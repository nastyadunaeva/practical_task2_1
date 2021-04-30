package serialization;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a profile: ");
		String profile = scanner.nextLine();
		System.out.print("Enter a group: ");
		String group = scanner.nextLine();
		
		SerializeMyClassToBePersisted.serialize(profile, group, "serialized.txt");
		DeserializeMyClassToBePersisted.deserialize("serialized.txt");
		
		scanner.close();
	}
}
