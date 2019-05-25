package com.resumebase.webapp;

import java.io.File;

public class MainFile {
    public static void main(String[] args) {
/*        String filePath = ".\\.gitignore";
        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }

        File dir = new File(".\\src\\com\\resumebase\\webapp");
        System.out.println(dir.isDirectory());
        String[] list = dir.list();
        if (list != null)
            for (String name : list) System.out.println(name);

        try (FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        //recursive cycle for directory basejava
        String root = ".\\";
        File f = new File(root);
        if (!f.exists()) {
            System.out.println("\nNot found: " + root);
        }

        if (!f.isDirectory()) {
            System.out.println(
                    "\nNot directory: " + root);
        }
        list(root);

    }

    static void list(String dir) {
        File mainDir = new File(dir);
        String[] dirs = mainDir.list();

        for (int i = 0; i < dirs.length; i++) {
            File f = new File(dir + File.separator + dirs[i]);
            if (f.isFile())
                System.out.println(dir + File.separator + dirs[i]);
            else
                list(dir + File.separator + dirs[i]);
        }
    }
}
