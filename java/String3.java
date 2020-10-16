/**
 * @author LogicallySpeakingLaura
 * @version 2020/10/16
 * Harder String problems -- 2 loops.
 * https://codingbat.com/java/String-3
 */
public class String3
{

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count, but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic letter immediately following it.
     */
    public int countYZ( String str )
    {
        int count = 0;
        str = str.toLowerCase(); //as Y or Z can count change everything to lower case so they aren't skipped

        if( str.endsWith("y") || str.endsWith("z") ) //checks very last char of str
            count++;

        for( int i = 0 ; i < str.length() - 1 ; i++ ) //length - 1 as last char already checked in above if stmt
            if( ( str.charAt(i) == 'y' || str.charAt(i) == 'z' ) && !( Character.isLetter( str.charAt( i + 1 ) ) ) )
                count++;                                             //i + 1 to make sure following char is whitespace

        return count;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have been removed (not case sensitive). You may assume that the remove string is length 1 or more. Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     */
    public String withoutString( String base, String remove )
    {
        String str = "";

        for( int i = 0 ; i < base.length() ; i++ )
            //check that sum of index lengths doesn't go out of bound for the base
            if( i + remove.length() - 1 < base.length() && base.toLowerCase().startsWith( remove.toLowerCase(), i ) )
                i += remove.length() - 1; //if there's a match skip to next index after last char of remove String
            else
                str += base.charAt(i); //only add char if not part of remove String

        return str;
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal to the number of appearances of "not" anywhere in the string (case sensitive).
     */
    public boolean equalIsNot( String str )
    {
        int is = 0;
        int not = 0;

        for( int i = 0 ; i < str.length() ; i++ )
            if( str.startsWith( "is", i ) && i + 1 < str.length() ) //check length, need to check char after i
            {                                                              //out of bounds if i on last index and
                is++;
                i++;    //if condition met want to jump to after substring, use one less than jump as for loop increments one as well
            }
            else if( str.startsWith( "not", i ) && i + 2 < str.length() )
            {
                not++;
                i += 2; //don't have to increment index but makes code more efficient, otherwise iterating through ot, o etc...
            }

        return is == not;
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right. Return true if all the g's in the given string are happy.
     */
    public boolean gHappy( String str )
    {
        boolean isHappy = true;

        for( int i = 0 ; i < str.length() ; i++ )
            if( str.charAt(i) == 'g' )
                if( i > 0 && str.charAt( i - 1 ) == 'g' ) //checks left char is g
                    isHappy = true;
                else if( i > str.length() - 1 && str.charAt( i + 1 ) == 'g' ) //checks right char is g
                    isHappy = true;
                else
                    isHappy = false; //need to have else that flips to false as all g need to be happy not just one

        return isHappy;
    }

    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row. Return the number of triples in the given string. The triples may overlap.
     */
    public int countTriple( String str )
    {
        int triple = 0;

        for( int i = 1 ; i < str.length() - 1 ; i++ ) //start and end at +/- 1 index, don't need to check for length in if stmt
            if( str.charAt(i) == str.charAt( i - 1 ) && str.charAt(i) == str.charAt( i + 1 ) ) //does left and right char match
                triple++;

        return triple;
    }

    /**
     * Given a string, return the sum of the digits 0-9 that appear in the string, ignoring all other characters. Return 0 if there are no digits in the string.
     */
    public int sumDigits( String str )
    {
        int sum = 0;

        for( int i = 0 ; i < str.length() ; i++ )
            if( Character.isDigit( str.charAt(i) ) ) //check for digit
                sum += Integer.parseInt( str.substring( i, i + 1 ) ); //add to running total

        return sum;
    }

    /**
     * Given a string, return the longest substring that appears at both the beginning and end of the string without overlapping. For example, sameEnds("abXab") is "ab".
     */
    public String sameEnds( String string )
    {
        String str = "";

        for( int i = 0 ; i < string.length() / 2 + 1 ; i++ ) //only iterate through first half of string, +1 because index starts at 0
            if( string.startsWith( string.substring( 0, i ), string.length() - i ) ) //if same index set of characters at front are same as back
                str = string.substring( 0, i ); //return that subset of indexes, check another index next loop to see if also matches

        return str;
    }

    /**
     * Given a string, look for a mirror image (backwards) string at both the beginning and end of the given string. In other words, zero or more characters at the very begining of the given string, and at the very end of the string in reverse order (possibly overlapping). For example, the string "abXYZba" has the mirror end "ab".
     */
    public String mirrorEnds( String string )
    {
        String mirror = "";

        for( int i = 0 ; i < string.length() ; i++ )
            if( string.charAt(i) == string.charAt( string.length() - 1 - i ) ) //length - 1 - i as -1 needed to get to last index, then move to wanted index
                mirror += string.charAt(i); //add mirrored char
            else
                break; //exit loop if no more mirroring

        return mirror;
    }

    /**
     * Given a string, return the length of the largest "block" in the string. A block is a run of adjacent chars that are the same.
     */
    public int maxBlock( String str )
    {
        int block = 0; //need to count values as one will be overridden each char set
        int count = 1; //count of current block set starts at 1 because there is 1 of a char there

        for( int i = 0 ; i < str.length() - 1 ; i++ )
        {
            if( str.charAt(i) == str.charAt( i + 1 ) ) //if the next char matches increase count
                count++;
            else           //if no match, reset counter and check next potential block set
                count = 1;

            if( count > block ) //if current set is longer in length than previous, overwrite value
                block = count;
        }

        return block;
    }

    /**
     * Given a string, return the sum of the numbers appearing in the string, ignoring all other characters. A number is a series of 1 or more digit chars in a row.
     */
    public int sumNumbers( String str )
    {
        int sum = 0;
        String num = "";

        for( int i = 0 ; i < str.length() ; i++ )
            if( Character.isDigit( str.charAt(i) ) )
                if( i < str.length() - 1 && Character.isDigit( str.charAt( i + 1 ) ) ) //if next char is a digit, including maybe last char
                    num += str.charAt(i);
                else //if at end of number or next char not a digit
                {
                    num += str.charAt(i);
                    sum += Integer.parseInt(num); //parse constructed String number and add to running total
                    num = ""; //reset constructed number
                }

        return sum;
    }

    /**
     * Given a string, return a string where every appearance of the lowercase word "is" has been replaced with "is not". The word "is" should not be immediately preceeded or followed by a letter -- so for example the "is" in "this" does not count.
     */
    public String notReplace( String str )
    {
        String isNot = "";

        for( int i = 0 ; i < str.length() ; i++ )
            if( i + 1 < str.length() && str.startsWith( "is", i ) ) //'is' present and in bounds
            {
                if( ( i > 0 && Character.isLetter( str.charAt( i - 1 ) ) ) || i + 2 < str.length() && Character.isLetter( str.charAt( i + 2 ) ) )
                    isNot += "is"; //left and right either a letter or out of bounds, so add with no change
                else
                    isNot += "is not"; //so add the 'not'

                i++;    //skip to right of the 's'
            }
            else
                isNot += str.charAt(i); //not 'is' so add as normal

        return isNot;
    }

}