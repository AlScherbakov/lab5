package commander;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import util.DataInputSource;
import util.StudyGroup;

import java.io.*;
import java.util.*;

/**
 * Client class from Command pattern. Main process host. May be used for creation of several application instances
 */
public class Client {
    private final Scanner scan;
    public Client(Scanner s){
        scan = s;
    };
    boolean active = true;

    /**
     * run method
     * @throws IOException
     */
    public void run() throws IOException {
        String outputFilepath = System.getenv("lab5_data_filepath");
        TreeSet<StudyGroup> groups = new TreeSet<>();
        Gson gson = new GsonBuilder().setDateFormat("dd.MM.yyyy HH:mm:ss").create();
        String collectionInitializationDate = "";
        try {
            if (outputFilepath != null){
                File outputFile = new File(outputFilepath);
                if (!outputFile.canRead()){
                    throw new RuntimeException("Can't read file " + outputFile);
                } else if (!outputFile.canWrite()){
                    throw new RuntimeException("Can't write to file " + outputFilepath);
                } else {
                    FileReader dataFileReader = new FileReader(outputFilepath);
                    StudyGroup[] data = gson.fromJson(dataFileReader, StudyGroup[].class);
                    Collections.addAll(groups, data);
                    collectionInitializationDate = new Date(new File(outputFilepath).lastModified()).toString();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл с данными не найден. Проверьте переменную окружения lab5_data_filepath");
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println("Проверьте формат входных данных");
        }
        ArrayList<CommandEnum> history = new ArrayList<>();
        System.out.println("Введите команду (help - помощь)");
        DataInputSource inputSource = new DataInputSource(scan);
        Receiver programState = new Receiver(groups, outputFilepath, history, true, inputSource, collectionInitializationDate);
            while (programState.getWorking() && active){
            String command = programState.getSource().get();
            if (command == null) {
                programState.removeFirstReader();
                continue;
            };
            Invoker invoker = new Invoker(programState);
            programState = invoker.executeCommand(command);
        }
    }

    /**
     * stop method
     */
    public void stop(){
        active = false;
    }
}
