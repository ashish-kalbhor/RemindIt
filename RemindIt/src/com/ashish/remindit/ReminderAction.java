

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

import android.R.drawable;
import android.app.Activity;
import android.app.Service;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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
			Bitmap reminderBitmap = BitmapFactory.decodeStream(input);
		           
		    WallpaperManager wallpaperManager = WallpaperManager.getInstance(this); 
		    final Drawable wallpaperDrawable = wallpaperManager.getDrawable();
		    Bitmap originalBitmap = ((BitmapDrawable)wallpaperDrawable).getBitmap();        	
		    
		    wallpaperManager.setBitmap(reminderBitmap);
		    
		    Toast.makeText(this, "Wallpaper Set", Toast.LENGTH_SHORT).show();
		    
		    Thread thread = new Thread(){
		    	@Override
		    	public void run() {
		    		try {
		    			synchronized (this) {
						
							wait(10000);
						} 
		    		}catch (InterruptedException e) {
							e.printStackTrace();
					}
		    	}
		    };
		    thread.start();
		    
		    wallpaperManager.setBitmap(originalBitmap);
		    
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
