"""
Author: LogicallySpeakingLaura
Date last modified: 2020/10/08
Medium python string problems -- 1 loop.
https://codingbat.com/python/String-2
"""

def double_char(str):
    """
    Given a string, return a string where for every char in the original, there are two chars.
    """
    rtrn = ""

    for i in range(len(str)):
        rtrn += str[i : i + 1] * 2 # add two of the same char

    return rtrn


def count_hi(str):
    count = 0

    for i in range(len(str) - 1):
        if str[i: i + 2] == 'hi':
            count += 1

    return count