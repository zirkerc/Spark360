/*
 * XboxLiveMultiPaneActivity.java 
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

import com.akop.bach.R;
import com.akop.bach.XboxLiveAccount;
import com.akop.bach.activity.RibbonedMultiPane;

public abstract class XboxLiveMultiPane extends RibbonedMultiPane
{
	protected XboxLiveAccount getAccount()
	{
		return (XboxLiveAccount)mAccount;
	}
	
	@Override
	protected int getLayout() 
	{
		return R.layout.xbl_multipane;
	}

	@Override
	protected int getActionBarLayout() 
	{
		return R.layout.xbl_actionbar_custom;
	}
}
