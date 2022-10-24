package ru.aasmc.effectivejava.chapter_06.item_34;

/**
 * The strategy enum pattern.
 */
public enum PayrollDay {

    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
    SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);

    private final PayType payType;

    PayrollDay(PayType payType) {
        this.payType = payType;
    }

    PayrollDay() {
        this(PayType.WEEKDAY); // Default
    }

    int pay(int minutesWorked, int payRate) {
        return payType.pay(minutesWorked, payRate);
    }

    /**
     * The strategy enum type.
     */
    private enum PayType {

        WEEKDAY {
            @Override
            int overtimePay(int mins, int payRate) {
                return mins <= MINS_PER_SHIFT ? 0 :
                        (mins - MINS_PER_SHIFT) * payRate / 2;
            }
        },

        WEEKEND {
            @Override
            int overtimePay(int mins, int payRate) {
                return mins * payRate / 2;
            }
        };

        abstract int overtimePay(int mins, int payRate);

        private static final int MINS_PER_SHIFT = 60 * 8;

        int pay(int minsWorked, int payRate) {
            int basePay = minsWorked * payRate;
            return basePay + overtimePay(minsWorked, payRate);
        }
    }
}
