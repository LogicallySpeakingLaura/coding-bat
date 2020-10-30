/**
 * @author LogicallySpeakingLaura
 * @version 2020/10/29
 * Functional mapping operations on lists with lambdas. The main computation for each of these problems can be done with 1 or 2 lines of lambda code.
 * https://codingbat.com/java/Functional-2
 * NOTE - there will be two solutions for each problem, one for functional mapping and the other using streams.
 * HINT - Stream solution is essentially the opposite of the functional solutions.
 */
public class Functional2
{

    /**
     * Given a list of integers, return a list of the integers, omitting any that are less than 0.
     */
    public List<Integer> noNeg( List<Integer> nums )
    {
        nums.removeIf( n  ->  n < 0 ); //removes any element that is less than 0
        return nums;
        //return nums.stream().filter( n  ->  n >= 0 ).collect( Collectors.toList() ); only returns elements bigger than or equal to 0
    }

    /**
     * Given a list of non-negative integers, return a list of those numbers except omitting any that end with 9.
     */
    public List<Integer> no9( List<Integer> nums )
    {
         nums.removeIf( n  ->  n % 10 == 9 ); //removes any element that doesn't end in 9
         return nums;
        //return nums.stream().filter( n  ->  n % 10 != 9 ).collect( Collectors.toList() ); only returns elements that don't end in 9
    }

    /**
     * Given a list of integers, return a list of those numbers, omitting any that are between 13 and 19 inclusive.
     */
    public List<Integer> noTeen( List<Integer> nums )
    {
         nums.removeIf( n  ->  13 <= n  &&  n <= 19 ); //removes any element in given range
         return nums;
         //return nums.stream().filter( n  ->  n < 13  ||  19 < n ).collect( Collectors.toList() ); only returns elements outside of range
    }

    /**
     *
     Given a list of strings, return a list of the strings, omitting any string that contains a "z".
     */
    public List<String> noZ( List<String> strings )
    {
        strings.removeIf( s  ->  s.contains( "z" ) ); //removes any element containing 'z'
        return strings;
        //return strings.stream().filter( s  ->  !s.contains( "z" ) ).collect( Collectors.toList() ); only returns elements that don't have a 'z'
    }

    /**
     * Given a list of strings, return a list of the strings, omitting any string length 4 or more.
     */
    public List<String> noLong( List<String> strings )
    {
        strings.removeIf( s  ->  s.length() >= 4 ); //remove elements with a length of 4 or more
        return strings;
        //return strings.stream().filter( s  ->  s.length() < 4 ).collect( Collectors.toList() ); only return elements with a length less than 4
    }

    /**
     * Given a list of strings, return a list of the strings, omitting any string length 3 or 4.
     */
    public List<String> no34( List<String> strings )
    {
        strings.removeIf( s  ->  s.length() == 4  ||  s.length() == 3 ); //remove elements with lengths of 3 or 4
        return strings;
        //return strings.stream().filter( s  ->  s.length() != 4  &&  s.length() != 3 ).collect( Collectors.toList() ); return elements that don't have prohibited length
    }

    /**
     * Given a list of strings, return a list where each string has "y" added at its end, omitting any resulting strings that contain "yy" as a substring anywhere.
     */
    public List<String> noYY( List<String> strings )
    {
        strings.replaceAll( s  ->  s + "y" ); //adds 'y' to each element
        strings.removeIf( s  ->  s.contains( "yy" ) ); //removes elements that have 'yy'
        return strings;
        //return strings.stream().map( s  ->  s + "y" ).filter( s  ->  !s.contains("yy") ).collect( Collectors.toList() ); after adding 'y' only returns elements that aren't doubled
    }

    /**
     * Given a list of non-negative integers, return a list of those numbers multiplied by 2, omitting any of the resulting numbers that end in 2.
     */
    public List<Integer> two2( List<Integer> nums )
    {
        nums.replaceAll( n  ->  n * 2 ); //replace each element with itself doubled
        nums.removeIf( n  ->  n % 10 == 2 ); //remove elements that end in 2
        return nums;
        //return nums.stream().map( n  ->  n * 2 ).filter( n  ->  n % 10 != 2 ).collect( Collectors.toList() ); after doubling only return elements that don't end in 2
    }

    /**
     * Given a list of integers, return a list of those numbers squared and the product added to 10, omitting any of the resulting numbers that end in 5 or 6.
     */
    public List<Integer> square56( List<Integer> nums )
    {
        nums.replaceAll( n  ->  ( n * n ) + 10 ); //replace each element with element multiplied by itself and 10 added
        nums.removeIf( n  ->  n % 10 == 5  ||  n % 10 == 6 ); //removes elements ending in 5 or 5
        return nums;
        //return nums.stream().map( n  ->  ( n * n ) + 10 ).filter( n  ->  n % 10 != 5  &&  n % 10 != 6 ).collect( Collectors.toList() ); //after elements replaced only return those not ending in 5 or 6
    }

}