package ga;

import java.util.Random;

public class SinglePointCrossoverer extends Crossoverer
{
	public void crossover(Genes genes)
	{
		Random rand = new Random();
		
		for(int i = 0; i < genes.getNum(); i+= 2)
		{
			int cuttingPoint = rand.nextInt(genes.getDim() - 1) + 1;
			Gene.ShiftCodesSection(genes.getAt(i), genes.getAt(i+1), cuttingPoint, genes.getDim());
		}
	}
}
