package ga;

public class SimpleEvaluater extends Evaluater
{
	private int _boundary;
	private int _count;
	
	public SimpleEvaluater(int boundary)
	{
		_count = 0;
		_boundary = boundary;
	}

	public boolean canFinish(Genes genes)
	{
		System.out.println("process : " + _count);
	
		if(++_count > _boundary)	return true;
		else						return false;
	}
}
