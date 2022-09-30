import java.text.DecimalFormat;
import java.lang.*;
import java.util.ArrayList;

public class MergeSort implements Sort{
    //declaring the variable
    public int j;
    public int programcounter;
    public String result;
	public String step;
    public int type;
	public int head,tail;
    //initializing the InsertionSort
    public MergeSort(){
        j = 1;
		head = 0;
        result="";
        programcounter=1;
        step="";
    }
	
	public <T extends Comparable<T>> void allStep(ArrayList<T> array){	
		head = 0;
		tail = array.size()-1;
		sort(array,head,tail);
	}
	
	public <T extends Comparable<T>> void Down_allStep(ArrayList<T> array){
		head = 0;
		tail = array.size()-1;
		down_sort(array,head,tail);
	}
	
	public void O_allStep(ArrayList<Food> array, int judge) {
		head = 0;
		tail = array.size()-1;
		O_sort(array,head,tail,judge);
	}
	
	public void O_Down_allStep(ArrayList<Food> array, int judge){
		head = 0;
		tail = array.size()-1;
		O_down_sort(array,head,tail,judge);
	}
	
	public <T extends Comparable <T>> void sort(ArrayList<T> array, int l, int r)
    {
        if (l < r) {
            int m =l+ (r-l)/2;
            sort(array, l, m);
            sort(array, m + 1, r);

            merge(array, l, m, r);
        }
    }
	
    public <T extends Comparable <T>> void down_sort(ArrayList<T> array, int l, int r)
    {
        if (l < r) {
            int m =l+ (r-l)/2;
            down_sort(array, l, m);
            down_sort(array, m + 1, r);

            down_merge(array, l, m, r);
        }
    }
	
	public void O_sort(ArrayList<Food> array, int l, int r, int judge)
    {
        if (l < r) {
            int m =l+ (r-l)/2;
            O_sort(array, l, m, judge);
            O_sort(array, m + 1, r , judge);

            O_merge(array, l, m, r, judge);
        }
    }
	
	public void O_down_sort(ArrayList<Food> array, int l, int r, int judge)
    {
        if (l < r) {
            int m =l+ (r-l)/2;
            O_down_sort(array, l, m, judge);
            O_down_sort(array, m + 1, r, judge);

            O_down_merge(array, l, m, r, judge);
        }
    }
	
    public <T extends Comparable <T>> void merge(ArrayList<T> array, int l, int m, int r)
    {

        int n1 = m - l + 1;
        int n2 = r - m;
 

        ArrayList<T> L = new ArrayList<T>(n1);
        ArrayList<T> R = new ArrayList<T>(n2);
 

        for (int i = 0; i < n1; ++i)
            L.add(array.get(i+l));
        for (int t = 0; t < n2; ++t)
           R.add(array.get(m+1+t));
 

        int i = 0, t = 0;

        int k = l;
        while (i < n1 && t < n2) {
            if (L.get(i).compareTo(R.get(t)) <= 0) {
				step+=(i+1)+" "+(k+1)+"\n";
				programcounter++;
				array.set(k,L.get(i));
				i++;
				toString(array);
				result+="\n";
            }
            else {			
            	step+=(t+1)+" "+(k+1)+"\n";
				programcounter++;
				array.set(k,R.get(t));
				t++;
				toString(array);
				result+="\n";
            }
            k++;
        }
 
        while (i < n1) {
			step+=(i+1)+" "+(k+1)+"\n";
			programcounter++;
            array.set(k,L.get(i));
            i++;
            k++;
			
				toString(array);
				result+="\n";
			
        }
 
        while (t < n2) {
			step+=(t+1)+" "+(k+1)+"\n";
			programcounter++;
            array.set(k,R.get(t));
            t++;
            k++;
			
				toString(array);
				result+="\n";
			
        }
    }
	
	
	public <T extends Comparable <T>> void down_merge(ArrayList<T> array, int l, int m, int r)
    {

        int n1 = m - l + 1;
        int n2 = r - m;
 

        ArrayList<T> L = new ArrayList<T>(n1);
        ArrayList<T> R = new ArrayList<T>(n2);
 

        for (int i = 0; i < n1; ++i)
            L.add(array.get(i+l));
        for (int t = 0; t < n2; ++t)
            R.add(array.get(m+1+t));
 

        int i = 0, t = 0;

        int k = l;
        while (i < n1 && t < n2) {
            if (L.get(i).compareTo(R.get(t)) > 0) {
				step+=(i+1)+" "+(k+1)+"\n";
				programcounter++;
				array.set(k,L.get(i));
				i++;
				toString(array);
				result+="\n";
            }
            else {			
				step+=(t+1)+" "+(k+1)+"\n";
				programcounter++;
				array.set(k,R.get(t));
				t++;
				toString(array);
				result+="\n";
            }
            k++;
        }
 
        while (i < n1) {
			step+=(i+1)+" "+(k+1)+"\n";
			programcounter++;
            array.set(k,L.get(i));
            i++;
            k++;
			
				toString(array);
				result+="\n";
			
        }
 
        while (t < n2) {
			step+=(t+1)+" "+(k+1)+"\n";
			programcounter++;
            array.set(k,R.get(t));
            t++;
            k++;
			
				toString(array);
				result+="\n";
			
        }
    }
	
    public void O_merge(ArrayList<Food> array, int l, int m, int r, int judge)
    {

        int n1 = m - l + 1;
        int n2 = r - m;
 

        ArrayList<Food> L = new ArrayList<Food>(n1);
        ArrayList<Food> R = new ArrayList<Food>(n2);
 

        for (int i = 0; i < n1; ++i){
            L.add(array.get(i+l));
			 switch(judge){
                case 1:L.get(i).setComparator(new NameComparator<Food>());break;
                case 2:L.get(i).setComparator(new PriceComparator<Food>());break;
                case 3:L.get(i).setComparator(new CaloriesComparator<Food>());break;
            }
		}	
        for (int t = 0; t < n2; ++t){
           R.add(array.get(m+1+t));
             switch(judge){
                case 1:R.get(t).setComparator(new NameComparator<Food>());break;
                case 2:R.get(t).setComparator(new PriceComparator<Food>());break;
                case 3:R.get(t).setComparator(new CaloriesComparator<Food>());break;
            }
		}	

        int i = 0, t = 0;

        int k = l;
        while (i < n1 && t < n2) {
            if (L.get(i).compare(R.get(t)) < 0) {
				step+=(i+1)+" "+(k+1)+"\n";
				programcounter++;
				array.set(k,L.get(i));
				i++;
				toString(array);
				result+="\n";
            }
            else {			
				step+=(t+1)+" "+(k+1)+"\n";
				programcounter++;
				array.set(k,R.get(t));
				t++;
				toString(array);
				result+="\n";
            }
            k++;
        }
 
        while (i < n1) {
			step+=(i+1)+" "+(k+1)+"\n";
			programcounter++;
            array.set(k,L.get(i));
            i++;
            k++;
			
				toString(array);
				result+="\n";
			
        }
 
        while (t < n2) {
			step+=(t+1)+" "+(k+1)+"\n";
			programcounter++;
            array.set(k,R.get(t));
            t++;
            k++;
			
				toString(array);
				result+="\n";
			
        }
    }
	
    public void O_down_merge(ArrayList<Food> array, int l, int m, int r, int judge)
    {

        int n1 = m - l + 1;
        int n2 = r - m;
 

        ArrayList<Food> L = new ArrayList<Food>(n1);
        ArrayList<Food> R = new ArrayList<Food>(n2);
 

        for (int i = 0; i < n1; ++i){
            L.add(array.get(i+l));
			 switch(judge){
                case 1:L.get(i).setComparator(new NameComparator<Food>());break;
                case 2:L.get(i).setComparator(new PriceComparator<Food>());break;
                case 3:L.get(i).setComparator(new CaloriesComparator<Food>());break;
            }
		}	
        for (int t = 0; t < n2; ++t){
           R.add(array.get(m+1+t));
             switch(judge){
                case 1:R.get(t).setComparator(new NameComparator<Food>());break;
                case 2:R.get(t).setComparator(new PriceComparator<Food>());break;
                case 3:R.get(t).setComparator(new CaloriesComparator<Food>());break;
            }
		}	

        int i = 0, t = 0;

        int k = l;
        while (i < n1 && t < n2) {
            if (L.get(i).compare(R.get(t)) > 0) {
				step+=(i+1)+" "+(k+1)+"\n";
				programcounter++;
				array.set(k,L.get(i));
				i++;
				toString(array);
				result+="\n";
            }
            else {			
				step+=(t+1)+" "+(k+1)+"\n";
				programcounter++;
				array.set(k,R.get(t));
				t++;
				toString(array);
				result+="\n";
            }
            k++;
        }
 
        while (i < n1) {
			step+=(i+1)+" "+(k+1)+"\n";
			programcounter++;
            array.set(k,L.get(i));
            i++;
            k++;
			
				toString(array);
				result+="\n";
			
        }
 
        while (t < n2) {
			step+=(t+1)+" "+(k+1)+"\n";
			programcounter++;
            array.set(k,R.get(t));
            t++;
            k++;
			
				toString(array);
				result+="\n";
			
        }
    }
	
    public <T> void toString(ArrayList<T> array){         //Output the stored array
        int c=0;
        DecimalFormat df = new DecimalFormat("0.######");
        for(T i:array){
            switch(type){
                case 0: {
                    result+=""+df.format((double)i);
                    break;
                }
                case 1:case 2:{
                    result+=""+i;
                    break;
                }
            }
            if(c++<array.size()-1)
                result+="  ";       //output a space between numbers, but don't output after the last number
        }
        System.out.println("success");
    }

}

