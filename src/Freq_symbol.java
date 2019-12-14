import java.io.*;
import java.util.Scanner;

public class Freq_symbol {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String filename = in.next();
        Frequency.CountFreq(filename);
    }
}
