public class SnakeAndLadder
{
	//UC-1
	int position = 0;

	int player1Position = 0;
	int player2Position = 0;
	int diePlayCount = 0;
	int maxPosition = 10;

	//UC-2
	int roleDieToGetNumber()
	{
		int randomNumber = (int)Math.floor(Math.random()*10)%6+1;
		diePlayCount++;
		return randomNumber;
	}

	//UC-3 //UC-5  // UC-6
   void checkOption(int dieNumber)
	{
		String option=null;
		int randomNumber = (int)Math.floor(Math.random()*10)%3;

		switch(randomNumber)
		{
			case 0:
			option = "No Play";
			position = position;
			break;

			case 1:
			option = "Ladder";
			if ( (position + dieNumber) <= maxPosition )
				position += dieNumber;
			break;
			
			default:
			option = "Snake";
			if ( (position - dieNumber) < 0 )
				position = 0;			
			else
				position -= dieNumber;
		}
		System.out.println(" Option is :" +option);
      System.out.println(" Current Position is : " +position+"\n");
	}
	
	//UC-4
	void checkOptionTillMaxPosition()
	{
		while( position < maxPosition )
		{
			int dieNumber = roleDieToGetNumber();
			System.out.println("Number got from rolling die : " +dieNumber);
			checkOption(dieNumber);
		}
	}

	//UC-7

	void checkOption(int dieNumber , String player)
   {
      String option = null;
		String playerName = player;
		int currentPosition = 0;

		if ( player.equalsIgnoreCase("Player1"))
			currentPosition = player1Position;
		else
			currentPosition = player2Position;

      int randomNumber = (int)Math.floor(Math.random()*10)%3;

      switch(randomNumber) 
      {
			case 0:
         option = "No Play";
			currentPosition = currentPosition;
			break;

			case 1:
			option = "Ladder";
         if ( (currentPosition + dieNumber) <= maxPosition )
            currentPosition += dieNumber;
			break;

			default:
			option = "Snake";
			if ( (currentPosition- dieNumber) < 0 )
				currentPosition = 0;
			else
				currentPosition -= dieNumber;
      }

      System.out.println(" Option is :" +option);
      System.out.println(" Current Position is : " +currentPosition+"\n");

		if ( player.equalsIgnoreCase("Player1"))
         player1Position = currentPosition;
      else
         player2Position = currentPosition;

		if ( option.equalsIgnoreCase("Ladder") && currentPosition < maxPosition)
         {
            dieNumber = roleDieToGetNumber();
            System.out.println("Die number of "+player+ "is : "+dieNumber);
            checkOption(dieNumber , player);
         }
	}

	void gameWithTwoPlayers()
	{
		int player1DieNumber=0;
		int player2DieNumber=0;
		String option = null;

		while ( player1Position < maxPosition && player2Position < maxPosition )
		{
			player1DieNumber = roleDieToGetNumber();
			System.out.println(" Die number for player1 is : " +player1DieNumber);
			checkOption(player1DieNumber , "Player1");
			if ( player1Position == maxPosition )
			{
				System.out.println("Player1 Won !");
				break;
			}

			player2DieNumber = roleDieToGetNumber();
         System.out.println(" Die number for player2 is : " +player2DieNumber);
         checkOption(player2DieNumber, "Player2");
			if ( player2Position == maxPosition )
         {
            System.out.println("Player2 Won !");
            break;
         }
		}
	}

	public static void main(String[] args)
	{
		SnakeAndLadder snakeAndLadder = new SnakeAndLadder();
		snakeAndLadder.checkOptionTillMaxPosition();
		
		//UC-6
		System.out.println("Number of times the die was played to win the game is : "+snakeAndLadder.diePlayCount);
		System.out.println(" \nGame with two players ");
		snakeAndLadder.gameWithTwoPlayers();
	}
}
