# System aukcyjny

## Wprowadzenie

Specyfikacja wymagań funkcjonalnych w ramach informatyzacji procesu sprzedaży produktów w oparciu o mechanizm aukcyjny. 

## Procesy biznesowe

---
<a id="bc1"></a>
### BC1: Sprzedaż aukcyjna 

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Opis:** Proces biznesowy opisujący sprzedaż za pomocą mechanizmu aukcyjnego. |

**Scenariusz główny:**
1. [Sprzedający](#ac1) wystawia produkt na aukcję. ([UC1](#uc1))
2. [Kupujący](#ac2) oferuje kwotę za produkt wyższą od aktualnie najwyższej oferty. ([BR1](#br1)) ([UC2](#uc2))
3. [Kupujący](#ac2) wygrywa aukcję ([BR2](#br2)) ([UC3](#uc3))
4. [Kupujący](#ac2) przekazuje należność Sprzedającemu. ([UC4](#uc4))
5. [Sprzedający](#ac1) przekazuje produkt Kupującemu. ([UC5](#uc5))

**Scenariusze alternatywne:** 

2.A. Oferta Kupującego została przebita, a [Kupujący](#ac2) pragnie przebić aktualnie najwyższą ofertę.
* 2.A.1. Przejdź do kroku 2.

3.A. Czas aukcji upłynął i [Kupujący](#ac2) przegrał aukcję. ([BR2](#br2))
* 3.A.1. Koniec przypadku użycia.

---

## Aktorzy

<a id="ac1"></a>
### AC1: Sprzedający

Osoba oferująca towar na aukcji.

<a id="ac2"></a>
### AC2: Kupujący

Osoba chcąca zakupić produkt na aukcji.


## Przypadki użycia poziomu użytkownika

### Aktorzy i ich cele

[Sprzedający](#ac1):
* [UC1](#uc1): Wystawienie produktu na aukcję
* [UC1](#uc1): Podanie danych o produkcie oraz ceny wywoławczej 
* [UC3](#uc3): Przekazanie przedmiotu Kupującemu

[Kupujący](#ac2):
* [UC2](#uc2): Udział w aukcji
* [UC3](#uc3): Wygranie lub przegranie aukcji
* [UC3](#uc3): Przekazanie opłaty Sprzedającemu

---
<a id="uc1"></a>
### UC1: Wystawienie produktu na aukcję

**Aktorzy:** [Sprzedający](#ac1)

**Scenariusz główny:**
1. [Sprzedający](#ac1) zgłasza do systemu chęć wystawienia produktu na aukcję.
2. System prosi o podanie danych produktu i ceny wywoławczej.
3. [Sprzedający](#ac1) podaje dane produktu oraz cenę wywoławczą.
4. System weryfikuje poprawność danych.
5. System informuje o pomyślnym wystawieniu produktu na aukcję.

**Scenariusze alternatywne:** 

4.A. Podano niepoprawne lub niekompletne dane produktu.
* 4.A.1. System informuje o błędnie podanych danych.
* 4.A.2. Powrót do kroku 2.

---

<a id="uc2"></a>
### UC2: Udział kupującego w aukcji 

**Aktorzy:** [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujący](#ac2) zgłasza się do systemu dla udziału w aukcji.
2. System prosi o podanie danych oraz kwoty.
3. [Kupujący](#ac2) podaje dane oraz kwotę.
4. System werifikuje dane kupującego ([BR1](#br1))
5. System informuje o pomyślnym wzięciu udziału w

**Scenariusze alternatywne:** 

4.A. Podane błędne dane lub niespełniające wymagania.
* 4.A.1. System informuje o błędzie.
* 4.A.2. Powrót do kroku 2.

---

<a id="uc3"></a>
### UC3: Zakończenie aukcji 

**Aktorzy:** [Kupujący](#ac2), [Sprzedający](#ac1)

**Scenariusz główny:**
1. Po zakończeniu czasu trwania licytacji system wyłania zwycięzcę. ([BR2](#br2))
2. System informuje Kupującego, który wygrał aukcję o konieczności przekazania opłaty Sprzedającemu.
3. [Kupujący](#ac2) przekazuje opłatę przez system.
4. [Sprzedający](#ac1) w wybrany przez siebie sposób przekazuje produkt Kupującemu.
5. Po zakończeniu licytacji, opłacie i przekazaniu towaru system informuje o skutecznym zakończeniu aukcji. System też usuwa wszelkie wrażliwe dane.

**Scenariusze alternatywne:** 

1.A. Nie wpłynęła żadna oferta w trakcie trwania aukcji.
* 1.A.1. System informuje że nie było żadnej oferty o kupowaniu towaru.
* 1.A.2. System zamyka aukcję.

---

## Obiewkty biznesowe (inaczje obiekty dziedzinowe lub informatycjne)

### BO1: Aukcja

Aukcja jest formą zawierania transakcji kupna-sprzedaży, w której Sprzedający określa cenę wywoławczą produktu, natomiast Kupujący mogą oferować własną ofertę zakupu każdorazowo proponując kwotę wyższą od aktualnie oferowanej kwoty. Aukcja kończy się po upływie określonego czasu. Jeśli złożona została co najmniej jedna oferta zakupy produkt nabywa ten Kupujący, który zaproponował najwyższą kwotę. 

### BO2: Produkt

Fizyczny lub cyfrowy obiekt, który ma zostać sprzedany w ramach aukcji.

## Reguły biznesowe

<a id="br1"></a>
### BR1: Złożenie oferty

Złożenie oferty wymaga zaproponowania kwoty wyższej niż aktualnie oferowana o minimum 1,00 PLN.


<a id="br2"></a>
### BR2: Rozstrzygnięcie aukcji

Aukcję wygrywa ten z [Kupujący](#ac2)ch, który w momencie jej zakończenia (upłynięcia czasu) złożył najwyższą ofertę.

## Macierz CRUDL


| Przypadek użycia                                  | Aukcja | Produkt | 
| ------------------------------------------------- | ------ | ------- | 
| UC1: Wystawienia produktu na aukcję               |    C   |   C     | 
| UC2: Udział kupującego w aukcji                   |   RU   |   -     | 
| UC3: Zakończenie aukcji                           |    D   |  RUD    | 

