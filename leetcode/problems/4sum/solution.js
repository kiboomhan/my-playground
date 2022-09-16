

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[][]}
 */
var fourSum = function(nums, target) {
    let result = [];

    let tg = nums.sort();
    let a = 0, b = 1, c = 2, d = 3;
    let aa, bb, cc, dd;
    let dupObj = {};
    while(true) {
        // console.log(a, b, c, d);
        aa = nums[a], bb = nums[b], cc = nums[c], dd = nums[d];

        if(aa+bb+cc+dd === target && !dupObj[[aa,bb,cc,dd].sort((a,b) => a-b).join('')]) {
            result.push([aa,bb,cc,dd].sort((a,b) => a-b));
            dupObj[[aa,bb,cc,dd].sort((a,b) => a-b).join('')] = 1;
        }
        d++;

        if(d >= (nums.length-0) ) c++;
        if(c >= (nums.length-1) ) b++;
        if(b >= (nums.length-2) ) a++;
        if(a >= (nums.length-3) ) break;

        if(b >= (nums.length-2) ) b=a+1;
        if(c >= (nums.length-1) ) c=b+1;
        if(d >= (nums.length-0) ) d=c+1;
    }
    return result;
};


let r;
r = fourSum([1,0,-1,0,-2,2], 0); console.log(r);
r = fourSum([2,2,2,2,2], 8); console.log(r);