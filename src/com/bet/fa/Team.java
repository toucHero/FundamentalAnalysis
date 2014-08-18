package com.bet.fa;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Team
{
	private String name;
	private String nameAbbr;
	private List<TeamMatchRecord> record;

	Team(String htmlc, String nameIdentifier, String recentIdentifier)
	{
		if (htmlc != null)
		{
			this.name = filterNameText(extractText(htmlc, nameIdentifier));

			if (this.name.length() > 4)
			{
				this.nameAbbr = this.name.substring(0, 4);
			}
			else
			{
				this.nameAbbr = this.name;
			}

			this.record = new ArrayList<TeamMatchRecord>();
			List<String> recentSectiontext = extractRecentSectionText(extractText(htmlc, recentIdentifier));
			for (int i = 0; i < recentSectiontext.size(); i++)
			{
				record.add(filterRecentSectionText(recentSectiontext.get(i)));
			}
		}
		else
		{
			this.name = null;
			this.nameAbbr = null;
			this.record = null;
		}
	}

	public String name()
	{
		return this.name;
	}

	public String nameAbbr()
	{
		return this.nameAbbr;
	}

	public List<TeamMatchRecord> historyList()
	{
		return this.record;
	}

	public TeamMatchRecord historyListItem(int i)
	{
		return this.record.get(i);
	}

	public TeamMatchRecord historyListItemRemove(int i)
	{
		return this.record.remove(i);
	}

	public int historySize()
	{
		return this.record.size();
	}

	private String extractText(String htmlc, String identifier)
	{
		String tmpString = "";

		List<String> list = new ArrayList<String>();
		Pattern pa = Pattern.compile(identifier, Pattern.CANON_EQ);
		Matcher ma = pa.matcher(htmlc);
		while (ma.find())
		{
			list.add(ma.group());
		}
		for (int i = 0; i < list.size(); i++)
		{
			tmpString = tmpString.concat(list.get(i));
		}

		return tmpString;
	}

	private String filterNameText(String nameText)
	{
		int start = 0;
		int end = 0;

		start = nameText.indexOf("\"", 0);
		end = nameText.indexOf("\"", start + 1);

		return nameText.substring(start + 1, end);
	}

	private List<String> extractRecentSectionText(String text)
	{
		int position = 8;
		int head = 0;
		int end = 0;
		List<String> tmpListString = new ArrayList<String>();

		for (; head != -1 && end != -1;)
		{
			head = text.indexOf("[", position);
			end = text.indexOf("]", position);
			if (head != -1 && end != -1)
			{
				tmpListString.add(text.substring(head + 1, end));
			}
			position = end + 1;
		}

		return tmpListString;
	}

	private TeamMatchRecord filterRecentSectionText(String sectionText)
	{
		int start = 0;
		int end = 0;
		int position = 0;

		TeamMatchRecord tmprecord = new TeamMatchRecord(this.name, this.nameAbbr);

		// column 1 is is date, need
		position = sectionText.indexOf(",", position);
		end = position;
		tmprecord.setDate(sectionText.substring(start + 1, end - 1)); // +-1 to pass ","

		// column 2 is match type number, not need
		position = sectionText.indexOf(",", position + 1);

		// column 3 is match type name, need
		start = position + 1;
		position = sectionText.indexOf(",", position + 1);
		end = position;
		tmprecord.setMatchType(sectionText.substring(start + 1, end - 1)); // +-1 to pass ","

		// column 4 is match type color, not need
		position = sectionText.indexOf(",", position + 1);

		// column 5 is home team number, not need
		position = sectionText.indexOf(",", position + 1);

		// column 6 is home team name, need
		start = position + 1;
		position = sectionText.indexOf(",", position + 1);
		end = position;
		tmprecord.setHomeTeam(teamNameExtract(sectionText.substring(start + 1, end - 1))); // +-1 to pass ","

		// column 7 is away team number, not need
		position = sectionText.indexOf(",", position + 1);

		// column 8 is away team name, need
		start = position + 1;
		position = sectionText.indexOf(",", position + 1);
		end = position;
		tmprecord.setGuestTeam(teamNameExtract(sectionText.substring(start + 1, end - 1))); // +-1 to pass ","

		// column 9 is home team score, not need
		position = sectionText.indexOf(",", position + 1);

		// column 10 is away team score, not need
		position = sectionText.indexOf(",", position + 1);

		// column 11 is half score, not need
		position = sectionText.indexOf(",", position + 1);

		// column 12 is handicap, need
		start = position + 1;
		position = sectionText.indexOf(",", position + 1);
		end = position;
		tmprecord.setHandicap(sectionText.substring(start + 1, end - 1)); // +-1 to pass ","

		// column 13 is home team score, not need
		// column 14 is home team score, not need
		// column 15 is home team score, not need
		// column 16 is home team score, not need

		return tmprecord;
	}

	// use in filterRecentSectionText()
	private String teamNameExtract(String teamName)
	{
		int start = 0;
		int end = 0;
		String tmp = teamName;

		// remove <sapan class/> if necessary
		start = tmp.indexOf("<span class");
		if (start != -1)
		{
			end = tmp.indexOf("</span>", start);
			tmp = tmp.replace(tmp.substring(start, end + 7), ""); // 7 for length of "</span>"
		}

		// remove <span title/> identifier
		start = tmp.indexOf("<");
		end = tmp.indexOf(">");
		tmp = tmp.replace(tmp.substring(start, end + 1), ""); // remove front
		start = tmp.indexOf("<");
		end = tmp.indexOf(">");
		tmp = tmp.replace(tmp.substring(start, end + 1), ""); // remove after

		return tmp;
	}

	public void print()
	{
		System.out.println(this.name);
		System.out.println(this.nameAbbr);

		for (int i = 0; i < this.record.size(); i++)
		{
			this.record.get(i).print();
		}
	}

	public void printName()
	{
		System.out.println(this.name);
	}
}