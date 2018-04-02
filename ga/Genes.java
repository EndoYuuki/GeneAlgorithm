package ga;

import java.util.Arrays;

public class Genes implements Aggregate
{
	private Gene[] _genes;
	private int _num;
	private int _dim;
	
	public Genes(Gene[] genes)
	{
		_genes = new Gene[genes.length];
		for(int i = 0; i < genes.length; i++)
		{
			_genes[i] = genes[i].clone();
		}
		_num = genes.length;
		_dim = genes[0].getSize();
	}
	
	public void setAt(int index, Gene gene)
	{
		_genes[index] = gene;
	}
	
	public Gene getAt(int index)
	{
		return _genes[index];
	}
	
	public int getNum()
	{
		return _num;
	}
	
	public int getDim()
	{
		return _genes[0].getSize();
	}
	
	public Gene maxScoreGene()
	{
		Gene geneMax = null;
		double scoreMax = 0.0;
		Iterator it = iterator();
		while(it.hasNext())
		{
			Gene gene = (Gene)it.next();
			if(scoreMax < gene.score())
			{
				scoreMax = gene.score();
				geneMax = gene;
			}
		}
		return geneMax;
	}
	
	public Genes clone()
	{
		return new Genes(_genes);
	}
	
	public Iterator iterator()
	{
		return new GenesIterator(this);
	}
}
