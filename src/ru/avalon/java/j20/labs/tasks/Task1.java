package ru.avalon.java.j20.labs.tasks;

import ru.avalon.java.j20.labs.Task;

import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;

/**
 * Задание №1
 *
 * <p>Тема: "Потоковый ввод-вывод. Чтение и запись данных
 * в двоичном режиме".
 */
public class Task1 implements Task {

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() throws IOException {
        
        File input = new File("../assets/countries.txt");
        File outputF = new File("countries_binary_mode_output.txt");

        String text = read(input);
        write(outputF, text);

        /*
         * TODO(Студент): Выполнить задание №1
         *
         * 1. Реализовать метод read.
         *
         *    При чтении файла следует пользоваться типами данных:
         *    InputStream и FileInputStream.
         *
         *    Для сохранениня прочитанных данных следует пользоваться
         *    классом ByteArrayOutputStream.
         *
         * 2. Реализовать метод write.
         *
         *    При реализации метода следует пользоваться типами данных:
         *    OutputStream и FileOutputStream.
         *
         * 3. С использованием отладчика проверить корректность работы программы.
         */
    }

    /**
     * Выполняет чтение указанного файла в двоичном режиме.
     *
     * <p>Весь текст файла возвращается в виде одного
     * экземпляра типа {@link String}.
     *
     * @param file файл
     * @return содержимое файла в виде текста.
     * @throws IOException в случае ошибок ввода-вывода.
     */
    private String read(File file) throws IOException {
        byte[] buffer = new byte[2048];
        FileInputStream stream = null;
        ByteArrayOutputStream outStr = null;
        try {
          stream = new FileInputStream(file);
          outStr = new ByteArrayOutputStream();
          int i;
          while((i = stream.read(buffer, 0, 2048)) >= 0)
            outStr.write(buffer, 0, i);
        }
        catch(IOException ex){
          System.out.println("Some IO.Exception"); 
        }
        finally {
          stream.close();
        }
        return outStr.toString();
    }

    /**
     * Выполняет запись текстоых данных в файл в двоичном
     * режиме.
     *
     * @param file файл
     * @param text текст
     * @throws IOException в случае ошибок ввода-вывода.
     */
    private void write(File file, String text) throws IOException {
      OutputStream stream = null;
         
      try {
        stream = new FileOutputStream(file);
        stream.write(text.getBytes());
      } 
      catch (IOException e) {
          // null;
      }
      finally{
        stream.flush();
        stream.close();
      }
    }
}
