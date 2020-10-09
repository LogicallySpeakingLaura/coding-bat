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
        // an iterative solution that works and is efficient can be found at https://codingbatsolutions.wordpress.com/category/string-3/
    }


}
