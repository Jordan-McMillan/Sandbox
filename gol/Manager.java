public class Board
{
	public int Iterations;
	public int Size;
	public int[][] Current;

	public Board(int size)
	{
		this.Size = size;
		this.CreateBoard();
	}

	private void CreateBoard()
	{
		this.Current = new int[this.Size][this.Size];
		for(int i = 0; i < this.Current.length; i++)
		{
			for(int j = 0; j < this.Current[i].length; j ++)
			{
				this.Current[i][j] = 1;
			}
		}
	}

	public int[][] NextGeneration()
	{
		int[][] Next = this.Current;
		Next[3][3] = 0;

		return Next;
	}

	public String GetBoard()
	{
		String result = "Current:\n";
		for(int i = 0; i < this.Current.length; i++)
		{
			for(int j = 0; j < this.Current[i].length; j++)
			{
				result += this.Current[i][j];
			}
			result += "\n";
		}
		return result;
	}

}
