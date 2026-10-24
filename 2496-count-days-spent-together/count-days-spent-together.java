class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int start = Math.max(toDay(arriveAlice),toDay(arriveBob));
        int end = Math.min(toDay(leaveAlice),toDay(leaveBob));

        return Math.max(0,end-start+1);
    }
    private int toDay(String date){
        int days[]={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String date_arr[]=date.split("-");
        int month=Integer.parseInt(date_arr[0]);
        int day=Integer.parseInt(date_arr[1]);

        for(int i=0;i<month-1;i++){
            day+=days[i];
        }
        return day;
    }
}