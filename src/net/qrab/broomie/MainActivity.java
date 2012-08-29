package net.qrab.broomie;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

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
            Tilesheet ts = new Tilesheet(context,"dungeon.png",0,0);
            theBitmap = ts.getBitmap();
        }
 
        @Override
        public void onDraw(Canvas canvas) {
            canvas.drawColor(Color.BLACK);
            canvas.drawBitmap(theBitmap,new Rect(0,0,60,60),new Rect(0,0,60,60),null);
            //canvas.drawBitmap(theBitmap, 10, 10, null);
        }

    
    }

}
