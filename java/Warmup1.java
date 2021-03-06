/**
 * @author LogicallySpeakingLaura
 * @version 2020/10/28
 * Simple warmup problems to get started.
 * https://codingbat.com/java/Warmup-1
 */
public class Warmup1
{

    /**
     * The parameter weekday is true if it is a weekday, and the parameter vacation is true if we are on vacation. We sleep in if it is not a weekday or we're on vacation. Return true if we sleep in.
     */
    public boolean sleepIn( boolean weekday, boolean vacation )
    {
        return !weekday  ||  vacation; //weekday is false and vacation is true
    }

    /**
     * We have two monkeys, a and b, and the parameters aSmile and bSmile indicate if each is smiling. We are in trouble if they are both smiling or if neither of them is smiling. Return true if we are in trouble.
     */
    public boolean monkeyTrouble( boolean aSmile, boolean bSmile )
    {
        return aSmile == bSmile; //this is the same as checking for if ( aSmile && bSmile ) or !( aSmile && bSmile )
    }

    /**
     * Given two int values, return their sum. Unless the two values are the same, then return double their sum.
     */
    public int sumDouble( int a, int b )
    {
        return  a == b  ?  ( a + b ) * 2  :  a + b; //if a and b are same return double sum otherwise sum
    }

    /**
     * Given an int n, return the absolute difference between n and 21, except return double the absolute difference if n is over 21.
     */
    public int diff21( int n )
    {
        return n > 21  ?  ( n - 21 ) * 2  :  21 - n; //if n is bigger return double diff, otherwise abs diff
    }

    /**
     * We have a loud talking parrot. The "hour" parameter is the current hour time in the range 0..23. We are in trouble if the parrot is talking and the hour is before 7 or after 20. Return true if we are in trouble.
     */
    public boolean parrotTrouble( boolean talking, int hour )
    {
        return talking  &&  ( hour < 7  ||  hour > 20 ); //talking is true AND it's before 7 OR after 20
    }

    /**
     * Given 2 ints, a and b, return true if one if them is 10 or if their sum is 10.
     */
    public boolean makes10( int a, int b )
    {
        return ( a + b == 10 )  ||  a == 10  || b == 10; //each expression evaluates to 10
    }

    /**
     * Given an int n, return true if it is within 10 of 100 or 200.
     */
    public boolean nearHundred( int n )
    {
        return Math.abs( 100 - n ) <= 10  ||  Math.abs( 200 - n ) <= 10; //each expression evaluates to within 10 of target number
    }

    /**
     * Given 2 int values, return true if one is negative and one is positive. Except if the parameter "negative" is true, then return true only if both are negative.
     */
    public boolean posNeg( int a, int b, boolean negative )
    {
        return  negative  &&  a < 0  &&  b < 0   ||   !negative  &&  ( a < 0  &&  0 < b   ||   b < 0  &&  0 < a ); //neg true and a and b < 0 or neg false or checking of ints
    }

    /**
     * Given a string, return a new string where "not " has been added to the front. However, if the string already begins with "not", return the string unchanged.
     */
    public String notString( String str )
    {
        return str.length() >= 3  &&  !str.startsWith( "not" )   ||   str.length() <= 2  ?  "not " + str  :  str; //length must be at least 3 to contain "not"
    }

    /**
     * Given a non-empty string and an int n, return a new string where the char at index n has been removed. The value of n will be a valid index of a char in the original string (i.e. n will be in the range 0..str.length()-1 inclusive).
     */
    public String missingChar( String str, int n )
    {
        return str.substring( 0, n ) + str.substring( n + 1 ); //first substring up to n, concat second starting at n + 1
    }

    /**
     * Given a string, return a new string where the first and last chars have been exchanged.
     */
    public String frontBack(String str)
    {
        return str.length() <= 1  ?  str  :  str.charAt( str.length() - 1 ) + str.substring( 1, str.length() - 1 ) + str.charAt(0); //if length is one no chars to exchange so return as is
    }

    /**
     * Given a string, we'll say that the front is the first 3 chars of the string. If the string length is less than 3, the front is whatever is there. Return a new string which is 3 copies of the front.
     */
    public String front3( String str )
    {
        return str.length() <= 3  ?  str + str + str  :  str.substring( 0, 3 ) + str.substring( 0, 3 ) + str.substring( 0, 3 ); //when length is 3 or less can return as-is
    }

    /**
     * Given a string, take the last char and return a new string with the last char added at the front and back, so "cat" yields "tcatt". The original string will be length 1 or more.
     */
    public String backAround( String str )
    {
        return str.charAt( str.length() - 1 ) + str + str.charAt( str.length() - 1 ); //last char + str + last char
    }

    /**
     * Return true if the given non-negative number is a multiple of 3 or a multiple of 5.
     */
    public boolean or35( int n )
    {
        return n % 3 == 0  ||  n % 5 == 0; //will only evaluate to 0 if n is a multiple of either/or
    }

    /**
     * Given a string, take the first 2 chars and return the string with the 2 chars added at both the front and back, so "kitten" yields"kikittenki". If the string length is less than 2, use whatever chars are there.
     */
    public String front22( String str )
    {
        return str.length() < 2  ?  str + str + str  :  str.substring( 0, 2 ) + str + str.substring( 0, 2 ); //< 2 as index starts at 0
    }

    /**
     * Given a string, return true if the string starts with "hi" and false otherwise.
     */
    public boolean startHi( String str )
    {
        return str.length() >= 2  &&  str.startsWith( "hi" ); //str has to have more than 2 letters, otherwise impossible to spell "hi"
    }

    /**
     * Given two temperatures, return true if one is less than 0 and the other is greater than 100.
     */
    public boolean icyHot( int temp1, int temp2 )
    {
        return temp1 < 0  &&  100 < temp2   ||   temp2 < 0  &&  100 < temp1; //each expression meets condition, if neither do will be false, as || used will pass with just one
    }

    /**
     * Given 2 int values, return true if either of them is in the range 10..20 inclusive.
     */
    public boolean in1020( int a, int b )
    {
        return 10 <= a  &&  a <= 20   ||   10 <= b  &&  b <= 20; //each expression meets condition, if neither do will be false, as || used will pass with just one
    }

    /**
     * We'll say that a number is "teen" if it is in the range 13..19 inclusive. Given 3 int values, return true if 1 or more of them are teen.
     */
    public boolean hasTeen( int a, int b, int c )
    {
        return 13 <= a  &&  a <= 19   ||   13 <= b  &&  b <= 19   ||   13 <= c  &&  c <= 19; //each expression meets condition, if none do will be false, as || used will pass with just one
    }

    /**
     * We'll say that a number is "teen" if it is in the range 13..19 inclusive. Given 2 int values, return true if one or the other is teen, but not both.
     */
    public boolean loneTeen( int a, int b )
    {
        return 13 <= a  &&  a <= 19  &&  !( 13 <= b  &&  b <= 19 )   ||   !( 13 <= a  &&  a <= 19 )  &&  13 <= b  &&  b <= 19; //negate opposite teen either side of ||
    }

    /**
     * Given a string, if the string "del" appears starting at index 1, return a string where that "del" has been deleted. Otherwise, return the string unchanged.
     */
    public String delDel( String str )
    {
        return str.length() > 3  &&  str.startsWith( "del", 1 )  ?  str.charAt( 0 ) + str.substring(4)  :  str; //str has to be 4 chars or more, otherwise "del" cannot be part of str
    }

    /**
     * Return true if the given string begins with "mix", except the 'm' can be anything, so "pix", "9ix" .. all count.
     */
    public boolean mixStart( String str )
    {
        return str.length() > 2  &&  str.startsWith( "ix", 1 ); //only need to check indexes 1-2 as 0 can be anything
    }

    /**
     * Given a string, return a string made of the first 2 chars (if present), however include first char only if it is 'o' and include the second only if it is 'z', so "ozymandias" yields "oz".
     */
    public String startOz( String str )
    {
        String s = "";

        if ( str.length() >= 1  &&  str.charAt(0) == 'o' ) //check for 'o' at first index
            s += str.charAt(0);                 //add to returnStr

        if ( str.length() >= 2  &&  str.charAt(1) == 'z' ) //check for 'z' at second index
            s += str.charAt(1);                 //add to returnStr, 'o' already added if applicable as 2 separate if stmts, not an if-else

        return s;
    }

    /**
     * Given three int values, a b c, return the largest.
     */
    public int intMax( int a, int b, int c )
    {
        return Math.max( Math.max( a, b ), c ); //nested Math.max find biggest of 3 ints at once
    }

    /**
     * Given 2 int values, return whichever value is nearest to the value 10, or return 0 in the event of a tie.
     */
    public int close10( int a, int b )
    {
        return Math.abs( a - 10 ) == Math.abs( b - 10 )  ?  0  : //check for tie and return 0,
                Math.abs( a - 10 ) < Math.abs( b - 10 )  ?  a  : //a nearer to 10 so return 10,
                        Math.abs( a - 10 ) > Math.abs( b - 10 )  ?  b  :  b; //b near to 10 so return b, b : b because no else but syntax needs
    }


    /**
     * Given 2 int values, return true if they are both in the range 30..40 inclusive, or they are both in the range 40..50 inclusive.
     */
    public boolean in3050( int a, int b )
    {
        return 30 <= a  &&  a <= 40  &&  30 <= b  &&  b <= 40   ||   40 <= a  &&  a <= 50  &&  40 <= b  &&  b <= 50; //both 30 - 40 inclusive or both 40 - 50 inclusive
    }

    /**
     * Given 2 positive int values, return the larger value that is in the range 10..20 inclusive, or return 0 if neither is in that range.
     */
    public int max1020( int a, int b )
    {
        a = 10 <= a  &&  a <= 20  ?  a  :  0; //assign 0 if not in inclusive range
        b = 10 <= b  &&  b <= 20  ?  b  :  0;

        return Math.max( a, b ); //if neither in range then both values here are 0, so 0 returned
    }

    /**
     * Return true if the given string contains between 1 and 3 'e' chars.
     */
    public boolean stringE( String str )
    {
        int count = 0; //int var will hold number of 'e's

        for ( int i = 0  ;  i < str.length()  ;  i++ )
        {
            if ( str.charAt(i) == 'e' )
                count++; //if there is an 'e' count increases by one, repeat till each char checked
        }

        return 1 <= count  &&  count <= 3; //return true if count in correct range
    }

    /**
     * Given two non-negative int values, return true if they have the same last digit, such as with 27 and 57.
     */
    public boolean lastDigit( int a, int b )
    {
        return a % 10 == b % 10; //% 10 removes all digits but last
    }

    /**
     * Given a string, return a new string where the last 3 chars are now in upper case. If the string has less than 3 chars, uppercase whatever is there.
     */
    public String endUp( String str )
    {
       return str.length() <= 3  ?  str.toUpperCase()  :  str.substring( 0, str.length() - 3 ) + str.substring( str.length() - 3 ).toUpperCase(); //length 3 or less just uppercase str as-is
    }

    /**
     * Given a non-empty string and an int N, return the string made starting with char 0, and then every Nth char of the string.
     */
    public String everyNth( String str, int n )
    {
        String s = "";

        for ( int i = 0  ;  i < str.length()  ;  i += n ) //i = i + n will increment loop by n
            s += str.charAt(i);

        return s;
    }

}