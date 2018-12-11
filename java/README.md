# Tutorial rapidissimo su Java

### Cosa è Java
In questa seconda parte del corso introdurremo il linguaggio di programmazione Java. 

Consiglio di leggere la pagina [Wikipedia](https://it.wikipedia.org/wiki/Java_(linguaggio_di_programmazione)) 
riguardo a Java per conoscere la storia e le caratteristiche di questo linguaggio. 

### Differenze fra Java e Python
La sintassi di Java è ispirata a quella di C++, in praticolare:
- ogni istruzione va terminata con un `;`
- i blocchi di codice sono delimitati con parentesi graffe (`{}`) anziché con l'indentazione (è comunque consigliato indentare correttamente il codice per questioni di leggibilità)
- le variabili vanno dichiarate prima dell'uso

Vediamo le principali differenze sintattiche con degli esempi

#### Commenti
In java i commenti sono di 3 tipi:
- commenti a linea singola, iniziano con `//` e si estendono fino a fine riga (l'equivalente dei commenti python `#`)
- commenti multilinea, iniziano con `/*` e finiscono con `*/`, possono estendersi su più righe
- commenti javadoc, iniziano con `/**` e finiscono con `*/`, funzionano come i commenti multilinea ma consentonod i inserire tag a supporto di IDE e sistemi di generazione automatica di documentazione

Esempi:
```java
// un commento a riga singola

/* un altro commento su una linea */

/* 
 * un commento multilinea
 */

/** 
 * un commento javadoc 
 * @author Alessandro Righi
 */
```

#### Espressioni
La sintassi delle espressioni è simile a python, alcune cose degne di nota:
- non esiste l'operatore elevamento a potenza (`**`)
- la divisione intera si fa con un singolo `/` e non con `//` come in python3
- gli operatori booleani `and`, `or`, `not` si indicano rispettivamente con `&&`, `||`, `!`
- esistono gli operatori `++` e `--` per incrementare/decrementare una variabile di un unità (anche se ne sconsiglio l'uso se non all'interno di istruzioni `for` in quanto causano ambiguità)
- le stringhe vanno racchiuse fra apici doppi (`"`) obbligatoriamente
- i singoli caratteri vanno invece obbligatoriamente fra apici singoli (`'`)
- si usano le costanti booleane `true` e `false` al posto di `True` e `False`
- l'equivalente di `None` di python in Java è `null`

#### Output
L'output in Java si fa con le funzioni seguenti, esempi:
```java
System.out.println("Hello, world!"); // stampa la stringa e va a capo (notare il ln che sta per line)
System.out.println(42); // posso stampare anche valori di tipi non stringa
System.out.println(false || true && true || !false);
System.out.print("Hello, world!"); // stampa una stringa e **non** va a capo
System.out.printf("%d %f\n", 42, 3.14); // la funzione printf come esiste in C, per chi la conoscesse
```

#### Variabili
Python è un linguaggio a tipizzazione dinamica, il che significa che le variabili non hanno un tipo e non devono essere dichiarate.
Al contrario Java usa la tipizzazione statica, un approccio più robusto ed efficiente, che richiede però di dichiarare le variabili esplicitamente prima dell'uso.

I tipi principali di variabili in Java sono:
- `byte`, `short`, `int`, `long`, interi con segno rispettivamente a 8, 16, 32 e 64 bit (valori da -2**(bit-1) a 2**(bit-1)-1)
- `unsigned byte/short/int/long`, come sopra, ma senza segno (valori da 0 a 2**bit)
- `float`, `double`, un numero a virgola mobile rispettivamente a singola (32bit) o doppia (64bit) precisione
- `char`, un carattere (codifica unicode UTF-16)
- `boolean`, un valore booleano (`true` o `false`) 
- `String`, una stringa di caratteri

Nota 1: conversioni implicite fra tipi non sono sempre possibili, a differenza di altri linguaggi come C/C++, ma sono possibili
solo quando la conversione non causa perdite di precisione (es `int -> long` ma non `long -> int`, nel secondo caso serve una conversoine esplicita)

```java
int i = 0; // dichiaro una variabile intera e la inizializzo a 0
long ans = -42;

// posso anche separare la fase di dichiarazine ed inizializzazione
// NB: a differenza di C/C++ una variabile va inizializzata prima di poter essere usata (come in Python) 
int j;
j = 0;

float pi = 3.14;
double e = 2.71;

boolean vero = true;
boolean falso = false;

char x = 'X';
String ciaoMondo = "Hello, world!";
```

#### Controllo di flusso

##### IF
In java l'if ha la seguente sintassi
```java
if (<condizione booleana>) {
    // ramo then
} else if (<altra condizione>) {
    // ramo elif
} else {
    // ramo else
}
```
Differenze princiali:
- i blocchi sono delimitati con parentesi graffe (in realtà, se il blocco contiene una singola istruzione si possono omettere... io consiglio almeno all'inizio di metterle sempre)
- la condizione va obbligaotoriamente fra parentesi tonde 
- non esiste una keyword `elif` ma si usa `else if` (di fatto non è altro che mettere if in cascata se ci pensate)

Nota: dato che booleani ed interi sono due tipi differenti, se ho un `int x`, `if (x != 0)` è valido, ma `if (x)` no!

##### WHILE
Il ciclo while è del tutto simile a quello di python
```java
while (<condizione>) {
  do_something();
  // ...
}
```
Si applica quanto detto sulle parentesi graffe e tonde per if. Come in python esistno le istruzioni `break;` e `continue;`.

##### DO-WHILE
In Java esiste anche il ciclo do-while con la seguente sintassi:
```java
do {
  do_something();
  // ...
} while (<condizione>);
```
Ha lo stesso funzionamento del while, soltanto che la condizione viene verificata al termine di ogni iterazione anziché all'inizio (in sostanza il ciclo fa sempre almeno un iterazione)

##### FOR
La sintassi del for è:
```java
for (<inizializzazione>; <test>; <incremento>) {
  do_something();
  // ...
}
```
dove:
  - `<inizializzazione>` è uno statement che viene eseguito una sola volta (tipicamente inizializza un contatore)
  - `<test>` è il test della condizione di ciclo che viene valutata ad ogni iterazione
  - `<incremento>` è uno statement che viene eseguito al termina di ogni iterazione (tipicamente incremento di un contatore)

Ognuna delle 3 parti può essere omessa (`for (;;)` è un ciclo infinito, equivalente a `while (true)`)


Ossia è soltanto zucchero sintattico per:
```java
<inizializzazione>;
while (<test>) {
  do_something();
  <incremento>;
}
```

O se vogiamo, il `while` è un tipo particolare di for (`while (<cond>)` è equivalente a `for (;<cond>;)`)

Il for come si vede è completamente diverso da quello di python, vediamolo degli esempi
```python3
for i in range(0, n):
  do_something(i)
```

Si traduce con
```java
for (int i = 0; i < n; i++) {
  do_something(i);
}
```
dove:
  - inizialmente dichiaro una variabile `i = 0`
  - ad ogni iterazione testo se `i < n`, se questa condizione è falsa esce dal ciclo
  - al termine di ogni iterazione incremento il valore di `i` (`i++` è equivalente a `i += 1`)

Esiste un ulteriore forma di for, il foreach, equivalente in python di `for x in list`:
```java
for (int x : array_of_int) {
  do_something(x);
}
```

#### Array
In python abbiamo visto le liste, che esistono anche in Java ma verranno affrontate più avanti. Vediamo una struttura dato più facile, l'array. 
L'array è una lista semplificata, in quanto ha una dimensione fissa, determinata alla sua creazione, e non consente quindi di aggiungere o eliminare elementi. 
In Java un array si dichiara in questo modo:
```java
int[] intArr = new int[42];
float[] floatArr = new float[42];
```
`new` crea un nuovo 'oggetto' array (vedremo più avanti cosa è un oggetto) della dimensione indicata. 

Per conoscere la lunghezza di un array, in python si usava `len(A)`, in Java si usa `A.length`. 

#### Stringhe
In Java, le stringhe hanno alcune particolarità che le rendono poco intuitive da utilizzare:
- non è possibile accedere ai caratteri di una stringa `s` con `s[i]`, ma è necessario usare il metodo `s.charAt(i)`
- le stringe **NON** vanno confrontate con l'operatore `==`, ma va usato il metodo `equals()`
- stringhe e caratteri sono due cose diverse
- le stringhe come in python si concatenano gli operatori `+` e `+=`
- la lunghezza si calcola con `s.length()`

Esempi:
```java
String s = "Hello";
String t = ", world";
String hw = s + t + "!"; // "Hello, world!"

hw[3]; // errore! Non posso usare [] sulle stringhe
hw.charAt(3); // 'l', charAt ritorna il carattere alla posizione i

String a = "A";
String b = "A";

a == b;      // sempre false! true solo se a e b sono la stessa identica stringa in memoria (identità)
a.equals(b); // true, in quanto a e b sono uguali

s.length(); // 5, lunghezza di s
```

#### Funzioni
In Java non esistono le funzioni come in Python, ma esistono i metodi, che possiamo dire siano grossomodo la stessa cosa (più avanti vedremo che non lo sono)
Un metodo in Java si dichiara con la seguente sintassi:
```java
<tipo ritorno> <nome>(<tipo parametro> <nome parametro>, ...) {
  // corpo funzione
}
```
Dove `<tipo parametro>` può essere un qualsiasi tipo visto precedentemente o il tipo speciale `void` che indica che la funzione non restituisce nessun valore.

Esempi:
```java
int somma(int a, int b) {
  return a + b;
}

void stampa(int x) {
  System.out.println(x);
}
```

#### Classi
`// TODO`

### Template di un programma Java
Un programma Java minimale ha la seguente struttura
```java
class HelloWorld {
   public static void main(String[] args) {
      System.out.println("Hello, world!");
   }
}
```
Il metodo `main()` è un metodo speciale detto entry point, che viene chiamato quando il programma viene mandato in esecuzione. 

Per compilare ed eseguire un programma Java dal terminale, è necessario fare i seguenti passi:
- salvare il programma in un file con estensione `.java` che deve obbligatoriamente chiamarsi come la classe contenuta (in questo caso, `HelloWorld.java`)
- spostarsi con il terminale nella directory dove si è salvato questo file
- dare il comando `javac <nomefile>.java`, per esempio `javac HelloWorld.java`. Se il programma non contiene errori, viene compilato e viene prodotto un file bytecode `<nomefile>.class`. 
- eseguire il file Java, sempre dalla stessa directory lanciare `java <nomefile>`, per esempio `java HelloWorld`. 

Esempio:
```bash
ale@fisso:~/java_example $ ls
HelloWorld.java
ale@fisso:~/java_example $ javac HelloWorld.java 
ale@fisso:~/java_example $ ls
HelloWorld.class  HelloWorld.java
ale@fisso:~/java_example $ java HelloWorld
Hello, world!
ale@fisso:~/java_example $
```

Errori comuni:
- salvare il file con un nome diverso rispetto a quello della classe in esso contenuta
- modificare il file `.java`, ma dimenticarsi di ricompilarlo con `javac`, andando a rieseguire sempre lo stesso file compilato
- definire il metodo `main()` in modi errati (deve avere esattamente quella forma, compreso il parametro `args` che va messo anche se non si usa)

