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
        }
        else {
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
        }
        else if (a.length == 0) { // Sjekker at tabellen har en lengde på over 0.
            return 0;               // Er den == 0 så skal det returneres 0, i henhold til oppgaveteksten.
        }
        else {
            int sum = 1;            // Her starter jeg på 1. Om alle tall hadde vært like er det fortsatt 1 unikt tall.
            for (int i = 1; i < a.length; i++) {
                if (a[i] != a[i-1]) {
                    sum ++;
                }
            }
            return sum;
        }
    }

    public static int inversjoner(int[] a)  // Programkode 1.3.2 a) fra https://www.cs.hioa.no/~ulfu/appolonius/kap1/3/kap13.html#1.3.2
    {
        int antall = 0;
        for (int i = 0; i < a.length - 1; i++)
        {
            for (int j = i + 1; j < a.length; j++)
            {
                if (a[i] > a[j]) antall++;
            }
        }
        return antall;
    }

    ///// Oppgave 3 //////////////////////////////////////

    /*Min første tanke var å lage en hjelpetabell, men det var før jeg leste hele oppgaveteksten. Kanskje det funker å
    bruke 2 for løkker. Ene sjekker om 2 indekser er like (starter med 1 mot 0). Dersom de ikke er like, så går jeg inn i
    den andre for løkken, og sjekker fra j=0 a[j] ikke er likt inneholdet i a[i], deretter inkrementeres j i tråd med
    progresjonen i første for-løkken.

     Etter å ha debugget hva som skjedde i andre for løkkens if setning, så gikk det opp for meg, at det ikke var nok å ha
     en else som inkrementerte sum, så lenge a[j] ikke var lik a[i]. Den andre for løkken går jo gjennom alle tallene mot
     a[i], og mange av de er jo nettopp IKKE like a[i], og da fikk jeg en "treff" som inkrementerte sum, selv om tallet
     hadde et duplikat ellers i tabellen. Løsningen ble derfor en boolean "unik". Så lenge den er true, så inkrementerer sum. Og
     med en gang den andre for-løkken får en duplikat, så blir den gjort til false.

     Det måtte enda en runde med debug til før jeg skjønte at jeg måtte jo ha noe som resatte boolean til true, så da
     definerte jeg heller den i første for-løkken, da vil den starte som true i hver iterasjon.*/
    public static int antallUlikeUsortert(int[] a) {
        if (a.length == 0) { // Sjekker om tabellen er tom, da returneres bare 0 iht oppgavens krav.
            return 0;
        }
        else {
            int sum = 1;    // Starter med sum = 1. Da får jeg returnert 1 om tabellen bare skulle inneholde 1 tall.

            for (int i = 1; i < a.length; i++) {    // Første for-løkken
                boolean unik = true;    // Denne avgjør om det skal inkrementeres eller ikke.
                if (a[i] != a[i-1]) {   // Dersom tallene ikke er like, sjekkes talet mot tidligere tall i neste for-løkke
                    for (int j = 0; j < i; j++) {
                        if (a[j] == a[i]) {     // Dersom jeg får en match tidligere i tabellen, vil unik=false, og vi bryter ut.
                            unik = false;
                            break;
                        }
                    }
                    if (unik) {     // Dersom denne fortsatt er unik (true) etter å ha vært gjennom andre løkken:
                        sum ++;     // så inkrementerer jeg.
                    }
                }
            }
            return sum;     // Antallet unike tall returneres
        }
    }

    ///// Oppgave 4 //////////////////////////////////////
    /*Kanskje jeg får løst dette ved å finne det til enhver tid minste tallet i tabellen, så sjekke om tallets modulus 2 er null. Altså if (n % 2 == 0), da vet jeg om det er partall eller oddetall.
    * Foreløpig litt usikker på hvordan det blir å plassere tallet tilbake i tabellen. Vi kan bruke a[i] greit nok for oddetallene som skal til venstre. Men hvordan vet jeg hvor mange oddetall det er, og hvor
    * partallene skal starte. */
    public static void delsortering(int[] a) {
        int antPartall = 0;
        for (int tall : a) {
            if (tall % 2 == 0) {
                antPartall++;
            }
        }

        for (int i = 0; i < a.length; i++) {
            int tall = min(a, i, a.length);
            if (tall % 2 == 0) {
                a[antPartall+i] = tall;
            }
            else {
                a[i] = tall;
            }
        }
    }

    public static int min(int[] a, int fra, int til) {    /*Minimum metode 1 - Fra kompendiet, oppgave 1.1.2.2 */
        if (fra < 0 || til > a.length || fra >= til)
            throw new IllegalArgumentException("Illegalt intervall!");

        int m = fra;             // indeks til minste verdi i a[fra:til>
        int minverdi = a[fra];   // minste verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++) if (a[i] < minverdi)
        {
            m = i;               // indeks til minste verdi oppdateres
            minverdi = a[m];     // minste verdi oppdateres
        }

        return minverdi;  // verdien til minste verdi i a[fra:til>
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
