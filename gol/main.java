
public class main
{
		public static void main(String[] args)
		{
			Out("Starting up...");

			Board board = new Board(20);
			BoardOutput output = new BoardOutput(board);

			// initial living cells
			board.Current[8][6] = 1;
			board.Current[7][6] = 1;
			board.Current[9][6] = 1;
			board.Current[8][5] = 1;
			board.Current[8][7] = 1;



			for(int i = 0; i < 15; i++)
			{
				Clear();
				Out("Generation " + i);
				Out(output.ToString(board.Current));

				int[][] Next = board.NextGeneration();
				board.Current = Next;

				try
				{
					Thread.sleep(1000);
				}
				catch(Exception e)
				{
				}
			}
		}

		public static void Clear()
		{
			for(int i = 0; i < 28; i++)
			{
				Out("");
			}
		}

		public static void Out(String output)
		{
			System.out.println(output);
		}
}

