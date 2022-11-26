public class MinDistance {

    private static int solve;

    public static int solve(String A) {
        char[] inpArr = A.toCharArray();
        int lastX = -1, lastO = -1, minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < inpArr.length; i++) {
            if (inpArr[i] == 'x') {
                if (lastO != -1)
                    minDistance = Math.min(minDistance, i - lastO);

                lastX = i;

            }

            else if (inpArr[i] == 'o') {
                if (lastX != -1)
                    minDistance = Math.min(minDistance, i - lastX);

                lastO = i;

            }

        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    public static void main(String[] args) {
        String A = "x...o.x...o";
        solve = solve(A);
        System.out.println(solve);
    }
}
