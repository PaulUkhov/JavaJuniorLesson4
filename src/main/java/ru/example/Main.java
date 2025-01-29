package ru.example;


import org.hibernate.Session;
import org.hibernate.Transaction;


public class Main {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            // Создаем объекты Person
            Person person1 = new Person("Иван", 25);
            Person person2 = new Person("Мария", 30);
            Person person3 = new Person("Алексей", 28);

            // Сохраняем в базу данных
            session.persist(person1);
            session.persist(person2);
            session.persist(person3);

            transaction.commit();
        }

        // Закрытие фабрики сессий
        HibernateUtil.getSessionFactory().close();
    }
}
