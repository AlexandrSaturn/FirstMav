package ForWork;

import org.joda.time.LocalDate;

/**
 * Класс людей со свойствами <b>id</b> , <b>fname</b>, <b>male</b> ,<b>birthday</b>, <b>age</b>.
 * @author Киса Александр
 * @version 0.000001
 *
 *
 */

public class Person {
    /** Поле идентификатора */
    private int id;

    /** Поле ФИО */
    private String fname;

    /** Поле пола человека */
    private String male;

    /** Поле дня рождения в формате ДД-ММ-ГГГГ */
    private LocalDate birthday;

    /** Поле возраста */
    private int age;

    /**
     * конструктор со списком всех параметров
     * @param id - идентификатор
     * @param fname - ФИО
     * @param male  - пол
     * @param birthday  - день рождения
     */
    public Person(int id, String fname, String male, LocalDate birthday) {
        this.id = id;
        this.fname = fname;
        this.male = male;
        this.birthday = birthday;
        this.age = 0;

        LocalDate today = LocalDate.now();

        if (today.getYear() > birthday.getYear()) {
            this.age =today.getYear() - birthday.getYear();
            if(today.getMonthOfYear() > birthday.getMonthOfYear())
                this.age--;
            else
                if ( today.getMonthOfYear() == birthday.getMonthOfYear() && today.getDayOfMonth() < birthday.getDayOfMonth() )
                this.age--;
        }

    }

    /**
     * Конструктор копирования
     * @param p человек
     */
    public Person(Person p) {
        this.id = p.id;
        this.fname = p.fname;
        this.male = p.male;
        this.birthday = p.birthday;
        this.age = p.age;
    }

    /**
     * Функция получения значение поля {@link Person#id}
     * @return возвращает значение идентификатора
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fname;
    }

    public void setFio(String fname) {
        this.fname = fname;
    }

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;

        LocalDate today = LocalDate.now();

        if (today.getYear() > birthday.getYear()) {
            this.age =today.getYear() - birthday.getYear();
            if(today.getMonthOfYear() > birthday.getMonthOfYear())
                this.age--;
            else if ( today.getMonthOfYear() == birthday.getMonthOfYear() && today.getDayOfMonth() < birthday.getDayOfMonth() )
                this.age--;
        }

    }

    public int getAge() {
        return age;
    }

    public void println(){
        System.out.println(this.id);
        System.out.println(this.fname);
        System.out.println(this.male);
        System.out.println(this.birthday);
        System.out.println(this.age);
        System.out.println();
    }

    public void Copy(Person p) {
        this.id = p.id;
        this.fname = p.fname;
        this.male = p.male;
        this.birthday = p.birthday;
        this.age = p.age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        if (age != person.age) return false;
        if (fname != null ? !fname.equals(person.fname) : person.fname != null) return false;
        if (male != null ? !male.equals(person.male) : person.male != null) return false;
        return birthday != null ? birthday.equals(person.birthday) : person.birthday == null;
    }


}
