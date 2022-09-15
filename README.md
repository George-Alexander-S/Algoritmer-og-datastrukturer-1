# Obligatorisk oppgave 1 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende student:
* George Alexander Saavedra, S360536, s360536@oslomet.no


# Arbeidsfordeling

Dette er en solo-innlevering.

# Oppgavebeskrivelse
Her følger en kort beskrivelse av hvordan hver oppgave har blitt løst.

En mer detaljert redegjørelse for hver oppgave finnes i relevante linjer i form av kildekodekommentarer.

Den mer detaljerte fremgangsmåten rundt teoretiske spørsmål er også tatt opp i kildkodekommentarer.

Kildekode markert med "Programkode n-n-n" er fra kompendiet: https://www.cs.hioa.no/~ulfu/appolonius/index.html

Oppgave 1:

Oppgaven er i korte trekk løst med en for løkke, som sammenligner et indeks (fra 1) med indeksen
før. Er forrige større så byttes de, slik vil man dytte det største tallet man har kommet over mot slutten
av tabellen. Returnerer så verdien i siste indeks.

Metoden ombyttinger fungerer på samme måte, men i stedet for å returnerer siste verdien så teller den byttene
og returnerer totalen av disse.

Flest ombyttinger blir det dersom tallene i tabellen er sortert i synkende rekkefølge.
Da må ombyttingen skje ved hver eneste iterasjon av for-løkken.

Færrest ombyttinger forekommer dersom tallene er sortert i stigende rekkefølge. Da er jo
tabellen ferdig sortert.

Angående gjennomsnittet:
Denne metoden tror jeg er mindre effektiv enn andre maks metoder, da den i tillegg til
å sammenligne elementer i tabellen, i tillegg skal stokke om for å sende de bakerst. Etter egne forsøk med tabeller av
ulike størrelser, med en gang tabellstørrelsen overstiger 6, så blir det i snitt 3 bytter.
Med 9 tall i tabellen er det 6 bytter i snitt. Antallet bytter øker ekstremt fort med antall tall i tabellen. Med 20
tall er vi oppe i 16 bytter i snitt. 

Jeg testet en tabell med 200 tall. I 5000 forskjellige permutasjoner. Det gav 194 bytter i snitt. Min konklusjon er at 
metoden er hårreisende inneffektiv.

Oppgave 2:

Det første metoden skulle var å returnere en feilmelding dersom ikke tabellen er sortert stigende.
Dette løstes ved å sjekke for inversjoner. Dersom det hadde vært 1 eller flere inversjoner, betyr det at tabellen ikke
er sortert stigende.
Inversjonssjekken benytter en metode fra kompendiet - Programkode 1.3.2 a).

Deretter vil en for løkke sjekke om det er forskjeller mellom verdiene i indeksene, og telle opp antallet "hits" som da
vil være antallet unike tall. Tellingen starter fra 1. Dersom alle tall var like ville den ikke fått noen "treff" men
likevel korrekt returnert 1.

Oppgave 3:

Denne oppgaven ble løst ved å bruke 2 for-løkker, en teller som teller unike tall, samt en boolean som hjelpevariabel.
Løkken sjekker verdiene i tabellen mot hverandre. Dersom 2 verdier er ulike, så går den inn i en ny for-løkke for å
sjekke tidligere tall i tabellen. Dersom den ikke finner en duplikat i andre for-løkken vil boolean unik forbli uendret (true)
og sum variabelen inkrementeres.

Oppgave 4:

Til denne oppgaven har jeg implementert en del kode fra kompendiet. quicksort, partere og bytt.

En hjelpevariabel (int) jeg kalte oddetall ble brukt for å plassere oddetallene fra 0 og utover. 
Først sorterte jeg hele tabellen med en quicksort. Deretter løp jeg gjennom arrayet og plukka ut partallene med en if og modulus av 2.
Dersom jeg kom over tall som ikke var partall (dermed oddetall), så ble de plassert i tabellen fra 0'te indeks og utover,
ved å bruke bytt metoden og hjelpevariabelen oddetall.

Når det var gjort, så skal det i teorien kun være partall (hvis noen) igjen i tabellen. Da kjørte jeg en quicksort med
resten av tabellen.

90% av tidsbruk i denne oppgaven gikk til å forstå den relevante koden fra kompendiet og implementere denne.
Resten kom relativt raskt på plass.

Oppgave 5:

Denne oppgaven har jeg løst ved å bruke en litt modifisert variant av programkode 1.3.13 d) fra kompendiet.
Ingen store problemer.

Oppgave 7a:

Ble løst med en kode som lignet litt på kompendiets programkode 1.3.11 a), men tilpasset strenger.
Oppgaven ble løst med while løkker og charAt metoden.

Oppgave 7b:

Ved siden av oppgave 4 var nok dette den oppgaven jeg sleit mest med. Essensen var at jeg tenkte motsatt om hvilken
løkke som skulle iterere hva. Da jeg snudde det riktig vei, altså til at moderløkken skulle iterere i forhold til lengden
for det lengste ordet, og at den interne løkken skulle iterere forbi antallet ord, så kom jeg nærmere fungerende kode.
if setningen i den indre løkken tar for seg s av j. Og dersom lengden av dette ordet, er lengre enn i's nåværende posisjon,
så skriver den charen (fra posisjon i) til ut variabelen.