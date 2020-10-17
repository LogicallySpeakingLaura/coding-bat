/**
 * @author LogicallySpeakingLaura
 * @version 2020/10/16
 * Medium array problems -- 1 loop.
 * https://codingbat.com/java/Array-2
 */
public class Array2
{

    /**
     * Return the number of even ints in the given array.
     */
    public int countEvens( int[] nums )
    {
        int count = 0;

        for( int i = 0 ; i < nums.length ; i++ )
            if( nums[i] % 2 == 0 ) //even%2 == 0, odd%2 == 1
                count++;

        return count;
    }

    /**
     * Given an array length 1 or more of ints, return the difference between the largest and smallest values in the array.
     */
    public int bigDiff( int[] nums )
    {
        int small = nums[0]; //set to first value in array
        int large = nums[0];

        for( int i = 1 ; i < nums.length ; i++ ) //start at 1 as 0 already assigned to variables
        {
            small = Math.min( small, nums[i] );
            large = Math.max( large, nums[i] );
        }

        return large - small;
    }

    /**
     * Return the "centered" average of an array of ints, which we'll say is the mean average of the values, except ignoring the largest and smallest values in the array. If there are multiple copies of the smallest value, ignore just one copy, and likewise for the largest value. Use int division to produce the final average. You may assume that the array is length 3 or more.
     */
    public int centeredAverage( int[] nums )
    {
        int sum = nums[0];
        int smallest = nums[0];
        int largest = nums[0];

        for( int i = 1 ; i < nums.length ; i++ ) //start at 1 as nums[0] used in variable assignment
        {
            sum += nums[i];
            smallest = Math.min( smallest, nums[i] );
            largest = Math.max( largest, nums[i] );
        }

        //subtract small and largest, - 2 to remove small/large from division
        return ( sum - smallest - largest ) / ( nums.length - 2 );
    }

    /**
     * Return the sum of the numbers in the array, returning 0 for an empty array. Except the number 13 is very unlucky, so it does not count and numbers that come immediately after a 13 also do not count.
     */
    public int sum13( int[] nums )
    {
        int sum = 0;

        for( int i = 0 ; i < nums.length ; i++ )
            if( nums[i] == 13 )
                if( i + 1 < nums.length ) //if there is a value after 13
                    i++; //skip past it
                else
                    continue; //otherwise must be at end of array so leave loop
            else
                sum += nums[i]; //if not 13 add to running total

        return sum;
    }

    /**
     * Return the sum of the numbers in the array, except ignore sections of numbers starting with a 6 and extending to the next 7 (every 6 will be followed by at least one 7). Return 0 for no numbers.
     */
    public int sum67( int[] nums )
    {
        int sum = 0;

        for( int i = 0 ; i < nums.length ; i++ )
            if( nums[i] == 6 )
            {
                while( nums[i] != 7 ) //loop till i is 7, while loop will terminate and for loop i++ will move to index after 7
                    i++;
            }
            else
                sum += nums[i]; //add if either side of the 6 and 7

        return sum;
    }

    /**
     * Given an array of ints, return true if the array contains a 2 next to a 2 somewhere.
     */
    public boolean has22( int[] nums )
    {
        boolean hasTwo = false;

        for( int i = 0 ; i < nums.length - 1 ; i++ ) //set bound to check proceeding index at same time
            if( nums[i] == 2 && nums[ i + 1 ] == 2 )
            {
                hasTwo = true;
                break; //leave loop when found true to stop further unnecessary iterations
            }

        return hasTwo;
    }

    /**
     * Given an array of ints, return true if the array contains no 1's and no 3's.
     */
    public boolean lucky13( int[] nums )
    {
        boolean isUnlucky = true;

        for( int i = 0 ; i < nums.length ; i++ )
            if( nums[i] == 1 || nums[i] == 3 ) //as soon as a 1 or 3 is found...
            {
                isUnlucky = false; //flag false and break loop
                break;
            }

        return isUnlucky;
    }

    /**
     * Given an array of ints, return true if the sum of all the 2's in the array is exactly 8.
     */
    public boolean sum28( int[] nums )
    {
        int sum = 0;

        for( int i = 0 ; i < nums.length ; i++ )
            if( nums[i] == 2 )
                sum += 2; //could be += nums[i]

        return sum == 8;
    }

    /**
     * Given an array of ints, return true if the number of 1's is greater than the number of 4's
     */
    public boolean more14( int[] nums )
    {
        int oneCount = 0;
        int fourCount = 0;

        for( int i = 0 ; i < nums.length ; i++ )
            if( nums[i] == 1 )
                oneCount++;
            else if( nums[i] == 4 )
                fourCount++;

        return oneCount > fourCount;
    }

    /**
     * Given a number n, create and return a new int array of length n, containing the numbers 0, 1, 2, ... n-1. The given n may be 0, in which case just return a length 0 array. You do not need a separate if-statement for the length-0 case; the for-loop should naturally execute 0 times in that case, so it just works.
     */
    public int[] fizzArray( int n )
    {
        int[] fizz = new int[n];

        for( int i = 0 ; i < fizz.length ; i++ ) //fizz.length = n, loop will run n-1 times
            fizz[i] = i;

        return fizz;
    }

    /**
     * Given an array of ints, return true if every element is a 1 or a 4.
     */
    public boolean only14( int[] nums )
    {
        boolean is1or4 = true;

        for( int i= 0 ; i < nums.length ; i++ )
            if( nums[i] != 1 && nums[i] != 4 ) //&& becasue both must be false
            {
                is1or4 = false; //as soon as something not 1 or 4 found, flip boolean and break loop
                break;
            }

        return is1or4;
    }

    /**
     * Given a number n, create and return a new string array of length n, containing the strings "0", "1" "2" .. through n-1. N may be 0, in which case just return a length 0 array.
     */
    public String[] fizzArray2( int n )
    {
        String[] fizz = new String[n];

        for( int i = 0 ; i < fizz.length ; i++ ) //fizz.length = n, loop will run n-1 times
            fizz[i] = String.valueOf(i); //conver the int value of i to String

        return fizz;
    }

    /**
     * Given an array of ints, return true if it contains no 1's or it contains no 4's.
     */
    public boolean no14( int[] nums )
    {
        boolean hasOne = false;
        boolean hasFour = false;

        for( int i = 0 ; i < nums.length ; i++ )
            if( nums[i] == 1 ) //as soon as a 1 or 4 is found flip to true
                hasOne = true;
            else if( nums[i] == 4 )
                hasFour = true;

        return !( hasOne && hasFour ); //if both are true we want to return false, all other options are OK
    }

}
