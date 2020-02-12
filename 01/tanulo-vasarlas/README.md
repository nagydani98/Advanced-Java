# Tanuló, vásárlás osztály #

1. Definiáljon egy **Tanulo** osztályt, amely tárolja a **nev** (szöveg) és a **penz** (egész) adatokat. A név adatot csak egyszer szeretnénk beállítani a konstruktorban! 
Az adatokat a leszármazott osztályból és az adott osztályból szeretnénk csak kiolvasni!
    * Definiáljon egy megfelelő adattagot (tanulok), amely az összes Tanulo objektum darabszámát képes tárolni.
    * Készítsen megfelelő gettert osszestanulo néven, amely a tanulok darabszámát adja vissza!
    * Készítsen csak gettert penz néven, amely a penz értékét adja vissza!
    * Definiáljon konstruktort, amellyel egy példány létrehozható! 
    Gondoskodjon a tanulok adattag frissítéséről!
    * Definiáljon egy egy paraméteres konstruktort, amely meghívja az előző konstruktort, a nevet a paraméterrel, 
    a pénzt pedig 10000-re állítja be.
    * Definiáljon egy megfelelő metódust arra az esetre, ha az objektum megszűnne, frissítse a tanulok adattagot.
    * Definiálja a toString metódust úgy, hogy a következő formában adja vissza az objektum állapotát: Tanuló: [név] 1301 Ft;
    * Definiáljon egy fogyasztás metódust, amely a paraméterben kapott értékkel csökkenti a pénz adattagot! Térjen vissza igaz értékkel, ha a pénz elfogyott, hamissal egyébként!
2. Írjon egy **Vasarlast** osztályt, amely futtatható. 
    * Hozzon létre egy dinamikus tömböt, melyben Tanulo példányok tárolhatók!
    * Példányosítson 5 db objektumot, tetszőleges adattokkal, használja az egy paraméteres konstruktort, majd illessze be a tömbbe!
    * Hadd szaladjon a vásárlás! 6 körös vásárlást szimulálunk. Ciklusban (6 iteráció) hívja meg a fogyasztás metódust minden Tanulo objektumra, 
    véletlen értékekkel (a 1500-3000 intervallumból). 
        * A visszatérési értéket vizsgálva nullázza ki azokat a Tanulo –kat amelyeknek elfogyott a pénzük!
        * Minden körben írja ki az átlag pénz értékét (összes pénz / tanulok száma)!
        * Írassa ki hány Tanulo maradt a vásárlás végén, majd írassa ki a tanulókat (toString)! 

4. Szorgalmi feladat:
    * használjon lombok libet a getterekhez, toStringhez!