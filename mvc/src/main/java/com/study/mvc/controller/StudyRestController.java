package com.study.mvc.controller;

import com.study.mvc.dto.HelloDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController // 모든 메서드에 @ResponseBody 어노테이션을 단 것과 같다.
public class StudyRestController {

//    ** 이전 JSP 방식
//    @GetMapping("hello/test")
//    public String hello(HttpServletRequest request) {
//        System.out.println(request.getParameter("name"));
//        return request.getParameter("name");
//    }


    //기본형태
    //생략이 가능해도 명시해주는게 좋음
    @GetMapping("hello/test1")
    public String hello1(@RequestParam("name") String str) {
        return str;
    }

    //변수명 일치시 어노테이션 생략
    @GetMapping("hello/test2")
    public String hello2(String name) {
        return name;
    }

    //어노테이션 생략하고 파라미터 2개
    @GetMapping("hello/test3")
    public String hello3(String name, String age) {
        return name + " " + age;
    }

    //파라미터를 int로 받아도 알아서 파싱해서 가져옴
    @GetMapping("hello/test4")
    public String hello4(String name, int age) {
        return name + " " + age;
    }

    //객체 반환시 NoArgConstructor없으면 부분적으로 null 불가능
    //dto는 내가 직접 생성하는 경우가 거의 없음 -> @NoArg , @AllArg, @Builer 필요없음(기본갑이 NoArg생성자니까)
    @GetMapping("hello/test5")
    public String hello5(HelloDto helloDto) {
        return helloDto.toString();
    }

}