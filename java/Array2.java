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

        for( int n : nums )
            if( n % 2 == 0 ) //even%2 == 0, odd%2 == 1
                count++;

        return count;
    }

    /**
     * Given an array length 1 or more of ints, return the difference between the largest and smallest values in the array.
     */
    public int bigDiff( int[] nums )
    {
        int small = nums[0], large = nums[0]; //set to first value in array

        for( int n : nums )
        {
            small = Math.min( small, n );
            large = Math.max( large, n );
        }

        return large - small;
    }

    /**
     * Return the "centered" average of an array of ints, which we'll say is the mean average of the values, except ignoring the largest and smallest values in the array. If there are multiple copies of the smallest value, ignore just one copy, and likewise for the largest value. Use int division to produce the final average. You may assume that the array is length 3 or more.
     */
    public int centeredAverage( int[] nums )
    {
        int sum = 0, smallest = nums[0], largest = nums[0];

        for( int n : nums )
        {
            sum += n;
            smallest = Math.min( smallest, n );
            largest = Math.max( largest, n );
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
                    break; //otherwise must be at end of array so leave loop
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

        for( int n : nums )
            if( n == 1 || n == 3 ) //as soon as a 1 or 3 is found...
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

        for( int n : nums )
            if( n == 2 )
                sum += 2; //could be += n, as long as 2 added to running total

        return sum == 8;
    }

    /**
     * Given an array of ints, return true if the number of 1's is greater than the number of 4's
     */
    public boolean more14( int[] nums )
    {
        int oneCount = 0, fourCount = 0;

        for( int n : nums )
            if( n == 1 )
                oneCount++;
            else if( n == 4 )
                fourCount++;

        return oneCount > fourCount; //will return true if there are more 1's
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

        for( int n : nums )
            if( n != 1 && n != 4 ) //&& because both must be false
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

        for( int n : nums )
            if( n == 1 ) //as soon as a 1 or 4 is found flip to true
                hasOne = true;
            else if( n == 4 )
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

    /**
     * Return true if the array contains, somewhere, three increasing adjacent numbers like .... 4, 5, 6, ... or 23, 24, 25.
     */
    public boolean tripleUp( int[] nums )
    {
        boolean hasUp = false;

        for( int i = 0 ; i < nums.length - 2 ; i++ )
            if( nums[ i + 1 ] == nums[i] + 1 && nums[ i + 2 ] == nums[i] + 2 ) //right == i++, right + 1 == i += 2
            {
                hasUp = true; //one pattern found return true
                break;
            }

        return hasUp;
    }

    /**
     * Given start and end numbers, return a new array containing the sequence of integers from start up to but not including end, so start=5 and end=10 yields {5, 6, 7, 8, 9}. The end number will be greater or equal to the start number.
     */
    public int[] fizzArray3( int start, int end )
    {
        int[] fizz = new int[ end - start ]; //length of new array is difference between start and end

        for( int i = 0, j = start ; j < end ; i++, j++ ) //i is index of new array, j is value of start, run end - start times
            fizz[i] = j;

        return fizz;
    }

    /**
     * Return an array that is "left shifted" by one -- so {6, 2, 5, 3} returns {2, 5, 3, 6}. You may modify and return the given array, or return a new array.
     */
    public int[] shiftLeft( int[] nums )
    {
        if( nums.length > 0 ) //make sure array not empty before switching index values
        {
            int temp = nums[0]; //store first index value before overriden
            for( int i = 0 ; i < nums.length - 1 ; i++ )
                nums[i] = nums[ i + 1 ]; //shifting of values

            nums[ nums.length - 1 ] = temp; //reinsert original first index value at end
        }

        return nums;
    }

    /**
     * For each multiple of 10 in the given array, change all the values following it to be that multiple of 10, until encountering another multiple of 10. So {2, 10, 3, 4, 20, 5} yields {2, 10, 10, 10, 20, 20}.
     */
    public int[] tenRun( int[] nums )
    {
        for( int i = 0 ; i < nums.length - 1 ; i++ ) //set bound length - 1
            if( nums[i] % 10 == 0 && nums[ i + 1 ] % 10 != 0 ) // %10 == 0 is a multiple of 10, if i+1 is not set i+1 to i
                nums[ i + 1 ] = nums[i]; //if i+1 already a multiple loop iterates and that is the new multiple value

        return nums;
    }

    /**
     * Given a non-empty array of ints, return a new array containing the elements from the original array that come before the first 4 in the original array. The original array will contain at least one 4.
     */
    public int[] pre4( int[] nums )
    {
        for( int i = 0 ; i < nums.length ; i++ )
            if( nums[i] == 4 )
            {
                int[] before = new int[i]; //one 4 found create new array of length equal to 4 value index

                for( int j = 0 ; j < i ; j++ )
                    before[j] = nums[j]; //nexted loop fills array from nums[0] to nums[ index of 4 ] exclusive

                nums = before; //override original array with new one then break to return
                break;
            }

        return nums;
    }

    /**
     * Given a non-empty array of ints, return a new array containing the elements from the original array that come after the last 4 in the original array. The original array will contain at least one 4.
     */
    public int[] post4( int[] nums )
    {
        for( int i = nums.length - 1 ; i >= 0 ; i-- ) //start at end and move back, so first 4 found is last in array
            if( nums[i] == 4 )
            {
                int[] after = new int[ nums.length - i - 1 ]; //new length will be original length - index where 4 found

                for( int j = i + 1, ai = 0 ; ai < after.length ; j++, ai++ ) //separate counters, one for new array, other for moving through original
                    after[ai] = nums[j];

                nums = after; //override old array and return
                break;
            }

        return nums;
    }

    /**
     * We'll say that an element in an array is "alone" if there are values before and after it, and those values are different from it. Return a version of the given array where every instance of the given value which is alone is replaced by whichever value to its left or right is larger.
     */
    public int[] notAlone( int[] nums, int val )
    {
        for( int i = 1 ; i < nums.length - 1 ; i++ ) //not checking first and last index as those don't count as alone
            if( nums[i] == val && nums[i] != nums[ i - 1 ] && nums[i] != nums[ i + 1 ] )
                nums[i] = Math.max( nums[ i - 1 ], nums[ i + 1 ] ); //replace current alone value with larger of neighbours

        return nums;
    }

    /**
     * Return an array that contains the exact same numbers as the given array, but rearranged so that all the zeros are grouped at the start of the array. The order of the non-zero numbers does not matter. So {1, 0, 0, 1} becomes {0 ,0, 1, 1}. You may modify and return the given array or make a new array.
     */
    public int[] zeroFront( int[] nums )
    {
        for( int i = 0, j = 0 ; i < nums.length ; i++) //2 counts, one for array index and one for zero count, only i always increments
            if( nums[i] == 0 )
            {
                nums[i] = nums[j]; //current index value at current zero index value
                nums[j++] = 0; //value at zero count index now equals 0, zero count only increments once its current index equals zero
            }

        return nums;
    }

    /**
     * Return a version of the given array where all the 10's have been removed. The remaining elements should shift left towards the start of the array as needed, and the empty spaces a the end of the array should be 0. So {1, 10, 10, 2} yields {1, 2, 0, 0}. You may modify and return the given array or make a new array.
     */
    public int[] withoutTen( int[] nums )
    {
        int[] without = new int[nums.length];

        for( int i = 0, j = 0 ; i < nums.length ; i++ ) //2 counts, one for nums, one for without, only nums always increments
            if( nums[i] != 10 )
                without[j++] = nums[i]; //fill without with non10 value from nums, increment without index

        return without; //rest of array will auto be zero upon return
    }

    /**
     * Return a version of the given array where each zero value in the array is replaced by the largest odd value to the right of the zero in the array. If there is no odd value to the right of the zero, leave the zero as a zero.
     */
    public int[] zeroMax( int[] nums )
    {
        for( int i = nums.length - 1, max = 0 ; i >= 0 ; i-- ) //start at end and work back, max hold largest odd value
        {
            if( nums[i] % 2 != 0 ) //if it is an odd number it is not 0, as max assigned 0 that's how 0 remains
                max = Math.max( max, nums[i] ); //set new max number

            if( nums[i] == 0 )
                nums[i] = max; //set to max odd number or 0 if no odd number
        }

        return nums;
    }

    /**
     * Return an array that contains the exact same numbers as the given array, but rearranged so that all the even numbers come before all the odd numbers. Other than that, the numbers can be in any order. You may modify and return the given array, or make a new array.
     */
    public int[] evenOdd( int[] nums )
    {
        int[] evenFirst = new int[nums.length];

        //3 counts: array index, event index, odd index, odd and even only change once used not every loop
        for( int i = 0, j = 0, k = nums.length - 1 ; i < nums.length ; i++ )
            if( nums[i] % 2 == 0 ) //value is even
                evenFirst[j++] = nums[i]; //placed towards front of array and increment index
            else
                evenFirst[k--] = nums[i]; //value odd, place towards back and increment index

        return evenFirst;
    }

    /**
     * This is slightly more difficult version of the famous FizzBuzz problem which is sometimes given as a first problem for job interviews. (See also: FizzBuzz Code.) Consider the series of numbers beginning at start and running up to but not including end, so for example start=1 and end=5 gives the series 1, 2, 3, 4. Return a new String[] array containing the string form of these numbers, except for multiples of 3, use "Fizz" instead of the number, for multiples of 5 use "Buzz", and for multiples of both 3 and 5 use "FizzBuzz".
     */
    public String[] fizzBuzz( int start, int end )
    {
        String[] fizz = new String[ end - start ]; //array length needs to be difference of start and end

        for( int i = 0 ; i < fizz.length ; i++, start++ ) //increment start as well to get next value up to and excluding end
            if( start % 3 == 0 && start % 5 == 0 ) //both multiple
                fizz[i] = "FizzBuzz";
            else if( start % 3 == 0 ) //only 3 multiple
                fizz[i] = "Fizz";
            else if( start % 5 == 0 ) //only 5 multiple
                fizz[i] = "Buzz";
            else
                fizz[i] = String.valueOf(start); //no multiple, convert int to String

        return fizz;
    }

}