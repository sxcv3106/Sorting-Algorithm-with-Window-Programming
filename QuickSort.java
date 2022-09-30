import java.text.DecimalFormat;
import java.lang.*;
import java.util.ArrayList;

public class QuickSort implements Sort{
	
	public int j;
	public int left , right;
	public int programcounter;
	public String result;
	public String step;
	public int type;
	public boolean check = true , checkD = true;
	
	public QuickSort(){
		left = 0;
		result="";
		step="";
		programcounter=1;
	}
//--------------------Increase_AllStep-----------------------------
	public <T extends Comparable<T>> void allStep(ArrayList<T> array){	
			right = array.size()-1;
			left = 0;		
			qsort(array,left,right);		     
		}
//---------------------Down_AllStep---------------------------------
	public <T extends Comparable<T>> void Down_allStep(ArrayList<T> array){
			right = array.size()-1;
			left = 0;		
			Down_qsort(array,left,right);
		}
//--------------------------qsort---------------------------------
public <T extends Comparable<T>> void qsort(ArrayList<T> array,int left,int right){
			if(left < right){ 
		   
				 int i = left - 1; 
					for(int j2 = left; j2 < right; j2++){ 
						if (array.get(j2).compareTo(array.get(right)) <= 0){ 
							i++; 
							Swap(array, i, j2); 
							step+=(i+1)+" "+(j2+1)+"\n";
							//System.out.println(step);
							toString(array);
							result+="\n";
							programcounter++;
						} 
					} 
					Swap(array, i+1, right); 
					int q = i+1; 
				step+=(i+2)+" "+(right+1)+"\n";
				//System.out.println(step);
				toString(array);
				result+="\n";
				programcounter++;
				
				qsort(array, left, q-1);
				qsort(array, q+1, right); 
			}	
}
//----------------------Doew_qsort--------------------------------
public <T extends Comparable<T>> void Down_qsort(ArrayList<T> array,int left,int right){
	if(left < right){ 
		   
		int i = left - 1; 
		   for(int j2 = left; j2 < right; j2++){ 
			   if (array.get(j2).compareTo(array.get(right)) > 0){ 
				   i++; 
				   Swap(array, i, j2); 
				   step+=(i+1)+" "+(j2+1)+"\n";
				  // System.out.println(step);
				   toString(array);
				   result+="\n";
				   programcounter++;
			   } 
		   } 
		   Swap(array, i+1, right); 
		   int q = i+1; 
	   step+=(i+2)+" "+(right+1)+"\n";
	  // System.out.println(step);
	   toString(array);
	   result+="\n";
	   programcounter++;
	   
	   Down_qsort(array, left, q-1);
	   Down_qsort(array, q+1, right); 
   }	
}
//--------------------------Change A and B---------------------------
	private <T> void Swap(ArrayList<T> array, int indexA, int indexB){
		T tmp = array.get(indexA);
        array.set(indexA, array.get(indexB));
        array.set(indexB, tmp);
	}
//-------------------------------------------------------------------
	public <T> void toString(ArrayList<T> array){
		int c=0;
		DecimalFormat df = new DecimalFormat("0.######");
		for(T i:array){
			switch(type){
				case 0: {
					result+=""+df.format((double)i);
					break;
				}
				case 1:{
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