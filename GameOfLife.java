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

public static String[] life(String[] c)
{
	String[] newGen= new String[cells.length];
	for(int row= 0;row < cells.length;row++)
	{
		newGen[row]= "";
		for(int i= 0;i < cells[row].length();i++)
	{
	  String above= "";
	   String same= "";
			  String below= "";
	   if(i == 0)
	  {
	    above= (row == 0) ? null : cells[row - 1].substring(i,
							    i + 2);
	    same= cells[row].substring(i + 1, i + 2);
	    below= (row == cells.length - 1) ? null : cells[row + 1]
	     .substring(i, i + 2);
	      }
	      else if(i == cells[row].length() - 1)
	      {
		above= (row == 0) ? null : cells[row - 1].substring(i - 1,
								    i + 1);
	      same= cells[row].substring(i - 1, i);
		below= (row == cells.length - 1) ? null : cells[row + 1]
		.substring(i - 1, i + 1);
      }
      else
	{
		above= (row == 0) ? null : cells[row - 1].substring(i - 1,
								    i + 2);
	      same= cells[row].substring(i - 1, i)
	  + cells[row].substring(i + 1, i + 2);
	below= (row == cells.length - 1) ? null : cells[row + 1]
	  .substring(i - 1, i + 2);
      }
      int neighbors= getNeighbors(above, same, below);
      if(neighbors < 2 || neighbors > 3)
      {
	newGen[row]+= "_";
      }
      else if(neighbors == 3)
      {
	newGen[row]+= "#";
      }
      else
      {
	newGen[row]+= cells[row].charAt(i);
      }
    }
  }
  return newGen;
}

public static int getNeighbors(String above, String same, String below)
{
  int ans= 0;
  if(above != null)
  {
    for(char x: above.toCharArray())
    {
      if(x == '#') ans++;
    }
  }
  for(char x: same.toCharArray())
  {
    if(x == '#') ans++;
  }
  if(below != null)
  {
    for(char x: below.toCharArray())
    {
      if(x == '#') ans++;
    }
  }
  return ans;
}

public static void print(String[] cells)
{
	for(String s: cells)
	{
		System.out.println(s);
	}
}
