package org.ies.tierno.serialization;

import org.ies.tierno.Student;

import java.io.*;

public class NativeSerializationDemo {
    public static void writeToFile(Student p, File file) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(p);
        }
    }

    public static Student readFromFile(File file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Student) ois.readObject();
        }
    }

    public static void main(String[] args) throws Exception {
        File f = new File("student.bin");
        Student back = readFromFile(f);
        System.out.println("Name: " + back.toString());
    }
}