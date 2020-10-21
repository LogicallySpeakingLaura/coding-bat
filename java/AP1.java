/**
 * @author LogicallySpeakingLaura
 * @version 2020/10/20
 * AP CS medium problems. These problems are based on free response questions from old AP CS-A exams, 2004 and later. Some are from the exams and some were just created to have a similar difficulty. These problems are good practice for the logic/loop/array aspects of the exam.
 * https://codingbat.com/java/AP-1
 */
public class AP1
{

    /**
     * Given an array of scores, return true if each score is equal or greater than the one before. The array will be length 2 or more.
     */
    public boolean scoresIncreasing( int[] scores )
    {
        boolean increase = true;

        for( int i = scores.length - 1 ; i > 0 ; i-- ) //start at end and move back
            if( scores[i] < scores[ i - 1 ] ) //if left of i is greater than i, condition not met
            {
                increase = false; //reverse boolean and return it immediately
                break;
            }

        return increase;
    }

    /**
     * Given an array of scores, return true if there are scores of 100 next to each other in the array. The array length will be at least 2.
     */
    public boolean scores100( int[] scores )
    {
        boolean hundred = false;

        for( int i = 0 ; i < scores.length - 1 ; i++ ) //set bound as want to check pairs
            if( scores[i] == 100 && scores[ i + 1 ] == 100 )
            {
                hundred = true; //as soon as match found return true
                break;
            }

        return hundred;
    }

    /**
     * Given an array of scores sorted in increasing order, return true if the array contains 3 adjacent scores that differ from each other by at most 2, such as with {3, 4, 5} or {3, 5, 5}.
     */
    public boolean scoresClump( int[] scores )
    {
        boolean increase = false;

        for( int i = 0 ; i < scores.length - 2 ; i++ )
            if( scores[ i + 2 ] - scores[i] <= 2 ) //only need to check first and last in clump of three as array already sorted
            {
                increase = true;
                break;
            }

        return increase;
    }

    /**
     * Given an array of scores, compute the int average of the first half and the second half, and return whichever is larger. We'll say that the second half begins at index length/2. The array length will be at least 2. To practice decomposition, write a separate helper method
     * int average(int[] scores, int start, int end) { which computes the average of the elements between indexes start..end. Call your helper method twice to implement scoresAverage(). Write your helper method after your scoresAverage() method in the JavaBat text area. Normally you would compute averages with doubles, but here we use ints so the expected results are exact.
     */
    public int scoresAverage( int[] scores )
    {
        int front = average( scores, 0, scores.length / 2 ); //find average of first half
        int back = average( scores, scores.length / 2, scores.length ); //find average of second half

        return Math.max( front, back ); //return bigger value
    }
    public int average( int[] scores, int start, int end )
    {
        int sum = 0;

        for( int i = start ; i < end ; i++ ) //add each i value to running total
            sum += scores[i];

        return sum / ( end - start ); //return calculate average
    }

    /**
     * Given an array of strings, return the count of the number of strings with the given length.
     */
    public int wordsCount( String[] words, int len )
    {
        int count = 0;

        for( String w : words ) //w is each element, will increment through each element in order
            if( w.length() == len ) //if length of the String for the element equals given length
                count++;

        return count;
    }

    /**
     * Given an array of strings, return a new array containing the first N strings. N will be in the range 1..length.
     */
    public String[] wordsFront( String[] words, int n )
    {
        String[] nArr = new String[n]; //new array of length n

        for( int i = 0 ; i < n ; i++ ) //only iterate n times or for nArr.length
            nArr[i] = words[i]; //index values same for each array

        return nArr;
    }

    /**
     * Given an array of strings, return a new List (e.g. an ArrayList) where all the strings of the given length are omitted.
     */
    public List wordsWithoutList( String[] words, int len )
    {
        //using ArrayList easier as no need to know final length
        //otherwise would have to do extra loop to figure out count, then create new array, then fill it
        ArrayList without = new ArrayList();

        for( String w : words ) //check each element
            if( w.length() != len )
                without.add(w); //only add to list if lengths don't match

        return without;
    }

    /**
     * Given a positive int n, return true if it contains a 1 digit. Note: use % to get the rightmost digit, and / to discard the rightmost digit.
     */
    public boolean hasOne( int n )
    {
        return String.valueOf(n).contains( "1" ); //converts int to String then performs check, easy regardless of # of digits
    }

    public boolean dividesSelf( int n )
    {
        //TODO solve later...
    }

    /**
     * Given an array of positive ints, return a new array of length "count" containing the first even numbers from the original array. The original array will contain at least "count" even numbers.
     */
    public int[] copyEvens( int[] nums, int count )
    {
        int[] even = new int[count]; //new array has to be length of count

        for( int i = 0, j = 0 ; i < nums.length && j < even.length ; i++  ) //i for nums, j for even
            if( nums[i] % 2 == 0 )
            {
                even[j] = nums[i];
                j++; //only increment even index once an even value placed
            }

        return even;
    }

}
