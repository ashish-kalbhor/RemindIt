

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

import android.app.Service;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds;
import android.text.format.Time;
import android.widget.Toast;

/**
 * Trigger class to scan device contacts and match current date with contact birthday.
 * 
 * @author Ashish Kalbhor <ashish.kalbhor@gmail.com>
 * 
 */

public class ReminderAction extends Service
{
	@Override
	public void onCreate()
	{
		VibrateAction vibrateAction = new VibrateAction();

		Toast.makeText(getApplicationContext(), "REMINDER", Toast.LENGTH_SHORT).show();
		vibrateAction.perform();
	}

	@Override
	public IBinder onBind(Intent arg0)
	{
		return null;
	}

}
