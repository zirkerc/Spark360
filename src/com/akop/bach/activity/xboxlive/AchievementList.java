/*
 * AchievementList.java 
 * Copyright (C) 2010-2012 Akop Karapetyan
 *
 * This file is part of Spark 360, the online gaming service client.
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA
 *  02111-1307  USA.
 *
 */

package com.akop.bach.activity.xboxlive;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.akop.bach.App;
import com.akop.bach.R;
import com.akop.bach.XboxLive.Games;
import com.akop.bach.XboxLiveAccount;
import com.akop.bach.fragment.xboxlive.AchievementsFragment;

public class AchievementList extends RibbonedSinglePaneActivity
{
	private String mTitle = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		long titleId;
		if ((titleId = getIntent().getLongExtra("gameId", -1)) < 0)
		{
			if (App.LOGV)
				App.logv("AchievementList: no gameId");
			
			finish();
			return;
		}
		
		mTitle = Games.getTitle(this, titleId);
		
		FragmentManager fm = getSupportFragmentManager();
		Fragment titleFrag;
		
		FragmentTransaction ft = fm.beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        
		if ((titleFrag = (AchievementsFragment)fm.findFragmentByTag("details")) == null)
		{
			titleFrag = AchievementsFragment.newInstance(mAccount, titleId, true);
			ft.replace(R.id.fragment_titles, titleFrag, "details");
		}
		
		ft.commit();
	}
	
	public static void actionShow(Context context, XboxLiveAccount account, long gameId)
	{
    	Intent intent = new Intent(context, AchievementList.class);
    	intent.putExtra("account", account);
    	intent.putExtra("gameId", gameId);
    	context.startActivity(intent);
	}

	@Override
    protected String getSubtitle()
    {
		return getString(R.string.achievements_of_f, mTitle);
    }
}