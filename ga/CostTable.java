package ga;

public abstract class CostTable
{
	private int _dim;
	
	public CostTable(int dim)
	{
		_dim = dim;
	}

	public int getDim()
	{
		return _dim;
	}
	
	public abstract double getCost(int from, int to);
}
