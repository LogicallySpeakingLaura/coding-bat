/**
 * @author LogicallySpeakingLaura
 * @version 2020/10/06
 * Basic boolean logic puzzles -- if else && || !.
 * https://codingbat.com/java/Logic-1
 */
public class Logic1
{

    /**
     * When squirrels get together for a party, they like to have cigars. A squirrel party is successful when the number of cigars is between 40 and 60, inclusive. Unless it is the weekend, in which case there is no upper bound on the number of cigars. Return true if the party with the given values is successful, or false otherwise.
     */
    public boolean cigarParty( int cigars, boolean isWeekend )
    {
        return ( cigars >= 40 && cigars <= 60 && !isWeekend ) || ( cigars >= 40 && isWeekend );
    }

    /**
     * You and your date are trying to get a table at a restaurant. The parameter "you" is the stylishness of your clothes, in the range 0..10, and "date" is the stylishness of your date's clothes. The result getting the table is encoded as an int value with 0=no, 1=maybe, 2=yes. If either of you is very stylish, 8 or more, then the result is 2 (yes). With the exception that if either of you has style of 2 or less, then the result is 0 (no). Otherwise the result is 1 (maybe).
     */
    public int dateFashion( int you, int date )
    {
        int table = 1; //assume maybe till style checked

        if( you >= 8 || date >= 8 ) //do not use if-else, both conditions need to be checked
            table = 2;

        if( you <= 2 || date <= 2 )
            table = 0;

        return table;
    }

    /**
     * The squirrels in Palo Alto spend most of the day playing. In particular, they play if the temperature is between 60 and 90 (inclusive). Unless it is summer, then the upper limit is 100 instead of 90. Given an int temperature and a boolean isSummer, return true if the squirrels play and false otherwise.
     */
    public boolean squirrelPlay( int temp, boolean isSummer )
    {
        return ( isSummer && temp >= 60 && temp <= 100 ) || ( !isSummer && temp >= 60 && temp <= 90 );
    }

    /**
     * You are driving a little too fast, and a police officer stops you. Write code to compute the result, encoded as an int value: 0=no ticket, 1=small ticket, 2=big ticket. If speed is 60 or less, the result is 0. If speed is between 61 and 80 inclusive, the result is 1. If speed is 81 or more, the result is 2. Unless it is your birthday -- on that day, your speed can be 5 higher in all cases.
     */
    public int caughtSpeeding( int speed, boolean isBirthday )
    {
        int ticket = 0;

        if( isBirthday )
        {
            if( speed >= 66 && speed <= 85 )
                ticket = 1;
            else if( speed > 85 ) //could do >= 86 if that logic is easier to understand
                ticket = 2;
        }       //first embedded if-else-if needs to be in {} otherwise it is not considered nested and will go to outer else
        else    //if there was no else stmt no need for braces, but there is so...
            if( speed >= 61 && speed <= 80 )
                ticket = 1;
            else if( speed > 80 )
                ticket = 2;

        return ticket;
    }

    /**
     * Given 2 ints, a and b, return their sum. However, sums in the range 10..19 inclusive, are forbidden, so in that case just return 20.
     */
    public int sortaSum(int a, int b)
    {
        return a + b >= 10 && a + b < 20 ? 20 : a + b; //could do <= 19 if that logic is easier to understand
    }

    /**
     * Given a day of the week encoded as 0=Sun, 1=Mon, 2=Tue, ...6=Sat, and a boolean indicating if we are on vacation, return a string of the form "7:00" indicating when the alarm clock should ring. Weekdays, the alarm should be "7:00" and on the weekend it should be "10:00". Unless we are on vacation -- then on weekdays it should be "10:00" and weekends it should be "off".
     */
    public String alarmClock( int day, boolean vacation )
    {
        String alarm = "10:00";

        if( vacation && ( day == 0 || day == 6 ) ) //is it a vacation and a weekend day
            alarm = "off";
        else if( !vacation && !( day == 0 || day == 6 ) ) //is it a weekday and no vacation
            alarm = "7:00";

        return alarm;
    }

    /**
     * The number 6 is a truly great number. Given two int values, a and b, return true if either one is 6. Or if their sum or difference is 6. Note: the function Math.abs(num) computes the absolute value of a number.
     */
    public boolean love6( int a, int b )
    {
        return a == 6 || b == 6 || a + b == 6 || Math.abs( a - b ) == 6;
    }

    /**
     * Given a number n, return true if n is in the range 1..10, inclusive. Unless outsideMode is true, in which case return true if the number is less or equal to 1, or greater or equal to 10.
     */
    public boolean in1To10( int n, boolean outsideMode )
    {
        return ( outsideMode && ( n <= 1 || n >= 10 ) ) || ( !outsideMode && n >= 1 && n <= 10 );
    }

    /**
     * We'll say a number is special if it is a multiple of 11 or if it is one more than a multiple of 11. Return true if the given non-negative number is special.
     */
    public boolean specialEleven( int n )
    {
        return n % 11 == 0 || ( n - 1 ) % 11 == 0;
    }

    /**
     * Return true if the given non-negative number is 1 or 2 more than a multiple of 20.
     */
    public boolean more20( int n )
    {
        return ( n - 1 ) % 20 == 0 || ( n - 2 ) % 20 == 0;
    }

    /**
     * Return true if the given non-negative number is a multiple of 3 or 5, but not both. Use the % "mod" operator -- see Introduction to Mod
     */
    public boolean old35( int n )
    {
        //first OR checks for either or so one will match, AND checks to make sure a second doesn't match
        return ( n % 3 == 0 || n % 5 == 0 ) && !( n % 3 == 0 && n % 5 == 0 );
    }

    /**
     * Return true if the given non-negative number is 1 or 2 less than a multiple of 20. So for example 38 and 39 return true, but 40 returns false.
     */
    public boolean less20( int n )
    {
        return ( n + 1 ) % 20 == 0 || ( n + 2 ) % 20 == 0;
    }

    /**
     * Given a non-negative number "num", return true if num is within 2 of a multiple of 10.
     */
    public boolean nearTen( int num )
    {
        return num % 10 <= 2 || num % 10 >= 8; //want result to equal 1, 2, 8 or 9
    }

    /**
     * Given 2 ints, a and b, return their sum. However, "teen" values in the range 13..19 inclusive, are extra lucky. So if either value is a teen, just return 19.
     */
    public int teenSum( int a, int b )
    {
        return ( a >= 13 && a <= 19 ) || ( b >= 13 && b <= 19 ) ? 19 : a + b;
    }

    /**
     * Your cell phone rings. Return true if you should answer it. Normally you answer, except in the morning you only answer if it is your mom calling. In all cases, if you are asleep, you do not answer.
     */
    public boolean answerCell( boolean isMorning, boolean isMom, boolean isAsleep )
    {
            //must be awake, if it's morning only if mom, else must be not morning
        return !isAsleep && ( ( isMorning && isMom ) || !isMorning );
    }

    /**
     * We are having a party with amounts of tea and candy. Return the int outcome of the party encoded as 0=bad, 1=good, or 2=great. A party is good (1) if both tea and candy are at least 5. However, if either tea or candy is at least double the amount of the other one, the party is great (2). However, in all cases, if either tea or candy is less than 5, the party is always bad (0).
     */
    public int teaParty( int tea, int candy )
    {
        int outcome = 1; //assume party is good, both at least 5

        if( tea * 2 <= candy || candy * 2 <= tea ) //check to see if great first, can still be double if other is less than 5
            outcome = 2;

        if( tea < 5 || candy < 5 ) //check to see if bad
            outcome = 0;

        return outcome;
    }

    /**
     * Given a string str, if the string starts with "f" return "Fizz". If the string ends with "b" return "Buzz". If both the "f" and "b" conditions are true, return "FizzBuzz".
     */
    public String fizzString( String str )
    {
        if( str.startsWith( "f" ) && str.endsWith( "b" ) ) //order of conditions important, if this written last but it's true it will never be evaluated
            str = "FizzBuzz";
        else if( str.startsWith( "f" ) )
            str = "Fizz";
        else if( str.endsWith( "b" ) )
            str = "Buzz";

        return str;
    }

    /**
     * Given an int n, return the string form of the number followed by "!". So the int 6 yields "6!". Except if the number is divisible by 3 use "Fizz" instead of the number, and if the number is divisible by 5 use "Buzz", and if divisible by both 3 and 5, use "FizzBuzz".
     */
    public String fizzString2( int n )
    {
        String str;

        if( n % 3 == 0 && n % 5 == 0 ) //order of conditions important, if this written last but it's true it will never be evaluated
            str = "FizzBuzz!";
        else if( n % 3 == 0)
            str = "Fizz!";
        else if( n % 5 == 0 )
            str = "Buzz!";
        else
            str = n + "!";

        return str;
    }

    /**
     * Given three ints, a b c, return true if it is possible to add two of the ints to get the third.
     */
    public boolean twoAsOne( int a, int b, int c )
    {
        return a + b == c || a + c == b || b + c == a;
    }

    /**
     * Given three ints, a b c, return true if b is greater than a, and c is greater than b. However, with the exception that if "bOk" is true, b does not need to be greater than a.
     */
    public boolean inOrder( int a, int b, int c, boolean bOk )
    {
        return ( bOk && c > b ) || ( !bOk && b > a && c > b );
    }

    /**
     * Given three ints, a b c, return true if they are in strict increasing order, such as 2 5 11, or 5 6 7, but not 6 5 7 or 5 5 7. However, with the exception that if "equalOk" is true, equality is allowed, such as 5 5 7 or 5 5 5.
     */
    public boolean inOrderEqual( int a, int b, int c, boolean equalOk )
    {
        return ( !equalOk && a < b && b < c ) || ( equalOk && a <= b && b <= c ); //no need to compare a with c as using &&
    }

    /**
     * Given three ints, a b c, return true if two or more of them have the same rightmost digit. The ints are non-negative.
     */
    public boolean lastDigit( int a, int b, int c )
    {
        return a % 10 == b % 10 || a % 10 == c % 10 || b % 10 == c % 10;
    }

    /**
     * Given three ints, a b c, return true if one of them is 10 or more less than one of the others.
     */
    public boolean lessBy10( int a, int b, int c )
    {
        return Math.abs( a - b ) >= 10 || Math.abs( a - c ) >= 10 || Math.abs( b - c ) >= 10;

    }

    /**
     * Return the sum of two 6-sided dice rolls, each in the range 1..6. However, if noDoubles is true, if the two dice show the same value, increment one die to the next value, wrapping around to 1 if its value was 6.
     */
    public int withoutDoubles( int die1, int die2, boolean noDoubles )
    {
        if( noDoubles && die1 == die2 ) //noDoubles can be true and the die have different values, check for equality
            if( die1 == 6 )
                die1 = 1 + die2;
            else
                die1 = ( die1 + 1 ) + die2;
        else
            die1 += die2;

        return die1;
    }

    /**
     * Given two int values, return whichever value is larger. However if the two values have the same remainder when divided by 5, then the return the smaller value. However, in all cases, if the two values are the same, return 0.
     */
    public int maxMod5( int a, int b )
    {
        if( a == b ) //check for same value first as this has higher priority than % 5
            a = 0;
        else if( a % 5 == b % 5 )
            a = Math.min( a, b );
        else
            a = Math.max( a, b );

        return a;
    }

    /**
     * You have a red lottery ticket showing ints a, b, and c, each of which is 0, 1, or 2. If they are all the value 2, the result is 10. Otherwise if they are all the same, the result is 5. Otherwise so long as both b and c are different from a, the result is 1. Otherwise the result is 0.
     */
    public int redTicket( int a, int b, int c )
    {
        if( a == 2 && b == 2 && c == 2 ) //check this before same value, value can be same and not 2 giving different result
            a = 10;
        else if( a == b && b == c ) //same value but value is not 2
            a = 5;
        else if( a != b && a != c ) //b and c different from a
            a = 1;
        else
            a = 0;

        return a;
    }

    /**
     * You have a green lottery ticket, with ints a, b, and c on it. If the numbers are all different from each other, the result is 0. If all of the numbers are the same, the result is 20. If two of the numbers are the same, the result is 10.
     */
    public int greenTicket( int a, int b, int c )
    {
        if( a == b && b == c ) //all same
            a = 20;
        else if( a == b || a == c || b == c ) //2 same
            a = 10;
        else if( a != b && a != c && b != c ) //all different
            a = 0;

        return a;
    }

    /**
     * You have a blue lottery ticket, with ints a, b, and c on it. This makes three pairs, which we'll call ab, bc, and ac. Consider the sum of the numbers in each pair. If any pair sums to exactly 10, the result is 10. Otherwise if the ab sum is exactly 10 more than either bc or ac sums, the result is 5. Otherwise the result is 0.
     */
    public int blueTicket( int a, int b, int c )
    {
        if( a + b == 10 || b + c == 10 || a + c == 10 ) //all equal 10
            a = 10;
        else if( a + b == b + c + 10 || a + b == a + c + 10 ) //question is not absolute sum, but the sum of a + b is 10 more than other sums
            a = 5;
        else
            a = 0;

        return a;
    }

    /**
     * Given two ints, each in the range 10..99, return true if there is a digit that appears in both numbers, such as the 2 in 12 and 23.
     */
    public boolean shareDigit( int a, int b )
    {
            //first a to first b, first a to second b, second a to first b, second a to second b
        return a / 10 == b / 10 || a / 10 == b % 10 || a % 10 == b / 10 || a % 10 == b % 10;
    }

    /**
     * Given 2 non-negative ints, a and b, return their sum, so long as the sum has the same number of digits as a. If the sum has more digits than a, just return a without b.
     */
    public int sumLimit( int a, int b )
    {
        return String.valueOf( a + b ).length() > String.valueOf(a).length() ? a : a + b; //String.valueOf(x).length() counts number of digits in an int
    }

}
