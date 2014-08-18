package com.bet.fa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

class HtmlContent
{
	protected final String htmlc;

	HtmlContent(String htmlURL)
	{
		this.htmlc = createContent(htmlURL);
	}

	private String createContent(String htmlURL)
	{
		URL url;
		String tmp;
		StringBuffer sb = new StringBuffer();

		try
		{
			url = new URL(htmlURL);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			while ((tmp = br.readLine()) != null)
			{
				sb.append(tmp);
			}
			br.close();
		}
		catch (final MalformedURLException me)
		{
			System.out.println("Wrong formatter of your URL");
			me.getMessage();
			return null;
		}
		catch (final IOException e)
		{
			e.printStackTrace();
			return null;
		}

		return sb.toString();
	}

	public void print()
	{
		System.out.println(this.htmlc);
	}
}