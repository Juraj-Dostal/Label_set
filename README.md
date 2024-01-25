**Label set algoritmus**
_____________________________________
Label-set algoritmus slúži na hľadanie najkratšej cesty v digrafe.

Label-set(a Label-correct) implementuje algoritmus na hľadanie najkratších orientovaných u–v
ciest z pevného vrchola u Є V do všetkých ostatných vrcholov v Є V v hranovo ohodnotenom
digrafe G=(V,H, c) s nezápornou cenou orientovanej hrany c(h), kde 0 !Є V .

Rozdiel medzi Label-correct a Label-set je, že pri correct vyberáme náhodne čo pri sete s najmenšou t().

________________________________________
**Popis fungovania algoritmu**:
- Krok 1: Inicializácia. Polož t(u) == 0, t(i) = ∞ pre i Є V, i != u a x(i) == 0 pre každé i Є V . Polož E = {u}.
  
- Krok 2: Vyber r Є E, polož E = E − {r}. Pre všetky orientované hrany tvaru (r, j) Є H urob:

  - Ak t(j) > t(r) + c(r , j), potom t(j) = t(r) + c(r , j), x(j) == r , E == E + {j}.

- Krok 3: Ak E !={} , chod’ na Krok 2. Ak E = {}, potom t(i) predstavuje dĺžku najkratšej
orientovanej u–i cesty pre každý vrchol i. Najkratšiu orientovanú u–i cestu zostroj potom
spätne pomocou značiek x(i) ako v predchádzajúcich dvoch algoritmoch.

________________________________________
**Ako spustiť**:

Ku algoritmu sú dostupné aj vstupné údaje(Digrafy). V main class stači premenovať názov vstupného súboru a spustiť.

________________________________________
Tento algoritmus som programoval na predmet Algoritmická teória grafov.
Ma slúžiť na inspiráciu a odkontrolovanie si vysledkov.
