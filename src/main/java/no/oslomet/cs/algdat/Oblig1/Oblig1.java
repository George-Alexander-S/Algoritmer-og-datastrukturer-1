package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 ////////////////////////

import java.lang.UnsupportedOperationException;
import java.util.NoSuchElementException;

public class Oblig1 {
    private Oblig1() {}

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {
        if (a.length == 0) { // Sjekker at lengden på tabellen er større enn 0
            throw new NoSuchElementException("Tabellen er tom og har dermed ingen verdier");
            // Brukte ALT for lang tid på å skjønne at jeg skulle bruke en annen feilmelding enn den som stod her fra før
        }
        else { // Dersom tabellen ikke er tom, så kjører vi.
            int max = a[0];        // Initialiserer max som 0.

            for (int i = 1; i < a.length; i++) { // En forløkke som starter med indeks 1 og sammenligner med forrige før inkrementering
                if (a[i-1] > a[i]) {
                    int temp = a[i];
                    a[i] = a[i-1];
                    a[i-1] = temp;
                }
                max = a[i];
            }
            return max;
        }
    }

    public static int ombyttinger(int[] a) {
        if (a.length == 0) { // Sjekker at lengden på tabellen er større enn 0
            throw new NoSuchElementException("Tabellen er tom og har dermed ingen verdier");
        } else {
            int bytter = 0;        // Initialiserer antall bytter som 0.

            for (int i = 1; i < a.length; i++) {
                if (a[i-1] > a[i]) {
                    int temp = a[i];
                    a[i] = a[i-1];
                    a[i-1] = temp;
                    bytter ++;
                }
            }
            return bytter;
        }
    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        throw new UnsupportedOperationException();
    }

    /// 7b)
    public static String flett(String... s) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new UnsupportedOperationException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new UnsupportedOperationException();
    }

}  // Oblig1
