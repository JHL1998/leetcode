package stackAndQueue;

import java.util.Stack;

/**
 * 42、接雨水
 */
public class Main42 {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            int last = 0;
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                int cur = stack.peek();
                stack.pop();
                res += (i - cur - 1) * (height[cur] - last);
                last = height[cur];
            }
            if (!stack.isEmpty()) res += (i - stack.peek() - 1) * (height[i] - last);
            stack.push(i);
        }
        return res;

    }
}
