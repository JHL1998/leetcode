package binarySearch;

/**
 * 1095、山脉数组中查找目标值
 */
public class Main1095 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peek=findPeek(mountainArr);
        int res=leftSearch(mountainArr,0,peek,target);
        return res>=0?res:rightSearch(mountainArr,peek,mountainArr.length(),target);
    }

    /**
     * 左边升序搜索
     * @param mountainArr
     * @param l
     * @param rr
     * @param target
     * @return
     */
    private int leftSearch(MountainArray mountainArr,int l,int rr,int target){
        int r=rr;
        while(l<r){
            int mid=l+(r-l)/2;
            if(mountainArr.get(mid)<target) l=mid+1;
            else r=mid;
        }
        return l<rr&&mountainArr.get(l) ==target?l:-1;
    }

    /**
     * 右边降序搜素
     * @param mountainArr
     * @param l
     * @param rr
     * @param target
     * @return
     */
    private int rightSearch(MountainArray mountainArr,int l,int rr,int target){
        int r=rr;
        while(l<r){
            int mid=l+(r-l)/2;
            if(mountainArr.get(mid)>target) l=mid+1;
            else r=mid;
        }
        return l<rr&&mountainArr.get(l) ==target?l:-1;
    }

    /**
     * 查找峰值元素
     * @param mountainArr
     * @return
     */
    private int findPeek(MountainArray mountainArr){
        int l=0,r=mountainArr.length();
        while(l<r){
            int mid=l+(r-l)/2;
            if(mid+1<mountainArr.length()&&mountainArr.get(mid)<mountainArr.get(mid+1))l=mid+1;
            else r=mid;
        }
        return l;
    }
}
