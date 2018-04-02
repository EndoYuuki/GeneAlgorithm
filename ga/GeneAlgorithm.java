package ga;

public class GeneAlgorithm
{
	private Initializer _initializer;
	private Crossoverer _crossoverer;
	private Mutater _mutater;
	private Surviver _surviver;
	private Evaluater _evaluater;
	
	public GeneAlgorithm(Initializer initializer,
						 Crossoverer crossoverer,
						 Mutater mutater,
						 Surviver surviver,
						 Evaluater evaluater)
	{
		_initializer = initializer;
		_crossoverer = crossoverer;
		_mutater = mutater;
		_surviver = surviver;
		_evaluater = evaluater;
	}
	
	public void solve(Genes genes)
	{
		long start, end;
		
		_initializer.init(genes);
		
		while(!_evaluater.canFinish(genes))
		{
			_crossoverer.crossover(genes);
			_mutater.mutate(genes);
			
			start = System.currentTimeMillis();
			_surviver.survive(genes);
			end = System.currentTimeMillis();
			System.out.println("survive : " + (end-start) + "ms");
		}
	}
}
