package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import junit.framework.Assert;

public class TouchImageView extends ImageView {
    private int a = 90;
    private int b = 0;
    private boolean enable = true;
    private int g = 0;
    private int r = 0;
    private RectF rDW = new RectF();
    private Paint rDX = new Paint();
    ak rgT;
    Runnable rgU;

    public TouchImageView(Context context) {
        super(context);
        AppMethodBeat.i(39897);
        init();
        AppMethodBeat.o(39897);
    }

    public TouchImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(39898);
        init();
        AppMethodBeat.o(39898);
    }

    public void settouchEnable(boolean z) {
        this.enable = z;
    }

    private void init() {
        AppMethodBeat.i(39899);
        this.rgT = new ak();
        this.rgU = new Runnable() {
            public final void run() {
                AppMethodBeat.i(39895);
                TouchImageView.this.setPressed(false);
                TouchImageView.this.invalidate();
                AppMethodBeat.o(39895);
            }
        };
        super.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(39896);
                if (TouchImageView.this.enable) {
                    TouchImageView touchImageView = TouchImageView.this;
                    switch (motionEvent.getAction()) {
                        case 0:
                            view.setPressed(true);
                            view.invalidate();
                            touchImageView.rgT.removeCallbacks(touchImageView.rgU);
                            break;
                        case 1:
                        case 3:
                            touchImageView.rgT.post(touchImageView.rgU);
                            break;
                    }
                    if (touchImageView.isClickable() || touchImageView.isLongClickable()) {
                        AppMethodBeat.o(39896);
                        return false;
                    }
                    AppMethodBeat.o(39896);
                    return true;
                }
                AppMethodBeat.o(39896);
                return false;
            }
        });
        AppMethodBeat.o(39899);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(39900);
        super.onDraw(canvas);
        if (isPressed()) {
            this.rDW.left = (float) getPaddingLeft();
            this.rDW.top = (float) getPaddingTop();
            this.rDW.right = (float) (getWidth() - getPaddingRight());
            this.rDW.bottom = (float) (getHeight() - getPaddingBottom());
            this.rDX.setARGB(this.a, this.r, this.g, this.b);
            canvas.drawRoundRect(this.rDW, (float) (getWidth() / 10), (float) (getHeight() / 10), this.rDX);
        }
        AppMethodBeat.o(39900);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        AppMethodBeat.i(39901);
        Assert.assertTrue(false);
        AppMethodBeat.o(39901);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(39902);
        super.onAttachedToWindow();
        ab.d("MicroMsg.MaskImageView", "onAttachedToWindow");
        AppMethodBeat.o(39902);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(39903);
        super.onDetachedFromWindow();
        ab.d("MicroMsg.MaskImageView", "onDetachedFromWindow");
        AppMethodBeat.o(39903);
    }
}
