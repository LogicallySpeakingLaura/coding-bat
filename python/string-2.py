"""
Author: LogicallySpeakingLaura
Date last modified: 2020/10/29
Medium python string problems -- 1 loop.
https://codingbat.com/python/String-2
"""

def double_char(str):
    """
    Given a string, return a string where for every char in the original, there are two chars.
    """
    return ''.join(char * 2 for char in str) # add another char of current char before moving onto next char


def count_hi(str):
    """
    Return the number of times that the string "hi" appears anywhere in the given string.
    """
    return str.count('hi') # count() finds any and all instance


def cat_dog(str):
    """
    Return True if the string "cat" and "dog" appear the same number of times in the given string.
    """
    return str.count('cat') == str.count('dog') # check equality of counts


def count_code(str):
    """
    Return the number of times that the string "code" appears anywhere in the given string, except we'll accept any letter for the 'd', so "cope" and "cooe" count.
    """
    return sum(1 for i in range(len(str) - 3) if str[i:i + 2] == 'co' and str[i + 3] == 'e') # 1 increases every time condition met


def end_other(a, b):
    """
    Given two strings, return True if either of the strings appears at the very end of the other string, ignoring upper/lower case differences (in other words, the computation should not be "case sensitive").
    """
    return b.lower().endswith( a.lower() ) or a.lower().endswith( b.lower() ) # check one option and its opposite


def xyz_there(str):
    """
    Return True if the given string contains an appearance of "xyz" where the xyz is not directly preceeded by a period (.). So "xxyz" counts but "x.xyz" does not.
    """
    return str.count('.xyz') != str.count('xyz') # as soon as a .xyz occurs or never occurs they don't evaluate the same