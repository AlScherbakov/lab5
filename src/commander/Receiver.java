package commander;

import util.DataInputSource;
import util.StudyGroup;

import java.io.BufferedReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.TreeSet;

public class Receiver {
    private TreeSet<StudyGroup> collection;
    private String outputFilepath;
    private ArrayList<CommandEnum> history;
    private boolean working;
    private DataInputSource source;
    public String collectionInitializationDate;
    private final Deque<BufferedReader> readers = new ArrayDeque<>();
    public Receiver(TreeSet<StudyGroup> c, String o, ArrayList<CommandEnum> h, boolean w, DataInputSource s, String cid){
        collection = c;
        outputFilepath = o;
        history = h;
        working = w;
        source = s;
        collectionInitializationDate = cid;
    }
    public TreeSet<StudyGroup> getCollection(){
        return collection;
    }
    public String getOutputFilepath(){
        return outputFilepath;
    }
    public ArrayList<CommandEnum> getHistory(){
        return history;
    }
    public boolean getWorking(){
        return working;
    }
    public DataInputSource getSource(){
        if (!readers.isEmpty()){
            return new DataInputSource(readers.getFirst());
        }
        return source;
    }
    public String getCollectionInitializationDate(){
        return collectionInitializationDate;
    }
    public Deque<BufferedReader> getReaders(){
        return readers;
    }
    public void setCollection(TreeSet<StudyGroup> c){
        collection = c;
    }
    public void setOutputFilepath(String o){
        outputFilepath = o;
    }
    public void setHistory(ArrayList<CommandEnum> h){
        history = h;
    }
    public void setWorking(boolean w){
        working = w;
    }
    public void setSource(DataInputSource s){
        source = s;
    }
    public void setCollectionInitializationDate(String d){
        collectionInitializationDate = d;
    }

    public void pushReader(BufferedReader r){
        readers.push(r);
    }

    public void removeFirstReader(){
        readers.remove();
    }

    public void addToCollection(StudyGroup e){
        collection.add(e);
    }

}