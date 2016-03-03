package model;

/**
 * Created by eroshin on 03.03.2016.
 */
public class JPerson {

    private String pName;
    private String pSurName;
    private String pTown;
    private int pYear;
    private int pNumber;

    private JGroup pGroup;
    private int pHour;
    private int pMinute;
    private int pSeconds;


    public JPerson(String n, String s, String t,int y, int num){
        pName = n;
        pSurName = s;
        pTown = t;
        pYear = y;
        pNumber = num;
    }

    public Object[] getObject(){
        Object[] ans = new Object[5];
        ans[0] = pName;
        ans[1]=pSurName;
        ans[2]=pTown;
        ans[3]=pYear;
        ans[4]=pNumber;
        return ans;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpSurName() {
        return pSurName;
    }

    public void setpSurName(String pSurName) {
        this.pSurName = pSurName;
    }

    public String getpTown() {
        return pTown;
    }

    public void setpTown(String pTown) {
        this.pTown = pTown;
    }

    public int getpYear() {
        return pYear;
    }

    public void setpYear(int pYear) {
        this.pYear = pYear;
    }

    public int getpNumber() {
        return pNumber;
    }

    public void setpNumber(int pNumber) {
        this.pNumber = pNumber;
    }
}
