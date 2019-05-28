package com.tencent.mm.plugin.emoji.ui.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ScaleRelativeLayout extends RelativeLayout {
    public float aJf;
    private float aJg;
    private float lgA;
    private float lgB;
    private float lgC;
    private float lgD;
    public float lgE;
    private float lgF;
    private boolean lgG;
    private ValueAnimator lgH;

    public ScaleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScaleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aJf = 3.0f;
        this.aJg = 0.5f;
        this.lgA = 1.0f;
        this.lgB = 1.0f;
        this.lgC = 0.0f;
        this.lgD = 0.0f;
        this.lgE = 6.0f;
        this.lgF = 0.3f;
        this.lgG = false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(53860);
        if (motionEvent.getPointerCount() > 1) {
            AppMethodBeat.o(53860);
            return true;
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(53860);
        return onInterceptTouchEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(53861);
        if (!this.lgG && motionEvent.getPointerCount() == 2) {
            this.lgG = true;
            this.lgC = (float) Math.hypot((double) (motionEvent.getX(0) - motionEvent.getX(1)), (double) (motionEvent.getY(0) - motionEvent.getY(1)));
            this.lgB = this.lgA;
        }
        float f;
        float f2;
        switch (motionEvent.getActionMasked()) {
            case 1:
                f = this.lgA;
                f2 = this.lgA;
                if (this.lgA < this.aJg) {
                    f2 = this.aJg;
                } else if (this.lgA > this.aJf) {
                    f2 = this.aJf;
                }
                if (this.lgH != null) {
                    this.lgH.cancel();
                }
                this.lgH = ValueAnimator.ofFloat(new float[]{f, f2});
                this.lgH.addUpdateListener(new AnimatorUpdateListener() {
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AppMethodBeat.i(53859);
                        ScaleRelativeLayout.this.lgA = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        ScaleRelativeLayout.this.postInvalidate();
                        AppMethodBeat.o(53859);
                    }
                });
                this.lgH.start();
                break;
            case 2:
                if (motionEvent.getPointerCount() == 2) {
                    f = (float) Math.hypot((double) (motionEvent.getX(0) - motionEvent.getX(1)), (double) (motionEvent.getY(0) - motionEvent.getY(1)));
                    f2 = (this.lgB * f) / this.lgC;
                    if (f2 > this.lgE) {
                        f2 = this.lgE;
                        this.lgD = this.lgC * f2;
                    } else if (f2 < this.lgF) {
                        f2 = this.lgF;
                        this.lgD = this.lgC * f2;
                    } else {
                        this.lgD = f;
                    }
                    this.lgA = f2;
                    if (this.lgH != null) {
                        this.lgH.cancel();
                        break;
                    }
                }
                break;
            case 6:
                if (motionEvent.getPointerCount() == 2) {
                    this.lgC = this.lgD;
                    this.lgB = this.lgA;
                    this.lgG = false;
                    break;
                }
                break;
        }
        if (this.lgC <= 0.0f) {
            this.lgC = 0.1f;
        }
        postInvalidate();
        AppMethodBeat.o(53861);
        return true;
    }

    /* Access modifiers changed, original: protected */
    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.i(53862);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        canvas.save();
        canvas.scale(this.lgA, this.lgA, (float) (width / 2), (float) (height / 2));
        super.dispatchDraw(canvas);
        canvas.restore();
        AppMethodBeat.o(53862);
    }
}
