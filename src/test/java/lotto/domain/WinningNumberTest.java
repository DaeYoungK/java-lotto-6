package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class WinningNumberTest {

    WinningNumber winningNumber = new WinningNumber();

    @DisplayName("쉼표로 구분된 문자열을 받아서 당첨 번호를 지정한다.")
    @Test
    void setWinningNumber() {
        String numbers = "1,2,3,4,5,6";

        winningNumber.setWinning(numbers);
        List<Integer> winningNumbers = winningNumber.getWinning();

        Assertions.assertThat(winningNumbers).containsExactly(1,2,3,4,5,6);
        Assertions.assertThat(winningNumbers.size()).isEqualTo(6);
    }

    @DisplayName("번호를 받아서 보너스 번호를 지정한다.")
    @Test
    void setBonusNumber() {
        int number = 7;

        winningNumber.setBonus(number);
        int bonus = winningNumber.getBonus();

        Assertions.assertThat(bonus).isEqualTo(7);
    }
}