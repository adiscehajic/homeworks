#Task - Sortirane linkane liste

Iskoristit cemo naše poznavanje algoritama za sortiranje, te novonaucene vještine rukovanja linkanim listama, da napravimo novu strukturu: sortirana linkana lista.

Ova linkana lista se razlikuje od obicne linkane liste po tome što su elementi u njoj uvijek poredani u rastucem redoslijedu, bez obzira na to kojim su se redoslijedom dodavali u listu.

Za ovu svrhu vam je dostavljena klasa `SortedIntList` koja sadrži vec neke manje ili više implementirane metode.

Zadaci:

	1. Implementirajte metodu `add(int n)` tako da doda broj `n` u linkanu listu uzimajuci u obzir da linkana lista nakon pokretanja treba biti sortirana u rastucem redoslijedu.
	* ako vam se ovaj zadatak pokaže kao suviše komplikovan, a želite pokušati uraditi ostale zadatke, implementirajte `add(n)` metodu tako da dodaje element na kraj liste. Slicne primjere smo vec radili na GitHub-u.

	2. Dovršite implementaciju metode `toArray()` tako da vraca niz koji sadrži sve elemente iz liste u ispravnom redoslijedu.

	3. *(bonus)* Prepišite metodu `getLength()` tako da racuna dužinu liste reukurzivno umjesto iterativno.
	**HINT**: Sama metoda `getLength()` ne treba da bude rekurzivna, vec ce vam trebati pomocna metoda koja prima argument tipa `Node`. Ne zaboravite da je linkana lista definisana rekurzivno: svaki cvor linkane liste pokazuje na prvi cvor ostatka linkane liste :)
	*(malo manji bonus)* Ako ne uspijete implementirati rekurzivno brojanje elemenata, još uvijek možete spasiti obraz ako prepišete `getLength()` metodu tako da koristi `for` umjesto `while` petlje. Za ovo imate par hintova u kôdu objavljenom nakon današnjeg predavanja.
