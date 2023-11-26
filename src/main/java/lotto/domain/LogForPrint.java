package lotto.domain;

import java.util.List;

public class LogForPrint {

    private static final String NEXT_LINE = "\n";
    private StringBuilder sb;

    public String purchaseLotto(List<Lotto> lottos) {
        sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto.getNumbers() + NEXT_LINE);
        }
        return sb.toString();
    }
}
