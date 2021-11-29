package hello.advanced.trace.template;

import hello.advanced.trace.template.code.AbstractTemplate;
import hello.advanced.trace.template.code.SubClassLogic1;
import hello.advanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    @Test
    void templateMethodV0() {
        logic1();
        logic2();
    }

    private void logic1() {
        final long startTime = System.currentTimeMillis();
        log.info("비지니스 로직 실행1");
        final long endTime = System.currentTimeMillis();
        final long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    private void logic2() {
        final long startTime = System.currentTimeMillis();
        log.info("비지니스 로직 실행2");
        final long endTime = System.currentTimeMillis();
        final long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    @Test
    void templateMethodV1() {
        AbstractTemplate template1 = new SubClassLogic1();
        template1.execute();

        AbstractTemplate template2 = new SubClassLogic2();
        template2.execute();
    }

    @Test
    void templateMethodV2() {
        final AbstractTemplate template1 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비지니스 로직1 실행");
            }
        };
        log.info("클래스 이름1={}", template1.getClass());
        template1.execute();

        final AbstractTemplate template2 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비지니스 로직1 실행");
            }
        };
        log.info("클래스 이름2={}", template2.getClass());
        template2.execute();
    }
}
