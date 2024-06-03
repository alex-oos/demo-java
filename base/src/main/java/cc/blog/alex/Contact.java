package cc.blog.alex;

import lombok.Builder;

/**
 * @author Alex
 * @since 2024/5/23 上午11:03
 * <p></p>
 */
public class Contact {

    private String name;

    private Integer age;

    public Contact() {

    }

    private Contact(Builder builder) {

        this.age = builder.age;
        this.name = builder.name;
    }

    public static class Builder {

        private String name;

        private Integer age;

        public Builder() {

        }

        public Builder age(Integer age) {

            this.age = age;
            return this;
        }

        public Builder name(String name) {

            this.name = name;
            return this;
        }

        public Contact build() {

            return new Contact(this);
        }

    }

    public static void main(String[] args) {

        Contact contact = new Contact.Builder().name("alex").build();
        System.out.println(contact.name);

    }

}
