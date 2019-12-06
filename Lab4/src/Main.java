import java.util.Scanner;

import Tasks.Task1.*;


class Main {

    static private Exercise1 exercise1;
    static private Exercise2 exercise2;
    static private Exercise3 exercise3;

    static private void showMenu() {
        System.out.println("1. Task 1/Exercise 1");
        System.out.println("2. Task 1/Exercise 2");
        System.out.println("3. Task 1/Exercise 3");
    }

    static public void main(String []args) {
        exercise1 = new Exercise1();
        exercise2 = new Exercise2();
        exercise3 = new Exercise3();

        Scanner input = new Scanner(System.in);

        Main.showMenu();

        while (input.hasNextInt()) {
            Main.showMenu();

            switch (input.nextInt()) {
                case 1: {
                    System.out.println();
                    System.out.println("MyFile 1 created? " + exercise1.createMyFile1());
                    System.out.println();
                    System.out.println("MyFile 2 created? " + exercise1.createMyFile2());
                    System.out.println();
                    System.out.println("MyFile 3 created? " + exercise1.createMyFile3());
                    System.out.println();
                    System.out.println("MyFolder created? " + exercise1.createFolder());
                } break;
                case 2: {
                    System.out.println();
                    exercise2.checkFile("out/MyFile3.txt");
                    System.out.println();
                    exercise2.checkFolder("MyFolder");
                    System.out.println();
                    System.out.println("MyFile 1 exists? " + exercise2.checkMyFile1());
                } break;
                case 3: {
                    System.out.println();
                    exercise3.createNewFolder("NewFolder");
                    System.out.println();
                    exercise3.viewFiles();
                    System.out.println();
                    exercise3.viewFolders();
                    System.out.println();
                    exercise3.removeAllCreatedObjects();
                    System.out.println("All created files and folders was removed");
                } break;

            }
        }

        input.close();
    }

}
