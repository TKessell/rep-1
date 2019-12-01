public class GameOfLife
{
	public static void main(String[] args)
	{
		String[] cells= {"-()-","-()-","-()-"};
		//System.out.println(cells.length);
		int gens= 3;
		for(int i= 0;i < gens;i++)
		{
			System.out.println("Generation " + i + ":");
			print(dish);
			dish= life(dish);
		}
	}		
}

public static void print(String[] cells)
{
	for(String s: cells)
	{
		System.out.println(s);
	}
}
	
