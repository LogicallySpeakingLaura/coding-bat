"""
Author: LogicallySpeakingLaura
Date last modified: 2020/10/18
Medium warmup string/list problems with loops.
https://codingbat.com/python/Warmup-2
"""

def string_times(str, n):
    """
    Given a string and a non-negative int n, return a larger string that is n copies of the original string.
    """
    return str * n


def front_times(str, n):
    """
    Given a string and a non-negative int n, we'll say that the front of the string is the first 3 chars, or whatever is there if the string is less than length 3. Return n copies of the front;
    """
    return str * n if len(str) < 3 else str[: 3] * n # check for length, return substring is longer than 3 chars


def string_bits(str):
    """
    Given a string, return a new string made of every other char starting with the first, so "Hello" yields "Hlo".
    """
    return ''.join(str[i] for i in range(0, len(str), 2)) # every second index starting at 0 is added to new return string


def string_splosion(str):
    """
    Given a non-empty string like "Code" return a string like "CCoCodCode".
    """
    return ''.join(str[: i + 1] for i in range(len(str)))  # pattern is 1, 12, 123, 1234, compound substring + 1 each time


def last2(str):
    """
    Given a string, return the count of the number of times that a substring length 2 appears in the string and also as the last 2 chars of the string, so "hixxxhi" yields 1 (we won't count the end substring).
    """
    return sum(1 for i in range(len(str) - 2) if str[i: i + 2] == str[-2:]) # exclude last 2 chars as we don't compare to that


def array_count9(nums):
    """
    Given an array of ints, return the number of 9's in the array.
    """
    return nums.count(9)


def array_front9(nums):
    """
    Given an array of ints, return True if one of the first 4 elements in the array is a 9. The array length may be less than 4.
    """
    return 9 in nums and nums.index(9) <= 3 # index where 9 is has to be 3 or less because index 3 == length 4


def array123(nums):
    """
    Given an array of ints, return True if the sequence of numbers 1, 2, 3 appears in the array somewhere.
    """
    has_seq = False

    for i in range(len(nums) - 2):
        if nums[i: i + 3] == [1, 2, 3]:  # do indexes i .. i + 3 equal 1, 2, 3
            has_seq = True
            break  # exit loop if condition met

    return has_seq #   return bool(True for i in range(len(nums) - 2) if nums[i: i + 3] == [1, 2, 3]) TODO figure out why won't work


def string_match(a, b):
    """
    Given 2 strings, a and b, return the number of the positions where they contain the same length 2 substring. So "xxcaazz" and "xxbaaz" yields 3, since the "xx", "aa", and "az" substrings appear in the same place in both strings.
    """
    return sum(1 for i in range(min(len(a), len(b)) - 1) if a[i: i + 2] == b[i: i + 2]) # can only loop for the length of smaller string