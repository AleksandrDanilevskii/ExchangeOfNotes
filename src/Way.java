//Way.java для хранения конкретного варианта размена

public class Way {

    private final Integer[] coins;

    public Way() {
        coins = new Integer[0];
    }

    public Way(Way way) {
        coins = new Integer[way.coins.length + 1];
        System.arraycopy(way.coins, 0, coins, 0, way.coins.length);
    }

    public void add(int coin) {
        coins[coins.length - 1] = coin;
    }

    public void print() {
        for (int i = 0; i < coins.length - 1; i++) {
            System.out.print(coins[i] + " ");
        }
        System.out.println();
    }

}