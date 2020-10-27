/**
 * @author LogicallySpeakingLaura
 * @version 2020/10/27
 * Functional mapping operations on lists with lambdas. The main computation for each of these problems can be done with 1 line of lambda code.
 * https://codingbat.com/java/Functional-1
 */
public class Functional1
{

    /**
     * Given a list of integers, return a list where each integer is multiplied by 2.
     */
    public List<Integer> doubling(List<Integer> nums)
    {
        nums.replaceAll( n -> n * 2 );

        return nums;
        //          return nums.stream().map(n -> n*2).collect(Collectors.toList());
    }

    /**
     * Given a list of integers, return a list where each integer is multiplied with itself.
     */
    public List<Integer> square( List<Integer> nums )
    {
        nums.replaceAll( n -> n * n );

        return nums;
        //        return nums.stream().map(n -> n*n).collect(Collectors.toList());
    }

    /**
     * Given a list of strings, return a list where each string has "*" added at its end.
     */
    public List<String> addStar( List<String> strings )
    {
        strings.replaceAll( n -> n + "*" );

        return strings;
        //      return strings.stream().map(s -> s + "*").collect(Collectors.toList());
    }

    /**
     * Given a list of strings, return a list where each string is replaced by 3 copies of the string concatenated together.
     */
    public List<String> copies3(List<String> strings)
    {
        strings.replaceAll( n -> n + n + n );

        return strings;
        //    return strings.stream().map(s -> s + s + s).collect(Collectors.toList());
    }

    /**
     * Given a list of strings, return a list where each string has "y" added at its start and end.
     */
    public List<String> moreY( List<String> strings )
    {
        strings.replaceAll( n -> "y" + n + "y" );

        return strings;
        //  return strings.stream().map(s -> "y" + s + "y").collect(Collectors.toList());
    }

    /**
     * Given a list of integers, return a list where each integer is added to 1 and the result is multiplied by 10.
     */
    public List<Integer> math1(List<Integer> nums) {
        nums.replaceAll( n -> (n+1)*10 );

        return nums;
        //       return nums.stream().map(n -> (n+1)*10).collect(Collectors.toList());
    }

    /**
     * Given a list of non-negative integers, return an integer list of the rightmost digits. (Note: use %)
     */
    public List<Integer> rightDigit(List<Integer> nums) {
        nums.replaceAll(n->n%10);
        return nums;
        //    return nums.stream().map(n -> n%10).collect(Collectors.toList());
    }

    /**
     *
     Given a list of strings, return a list where each string is converted to lower case.
     */
    public List<String> lower(List<String> strings) {
        strings.replaceAll( n->n.toLowerCase());
        return strings;
        //return strings.stream().map(s -> s.toLowerCase()).collect(Collectors.toList());
    }

    /**
     * Given a list of strings, return a list where each string has all its "x" removed.
     */
    public List<String> noX(List<String> strings) {
        strings.replaceAll( n->n.replaceAll("x",""));
        return strings;
        //return strings.stream().map(s -> s.replaceAll("x","")).collect(Collectors.toList());
    }

}
