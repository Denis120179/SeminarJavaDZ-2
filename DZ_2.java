import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.PrintWriter;

public class DZ_2 {
    public static void main(String[] args) throws FileNotFoundException { 
        int[] params = readFile();
        int a = params[1];
        int b = params[0];
        if(a == 0 && b == 0) {
            writeFile("Not defined");        
        } else {double n = pow(a, b);
                String str = Double.toString(n); 
                writeFile(str);
        }               
    }
    // Метод считывания файла и получения чисел:
    public static int[] readFile() throws FileNotFoundException {
        File file = new File("input.txt"); 
        Scanner scanner = new Scanner(file); 
        String line = scanner.nextLine(); 
        int[] intArray = new int[2];
        String[] stringArray = line.split(" "); 
        int a = Integer.parseInt(stringArray[1]); 
        intArray[0] = a;
        line = scanner.nextLine(); 
        stringArray = line.split(" "); 
        a = Integer.parseInt(stringArray[1]); 
        intArray[1] = a;        
        scanner.close(); 
        return intArray;
    }
    // Возведение в степень
    public static double pow(int a, int b) {        
        if (b == 0 && a != 0) {
            return 1; 
        } if (b < 0 && a !=0) {
            return 1.0/(pow(a,-b));
        } 
        else {
            return a*pow(a, b - 1);
            }                     
        }    
    //Метод записи в файл:
    public static void writeFile(String str) throws FileNotFoundException {
        File file = new File("output.txt");
        String text = str;
        PrintWriter out = new PrintWriter(file);
        out.print(text);
        System.out.print(str);
        out.close(); 
    }
}