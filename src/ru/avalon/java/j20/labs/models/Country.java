package ru.avalon.java.j20.labs.models;

import java.text.ParseException;
import java.util.Objects;

/**
 * Модель представления о стране.
 */
public class Country {
    /**
     * Код страны.
     */
    private final String code;
    /**
     * Название страны.
     */
    private final String name;

    /**
     * Основное конструктор класса.
     *
     * @param code код страны
     * @param name название страны
     */
    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * Возвращает код страны.
     *
     * @return строковый код страны
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Возвращает название страны.
     *
     * @return название страны
     */
    public String getName() {
        return this.name;
    }

    /*
     * TODO(Студент): для класса Country переопределить методы equals и hashCode
     */
    @Override
    public boolean equals(Object other) {
        return this.hashCode() == other.hashCode();
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.code, this.name);
    }
    /**
     * Возвращает экземпляр страны созданный из переданного
     * текста в формате 'Код:Название'.
     *
     * @param text тектс в формате 'Код:Название'
     * @return новый экземпляр типа {@Link Country}.
     * @throws ParseException в случае, если переданная строка
     * имеет неверный формат.
     */
    public static Country valueOf(String text) throws ParseException {
        /*
         * TODO(Студент): Реализовать метод valueOf класса Country
         */
        String isoCode;
        String countryName;
        int commaPos = text.indexOf(":");
        if (commaPos <= 0)
            throw new ParseException("Строка неверного формата", 0);
        isoCode = text.substring(0, commaPos);
        countryName = text.substring(commaPos+1);

        return (new Country(isoCode, countryName));
    }
}
