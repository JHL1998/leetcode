package greed;

/**
 * 860、柠檬水找零
 */
public class _860LemonadeChange {
    /**
     * 按照贪心的思想，我们尽量优先找10块的出去
     * 10块钱不够了我们可以拿5块凑
     * 但是5块没有了，10块凑不了
     * 这就是本题的贪心思想
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int five=0, ten=0;
        for(int bill:bills){
            if(bill==5) five++;
            else if(bill==10){
                if(five>0) five--;
                else return false;
                ten++;

            }
            else{
                //此时需要找零15，优先找10块的
                int temp=15;
                if(ten>0){
                    temp-=10;
                    ten--;
                }
                while(temp>0&&five>0){
                    temp-=5;
                    five--;
                }
                if(temp!=0) return false;
            }
        }
        return true;

    }
}
