import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int numero = pedirNumero();
        JOptionPane.showMessageDialog(null, "Número ingresado: " + numero);
        double[] notas = new double[numero];
        for (int i = 0; i < numero; i++) {
            notas[i] = pedirNotas("Separe los numeros con un punto (.) \n Ingrese la nota " + (i + 1) + ": ");
        }
        double notaFinal = calcularNotaFinal(notas);
        double notaMayor = calcularNotaMayor(notas);
        double notaMenor = calcularNotaMenor(notas);
        burbuja(notas);
        String arreglo = mostrarArreglo(notas);
        JOptionPane.showMessageDialog(null, "-- Nota Definitiva -- \n~" + notaFinal +
                "\n-- Nota Mayor --\n~" + notaMayor + "\n-- Nota menor -- \n~" + notaMenor + "\nSus notas fueron: \n" + arreglo);
        bonusAleatorio(notas);
        JOptionPane.showMessageDialog(null, "MUCHAS GRACIAS POR USAR NUESTRO CODIGO");

    }

    public static int pedirNumero() {
        while (true) {
            String entrada = JOptionPane.showInputDialog("Ingrese la cantidad de notas deseadas: ");
            try {
                int number = Integer.parseInt(entrada);
                return number;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ERROR. Ingrese un número valido");
            }
        }
    }

    public static double pedirNotas(String mensaje) {
        while (true) {
            String entrada = JOptionPane.showInputDialog(mensaje);
            try {
                double nota = Double.parseDouble(entrada);
                return nota;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ERROR. Ingrese un Nota valida");
            }
        }
    }

    public static double calcularNotaFinal(double[] notas) {
        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        return suma / notas.length;

    }

    public static double calcularNotaMayor(double[] notas) {
        double mayor = 0;
        for (int y = 0; y < notas.length; y++) {
            if (notas[y] > mayor) {
                mayor = notas[y];

            }

        }
        return mayor;

    }

    public static double calcularNotaMenor(double[] notas) {
        double menor = notas[0];
        for (int y = 0; y < notas.length; y++) {
            if (notas[y] < menor) {
                menor = notas[y];

            }

        }
        return menor;

    }

    public static void burbuja(double[] notas) {
        int n = notas.length;
        for (int z = 0; z < n - 1; z++) {
            for (int t = 0; t < n - 1 - z; t++) {
                if (notas[t] > notas[t + 1]) {
                    double temp = notas[t];
                    notas[t] = notas[t + 1];
                    notas[t + 1] = temp;

                }
            }
        }
    }

    public static String mostrarArreglo(double[] notas) {
        String resultado = "";
        for (double dato : notas) {
            resultado += String.format("%.1f", dato) + "\n";;
        }
        return resultado;

    }

    public static void bonusAleatorio(double[] notas) {
        int indice= 0;

        do {
            indice= (int) (Math.random()* notas.length);
        } while (notas [indice]== 5.0);
        double [] bonusPos = {0.2 ,0.3, 0.4, 0.5};
        int randomBonus =(int) (Math.random()* bonusPos.length);
        double bonus= bonusPos[randomBonus];
        notas [indice]+= bonus;
        if (notas[indice]>5.0 ){
            notas [indice] =5.0;
        }

        JOptionPane.showMessageDialog( null, "🎉 Felicidades has conseguido un " +
                "bonus por" + " buen comportamiento " + "🎉\n" +
                "~Se agregó " + bonus + " a la nota # "+ (indice +1));
        String arregloAct = mostrarArreglo(notas);
        JOptionPane.showMessageDialog(null,
                "Notas actualizadas:\n" + arregloAct);


    }
}

