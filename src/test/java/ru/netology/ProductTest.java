package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ProductTest {
    @Test
    public void addProductBook() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Sherlock holmes", 300, "Arthur Conan Doyle");
        Book book2 = new Book(2, "the green mile", 400, "Stephen King");
        Book book3 = new Book(3, "Twilight", 200, "Stephanie Mayer");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void searchByNameProduct() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Sherlock holmes", 300, "Arthur Conan Doyle");
        Book book2 = new Book(2, "the green mile", 400, "Stephen King");
        Book book3 = new Book(3, "Twilight", 200, "Stephanie Mayer");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("the green mile");
        Product[] expected = {book2};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void searchByNameProduct2() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Sherlock holmes", 300, "Arthur Conan Doyle");
        Book book2 = new Book(2, "the green mile", 400, "Stephen King");
        Book book3 = new Book(3, "Twilight", 200, "Stephanie Mayer");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("the green book");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void Product() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Sherlock holmes", 300, "Arthur Conan Doyle");
        Book book2 = new Book(2, "the green mile", 400, "Stephen King");
        Book book3 = new Book(3, "Sherlock holmes. The games of shadow", 200, "Arthur Conan Doyle");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("Sherlock holmes");
        Product[] expected = {book1, book3};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void removeById() {
        ProductRepository repo = new ProductRepository();
        Book book1 = new Book(1, "Sherlock holmes", 300, "Arthur Conan Doyle");
        Book book2 = new Book(2, "the green mile", 400, "Stephen King");
        Book book3 = new Book(3, "Twilight", 200, "Stephanie Mayer");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.removeById(1);
        Product[] actual = repo.findAll();
        Product[] expected = {book2, book3};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void addProductSmartPhone() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        SmartPhone smartPhone1 = new SmartPhone(10, "Samsung", 50000, "Korea");
        SmartPhone smartPhone2 = new SmartPhone(20, "Iphone", 100000, "USA");
        SmartPhone smartPhone3 = new SmartPhone(30, "Huawei", 20000, "China");

        manager.add(smartPhone1);
        manager.add(smartPhone2);
        manager.add(smartPhone3);
        Product[] actual = repo.findAll();
        Product[] expected = {smartPhone1, smartPhone2, smartPhone3};

        Assertions.assertArrayEquals(expected, actual);
    }
}
