/**
 * @author LogicallySpeakingLaura
 * @version 2020/10/20
 * Medium warmup string/array loops.
 * https://codingbat.com/java/Warmup-2
 */
public class Warmup2
{
    /**
     * Given a string and a non-negative int n, return a larger string that is n copies of the original string.
     */
    public String stringTimes( String str, int n )
    {
        String returnStr = "";

        for( int i = 0 ; i < n ; i++ ) //set loop to run n times
            returnStr += str;

        return returnStr;
    }

    /**
     * Given a string and a non-negative int n, we'll say that the front of the string is the first 3 chars, or whatever is there if the string is less than length 3. Return n copies of the front;
     */
    public String frontTimes( String str, int n )
    {
        String returnStr = "";

        for( int i = 0 ; i < n ; i++ )
            if( str.length() > 3 )
                returnStr += str.substring( 0, 3 );
            else                    //check length first, if less than 3 add as is
                returnStr += str;

        return returnStr;
    }

    /**
     * Count the number of "xx" in the given string. We'll say that overlapping is allowed, so "xxx" contains 2 "xx".
     */
    int countXX( String str )
    {
        int xCount = 0;

        for( int i = 0 ; i < str.length() - 1 ; i++ ) //i++ as we want to check for overlap
            if( str.startsWith( "xx", i) )
                xCount++;

        return xCount;
    }

    /**
     * Given a string, return true if the first instance of "x" in the string is immediately followed by another "x".
     */
    boolean doubleX( String str )
    {
        return str.indexOf( "x" ) < str.length() - 1 && str.charAt( str.indexOf( "x" ) + 1 ) == 'x';
    }

    /**
     * Given a string, return a new string made of every other char starting with the first, so "Hello" yields "Hlo".
     */
    public String stringBits( String str )
    {
        String returnStr = "";

        for( int i = 0 ; i < str.length() ; i += 2 ) //+= 2 to skip chars
            returnStr += str.charAt(i);

        return returnStr;
    }

    /**
     * Given a non-empty string like "Code" return a string like "CCoCodCode".
     */
    public String stringSplosion( String str )
    {
        String returnStr = "";

        for( int i = 0 ; i < str.length() ; i++ )
            returnStr += str.substring( 0, i + 1 ); //pattern is 1, 12, 123, 1234, so compound on another char each loop

        return returnStr;
    }

    /**
     * Given a string, return the count of the number of times that a substring length 2 appears in the string and also as the last 2 chars of the string, so "hixxxhi" yields 1 (we won't count the end substring).
     */
    public int last2( String str )
    {
        int count = 0;

        if( str.length() >= 2 )
            for( int i = 0 ; i < str.length() - 2 ; i++ ) //pattern is does the last 2 characters repeat anywhere else in str
                if( str.substring( i, i +2 ).equals( str.substring( str.length() - 2 ) ) )
                    count++;

        return count;
    }

    /**
     * Given an array of ints, return the number of 9's in the array.
     */
    public int arrayCount9( int[] nums )
    {
        int count = 0;

        for( int n : nums ) //check every element in array
            if( n == 9 )
                count++;

        return count;
    }

    /**
     * Given an array of ints, return true if one of the first 4 elements in the array is a 9. The array length may be less than 4.
     */
    public boolean arrayFront9( int[] nums )
    {
        boolean first4 = false;
        int arrayEnd = nums.length > 4 ? 4 : nums.length; //this value needs a var as some arrays will be less than 4, so i < nums.length won't work

        for( int i = 0 ; i < arrayEnd ; i++ ) //so runs up to 4, or if array is less, end of array
            if( nums[i] == 9 )
            {
                first4 = true;
                break; //exit loop as soon as condition met to return as true
            }

        return first4;
    }

    /**
     * Given an array of ints, return true if the sequence of numbers 1, 2, 3 appears in the array somewhere.
     */
    public boolean array123( int[] nums )
    {
        boolean numsPresent = false;

        for( int i = 0 ; i < nums.length - 2 ; i++ ) //length-2 so loop does not go out of bounds
            if( nums[i] == 1 && nums[ i + 1 ] == 2 && nums[ i + 2 ] == 3 )
            {
                numsPresent = true;
                break; //exit loop as soon as condition met to return as true
            }

        return numsPresent;
    }

    /**
     * Given 2 strings, a and b, return the number of the positions where they contain the same length 2 substring. So "xxcaazz" and "xxbaaz" yields 3, since the "xx", "aa", and "az" substrings appear in the same place in both strings.
     */
    public int stringMatch( String a, String b )
    {
        int count = 0;

        for( int i = 0 ; i < Math.min( a.length(), b.length() ) - 1 ; i++ ) //have to run loop against smaller str otherwise will go out of bounds
            if( a.substring( i, i + 2 ).equals( b.substring( i, i + 2 ) ) )
                count++;

        return count;
    }

    /**
     * Given a string, return a version where all the "x" have been removed. Except an "x" at the very start or end should not be removed.
     */
    public String stringX( String str )
    {
        String returnStr = "";

        for ( int i = 0 ; i < str.length() ; i++ )
            if ( !( i > 0 && i < str.length() - 1 && str.charAt(i) == 'x' ) ) //make sure i isn't first or last char when comparing
                returnStr += str.charAt(i);

        return returnStr;
    }

    /**
     * Given a string, return a string made of the chars at indexes 0,1, 4,5, 8,9.
     */
    public String altPairs( String str )
    {
        String returnStr = "";

        for( int i = 0 ; i < str.length() ; i += 4 ) //adding at every 4th index
        {
            returnStr += str.charAt(i);

            if( i + 1 < str.length() ) //check not at end of String before adding second char
                returnStr += str.charAt( i + 1 );
        }

        return returnStr;
    }

    /**
     * Suppose the string "yak" is unlucky. Given a string, return a version where all the "yak" are removed, but the "a" can be any char. The "yak" strings will not overlap.
     */
    public String stringYak( String str )
    {
        String result = "";

        for( int i = 0 ; i < str.length() ; i ++ ) //remember to check for length
            if( i + 2 < str.length() && str.charAt(i) == 'y' && str.charAt( i + 2 ) == 'k' )
                i += 2; //if 'yak' is there, jump loop past it and check again
            else            //if there's no yak, count the current index
                result += str.charAt(i);

        return result;
    }

    /**
     * Given an array of ints, return the number of times that two 6's are next to each other in the array. Also count instances where the second "6" is actually a 7.
     */
    public int array667( int[] nums )
    {
        int count = 0;

        for( int i = 0 ; i < nums.length - 1 ; i++ ) //make sure to not go out of bounds, length - 1
            if( nums[i] == 6 && ( nums[ i + 1 ] == 6 || nums[ i + 1 ] == 7 ) )
                count++;

        return count;
    }

    /**
     * Given an array of ints, we'll say that a triple is a value appearing 3 times in a row in the array. Return true if the array does not contain any triples.
     */
    public boolean noTriples( int[] nums )
    {
        boolean triple = true; //assuming true triples

        for( int i = 0 ; i < nums.length - 2 ; i++ ) //bound check, length - 2
            if( nums[i] == nums[ i + 1 ] && nums[ i + 1 ] == nums[ i + 2 ] )
            {
                triple = false; //as soon as a triple is found, return false
                break;
            }

        return triple;
    }

    /**
     * Given an array of ints, return true if it contains a 2, 7, 1 pattern: a value, followed by the value plus 5, followed by the value minus 1. Additionally the 271 counts even if the "1" differs by 2 or less from the correct value.
     */
    public boolean has271( int[] nums )
    {
        boolean pattern = false;

        for( int i = 0 ; i < nums.length - 2 ; i++ )
            if( nums[ i + 1 ] == nums[i] + 5 && Math.abs( nums[ i + 2 ] - ( nums[i] - 1 ) ) <= 2 )
            {                                   //checking that third value of value - 1 differs by 2
                pattern = true; //as soon as pattern is found, return false
                break;
            }

        return pattern;
    }

}
