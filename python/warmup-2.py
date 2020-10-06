"""
Author: LogicallySpeakingLaura
Date last modified: 2020/10/04
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
    """ # check for length, return substring is longer than 3 chars
    return str * n if len(str) < 3 else str[: 3] * n


def string_bits(str):
    """
    Given a string, return a new string made of every other char starting with the first, so "Hello" yields "Hlo".
    """
    bits = ''

    for i in range(0, len(str), 2):  # use 2 to skip every other char, i + 2
        bits += str[i]

    return bits


def string_splosion(str):
    """
    Given a non-empty string like "Code" return a string like "CCoCodCode".
    """
    splosion = ''

    for i in range(len(str)):  # pattern is 1, 12, 123, 1234
        splosion += str[: i + 1]  # compound a new char each loop

    return splosion


def last2(str):
    """
    Given a string, return the count of the number of times that a substring length 2 appears in the string and also as the last 2 chars of the string, so "hixxxhi" yields 1 (we won't count the end substring).
    """
    count = 0

    for i in range(len(str) - 2):  # exclude last 2 chars as we don't compare to that
        if str[i: i + 2] == str[-2:]:  # check for index matches against last 2 chars
            count += 1

    return count


def array_count9(nums):
    """
    Given an array of ints, return the number of 9's in the array.
    """
    count = 0

    for i in nums:
        if i == 9:
            count += 1

    return count


def array_front9(nums):
    """
    Given an array of ints, return True if one of the first 4 elements in the array is a 9. The array length may be less than 4.
    """
    has9 = False

    for i in nums[: 4]:  # if array is less than 4, loop will stop
        if i == 9:
            has9 = True
            break  # exit loop if condition met

    return has9


def array123(nums):
    """
    Given an array of ints, return True if the sequence of numbers 1, 2, 3 appears in the array somewhere.
    """
    has_seq = False

    for i in range(len(nums) - 2):
        if nums[i: i + 3] == [1, 2, 3]:  # do indexes i .. i + 3 equal 1, 2, 3
            has_seq = True
            break  # exit loop if condition met

    return has_seq


def string_match(a, b):
    """
    Given 2 strings, a and b, return the number of the positions where they contain the same length 2 substring. So "xxcaazz" and "xxbaaz" yields 3, since the "xx", "aa", and "az" substrings appear in the same place in both strings.
    """
    count = 0
    smaller = min(len(a), len(b))  # find smaller string for iterations so not going out of bounds

    for i in range(smaller - 1):
        if a[i: i + 2] == b[i: i + 2]:
            count += 1

    return count
