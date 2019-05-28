package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

public class MaskImageButton extends ImageView {
    private int a;
    private Paint aFY;
    private int b;
    public Object eSe;
    private int g;
    private int r;
    private ak rgT;
    private Runnable rgU;
    private RectF zGi;
    private int zGj;
    private int zGk;

    public MaskImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(107743);
        this.zGi = new RectF();
        this.aFY = null;
        this.a = 90;
        this.r = 0;
        this.g = 0;
        this.b = 0;
        this.zGj = 0;
        this.zGk = 0;
        this.aFY = new Paint();
        this.aFY.setColor(Color.argb(this.a, this.r, this.g, this.b));
        this.rgT = new ak(Looper.getMainLooper());
        this.rgU = new Runnable() {
            public final void run() {
                AppMethodBeat.i(107741);
                MaskImageButton.this.setPressed(false);
                MaskImageButton.this.invalidate();
                AppMethodBeat.o(107741);
            }
        };
        super.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(107742);
                switch (motionEvent.getAction()) {
                    case 0:
                        view.setPressed(true);
                        view.invalidate();
                        MaskImageButton.this.rgT.removeCallbacks(MaskImageButton.this.rgU);
                        break;
                    case 1:
                    case 3:
                        MaskImageButton.this.rgT.post(MaskImageButton.this.rgU);
                        break;
                }
                if (MaskImageButton.this.isClickable() || MaskImageButton.this.isLongClickable()) {
                    AppMethodBeat.o(107742);
                    return false;
                }
                AppMethodBeat.o(107742);
                return true;
            }
        });
        AppMethodBeat.o(107743);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(107744);
        super.onDraw(canvas);
        if (isPressed()) {
            this.zGi.set((float) (getPaddingLeft() + 0), (float) (getPaddingTop() + 0), (float) (this.zGj - getPaddingRight()), (float) (this.zGk - getPaddingBottom()));
            canvas.drawRoundRect(this.zGi, (float) (getMeasuredHeight() / 10), (float) (getMeasuredHeight() / 10), this.aFY);
        }
        AppMethodBeat.o(107744);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(107745);
        super.onMeasure(i, i2);
        this.zGj = getMeasuredWidth();
        this.zGk = getMeasuredHeight();
        AppMethodBeat.o(107745);
    }
}
