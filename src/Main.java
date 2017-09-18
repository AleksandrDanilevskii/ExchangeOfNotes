import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        Exchange exchange = new Exchange();

        int a = Exchange.inputa();

        List<Integer> b = Exchange.inputb();
        b = Exchange.sortList(b);

        if (b.get(0) <= a) {
            WaysGroup allWays = exchange.getAllExchanges(a, b);
            allWays.print();
        } else System.out.print("Размен невозможен!");

    }
}