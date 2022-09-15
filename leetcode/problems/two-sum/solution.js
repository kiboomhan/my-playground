/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    let map = {},
        diff;

    for(let i = 0; i < nums.length; i++){
        diff = target - nums[i];
        if(map.hasOwnProperty(diff)) {
            return [map[diff], i];
        }
        map[nums[i]] = i;
    }
    return null;
};

// test
console.log(twoSum([2,7,11,15], 9));
console.log(twoSum([3,2,4], 6));
console.log(twoSum([3,3], 6));