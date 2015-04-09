

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

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.app.Service;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.os.Vibrator;
import android.util.DisplayMetrics;
import android.widget.Toast;

public class ReminderAction extends Service
{
	Vibrator vibe = null;
	
	@Override
	public void onCreate()
	{
		this.vibe = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

		Toast.makeText(getApplicationContext(), "REMINDER", Toast.LENGTH_SHORT).show();
		vibe.vibrate(1000);
		
		InputStream input = null;
		try 
		{
			input = getAssets().open("image.jpg");
			Bitmap bitmap = BitmapFactory.decodeStream(input);
	
		    //DisplayMetrics metrics = new DisplayMetrics(); 
		    //((Activity)getBaseContext()).getWindowManager().getDefaultDisplay().getMetrics(metrics);
		    // get the height and width of screen 
		    //int height = metrics.heightPixels; 
		    //int width = metrics.widthPixels;
		           
		    WallpaperManager wallpaperManager = WallpaperManager.getInstance(this); 
		    wallpaperManager.setBitmap(bitmap);
		    //wallpaperManager.suggestDesiredDimensions(width, height);
		    Toast.makeText(this, "Wallpaper Set", Toast.LENGTH_SHORT).show();
	    } catch (IOException e) 
	    {
	    	e.printStackTrace();
	    }
	}

	@Override
	public IBinder onBind(Intent arg0)
	{
		return null;
	}

}
