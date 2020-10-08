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
        {
            str += str.charAt(i);
            str += str.charAt(i);
        }

        return rtrn;
    }
}
