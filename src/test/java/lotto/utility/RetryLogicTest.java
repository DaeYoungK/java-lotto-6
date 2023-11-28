package lotto.utility;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.utility.RetryLogic.*;
import static org.assertj.core.api.Assertions.*;

class RetryLogicTest {

    int count = 0;

    @DisplayName("입력 오류 발생시 재시도 로직 테스트")
    @Test
    void retryTest() {
        assertThatThrownBy(() -> retry(() -> plusCount()))
                .isInstanceOf(IllegalArgumentException.class);

        assertThat(count).isEqualTo(5);
    }

    private void plusCount() {
        count++;
        throw new IllegalArgumentException();
    }
}