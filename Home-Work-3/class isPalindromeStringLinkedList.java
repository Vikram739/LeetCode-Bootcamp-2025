class isPalindromeStringLinkedList {
    public boolean isPalindrome(ListNode head) {
        List<Integer> listVals = new ArrayList<>();
        while (head != null) {
            listVals.add(head.val);
            head = head.next;
        }
        
        int left = 0, right = listVals.size() - 1;
        while (left < right && listVals.get(left).equals(listVals.get(right))) {
            left++;
            right--;
        }
        return left >= right;
    }
}