"""
Author: LogicallySpeakingLaura
Date last modified: 2020/10/05
Simple warmup problems to get started.
https://codingbat.com/python/Warmup-1
"""


def sleep_in(weekday, vacation):
    """
    The parameter weekday is True if it is a weekday, and the parameter vacation is True if we are on vacation. We
    sleep in if it is not a weekday or we're on vacation. Return True if we sleep in.
    """
    return not weekday or vacation  # it's not a weekday and on vacation


def monkey_trouble(a_smile, b_smile):
    """
    We have two monkeys, a and b, and the parameters a_smile and b_smile indicate if each is smiling. We are in
    trouble if they are both smiling or if neither of them is smiling. Return True if we are in trouble.
    """
    return a_smile == b_smile  # monkeys are the same, so either both smiling or not


def sum_double(a, b):
    """
    Given two int values, return their sum. Unless the two values are the same, then return double their sum.
    """
    return (a + b) * 2 if a == b else a + b  # only return double sum if a and b are the same


def diff21(n):
    """
    Given an int n, return the absolute difference between n and 21, except return double the absolute difference if n is over 21.
    """
    return abs(21 - n) if n < 21 else 2 * abs(n - 21)  # flip ints if n is smaller than 21


def parrot_trouble(talking, hour):
    """
    We have a loud talking parrot. The "hour" parameter is the current hour time in the range 0..23. We are in
    trouble if the parrot is talking and the hour is before 7 or after 20. Return True if we are in trouble.
    """
    return talking and (hour < 7 or hour > 20)  # parrot is talking before 7 and after 20, so trouble...


def makes10(a, b):
    """
    Given 2 ints, a and b, return True if one if them is 10 or if their sum is 10.
    """
    return a + b == 10 or a == 10 or b == 10  # only one of the conditions needs to be met


def near_hundred(n):
    """
    Given an int n, return True if it is within 10 of 100 or 200. Note: abs(num) computes the absolute value of a number.
    """
    return abs(100 - n) <= 10 or abs(200 - n) <= 10  # only one of the conditions needs to be met


def pos_neg(a, b, negative):
    """
    Given 2 int values, return True if one is negative and one is positive. Except if the parameter "negative" is 
    true, then return True only if both are negative. 
    """                                                     # a pos * neg must equal a neg num, otherwise they are
    return a * b < 0 if not negative else a < 0 and b < 0  # both pos or neg, negative is true in the else condition


def not_string(str):
    """
    Given a string, return a new string where "not " has been added to the front. However, if the string already
    begins with "not", return the string unchanged.
    """
    return str if str.startswith('not') else 'not ' + str  # assume all strings are at least 3 letters


def missing_char(str, n):
    """
    Given a non-empty string and an int n, return a new string where the char at index n has been removed. The value
    of n will be a valid index of a char in the original string (i.e. n will be in the range 0..len(str)-1 inclusive).
    """
    return str[: n] + str[n + 1:]  # first string is up to n not inclusive, second is one letter after n to length of string


def front_back(str):
    """
    Given a string, return a new string where the first and last chars have been exchanged.
    """
    return str if len(str) <= 1 else str[-1] + str[1: -1] + str[0] # check for length first, otherwise last + middle + first


def front3(str):
    """
    Given a string, we'll say that the front is the first 3 chars of the string. If the string length is less than 3, 
    the front is whatever is there. Return a new string which is 3 copies of the front. 
    """
    return str[: 3] * 3 if len(str) > 3 else str * 3 # check for length before splitting and building string