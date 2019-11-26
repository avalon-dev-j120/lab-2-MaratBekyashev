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
        //System.out.println(System.getProperties().get("java.class.path"));
      //BufferedReader areader = new BufferedReader(new FileReader(path));
        //FileReader reader = new FileReader(path);
        InputStream stream = ClassLoader.getSystemResourceAsStream(path);
        Properties result = new Properties();
        result.load(stream);
        String line = result.getProperty("db.mysql.url");
        System.out.println(" " + line );
        return result;
    }
}
