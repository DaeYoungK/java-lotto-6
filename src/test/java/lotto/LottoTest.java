package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @BeforeEach
    void init() {
        LottoStore.getInstance().getLotto().clear();
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 생성 후 로또저장소에 저장한다.")
    @Test
    void createLottoAndLottoStore() {
        Lotto.createLotto(List.of(1, 2, 3, 4, 5, 6));

        List<Lotto> lottos = LottoStore.getInstance().getLotto();
        Lotto lotto = lottos.get(0);
        List<Integer> lottoNumbers = lotto.getNumbers();

        assertThat(lottos.size()).isEqualTo(1);
        assertThat(lottoNumbers.size()).isEqualTo(6);
        assertThat(lottoNumbers.get(2)).isEqualTo(3);
    }
}