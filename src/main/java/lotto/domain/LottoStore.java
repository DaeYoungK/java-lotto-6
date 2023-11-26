package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoStore {

    private List<Lotto> lottos = new ArrayList<>();

    public List<Integer> addLotto(List<Integer> numbers) {
        Lotto lotto = Lotto.createLotto(numbers);
        lottos.add(lotto);

        return lotto.getNumbers();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
