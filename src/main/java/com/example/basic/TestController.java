package com.example.basic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.StringJoiner;

@Controller // 웹브라우저랑 통신
public class TestController {
    @RequestMapping("/list")
    @ResponseBody
    public String list() {
        return "게시물목록";

    }

    @RequestMapping("/test1")
    @ResponseBody
    public Integer text1() {
        return 100;
    }

    @RequestMapping("/test2")
    @ResponseBody
    public ArrayList<String> test2() {
        ArrayList<String> list = new ArrayList<>();
        list.add("바나나");
        list.add("딸기");
        list.add("오렌지");
        return list;
    }

    @RequestMapping("/test3")
    @ResponseBody
    public Person test3() {

        return new Person("홍길동", 20);
    }

    @RequestMapping("/test4")
    @ResponseBody
    public ArrayList<Person> test4() {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("홍길동", 20));
        list.add(new Person("김철수", 30));
        list.add(new Person("김영희", 40));
        return list;
    }

    @RequestMapping("/test5")
    @ResponseBody
    public String test5() {
//        String html = "<h1>hello</h1>";
//        html += "<ul>";
//        html += "<li>apple</li>";
//        html += "<li>banana</li>";
//        html += "</ul>";
//
        StringBuilder sb = new StringBuilder();
        sb.append("<h1>hello</h1>");
        sb.append("<ul>");
        sb.append("<li>apple</li>");
        sb.append("<li>banana</li>");
        sb.append("</ul>");

        return sb.toString();
    }

    @RequestMapping("/test6")
    @ResponseBody
    public String test6() {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 9; i++) {
            sb.append(2 + " X " + i + " = " + (2 * i) + "<br>");
        }
//        sb.append("2 X 1 = 2<br>");
//        sb.append("2 X 2 = 4<br>");
//        sb.append("2 X 3 = 6<br>");
//        sb.append("2 X 4 = 8<br>");

        return sb.toString();
    }


}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class Person {
    private String name;
    private int age;
}