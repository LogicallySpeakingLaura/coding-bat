/**
 * @author LogicallySpeakingLaura
 * @version 2020/10/20
 * Harder array problems -- 2 loops, more complex logic.
 * https://codingbat.com/java/Array-3
 */
public class Array3
{

    /**
     * Consider the leftmost and righmost appearances of some value in an array. We'll say that the "span" is the number of elements between the two inclusive. A single value has a span of 1. Returns the largest span found in the given array. (Efficiency is not a priority.)
     */
    public int maxSpan( int[] nums )
    {
        int span = nums.length > 0 ? 1 : 0; //if array not empty the max span is 1, otherwise return 0

        for( int i = 0 ; i < nums.length ; i++ )
            for( int j = nums.length - 1 ; j > i ; j-- ) //move back till index i, this will find latest/largest first
                if( nums[i] == nums[j] ) //if index value at j is same as i, that's the max span for that value
                {
                    span = Math.max( span, 1 + j - i ); //span = larger of previous span and span of current value (+1 because of indexing)
                    break; //break inner loop so outer loop can move to next value
                }

        return span;
    }

    /**
     * Return an array that contains exactly the same numbers as the given array, but rearranged so that every 3 is immediately followed by a 4. Do not move the 3's, but every other number may move. The array contains the same number of 3's and 4's, every 3 has a number after it that is not a 3, and a 3 appears in the array before any 4.
     */
    public int[] fix34( int[] nums )
    {
        for ( int i = 0 ; i < nums.length ; i++ )
            if ( nums[i] == 3 )
            {
                int temp = nums[ i + 1 ]; //the value right of 3 assigned to var independent of inner loop
                nums[ i + 1 ] = 4; //right of 3 is now 4

                for ( int j = i + 2 ; j < nums.length ; j++ ) //j = i+2 as i=3 and i+1=4, want to find next instance of 4
                    if ( nums[j] == 4 )
                        nums[j] = temp; //set j to what used to be at i+1, so the 4 and non 4 value have switched indexes
            }

        return nums;
    }

    /**
     * (This is a slightly harder version of the fix34 problem.) Return an array that contains exactly the same numbers as the given array, but rearranged so that every 4 is immediately followed by a 5. Do not move the 4's, but every other number may move. The array contains the same number of 4's and 5's, and every 4 has a number after it that is not a 4. In this version, 5's may appear anywhere in the original array.
     */
    public int[] fix45( int[] nums )
    {
        for( int i = 0 ; i < nums.length - 1 ; i++) //loop to find instance of 4
            if( nums[i] == 4 && nums[ i + 1 ] != 5 ) //4 found but right of 4 is not 5
                for( int j = 0 ; j < nums.length ; j++ ) //loop to find instance of 5
                {
                    if( nums[j] == 5 && j == 0 ) //if 5 is at beginning of array
                    {
                        nums[0] = nums[ i + 1 ]; //make beginning of array equal current value after 4
                        nums[ i + 1 ] = 5; //set right of 4 to 5
                    }

                    if( nums[j] == 5 && nums[ j - 1 ]!= 4 ) //if 5 and left of 5 does not equal 4 after beginning of array
                    {
                        nums[j] = nums[ i + 1 ]; //make current index holding 5 equal current value after 4
                        nums[ i + 1 ] = 5; //set right of 4 to 5
                    }
                }

        return nums;
    }

    /**
     * Given a non-empty array, return true if there is a place to split the array so that the sum of the numbers on one side is equal to the sum of the numbers on the other side.
     */
    public boolean canBalance(int[] nums)
    {
        boolean canBalance = false;

        for( int i = 0 ; i < nums.length ; i++ )
        {
            int leftSum = 0, rightSum = 0;

            for( int j = 0 ; j < i ; j++ ) //loop through first half, do not include value at i
                leftSum += nums[j];

            for( int k = nums.length - 1 ; k >= i ; k-- ) //reverse loop through second half, include vaue at i
                rightSum += nums[k];

            if( leftSum == rightSum ) //compare values, if they are same there is balance
            {
                canBalance = true;
                break; //break when balance found to avoid unnecessary iterations
            }
        }

        return canBalance;
    }

    public boolean linearIn( int[] outer, int[] inner )
    {
        int numsFound = 0;

        for( int i = 0, j = 0 ; i < outer.length && j < inner.length ; i++ ) //i hold index for outer, j for inner
            if( outer[i] == inner[j] ) //if both match
            {
                numsFound++; //increment count
                j++; //move along inner array, as arrays sorted no need to reset i back to 0
            }

        return numsFound == inner.length; //only complete match if the number found equals length of array
    }

    /**
     * Given n>=0, create an array length n*n with the following pattern, shown here for n=3 : {0, 0, 1,    0, 2, 1,    3, 2, 1} (spaces added to show the 3 groups).
     */
    public int[] squareUp( int n )
    {
        int[] squared = new int[ n * n ];

        if( n != 0 ) //no need to fill empty array
            for( int i = n - 1 ; i < squared.length ; i += n ) //start at end of block, run for as long as array is, but jump one block at a time
                for( int j = i ; j >= i - ( i / n ) ; j-- ) //create fill pattern, where to stop and fill with 0
                    squared[j] = i - j + 1; //fill with difference + 1 because of indexing

        return squared;
    }

    /**
     * Given n>=0, create an array with the pattern {1,    1, 2,    1, 2, 3,   ... 1, 2, 3 .. n} (spaces added to show the grouping). Note that the length of the array will be 1 + 2 + 3 ... + n, which is known to sum to exactly n*(n + 1)/2.
     */
    public int[] seriesUp( int n )
    {
        int[] series = new int[ n * ( n + 1 ) / 2 ];

        for( int i = 0, j = 1 ; j <= n ; ++j ) //i is new array index, j keeps track of n value, run n times but increment then iterate
            for ( int k = 1 ; k <= j ; ++k ) //k is value for index, run j times but increment then iterate
                series[ i++ ] = k; //new array places value then moves to right

        return series;
    }

    /**
     * We'll say that a "mirror" section in an array is a group of contiguous elements such that somewhere in the array, the same group appears in reverse order. For example, the largest mirror section in {1, 2, 3, 8, 9, 3, 2, 1} is length 3 (the {1, 2, 3} part). Return the size of the largest mirror section found in the given array.
     */
    public int maxMirror( int[] nums )
    {
        int max = 0; //count of mirrored values for biggest section

        for( int i = 0, j ; i < nums.length ; i++ )
        {
            j = 0; //tracks mirror count/position, assign here as need to reset each outer loop

            //loop to reverse, put bound on count, can't reverse if already at the end of the array
            for( int k = nums.length - 1 ; k >= 0 && i + j < nums.length ; k-- )
                if( nums[ i + j ] == nums[k] )
                    j++; //increment mirror/count position if there's a match
                else if( j > 0 ) //only reassign max if there is a match
                {
                    max = Math.max( max, j );
                    j = 0; //reset for next iteration of inner loop
                }

            max = Math.max( max, j ); //check for max reassign here as there is chance it did not happen in inner loop
        }

        return max;
    }

    /**
     * Say that a "clump" in an array is a series of 2 or more adjacent elements of the same value. Return the number of clumps in the given array.
     */
    public int countClumps( int[] nums )
    {
        int count = 0;

        for( int i = 0 ; i < nums.length - 1 ; i++ ) //set bound here so can check right of index
        {
            if( nums[i] == nums[ i + 1 ] ) //if right of i matches that is one clump
                count++;

            while ( i + 1 < nums.length && nums[i] == nums[ i + 1 ] ) //find end of current clump so next for iteration starts at right of end
                i++;
        }

        return count;
    }

}