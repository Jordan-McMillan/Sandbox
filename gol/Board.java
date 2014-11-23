/*
   less than 2, die
   2 or 3 lives
   over 3 dies
   dead cell with 3 neighboors lives
*/

public class Board
{
	public int Iterations;
	public int Size;
	public int[][] Current;

	public Board(int size)
	{
		this.Size = size;
		this.Current = this.CreateBoard(false);
	}

	public int[][] NextGeneration()
	{
		int[][] next = this.CreateBoard(true);
		
		for(int i = 0; i < this.Current.length; i++)
		{
			for(int j = 0; j < this.Current[i].length; j++)
			{
				int neighboors = 0;
				boolean allowLeft = (j > 0);
				boolean allowRight = (j < this.Size - 1);
				
				// left neighboor
				if(allowLeft && this.Current[i][j - 1] == 1)
					neighboors++;
				
				// top neighboors
				if(i > 0)
				{
					// left
					if(allowLeft && this.Current[i - 1][j - 1] == 1)
						neighboors++;
					// middle
					if(this.Current[i - 1][j] == 1)
						neighboors++;
					// right
					if(allowRight && this.Current[i - 1][j + 1] == 1)
						neighboors++;
				}

				// bottom neighboors
				if(i < this.Size - 1)
				{
					// left
					if(allowLeft && this.Current[i + 1][j - 1] == 1)
						neighboors++;
					// middle
					if(this.Current[i + 1][j] == 1)
						neighboors++;
					// right
					if(allowRight && this.Current[i + 1][j + 1] == 1)
						neighboors++;
				}
				// right neighboor
				if(allowRight && this.Current[i][j + 1] == 1)
					neighboors++;

				if(this.Current[i][j] == 1)
				{
					if(neighboors < 2)
						next[i][j] = 0;
					else if(neighboors > 3)
						next[i][j] = 0;
					else
						next[i][j] = 1;
				}
				else if(neighboors == 3)
					next[i][j] = 1;
				
			}
		}

		return next;
	}

	private int[][] CreateBoard(boolean copyCurrent)
	{
		int[][] result = new int[this.Size][this.Size];
		for(int i = 0; i < result.length; i++)
		{
			for(int j = 0; j < result[i].length; j ++)
			{
				if(copyCurrent)
					result[i][j] = this.Current[i][j];
				else
					result[i][j] = 0;
			}
		}
		return result;
	}
}
