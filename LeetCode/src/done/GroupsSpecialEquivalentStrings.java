package done;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GroupsSpecialEquivalentStrings {

	public static boolean equiv(String a, String b){
		int i=0,j=0,k=0,l=0;
		for(int x=0;x<a.length();++x){
			if(x %2==0){
				i |= (1 << (a.charAt(x)-'a'));
				k |= (1 << (b.charAt(x)-'a'));

			}
			else{
				j |= (1 << (a.charAt(x)-'a'));
				l |= (1 << (b.charAt(x)-'a'));
			}
		}
		return ((i^k) == 0) && ((j^l) ==0);
	}
	
    public static int numSpecialEquivGroups(String[] A) {
        int num = 0;
        Set<String> set = new HashSet<>();
        for(String a:A)
        	set.add(a);
        ArrayList<String> words = new ArrayList<>(set);
        
        Set<String> used = new HashSet<>();
        for(int i =0; i < words.size();++i){
        	if(!used.contains(words.get(i))){
        		++num;
            	used.add(words.get(i));
            	for(int j=i+1; j < words.size();++j){
            		if(!used.contains(words.get(j)) && equiv(words.get(i), words.get(j)))
            			used.add(words.get(j));
            	}
        	}        	
        }
    	
    	return num;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(equiv("bapap","ppaab"));
		String [] example = {"abcd","cdab","adcb","cbad"};
		System.out.println(numSpecialEquivGroups(example));
		
	}

}
