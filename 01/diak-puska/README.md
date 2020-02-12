# Diák osztály #

1. Definiáljon egy Szemely osztályt, amely képes tárolni egy személy nevét és életkorát. 
Az életkor és név csak 1x a konstruktorban változtatható meg!
    * Definiáljon konstruktort, amellyel egy példány adatai beállíthatóak
    * Definiáljon gettert, amely visszaadja a személy életkorát.
    * Definiáljon gettert, amely visszaadja a személy nevét.
2. Definiáljon egy Diak osztályt a Szemely osztály leszármazottjaként, 
és egyben implementálja a Comparable interfészt.
    ```java
    public interface Comparable<T> 
    {
        public int compareTo(T o);
    }
    ```
    * Tartalmazzon továbbá adattagot, amely a puskák számát tárolja.
    * Definiáljon konstruktort, amellyel egy példány adatai beállíthatóak.
    * Írja felül a ToString metódust!
    * Implementálja a CompareTo fv.-t! Akkor kisebb egy Diak, ha kevesebb puskája van.
3. Írjon egy Proba osztályt, amely futtatható.
    * Ellenőrzi, hogy pontosan egy paraméter kapott-e. Ha nem, hibajelzést ír ki és befejezi a munkát.
    * Az első kapott paraméter egy szám. Annyi darab példányt kell létrehozni a Diak osztályból.
    * Helyes paraméter esetén hozzon létre egy tömböt, majd helyezzen bele annyi Diak objektumot, a következő adatokkal 
név: diák01, diák02, … ; életkor: 18-25; puska: 0-5 (éeltkor, puska szám véletlen érték)
    * Végül írja ki a tömb elemeit egymás alá rendezve, elöl a kevesebb puskával rendelkezők!
    
    
    [ https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html ]
    [ https://howtodoinjava.com/java/collections/java-comparable-interface/ ]


```
mvn archetype:generate -DgroupId=hu.me.krz.haladojava -DartifactId=diak-puska -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
```

4. Szorgalmi feladat:
    * használjon lombok libet a getterekhez, toStringhez!