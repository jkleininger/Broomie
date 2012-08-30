package net.qrab.broomie;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
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
        Tilesheet	ts;

        public Panel(Context context) {
            super(context);
            ts = new Tilesheet(context,"dungeon.png",0,0);
            theBitmap = ts.getBitmap();
        }
 
        @Override
        public void onDraw(Canvas canvas) {
            canvas.drawColor(Color.BLACK);
            for(int n=0;n<=40;n++){
            	ts.drawTile(canvas, n, (int)n/10, (int)n%10);
            }
            //canvas.drawBitmap(theBitmap, 10, 10, null);
        }

    
    }

}
