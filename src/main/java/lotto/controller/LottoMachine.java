package lotto.controller;

import lotto.domain.*;
import lotto.utility.RandomNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

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

    public void proceed() {
        int count = payPurchase();
        publishLotto(count);
        statisticResult();
    }

    private void statisticResult() {
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
        price = Integer.parseInt(inputView.readPurchase());
        if (price % STANDARD_PURCHASE != ZERO) {
            System.out.println("예외 발생!");
        }
        return price/STANDARD_PURCHASE;
    }
}
