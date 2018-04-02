package ga;

public class SimpleInitializer extends Initializer
{
	public void init(Genes genes)
	{
		Iterator it = genes.iterator();
		while(it.hasNext())
		{
			Gene gene = (Gene)it.next();
		}
	}
}
