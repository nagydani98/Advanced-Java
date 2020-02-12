# Válógató interfész #

1. Definiáljon egy interfészt **Valogato** néven, amely előírja a következőt:
    * Egy joAlanyE metódust, amely logikai értékkel tér vissza.
2. Definiáljon egy **Szemely** osztályt, amely képes tárolni egy személy nevét és életkorát.
    * Definiáljon konstruktort, amellyel egy példány adatai beállíthatóak
    * Definiáljon egy gettert, amely visszaadja a személy életkorát.
    * Definiáljon egy gettert, amely visszaadja a személy nevét.
    * Definiálja felül a toString metódust! 
3. Definiáljon egy **Diak** osztályt a **Szemely** osztály leszármazottjaként, és egyben implementálja az **Valogato** interfészt.
    * Tartalmazzon továbbá adattagot, amely a puskák számát tárolja.
    * Definiáljon konstruktort, amellyel egy példány adatai beállíthatóak. Hívja meg az ős konstruktorát.
    * Implementálja a joAlanyE fv.-t! Akkor jó alany egy Diak, ha nincs nála puska.
    * Definiálja felül a ToString metódust! 
4. Definiáljon egy **Tanar** osztályt a **Szemely** osztály leszármazottjaként, és egyben implementálja az **Valogato** interfészt.
    * Tartalmazzon továbbá adattagot, amely a nála megszerzett vizsgajegyek átlagát tárolja.
    * Definiáljon konstruktort, amellyel egy példány adatai beállíthatóak.
    * Implementálja a joAlanyE fv.-t! Akkor jó alany egy Tanár, ha 30 évnél fiatalabb, és vizsgái átlaga > 4.
    * Definiálja felül a toString metódust! 
5. Írjon egy **Proba** osztályt, amely futtatható.
    * Ellenőrzi, hogy pontosan egy paraméter kapott-e. Ha nem, hibajelzést ír ki és befejezi a munkát.
    * Helyes paraméterek esetén létrehoz egy tömböt (mérete a kapott paraméter), melyben Tanar és Diak objektumokat tárol, tetszőleges adatokkal (számoknál véletlen).
    * Járja végig a tömböt, és írja ki a „jó alanyokat”!.

4. Szorgalmi feladat:
    * Mivel a Szemely osztálynak önmagában nincs értelme, tilsuk meg a példanyosítását! Csak a leszármazottakat lehessen. 
    * használjon lombok libet a getterekhez, toStringhez!