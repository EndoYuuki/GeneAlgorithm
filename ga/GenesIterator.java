package ga;

public class GenesIterator implements Iterator
{
	private Genes _genes;
	private int _index;
	
	public GenesIterator(Genes genes)
	{
		_genes = genes;
		_index = 0;
	}
	
	public boolean hasNext()
	{
		if(_index < _genes.getNum())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public Object next()
	{
		return _genes.getAt(_index++);
	}
}
