# Obligatorisk oppgave 1 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende student:
* George Alexander Saavedra, S360536, s360536@oslomet.no


# Arbeidsfordeling



# Oppgavebeskrivelse
Her følger også svar på de teoretiske spørsmålene som tas opp i oppgavetekstene.
Den mer detaljerte fremgangsmåten rundt teoretiske spørsmål er tatt opp i kildkodekommentarer.

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
å sammenligne elementer i tabellen, i tillegg skal stokke om for å sende de bakerst.

Oppgave 2:

Det første metoden skulle var å returnere en feilmelding dersom ikke tabellen er sortert stigende.
Dette løstes ved å sjekke for inversjoner. Dersom det hadde vært 1 eller flere inversjoner, betyr det at tabellen ikke
er sortert stigende.
Inversjonssjekken benytter en metode fra kompendiet - Programkode 1.3.2 a).

Deretter vil en for løkke sjekke om det er forskjeller mellom verdiene i indeksene, og telle opp antallet "hits" som da
vil være antallet unike tall. Tellingen starter fra 1. Dersom alle tall var like ville den ikke fått noen "treff" men
likevel korrekt returnert 1.

Oppgave 3: Her hadde jeg tenkt å starte med en hjelpetabell, men så ser jeg at det ikke er lov.
