Task 1

Napisati dvije klase:

	1. StoryElement klasa (abstract)
		a. Klasa koja opisuje jedan element u radnji jedne price
		b. Sadr�i atribut imena
		c. Sadr�i dva konstruktora
			i. Konstruktor koji inicijalizira ime na datu vrijednost
			ii. Prazni konstruktor koji inicijalizira, preko prvog konstruktora, ime na �STElement�

	2. Character klasa koja nasljeduje StoryElement klasu
		a. Klasa koja opisuje jednog lika u radnji jedne price
		b. Sadr�i spol karaktera
		c. Sadr�i atribut koji opisuje da li je lik �iv ili ne (default je true)
		d. Sadr�i atribut koji opisuje da li je lik sposoban ili ne
		e. Sadr�i metodu koja... ubija lika
		f. Sadr�i metodu koja pretvara nesposobnog lika u sposobnog
		g. Konstruktor koji inicijalizira ime, spol karaktera i sposobnost karaktera

Task 2

Napisati dvije klase:

	1. Event klasa
		a. Klasa koja opisuje dogadaj u radnji jedne price
		b. Klasa sadr�i samo konstante i to:
			i. Poraz
			ii. Prijateljstvo
			iii. Ljubav
			iv. Osveta
			v. Manipulacija

	2. Goal klasa koja nasljeduje StoryElement klasu
		a. Klasa koja opisuje cilj jednog lika u radnji jedne price
		b. Sadr�i atribut te�ine bazirano na tri vrijednosti (lagano, te�ko i nemoguce)
		c. Sadr�i atribut koji opisuje �ta (Event) se treba desiti da se ispuni cilj
		d. Sadr�i atribut koji opisuje kome ili sa kim (Character) se treba desiti dogadaj pod c.
		e. Sadr�i konstruktor koji inicijalizira tri pomenuta atributa, kao i ime cilja

Task 3

Napisati klasu:

	1. Protagonist klasa koja nasljeduje Character klasu
		a. Opisuje glavnog pozitivca u prici
		b. Sadr�i atribut koji opisuje glavni cilj (Goal) lika
		c. Sadr�i jedan niz, kao atribut, likova (Character) koji poma�u glavnom liku (max. 3)
		d. Sadr�i jedan atribut koji oznacava glavnog neprijatelja (Character)
			i. Dati atribut mo�e biti null
		e. Sadr�i konstruktor koji inicijalizira ime, spol, sposobnost i cilj lika
		f. Sadr�i metodu koja postavi glavnog neprijatelja
		g. Sadr�i metodu koja doda jednog lika koji ce pomoci glavnom liku
		i. Pomenuta metoda se mo�e samo cetiri puta pozvati (peti throw-a exception)

Task 4

Napisati metodu:

	1. Metoda attainGoal() u klasi Protagonist
		a. Metoda koja pokrene ciklus borbe glavnog lika i poku�aja da dokuci svoj cilj
		b. Metoda ne mo�e raditi ukoliko glavni lik nije �iv
		c. Metoda izracuna kolika je �ansa da glavni lik dokuci svoj cilj
			i. Ukoliko je glavni lik sposoban onda +40%
			ii. Za svakog sposobnog pomocnog lika +20%
			iii. Ukoliko je glavni neprijatelj sposoban onda -30%
			iv. Ukoliko je cilj te�ak onda -20%
			v. Ukoliko je cilj nemoguc onda -100%
			vi. �ansa uvijek mora biti izmedu 0 i 100%
		d. Bazirano na izracunatoj �ansi metoda odluci da li je lik uspio ili ne
			i. Uspjeh:
				1. Ispisati na konzolu da je lik uspio i u cemu (Goal) je uspio
				2. Napraviti jednog lika (nasumicno izabranog) sposobnim (ako nije bio)
			ii. Neuspjeh:
				1. Ispisati na konzolu da lik nije uspio i u cemu (Goal) nije uspio
				2. Nasumicno izabrati jednoga lika koji je ucestvovao i ubiti ga
				3. Napraviti jednog lika (nasumicno izabranog) sposobnim (ako nije bio)

Task 5

Napraviti pricu u main metodi pomocu navedenih klasa!
