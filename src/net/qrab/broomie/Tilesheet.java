package net.qrab.broomie;

import java.io.IOException;
import java.io.InputStream;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.content.Context;
//import android.graphics.Rect;
import android.content.res.AssetManager;


public class Tilesheet {
	AssetManager	aManager;
	Bitmap			theBitmap;
	int				rows;
	int				cols;
	int				tilewd;
	int				tileht;
	int				wd;
	int				ht;
	
	public Tilesheet(Context cxt, String fname, int c, int r) {
		aManager = cxt.getAssets();
        theBitmap = getBitmapFromAssets(fname);
	}

	public Bitmap getBitmap() {
		return theBitmap;
	}
	
    private Bitmap getBitmapFromAssets(String f) {
    	Bitmap b=null;
    	try {
            InputStream ips=aManager.open(f);
            b=BitmapFactory.decodeStream(ips);
            return b;
        } catch (IOException e1) {
            //e1.printStackTrace();
        }
    	return b;
    }
	

}
