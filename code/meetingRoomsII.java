class Solution {
    /*
         https://leetcode.com/problems/meeting-rooms-ii/
         
         n: array size
         time: O(n log n) -- sort based on start time + original iteration O(n log n) since we extract from min heap in each iter
         space: O(n)
              worst case: need a room for each meeting, min heap grows to n
    */
    public int minMeetingRooms(int[][] intervals) {
        int roomsNeeded = 0;
        
        // should return earliest ending meeting when popped
        PriorityQueue<Integer> minHeapForEndTimes = 
            new PriorityQueue<>();
        
        // sort based on start times
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        for(int[] interval: intervals) {
            // there is a room when meeting ends before this starts
            // reuse the room
            if( !minHeapForEndTimes.isEmpty() && minHeapForEndTimes.peek() <= interval[0]) {
                minHeapForEndTimes.remove();
                minHeapForEndTimes.add(interval[1]);
            }
            
            // need a new room
            else {
                roomsNeeded++;
                minHeapForEndTimes.add(interval[1]);
            }
        }
        
        return roomsNeeded;
    }
}
