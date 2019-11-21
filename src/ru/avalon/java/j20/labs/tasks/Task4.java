package ru.avalon.java.j20.labs.tasks;

import java.io.FileNotFoundException;
import ru.avalon.java.j20.labs.Task;

import java.io.IOException;
import java.util.Properties;
import java.io.FileReader;

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
        FileReader reader = new FileReader(path);
        Properties result = new Properties();
        result.load(reader);
        return result;
    }
}
