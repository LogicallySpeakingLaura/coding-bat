/**
 * @author LogicallySpeakingLaura
 * @version 2020/10/29
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
        Map< String, Integer > map = new HashMap(); //instantiation of a new HashMap

        for ( String s : strings )
            map.put( s, 0 ); //as 's' changes for each iteration the new value becomes the key

        return map;
    }

    /**
     * Given an array of strings, return a Map<String, Integer> containing a key for every different string in the array, and the value is that string's length.
     */
    public Map< String, Integer > wordLen( String[] strings )
    {
        Map< String, Integer > map = new HashMap();

        for ( String s : strings )
            map.put( s, s.length() );

        return map;
    }

    /**
     * Given an array of non-empty strings, create and return a Map<String, String> as follows: for each string add its first character as a key with its last character as the value.
     */
    public Map< String, String > pairs( String[] strings )
    {
        Map< String, String > map = new HashMap();

        for ( String s : strings )
            map.put( String.valueOf( s.charAt(0) ), String.valueOf( s.charAt( s.length() - 1 ) ) );

        return map;
    }

    /**
     * The classic word-count algorithm: given an array of strings, return a Map<String, Integer> with a key for each different string, with the value the number of times that string appears in the array.
     */
    public Map< String, Integer > wordCount( String[] strings )
    {
        Map< String, Integer > map = new HashMap();

        for ( String s : strings )
            if ( !map.containsKey(s) ) //map does not contain key for current array index element
                map.put( s, 1 ); //so add it to array, 1 represent count as first instance
            else
            {
                int count = map.get(s); //the value of the key contains the count for key already in map
                map.put( s, count + 1 ); //override of key with incremented count gives new value
            }

        return map;
    }

    /**
     * Given an array of non-empty strings, return a Map<String, String> with a key for every different first character seen, with the value of all the strings starting with that character appended together in the order they appear in the array.
     */
    public Map< String, String > firstChar( String[] strings )
    {
        Map< String, String > map = new HashMap();

        for ( String s : strings )
            if ( !map.containsKey( String.valueOf( s.charAt(0) ) ) ) //no current key for first char of current element
                map.put( String.valueOf( s.charAt(0) ), s );
            else
                map.put( String.valueOf( s.charAt(0) ), map.get( String.valueOf( s.charAt(0) ) ) + s ); //if there is a key, override and concat current element

        return map;
    }

    /**
     * Loop over the given array of strings to build a result string like this: when a string appears the 2nd, 4th, 6th, etc. time in the array, append the string to the result. Return the empty string if no string appears a 2nd time.
     */
    public String wordAppend( String[] strings )
    {
        String str = "";
        Map< String, Integer > map = new HashMap();

        for ( String s : strings )
            if ( !map.containsKey(s) ) //place first instance of String into map
                map.put( s, 1 );
            else
            {
                int count = map.get(s);
                map.put( s, count + 1 ); //update count for subsequent appearances

                if ( map.get(s) != 1  &&  map.get(s) % 2 == 0 ) //if not first appearance and even count, concat onto returned String
                    str += s;
            }

        return str;
    }

    /**
     * Given an array of strings, return a Map<String, Boolean> where each different string is a key and its value is true if that string appears 2 or more times in the array.
     */
    public Map< String, Boolean > wordMultiple( String[] strings )
    {
        Map< String, Boolean > map = new HashMap();

        for ( String s : strings )
            if ( !map.containsKey( s ) ) //first instance and potentially only instance so set to false
                map.put( s, false );
            else
                map.put( s, true ); //as soon as second instance found can set to true and stay true for any other appearances

        return map;
    }

    /**
     * We'll say that 2 strings "match" if they are non-empty and their first chars are the same. Loop over and then return the given array of non-empty strings as follows: if a string matches an earlier string in the array, swap the 2 strings in the array. When a position in the array has been swapped, it no longer matches anything. Using a map, this can be solved making just one pass over the array. More difficult than it looks.
     */
    public String[] allSwap( String[] strings )
    {
        Map< String, Integer > map = new HashMap();

        for ( int i = 0  ;  i < strings.length  ;  i++ )
            if ( !map.containsKey( String.valueOf( strings[i].charAt(0) ) ) ) //place first instance w/ its index
                map.put( String.valueOf( strings[i].charAt(0) ), i );
            else
            {
                String temp = strings[i]; //for subsequent instance place value into temp var
                strings[i] = strings[ map.get( String.valueOf( strings[i].charAt(0) ) ) ]; //current index then equals value for its first appearance
                strings[ map.get( String.valueOf( strings[i].charAt(0) ) ) ] = temp; //then replace first instance with temp value
                map.remove( String.valueOf( strings[i].charAt(0) ) ); //remove current index value from map
            }

        return strings;
    }

    /**
     * We'll say that 2 strings "match" if they are non-empty and their first chars are the same. Loop over and then return the given array of non-empty strings as follows: if a string matches an earlier string in the array, swap the 2 strings in the array. A particular first char can only cause 1 swap, so once a char has caused a swap, its later swaps are disabled. Using a map, this can be solved making just one pass over the array. More difficult than it looks.
     */
    public String[] firstSwap( String[] strings )
    {
        Map< String, Integer > map = new HashMap();

        for ( int i = 0  ;  i < strings.length  ;  i++ )
            if ( !map.containsKey( String.valueOf( strings[i].charAt(0) ) ) ) //placing first instance of element value and its index
                map.put( String.valueOf( strings[i].charAt(0) ), i );
            else
            {
                int flag = map.get( String.valueOf( strings[i].charAt(0) ) ); //flag used to determine if one swap has happened, so further swaps are disabled

                if ( flag == -1 ) //only continue if flag not set, can't reverse condition and break as that moves straight to return statement
                    continue;

                int pos = map.get( String.valueOf( strings[i].charAt(0) ) ); //getting position of first appearance
                String temp = strings[pos]; //placing first appearance into temp var
                strings[pos] = strings[i]; //setting temp element to current
                strings[i] = temp ; //current element set to temp or first appearance, so swap now done

                map.put( String.valueOf( strings[i].charAt(0) ), -1 ); //override value on map to flag so swap does not happen again
            }

        return strings;
    }

}