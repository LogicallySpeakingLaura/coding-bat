/**
 * @author LogicallySpeakingLaura
 * @version 2020/10/28
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
        String s = "";

        for ( int i = 0  ;  i < str.length()  ;  i++ )
            s += String.valueOf( str.charAt(i) ) + str.charAt(i); //add same char twice

        return s;
    }

    /**
     * Return the number of times that the string "hi" appears anywhere in the given string.
     */
    public int countHi( String str )
    {
        int count = 0;

        for ( int i = 0  ;  i < str.length() - 1  ;  i++ ) //length - 1 so "hi" doesn't go out of bounds
            if( str.startsWith( "hi", i ) )
                count++;

        return count;
    }

    /**
     * Return true if the string "cat" and "dog" appear the same number of times in the given string.
     */
    public boolean catDog( String str )
    {
        int catCount = 0, dogCount = 0;

        for ( int i = 0  ;  i < str.length() - 2  ;  i++ ) //length - 2 so check doesn't go out of bounds
            if ( str.startsWith( "cat", i ) ) //use if else as conditions are mutually exclusive
                catCount++;
            else if ( str.startsWith( "dog", i ) )
                dogCount++;

        return catCount == dogCount; //check count equality
    }

    /**
     * Return the number of times that the string "code" appears anywhere in the given string, except we'll accept any letter for the 'd', so "cope" and "cooe" count.
     */
    public int countCode( String str )
    {
        int count = 0;

        for ( int i = 0  ;  i < str.length() - 3  ;  i++ ) //length - 3 so don't go out of bounds
            if ( str.startsWith( "co", i ) && str.charAt( i + 3 ) == 'e' ) //checks first 2 chars and then checks 4th
            {
                count++;
                i += 3; //move index to right of 'e'
            }

        return count;
    }

    /**
     * Given two strings, return true if either of the strings appears at the very end of the other string, ignoring upper/lower case differences (in other words, the computation should not be "case sensitive").
     */
    public boolean endOther( String a, String b )
    {
        return a.toLowerCase().endsWith( b.toLowerCase() )  ||  b.toLowerCase().endsWith( a.toLowerCase() ); //convert to lower case to ignore case
    }

    /**
     * Return true if the given string contains an appearance of "xyz" where the xyz is not directly preceeded by a period (.). So "xxyz" counts but "x.xyz" does not.
     */
    public boolean xyzThere( String str )
    {
        boolean isThere = false;

        for ( int i = 0  ;  i < str.length() - 2  ;  i++ ) //set correct bound
            if( str.startsWith( "xyz", i ) )
            {
                isThere = i > 0  &&  str.charAt( i - 1 ) == '.'  ?  false  :  true; //i > 0 as want to check char to left
                i += 2; //jump to the right of the index where z is for next check, so not checking yz and z
            }

        return isThere;
    }

    /**
     * Return true if the given string contains a "bob" string, but where the middle 'o' char can be any char.
     */
    public boolean bobThere( String str )
    {
        boolean hasBob = false;

        for ( int i = 0  ;  i < str.length() - 2  ;  i++ ) //length - 3 so don't go out of bounds
            if( str.charAt( i ) == 'b'  &&  str.charAt( i + 2 ) == 'b' ) //checks first b and then check second b
            {
                hasBob = true;
                break; //exit loop as soon as condition met, avoid further iterations
            }

        return hasBob;
    }

    /**
     * We'll say that a String is xy-balanced if for all the 'x' chars in the string, there exists a 'y' char somewhere later in the string. So "xxy" is balanced, but "xyx" is not. One 'y' can balance multiple 'x's. Return true if the given string is xy-balanced.
     */
    public boolean xyBalance( String str )
    {
        return str.lastIndexOf( 'x' ) < str.lastIndexOf( 'y' )  ||  !str.contains( "x" ); //if there is no x str auto balanced
    }

    /**
     * Given two strings, a and b, create a bigger string made of the first char of a, the first char of b, the second char of a, the second char of b, and so on. Any leftover chars go at the end of the result.
     */
    public String mixString( String a, String b )
    {
        int shorter = a.length() < b.length()  ?  a.length()  :  b.length(); //finding length of shortest String
        String mix = "", leftover = a.length() < b.length()  ?  b.substring( shorter )  :  a.substring( shorter ); //getting leftovers of bigger String

        for ( int i = 0  ;  i < shorter  ;  i++ ) //only iterate for length of shorter String
            mix += String.valueOf( a.charAt(i) ) + b.charAt(i); //mixing letters

        return mix + leftover;
    }

    /**
     * Given a string and an int n, return a string made of n repetitions of the last n characters of the string. You may assume that n is between 0 and the length of the string, inclusive.
     */
    public String repeatEnd( String str, int n )
    {
        String s = "";

        for( int i = 0  ;  i < n  ;  i++ ) //iterate n times
            s += str.substring( str.length() - n ); //adds end of str plus extra char going in reverse each iteration

        return s;
    }

    /**
     * Given a string and an int n, return a string made of the first n characters of the string, followed by the first n-1 characters of the string, and so on. You may assume that n is between 0 and the length of the string, inclusive (i.e. n >= 0 and n <= str.length()).
     */
    public String repeatFront( String str, int n )
    {
        String s = "";

        for( int i = n  ;  i > 0  ;  i-- ) //index starts at what will be end of substring
            s += str.substring( 0, i ); //substring decreases in length each iteration

        return s;
    }

    /**
     * Given two strings, word and a separator sep, return a big string made of count occurrences of the word, separated by the separator string.
     */
    public String repeatSeparator( String word, String sep, int count )
    {
        String s = count == 0  ?  ""  :  word; //if count is 0 want to return ""

        while( count > 1 ) //if count == 1 want to return one instance of word, assigned above
        {
            s += sep + word; //concat together
            count--;           //decrement count so when it equals 1 loop exited
        }

        return s;
    }

    /**
     * Given a string, consider the prefix string made of the first N chars of the string. Does that prefix string appear somewhere else in the string? Assume that the string is not empty and that N is in the range 1..str.length().
     */
    public boolean prefixAgain( String str, int n )
    {
        return str.substring(n).contains( str.substring( 0, n ) ); //does substring from index n to end contain substring from 0 to index n - 1
    }

    /**
     * Given a string, does "xyz" appear in the middle of the string? To define middle, we'll say that the number of chars to the left and right of the "xyz" must differ by at most one. This problem is harder than it looks.
     */
    public boolean xyzMiddle( String str )
    {
        return str.length() >= 3  &&  str.startsWith( "xyz", str.length() / 2 - 1 )  ?  true  : //uneven length, length has to be at least 3
                str.length() >= 3  &&  str.length() % 2 == 0  &&  str.startsWith( "xyz", str.length() / 2 - 2 ); //even length
    }

    /**
     * A sandwich is two pieces of bread with something in between. Return the string that is between the first and last appearance of "bread" in the given string, or return the empty string "" if there are not two pieces of bread.
     */
    public String getSandwich( String str )
    {
        return str.length() > 10  ?  str.substring( str.indexOf( "bread" ) + 5, str.lastIndexOf( "bread" ) )  :  ""; //length must be more than 10 for a sandwich, + 5 moves to right of 'd' for first "bread"
    }

    /**
     * Returns true if for every '*' (star) in the string, if there are chars both immediately before and after the star, they are the same.
     */
    public boolean sameStarChar( String str )
    {
        boolean isSame = true;

        for ( int i = 1  ;  i < str.length() - 1  ;  i++ ) //start at index 1 and go length - 1 as * at 0 or last index is true
            if ( str.charAt(i) == '*' )
                if ( str.charAt( i - 1 ) != str.charAt( i + 1 ) ) //checking char either side of *
                {
                    isSame = false;
                    break; //exit first time found false to avoid unnecessary iterations
                }

        return isSame;
    }

    /**
     * Given a string, compute a new string by moving the first char to come after the next two chars, so "abc" yields "bca". Repeat this process for each subsequent group of 3 chars, so "abcdef" yields "bcaefd". Ignore any group of fewer than 3 chars at the end.
     */
    public String oneTwo( String str )
    {
        String s = "";

        for ( int i = 0  ;  i < str.length() - 2  ;  i += 3 ) //length - 2 for bounds, increment by 3 to get to start of next group
            s += str.substring( i + 1, i + 3 ) + str.charAt(i); //append char 2 and 3, then 1

        return s;
    }

    /**
     * Look for patterns like "zip" and "zap" in the string -- length-3, starting with 'z' and ending with 'p'. Return a string where for all such words, the middle letter is gone, so "zipXzap" yields "zpXzp".
     */
    public String zipZap( String str )
    {
        String s = "";

        for ( int i = 0  ;  i < str.length()  ;  i++ )
            if ( i + 2 < str.length()  &&  str.charAt(i) == 'z'  &&  str.charAt( i + 2 ) == 'p' ) //check bound as well as index value, length checked here as if true i incremented
            {
                s += "zp";
                i += 2; //jump to next index after p so not checking for ?p and p
            }
            else
                s += str.charAt(i); //if not z?p just add char as is

        return s;
    }

    /**
     * Return a version of the given string, where for every star (*) in the string the star and the chars immediately to its left and right are gone. So "ab*cd" yields "ad" and "ab**cd" also yields "ad".
     */
    public String starOut( String str )
    {
        String s = "";

        for ( int i = 0  ;  i < str.length()  ;  i++ ) //don't put bound here as still want to add first/last char if they not *
            if ( !( '*' == str.charAt(i)   ||   i + 1 < str.length()  &&  '*' == str.charAt( i + 1 )   ||   i > 0  &&  '*' == str.charAt( i - 1) ) ) //check current index *, then check char to right, then char to the left
                s += str.charAt(i);

        return s;
    }

    /**
     * Given a string and a non-empty word string, return a version of the original String where all chars have been replaced by pluses ("+"), except for appearances of the word string which are preserved unchanged.
     */
    public String plusOut( String str, String word )
    {
        String s = "";

        for ( int i = 0  ;  i < str.length()  ;  i++ )
            if ( str.startsWith( word, i ) ) //word exists at current index
            {
                s += word;
                i += word.length() - 1; //iterate so next index is right of word
            }
            else
                s += "+";

        return s;
    }

    /**
     * Given a string and a non-empty word string, return a string made of each char just before and just after every appearance of the word in the string. Ignore cases where there is no char before or after the word, and a char may be included twice if it is between two words.
     */
    public String wordEnds( String str, String word )
    {
        String s = "";

        for ( int i = 0  ;  i < str.length() - word.length() + 1  ;  i++ )
        {
            if ( i > 0  &&  str.startsWith( word, i ) ) //char before word
                s += String.valueOf( str.charAt( i - 1 ) );

            if ( i < str.length() - word.length()  &&  str.startsWith( word, i ) ) //char after word
                s += String.valueOf( str.charAt( i + word.length() ) );
        }

        return s;
    }

}