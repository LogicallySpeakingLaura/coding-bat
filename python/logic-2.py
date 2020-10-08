"""
Author: LogicallySpeakingLaura
Date last modified: 2020/10/08
Medium boolean logic puzzles -- if else and or not.
https://codingbat.com/python/Logic-2
"""

def make_bricks(small, big, goal):
    """
    We want to make a row of bricks that is goal inches long. We have a number of small bricks (1 inch each) and big bricks (5 inches each). Return True if it is possible to make the goal by choosing from the given bricks.
    """
    # condition 1 - will remainder of length of goal after big bricks used be less than or equal to amount of small bricks
    # condition 2 - will length of both big and small bricks together at least equal the goal length, ok if bigger as can get rid of a brick
    return goal % 5 <= small and big * 5 + small >= goal


def lone_sum(a, b, c):
    """
    Given 3 int values, a b c, return their sum. However, if one of the values is the same as another of the values, it does not count towards the sum.
    """
    return 0 if a == b and b == c else c if a == b else b if a == c else a if b == c else a + b + c


def lucky_sum(a, b, c):
    """
    Given 3 int values, a b c, return their sum. However, if one of the values is 13 then it does not count towards the sum and values to its right do not count. So for example, if b is 13, then both b and c do not count.
    """
    return 0 if a == 13 else a if b == 13 else a + b if c == 13 else a + b + c


def no_teen_sum(a, b, c):
    """
    Given 3 int values, a b c, return their sum. However, if any of the values is a teen -- in the range 13..19 inclusive -- then that value counts as 0, except 15 and 16 do not count as a teens. Write a separate helper "def fix_teen(n):"that takes in an int value and returns that value fixed for the teen rule.
    """
    return fix_teen(a) + fix_teen(b) + fix_teen(c)

def fix_teen(n):
    return 0 if 13 <= n < 15 or 16 < n <= 19 else n # excluding 15 and 16 from teen range


def round_sum(a, b, c):
    """
    For this problem, we'll round an int value up to the next multiple of 10 if its rightmost digit is 5 or more, so 15 rounds up to 20. Alternately, round down to the previous multiple of 10 if its rightmost digit is less than 5, so 12 rounds down to 10. Given 3 ints, a b c, return the sum of their rounded values. To avoid code repetition, write a separate helper "def round10(num):" and call it 3 times.
    """
    return round10(a) + round10(b) + round10(c)

def round10(num): # rightmost digit less than 5, round down, round up
    return num - (num % 10) if num % 10 < 5 else num + (10 - (num % 10))


def close_far(a, b, c):
    """
    Given three ints, a b c, return True if one of b or c is "close" (differing from a by at most 1), while the other is "far", differing from both other values by 2 or more.
    """
    return ( abs( a - b ) <= 1 and abs( a - c ) >= 2 and abs(b - c) >= 2 ) or ( abs( a - c ) <= 1 and abs( a - b ) >= 2 and abs(b - c) >= 2 )


def make_chocolate(small, big, goal):
    """
    We want make a package of goal kilos of chocolate. We have small bars (1 kilo each) and big bars (5 kilos each). Return the number of small bars to use, assuming we always use big bars before small bars. Return -1 if it can't be done.
    """
    return goal % 5 if goal % 5 <= small and goal / 5 <= big else goal- big * 5 if goal / 5 > big and small >= ( goal - big * 5 ) else -1
