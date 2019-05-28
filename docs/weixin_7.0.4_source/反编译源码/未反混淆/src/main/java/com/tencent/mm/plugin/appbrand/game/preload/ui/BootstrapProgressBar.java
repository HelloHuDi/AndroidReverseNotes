package com.tencent.mm.plugin.appbrand.game.preload.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;

public class BootstrapProgressBar extends View implements AnimatorListener, AnimatorUpdateListener {
    private Paint htJ;
    private Paint htK;
    private Paint htL;
    private float htM = 0.0f;
    private float htN = 0.0f;
    private float htO = 100.0f;
    private boolean htP = true;
    private boolean htQ = true;
    private boolean htR = true;
    private boolean htS = true;
    private boolean htT = true;
    private ValueAnimator htU;
    private Paint htV;
    private Canvas htW;
    private Bitmap htX;
    private Bitmap htY;
    private int htZ;

    public BootstrapProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(130310);
        aBE();
        AppMethodBeat.o(130310);
    }

    public BootstrapProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(130311);
        aBE();
        AppMethodBeat.o(130311);
    }

    private void aBE() {
        AppMethodBeat.i(130312);
        ValueAnimator.setFrameDelay(15);
        this.htV = new Paint();
        this.htJ = new Paint();
        this.htJ.setStyle(Style.FILL);
        this.htJ.setAntiAlias(true);
        this.htK = new Paint();
        this.htK.setStyle(Style.FILL);
        this.htK.setAntiAlias(true);
        this.htL = new Paint();
        this.htL.setStyle(Style.FILL);
        this.htL.setARGB(38, 0, 0, 0);
        setProgress(this.htM);
        setMaxProgress(this.htO);
        AppMethodBeat.o(130312);
    }

    public void setProgressColor(int i) {
        AppMethodBeat.i(130313);
        this.htZ = i;
        this.htJ.setColor(this.htZ);
        Paint paint = this.htK;
        int i2 = this.htZ;
        paint.setColor(Color.rgb(((int) ((((float) Color.red(i2)) * 0.7f) + (((float) Color.red(WebView.NIGHT_MODE_COLOR)) * 0.3f))) / 1, ((int) ((((float) Color.green(i2)) * 0.7f) + (((float) Color.green(WebView.NIGHT_MODE_COLOR)) * 0.3f))) / 1, ((int) ((((float) Color.blue(i2)) * 0.7f) + (((float) Color.blue(WebView.NIGHT_MODE_COLOR)) * 0.3f))) / 1));
        this.htY = null;
        this.htX = null;
        this.htW = null;
        invalidate();
        AppMethodBeat.o(130313);
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        AppMethodBeat.i(130314);
        this.htN = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
        AppMethodBeat.o(130314);
    }

    public void onAnimationStart(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        AppMethodBeat.i(130315);
        aBF();
        AppMethodBeat.o(130315);
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
    }

    private void aBF() {
        AppMethodBeat.i(130316);
        if (this.htP && this.htQ) {
            clearAnimation();
            this.htU = ValueAnimator.ofFloat(new float[]{0.0f, 0.0f});
            this.htU.setDuration(300);
            this.htU.setRepeatCount(-1);
            this.htU.setRepeatMode(1);
            this.htU.setInterpolator(new LinearInterpolator());
            this.htU.addUpdateListener(new AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(130309);
                    BootstrapProgressBar.this.invalidate();
                    AppMethodBeat.o(130309);
                }
            });
            this.htU.start();
            AppMethodBeat.o(130316);
            return;
        }
        AppMethodBeat.o(130316);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(130317);
        setMeasuredDimension(MeasureSpec.getSize(i), MeasureSpec.getSize(i2));
        AppMethodBeat.o(130317);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(130318);
        if (i2 != i4) {
            this.htY = null;
        }
        super.onSizeChanged(i, i2, i3, i4);
        AppMethodBeat.o(130318);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(130319);
        float width = (float) getWidth();
        float height = (float) getHeight();
        if (width <= 0.0f || height <= 0.0f) {
            AppMethodBeat.o(130319);
            return;
        }
        if (this.htX == null) {
            this.htX = Bitmap.createBitmap((int) width, (int) height, Config.ARGB_8888);
        }
        if (this.htW == null) {
            this.htW = new Canvas(this.htX);
        }
        this.htW.drawColor(0, Mode.CLEAR);
        float f = this.htM / this.htO;
        int i = (int) (width * f);
        float f2 = 0.0f;
        float currentTimeMillis = ((float) (System.currentTimeMillis() % 370)) / 370.0f;
        if (this.htP && this.htQ) {
            f2 = (2.0f * height) * (1.0f - currentTimeMillis);
        }
        if (f < 1.0f) {
            this.htW.save();
            Path path = new Path();
            path.moveTo(0.0f, 0.0f);
            path.lineTo((float) i, 0.0f);
            path.lineTo(((float) i) - height, height);
            path.lineTo(0.0f, height);
            this.htW.clipPath(path);
        }
        if (this.htP) {
            if (this.htY == null) {
                Paint paint = this.htK;
                Paint paint2 = this.htJ;
                Bitmap createBitmap = Bitmap.createBitmap(((int) height) * 2, (int) height, Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap);
                Path path2 = new Path();
                path2.moveTo(0.0f, 0.0f);
                path2.lineTo(height, 0.0f);
                path2.lineTo(0.0f, height);
                canvas2.drawPath(path2, paint);
                path2.reset();
                path2.moveTo(0.0f + height, 0.0f);
                path2.lineTo(0.0f, height);
                path2.lineTo(0.0f + height, height);
                path2.lineTo(0.0f + (2.0f * height), 0.0f);
                canvas2.drawPath(path2, paint2);
                float f3 = 0.0f + (2.0f * height);
                path2.reset();
                path2.moveTo(f3, 0.0f);
                path2.lineTo(f3 - height, height);
                path2.lineTo(f3, height);
                canvas2.drawPath(path2, paint);
                this.htY = createBitmap;
            }
            f2 = 0.0f - f2;
            while (f2 < ((float) i)) {
                this.htW.drawBitmap(this.htY, f2, 0.0f, this.htV);
                f2 += (float) this.htY.getWidth();
            }
        } else {
            this.htW.drawRect(0.0f, 0.0f, (float) i, height, this.htJ);
        }
        if (f < 1.0f) {
            this.htW.restore();
        }
        Path path3 = new Path();
        path3.moveTo(0.0f, 0.0f);
        path3.lineTo(width, 0.0f);
        path3.lineTo(width, height);
        path3.lineTo(0.0f, height);
        this.htW.drawPath(path3, this.htL);
        f2 = this.htR ? height / 2.0f : 0.0f;
        Bitmap bitmap = this.htX;
        boolean z = this.htT;
        boolean z2 = this.htS;
        Bitmap createBitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas3 = new Canvas(createBitmap2);
        Paint paint3 = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        Rect rect2 = new Rect(0, 0, bitmap.getWidth() / 2, bitmap.getHeight());
        Rect rect3 = new Rect(bitmap.getWidth() / 2, 0, bitmap.getWidth(), bitmap.getHeight());
        paint3.setAntiAlias(true);
        paint3.setColor(-1);
        paint3.setStyle(Style.FILL);
        canvas3.drawARGB(0, 0, 0, 0);
        canvas3.drawRoundRect(new RectF(rect), f2, f2, paint3);
        if (!z2) {
            canvas3.drawRect(rect2, paint3);
        }
        if (!z) {
            canvas3.drawRect(rect3, paint3);
        }
        paint3.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas3.drawBitmap(bitmap, rect, rect, paint3);
        canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, this.htV);
        AppMethodBeat.o(130319);
    }

    @SuppressLint({"DefaultLocale"})
    public void setProgress(float f) {
        AppMethodBeat.i(130320);
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > this.htO) {
            f = 100.0f;
        }
        this.htM = f;
        if (this.htQ) {
            clearAnimation();
            this.htU = ValueAnimator.ofFloat(new float[]{this.htN, this.htM});
            this.htU.setDuration(300);
            this.htU.setRepeatCount(0);
            this.htU.setRepeatMode(1);
            this.htU.setInterpolator(new LinearInterpolator());
            this.htU.addUpdateListener(this);
            this.htU.addListener(this);
            this.htU.start();
            AppMethodBeat.o(130320);
            return;
        }
        this.htN = f;
        invalidate();
        AppMethodBeat.o(130320);
    }

    public float getProgress() {
        return this.htM;
    }

    public void setStriped(boolean z) {
        AppMethodBeat.i(130321);
        this.htP = z;
        invalidate();
        aBF();
        AppMethodBeat.o(130321);
    }

    public void setAnimated(boolean z) {
        AppMethodBeat.i(130322);
        this.htQ = z;
        invalidate();
        aBF();
        AppMethodBeat.o(130322);
    }

    public float getMaxProgress() {
        return this.htO;
    }

    public void setMaxProgress(float f) {
        AppMethodBeat.i(130323);
        if (getProgress() <= f) {
            this.htO = f;
            invalidate();
            AppMethodBeat.o(130323);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("MaxProgress cant be smaller than the current progress %d<%d", new Object[]{Float.valueOf(getProgress()), Float.valueOf(f)}));
        AppMethodBeat.o(130323);
        throw illegalArgumentException;
    }
}
