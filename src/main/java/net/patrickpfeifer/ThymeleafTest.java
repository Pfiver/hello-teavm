package net.patrickpfeifer;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.TemplateSpec;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;

public class ThymeleafTest {

    public static void main(String... args) {

        TemplateEngine te = new TemplateEngine();

        Context ctx = new Context();
        ctx.setVariable("book", new Book("Jack"));

        System.out.println(
            te.process(new TemplateSpec(
                    "<span th:text=\"${book.author.name}\"/>", TemplateMode.HTML), ctx));
    }

    static class Book {
        Author author;

        Book(String authorName) {
            author = new Author(authorName);
        }

        public Author getAuthor() {
            return author;
        }

        public void setAuthor(Author author) {
            this.author = author;
        }
    }

    static class Author {
        String name;

        Author(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
