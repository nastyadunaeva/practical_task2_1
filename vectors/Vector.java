package vectors;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.util.StringTokenizer;

/*
 * Класс, описывающий вектор
 */
public class Vector {
    private int[] vector;
    public Vector() {}
    /*
     * Конструктор, принимающий в качестве аргумента длину вектора
     */
    public Vector (int size) {
        this.vector = new int[size];
    }
    /*
     * Конструктор, принимающий в качестве аргумента массив
     */
    public Vector (int[] vector) {
        this.vector = vector;
    }
    /*
     * Возвращает значение координат вектора
     */
    public int[] getVector() {
        return this.vector;
    }
    /*
     * Устанавливает значение координат вектора
     */
    public void setVector(int[] vector) {
        this.vector = vector;
    }
    /*
     * Возвращает значение координаты по ее номеру
     */
    public int getValue(int idx) {
        return this.vector[idx];
    }
    /*
     * Устанавливает значение координаты по ее номеру
     */
    public void setValue(int idx, int value) {
        this.vector[idx] = value;
    }
    /*
     * Возвращает длину вектора
     */
    public int getCount() {
        return this.vector.length;
    }
    
	/*
	 * Возвращает произведение вектора на число
	 */
	public static Vector multiply(Vector argVector, int num) {
		int len = argVector.getCount();
		Vector result = new Vector(len);
		for (int i = 0; i < len; i++) { 
			result.setValue(i, argVector.getValue(i) * num);
		}
		return result;
	}
	/*
	 * Возвращает скалярное произведение двух векторов
	 * Бросает исключение ArithmeticException, если длины
	 * векторов не совпадают
	 */
	public static int scalarProduct(Vector v1, Vector v2) {
		int len1 = v1.getCount();
		int len2 = v2.getCount();
		if (len1 != len2) {
			throw new ArithmeticException();
		}
		int result = 0;
		for (int i = 0; i < len1; i++) {
			result += v1.getValue(i) * v2.getValue(i);
		}
		return result;
	}
	/*
	 * Возвращает сумму двух векторов
	 * Бросает исключение ArithmeticException, если длины
	 * векторов не совпадают
	 */
	public static Vector add(Vector v1, Vector v2) {
		int len1 = v1.getCount();
		int len2 = v2.getCount();

		if (len2 != len1) {
			throw new ArithmeticException();
		}
		Vector result = new Vector(len1);
		for (int i = 0; i < len1; i++) {
			result.setValue(i, v1.getValue(i) + v2.getValue(i));
		}
		return result;
	}
	/*
	 * Запись вектора в байтовый поток
	 */
	public void outputVector(Vector v, OutputStream out) {
		ByteBuffer dbuf = ByteBuffer.allocate(4);
		int len = v.getCount();
		dbuf.putInt(len);
		byte[] bytes = dbuf.array();
		try {
			out.write(bytes);
			for (int i = 0; i < len; i++) {
				dbuf.clear();
				dbuf.putInt(v.getValue(i));
				bytes = dbuf.array();
				out.write(bytes);
			}
		}
		catch (IOException ioe) {
			System.out.print(ioe.getMessage());
		}
	}
    /*
     * Чтение вектора из байтового потока
     */
	public Vector inputVector(InputStream in) {
		byte[] buffer = new byte[4];
		Vector vector = new Vector();
		try {
			in.read(buffer, 0, 4);
			ByteBuffer wrapped = ByteBuffer.wrap(buffer); // big-endian by default
			int len = wrapped.getInt(); // считали длину вектора
			for (int i = 0; i < len; i++) {
				in.read(buffer, 0, 4);
				ByteBuffer wr = ByteBuffer.wrap(buffer);
				int value = wr.getInt();
				vector.setValue(i, value);
			}
		}
		catch (IOException ioe) {
			System.out.print(ioe.getMessage());
		}
		return vector;
	}
	/*
	 * Запись вектора в символьный поток
	 */
	public void writeVector(Vector v, Writer out) {
		String vecStr = v.toString();
		try {
			out.write(vecStr);
			out.flush();
		}
		catch (IOException ioe) {
			System.out.print(ioe.getMessage());
		}
	}
	/*
	 * Чтение вектора из символьного потока
	 */
	public Vector readVector(Reader in) {
		char[] cbuf = new char[200];
		Vector vec = new Vector();
		try {
			in.read(cbuf);
			String string1 = new String(cbuf);
			string1 = string1.trim();
	
			StringTokenizer st = new StringTokenizer(string1, " \s");
			String lenStr = st.nextToken();
			int len = Integer.parseInt(lenStr);
			vec = new Vector(len);
			
			for (int i = 0; i < len; i++) {
				String coordStr = st.nextToken();
				int coord = Integer.parseInt(coordStr);
				vec.setValue(i, coord);
			}
		}
		catch (IOException ioe) {
			System.out.print(ioe.getMessage());
		}
		
		return vec;
	}
    @Override
    public String toString() {
        String result = "";
        for (int coord : vector) {
            result += String.valueOf(coord)+" ";
        }
        return result;
    }
}
