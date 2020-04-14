package bowling.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class FrameTest {

    @Test
    @DisplayName("프레임 생성 테스트")
    void createFrameTest() {
        assertThatCode(
                () -> new Frame()
        ).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("공 던지기 가능 테스트")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void isThrowableTrueTest(int firstFallenPin) {
        Frame frame = new Frame();
        frame.throwBall(firstFallenPin);
        assertThat(frame.isThrowable()).isTrue();
    }

    @Test
    @DisplayName("공 던지기 불가능 테스트1")
    void isThrowableFalseTest() {
        Frame frame = new Frame();
        frame.throwBall(10);
        assertThat(frame.isThrowable()).isFalse();
    }

    @Test
    @DisplayName("공 던지기 불가능 테스트2")
    void isThrowableFalse2Test() {
        Frame frame = new Frame();
        frame.throwBall(1);
        frame.throwBall(0);
        assertThat(frame.isThrowable()).isFalse();
    }
}
