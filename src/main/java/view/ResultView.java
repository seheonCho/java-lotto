package view;

import domain.Lotto;
import util.LottoMessage;

import java.util.List;

public class ResultView {

    public ResultView() {}

    public void displayAllLotteries(List<Lotto> lotteries) {
        System.out.println(String.format(LottoMessage.NUMBER_RESULT, lotteries.size()));
        lotteries.iterator()
                .forEachRemaining(lotto -> System.out.println(lotto.getNumbers()));
    }

}
