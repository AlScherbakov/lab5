package commander;

import com.google.gson.*;

import util.StudyGroup;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.TreeSet;

/**
 * Save command writes data into output file
 */

public class SaveCommand extends Command{
    String outputFilepath;
    TreeSet<StudyGroup> collection;
    public SaveCommand(String path, TreeSet<StudyGroup> c){
        outputFilepath = path;
        collection = c;
        this.name = CommandEnum.SAVE;
    }
    @Override
    public Boolean execute(){
        try{
            Gson gson = new GsonBuilder().setDateFormat("dd.MM.yyyy HH:mm:ss").create();
            File outputFile = new File(outputFilepath);
            OutputStream os = new FileOutputStream(outputFile);
            BufferedOutputStream br = new BufferedOutputStream(os, 16384);
            br.write(gson.toJson(collection).getBytes(StandardCharsets.UTF_8));
            br.close();
            os.close();
            System.out.println("Коллекция сохранена в файл");
            return true;
        } catch (Exception e){
            System.out.println("Возникла ошибка при сохранении коллекции в файл, попробуйте ещё раз");
            return false;
        }
    }

    @Override
    public String describe() {
        return "save : сохранить коллекцию в файл";
    }
}
