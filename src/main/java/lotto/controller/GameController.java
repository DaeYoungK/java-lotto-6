package lotto.controller;

import lotto.domain.Lotto;
import lotto.utility.RandomNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    
    int amount; //로또 구입 총액
    int count; //로또 발행 개수

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    RandomNumber randomNumber = new RandomNumber();
    

    public void proceed() {
        init();
        LottoPublish();
    }

    private void LottoPublish() {
        for (int i = 0; i < count; i++) {
            Lotto.createLotto(randomNumber.makeLottoNumber());
        }
    }



    private void init() {
        amount = inputView.printPurchaseAmount();
        count = amount / 1000;
        outputView.printPurchase(count);
    }
}
