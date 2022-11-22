class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        Stack<Integer> monotoneStack = new Stack<>();

        for (int i = 0; i < nums1.length; i++) {
            hm.put(nums1[i], i);
        }

        for (int i = nums2.length - 1; i >= 0; i--) {
            if (monotoneStack.isEmpty()) {
                monotoneStack.push(nums2[i]);

                if (hm.containsKey(nums2[i])) nums1[hm.get(nums2[i])] = -1;
            } else if (nums2[i] > monotoneStack.peek()) {
                while (!monotoneStack.isEmpty() && nums2[i] > monotoneStack.peek()) {
                    monotoneStack.pop();
                }

                if (!monotoneStack.isEmpty()) {
                    if (hm.containsKey(nums2[i])) {
                        nums1[hm.get(nums2[i])] = monotoneStack.peek();
                    }
                } else {
                    if (hm.containsKey(nums2[i])) {
                        nums1[hm.get(nums2[i])] = -1;
                    }
                }

                monotoneStack.push(nums2[i]);
            } else if (nums2[i] < monotoneStack.peek()) {
                if (hm.containsKey(nums2[i])) {
                    nums1[hm.get(nums2[i])] = monotoneStack.peek();
                }

                monotoneStack.push(nums2[i]);
            }
        }

        return nums1;
    }
}
//     public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//         Map<Integer, Integer> hm = new HashMap<>();
//         for(int i=0; i<nums2.length; i++) {
//            hm.put(nums2[i], i);
//         }
//         for(int i=0; i<nums1.length; i++) {
//             int j = hm.get(nums1[i]);
//             int val = nums2[j];
//             boolean flag = false;
//             for(; j<nums2.length-1; j++) {
//                 if(nums2[j+1] > val) {
//                     nums1[i] = nums2[j+1];
//                     flag = true;
//                     break;
//                 }
//             }
//             if(flag == false) {
//                 nums1[i] = -1;
//             }
//         }
//         return nums1;
//     }
// }
