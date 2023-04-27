import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class lab13 {
	private ArrayList<Integer> values = new ArrayList<Integer>();
	
	public void readData(String filename)
	{
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			String inn;
			while( (inn = input.readLine()) != null )
			{
				values.add(Integer.valueOf(inn.trim()));
			}
			input.close();
		}
		catch(Exception e)
		{
			
		}
	}
	
	public long getTotalCount()
	{
		return values.stream()
				.count();
	}
	
	public long getOddCount()
	{
		return values.stream()
				.filter(s -> s % 2 == 1)
				.count();
	}
	
	public long getEvenCount()
	{
		return values.stream()
				.filter(s -> s % 2 == 0)
				.count();
	}
	
	public long getDistinctGreaterThanFiveCount()
	{
		return values.stream()
				.distinct()
				.filter(s -> s > 5)
				.count();
	}
	
	public Integer[] getResult1()
	{
		return values.stream()
				.filter(s -> s % 2 == 0)
				.filter(s -> s > 5)
				.filter(s -> s < 50)
				.sorted()
				.toArray(Integer[]::new);
	}
	
	public Integer[] getResult2()
	{
		return values.stream()
				.map(s -> s*s)
				.map(s -> s*3)
				.limit(50)
				.toArray(Integer[]::new);
	}
	
	public Integer[] getResult3()
	{
		return values.stream()
				.filter(s -> s % 2 == 1)
				.map(s -> s*2)
				.sorted()
				.skip(20)
				.distinct()
				.toArray(Integer[]::new);
	}
}
