package ru.job4j.inout;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class LogFilter читает файл
 *  и возвращает, где предпоследнее число - это 404
 *
 * @author Ruslan Shuyski
 * @version 2
 */
public class LogFilter {

    public static List<String> filter(String file) {
        List<String> list = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            list = in
                    .lines()
                    .filter(s ->
                            s.contains("404 ")
                                    && !s.contains("404 -")
                                   )
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
    }
}