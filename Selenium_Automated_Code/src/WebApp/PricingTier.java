package WebApp;

public class PricingTier {
    private int sqftMin;
    private int sqftMax;
    private int initialMin;
    private int initialMax;
    private int recurringMin;
    private int recurringMax;

    public PricingTier() {
        sqftMin = 0;
        sqftMax = 0;
        initialMin = 0;
        initialMax = 0;
        recurringMin = 0;
        recurringMin = 0;
    }

    public PricingTier(int SQFTMin, int SQFTMax, int IntMin, int IntMax, int RecrrMin, int RecrrMax) {
        sqftMin = SQFTMin;
        sqftMax = SQFTMax;
        initialMin = IntMin;
        initialMax = IntMax;
        recurringMin = RecrrMin;
        recurringMax = RecrrMax;
    }

    public int getSqftMin() {
        return sqftMin;
    }

    public void setSqftMin(int sqftMin) {
        this.sqftMin = sqftMin;
    }

    public int getSqftMax() {
        return sqftMax;
    }

    public void setSqftMax(int sqftMax) {
        this.sqftMax = sqftMax;
    }

    public int getInitialMin() {
        return initialMin;
    }

    public void setInitialMin(int initialMin) {
        this.initialMin = initialMin;
    }

    public int getInitialMax() {
        return initialMax;
    }

    public void setInitialMax(int initialMax) {
        this.initialMax = initialMax;
    }

    public int getRecurringMin() {
        return recurringMin;
    }

    public void setRecurringMin(int recurringMin) {
        this.recurringMin = recurringMin;
    }

    public int getRecurringMax() {
        return recurringMax;
    }

    public void setRecurringMax(int recurringMax) {
        this.recurringMax = recurringMax;
    }
}
