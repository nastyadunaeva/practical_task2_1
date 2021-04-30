package vectors;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Program {
	public static void main(String[] args) {
		int[] arr1  = {2, 1, 0, 9, -5};
		int[] arr2  = {3, 5, 2, -7, 1};
	
		Vector vec1 = new Vector(arr1);
		Vector vec2 = new Vector(arr2);
		Vector vec3 = new Vector();
		
		System.out.println("Vector 1:  " + vec1.toString());
		System.out.println("Vector 2:  " + vec2.toString());
		System.out.println();
		
		System.out.println("multuply by 2:  " + Vector.multiply(vec1, 2).toString());
		System.out.println("scalar product:  " + Vector.scalarProduct(vec1, vec2));
		System.out.println("add vectors:  " + Vector.add(vec1, vec2).toString());
		System.out.println();
		
		System.out.print("Enter a string with vector (for readVector method):  ");
		InputStream inStream = System.in;
		InputStreamReader isr = new InputStreamReader(inStream);
		System.out.println("Vector: " + vec1.readVector(isr));
		System.out.println();
		
		OutputStream outStream = System.out;
		OutputStreamWriter osw = new OutputStreamWriter(outStream);
		System.out.print("writeVector method for vector 2:  ");
		vec2.writeVector(vec2, osw);
	}
}
