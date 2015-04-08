
/**
 * Copyright 2012 Ashish Kalbhor (ashish.kalbhor@gmail.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ashish.remindit;

import android.content.Context;
import android.os.Vibrator;

/**
 * SMS Action Class. The life cycle methods are explained as follows
 * <ul>
 * <li>onCreate - Called once when creating an instance of this action. Application Context is passed here</li>
 * <li>perform - Called each time when an action needs to be performed</li>
 * <li>onDestroy - Called once when this action needs to be destroyed. Clean up needs to be done here</li>
 * </ul>
 * 
 * @author Ashish Kalbhor <ashish.kalbhor@gmail.com>
 * 
 */

public class VibrateAction
{
	/**
	 * Android Application Context
	 */
	private Context context = null;

	/**
	 * Vibrator Service to Vibrate the device
	 */
	Vibrator vibe = null;


	/**
	 * Called once when creating an instance of this action.
	 * 
	 * @param context Android Application Context
	 */
	public void onCreate(Context context)
	{
		this.context = context;
		this.vibe = (Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
	}


	/**
	 * Called each time when an action needs to be performed
	 * 
	 * @param cName : Contact Name
	 * @param cNumber : Contact Number
	 */
	public void perform()
	{
		this.vibe.vibrate(1000);
	}


	/**
	 * Called once when this action needs to be destroyed. Clean up needs to be done here
	 */
	public void onDestroy()
	{
		
	}
}
