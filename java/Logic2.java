/**
 * @author LogicallySpeakingLaura
 * @version 2020/10/07
 * Medium boolean logic puzzles -- if else && || !.
 * https://codingbat.com/java/Logic-2
 */
public class Logic2
{

    /**
     * We want to make a row of bricks that is goal inches long. We have a number of small bricks (1 inch each) and big bricks (5 inches each). Return true if it is possible to make the goal by choosing from the given bricks.
     */
    public boolean makeBricks( int small, int big, int goal )
    {
        //condition 1 - will remainder of length of goal after big bricks used be less than or equal to amount of small bricks
        //condition 2 - will length of both big and small bricks together at least equal the goal length, ok if bigger as can get rid of a brick
        return goal % 5 <= small && big * 5 + small >= goal;
    }

    /**
     * Given 3 int values, a b c, return their sum. However, if one of the values is the same as another of the values, it does not count towards the sum.
     */
    public int loneSum( int a, int b, int c )
    {
        //all values same so none count, a = b so just c, a = c so just b, b = a so just a, all different so return sum
        return ( a == b && b == c ) ? 0 : ( a == b ) ? c : ( a == c ) ? b : ( b == c ) ? a : a + b + c;
    }

}
