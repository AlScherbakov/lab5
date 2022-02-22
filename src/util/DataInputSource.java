package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class DataInputSource {
    private Scanner scan;
    private BufferedReader reader;
    public DataInputSource(Scanner scan){
        this.scan = scan;
    }
    public DataInputSource(BufferedReader reader){
        this.reader = reader;
    }
    public String get() throws IOException {
        return scan != null ? scan.nextLine() : reader.readLine();
    }
    public boolean hasNext() throws IOException {
        return scan != null ? scan.hasNext() : reader.readLine() != null;
    }
}