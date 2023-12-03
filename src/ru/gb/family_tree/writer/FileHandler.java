package ru.gb.family_tree.writer;


import java.io.*;

public class FileHandler implements ru.gb.family_tree.writer.Writable {
    public  boolean save(Serializable serializable, String path) {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Object read(String path) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            return objectInputStream.readObject();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
