//Time Complexity-O(n*m)
//Space Complexity-O(n)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length==0||envelopes==null||
          envelopes[0].length==0)
        {
            return 0;
        }
        int max=1;
        Arrays.sort(envelopes,(a,b)->a[0]-b[0]);
        int[]dp=new int[envelopes.length];
        Arrays.fill(dp,1);
        for(int i=1;i<dp.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(envelopes[i][1]>envelopes[j][1]&&envelopes[i][0]!=envelopes[j][0])
                {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    max=Math.max(max,dp[i]);
                }
            }
        }
        return max;
        
    }
}