package com.example.basic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yaml.snakeyaml.tokens.Token;

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

    @RequestMapping("/test7")
    @ResponseBody
    public String test7(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        int result = num1 + num2;

        return "result : " + result;
    }

    @RequestMapping("/test8")
    @ResponseBody
    public String test8(@RequestParam("name") String name){
        return name + "님 반갑습니다.";
    }

    @RequestMapping("/test9")
    @ResponseBody
    public String test9(@RequestParam("dan") int dan){
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <=9; i++){
            sb.append(dan+" X "+i+" = "+dan*i+"<br>");
        }
        return sb.toString();
    }

    @RequestMapping("/test10")
    @ResponseBody
    public String test10(@RequestParam("dan") int dan, @RequestParam("limit") int limit){
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= limit; i++){
            sb.append(dan+" X "+i+" = "+dan*i+"<br>");
        }
        return sb.toString();
    }

    @RequestMapping("/test11")
    @ResponseBody
    public String test11(@RequestParam("name") String name,@RequestParam("age") int age){
        return age+"살 "+name+"입니다";
    }

    @RequestMapping("/login")
    @ResponseBody
    public String test12(@RequestParam("ID") String id,@RequestParam("PW") String pw){
        String Id = "hong";
        String Pw = "1234";
        if(Id.equals(id)){
            if(Pw.equals(pw)){
                return "로그인 성공";
            }else{
                return "로그인 실패";
            }
        }else{
            return "로그인 실패";
        }
    }

    @RequestMapping("/loginView")
    @ResponseBody
    public String loginView(){
        return """
                <form action="http://localhost:8088/test12">
                  <input type="text" name = "ID">
                  <input type="password" name = "PW">
                  <input type="submit">
                </form>
                                
                """;
    }

    @RequestMapping("/loginView2")
    // @ResponseBody 를 붙이지 않으면 template으로 view를 대체한다는 의미
    // 타임리프(thymeleaf) 라이브러리 추가해야함.
    public String loginView2(){
        return "login";
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