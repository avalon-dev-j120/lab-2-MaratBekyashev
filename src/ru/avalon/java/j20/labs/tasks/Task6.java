package ru.avalon.java.j20.labs.tasks;

import ru.avalon.java.j20.labs.Task;
import ru.avalon.java.j20.labs.models.Country;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;

import java.io.Reader;
import java.io.InputStream;


/**
 * Задание №6
 *
 * <p>Тема: "Потоковый ввод-вывод. Получение объекта на
 * основании прочитанных данных".
 */
public class Task6 implements Task {

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() throws IOException {
        File input = new File("assets/countries.txt");
        Collection<Country> countries = read(input);

        for (Country cou: countries)
            System.out.println("ISO: "+cou.getCode()+", NAME: "+ cou.getName());

        /*
         * TODO(Студент): Выполнить задание №6
         *
         * 1. Реализовать метод read.
         *
         * 2. При реализации следует пользоваться классами:
         *    BufferedReader и Country.
         *
         * 3. С использованием отладчика проверить корректность работы программы.
         */
    }

    /**
     * Выполняет чтение коллекции объектов типа {@link Country}
     * из указанного файла.
     *
     * <p>Выполняет чтение файла построчно. Преобразование
     * из текста в объект выполняется с использованием
     * метода {@code valueOf} класса {@link Country}.
     *
     * @param file файл
     * @return коллекция объектов типа {@link Country}
     * @throws IOException в случае ошибки ввода-вывода.
     */
    private Collection<Country> read(File file) throws IOException {
        LinkedList<Country> countryList = new LinkedList();
        ArrayList<Country> result = null;

        try (InputStream stream = new FileInputStream(file);
             Reader reader = new InputStreamReader(stream);
             BufferedReader input = new BufferedReader(reader)) {

            Collection<Country> buffer = new LinkedList<>();

            String countryRow;
            while ((countryRow = input.readLine()) != null) {
                try{
                  buffer.add(Country.valueOf(countryRow));
                   }
                catch (ParseException e){
                    System.out.println("ошибка парсинга строки \""+ countryRow + "\"");
                }
            }
            return new ArrayList<Country>(buffer);
        }

    }
}
