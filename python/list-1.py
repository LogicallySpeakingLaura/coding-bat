"""
Author: LogicallySpeakingLaura
Date last modified: 2020/10/05
Basic python list problems -- no loops.
https://codingbat.com/python/List-1
"""

def first_last6(nums):
    """
    Given an array of ints, return True if 6 appears as either the first or last element in the array. The array will be length 1 or more.
    """
    return nums[0] == 6 or nums[ len(nums) - 1 ] == 6
