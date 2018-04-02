package ga;

import java.util.Random;

public class RouletteSurviver extends Surviver
{
	public void survive(Genes genes)
	{
		long start = System.currentTimeMillis();
		Genes genes_tmp = genes.clone();
		long end = System.currentTimeMillis();
		
		System.out.println("stacking : " + (end - start) + "ms");
		Random rand = new Random();
		double[] boundaryTable = new double[genes.getNum() + 1];
		double tmp;
		
		// set scores stacking
		tmp = 0.0;
		boundaryTable[0] = 0.0;
		for(int i = 1; i < genes.getNum() + 1; i++)
		{
			tmp += genes.getAt(i - 1).score();
			boundaryTable[i] = tmp;
		}
		
		// survive genes
		for(int i = 0; i < genes.getNum(); i++)
		{
			double selectedPoint = rand.nextDouble() * (boundaryTable[genes.getNum()] - Double.MIN_VALUE);
			
			for(int j = 1; j < genes.getNum() + 1; j++)
			{
				if(boundaryTable[j-1] <= selectedPoint && selectedPoint < boundaryTable[j])
				{
					genes.setAt(i, genes_tmp.getAt(j - 1));
					break;
				}
			}
		}
	}
}
