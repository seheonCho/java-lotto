package util;

import domain.Lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public enum LottoRank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    LOSING_TICKET(0, 0);

    private int sameCount;
    private int prizeMoney;

    LottoRank(int sameCount, int prizeMoney) {
        this.sameCount = sameCount;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank getRank(Lotto lotto, int numberOfSameNumber, int bonusNumber) {
        if (isSecond(numberOfSameNumber, lotto.isContainBonusNumber(bonusNumber))) {
            return LottoRank.THIRD;
        }

        return Arrays.stream(values())
                .filter(rank -> rank.getSameCount() == numberOfSameNumber)
                .findAny()
                .orElse(LottoRank.LOSING_TICKET);
    }

    private static boolean isSecond(int numberOfSameNumber, boolean hasBonusNumber) {
        if (SECOND.getSameCount() == numberOfSameNumber && !hasBonusNumber) {
            return true;
        }
        return false;
    }

    public static Stream<LottoRank> getAscendRank() {
        return Arrays.stream(LottoRank.values())
                .sorted(Collections.reverseOrder());
    }

    public int getSameCount() {
        return sameCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

}
