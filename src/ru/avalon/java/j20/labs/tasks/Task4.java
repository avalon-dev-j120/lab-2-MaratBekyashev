package ru.avalon.java.j20.labs.tasks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import ru.avalon.java.j20.labs.Task;

import java.io.IOException;
import java.util.Properties;
import java.io.FileReader;
import java.io.InputStream;

/**
 * Задание №4
 *
 * <p>Тема: "Потоковый ввод-вывод. Чтение файлов конфигурации".
 */
public class Task4 implements Task {

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() throws IOException {
        Properties properties = read("resources/database.properties");

        /*
         * TODO(Студент): Выполнить задание №4
         *
         * 1. Реализовать метод read.
         *
         * 2. С использованием отладчика проверить корректность работы программы.
         */
    }

    /**
     * Выполняет чтение файла конфигураций описанного
     * параметром {@code path}.
     *
     * @param path путь к конфигурации
     * @return новый экземпляр типа {@link Properties}
     */
    private Properties read(String path) throws FileNotFoundException, IOException {
        InputStream stream = ClassLoader.getSystemResourceAsStream(path);
        Properties result = new Properties();
        result.load(stream);
        System.out.println("Property value with key \"db.mysql.url\" = " + result.getProperty("db.mysql.url"));
        return result;
    }
}
