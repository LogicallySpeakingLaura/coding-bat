/**
 * @author LogicallySpeakingLaura
 * @version 2020/10/18
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

}