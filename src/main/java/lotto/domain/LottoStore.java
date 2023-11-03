package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    private static LottoStore lottoStore = new LottoStore();

    public static LottoStore getInstance() {
        return lottoStore;
    }

    private List<Lotto> lottos = new ArrayList<>();
    private List<Integer> winningLotto = new ArrayList<>();
    private Integer bonusNumber;

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }
}
