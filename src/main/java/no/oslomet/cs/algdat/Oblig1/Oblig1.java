package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 ////////////////////////

import java.lang.UnsupportedOperationException;
import java.util.Arrays;
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
                    bytter ++;          // Inkrementerer etter et bytte.
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
    /* Kodesnutter som er implementert fra kompendiet:
    - kvikksortering, Programkode 1.3.9 h)
    - sParter0, Programkode 1.3.9 f)
    - parter0, Programkode 1.3.9 a)
    - bytt, Programkode 1.1.8 d*/
    public static void delsortering(int[] a) {
        kvikksortering(a);      // Her sorterer jeg tabellen i sin helhet.
        int oddetall = 0;       // Assigner teller til bruk i for-løkken. Denne variabelen vil fungere som en slags veiviser for hvor oddetallene skal inn senere.
        for (int i = 0; i < a.length; i++) {        // Løper gjennom arrayet. Gjør ingenting om jeg finner et partall.
            if (a[i] % 2 == 0) { // Partallsjekken
                        // Er det partall så lar jeg tallene være for nå.
            }
            else {      // Er det ikke partall, må det være oddetall.
                        // I elsen, så fyller jeg fra 0'te indeks med oddetallene vi måtte finne underveis. Det gjør jeg med bytt metoden.
                bytt(a, oddetall, i);
                oddetall++;
                        // Det som er litt kjipt er at jeg er ganske sikker på at oddetallene bytter plass med seg selv dersom tabellen skulle kun bestå av oddetall. Men det klarer jeg ikke å unngå per nå.
                        // Det bytt metoden gjør, beskrives de følgende linjene:
                        // Jeg har fra før assignet oddetall som = 0, som fungerer som "indeks 0", fordi jeg vil starte å fylle tabellen med oddetall først. Slik oppgaven vil ha den.
                        // Steg 1: temp = a[oddetall]; Da mellomlagres det som er i a[oddetall]
                        // Steg 2: a[oddetall] = a[i]; Så overskrives det med a[i], som må være et oddetall, fordi koden er inne i elsen.
                        // Steg 3: a[i] = temp; Her settes så tallet som ble fjernet fra steg 1. Verdiene har nå byttet plass.
                        // Deretter inkrementerer jeg oddetall variabelen. Neste gang man er i elsen, vil neste indeks fylles med et eventuelt oddetall.
            }
        }
        // Hvis alt gikk riktig for seg, vil oddetallene (dersom de finnes) være sortert i stigende rekkefølge fra venstre i tabellen.
        // Da kan jeg sortere de resterende tallene (som i teorien skal være partallene) med en quicksort på resten av tabellen.
        // Merker meg at jeg må bruke oddetall og ikke oddetall+1 som start posisjon. Det er fordi jeg allerede har inkrementert oddetall variabelen på slutten av else.
        kvikksortering(a, oddetall, a.length);
    }

    private static void kvikksortering0(int [] a, int v, int h) {  // Kompendiekode - Programkode 1.3.9 h)
        if (v >= h) {
            return; // Dersom a[v:h] er tomt, eller har maks ett element
        }
        int k = sParter0(a, v, h, (v + h) / 2);     // Bruker midterste indeks
        kvikksortering0(a, v, k-1); // Sorterer intervallet til venstre for k. a[v:k-1]
        kvikksortering0(a, k+1, h); // Sorterer intervallet til høyre for k. a[k+1:h]
    }

    public static void kvikksortering(int[] a, int fra, int til) { // Kompendiekode - 1.3.9 - Her har jeg fjernet fratilKontroll delen fra koden
        kvikksortering0(a, fra, til-1); // v = fra, h = til - 1
    }

    public static void kvikksortering(int[] a) { // Kompendiekode
        kvikksortering0(a, 0, a.length - 1);
    } // Kompendiekode - 1.3.9

    private static int sParter0(int[] a, int v, int h, int indeks) {  // Kompendiekode - Programkode 1.3.9 f)
        bytt(a, indeks, h);           // skilleverdi a[indeks] flyttes bakerst
        int pos = parter0(a, v, h - 1, a[h]);  // partisjonerer a[v:h - 1] - oppgir da bakerste indeks som skilleverdi
        bytt(a, pos, h);              // bytter for å få skilleverdien på rett plass
        return pos;                   // returnerer posisjonen til skilleverdien
    }

    private static int parter0(int[] a, int v, int h, int skilleverdi) { // Kompendiekode - Programkode 1.3.9 a)
        while (true) {
            while (v <= h && a[v] < skilleverdi) { // h er stoppverdi for v
                v++;
            }
            while (v <= h && a[h] >= skilleverdi) { // v er stoppverdi for h
                h--;
            }
            if (v < h) {
                bytt(a, v, h);
                v++;
                h--;
            }
            else return v;
        }
    }
    public static void bytt(int[] a, int i, int j) { // Kompendiekode - Programkode 1.1.8 d
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }


    ///// Oppgave 5 //////////////////////////////////////
    // Denne oppgaven ble greit løst med en litt modifisert versjon av kompendiets programkode 1.3.13 b)
    public static void rotasjon(char[] a) {     // en lett modifisert variant av kompendiets programkode 1.3.13 b)

        int enEnhet = 1;                                            // Denne brukes da vi kun skal rotere med én enhet.
        int n = a.length;                                           // instansierer lengden på arrayet.
        if (n < 2)  {
            return;                                                 // Sjekker at arrayet ikke er tomt, eller inneholder kun én verdi.
        }
        char [] b = Arrays.copyOfRange(a, n-enEnhet, n);       // Kopierer det som skal skyves ut av tabellen.
        for (int i = n -1; i >= enEnhet; i--) {                     // Forskyver en og en verdi i indeksen en enhet av gangen. Helt frem til a[1] har kopiert det som er i a[0]
            a[i] = a[i - enEnhet];
        }
        System.arraycopy(b, 0, a, 0, enEnhet);        // Kopierer tilbake det som ble skjøvet ut, til starten av arrayet.
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
