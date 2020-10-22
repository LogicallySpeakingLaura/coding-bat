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
        boolean isOne = false;

        while( n > 0 ) //set bound, nothing left to check when n == 0
            if( n % 10 == 1 ) //check right digit
            {
                isOne = true;
                break;
            }
            else
                n /= 10; //discard right digit if it's not 1

        return isOne;     }

    /**
     * We'll say that a positive int divides itself if every digit in the number divides into the number evenly. So for example 128 divides itself since 1, 2, and 8 all divide into 128 evenly. We'll say that 0 does not divide into anything evenly, so no number with a 0 digit divides itself.
     */
        public boolean dividesSelf( int n )
        {
            boolean canDivide = true;

            for( int i = n ; i > 0 ; i /= 10) //assign n to i so i can be manipulated and still compared to n, /=10 to discard right digit
                if( i % 10 == 0 || n % ( i % 10 ) != 0 ) //if right digit is 0 or n cannot divide by current digit(s)
                {
                    canDivide = false; //return false
                    break;
                }

            return canDivide;
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

    /**
     * We'll say that a positive int n is "endy" if it is in the range 0..10 or 90..100 (inclusive). Given an array of positive ints, return a new array of length "count" containing the first endy numbers from the original array. Decompose out a separate isEndy(int n) method to test if a number is endy. The original array will contain at least "count" endy numbers.
     */
    public int[] copyEndy( int[] nums, int count )
    {
        int[] copy = new int[count]; //new array of count length

        for( int i = 0, j = 0 ; j < copy.length ; i++ ) //i for nums, j for copy, iterate count times, increment nums index
            if( isEndy( nums[i] ) ) //if value is an endy
                copy[j++] = nums[i]; //place it in next available index of copy and increment j

        return copy;
    }
    public boolean isEndy( int n )
    {
        return ( 0 <= n && n <= 10 ) || ( 90 <= n && n <= 100 );
    }

    /**
     * Given 2 arrays that are the same length containing strings, compare the 1st string in one array to the 1st string in the other array, the 2nd to the 2nd and so on. Count the number of times that the 2 strings are non-empty and start with the same char. The strings may be any length, including 0.
     */
    public int matchUp( String[] a, String[] b )
    {
        int count = 0;

        for( int i = 0 ; i < a.length ; i++ ) //lengths are same, doesn't matter which used
                //check for empty String elements,      compare equality of first chars
            if( !a[i].equals("") && !b[i].equals("") && a[i].charAt(0) == b[i].charAt(0) )
                count++;

        return count;
    }

    /**
     * The "key" array is an array containing the correct answers to an exam, like {"a", "a", "b", "b"}. the "answers" array contains a student's answers, with "?" representing a question left blank. The two arrays are not empty and are the same length. Return the score for this array of answers, giving +4 for each correct answer, -1 for each incorrect answer, and +0 for each blank answer.
     */
    public int scoreUp( String[] key, String[] answers )
    {
        int score = 0;

        for( int i = 0 ; i < key.length ; i++ )
            if( key[i] == answers[i] )
                score += 4;
            else if( answers[i] == "?" ) //check for blank before wrong answer, as != will prove true for a blank answer
                score += 0;
            else if( key[i] != answers[i] )
                score -= 1;

        return score;
    }

    /**
     * Given an array of strings, return a new array without the strings that are equal to the target string. One approach is to count the occurrences of the target string, make a new array of the correct length, and then copy over the correct strings.
     */
    public String[] wordsWithout( String[] words, String target )
    {
        int count = 0;

        for( String w : words ) //check every element
            if( !w.equals(target) ) //if element != target increment count
                count++;

        String[] without = new String[count]; //new array of length count

        for( int i = 0, j = 0 ; j < without.length ; i++ ) //i for words, j for without, loop count times, increment words index
            if( !words[i].equals(target) )
                without[j++] = words[i]; //if there isn't a target match assign current words element to appropriate without index, increment j

        return without;
    }

    /**
     *
     Given two arrays, A and B, of non-negative int scores. A "special" score is one which is a multiple of 10, such as 40 or 90. Return the sum of largest special score in A and the largest special score in B. To practice decomposition, write a separate helper method which finds the largest special score in an array.
     */
    public int scoresSpecial( int[] a, int[] b )
    {
        return largestSpecial(a) + largestSpecial(b);
    }
    public int largestSpecial( int[] scores )
    {
        int largest = 0;

        for( int i = 0 ; i < scores.length ; i++ )
            if( scores[i] % 10 == 0 ) //check if multiple of 10
                largest = Math.max( largest, scores[i]); //is current element larger than last largest element

        return largest;
    }

}
