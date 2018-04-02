package ga;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public abstract class Gene
{
	private int[] _code;
	private int _dim;
	
	public abstract double score();
	public abstract Gene clone();
	public abstract void print();
	
	public Gene(int dim)
	{
		_dim = dim;
	}
	
	protected void _setCode(int[] code)
	{
		_code = code;
	}
	
	protected void _setCodeAt(int index, int value)
	{
		_code[index] = value;
	}
	
	protected int[] _getCode()
	{
		return _code;
	}
	
	public int getCodeAt(int index)
	{
		return _code[index];
	}
	
	public int getSize()
	{
		return _dim;
	}
	
	private ArrayList<Integer> toList(int[] arr)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int t: arr)	list.add(t);
		return list;
	}
	
	public int[] toArr(ArrayList<Integer> list)
	{
		int l = list.size();
		int[] arr = new int[l];
		for(int i = 0; i < l; i++)	arr[i] = list.get(i);
		return arr;
	}
	
	public static void ShiftCodesSection(Gene g1, Gene g2, int start, int end)
	{
		for(int i = start; i < end; i++)
		{
			int tmp = g1.getCodeAt(i);
			g1._setCodeAt(i, g2.getCodeAt(i));
			g2._setCodeAt(i, tmp);
		}
	}
}
