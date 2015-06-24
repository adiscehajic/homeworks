Task 1

Napraviti klasu Computer, koja je abstract. Klasa sadr�i ime i MAC adresu racunara. Pored toga, napraviti i
dva konstruktora, kao i dvije get metode. MAC adresa je objekat koju opisuje unutra�nja nestaticna klasa
MACAddress. Objekat tog tipa treba sadr�avati niz karaktera adrese, ali bez ':'. Klasa treba imati toString
metodu i konstruktor. Napraviti i equals i toString metode za Computer klasu.

Task 2

Napisati klasu Network, koja je abstract. Network klasa sadr�i atribut imena mre�e, kao i spisak racunara
koji su u toj mre�i (niz racunara). Klasa sadr�i konstruktor koji inicijalizira broj racunara niza na 0, kao i metodu
addComputer(Computer c) i removeComputer(Computer c), koje su abstract.

Task 3

Napisati Server klasu koja sadr�i broj koji oznacava koliko maksimalno drugih racunara mo�e podnijeti a da
ne do�ivi krah. Napraviti i jednu get metodu za taj limit. Napisati dodatni konstruktor koji inicijalizira ime, MAC
adresu i spomenuti limit servera. Napraviti i equals i toString metode.

Task 4

Napraviti interface Connectable koji sadr�i metode connect(Computer), connect(Network) i
disconnect().

Client klasa sadr�i atribut tipa Computer koji oznacava sa kojim je racunarom dati klijent spojen. Pored
toga, ima jo� jedan slican atribut koji je tipa Network koji oznacava sa kojom je mre�om klijent spojen.
Konstruktor klijenta treba imati samo ime i MAC adresu. Klasa implementira Connectable interface. Metoda
connect treba da postavi link na dati racunar, odnosno na datu mre�u. Ukoliko link vec postoji onda baciti
exception. Metoda disconnect postavlja oba linka na null. Napisati i get metodu za te link metode.
Napraviti i equals i toString metode.

Napomena: Client se nikada ne mo�e spojiti na drugu mre�u/racunar ako mu oba atributa nisu null!

Task 5

Napraviti demonstraciju svih klasa i metoda iz prija�nja cetiri zadatka.

Napisati javadoc za sve metode (nije potrebno za equals i toString metode).

Task 6 

Napraviti interface Functionable koji ima metodu boolean isFunctioning().

Task 7

Napraviti klasu ArrayManipulation koja sadr�i static metodu extendArray(Computer[]) koja
pro�iri dati niz za jedan index/element. Novi element treba biti null. Pored toga, tu se nalazi i metoda
shrinkArray(Computer[], int) koja smanji dati niz za jedan tako �to �obri�e� dati index.

Task 8

Napraviti klasu BusNetwork koja nasljeduje Network klasu i implementira Functionable interface.

Metoda addComputer radi na principu tako �to pro�iri prvo niz racunara za jedan, zatim stavi dati racunar na
to mjesto i povezuje racunar preko njegove connect metode sa ovom mre�om. Metoda removeComputer
radi na principu tako �to prvo pronade dati racunar (ako ga nema baciti exception) i obri�e ga (smanji niz).
Pored toga, racunar prekida svoju vizu sa mre�om preko svoje disconnect metode.

Metoda isFunctioning treba vratiti true ukoliko ima barem dva racunara spojena na mre�i (da nisu
null). toString metoda treba imati broj racunara u sebi, kao i dio koji govori da li mre�a funkcioni�e ili ne.

Task 9

Napraviti klasu StarNetwork koja nasljeduje Network klasu i implementira Functionable interface.
Klasa sadr�i jedan Server.

Metoda addComputer radi na principu tako �to pro�iri prvo niz racunara za jedan, zatim stavi racunar na to
mjesto. Pored toga, dati racunar se povezuje preko connect metode sa serverom preko svoje connect metode.
Metoda removeComputer radi na principu tako �to prvo pronade dati racunar (ako ga nema baciti
exception) i obri�e ga (smanji niz). Pored toga, dati racunar prekida link sa serverom preko svoje
disconnect metode.

Metoda isFunctioning treba vratiti true ukoliko server radi. Server pada ukoliko ima vi�e povezanih
racunara nego �to mo�e podnijeti. toString metoda treba imati broj spojenih racunara na server u sebi, kao
i dio koji govori da li mre�a funkcioni�e ili ne.

Task 10

Napisati javadoc za sve metode osim toString i equals metode. Napisati demonstraciju svih metoda!