package KMP;

public class kmpNext {
    public static void main(String[] args) {
        String str = "99900abciohoabc00abdabcdfef";
        String dest = "abcd";
        int[]next = kmpNext(dest);
        System.out.println(kmp(str,dest,next)); //20
    }

    public static int[] kmpNext(String dest){
        int[] next = new int[dest.length()];
        next[0] =0;
        //退出next
        for (int i = 1,j = 0; i < dest.length(); i++) {
            //3
            while (j>0 && dest.charAt(j) != dest.charAt(i)){
                j = next[j-i];
            }
            //1
            if (dest.charAt(i) ==dest.charAt(j)){
                j++;
            }
            //2
            next[i] = j;
        }
        return next;
    }

    public static int kmp(String str,String dest,int[]next){
        for (int i = 0,j=0; i < str.length(); i++) {
            while (j>0 && str.charAt(i) != dest.charAt(j)){
                j = next[j-1];
            }
            if (str.charAt(i) == dest.charAt(j)){
                j++;
            }
            //结束
            if (j ==dest.length()){
                return i-j+1;
            }

        }
        return 0;
    }

}
