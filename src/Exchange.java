import com.sun.istack.internal.NotNull;
import java.io.*;
import java.util.ArrayList;
import java.util.TreeSet;

public class Exchange {

    public WaysGroup getAllExchanges(int sumForExchange, ArrayList<Integer> denominationСoins) {
        ArrayList<Integer> coins = denominationСoins;
        WaysGroup[][] waysGroups = new WaysGroup[coins.size()][sumForExchange + 1]; //новый объект класса WaysGroup[число номиналов][сумма для размена+1]
        waysGroups[0][0] = new WaysGroup();
        waysGroups[0][0].add(new Way());
        for (int i = 0; i < sumForExchange; i++) { //текущая сумма
            for (int j = 0; j < coins.size(); j++) {
                for (int k = j; k < coins.size(); k++) { //номер монет для докидывания
                    if (i + coins.get(k) <= sumForExchange) { //если можно докинуть монету к i
                        if (waysGroups[k][i + coins.get(k)] == null){
                            waysGroups[k][i + coins.get(k)] = new WaysGroup();
                        }
                        waysGroups[k][i + coins.get(k)].add(waysGroups[j][i]);
                    }
                }
                if (i + coins.get(j) <= sumForExchange) {
                    waysGroups[j][i + coins.get(j)].add(coins.get(j)); //добавляем значение
                }
                waysGroups[j][i] = null;
            }
        }

        WaysGroup result = new WaysGroup();
        for (int i = 0; i < coins.size(); i++) {
            result.add(waysGroups[i][sumForExchange]);
        }
        return result;
    }

    public static int inputa() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a;
        System.out.print("Введите номинал купюры для размена: ");
        String numa = reader.readLine();
        try {
            a = Integer.parseInt(numa);
            if (a <= 0) throw new Exception("Вы ввели недопустимое число!");
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели недопустимые символы!");
            return Exchange.inputa();
        } catch (Exception e) {
            System.out.println("Вы ввели неположительные числа!");
            return Exchange.inputa();
        }
        return a;
    }

    public static ArrayList<Integer> inputb() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> b = new ArrayList();
        System.out.print("Введите доступные номиналы купюр: ");
        String numb = reader.readLine();
        String[] strnumb = numb.split(" ");
        int temp;
        try {
            for (int i = 0; i < strnumb.length; i++) {
                temp = Integer.parseInt(strnumb[i]);
                if (temp <= 0) throw new Exception();
                else b.add(temp);
            }
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели недопустимые символы!");
            return Exchange.inputb();
        } catch (Exception e) {
            System.out.println("Вы введи неположительные числа!");
            return Exchange.inputb();
        }
        return b;
    }

    @NotNull
    public static ArrayList<Integer> sortList(ArrayList<Integer> b) {
        TreeSet<Integer> set = new TreeSet<>();
        set.addAll(b);
        return new ArrayList<>(set);
    }

}