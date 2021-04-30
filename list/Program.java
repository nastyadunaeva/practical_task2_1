package list;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;

public class Program {
	public static void main(String[] args) {
		/*
		 * Сериализация ArrayList
		 */
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serialized.txt")))
        {
            ArrayList<Integer> al = new ArrayList<Integer>();
            al.add(5);
            al.add(3);
            al.add(69);
            System.out.print("ArrayList: ");
            for (Integer i: al) {
				System.out.printf(i + " ");
			}
            System.out.printf("\nSerialization...\n");
            oos.writeObject(al);
        }
        catch(Exception ex){
             
            System.out.println(ex.getMessage());
        } 
		/*
		 * Десериализация ArrayList
		 */
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serialized.txt")))
        {
			ArrayList<Integer> p=(ArrayList)ois.readObject();
			System.out.printf("Deserialized ArrayList: ");
			for (Integer i: p) {
				System.out.printf(i + " ");
			}
            
        }
        catch(Exception ex){
             
            System.out.println(ex.getMessage());
        }
		/*
		 * Сериализация LinkedList
		 */
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serialized1.txt")))
        {
            LinkedList<Integer> al = new LinkedList<Integer>();
            al.add(7);
            al.add(82);
            al.add(50);
            System.out.print("\nLinkedList: ");
            for (Integer i: al) {
				System.out.printf(i + " ");
			}
            System.out.printf("\nSerialization...\n");
            oos.writeObject(al);
        }
        catch(Exception ex){
             
            System.out.println(ex.getMessage());
        } 
		/*
		 * Десериализация LinkedList
		 */
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serialized1.txt")))
        {
			LinkedList<Integer> p=(LinkedList)ois.readObject();
			System.out.printf("Deserialized LinkedList: ");
			for (Integer i: p) {
				System.out.printf(i + " ");
			}
            
        }
        catch(Exception ex){
             
            System.out.println(ex.getMessage());
        }
	}
}
