import java.util.BitSet;
import java.util.List;
import java.util.stream.Collectors;

public class Sieve {
    private int limit = 100;

    public Sieve(int numero) {
        this.limit = numero;
    }

    public List<Integer> getPrimos() {

        BitSet numeros = new BitSet(limit);
        numeros.set(2, limit + 1);

        for (int i = 2; i <= Math.sqrt(limit); i++) {

            if (numeros.get(i)) {

                for (int j = i * i; j <= limit; j += i) {

                    numeros.clear(j);
                }
            }
        }
        return numeros.stream().boxed().collect(Collectors.toList());

    }
}


