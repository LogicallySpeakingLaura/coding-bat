/**
 * @author LogicallySpeakingLaura
 * @version 2020/10/09
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
        //regex checks for all cases of remove ignoring case and replaces w/ empty string
        return base.replaceAll( "(?i)" + remove, "" );
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

}
