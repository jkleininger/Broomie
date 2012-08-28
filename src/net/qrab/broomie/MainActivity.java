package net.qrab.broomie;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import java.io.InputStream;
import java.io.IOException;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Panel(this));
    }

    class Panel extends View {
        Bitmap theBitmap;
        String fName;

        public Panel(Context context) {
            super(context);
            theBitmap=getBitmapFromAssets("dungeon.png");

        }
 
        @Override
        public void onDraw(Canvas canvas) {
            canvas.drawColor(Color.BLACK);
            if(theBitmap!=null) { canvas.drawBitmap(theBitmap, 10, 10, null); } else { Log.d("DEBUGINFO", "The Bitmap is null"); }
        }

        private Bitmap getBitmapFromAssets(String f) {
        	Bitmap b=null;
        	try {
                InputStream ips=getAssets().open(f);
                b=BitmapFactory.decodeStream(ips);
                return b;
            } catch (IOException e1) {
                //e1.printStackTrace();
            }
        	return b;
        }
    
    }

}
