package com.bet.fa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class FundamentalAnalysis
{
	public static void main(String[] args)
	{
		// System.out.println("Hello World!");

		String id;
		while (true)
		{
			id = input1();

			if (id == null)
			{
				continue;
			}
			else if (id.equals("exit") || id.equals("end") || id.equals("quit"))
			{
				break;
			}

			String url = "http://info.win007.com/analysis/".concat(id.concat("cn.htm"));
			Preview test = new Preview(url);
			test.printDerivedHeadToHead();
		}
	}

	static String input1()
	{
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader buf = new BufferedReader(ir);
		String id = null;
		System.out.print(" ‰»Î±»»¸±‡∫≈£∫");
		try
		{
			id = buf.readLine();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return id;
	}

	static String input2()
	{
		String id;
		Scanner sc = new Scanner(System.in);
		id = sc.next();
		return id;
	}
}