package ga;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.NumberFormatException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
	public static void main(String[] args)
	{
		Initializer initializer = new SimpleInitializer();
		Evaluater evaluater = new SimpleEvaluater(1000);
		Surviver surviver = new RouletteSurviver();
		Mutater mutater = new SimpleMutater();
		Crossoverer crossoverer = new SinglePointCrossoverer();
		
		GeneAlgorithm ga = new GeneAlgorithm(initializer,
											 crossoverer,
											 mutater,
											 surviver,
											 evaluater);
		
		CostTable costTable = null;
		try
		{
			costTable = new TwoDimArrayCostTable("ga/table.dat", 5000);
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("FileNotFoundException");
			System.exit(0);
		}
		catch(IOException ex)
		{
			System.out.println("IOException");
			System.exit(0);
		}
		catch(NumberFormatException ex)
		{
			System.out.println("NumberFormatException");
			System.exit(0);
		}
		
		ArrayList<Integer> origin = new ArrayList<Integer>();
		for(int i = 0; i < 5000; i++)	origin.add(i);
		Path.setOrigin(origin);
		
		Gene[] gene = new Gene[200];
		for(int i = 0; i < gene.length; i++)
		{
			gene[i] = new PathGene(costTable);
		}
		
		Genes genes = new Genes(gene);
		
		Gene result = genes.maxScoreGene();
		
		System.out.println(100000000.0-result.score());
		
		ga.solve(genes);
		
		result = genes.maxScoreGene();
		System.out.println(100000000.0-result.score());
	}
}
