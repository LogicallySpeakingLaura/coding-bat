"""
Author: LogicallySpeakingLaura
Date last modified: 2020/10/18
Medium python list problems -- 1 loop.
https://codingbat.com/python/List-2
"""

def count_evens(nums):
    """
    Return the number of even ints in the given array.
    """
    return sum(1 for i in range(len(nums)) if nums[i]%2 == 0) # only even if value%2 == 0


def big_diff(nums):
    """
    Given an array length 1 or more of ints, return the difference between the largest and smallest values in the array.
    """
    return max(nums) - min(nums) # max() finds biggest value in nums, min() finds smallest


def centered_average(nums):
    """
    Return the "centered" average of an array of ints, which we'll say is the mean average of the values, except ignoring the largest and smallest values in the array. If there are multiple copies of the smallest value, ignore just one copy, and likewise for the largest value. Use int division to produce the final average. You may assume that the array is length 3 or more.
    """
    return (sum(nums) - max(nums) - min(nums)) / (len(nums) - 2) # sum() adds all nums value, len(nums) - 2 to remove max and min values


def sum13(nums):
    """
    Return the sum of the numbers in the array, returning 0 for an empty array. Except the number 13 is very unlucky, so it does not count and numbers that come immediately after a 13 also do not count.
    """
    for i in range(len(nums)):

        if nums[i] == 13:
            nums[i] = 0 # change 13 to 0 so it doesn't affect sum

            if i + 1 < len(nums):
                nums[i + 1] = 0 # if not at end of list, change next index to 0

    return sum(nums)


def sum67(nums):
    """
    Return the sum of the numbers in the array, except ignore sections of numbers starting with a 6 and extending to the next 7 (every 6 will be followed by at least one 7). Return 0 for no numbers.
    """
    sum, flag = 0, False

    for i in range(len(nums)):
        if nums[i] == 6: # can't add if flag is true
            flag = True
        elif flag and nums[i] == 7: # set flag back to false
            flag = False
        elif not flag:
            sum += nums[i]

    return sum


def has22(nums):
    """
    Given an array of ints, return True if the array contains a 2 next to a 2 somewhere.
    """
    has2 = False

    for i in range(len(nums) - 1): # set bound
        if nums[i: i + 2] == [2, 2]:
            has2 = True
            break # return as soon as match found

    # return any(nums[i] == 2 and nums[ i + 1 ] == 2 for i in range(len(nums)-1)) - possible one line solution
    return has2

