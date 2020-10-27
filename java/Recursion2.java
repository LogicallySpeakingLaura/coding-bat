/**
 * @author LogicallySpeakingLaura
 * @version 2020/10/26
 * Harder recursion problems. Currently, these are all recursive backtracking problems with arrays.
 * https://codingbat.com/java/Recursion-2
 */
public class Recursion2
{

    /**
     * Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target? This is a classic backtracking recursion problem. Once you understand the recursive backtracking strategy in this problem, you can use the same pattern for many problems to search a space of choices. Rather than looking at the whole array, our convention is to consider the part of the array starting at index start and continuing to the end of the array. The caller can specify the whole array simply by passing start as 0. No loops are needed -- the recursive calls progress down the array.
     */
    public boolean groupSum( int start, int[] nums, int target )
    {
        return start >= nums.length ? target == 0 :
                groupSum( start + 1, nums, target - nums[start] ) || groupSum( start + 1, nums, target ) ? true : false;
    }

    /**
     * Given an array of ints, is it possible to choose a group of some of the ints, beginning at the start index, such that the group sums to the given target? However, with the additional constraint that all 6's must be chosen. (No loops needed.)
     */
    public boolean groupSum6( int start, int[] nums, int target )
    {
        return start >= nums.length ? target == 0 : //first call nums[start] == 6
                groupSum6( start + 1, nums, target - nums[start] ) || ( nums[start] != 6 && groupSum6( start + 1, nums, target ) ) ? true : false;
    }

    /**
     * Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target with this additional constraint: If a value in the array is chosen to be in the group, the value immediately following it in the array must not be chosen. (No loops needed.)
     */
    public boolean groupNoAdj( int start, int[] nums, int target )
    {
        return start >= nums.length ? target == 0 : //two option of +1 and +2 allow for alternating through odd indexes and skipping even and vice versa
                groupNoAdj( start + 2, nums, target - nums[start] ) || groupNoAdj( start + 1, nums, target ) ? true : false;
    }

    /**
     * Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target with these additional constraints: all multiples of 5 in the array must be included in the group. If the value immediately following a multiple of 5 is 1, it must not be chosen. (No loops needed.)
     */
    public boolean groupSum5( int start, int[] nums, int target )
    {
        if( start >= nums.length ) //base case
        {
            return target == 0;
        }
        else if( nums[start] % 5 == 0 ) //element is a multiple of 5
        {
            if( start + 1 < nums.length && nums[ start + 1 ] == 1 ) //right of element is 1
            {
                return groupSum5( start + 2, nums, target - nums[start] ); //so skip that element and start at right of right element
            }

            return groupSum5( start + 1, nums, target - nums[start] ); //if right of start is not 1, include it
        }

        return groupSum5( start + 1, nums, target - nums[start] ) || groupSum5( start + 1, nums, target );
    }

    /**
     * Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target, with this additional constraint: if there are numbers in the array that are adjacent and the identical value, they must either all be chosen, or none of them chosen. For example, with the array {1, 2, 2, 2, 5, 2}, either all three 2's in the middle must be chosen or not, all as a group. (one loop can be used to find the extent of the identical values).
     */
    public boolean groupSumClump( int start, int[] nums, int target )
    {
        if( start >= nums.length ) //base case
            return target == 0;

        int count = 1, sum = nums[start]; //count starts at 1 as value of start is first count

        for( int i = start + 1 ; i < nums.length ; i++ ) //begin at index to right of start as start already counted
            if( nums[start] == nums[i] )
            {
                sum += nums[i]; //compound element value onto sum
                count++; //increment count
            }

        return groupSumClump( start + count, nums, target - sum ) || groupSumClump( start + count, nums, target );
    }

    /**
     * Given an array of ints, is it possible to divide the ints into two groups, so that the sums of the two groups are the same. Every int must be in one group or the other. Write a recursive helper method that takes whatever arguments you like, and make the initial call to your recursive helper from splitArray(). (No loops needed.)
     */
    public boolean splitArray( int[] nums )
    {
        return checkSums( nums, 0, 0, 0 ); //3 base cases valued at 0
    }
    public boolean checkSums( int[] nums, int start, int front, int back )
    {
        return start >= nums.length ? front == back : //first condition  moves forward through array, second moves backwards
                checkSums( nums, start + 1, front + nums[start], back ) || checkSums( nums, start + 1, front, back + nums[start] );
    }

    /**
     * Given an array of ints, is it possible to divide the ints into two groups, so that the sum of one group is a multiple of 10, and the sum of the other group is odd. Every int must be in one group or the other. Write a recursive helper method that takes whatever arguments you like, and make the initial call to your recursive helper from splitOdd10(). (No loops needed.)
     */
    public boolean splitOdd10( int[] nums )
    {
        return checkGroups( nums, 0, 0, 0 ); //3 base cases valued at 0
    }
    public boolean checkGroups( int[] nums, int start, int a, int b )
    {
        return start >= nums.length ? a % 10 == 0 && b % 2 == 1  ||  a % 2 == 1 && b % 10 == 0 : //%10 checks for multiple of 10, %2 checks that sum is odd
                checkGroups( nums, start + 1, a + nums[start], b ) || checkGroups( nums, start + 1, a, b + nums[start] );
    }

    /**
     * Given an array of ints, is it possible to divide the ints into two groups, so that the sum of the two groups is the same, with these constraints: all the values that are multiple of 5 must be in one group, and all the values that are a multiple of 3 (and not a multiple of 5) must be in the other. (No loops needed.)
     */
    public boolean split53( int[] nums )
    {
        return checkMultiples( nums, 0, 0, 0 ); //3 base cases valued at 0
    }
    public boolean checkMultiples( int[] nums, int start, int a, int b )
    {
        if( start >= nums.length )
            return a == b; //sums are split into multiples and equal at base case
        else if( nums[start] % 5 == 0 ) //multiple of 5 added to sum for group a
            return checkMultiples( nums, start + 1, a + nums[start], b );
        else if( nums[start] % 3 == 0 ) //multiple of 3 added to sum for group b
            return checkMultiples( nums, start + 1, a, b + nums[start] );

        return checkMultiples( nums, start + 1, a + nums[start], b ) || checkMultiples( nums, start + 1, a, b + nums[start] );
    }
    
}
