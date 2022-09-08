package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 ////////////////////////

import java.lang.UnsupportedOperationException;
import java.util.NoSuchElementException;

public class Oblig1 {
    private Oblig1() {}

    ///// Oppgave 1 //////////////////////////////////////

    /* Når blir det flest ombyttinger? :
    * Det vil være flest ombyttinger dersom den største verdien ligger først i arrayet. Da må obyttingen skje ved hver
    * eneste iterasjon av for-løkken*/

    /* Når blir det færrest ombyttinger?:
    * Færrest ombyttinger vil skje om tabellen skulle være ferdig sortert, fra minst til størst. Da vil vilkåret i if
    * setningen aldri oppfylles, da nåværende a[i] alltid vil være større enn a[i-1]. Dermed vil bytte aldri forekomme.*/



    public static int maks(int[] a) {
        if (a.length == 0) {                    // Sjekker at lengden på tabellen er større enn 0
            throw new NoSuchElementException("Tabellen er tom og har dermed ingen verdier");
            // Brukte ALT for lang tid på å skjønne at jeg skulle bruke en annen feilmelding enn den som stod her fra før
        }
        else {                                  // Dersom tabellen ikke er tom, så kjører vi.
            int max = a[0];                     // Initialiserer max som 0.

            for (int i = 1; i < a.length; i++) { // En forløkke som starter med indeks 1 og sammenligner med forrige indeks.
                if (a[i-1] > a[i]) {
                    int temp = a[i];            // Bytter hvis større
                    a[i] = a[i-1];
                    a[i-1] = temp;
                }
                max = a[i];   // Dersom byttingen har skjedd riktig for seg så vil dette peke til elementet i tabellens siste indeks.
            }
            return max;
        }
    }

    /*Hvor mange blir det i gjennomsnitt?:
    * For å besvare dette spørsmålet så har jeg laget en metode for å regne ut snittet av byttene for et
    * n antall permutasjoner. Jeg har lagt ved metoden under kommentaren
    *
    * Metoden kjørte jeg i en egen main metode for å teste, sammen med randPerm og bytt metodene fra kompendiet.
    * Det metoden gjorde var å ta inn et tall for innparameter som angir hvor mange permutasjoner som skal testes.
    *
    * Metoden teller antall tester, opp til det ønskede antallet.
    * For hver iterasjon blir det generert et nytt random array med x(innparameter) antall tall. For hvert nye random
    * array, vil metoden kjøre ombyttinger metoden under, for å telle byttene.
    * Til sist deler den summen av alle byttene for alle iterasjoner, på antallet tester. Da står vi igjen med et snitt.
    *
    * Jeg har testet med 5000 permutasjoner, på ulike array størrelser.
    * Det jeg merket meg var at byttene øker veldig fort i takt med størrelsen på arrayet. Effektiviteten er således svært lav.
    * I et array av lengde 1000, så skjer byttene i snitt 992 ganger.
     */

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
        if (inversjoner(a) != 0) { // Sjekker for inversjoner i tabellen. Er det en inversjon, så er tabellen ikke sortert.
            throw new IllegalStateException("Tabellen er ikke sortert");
        } else if (a.length == 0) { // Sjekker at tabellen har en lengde.
            return 0;               // Er den = 0 så skal det returneres 0, i henhold til oppgaveteksten.
        } else {
            int sum = 1;            // Her starter
            for (int i = 1; i < a.length; i++) {
                if (a[i] != a[i-1]) {
                    sum ++;
                }
            }
            return sum;
        }
    } // i iiiii

    public static int inversjoner(int[] a)
    {
        int antall = 0;  // antall inversjoner
        for (int i = 0; i < a.length - 1; i++)
        {
            for (int j = i + 1; j < a.length; j++)
            {
                if (a[i] > a[j]) antall++;  // en inversjon siden i < j
            }
        }
        return antall;
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
