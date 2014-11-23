public class test
{
	public static void main(String[] args)
	{
		Board board = new Board(10);
		if(board.Size != 10)
			Out("Expected size to be 10");
		if(board.Current.length != 10)
			Out("Expected size of array to be 10");

		Out("done");
	}

	public static void Out(String output)
	{
		System.out.println(output);
	}
}
