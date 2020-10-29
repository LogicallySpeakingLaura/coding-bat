/**
 * @author LogicallySpeakingLaura
 * @version 2020/10/28
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
        return goal % 5 <= small  &&  big * 5 + small >= goal;
    }

    /**
     * Given 3 int values, a b c, return their sum. However, if one of the values is the same as another of the values, it does not count towards the sum.
     */
    public int loneSum( int a, int b, int c )
    {
        return a == b  &&  b == c  ?  0  : //all values same so none count
                a == b  ?  c  : //a = b so just c
                        a == c  ?  b  : //a = c so just b
                                b == c  ?  a  : a + b + c; //b = a so just a, else all different so return sum
    }

    /**
     * Given 3 int values, a b c, return their sum. However, if one of the values is 13 then it does not count towards the sum and values to its right do not count. So for example, if b is 13, then both b and c do not count.
     */
    public int luckySum( int a, int b, int c )
    {
        return a == 13  ?  0  : //a is 13 exclude b and c
                b == 13  ?  a  : //b is 13 only return a
                        c == 13  ?  a + b  :  a + b + c; //c is 13 return sum of a + b, else sum of all
    }

    /**
     * Given 3 int values, a b c, return their sum. However, if any of the values is a teen -- in the range 13..19 inclusive -- then that value counts as 0, except 15 and 16 do not count as a teens. Write a separate helper "public int fixTeen(int n) {"that takes in an int value and returns that value fixed for the teen rule.
     */
    public int noTeenSum( int a, int b, int c )
    {
        return fixTeen(a) + fixTeen(b) + fixTeen(c);
    }
    public int fixTeen( int n )
    {
        return 13 <= n  &&  n < 15   ||   16 < n  &&  n <= 19  ?  0  :  n; //excluding 15 and 16 from teen range
    }

    /**
     * For this problem, we'll round an int value up to the next multiple of 10 if its rightmost digit is 5 or more, so 15 rounds up to 20. Alternately, round down to the previous multiple of 10 if its rightmost digit is less than 5, so 12 rounds down to 10. Given 3 ints, a b c, return the sum of their rounded values. To avoid code repetition, write a separate helper "public int round10(int num) {" and call it 3 times.
     */
    public int roundSum( int a, int b, int c )
    {
        return round10(a) + round10(b) + round10(c);
    }
    public int round10( int num )
    {
        return num % 10 < 5  ?  num - ( num % 10 )  :  num + ( 10 - ( num % 10 ) ); //rightmost digit less than 5, round down, round up
    }

    /**
     * Given three ints, a b c, return true if one of b or c is "close" (differing from a by at most 1), while the other is "far", differing from both other values by 2 or more.
     */
    public boolean closeFar( int a, int b, int c )
    {
        return Math.abs( a - b ) <= 1  &&  Math.abs( a - c ) >= 2  &&  Math.abs(b - c) >= 2   || //b is close, c is far and c is far from b
                Math.abs( a - c ) <= 1  &&  Math.abs( a - b ) >= 2  &&  Math.abs(b - c) >= 2; //c is close, b is far, and c is far from b
    }

    /**
     * Given 2 int values greater than 0, return whichever value is nearest to 21 without going over. Return 0 if they both go over.
     */
    public int blackjack( int a, int b )
    {
        return a > 21  &&  b > 21  ?  0  : //both over 21
                a > 21  ?  b  :  b > 21  ?  a  : //if a or b is over 21 but not other
                                21 - a > 21 - b  ?  b : a; //else which is closest
    }

    /**
     * Given three ints, a b c, one of them is small, one is medium and one is large. Return true if the three values are evenly spaced, so the difference between small and medium is the same as the difference between medium and large.
     */
    public boolean evenlySpaced( int a, int b, int c )
    {
        return a + b == 2 * c  ||  a + c == 2 * b  ||  b + c == 2 * a; //1 + 2 == 2 * 3 not spaced, 2 + 6 == 4 * 2 is spaced, run the math probability
    }

    /**
     * We want make a package of goal kilos of chocolate. We have small bars (1 kilo each) and big bars (5 kilos each). Return the number of small bars to use, assuming we always use big bars before small bars. Return -1 if it can't be done.
     */
    public int makeChocolate( int small, int big, int goal )
    {
        return goal % 5 <= small  &&  goal / 5 <= big  ?  goal % 5  :
                goal / 5 > big  &&  small >= ( goal - big * 5 )  ?  goal- big * 5  :  -1; //similar logic for makeBricks
    }

}