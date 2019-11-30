import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class binarysearch {


        public static void main(String[] args) {

            Scanner input = new Scanner(System.in);

            System.out.print("Enter Min number: ");
            int min = input.nextInt();
            System.out.println("You entered " + min);

            System.out.print("Enter Max number: ");
            int max = input.nextInt();
            System.out.println("You entered " + max);

            System.out.print("How many random number do you need?: ");
            int random = input.nextInt();
            System.out.println("You entered " + random);


            ArrayList<Integer> list = new ArrayList<>();
            for (int i = min; i < max; i++) {
                list.add(new Integer(i));
            }

            ArrayList<Integer> randomlist = new ArrayList<>();

            Collections.shuffle(list);
            for (int i = 0; i < random; i++) {

                randomlist.add(list.get(i));
                System.out.println(randomlist);
                Collections.sort(randomlist);
                // sort open code

                    for (int j = i + 1; j < randomlist.size(); j++)
                    {
                        if (randomlist.get(i) > randomlist.get(j))
                        {
                            int temp = randomlist.get(i);
                            randomlist.set(i,randomlist.get(j));
                            randomlist.set(j,temp);
                        }
                    }


            }
            System.out.println(randomlist);

            System.out.print("Enter a number for searching: ");
            int search = input.nextInt();
            System.out.println("You entered " + search);

            long start = System.nanoTime();

            boolean ans = randomlist.contains(search);

            if (ans)
                System.out.println("The list contains" + search);
            else
                System.out.println("The list does not contains" + search);

            long end = System.nanoTime();
            long timeInMillis = TimeUnit.MILLISECONDS.convert(end - start, TimeUnit.NANOSECONDS);
            System.out.println("Time spend in ms: " + timeInMillis);
            System.out.println("Time spend in nanos: " + (end - start));

            long start2 = System.nanoTime();

            int pos = Collections.binarySearch(randomlist, search);
            System.out.println(pos);

            long end2 = System.nanoTime();
            long timeInMillis2 = TimeUnit.MILLISECONDS.convert(end2 - start2, TimeUnit.NANOSECONDS);
            System.out.println("Time spend in ms: " + timeInMillis2);
            System.out.println("Time spend in nanos: " + (end2 - start2));

            // binary search open code
            long start3 = System.nanoTime();

            int first = 0;
            int last = randomlist.size() - 1;
            int middle = (first + last) / 2;

            while (first <= last) {

                if (randomlist.get(middle) < search)
                    first = middle + 1;
                else if (randomlist.get(middle) == search) {
                    System.out.println(search + " found at location " + (middle + 1) + ".");
                    break;
                } else
                    last = middle - 1;

                middle = (first + last) / 2;
            }

            if (first > last)
                System.out.println(search + " isn't present in the list.\n");

            long end3 = System.nanoTime();
            long timeInMillis3 = TimeUnit.MILLISECONDS.convert(end3 - start3, TimeUnit.NANOSECONDS);
            System.out.println("Time spend in ms: " + timeInMillis3);
            System.out.println("Time spend in nanos: " + (end3 - start3));


        }

    }






