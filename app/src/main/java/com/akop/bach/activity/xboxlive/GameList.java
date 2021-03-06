/*
 * GameList.java 
 * Copyright (C) 2010-2014 Akop Karapetyan
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
import android.support.v4.app.Fragment;

import com.akop.bach.R;
import com.akop.bach.XboxLiveAccount;
import com.akop.bach.fragment.xboxlive.AchievementsFragment;
import com.akop.bach.fragment.xboxlive.GamesFragment;
import com.akop.bach.fragment.xboxlive.GamesFragment.OnGameSelectedListener;

public class GameList extends XboxLiveMultiPane implements
        OnGameSelectedListener
{
	@Override
    protected Fragment instantiateDetailFragment()
    {
	    return AchievementsFragment.newInstance(getAccount(), false);
    }
	
	@Override
    protected Fragment instantiateTitleFragment()
    {
	    return GamesFragment.newInstance(getAccount());
    }
	
	@Override
    public void onGameSelected(long id)
    {
		if (isDualPane())
		{
			AchievementsFragment detailFragment = (AchievementsFragment)mDetailFragment;
			detailFragment.resetTitle(id);
		}
		else
		{
			AchievementList.actionShow(this, getAccount(), id);
		}
    }
	
	public static void actionShow(Context context, XboxLiveAccount account)
	{
    	Intent intent = new Intent(context, GameList.class);
    	intent.putExtra("account", account);
    	context.startActivity(intent);
	}

	@Override
    protected String getSubtitle()
    {
	    return getString(R.string.my_played_games);
    }
}
