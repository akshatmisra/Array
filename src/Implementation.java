import java.util.*;
public class Implementation {

	public static void main(String args[])
	{
//		Scanner sc = new Scanner(System.in);
//		
//		sc.close();
		int [] nums = {4,5,6,7,1,2,3};
		FindDuplicates fd = new FindDuplicates();
		//System.out.println(fd.search(nums,7));
		char [] X = {'A','B','C','B','D','A','B'};
		char [] Y = {'B','D','C','A','B','A'};
		System.out.println(fd.LCSLength(X,X.length-1, Y,Y.length-1));
	}
	
}
