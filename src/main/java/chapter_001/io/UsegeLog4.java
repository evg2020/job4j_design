package chapter_001.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsegeLog4 {
    public static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        try {
            throw new Exception("Not Supported code");
        } catch (Exception e) {
//            e.printStackTrace(); // печатается напрямую в консоль.
            LOG.error("Exception in log example", e);
//            LOG.error(e.getMessage()); //В этом случае мы не можем понять, кто вызывал этот код. Не может отследить причину.
        }

    }
}
