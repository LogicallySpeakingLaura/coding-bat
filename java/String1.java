/**
 * @author LogicallySpeakingLaura
 * @version 2020/10/28
 * Basic string problems -- no loops.
 * https://codingbat.com/java/String-1
 */
public class String1
{

    /**
     * Given a string name, e.g. "Bob", return a greeting of the form "Hello Bob!".
     */
    public String helloName( String name )
    {
        return "Hello " + name + "!"; //concat separate pieces together
    }

    /**
     * Given two strings, a and b, return the result of putting them together in the order abba, e.g. "Hi" and "Bye" returns "HiByeByeHi".
     */
    public String makeAbba( String a, String b )
    {
        return a + b + b + a; //concat in order, you are the dancing queen
    }

    /**
     * The web is built with HTML strings like "<i>Yay</i>" which draws Yay as italic text. In this example, the "i" tag makes <i> and </i> which surround the word "Yay". Given tag and word strings, create the HTML string with tags around the word, e.g. "<i>Yay</i>".
     */
    public String makeTags( String tag, String word )
    {
        return "<" + tag + ">" + word + "</" + tag + ">"; //concat separate pieces together
    }

    /**
     * Given an "out" string length 4, such as "<<>>", and a word, return a new string where the word is in the middle of the out string, e.g. "<<word>>".
     */
    public String makeOutWord( String out, String word )
    {
        return out.substring( 0, out.length() / 2 ) + word + out.substring( out.length() / 2 ); //first half + word + second half
    }

    /**
     * Given a string, return a new string made of 3 copies of the last 2 chars of the original string. The string length will be at least 2.
     */
    public String extraEnd( String str )
    {
        return str.substring( str.length() - 2 ) + str.substring( str.length() - 2 ) + str.substring( str.length() - 2 ); //last 2 char * 3, or index 0-1 if length is 2
    }

    /**
     * Given a string, return the string made of its first two chars, so the String "Hello" yields "He". If the string is shorter than length 2, return whatever there is, so "X" yields "X", and the empty string "" yields the empty string "".
     */
    public String firstTwo( String str )
    {
        return str.length() > 2  ?  str.substring( 0, 2 )  :  str; //only make substring if length is big enough, otherwise return str as is
    }

    /**
     * Given a string of even length, return the first half. So the string "WooHoo" yields "Woo".
     */
    public String firstHalf( String str )
    {
        return str.substring( 0, str.length() / 2 ); //substring ends at half of length - 1
    }

    /**
     * Given a string, return a version without the first and last char, so "Hello" yields "ell". The string length will be at least 2.
     */
    public String withoutEnd( String str )
    {
        return str.length() == 2  ?  ""  :  str.substring( 1, str.length() - 1 ); //length of 2 with first and last removed is an empty String
    }

    /**
     * Given 2 strings, a and b, return a string of the form short+long+short, with the shorter string on the outside and the longer string on the inside. The strings will not be the same length, but they may be empty (length 0).
     */
    public String comboString( String a, String b )
    {
        return a.length() < b.length()  ?  a + b + a  :  b + a + b; //return sandwich after determining shorter String
    }

    /**
     * Given 2 strings, return their concatenation, except omit the first char of each. The strings will be at least length 1.
     */
    public String nonStart( String a, String b )
    {
        return a.substring(1) + b.substring(1); //concat new substrings without the char at index 0
    }

    /**
     * Given a string, return a "rotated left 2" version where the first 2 chars are moved to the end. The string length will be at least 2.
     */
    public String left2( String str )
    {
        return str.substring(2) + str.substring( 0, 2 ); //divide into substrings then concat again
    }

    /**
     * Given a string, return a "rotated right 2" version where the last 2 chars are moved to the start. The string length will be at least 2.
     */
    public String right2( String str )
    {
        return str.substring( str.length() - 2 ) + str.substring( 0, str.length() - 2 ); //divide into substrings then concat again
    }

    /**
     * Given a string, return a string length 1 from its front, unless front is false, in which case return a string length 1 from its back. The string will be non-empty.
     */
    public String theEnd( String str, boolean front )
    {
        return front  ?  String.valueOf( str.charAt(0) )  :  String.valueOf( str.charAt( str.length() - 1 ) ); //String of length 1 is just a specific char
    }

    /**
     * Given a string, return a version without both the first and last char of the string. The string may be any length, including 0.
     */
    public String withouEnd2( String str )
    {
        return str.length() > 2  ?  str.substring( 1, str.length() - 1 )  :  ""; //anything <= 2 will be empty
    }

    /**
     * Given a string of even length, return a string made of the middle two chars, so the string "string" yields "ri". The string length will be at least 2.
     */
    public String middleTwo( String str )
    {
        return str.substring( ( str.length() / 2 ) - 1, ( str.length() / 2 ) + 1 ); //if length is 2 this is return char at first index
    }

    /**
     * Given a string, return true if it ends in "ly".
     */
    public boolean endsLy( String str )
    {
        return str.length() >= 2  &&  str.endsWith( "ly" ); //check for length, empty string or one char string cannot contain "ly"
    }

    /**
     * Given a string and an int n, return a string made of the first and last n chars from the string. The string length will be at least n.
     */
    public String nTwice( String str, int n )
    {
        return str.substring( 0, n ) + str.substring( str.length() - n ); //no need to check bound for n as length at least n
    }

    /**
     * Given a string and an index, return a string length 2 starting at the given index. If the index is too big or too small to define a string length 2, use the first 2 chars. The string length will be at least 2.
     */
    public String twoChar( String str, int index )
    {
        return index >= 0  &&  index + 2 <= str.length()  ?  str.substring( index, index + 2 )  :  str.substring( 0, 2 ); //index value could be negative, so check for 0 or above
    }

    /**
     * Given a string of odd length, return the string length 3 from its middle, so "Candy" yields "and". The string length will be at least 3.
     */
    public String middleThree( String str )
    {
        return str.substring( ( str.length() / 2 ) - 1, ( str.length() / 2 ) + 2 ); //must be + 2, otherwise will return 2 chars
    }

    /**
     * Given a string, return true if "bad" appears starting at index 0 or 1 in the string, such as with "badxxx" or "xbadxx" but not "xxbadxx". The string may be any length, including 0.
     */
    public boolean hasBad( String str )
    {
        return str.length() >= 3  &&  str.startsWith( "bad" )   ||   str.length() >= 4  &&  str.startsWith( "bad", 1 ); //as this checks for "bad" at index 1 length must be at least 4 otherwise out of bounds
    }

    /**
     * Given a string, return a string length 2 made of its first 2 chars. If the string length is less than 2, use '@' for the missing chars.
     */
    public String atFirst( String str )
    {
       return str.length() >= 2  ?  str.substring( 0, 2 )  :  str.length() == 1  ?  str + "@"  :  "@@"; //return "@@" for empty String
    }

    /**
     * Given 2 strings, a and b, return a new string made of the first char of a and the last char of b, so "yo" and "java" yields "ya". If either string is length 0, use '@' for its missing char.
     */
    public String lastChars( String a, String b )
    {
        if ( a.length() == 0 ) //a is empty
            a = "@";

        if ( b.length() == 0 ) //b is empty
            b = "@";

        return a.substring( 0, 1 ) + b.substring( b.length() - 1 ); //if Strings are empty this returns simpy index 0 which is now "@"
    }

    /**
     * Given two strings, append them together (known as "concatenation") and return the result. However, if the concatenation creates a double-char, then omit one of the chars, so "abc" and "cat" yields "abcat".
     */
    public String conCat( String a, String b )
    {
        return a.length() > 0  &&  b.length() > 0  &&  b.startsWith( String.valueOf( a.charAt( a.length() - 1 ) ) )  ?  a + b.substring(1)  :  a + b; //get rid of first char on b if there is overlap
    }

    /**
     * Given a string of any length, return a new string where the last 2 chars, if present, are swapped, so "coding" yields "codign".
     */
    public String lastTwo( String str )
    {
        return str.length() == 2  ?  str.substring(1) + str.charAt(0)  :
                str.length() > 2  ?  str.substring( 0, str.length() - 2 ) + str.charAt( str.length() - 1 ) + str.charAt( str.length() - 2 )  :
                        str; // : str is str <== 1 so can be returned as is
    }

    /**
     * Given a string, if the string begins with "red" or "blue" return that color string, otherwise return the empty string.
     */
    public String seeColor( String str )
    {
        return str.startsWith( "red" )  ?  "red"  :  str.startsWith( "blue" )  ?  "blue"  :  ""; // : "" is neither matching
    }

    /**
     * Given a string, return true if the first 2 chars in the string also appear at the end of the string, such as with "edited".
     */
    public boolean frontAgain( String str )
    {
        return str.length() == 2   ||   str.length() > 2  &&  str.endsWith( str.substring( 0, 2 ) ); //have to check length to account for length being less than 2
    }

    /**
     * Given two strings, append them together (known as "concatenation") and return the result. However, if the strings are different lengths, omit chars from the longer string so it is the same length as the shorter string. So "Hello" and "Hi" yield "loHi". The strings may be any length.
     */
    public String minCat( String a, String b )
    {
        return a.length() > b.length()  ?  a.substring( a.length() - b.length() ) + b  :
                a.length() < b.length()  ?  a + b.substring( b.length() - a.length() )  :  a + b; //begin substring at difference between lengths
    }

    /**
     * Given a string, return a new string made of 3 copies of the first 2 chars of the original string. The string may be any length. If there are fewer than 2 chars, use whatever is there.
     */
    public String extraFront( String str )
    {
        return str.length() > 2  ?  str.substring( 0, 2 ) + str.substring( 0, 2 ) + str.substring( 0, 2 )  :  str + str + str; //if length is 2 return as-is
    }

    /**
     * Given a string, if a length 2 substring appears at both its beginning and end, return a string without the substring at the beginning, so "HelloHe" yields "lloHe". The substring may overlap with itself, so "Hi" yields "". Otherwise, return the original string unchanged.
     */
    public String without2( String str )
    {
        return str.length() == 2  ?  ""  :  str.length() > 2  &&  str.endsWith( str.substring( 0, 2 ) )  ?  str.substring(2)  :  str; //length of 2 returns empty, less than 2 returns as-is
    }

    /**
     * Given a string, return a version without the first 2 chars. Except keep the first char if it is 'a' and keep the second char if it is 'b'. The string may be any length.
     */
    public String deFront( String str )
    {
        return str.charAt(0) == 'a'  &&  str.charAt(1) == 'b'  ?  str  : //return str as is and immediately because a and b are first 2 char
                str.charAt(0) != 'a'  &&  str.charAt(1) != 'b'  ?  str.substring(2)  : //no a or b, so return str without first 2 char
                        str.charAt(0) == 'a'  ?  "a" + str.substring(2)  : //only a is present, return without char at index 1
                                str.charAt(1) == 'b'  ?  "b" + str.substring(2)  :  str; //only b present, return without char at index 0
    }

    /**
     * Given a string and a second "word" string, we'll say that the word matches the string if it appears at the front of the string, except its first char does not need to match exactly. On a match, return the front of the string, or otherwise return the empty string. So, so with the string "hippo" the word "hi" returns "hi" and "xip" returns "hip". The word will be at least length 1.
     */
    public String startWord( String str, String word )
    {
        //check length, word can't match string if it longer, don't care about first char so start checking at index 1
        //want to return first char of str and second char onward for word
        return str.length() >= word.length()  &&  str.substring( 1, word.length() ).equals( word.substring(1) )  ?  str.substring( 0, word.length() )  :  "";
    }

    /**
     * Given a string, if the first or last chars are 'x', return the string without those 'x' chars, and otherwise return the string unchanged.
     */
    public String withoutX( String str )
    {
        //no if-else as need to be able to check each condition and the second and third if statements can be:
        //both true, both false, one true the other false
        if ( str.equals( "xx" ) ) //str can be two char of both x
            str = "";

        if ( str.length() > 0  &&  str.charAt(0) == 'x' ) //checking first char
            str = str.substring(1);

        if ( str.length() > 1  &&  str.charAt( str.length() - 1 ) == 'x' ) //checking second char
            str = str.substring( 0, str.length() - 1 );

        return str;
    }

    /**
     * Given a string, if one or both of the first 2 chars is 'x', return the string without those 'x' chars, and otherwise return the string unchanged.
     */
    public String withoutX2( String str )
    {
        return str.length() > 1  &&  str.charAt(0) == 'x'  &&  str.charAt(1) == 'x'  ?  str.substring(2)  : //both x
                str.length() > 0  &&  str.charAt(0) == 'x'  ?  str.substring(1)  :   //first x
                str.length() > 1  &&  str.charAt(1) == 'x'  ?  str.charAt(0) + str.substring(2)  :  str; //second x or none x
    }

}