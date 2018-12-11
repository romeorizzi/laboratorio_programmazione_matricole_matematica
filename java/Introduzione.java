/**
 * PrimoEsempio.java
 * Primo esempio di codice in Java
 * @author Eros Rossi
 */

// SEZIONE 1
import java.util.*;

// SEZIONE 2
public class PrimoEsempio
{
  // SEZIONE 3
public static void main(String[] args){

  int a; // Dichiaro una variabile chiamata a di tipo int (integer).
  int b = 5; // Dichiaro una variabile b di tipo int e la inizializzo a 5.

  System.out.println("Questa é la mia prima stampa!");
  // Semplice stampa, println va a capo dopo aver stampato.

  System.out.println("Variabile b = " +b);
  // Stampo la scritta tra virgolette, poi ad esso concateno (+) il valore
  // della variabile b.

  a = 10*b; // Assegno un valore ad una variabile giá dichiarata.

  System.out.println("Variabile a = " +a);

  for ( int i = 0; i < 10; i++ ) // Eseguo un ciclo che itera sulla variabile i.
  {
    System.out.println("Iterazione del ciclo numero: "+ i);
  }

  int c = SempliceMetodo(a,b);

  System.out.println("Variabile c = " +c);
}
/**
* Questo é un semplice esempio di un metodo.
*
* @param  y,x sono due interi che passo al mio metodo (input).
* @return la somma dei valori ottenuti in input.
*/
static int SempliceMetodo(int x, int y)
{
  int risultato;
  risultato = x+y;
  return risultato; // Ritorno il valore della variabile risultato
}

}
