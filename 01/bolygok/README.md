## Bolygók felfedezése

1. Hozz létre egy **Planet** nevű osztályt, amelynek állapota nem változhat! Most csak olyan attribútumok vannak,
amelyek nem változnak. A Bolygót, amikor felfedezik, akkor meghatározzák a helyzetét, az átmérőjét, és 
el is nevezik (tároljuk azeket a `position`, `radius`, `name` attribútumokba). (A bolygó életében ezek az adatok nem fognak változni.)
    * Hozz létre egy konstruktort, amelyben az objektum megkapja a három adatot kívülről, és rendre beállítja azokat!
    * Hozz létre getter metódusokat az attribútumokra!

2. Hozz létre egy osztály amely tárolja a bolygó abszolút koordinátáit **Point** néven. A bolygó abszolút helyzetét írja le.
    * Ennek az osztálynak három attribútuma van,  `x`, `y`, `z`. 
    * Hozzunk létre egy konstruktort, amely megkap három `long` típust, és beállítja az attribútumok értékét! 
    * Hozzunk létre getter metódusokat az attribútumokra!
    * Hozz létre egy **translate** metódust, amely a paraméterben megkapott `Point` példánnyal eltolt új `Point` példánnyal tér vissza.

3. Végül hozzunk létre egy csillagász osztályt **Astronomer**, amely az előzőeket használja! Minden csillagásznak van neve, 
nyilvántartja hogy milyen bolygókat fedezett fel (`List<Planet>` típusú). 
    * Szükség van egy konstruktorra, amellyel az attribútumok beállíthatóak (név). 
    * Szükség van egy getterre, amely visszaadja a felfedezett bolygókat (`getDiscoveredPLanets`).

A csillagász figyeli az égboltot. Adott pillanatban, adott helyet figyeli, amelyet a következő metódus szimulál:

```java
public void observeTheSky()`
```

Ez a metódus létrehoz 10 bolygót:
 * véletlenszerű sugár adatokkal,
 * nevük rendre a felfedező neve + egy szorszám (pl.: Galileo1, Galileo2, ...)
 * poziciója x iranyban 10-el eltolt helyzetűek (10, 0, 0), (20, 0, 0,), ... 


