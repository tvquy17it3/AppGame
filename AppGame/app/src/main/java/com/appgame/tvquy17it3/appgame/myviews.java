package com.appgame.tvquy17it3.appgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class myviews extends View implements  Runnable{
    private int x1=100,y1=100, dx1=20, dy1=20;
    private Canvas canvas;


    public myviews(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        Bitmap bgBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bg);

        //canvas.drawBitmap(bgBitmap, 0, 0, null);

    }

    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        int x=getWidth();
        int y= getHeight();

        Paint paint =  new Paint();
        int radius = 50;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);
        paint.setColor(Color.parseColor("#CD5C5C"));
        canvas.drawCircle(x1, y1, radius, paint);

//        Bitmap ball = BitmapFactory.decodeResource(getResources(), R.drawable.bong);
//        Bitmap ballResize = Bitmap.createScaledBitmap(ball,95,70,false);
//        canvas.drawBitmap(ballResize, x1, y1,paint);

        update();
        invalidate();
    }



    void update(){
        x1+=dx1;
        y1+=dy1;
        if (x1>this.getWidth() || x1<0){
            dx1=-dx1;
        }
        if (y1>this.getHeight() || y1<0){
            dy1=-dy1;
        }
    }

    @Override
    public void run() {
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        boolean handled = false;

        int xTouch;
        int yTouch;
        int actionIndex = event.getActionIndex();


        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:

                xTouch = (int) event.getX(0);
                yTouch = (int) event.getY(0);


                handled = true;
                break;

            case MotionEvent.ACTION_POINTER_DOWN:
                xTouch = (int) event.getX(actionIndex);
                yTouch = (int) event.getY(actionIndex);


                handled = true;
                break;

            case MotionEvent.ACTION_MOVE:
                final int pointerCount = event.getPointerCount();

                for (actionIndex = 0; actionIndex < pointerCount; actionIndex++) {

                    xTouch = (int) event.getX(actionIndex);
                    yTouch = (int) event.getY(actionIndex);

                }


                invalidate();
                handled = true;
                break;

            case MotionEvent.ACTION_UP:

                invalidate();
                handled = true;
                break;

            case MotionEvent.ACTION_POINTER_UP:

                invalidate();
                handled = true;
                break;

            case MotionEvent.ACTION_CANCEL:

                handled = true;
                break;

            default:
                // do nothing
                break;
        }

        return super.onTouchEvent(event) || handled;
    }
}
