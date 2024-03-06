package March_05_Assignment;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;


public class Q1_Reconstruct_Queue_by_Height
{
    public  int[] recunstructQueue(int height[] , int in_front[])// function reconstructQueue
    {
        Scanner sc = new Scanner(System.in);
        int length = height.length;
        // Creating a 2D array to store people's heights and the number of people in front of them
        int [][] people = new int[length][2];
        //  [n][2] is used to store two pieces of information for each person: their height and the number
        //       of people in front of them.

        for(int i=0;i<length;i++)
        {
            people[i][0]=height[i];// store height at specific location 0
            people[i][1] = in_front[i];// store infront person at location 1
        }
        Arrays.sort(people, new Comparator<int[]>()//override compare method of the comparator interface
        {

            public int compare(int[] person1, int[] person2)//  // If the first element of person1 is equal to the first element of person2
            {
               if(person1[0] == person2[0])  // Sort by the second element of the person in ascending order
               {
                   return person1[1] - person2[1];
               }
               else   // Sort by the second element of the person in ascending order
               {
                   return  person2[0] -person1[0];
               }
            }
        });

        List<int[]> result= new ArrayList<>();// create list
        for(int[] person : people)//for loop that add person
        {
           result.add(person[1] , person);
        }
        int output[] = new int[result.size()];// new output array
        for(int i=0;i<result.size();i++)
        {
            output[i] = result.get(i)[0];//convery arraylist to array
        }
        return output;// return output
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the queue ");
        int length = sc.nextInt();// length of queue
        int height[] = new int[length];//height type array for storing height
        int in_front[] = new int[length];// infront type array for storing pople in front
        System.out.println("enter the height of people");
        for(int i=0 ;i<length;i++)// user input for height
        {
            height[i] = sc.nextInt();
        }
        System.out.println("enter the infront people");// user input for infront people
        for(int i=0 ;i<length;i++)
        {
            in_front[i] = sc.nextInt();
        }
        Q1_Reconstruct_Queue_by_Height reconstructQueueByHeight = new Q1_Reconstruct_Queue_by_Height();// make object
        int actualOrder[] = reconstructQueueByHeight.recunstructQueue(height , in_front);// call recunstructQueue by object
        for(int i=0;i<actualOrder.length;i++)// loop for printing actual order of array
        {
            System.out.print(actualOrder[i]);
        }

    }

}
