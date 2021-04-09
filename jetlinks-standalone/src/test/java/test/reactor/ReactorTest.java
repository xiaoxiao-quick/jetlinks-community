package test.reactor;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

/**
 * @ClassName ReactorTest
 * @Description TODO
 * @Author fengxiaoxiao
 * @Date 2021/3/9 8:48
 * @Version 1.0
 */
public class ReactorTest {

    @Test
    public void tool() {
        Flux.range(0, 5)
            .single();
    }
}
