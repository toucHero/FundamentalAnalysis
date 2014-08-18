package com.bet.fa;

class TeamMatchRecord extends MatchRecord
{
	private String base;
	private String baseAbbr;

	TeamMatchRecord(String base, String baseAbbr)
	{
		super();
		this.base = base;
		this.baseAbbr = baseAbbr;
	}

	String getAnotherTeam()
	{
		if (this.item[2].substring(0, this.baseAbbr.length()).equals(this.baseAbbr))
		{
			return this.item[3];
		}
		else if (this.item[3].substring(0, this.baseAbbr.length()).equals(this.baseAbbr))
		{
			return this.item[2];
		}
		else
		{
			return null;
		}
	}
}