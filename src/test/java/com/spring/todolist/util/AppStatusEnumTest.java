package com.spring.todolist.util;

import org.junit.jupiter.api.Test;
import com.spring.todolist.constant.AppStatus;

import static com.spring.todolist.constant.AppStatus.SUBMITTED;

public class AppStatusEnumTest {

    @Test
    public void test() {

        AppStatus appStatus = SUBMITTED;
        AppStatus appStatus1 = AppStatus.valueOf(AppStatus.SUBMITTED.name());
        System.out.println(appStatus.equals(appStatus1));

//        for (AppStatus appStatusTemp : AppStatus.values()) {
//            System.out.println("appStatus->"+appStatusTemp.name());
//        }

//        System.out.println(AppStatus);

    }
}
