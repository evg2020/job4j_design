package chapter_001.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
      /*  LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");*/

        String name = "Petr Arsentev";
        byte build = 12;
        short flat = 14;
        int age = 33;
        long star = 2121;
        float pi = 3.14f;
        double e = 2.71d;

        LOG.debug("User info name : {}, build : {}, flat : {}, age : {}, star : {}, pi : {}, e : {}",
                name, build, flat, age, star, pi, e, e);
    }
}