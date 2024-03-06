package March_05_Assignment;
import java.util.ArrayList;
import java.util.Scanner;

class Trinode
{
    Trinode[] children;//array to store child node
    int count;// count to track the number of words that pass through this

    public Trinode()
    {
        children = new Trinode[26];// child node for each character
        count = 0;// initialize count to 0
    }
}

public class Q2_Shortest_unique_Prefix {
    public ArrayList<String> prefix(ArrayList<String> words)
    {
        Trinode root = new Trinode();// create root of tree
        for (String word : words)
        {
            Trinode current = root;// start from the root for each word
            for (char ch : word.toCharArray()) //loop through each charater in word
            {
                int index = ch - 'a';// calculate index
                if (current.children[index] == null) //if child node doesnot exist for character
                {
                    current.children[index] = new Trinode();//create new node for character
                }
                current.count++;// increament count for this node
                current = current.children[index];// move to the child node
            }
        }
        // find shortest unique prefix
        ArrayList<String> result = new ArrayList<>();
        for (String word : words)
        {
            StringBuilder prefix = new StringBuilder();
            Trinode current = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                prefix.append(ch); // append character to prefix
                current = current.children[index];// move to the child node
                if (current.count == 1)// if count for any node is 1 then indicate unique
                {
                    break;
                }
            }
            result.add(prefix.toString());// add prefix to result list
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<>();

        //System.out.println("Enter words :");
        System.out.println("enter the limit or words");
        int limit = scanner.nextInt();// Set the limit of input words
      //  int limit = 5;
        int count = 0; // Counter to track the number of inputs
        System.out.println("enter the  words");
        String input;
        while (count <= limit)//continue until the number of input reaches limit
        {

            input = scanner.nextLine();
            if (input.equals("done")) // if user enter done then break
            {
                break;
            }
//            if (!input.matches("[a-z]+"))//check input contain only lower letter
//            {
//                System.out.println("Invalid input! Please enter only lowercase letters.");
//                continue;
//            }
            words.add(input);// add input word to the list
            count++;// increameneet count
        }

        Q2_Shortest_unique_Prefix uniquePrefix = new Q2_Shortest_unique_Prefix();
        ArrayList<String> prefixes = uniquePrefix.prefix(words);

        System.out.println("Shortest unique prefixes:");
        for (String prefix : prefixes)
        {
            System.out.println(prefix);// print prefix
        }
    }
}

