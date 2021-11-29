package hello.advanced.trace.strategy.code.template;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeLogTemplate {

    public void execute(Callback callback) {
        final long startTime = System.currentTimeMillis();

        callback.call(); // 위임

        final long endTime = System.currentTimeMillis();
        final long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }
}
