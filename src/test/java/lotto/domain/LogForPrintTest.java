package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.Statistic.*;
import static org.assertj.core.api.Assertions.*;

class LogForPrintTest {

    LogForPrint log = new LogForPrint();
    LottoStore lottoStore = new LottoStore();

    @DisplayName("발행된 로또를 받아 출력용 데이터로 만든다.")
    @Test
    void makePublishLottoLog() {
        lottoStore.addLotto(List.of(1,2,3,4,5,6));
        lottoStore.addLotto(List.of(1,2,5,7,9,11));
        lottoStore.addLotto(List.of(1,3,5,7,9,20));
        List<Lotto> lottos = lottoStore.getLottos();

        String resultLog = log.purchaseLotto(lottos);

        assertThat(resultLog).contains(
                "[1, 2, 3, 4, 5, 6]\n",
                "[1, 2, 5, 7, 9, 11]\n",
                "[1, 3, 5, 7, 9, 20]\n"
        );
    }

    @DisplayName("당첨 통계를 정리하여 출력한다.")
    @Test
    void makeStatisticLog() {
        Map<Statistic, Integer> result = new HashMap<>(){{
            put(THREE, 1);
            put(FOUR, 0);
            put(FIVE, 0);
            put(FIVE_BONUS, 0);
            put(SIX, 0);
        }};

        String resultLog = log.resultStatistic(result);

        assertThat(resultLog).contains(
                "3개 일치 (5,000원) - 1개\n",
                "4개 일치 (50,000원) - 0개\n",
                "5개 일치 (1,500,000원) - 0개\n",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n",
                "6개 일치 (2,000,000,000원) - 0개\n"
        );
    }

    @DisplayName("당첨 통계를 정리하여 출력한다.")
    @Test
    void makeRateOfReturnLog() {
        double rateOfReturn = 62.5423;

        String resultLog = log.rateOfReturn(rateOfReturn);

        assertThat(resultLog).contains("총 수익률은 62.5%입니다.");
    }
}