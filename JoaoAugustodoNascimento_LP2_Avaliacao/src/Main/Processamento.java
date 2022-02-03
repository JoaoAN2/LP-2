package Main;

/**
 *
 * @author JoaoAN
 *
 */
class Processamento {

    public double calculate(double investment, int time, double profitability) {
        double montante = investment * Math.pow((1 + profitability/100), time);
        double profit = montante - investment;
        double tax = profit * 0.15;
        return montante - tax;
    }
}
