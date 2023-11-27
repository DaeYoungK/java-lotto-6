package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static lotto.domain.Statistic.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    LottoStore lottoStore = new LottoStore();
    WinningNumber winningNumber = new WinningNumber();
    Calculator calculator = new Calculator();

    @DisplayName("로또 번호와 일치하는 개수를 구하여 맵에 정리한다.")
    @Test
    void getCollectLottoNumberCountTest() {
        lottoStore.addLotto(List.of(1,2,3,4,5,6));
        lottoStore.addLotto(List.of(1,2,4,6,7,9));
        lottoStore.addLotto(List.of(1,3,6,8,9,25));
        lottoStore.addLotto(List.of(1,2,6,8,5,7));
        winningNumber.setWinning("1,2,3,4,5,6");
        List<Lotto> lottos = lottoStore.getLottos();

        Map<Statistic, Integer> statisticIntegerMap = calculator.collectLotto(lottos, winningNumber);

        Assertions.assertThat(statisticIntegerMap.get(SIX)).isEqualTo(1);
        Assertions.assertThat(statisticIntegerMap.get(FOUR)).isEqualTo(2);
        Assertions.assertThat(statisticIntegerMap.get(THREE)).isEqualTo(1);
    }

    @DisplayName("로또 번호와 일치하는 개수를 구하여 맵에 정리한다.")
    @Test
    void getRateOfReturnTest() {
        int price = 8000;
        lottoStore.addLotto(List.of(1,2,3,4,5,6));
        lottoStore.addLotto(List.of(1,5,4,6,7,9));
        lottoStore.addLotto(List.of(1,7,6,8,9,25));
        lottoStore.addLotto(List.of(1,2,6,8,5,7));
        winningNumber.setWinning("1,2,3,41,45,36");
        List<Lotto> lottos = lottoStore.getLottos();
        calculator.collectLotto(lottos, winningNumber);
        double result = calculator.rateOfReturn(price);

        Assertions.assertThat(result).isEqualTo(62.5);
    }

}