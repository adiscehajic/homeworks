#Task - Sortirane linkane liste

Iskoristit cemo na�e poznavanje algoritama za sortiranje, te novonaucene vje�tine rukovanja linkanim listama, da napravimo novu strukturu: sortirana linkana lista.

Ova linkana lista se razlikuje od obicne linkane liste po tome �to su elementi u njoj uvijek poredani u rastucem redoslijedu, bez obzira na to kojim su se redoslijedom dodavali u listu.

Za ovu svrhu vam je dostavljena klasa `SortedIntList` koja sadr�i vec neke manje ili vi�e implementirane metode.

Zadaci:

	1. Implementirajte metodu `add(int n)` tako da doda broj `n` u linkanu listu uzimajuci u obzir da linkana lista nakon pokretanja treba biti sortirana u rastucem redoslijedu.
	* ako vam se ovaj zadatak poka�e kao suvi�e komplikovan, a �elite poku�ati uraditi ostale zadatke, implementirajte `add(n)` metodu tako da dodaje element na kraj liste. Slicne primjere smo vec radili na GitHub-u.

	2. Dovr�ite implementaciju metode `toArray()` tako da vraca niz koji sadr�i sve elemente iz liste u ispravnom redoslijedu.

	3. *(bonus)* Prepi�ite metodu `getLength()` tako da racuna du�inu liste reukurzivno umjesto iterativno.
	**HINT**: Sama metoda `getLength()` ne treba da bude rekurzivna, vec ce vam trebati pomocna metoda koja prima argument tipa `Node`. Ne zaboravite da je linkana lista definisana rekurzivno: svaki cvor linkane liste pokazuje na prvi cvor ostatka linkane liste :)
	*(malo manji bonus)* Ako ne uspijete implementirati rekurzivno brojanje elemenata, jo� uvijek mo�ete spasiti obraz ako prepi�ete `getLength()` metodu tako da koristi `for` umjesto `while` petlje. Za ovo imate par hintova u k�du objavljenom nakon dana�njeg predavanja.
