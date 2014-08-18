package com.bet.fa;

import java.util.ArrayList;
import java.util.List;

class DerivedHeadToHead
{
	private List<DerivedHeadToHeadItem> itemList;
	private int itemListSize; // equal to the number of common opposite teams
	private String baseTeam;
	private String anotherTeam;

	DerivedHeadToHead(Team base, Team another)
	{
		this.itemList = new ArrayList<DerivedHeadToHeadItem>();
		this.baseTeam = base.name();
		this.anotherTeam = another.name();

		while (base.historySize() != 0)
		{
			DerivedHeadToHeadItem dhthi = new DerivedHeadToHeadItem();
			String oppo = base.historyListItem(0).getAnotherTeam();
			if (oppo.length() > 4)
			{
				oppo = oppo.substring(0, 4);
			}

			for (int i = 0; i < base.historySize(); i++)
			{
				if (oppo.equals(base.historyListItem(i).getAnotherTeam().substring(0, oppo.length())))
				{
					dhthi.addHome(base.historyListItem(i));
					base.historyListItemRemove(i);
					i--; // change index after delete sth.
				}
			}

			for (int i = 0; i < another.historySize(); i++)
			{
				if (oppo.equals(another.historyListItem(i).getAnotherTeam().substring(0, oppo.length())))
				{
					dhthi.addGuest(another.historyListItem(i));
					another.historyListItemRemove(i);
					i--; // change index after delete sth.
				}
			}

			if (dhthi.homeSize() > 0 && dhthi.guestSize() > 0)
			{
				this.itemList.add(dhthi);
			}
		}

		this.itemListSize = this.itemList.size();
	}

	public int Size()
	{
		return this.itemListSize;
	}

	public void print()
	{
		// System.out.println(this.itemListSize);
		System.out.println();
		System.out.println(this.baseTeam.concat(" vs ".concat(this.anotherTeam)));
		System.out.println();

		for (int i = 0; i < this.itemListSize; i++)
		{
			this.itemList.get(i).print();
			System.out.println();
		}
	}
}