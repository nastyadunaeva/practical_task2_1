package serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializeMyClassToBePersisted {
	/*
	 * Метод создает экземпляр класса с полями profile и group и
	 * сериализует его в файл с именем fileName
	 */
	public static void serialize(String profile, String group, String fileName) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName)))
        {
			MyClassToBePersisted item = new MyClassToBePersisted(profile, group);
			System.out.println("Serializing...");
            oos.writeUTF(item.getProfile()); //Записываем в файл непосредственно поля
            oos.writeUTF(item.getGroup());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
	}
}
