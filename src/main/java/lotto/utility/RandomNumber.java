package lotto.utility;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class RandomNumber {

    private static final int START_LOTTO = 1;
    private static final int END_LOTTO = 45;
    private static final int LOTTO_COUNT = 6;

    public List<Integer> lottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_LOTTO, END_LOTTO, LOTTO_COUNT);

        return sort(numbers);
    }

    private List<Integer> sort(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }
}
