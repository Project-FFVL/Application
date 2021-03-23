package fr.arinonia.app.components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Circle extends View {

    private int animValue;
    private final int strokeWidth = 15;

    public Circle(Context context, @Nullable AttributeSet attrs) { super(context, attrs);
        animValue = 0;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.strokeWidth);
        paint.setColor(Color.GRAY);
        RectF rectF = new RectF(); rectF.set(strokeWidth,strokeWidth,getWidth() - this.strokeWidth ,getWidth() - this.strokeWidth);
        canvas.drawArc(rectF,0,360,false,paint);
        paint.setColor(Color.BLUE); canvas.drawArc(rectF, this.animValue,80,false,paint);
    }

    public void setValue(int animatedValue) {
        animValue = animatedValue;
        this.invalidate();
    }
}