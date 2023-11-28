package lotto.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class ValidatorTest {

    Validator validator = new Validator();

    @DisplayName("구매할 로또 가격 입력 데이터가 숫자인지 검증")
    @ValueSource(strings = {"ans", "문","fw f"})
    @ParameterizedTest
    void priceTypeTest(String value) {
        assertThatThrownBy(() -> validator.validPrice(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매할 로또 가격 입력 데이터가 1,000으로 나누어 떨어지는지 검증")
    @ValueSource(strings = {"1023", "999","2001"})
    @ParameterizedTest
    void priceTest(String value) {
        assertThatThrownBy(() -> validator.validPrice(value))
                .isInstanceOf(IllegalArgumentException.class);
    }





}