import java.util.*;

public class Data {
    public String result;
    public String sindex;
    public int step;
    public int size;
    public String[][] data;
    public int[] index1;
    public int[] index2;
    
    public Data(){}

    public void rearrange(){
        data = new String[step][size];
        StringTokenizer st = new StringTokenizer(result, "\n");
        for(int i=0; i<step; i++){
            String datastr = st.nextToken();
            StringTokenizer st2 = new StringTokenizer(datastr, "  ");
            for(int j=0; j<size; j++){
                data[i][j] = st2.nextToken();
            }
        }
    }
    
    public void pickindex() {
    	index1 = new int[step];
    	index2 = new int[step];
        StringTokenizer st = new StringTokenizer(sindex, "\n");
        for(int i=0; i<step; i++){
            String datastr = st.nextToken();
            StringTokenizer st2 = new StringTokenizer(datastr, " ");
            
            	index1[i] =Integer.parseInt(st2.nextToken());
            	index2[i] =Integer.parseInt(st2.nextToken());
            
        }
    }
}
