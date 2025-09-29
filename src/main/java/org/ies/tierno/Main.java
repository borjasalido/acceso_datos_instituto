package org.ies.tierno;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

@Log4j
public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            log.info("Introduce un path");
            String pathStr = scanner.nextLine();

            Student st = new Student("1X", "BOb", "Esponja");
            System.out.println(st.getName());
        }
}