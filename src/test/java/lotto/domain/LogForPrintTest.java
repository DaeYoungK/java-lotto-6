package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

        Assertions.assertThat(resultLog).contains(
                "[1, 2, 3, 4, 5, 6]\n",
                "[1, 2, 5, 7, 9, 11]\n",
                "[1, 3, 5, 7, 9, 20]\n"
        );
    }

}