/**
 * @author LogicallySpeakingLaura
 * @version 2020/10/29
 * Functional mapping operations on lists with lambdas. The main computation for each of these problems can be done with 1 line of lambda code.
 * https://codingbat.com/java/Functional-1
 * NOTE - there will be two solutions for each problem, one for functional mapping and the other using streams.
 */
public class Functional1
{

    /**
     * Given a list of integers, return a list where each integer is multiplied by 2.
     */
    public List<Integer> doubling( List<Integer> nums )
    {
        nums.replaceAll( n  ->  n * 2 ); //replaces every element at all indexes with a doubled value
        return nums;
        //return nums.stream().map( n  ->  n * 2 ).collect( Collectors.toList() );
    }

    /**
     * Given a list of integers, return a list where each integer is multiplied with itself.
     */
    public List<Integer> square( List<Integer> nums )
    {
        nums.replaceAll( n  ->  n * n ); //replaces every element at all indexes with itself multiplied
        return nums;
        //return nums.stream().map( n  ->  n * n ).collect( Collectors.toList() );
    }

    /**
     * Given a list of strings, return a list where each string has "*" added at its end.
     */
    public List<String> addStar( List<String> strings )
    {
        strings.replaceAll( s  ->  s + "*" ); //adds a star to the end of every element
        return strings;
        //return strings.stream().map( s  ->  s + "*" ).collect( Collectors.toList() );
    }

    /**
     * Given a list of strings, return a list where each string is replaced by 3 copies of the string concatenated together.
     */
    public List<String> copies3( List<String> strings )
    {
        strings.replaceAll( s  ->  s + s + s ); //replaces each element with 3 copies of its values
        return strings;
        //return strings.stream().map( s  ->  s + s + s ).collect( Collectors.toList() );
    }

    /**
     * Given a list of strings, return a list where each string has "y" added at its start and end.
     */
    public List<String> moreY( List<String> strings )
    {
        strings.replaceAll( s  ->  "y" + s + "y" ); //replaces each element with its value sandwiched between 'y'
        return strings;
        //return strings.stream().map( s  ->  "y" + s + "y" ).collect( Collectors.toList() );
    }

    /**
     * Given a list of integers, return a list where each integer is added to 1 and the result is multiplied by 10.
     */
    public List<Integer> math1( List<Integer> nums )
    {
        nums.replaceAll( n  ->  ( n + 1 ) * 10 ); //replaces every element with itself incremented and multiplied by 10
        return nums;
        //return nums.stream().map( n  ->  ( n + 1 ) * 10 ).collect( Collectors.toList() );
    }

    /**
     * Given a list of non-negative integers, return an integer list of the rightmost digits. (Note: use %)
     */
    public List<Integer> rightDigit( List<Integer> nums )
    {
        nums.replaceAll( n  ->  n % 10 ); //replaces every element with its remainder when divided by 10
        return nums;
        //return nums.stream().map( n  ->  n % 10 ).collect( Collectors.toList() );
    }

    /**
     *
     Given a list of strings, return a list where each string is converted to lower case.
     */
    public List<String> lower( List<String> strings )
    {
        strings.replaceAll( s  ->  s.toLowerCase() ); //replaces every element with its value converted to lower case
        return strings;
        //return strings.stream().map( s  ->  s.toLowerCase() ).collect( Collectors.toList() );
    }

    /**
     * Given a list of strings, return a list where each string has all its "x" removed.
     */
    public List<String> noX( List<String> strings )
    {
        strings.replaceAll( s  ->  s.replaceAll( "x", "" ) );  //replaces every instance of 'x' for each element with nothing
        return strings;
        //return strings.stream().map( s  ->  s.replaceAll( "x", "" ) ).collect( Collectors.toList() );
    }

}