/**
 * @author LogicallySpeakingLaura
 * @version 2020/10/08
 * Medium String problems -- 1 loop.
 * https://codingbat.com/java/String-2
 */
public class String2
{
    /**
     * Given a string, return a string where for every char in the original, there are two chars.
     */
    public String doubleChar( String str )
    {
        String rtrn = "";

        for( int i = 0 ; i < str.length() ; i++ )
            rtrn += str.substring( i, i + 1 ) + str.substring( i, i + 1 ); //add same char twice

        return rtrn;
    }

    /**
     * Return the number of times that the string "hi" appears anywhere in the given string.
     */
    public int countHi( String str )
    {
        int count = 0;

        for( int i = 0 ; i < str.length() - 1 ; i++ ) //length - 1 so "hi" doesn't go out of bounds
            if( str.startsWith( "hi", i ) )
                count++;

        return count;
    }

    public boolean catDog( String str )
    {
        int catCount = 0;
        int dogCount = 0;

        for( int i = 0 ; i < str.length() - 2 ; i++ ) //length - 2 so check doesn't go out of bounds
            if( str.startsWith( "cat", i ) ) //use if else as conditions are mutually exclusive
                catCount++;
            else if( str.startsWith( "dog", i ) )
                dogCount++;

        return catCount == dogCount;
    }

    /**
     * Return the number of times that the string "code" appears anywhere in the given string, except we'll accept any letter for the 'd', so "cope" and "cooe" count.
     */
    public int countCode( String str )
    {
        int count = 0;

        for( int i = 0 ; i < str.length() - 3 ; i++ ) //length - 3 so don't go out of bounds
                    //checks first 2 chars          checks 4th
            if( str.startsWith( "co", i ) && str.charAt( i + 3 ) == 'e' )
                count++;

        return count;
    }

    /**
     * Given two strings, return true if either of the strings appears at the very end of the other string, ignoring upper/lower case differences (in other words, the computation should not be "case sensitive").
     */
    public boolean endOther( String a, String b )
    {
        return a.toLowerCase().endsWith( b.toLowerCase() ) || b.toLowerCase().endsWith( a.toLowerCase() );
    }

    public boolean xyzThere( String str )
    {
        return str.contains( "xyz" ) && !( str.contains( ".xyz" ) );
    }

}
