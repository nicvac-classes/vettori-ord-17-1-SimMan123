import java.util.*;
import java.lang.Math;

class Program {
    private static Random random = new Random();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int n, i;

        System.out.println("Inserire il numero di automobili");
        n = input.nextInt();
        String[] nomi = new String[n];
        int[] posizioni = new int[n];

        // Caricamento dei due vettori
        for (i = 0; i <= n - 1; i++) {
            System.out.println("Nome " + (i + 1) + "° automobile");
            nomi[i] = input.nextLine();
        }
        impostaVettoreRandom(posizioni, n);
        visualizzaVettori(nomi, n, posizioni);

        // Ordinamento dei vettori paralleli. Quando ordino Posizioni, ordino gli elementi corrispondenti di Nomi.
        bubbleSort(nomi, n, posizioni);

        // Visualizzo i valori ordinati.
        System.out.println("🏁🏁🏁🏁🏁 Posizione di arrivo 🏁🏁🏁🏁🏁");
        visualizzaVettori(nomi, n, posizioni);

        // Chiedo la posizione, visualizzo l'auto corrispondente.
        int posizione;
        String auto;

        System.out.println("Inserire la posizione desiderata: ");
        posizione = input.nextInt();
        System.out.println("Ricerca sequenziale 🐌🐌🐌");
        i = ricercaSequenziale(posizioni, n, posizione);
        System.out.println("Auto in posizione " + posizione + ": " + nomi[i]);
        System.out.println("Ricerca binaria 🏎️🏎️🏎️");
        i = ricercaBinaria(posizioni, n, posizione);
        System.out.println("Auto in posizione " + posizione + ": " + nomi[i]);
        int n3;

        // System.out.println(Espressione);
    }
    
    public static void bubbleSort(String[] nomi, int n, int[] posizioni) {
        String ts;
        int t;
        boolean scambio;
        int i, j;

        scambio = true;
        i = 0;
        while (i <= n - 1 && scambio) {
            scambio = false;
            j = 0;
            while (j <= n - 2 - i) {
                if (posizioni[j] > posizioni[j + 1]) {
                    scambio = true;

                    // Prima ordino Posizioni
                    t = posizioni[j];
                    posizioni[j] = posizioni[j + 1];
                    posizioni[j + 1] = t;

                    // Per mantenere la corrispondenza fra nomi e posizioni, devo scambiare anche le celle dei nomi. In questo modo i vettori paralleli rimangono coerenti.
                    ts = nomi[j];
                    nomi[j] = nomi[j + 1];
                    nomi[j + 1] = ts;
                }
                j = j + 1;
            }
            i = i + 1;
        }
    }
    
    public static void impostaVettoreRandom(int[] posizioni, int n) {
        int i;

        for (i = 0; i <= n - 1; i++) {
            posizioni[i] = 1 + random.nextInt(n);
        }
    }
    
    public static void merge(int[] v1, int v2, int v3) {
        int n3, i1, i2, i3;

        i1 = 0;
        i2 = 0;
        for (i3 = 0; i3 <= n3 - 1; i3++) {
            while (i2 <= n2 - 1) {
                while (i1 <= n1 - 1) {
                    if (v[i1] < v[i2]) {
                        v3[i3] = v1[i1];
                    } else {
                        v3[i3] = v2[i2];
                    }
                    i1 = i1 + 1;
                }
                i2 = i2 + 1;
            }
        }
        for (i1 = 0; i1 <= n3 - 1; i1++) {
            System.out.println(v3[i1]);
        }
    }
    
    public static int ricercaBinaria(int[] v, int n, int valore) {
        int inizio, fine, medio, indice, numControlli;

        numControlli = 0;
        indice = (int) (-1);
        inizio = 0;
        fine = n - 1;
        while (inizio <= fine && indice == -1) {
            medio = (int) (inizio + (double) (fine - inizio) / 2);
            numControlli = numControlli + 1;
            if (valore == v[medio]) {
                indice = medio;
            } else {
                numControlli = numControlli + 1;
                if (valore > v[medio]) {
                    inizio = medio + 1;
                } else {
                    fine = medio - 1;
                }
            }
        }
        System.out.println("Controlli eseguiti: " + numControlli);
        
        return indice;
    }
    
    public static int ricercaSequenziale(int[] v, int n, int valore) {
        int i, indice, numControlli;

        numControlli = 0;
        indice = (int) (-1);
        i = 0;
        while (i <= n - 1 && indice == -1) {
            numControlli = numControlli + 1;
            if (valore == v[i]) {
                indice = i;
            }
            i = i + 1;
        }
        System.out.println("Controlli eseguiti: " + numControlli);
        
        return indice;
    }
    
    public static void visualizzaVettori(String[] nomi, int n, int[] posizioni) {
        int i;

        for (i = 0; i <= n - 1; i++) {
            System.out.println("Auto " + nomi[i] + "; Posizione: " + posizioni[i]);
        }
    }
}
