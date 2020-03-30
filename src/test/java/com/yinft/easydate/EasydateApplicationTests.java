package com.yinft.easydate;

import com.yinft.easydate.util.DateUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class EasydateApplicationTests {

    @Test
    public void getStr2Date() {
        Date date = DateUtils.str2Date("2020-03-05 12:13:50");
        System.out.println("============" + date + "==============");
    }

}
