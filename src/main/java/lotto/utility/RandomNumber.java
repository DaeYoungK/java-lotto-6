package lotto.utility;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class RandomNumber {

    public List<Integer> makeLottoNumber() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lottoNumber);
        return lottoNumber;
    }
}