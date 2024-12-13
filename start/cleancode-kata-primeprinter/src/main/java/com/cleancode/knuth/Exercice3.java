public class Exercice3 {
    public double calculate(double amount, int type, int years) {
        double discount = (years > 5) ? 0.05 : years / 100.0;

        double result = amount;

        switch (type) {
            case 1:
                result = amount;
                break;

            case 2:
                result = amount * 0.9;
                result -= result * discount;
                break;

            case 3:
                result = amount * 0.7;
                result -= result * discount;
                break;

            case 4:
                result = amount * 0.5;
                result -= result * discount;
                break;

            default:
                throw new IllegalArgumentException("Type de client invalide: " + type);
        }

        return result;
    }
}
