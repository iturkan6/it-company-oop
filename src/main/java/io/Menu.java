package io;

public interface Menu {
    void print(String line);
    default void printLn(String line) {
        print(line);
        print("\n");
    }
    String readLn();
}
