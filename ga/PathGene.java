package ga;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PathGene extends Gene
{
	private CostTable _costTable;
	private static int _seed = 0;

	public PathGene(CostTable costTable)
	{
		super(costTable.getDim());
		
		Random rand = new Random(_seed++);
		_costTable = costTable;
		
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		for(int i = 1; i < getSize(); i++)	tmp.add(i);	// 1234...
		
		int[] route = new int[getSize()];
		route[0] = 0;
		for(int i = 1; i < getSize(); i++)
		{
			int n = rand.nextInt(getSize() - i);
			route[i] = tmp.get(n);
			tmp.remove(n);
		}
		
		_setCode(Path.routeToCode(route));
	}
	
	public PathGene(CostTable costTable, int[] route)
	{
		super(costTable.getDim());
		_costTable = costTable;
		_setCode(Path.routeToCode(route));
	}
	
	public PathGene(CostTable costTable, int dim)
	{
		super(costTable.getDim());
		_costTable = costTable;
	}
	
	public Gene clone()
	{
		Gene gene = new PathGene(_costTable, 0);
		gene._setCode(_getCode());
		return gene;
	}
	
	public double score()
	{
		double cost = 0.0;
		int[] route = Path.codeToRoute(_getCode());
		
		for(int i = 1; i < getSize(); i++)
		{
			cost += _costTable.getCost(route[i-1], route[i]);
		}
		
		return 100000000.0 - cost;
	}
	
	public void print()
	{
		int[] code = new int[getSize()];
		for(int i = 0; i < getSize(); i++)
		{
			code[i] = getCodeAt(i);
		}
		
		int[] route = Path.codeToRoute(code);
		
		System.out.println(Arrays.toString(route));
	}
}
