package com.exam.ifg.service;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class IfgApplication {
    public static void main(String[] args) {
        Quarkus.run(IfgService.class, args);
    }

    public static class IfgService implements QuarkusApplication {

        @Override
        public int run(String... args) throws Exception {
            System.out.println("=========== Start Running Ifg ===========");
            Quarkus.waitForExit();
            return 0;
        }
    }
}
