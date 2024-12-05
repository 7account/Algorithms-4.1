import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList; //for mode
import java.util.Collections; //for mode

public class Algorithms {
    private static File f;
    private static Scanner s;    public static void main(String[] args) throws FileNotFoundException {
        f = new File("Numbers.txt");
        int odds = odds();
        int evens = evens();
        int twoDigit = twoDigit();
        int greater500 = greater500();
        int greatest = greatest();
        int smallest = smallest();
        int total = total();
        double mean = mean();
        int mode = mode();
        System.out.println("Odds: " + odds);
        System.out.println("Evens: " + evens);
        System.out.println("Two Digit Numbers: " + twoDigit);
        System.out.println("Amount of Numbers greater than 500: " + greater500);
        System.out.println("Greatest Number: " + greatest);
        System.out.println("Smallest Number: " + smallest);
        System.out.println("Sum of All Values: " + total);
        System.out.println("Arithmetic Mean: " + mean);
        System.out.println("Mode: " + mode);
        s.close();
    }

    public static int odds() throws FileNotFoundException{
        s = new Scanner(f);
        int odds = 0;
        while (s.hasNext()) {
            if (s.nextInt() % 2 != 0)
                odds++;
        }
        return odds;
    }

    public static int evens() throws FileNotFoundException{
        s = new Scanner(f);
        int evens = 0;
        while (s.hasNext()) {
            if (s.nextInt() % 2 == 0)
                evens++;
        }
        return evens;
    }

    public static int twoDigit() throws FileNotFoundException{
        s = new Scanner(f);
        int twoDigit = 0;
        while (s.hasNext()) {
            int i = s.nextInt();
            if (i <= 99 && i >= 10)
                twoDigit++;
        }
        return twoDigit;
    }

    public static int greater500() throws FileNotFoundException{
        s = new Scanner(f);
        int greater500 = 0;
        while (s.hasNext()) {
            if (s.nextInt() > 500)
                greater500++;
        }
        return greater500;
    }

    public static int greatest() throws FileNotFoundException{
        s = new Scanner(f);
        int greatest = 0;
        while (s.hasNext()) {
            int i = s.nextInt();
            if (i > greatest)
                greatest = i;
        }
        return greatest;
    }

    public static int smallest() throws FileNotFoundException{
        s = new Scanner(f);
        int smallest = Integer.MAX_VALUE;
        while (s.hasNext()) {
            int i = s.nextInt();
            if (i < smallest)
                smallest = i;
        }
        return smallest;
    }

    public static int total() throws FileNotFoundException{
        s = new Scanner(f);
        int total = 0;
        while (s.hasNext()) {
            total += s.nextInt();
        }
        return total;
    }

    public static double mean() throws FileNotFoundException{
        s = new Scanner(f);
        double count = 0;
        double total = 0;
        while (s.hasNext()) {
            total += s.nextInt();
            count++;
        }
        double mean = (double) total / count;
        return (double) mean;
    }

    public static int mode() throws FileNotFoundException{
        s = new Scanner(f);
        ArrayList<Integer> listArray = new ArrayList<Integer>();
        int count = 0;
        int maxCount = 0;
        int mode = 0;
        while (s.hasNext()) {
            listArray.add(s.nextInt()); //use Mr.Holmer's hint- put every number into some sort of list
        }
        Collections.sort(listArray); //sort listArray in order to get number of times the # pops up
        int[] size = new int[listArray.size()]; //calculate size of list
        int x = 0;
        while (x<listArray.size()) {
            size[x] = listArray.get(x); // convert listArray to some sort of array
            x++;
        }
        for (int i = 1; i < size.length-1; i++) {
            if (size[i] == size[i-1]) { //find if the array starting at zero is greater than +1
                count++;
                if (count > maxCount) {
                    maxCount = count;
                    mode = size[i];
                }
            }
            else count = 0; //count has to be zero or else it would still be adding 
        }
        return mode;
    }
}
