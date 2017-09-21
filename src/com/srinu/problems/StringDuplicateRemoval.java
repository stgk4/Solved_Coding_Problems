import java.util.HashSet;

public class StringDuplicateRemoval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "rebbercea";
		System.out.println(removeDuplicate(str));
	}
	
	public static String removeDuplicate(String str){
		//String output = null;
		HashSet<Character> h = new HashSet<Character>();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<str.length(); i++){
			char c = str.charAt(i);
			if(!h.contains(c)){
				h.add(c);
				sb.append(c);
			}
		}
		return sb.toString() ;
		
	}

}
