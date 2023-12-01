package com.always.demo.test2;

public class Main extends ClassLoader {
    public static void main(String[] args) {
        Class<Student> studentClass = Student.class;
        String name = studentClass.getName();
        System.out.println(name);
        long nanoTime = System.nanoTime();
        System.out.println(nanoTime);  // 28382549562200
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return loadClass(name, false);
    }
}
