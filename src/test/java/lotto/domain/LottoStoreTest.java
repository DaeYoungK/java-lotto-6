package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoStoreTest {

    LottoStore lottoStore = new LottoStore();

    @DisplayName("로또 번호를 받아 리스트에 저장하는 기능 테스트")
    @Test
    void saveLottoInStoreTest() {
        List<Integer> numbers = List.of(1,2,3,4,5,6);

        lottoStore.addLotto(numbers);
        List<Lotto> lottos = lottoStore.getLottos();

        assertThat(lottos.size()).isEqualTo(1);
        assertThat(lottos.get(0).getNumbers()).containsExactly(1,2,3,4,5,6);

    }

}