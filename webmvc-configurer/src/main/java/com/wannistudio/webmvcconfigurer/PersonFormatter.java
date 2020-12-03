package com.wannistudio.webmvcconfigurer;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

//@Component
public class PersonFormatter implements Formatter<Person> {
    @Override
    public Person parse(String text, Locale locale) throws ParseException {
        Person person = new Person();
        person.setName(text);
        return person;
    }

    @Override // 실질적으로 사용은 안함.
    public String print(Person object, Locale locale) {
        return object.toString();
    }
}
