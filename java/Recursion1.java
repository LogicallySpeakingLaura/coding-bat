/**
 * @author LogicallySpeakingLaura
 * @version 2020/10/26
 * Basic recursion problems.
 * https://codingbat.com/java/Recursion-1
 */
public class Recursion1
{

    /**
     * Given n of 1 or more, return the factorial of n, which is n * (n-1) * (n-2) ... 1.
     */
    public int factorial( int n )
    {
        //base case is 1 as that can be returned as is
        return n == 1 ? 1 : n * factorial( n - 1 ); //otherwise decrement n towards base case
    }

    /**
     * We have a number of bunnies and each bunny has two big floppy ears. We want to compute the total number of ears across all the bunnies recursively (without loops or multiplication).
     */
    public int bunnyEars( int bunnies )
    {
        return bunnies == 0 ? 0 : 2 + bunnyEars( bunnies - 1 ); //+2 for each bunny
    }

    /**
     * The fibonacci sequence is a famous bit of mathematics, and it happens to have a recursive definition. The first two values in the sequence are 0 and 1 (essentially 2 base cases). Each subsequent value is the sum of the previous two values, so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on. Define a recursive fibonacci(n) method that returns the nth fibonacci number, with n=0 representing the start of the sequence.
     */
    public int fibonacci( int n )
    {
                                        //previous value + previous of previous
        return n == 0 ? 0 : n == 1 ? 1 : fibonacci( n - 1 ) + fibonacci( n - 2 );
    }

    /**
     * We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, ..) have the normal 2 ears. The even bunnies (2, 4, ..) we'll say have 3 ears, because they each have a raised foot. Recursively return the number of "ears" in the bunny line 1, 2, ... n (without loops or multiplication).
     */
    public int bunnyEars2( int bunnies )
    {
                                //check odd or even,    + 3 for odd,                        +2 for even
        return bunnies == 0 ? 0 : bunnies % 2 == 0 ? 3 + bunnyEars2( bunnies - 1 ) : 2 + bunnyEars2( bunnies - 1 );
    }

    /**
     * We have triangle made of blocks. The topmost row has 1 block, the next row down has 2 blocks, the next row has 3 blocks, and so on. Compute recursively (no loops or multiplication) the total number of blocks in such a triangle with the given number of rows.
     */
    public int triangle( int rows )
    {
        return rows == 0 ? 0 : rows + triangle( rows - 1 ); //current row + next row
    }

    /**
     * Given a non-negative int n, return the sum of its digits recursively (no loops).
     */
    public int sumDigits( int n )
    {
        //base case if leftmost digit
        return n < 10 ? n : ( n % 10 ) + sumDigits( n / 10 ); //right digit is added to sum of all
    }

    /**
     * Given a non-negative int n, return the count of the occurrences of 7 as a digit, so for example 717 yields 2. (no loops).
     */
    public int count7( int n )
    {
        //if there is a 7 add 1 to return count, if no 7 return count as is till base case reached
        return n == 0 ? 0 : n % 10 == 7 ? 1 + count7( n / 10 ) : count7( n / 10 );
    }

    /**
     * Given a non-negative int n, compute recursively (no loops) the count of the occurrences of 8 as a digit, except that an 8 with another 8 immediately to its left counts double, so 8818 yields 4.
     */
    public int count8( int n )
    {
                            //checks for double count,                single count,         no 8
        return n == 0 ? 0 : n % 100 == 88 ? 2 + count8( n / 10 ) : n % 10 == 8 ? 1 + count8( n / 10 ) : count8( n / 10 );
    }

    /**
     * Given base and n that are both 1 or more, compute recursively (no loops) the value of base to the n power, so powerN(3, 2) is 9 (3 squared).
     */
    public int powerN( int base, int n )
    {
        return n == 0 ? 1 : base * powerN( base, n - 1 ); //base to n power is base multiplying itself by base number of times
    }

    /**
     * Given a string, compute recursively (no loops) the number of lowercase 'x' chars in the string.
     */
    public int countX( String str )
    {
                                    //check first char,   then remove it by only checking from index 1 next function call
        return str.length() == 0 ? 0 : str.charAt(0) == 'x' ? 1 + countX( str.substring(1) ) : countX( str.substring(1) );
    }

    /**
     * Given a string, compute recursively (no loops) the number of times lowercase "hi" appears in the string.
     */
    public int countHi( String str )
    {
        //check bounds of str,  there is a "hi" so return +1 count and start str from 3rd char next recursion to skip 'i'
        return str.length() < 2 ? 0 : str.startsWith( "hi" ) ? 1 + countHi( str.substring(2) ) : countHi( str.substring(1) );
    }

    /**
     * Given a string, compute recursively (no loops) a new string where all the lowercase 'x' chars have been changed to 'y' chars.
     */
    public String changeXY( String str )
    {
                                        //replacing first char of 'x' with 'y' to str starting at index 1, else add char unchanged
        return str.length() == 0 ? str : str.charAt(0) == 'x'  ? "y" + changeXY( str.substring(1) ) : str.charAt(0) + changeXY( str.substring(1) );
    }

    /**
     * Given a string, compute recursively (no loops) a new string where all appearances of "pi" have been replaced by "3.14".
     */
    public String changePi( String str )
    {
                                                                    //if replacing start next recursion from index 2 so not checking 'i' from "pi"
        return str.length() == 0 ? str : str.startsWith( "pi" ) ? "3.14" + changePi( str.substring(2) ) : str.charAt(0) + changePi( str.substring(1) );
    }

    /**
     * Given a string, compute recursively a new string where all the 'x' chars have been removed.
     */
    public String noX( String str )
    {
        return str.length() == 0 ? str : str.charAt(0) == 'x' ? noX( str.substring(1) ) : str.charAt(0) + noX( str.substring(1) ); //only keep the checked char if it's not 'x'
    }

    /**
     * Given an array of ints, compute recursively if the array contains a 6. We'll use the convention of considering only the part of the array that begins at the given index. In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.
     */
    public boolean array6( int[] nums, int index )
    {
        //base is end of array as start index is 0, if match return true, else call function with incremented index
        return index >= nums.length ? false : nums[index] == 6 ? true : array6( nums, index + 1 );
    }

    /**
     * Given an array of ints, compute recursively the number of times that the value 11 appears in the array. We'll use the convention of considering only the part of the array that begins at the given index. In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.
     */
    public int array11( int[] nums, int index )
    {
                                                            //increment count regardless of match, but only increment count for a match
        return index >= nums.length ? 0 : nums[index] == 11 ? 1 + array11( nums, index + 1 ) : array11( nums, index + 1 );
    }

    /**
     * Given an array of ints, compute recursively if the array contains somewhere a value followed in the array by that value times 10. We'll use the convention of considering only the part of the array that begins at the given index. In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.
     */
    public boolean array220( int[] nums, int index )
    {
        //base case of a continuous pair being out of array bounds, check multiple of 10 condition and if no match call function with incremented index
        return index >= nums.length - 1  ? false : nums[index] * 10 == nums[ index + 1 ] || array220( nums, index + 1 );
    }

    /**
     * Given a string, compute recursively a new string where all the adjacent chars are now separated by a "*".
     */
    public String allStar( String str )
    {
        return str.length() <= 1 ? str : str.charAt(0) + "*" + allStar( str.substring(1) ); //base at <= 1 as don't want * at end of str
    }

    /**
     * Given a string, compute recursively a new string where identical chars that are adjacent in the original string are separated from each other by a "*".
     */
    public String pairStar( String str )
    {
                                            //if there's an adjacent pair add a star,                                           otherwise make no changes
        return str.length() <= 1 ? str : str.charAt(0) == str.charAt(1) ? str.charAt(0) + "*" + pairStar( str.substring(1) ) : str.charAt(0) + pairStar( str.substring(1) );
    }

    /**
     * Given a string, compute recursively a new string where all the lowercase 'x' chars have been moved to the end of the string.
     */
    public String endX( String str )
    {
                                        //if an 'x' add to end of next function call,           else add char as is
        return str.length() <= 1 ? str : str.charAt(0) == 'x' ? endX( str.substring(1) ) + 'x' : str.charAt(0) + endX( str.substring(1) );
    }

    /**
     * We'll say that a "pair" in a string is two instances of a char separated by a char. So "AxA" the A's make a pair. Pair's can overlap, so "AxAxA" contains 3 pairs -- 2 for A and 1 for x. Recursively compute the number of pairs in the given string.
     */
    public int countPairs( String str )
    {
        //stop at 2 as 0-1 doesn't make pair, compare chars and if match increase count and remove first char, else just remove first char
        return str.length() <= 2 ? 0 : str.charAt(0) == str.charAt(2) ? 1 + countPairs( str.substring(1) ) : countPairs( str.substring(1) );
    }

    /**
     * Count recursively the total number of "abc" and "aba" substrings that appear in the given string.
     */
    public int countAbc( String str )
    {
                                                                //start at 2 because if "aba" there may be overlap with next pair
        return str.length() <= 2 ? 0 : str.startsWith( "abc" ) || str.startsWith( "aba" ) ? 1 + countAbc( str.substring(2) ) : countAbc( str.substring(1) );
    }

    /**
     * Given a string, compute recursively (no loops) the number of "11" substrings in the string. The "11" substrings should not overlap.
     */
    public int count11( String str )
    {
                        //move completely past "11" to avoid overlap, so substring starting at 2
        return str.length() <= 1 ? 0 : str.startsWith( "11" ) ? 1 + count11( str.substring(2) ) : count11( str.substring(1) );
    }

    /**
     * Given a string, return recursively a "cleaned" string where adjacent chars that are the same have been reduced to a single char. So "yyzzza" yields "yza".
     */
    public String stringClean( String str )
    {
                                //adjacent chars are same so leave first one off else keep it, move up one at a time as there can be 3 in a row of the same
        return str.length() <= 1 ? str : str.charAt(0) == str.charAt(1) ? stringClean( str.substring(1) ) : str.charAt(0) + stringClean( str.substring(1) );
    }

    /**
     * Given a string, compute recursively the number of times lowercase "hi" appears in the string, however do not count "hi" that have an 'x' immedately before them.
     */
    public int countHi2( String str )
    {
                                        //skip past "xh", assume not "xhi" as can be "xhh", logically here there is no "x" before as previous comparison accounts for that
        return str.length() <= 1 ? 0 : str.startsWith( "xh" ) ? countHi2( str.substring(2) ) : str.startsWith( "hi" ) ? 1 + countHi2( str.substring(1) ): countHi2( str.substring(1) );
    }

    /**
     * Given a string that contains a single pair of parenthesis, compute recursively a new string made of only of the parenthesis and their contents, so "xyz(abc)123" yields "(abc)".
     */
    public String parenBit( String str )
    {
                //removes anything to left of open parenthesis,     removes anything to right of close parenthesis
        return str.charAt(0) != '(' ? parenBit( str.substring(1) ) : str.charAt( str.length() - 1 ) != ')' ? parenBit( str.substring( 0, str.length() - 1 ) ) : str; //one just parenthesis and contents left then it is returned
    }

    /**
     * Given a string, return true if it is a nesting of zero or more pairs of parenthesis, like "(())" or "((()))". Suggestion: check the first and last chars, and then recur on what's inside them.
     */
    public boolean nestParen( String str )
    {
        //if not left with an empty String then letters are breaking up parentheses so they aren't nested so return false at the end
        return str.equals( "" ) ? true : str.charAt(0) == '(' && str.charAt( str.length() - 1 ) == ')'  ? nestParen( str.substring( 1, str.length() - 1 ) ) : false;
                                        //check leftmost char for open and rightmost for close, both must be true else not nested, move indexes at both ends by 1
    }

    /**
     * Given a string and a non-empty substring sub, compute recursively the number of times that sub appears in the string, without the sub strings overlapping.
     */
    public int strCount( String str, String sub )
    {
        //sub can't be in str if it is bigger,   if sub starts at str index 0 increase count and move index to right of sub, else just jump right by one
        return str.length() < sub.length() ? 0 : str.startsWith(sub) ? 1 + strCount( str.substring( sub.length() ), sub ) : strCount( str.substring(1), sub );
    }

    /**
     * Given a string and a non-empty substring sub, compute recursively if at least n copies of sub appear in the string somewhere, possibly with overlapping. N will be non-negative.
     */
    public boolean strCopies( String str, String sub, int n )
    {
            //2 stopping cases both for true and false,                 if sub appears decrement n and move index,                      else just move index
        return n == 0 ? true : str.length() < sub.length() ? false : str.startsWith(sub) ? strCopies( str.substring(1), sub, n - 1 ) : strCopies( str.substring(1), sub, n );
    }

    /**
     * Given a string and a non-empty substring sub, compute recursively the largest substring which starts and ends with sub and return its length.
     */
    public int strDist( String str, String sub )
    {
                                                    //sub is at beginning and end of str so return current str length,                                 str doesn't start with sub so increment index,       otherwise remove last index to check end of str for sub
        return str.length() < sub.length() ? 0 : str.startsWith(sub) && str.startsWith( sub, str.length() - sub.length() ) ? str.length() : !str.startsWith(sub) ? strDist( str.substring(1), sub ) : strDist( str.substring( 0, str.length() - 1 ), sub );
    }

}