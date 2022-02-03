package Main;

/**
 *
 * @author JoaoAN2
 */
class Processamento {

    double a;
    double b;
    double c;
    double delta = getDelta();

    public Processamento(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDelta() {
        return Math.pow(b, 2) - 4 * a * c;
    }

    public String getX1() {
        if (delta < 0) {
            return "Delta < 0! Valor real inexistente!";
        } else {
            return String.valueOf((-b + Math.sqrt(delta)) / 2 * a);
        }
    }

    public String getX2() {
        if (delta > 0) {
            return String.valueOf((-b - Math.sqrt(delta)) / 2 * a);
        } else if(delta == 0) {
            return "Apenas um x real";
        } else {
            return null;
        }
    }
}
