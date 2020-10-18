/**
 * @author LogicallySpeakingLaura
 * @version 2020/10/17
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
        int small = nums[0], large = nums[0]; //set to first value in array

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
        int sum = nums[0], smallest = nums[0], largest = nums[0];

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
        int oneCount = 0, fourCount = 0;

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
        boolean hasOne = false, hasFour = false;

        for( int i = 0 ; i < nums.length ; i++ )
            if( nums[i] == 1 ) //as soon as a 1 or 4 is found flip to true
                hasOne = true;
            else if( nums[i] == 4 )
                hasFour = true;

        return !( hasOne && hasFour ); //if both are true we want to return false, all other options are OK
    }

    /**
     * We'll say that a value is "everywhere" in an array if for every pair of adjacent elements in the array, at least one of the pair is that value. Return true if the given value is everywhere in the array.
     */
    public boolean isEverywhere( int[] nums, int val )
    {
        boolean isThere = true;

        for( int i = 0 ; i < nums.length - 1 ; i++ )
            if( nums[i] != val && nums[ i + 1 ] != val ) //as soon as neither match set to false as no way to be true again
            {
                isThere = false;
                break; //exit to return, avoid unnecessary iterations
            }

        return isThere;
    }

    /**
     * Given an array of ints, return true if the array contains a 2 next to a 2 or a 4 next to a 4, but not both.
     */
    public boolean either24( int[] nums )
    {
        boolean has2 = false, has4 = false;

        for( int i = 0 ; i < nums.length - 1 ; i++ ) //set bound -1
            if( nums[i] == 2 && nums[ i + 1 ] == 2 ) //there are two 2
                has2 = true;
            else if( nums[i] == 4 && nums[ i + 1 ] == 4 ) //there are two 4
                has4 = true;

        return has2 != has4; //one boolean must be true but not the other, can't both be false or both true
    }

    /**
     * Given arrays nums1 and nums2 of the same length, for every element in nums1, consider the corresponding element in nums2 (at the same index). Return the count of the number of times that the two elements differ by 2 or less, but are not equal.
     */
    public int matchUp( int[] nums1, int[] nums2 )
    {
        int count = 0;

        for( int i = 0 ; i < nums1.length ; i++ )
                //checks difference,                check equality
            if( Math.abs( nums1[i] - nums2[i] ) <= 2 && nums1[i] != nums2[i] )
                count++;

        return count;
    }

    /**
     * Given an array of ints, return true if the array contains two 7's next to each other, or there are two 7's separated by one element, such as with {7, 1, 7}.
     */
    public boolean has77( int[] nums )
    {
        boolean has7 = false;

        for( int i = 0 ; i < nums.length ; i++ ) //right index is 7,                right of right index is 7
            if( nums[i] == 7 && ( ( i + 1 < nums.length && nums[ i + 1 ] == 7 ) || ( i + 2 < nums.length && nums[ i + 2 ] == 7 ) ) )
            {
                has7 = true;
                break; //break as soon as true, no need to check for more than 1 case
            }

        return has7;
    }

    /**
     * Given an array of ints, return true if there is a 1 in the array with a 2 somewhere later in the array.
     */
    public boolean has12( int[] nums )
    {
        boolean has2 = false;

        for( int i = 0 ; i < nums.length ; i++ )
            if( nums[i] == 1 ) //only do second loop if there is a 1, so have to use nested loop
                for( int j = nums.length - 1 ; j > i ; j-- ) //work backwards through array
                    if( nums[j] == 2 ) //if there is a 2 after the 1
                    {
                        has2 = true; //flip boolean and exit to return
                        break;
                    }

        return has2;
    }

    /**
     * Given an array of ints, return true if the array contains either 3 even or 3 odd values all next to each other.
     */
    public boolean modThree( int[] nums )
    {
        boolean isOddEven = false;

        for( int i = 0 ; i < nums.length - 2 ; i++ ) //set bound so not checking set less than 3
            if( nums[i] % 2 == nums[ i + 1 ] % 2 && nums[i] % 2 == nums[ i + 2 ] % 2 ) //mod2 gives odd or even, if they equal both are same
            {
                isOddEven = true; //as soon as case found flip boolean and exit to return
                break;
            }

        return isOddEven;
    }

    /**
     * Given an array of ints, return true if the value 3 appears in the array exactly 3 times, and no 3's are next to each other.
     */
    public boolean haveThree( int[] nums )
    {
        int count = 0;

        for( int i = 0 ; i < nums.length ; i++ )
            if( nums[i] == 3 )
            {
                count++;
                i++; //this skips right of i, so even if it equals 3, it's not added to the count and count won't equal 3
            }

        return count == 3;
    }

    /**
     * Given an array of ints, return true if every 2 that appears in the array is next to another 2.
     */
    public boolean twoTwo( int[] nums )
    {
        boolean has2 = true;

        for( int i = 0 ; i < nums.length ; i++ )
            if ( nums[i] == 2 ) //only check left and right if i is 2
                if ( ( i > 0 && nums[ i - 1 ] == 2 ) || ( i + 1 < nums.length && nums[ i + 1 ] == 2 ) )
                    //check left i must be at least 1 to check left, check right i ust be length - 1 to have a right
                    i++; //skip next index
                else
                {
                    has2 = false; //as soon as found false return false
                    break;
                }

        return has2;
    }

    /**
     * Return true if the group of N numbers at the start and end of the array are the same. For example, with {5, 6, 45, 99, 13, 5, 6}, the ends are the same for n=0 and n=2, and false for n=1 and n=3. You may assume that n is in the range 0..nums.length inclusive.
     */
    public boolean sameEnds( int[] nums, int len )
    {
        boolean nMatches = true;

        //questions is not asking if the numbers at the end going back equal the same as the front going forward
        //question asking if subarray of len starting at nums.length - len is the exact same as beginning of array to index n
        for( int i = 0, j = nums.length - len ; i < len ; i++, j++ )
            if( nums[i] != nums[j] )
            {
                nMatches = false; //as soon as there isn't a match flip boolean and return false
                break;
            }

        return nMatches;
    }

}