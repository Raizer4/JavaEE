package aop;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstractLibrary {

    public void getBook(){
        System.out.println("Мы берем книгу UniLibrary");
    }

    public void getMagazine(){
        System.out.println("Мы берем журнал UniLibrary");
    }

    public void returnBook(){
        System.out.println("Мы возращаем книгу в UniLibrary");
    }

    public void returnMagazine(){
        System.out.println("Мы возращаем журнал в UniLibrary");
    }

    public void addBook(){
        System.out.println("Мы добавляем книгу в UniLibrary");
    }

    public void addMagazine(){
        System.out.println("Мы добавляем журнал в UniLibrary");
    }

}
