package com.bet.fa;

class MatchRecord
{
	protected String[] item;

	MatchRecord()
	{
		this.item = new String[5]; // column: 1: date, 2: match type name, 3: home team name, 4: away team name, 5: handicap
	}

	void setDate(String date)
	{
		this.item[0] = date;
	}

	void setMatchType(String matchType)
	{
		this.item[1] = matchType;
	}

	void setHomeTeam(String homeTeam)
	{
		this.item[2] = homeTeam;
	}

	void setGuestTeam(String guestTeam)
	{
		this.item[3] = guestTeam;
	}

	void setHandicap(String handicap)
	{
		this.item[4] = handicap;
	}

	void print()
	{
		for (int i = 0; i < 5; i++)
		{
			System.out.print(this.item[i]);
			System.out.print(" ");
		}

		System.out.println();
	}
}