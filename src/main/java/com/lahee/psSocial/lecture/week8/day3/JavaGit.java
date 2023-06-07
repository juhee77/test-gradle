package com.lahee.psSocial.lecture.week8.day3;

public class JavaGit {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("usage: add, commit");
        } else {
            switch (args[0]) {
                case "add" -> {
                    System.out.println("add changes to git:");
                    for (int i = 1; i < args.length; i++) {
                        System.out.println(args[i]);
                    }
                }
                case "commit" -> {
                    if (args.length > 1) {
                        if (args[1].equals("-m")) {
                            System.out.printf("commit with message: ");
                            for (int i = 2; i < args.length; i++) {
                                System.out.printf("%s ", args[i]);
                            }
                            System.out.println();
                        } else {
                            System.out.println("[ERROR] use -m command");
                        }
                    } else {
                        System.out.println("no message specified");
                    }
                }
                default -> System.out.println("[ERROR] check spell");
            }
        }
    }
}
