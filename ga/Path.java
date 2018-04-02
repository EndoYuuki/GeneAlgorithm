package ga;

import java.util.Arrays;
import java.util.ArrayList;

public class Path
{
	private static ArrayList<Integer> _origin;
	
	public static void setOrigin(ArrayList<Integer> origin)
	{
		_origin = new ArrayList<Integer>(origin);
	}
	
	public static int[] routeToCode(int[] route)
	{
		int[] code = new int[route.length];
		ArrayList<Integer> tmp = new ArrayList<Integer>(_origin);
		
		for(int i = 0; i < route.length; i++)
		{
			int n = tmp.indexOf(route[i]);
			code[i] = n;
			tmp.remove(n);
		}
		
		return code;
	}
	
	public static int[] codeToRoute(int[] code)
	{
		int[] route = new int[code.length];
		ArrayList<Integer> tmp = new ArrayList<Integer>(_origin);
		for(int i = 0; i < code.length; i++)
		{
			route[i] = tmp.get(code[i]);
			tmp.remove(code[i]);
		}
		return route;
	}
}
