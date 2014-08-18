package com.bet.fa;

import java.util.ArrayList;
import java.util.List;

class DerivedHeadToHeadItem
{
	private List<TeamMatchRecord> homeItem;
	private List<TeamMatchRecord> guestItem;

	DerivedHeadToHeadItem()
	{
		this.homeItem = new ArrayList<TeamMatchRecord>();
		this.guestItem = new ArrayList<TeamMatchRecord>();
	}

	public int totalSize()
	{
		return (this.homeItem.size() + this.guestItem.size());
	}

	public int homeSize()
	{
		return this.homeItem.size();
	}

	public int guestSize()
	{
		return this.guestItem.size();
	}

	public void addHome(TeamMatchRecord tmr)
	{
		this.homeItem.add(tmr);
	}

	public void addGuest(TeamMatchRecord tmr)
	{
		this.guestItem.add(tmr);
	}

	public void print()
	{
		// System.out.println(this.itemSize);

		for (int i = 0; i < this.homeItem.size(); i++)
		{
			this.homeItem.get(i).print();
		}

		for (int i = 0; i < this.guestItem.size(); i++)
		{
			this.guestItem.get(i).print();
		}
	}
}