public class BoardOutput
{
	//Board board;
	public BoardOutput(Board board)
	{
	//	this.Board = board;
	}

	public String ToString(int[][] generation)
	{
		String result = "";
		for(int i = 0; i < generation.length; i++)
		{
			for(int j = 0; j < generation[i].length; j++)
			{
				result += generation[i][j] + " ";
			}
			result += "\n";
		}
		return result;
	}
}
