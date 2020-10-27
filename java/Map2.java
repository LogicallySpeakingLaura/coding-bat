/**
 * @author LogicallySpeakingLaura
 * @version 2020/10/27
 * Maps with bulk data and loops.
 * https://codingbat.com/java/Map-2
 */
public class Map2
{

    /**
     * Given an array of strings, return a Map<String, Integer> containing a key for every different string in the array, always with the value 0. For example the string "hello" makes the pair "hello":0. We'll do more complicated counting later, but for this problem the value is simply 0.
     */
    public Map< String, Integer > word0( String[] strings )
    {
        Map< String, Integer > map = new HashMap();

        for( String s : strings )
            map.put( s, 0 );

        return map;
    }

    /**
     * Given an array of strings, return a Map<String, Integer> containing a key for every different string in the array, and the value is that string's length.
     */
    public Map< String, Integer > wordLen( String[] strings )
    {
        Map< String, Integer > map = new HashMap();

        for( String s : strings )
            map.put( s, s.length() );

        return map;
    }

    /**
     * Given an array of non-empty strings, create and return a Map<String, String> as follows: for each string add its first character as a key with its last character as the value.
     */
    public Map< String, String > pairs( String[] strings )
    {
        Map< String, String > map = new HashMap();

        for( String s : strings )
            map.put( String.valueOf( s.charAt(0) ), String.valueOf( s.charAt( s.length() - 1 ) ) );

        return map;
    }

    /**
     * The classic word-count algorithm: given an array of strings, return a Map<String, Integer> with a key for each different string, with the value the number of times that string appears in the array.
     */
    public Map< String, Integer > wordCount( String[] strings )
    {
        Map< String, Integer > map = new HashMap();

        for( String s : strings )
            if (!map.containsKey(s))
                map.put(s, 1);
            else
            {
                int count = map.get(s);
                map.put(s, count + 1);
            }

        return map;
    }

    public Map< String, String > firstChar( String[] strings )
    {
        Map< String, String > map = new HashMap();

        for( String s : strings )
            if ( !map.containsKey( String.valueOf( s.charAt(0) ) ) )
                map.put( String.valueOf( s.charAt(0) ), s );
            else
                map.put( String.valueOf( s.charAt(0) ), map.get( String.valueOf( s.charAt(0) ) ) + s );

        return map;
    }

    /**
     * Loop over the given array of strings to build a result string like this: when a string appears the 2nd, 4th, 6th, etc. time in the array, append the string to the result. Return the empty string if no string appears a 2nd time.
     */
    public String wordAppend( String[] strings )
    {
        String str = "";
        Map< String, Integer > map = new HashMap();

        for( String s : strings )
            if (!map.containsKey(s))
                map.put(s, 1);
            else
            {
                int count = map.get(s);
                map.put(s, count + 1);

                if (map.get(s)!=1&&map.get(s)%2==0)
                    str+=s;
            }

        return str;
    }

    /**
     * Given an array of strings, return a Map<String, Boolean> where each different string is a key and its value is true if that string appears 2 or more times in the array.
     */
    public Map<String, Boolean> wordMultiple(String[] strings)
    {
        Map< String, Boolean > map = new HashMap();

        for( String s : strings )
            if ( !map.containsKey( s ) )
                map.put( s, false );
            else
                map.put( s, true );

        return map;
    }

    /**
     * We'll say that 2 strings "match" if they are non-empty and their first chars are the same. Loop over and then return the given array of non-empty strings as follows: if a string matches an earlier string in the array, swap the 2 strings in the array. When a position in the array has been swapped, it no longer matches anything. Using a map, this can be solved making just one pass over the array. More difficult than it looks.
     */
    public String[] allSwap(String[] strings)
    {
        Map<String, Integer> map = new HashMap();

        for (int i =0; i<strings.length; i++)
            if (!map.containsKey(String.valueOf( strings[i].charAt(0) )))
                map.put(String.valueOf( strings[i].charAt(0) ),i);
            else
            {
                String temp = strings[i];
                strings[i] = strings[map.get(String.valueOf( strings[i].charAt(0) ))];
                strings[map.get(String.valueOf( strings[i].charAt(0) ))]= temp;
                map.remove(String.valueOf( strings[i].charAt(0) ));
            }

        return strings;
    }

    /**
     * We'll say that 2 strings "match" if they are non-empty and their first chars are the same. Loop over and then return the given array of non-empty strings as follows: if a string matches an earlier string in the array, swap the 2 strings in the array. A particular first char can only cause 1 swap, so once a char has caused a swap, its later swaps are disabled. Using a map, this can be solved making just one pass over the array. More difficult than it looks.
     */
    public String[] firstSwap(String[] strings)
    {
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (int i = 0; i < strings.length; i++)
            if (!map.containsKey(String.valueOf( strings[i].charAt(0) )))
                map.put(String.valueOf( strings[i].charAt(0) ), i);
            else
            {
                int flag = map.get(String.valueOf( strings[i].charAt(0) ));

                if (flag == -1)
                    continue;

                int swapPos = map.get(String.valueOf( strings[i].charAt(0) ));
                String temp = strings[swapPos];
                strings[swapPos] = strings[i];
                strings[i] = temp ;

                map.put(String.valueOf( strings[i].charAt(0) ), -1);
            }

        return strings;
    }

}