package lotto.controller;

import lotto.domain.*;
import lotto.utility.RandomNumber;
import lotto.utility.RetryLogic;
import lotto.validation.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

import static lotto.utility.RetryLogic.*;

public class LottoMachine {

    private static final int STANDARD_PURCHASE = 1000;
    private static final int ZERO = 0;
    private int price;

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private LottoStore lottoStore = new LottoStore();
    private LogForPrint log = new LogForPrint();
    private Calculator calculator = new Calculator();
    private WinningNumber winningNumber = new WinningNumber();
    private Validator validator = new Validator();

    public void proceed() {
        int count = payPurchase();
        publishLotto(count);
        statisticResult();
    }

    private void statisticResult() {
        retry(() -> winningNumber.setWinning(validator.validWinning(inputView.readWinningNumber())));
        retry(() -> winningNumber.setBonus(validator.validBonus(inputView.readBonusNumber(),winningNumber.getWinning())));

        List<Lotto> lottos = lottoStore.getLottos();
        Map<Statistic, Integer> resultMap = calculator.collectLotto(lottos, winningNumber);
        double rateOfReturn = calculator.rateOfReturn(price);
        outputView.printStatistic(log.resultStatistic(resultMap));
        outputView.printRateOfReturn(log.rateOfReturn(rateOfReturn));
    }

    private void publishLotto(int count) {
        RandomNumber randomNumber = new RandomNumber();
        for (int i = 0; i < count; i++) {
            lottoStore.addLotto(randomNumber.lottoNumbers());
        }
        List<Lotto> lottos = lottoStore.getLottos();
        outputView.printPurchaseLotto(count, log.purchaseLotto(lottos));
    }

    private int payPurchase() {
        retry(() -> price = validator.validPrice(inputView.readPurchase()));

        return price/STANDARD_PURCHASE;
    }
}
