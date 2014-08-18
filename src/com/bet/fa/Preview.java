package com.bet.fa;

class Preview extends HtmlContent
{
	static final String homeNameIdentifier = "hometeam.*?;";
	static final String guestNameIdentifier = "guestteam.*?;";
	static final String homeHistoryIdentifier = "h_data.*?]];";
	static final String guestHistoryIdentifier = "a_data.*?]];";

	private Team home;
	private Team guest;
	private DerivedHeadToHead dhth;

	Preview(String htmlURL)
	{
		super(htmlURL);

		this.home = new Team(this.htmlc, homeNameIdentifier, homeHistoryIdentifier);
		this.guest = new Team(this.htmlc, guestNameIdentifier, guestHistoryIdentifier);
		this.dhth = new DerivedHeadToHead(this.home, this.guest);
	}

	public void print()
	{
		super.print();

		this.home.print();
		this.guest.print();
		this.dhth.print();
	}

	public void printDerivedHeadToHead()
	{
		this.dhth.print();
	}
}