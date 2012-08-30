package net.qrab.broomie;

import java.io.IOException;
import java.io.InputStream;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.content.Context;
import android.graphics.Canvas;
import android.content.res.AssetManager;


public class Tilesheet {
	AssetManager	aManager;
	Bitmap			theBitmap;
	int				rows   = 13;
	int				cols   = 10;
	int				tileWd = 32;
	int				tileHt = 32;
	int				wd;
	int				ht;

	Rect			rectSrc = new Rect(0,0,tileWd,tileHt);
	Rect 			rectDst = new Rect(0,0,tileWd,tileHt);
	
	public Tilesheet(Context cxt, String fname, int c, int r) {
		aManager = cxt.getAssets();
        theBitmap = getBitmapFromAssets(fname);
	}

	public Bitmap getBitmap() {
		return theBitmap;
	}

	public void drawTile(Canvas c, int i, int bdCol, int bdRow) {
		int tsCol = (int)i%cols;
		int tsRow = (int)i/cols;
		
		rectSrc.offsetTo(tsCol*tileWd, tsRow*tileHt);
		rectDst.offsetTo(bdCol*tileWd, bdRow*tileHt);
		c.drawBitmap(theBitmap, rectSrc, rectDst, null);
		System.out.println(i+"->("+tsCol+","+tsRow+")");
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
