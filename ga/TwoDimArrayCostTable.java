package ga;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.NumberFormatException;

public class TwoDimArrayCostTable extends CostTable
{
	private double[][] _costMat;
	
	public TwoDimArrayCostTable(double[][] costMat)
	{
		super(costMat.length);
		_costMat = costMat;
	}
	
	// TODO
	public TwoDimArrayCostTable(String filename, int num)
		throws IOException, FileNotFoundException, NumberFormatException
	{
		super(num);
		_costMat = new double[num][num];
		
		File file = new File(filename);
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String str;
		int count = 0;
		while((str = br.readLine()) != null && count < num)
		{
			String[] strSplited = str.split(" ");
			if(strSplited.length != num)
			{
				throw new NumberFormatException();
			}
			_costMat[count++] = parseDoubles(strSplited);
		}
		
		if(count != num)
		{
			throw new NumberFormatException();
		}
		
		br.close();
	}
	
	private static double[] parseDoubles(String[] strings)
	{
		double[] vals = new double[strings.length];
		for(int i = 0; i < strings.length; i++)
		{
			vals[i] = Double.parseDouble(strings[i]);
		}
		return vals;
	}
	
	public double getCost(int from, int to)
	{
		return _costMat[from][to];
	}
}
