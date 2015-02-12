import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class provideString {

	private ArrayList<String> nextStates = new ArrayList<String>();
	
	
	public provideString(){
		getUserInput();
	}
	
	
	public void getUserInput(){
		StringBuilder sb = new StringBuilder();
		Scanner in = new Scanner(System.in);
		if(in.hasNext()){
			String s = in.next();
			s= s.toUpperCase();
			sb.append(s);
			sb.deleteCharAt(0);
			nextStates(sb);
			/*removeM(s);*/
			
		} else {
			System.out.println("Scanner Error in userInput()");
		}

	}


	private void nextStates(StringBuilder sb1) {
		rules(sb1);
		for(int i=0;i<nextStates.size();i++){
			System.out.println(i +"  M"+nextStates.get(i));
		}
		
	}
	/*
	private void removeM(String s1){
		String s2;
		if(s1.charAt(0)=='M'){
		for(int i=1;i<s1.length();i++){
			s2= s2 + s1.charAt(i);
		}
		nextStates(s2);
		}
	}
	*/
	private void rules(StringBuilder sb1){
		/*rule 1
		String sru1=null;
		if((s2.charAt(s2.length()-1))==('I')){
			sru1=s2+'U';
		}
		nextStates.add(sru1);
		
		/*rule 2
		String sru2=null;
		if(s2.length()>0){
			sru2=s2+s2;
		}
		nextStates.add(sru2);
		
		/*rule 3
		String sru3;
		for(int i=0;i<s2.length()-1;i++){
			if((s2.charAt(i)=='I')&&(s2.charAt(i+1)=='I')&&(s2.charAt(i+2)=='I')){
				for(int k=i+3;k<s2.length();k++){
					
				}
				
			}
		}
		*/
		String originalString = sb1.toString();
		/*cannot change sb1*/
		System.out.println("ORgin"+sb1);
		/*making a copy for each rule*/
		StringBuilder sbr = new StringBuilder();
		sbr.append(originalString);
		StringBuilder sb2 = new StringBuilder();
		sb2.append(originalString);
		StringBuilder sb3 = new StringBuilder();
		sb3.append(originalString);
		

		/*rule 1 sb*/
		if((sbr.charAt(sbr.length()-1))=='I'){
			sbr=sbr.append('U');
		}
		String s = sbr.toString();
		nextStates.add(s);

		/*rule 2 sb*/	
		if(sb2.length()>0){
			sb2.append(sb2);
		}
		s=sb2.toString();
		nextStates.add(s);
		
		/*rule 3 sb*/
		char[] dst1 = new char[3];
		char[] dst2 = new char[3];
		char[] dst3 = new char[3];
		char[] III = new char[3];
		String U = "U";
		
		III[0] = 'I';
		III[1] = 'I';
		III[2] = 'I';
		/*pass in the original string*/
		/*will need a try catch for when the string.length()
		 * isn't a multiple of three*/
		
		for(int i=0;i<sb3.length()-1;i++){
			try{
				sb3.getChars(i,i+2,dst1,0); //get the first three chars
			}catch(NullPointerException npe){
				break;
			}catch(StringIndexOutOfBoundsException siobe){
				break;
			}
			for(int j=0;i<dst1.length-1;j++){
				System.out.println("dst1" +j+": "+dst1[j]);
			}
			for(int k=0;i<dst1.length-1;k++){
				System.out.println("III" +k+": "+III[k]);
			}
				if(Arrays.equals(dst1,III)){
				System.out.println("thesame");
				sb3.replace(i,i+2,U);
				s = sb3.toString();
				nextStates.add(s);
			}
			try{
			sb1.getChars(i+1,i+3,dst2,0);//get the next three chars
			}catch(NullPointerException npe){
				break;
			}catch(StringIndexOutOfBoundsException siobe){
				break;
			}
			if(Arrays.equals(dst2,III)){
				//StringBuilder sb5 = new StringBuilder();
				/*reset sb3 to original*/
				sb3=sb1;
				sb3.replace(i+1,i+3,U);
				s = sb3.toString();
				nextStates.add(s);
			}
			try{
				sb1.getChars(i+2,i+4,dst3,0); //get the next three chars
			}catch(NullPointerException npe){
				break;
			}catch(StringIndexOutOfBoundsException siobe){
				break;
			}
			if(Arrays.equals(dst3,III)){
				//StringBuilder sb6 = new StringBuilder();
				/*reset sb3 to original*/
				sb3=sb1;
				sb3.replace(i+1,i+3,U);
				s = sb3.toString();
				nextStates.add(s);
			}
		}
	}
	
}
