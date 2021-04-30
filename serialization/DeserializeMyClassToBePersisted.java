package serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializeMyClassToBePersisted {
	/*
	 * Метод печатает из файла десериализованный объект класса MyClassToBePersisted
	 */
	public static void deserialize(String fileName) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName)))
        {
			System.out.printf("Deserialized \n");
			System.out.printf("Profile: %s \t Group: %s \n", ois.readUTF(), ois.readUTF());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
	}
}
