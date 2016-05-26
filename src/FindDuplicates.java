import java.util.*;

public class FindDuplicates {

	public int findDuplicates(int nums[])
	{
		int slow = 0;
		int fast = 0;
		int finder = 0;
		
		while(true)
		{
			slow = nums[slow];
			fast = nums[nums[fast]];
			if(slow == fast)
				break;
		}
		
		while(true)
		{
			slow = nums[slow];
			finder = nums[finder];
			if(slow == finder)
				return finder;
		}
	}
	
	///Use Xor to find the single non repeating number in an array
	public int singleNumber(int[] nums)
	{
		int res = 0;
		for(int i = 0; i<nums.length; i++)
			res ^= nums[i];
		return res;
	}
	
	// If numbers are repeated 3 time except 1
	// if the array has many then it will return last if it is not repeated 3 times or the first value
	public int singleNum(int[] nums)
	{
		//Sort array
		Arrays.sort(nums);
		
		if(nums.length <=2)
			return nums[0];
		else
		{
			if(nums[nums.length -1] != nums[nums.length -2])
				return nums[nums.length -1];
			else
			{
				for(int i = 3; i< nums.length; i++)
				{
					if(nums[i]!= nums[i-1]&& nums[i] != nums[i+1])
						return nums[i];
				}
			}
		}
		return nums[0];
	}
	// Find the two numbers which appear only once and all other elements appear twice
	// Idea is to use HashMap
	public int [] twoSingle(int [] nums)
	{
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
		int [] result = new int[2];
		int count =0;
		for(int i = 0; i<nums.length;i++)
		{
			if(map.containsKey(nums[i]))
				map.put(nums[i], 2);
			else
				map.put(nums[i],1);
		}
		
		for(int i : map.keySet())
		{
			if(map.get(i) == 1)
				result[count++] = i;
		}
		return result;
	}
	
	// Find the majority element in an array ie. a number appearing more than n/2 times
	// Moore's Voting algorithm when majority element always exist
	// Create a BST with element and count.  
	public int majorityElement(int [] nums)
	{
		int majIdx = 0; int count =1;
		
		for(int i =1; i<nums.length; i++)
		{
			if(nums[majIdx]==nums[i])
				count++;
			else
				count--;
			if(count == 0)
			{
				majIdx = i;
				count = 1;
			}
		}
		return nums[majIdx];
	}
	
	// Find majority element list where majority is defined by the number appearing more than n/3 times
	public List<Integer> majorityEle(int[] nums)
	{
		List<Integer> result = new ArrayList<Integer>();
		int count = 1; // current appearence
		if(nums.length <=2)
		{
			for(int i = 0; i<nums.length; i++)
				if(!result.contains(nums[i]))
					result.add(nums[i]);
		}
		else
		{
			Arrays.sort(nums);
			
			for(int i = 1; i<nums.length -1; i++)
			{
				if(nums[i]==nums[i-1])
					count++;
				else
					count=1;// reset count
				
				if(count > nums.length/3 && !result.contains(nums[i]))//more than n/3 times
					result.add(nums[i]);
			}
		}
		
		return result;
	}
	
	// Find Minimum in sorted rotated array
	//Idea is to check for a point where the element is less than a previous value
	public int minValue(int[] nums)
	{
		if(nums.length == 1)
			return nums[0];
		for(int i = 1; i<nums.length; i++)
		{
			if(nums[i] < nums[i-1])
				return nums[i];
		}
		return nums[0];
	}
	// Find minimum in sorted rotated array using Binary search
	public int minVal(int [] nums)
	{
		if(nums.length == 1)
			return nums[0];
		if(nums[0]< nums[nums.length-1])
			return nums[0];
		else
		{
			int l = 0;
			int r = nums.length -1;
			while(l+1 < r) //Important to note
			{
				int mid = l+(r-l)/2;
				
				if(nums[mid] < nums[mid -1] && nums[mid]<nums[mid+1])
					return nums[mid];
				else if(nums[mid] > nums[l])
					l = mid;
				else
					r = mid;
			}
		}
		return nums[nums.length -1];
	}
	
	public int search(int[] nums, int target) {
        
        if(nums.length ==1 && nums[0] == target)
            return 0;
        if(nums[nums.length -1] == target)
        	return nums.length -1;
        if(nums[0] == target)
        	return 0;
        
        int l = 0;
        int r = nums.length -1;
        while(l+1 < r)
        {
            int mid = l+(r-l)/2;
            
            if(nums[mid] == target)
                return mid;
            if(nums[l]<nums[mid])
            	if(target < nums[mid] && target > nums[l])
            		r = mid;
            	else
            		l = mid;
            if(nums[mid]<nums[r])
            	if(target > nums[mid] && target < nums[r])
            		l = mid;
            	else
            		r = mid;
        }
        
        return nums[nums.length -1] == target?(nums.length -1):-1; 
    }

	int [][] LCS = new int[1024][1024];
	public int LCSLength(char [] X,int m, char[] Y, int n)
	{	
		for(int i = m; i>=0; i--)
		{
			for(int j = n; j>=0; j--)
			{
				LCS[i][j] = LCS[i+1][j+1];
				
				if(X[i] == Y[j])
					LCS[i][j]++; 
				
				if(LCS[i][j+1] > LCS[i][j])
					LCS[i][j] = LCS[i][j+1];
				if(LCS[i+1][j] > LCS[i][j])
					LCS[i][j] = LCS[i+1][j];
			}
		}
		
		for(int i = 0; i<= m; )
			for(int j = 0; j<=n; )
			{
				if(X[i++] == Y[j++])
					System.out.print(X[i]);
			}
		System.out.println();
		return LCS[0][0];
	}

}
