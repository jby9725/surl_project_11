package com.koreait.surl_project_11;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String _main() {
        return "main";
    }

    @GetMapping("home")
    @ResponseBody
    public String home() {
        return "Hello World";
    }

    @GetMapping("a")
    @ResponseBody
    public String hi(
            String age,
            String id
    ) {
        return "안녕, %s번, %s살이야.".formatted(id, age);
    }

    @GetMapping("b")
    @ResponseBody
    public String plus(
            // http://localhost:8080/b?a=20&b=40
            @RequestParam("a") int num1,
            @RequestParam("b") int num2,
            @RequestParam(name = "c", defaultValue = "10") int num3
    ) {

        System.out.println("a : " + num1);
        System.out.println("b : " + num2);

        return "a + b + c = %d".formatted(num1 + num2 + num3);
    }

    @GetMapping("c")
    @ResponseBody
    public String c(
            boolean married
    ) {
        return married ? "기혼" : "미혼";
    }

    @GetMapping("d")
    @ResponseBody
    public String d(
            Boolean married
    ) {
        if (married == null) return "정보 입력해";

        return married ? "기혼" : "미혼";
    }

    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    @GetMapping("person1")
    @ResponseBody
    public String person1(
            String name,
            int age
    ) {
        Person person = new Person(name, age);

        return person.toString();
    }

    @GetMapping("person2")
    @ResponseBody
    public String person2(
            Person person
    ) {
        return person.toString();
    }

    @GetMapping("e")
    @ResponseBody
    public int e() {
        int age = 10;
        return age;
    }

}
