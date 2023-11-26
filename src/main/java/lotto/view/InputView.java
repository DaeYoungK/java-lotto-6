package lotto.view;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {

    private static final String INPUT_PURCHASE = "구매금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public String readPurchase () {
        System.out.println(INPUT_PURCHASE);
        return readLine();
    }

    public String readWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);
        return readLine();
    }

    public String readBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return readLine();
    }
}
