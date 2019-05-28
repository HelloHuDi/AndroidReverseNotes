package com.tencent.mm.pluginsdk.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Random;

public final class k extends Drawable {
    private Paint aFY = new Paint(1);
    private Context context;
    private int currentState = 2;
    private float hcR = -90.0f;
    private float hcS = 0.0f;
    private ValueAnimator jcQ = ValueAnimator.ofFloat(new float[]{0.0f, 100.0f});
    private int mMA;
    private int mMB = 0;
    private boolean mMC = false;
    private int mMD;
    private int mMv = 0;
    private int mMw = 0;
    private int mMx;
    private int mMy;
    private int mMz;
    private float mYY = 0.0f;
    private Random random = new Random(System.currentTimeMillis());
    private Drawable viJ = null;
    private Interpolator viK = new LinearInterpolator();
    private Interpolator viL = new AccelerateDecelerateInterpolator();
    private int viM;
    private int viN;
    private int viO;
    private int viP;
    private int viQ;
    private int viR;
    private float viS = 0.0f;
    private float viT = 5.0f;
    private int viU;
    private int viV;
    private RectF viW;

    public k(Context context) {
        AppMethodBeat.i(27543);
        this.jcQ.setInterpolator(this.viK);
        this.jcQ.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(27542);
                k.this.mYY = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                k.this.invalidateSelf();
                AppMethodBeat.o(27542);
            }
        });
        this.viW = new RectF();
        this.context = context;
        this.mMv = a.i(context, R.color.a61);
        this.mMw = a.i(context, R.color.w0);
        this.viJ = context.getResources().getDrawable(R.raw.voiceinput_icon_button);
        this.viO = a.am(context, R.dimen.aae);
        this.viP = a.am(context, R.dimen.aad);
        this.viQ = a.am(context, R.dimen.aa4);
        this.mMB = a.am(context, R.dimen.aa9);
        this.mMx = a.i(context, R.color.a42);
        this.viN = a.am(context, R.dimen.aa6);
        this.viR = a.am(context, R.dimen.aa5);
        this.mMA = a.i(context, R.color.a43);
        this.viU = this.viR;
        this.viV = this.viU;
        this.mMD = a.am(context, R.dimen.aa8);
        this.mMy = a.am(context, R.dimen.aa8);
        this.mMz = a.am(context, R.dimen.aa7);
        this.viM = a.am(context, R.dimen.aaf);
        AppMethodBeat.o(27543);
    }

    public final void djl() {
        AppMethodBeat.i(27544);
        ab.d("MicroMsg.VoiceInputDrawable", "longClickState %s", Integer.valueOf(this.currentState));
        this.currentState = 7;
        this.jcQ.cancel();
        this.mYY = 0.0f;
        invalidateSelf();
        AppMethodBeat.o(27544);
    }

    public final void bBx() {
        AppMethodBeat.i(27545);
        ab.d("MicroMsg.VoiceInputDrawable", "readyState %s", Integer.valueOf(this.currentState));
        this.currentState = 2;
        this.jcQ.cancel();
        this.mYY = 0.0f;
        this.hcR = -90.0f;
        this.viS = 0.0f;
        this.hcS = 0.0f;
        this.viT = 5.0f;
        invalidateSelf();
        AppMethodBeat.o(27545);
    }

    public final void djm() {
        AppMethodBeat.i(27546);
        ab.d("MicroMsg.VoiceInputDrawable", "readyPressState %s", Integer.valueOf(this.currentState));
        this.currentState = 6;
        this.jcQ.cancel();
        this.mYY = 0.0f;
        invalidateSelf();
        AppMethodBeat.o(27546);
    }

    public final void oy(boolean z) {
        AppMethodBeat.i(27547);
        ab.d("MicroMsg.VoiceInputDrawable", "recordingStartState() called with: maxAmplitudeRate = [%s] fromLongCkick = %s", Integer.valueOf(0), Boolean.valueOf(z));
        if (!z) {
            this.currentState = 3;
        }
        this.mMC = true;
        invalidateSelf();
        AppMethodBeat.o(27547);
    }

    public final void KO(int i) {
        boolean z = true;
        AppMethodBeat.i(27548);
        ab.d("MicroMsg.VoiceInputDrawable", "recordingState() called with: maxAmplitudeRate = [%s]", Integer.valueOf(i));
        if (i >= 28) {
            z = false;
        }
        this.mMC = z;
        invalidateSelf();
        AppMethodBeat.o(27548);
    }

    public final void djn() {
        AppMethodBeat.i(27549);
        ab.d("MicroMsg.VoiceInputDrawable", "recognizingState %s", Integer.valueOf(this.currentState));
        this.currentState = 4;
        this.jcQ.cancel();
        this.mYY = 0.0f;
        this.jcQ.setInterpolator(new AccelerateDecelerateInterpolator());
        this.jcQ.setDuration(1000);
        this.jcQ.setRepeatCount(-1);
        this.jcQ.start();
        AppMethodBeat.o(27549);
    }

    public final void djo() {
        AppMethodBeat.i(27550);
        ab.d("MicroMsg.VoiceInputDrawable", "disableState %s", Integer.valueOf(this.currentState));
        this.currentState = 5;
        this.jcQ.cancel();
        this.mYY = 0.0f;
        invalidateSelf();
        AppMethodBeat.o(27550);
    }

    public final void draw(Canvas canvas) {
        int width;
        int height;
        AppMethodBeat.i(27551);
        if ((this.currentState == 6 || this.currentState == 7) && !j(canvas)) {
            width = canvas.getWidth() >> 1;
            height = canvas.getHeight() >> 1;
            this.aFY.setShader(null);
            this.aFY.setStyle(Style.FILL);
            this.aFY.setColor(this.mMx);
            if (this.currentState == 7) {
                if (this.mMC) {
                    this.mMD -= 4;
                } else {
                    this.mMD += 4;
                }
                this.mMD = Math.min(Math.max(this.mMy, this.mMD), this.mMz);
                canvas.drawCircle((float) width, (float) height, (float) this.mMD, this.aFY);
            } else {
                canvas.drawCircle((float) width, (float) height, (float) this.mMy, this.aFY);
            }
        }
        if (!(this.viJ == null || j(canvas))) {
            if (this.currentState == 5) {
                this.viJ.setColorFilter(this.mMw, Mode.SRC_ATOP);
            } else {
                this.viJ.setColorFilter(this.mMv, Mode.SRC_ATOP);
            }
            width = canvas.getWidth() / 2;
            height = canvas.getHeight() / 2;
            this.viJ.setBounds(width - this.mMB, height - this.mMB, width + this.mMB, height + this.mMB);
            this.viJ.draw(canvas);
        }
        if (this.currentState == 4 && canvas != null) {
            this.aFY.setColor(this.mMv);
            this.aFY.setStrokeWidth((float) this.viM);
            this.aFY.setStyle(Style.STROKE);
            this.aFY.clearShadowLayer();
            this.aFY.setShader(null);
            this.viW.left = (float) ((canvas.getWidth() / 2) - this.viR);
            this.viW.top = (float) ((canvas.getHeight() / 2) - this.viR);
            this.viW.right = (float) ((canvas.getWidth() / 2) + this.viR);
            this.viW.bottom = (float) ((canvas.getHeight() / 2) + this.viR);
            canvas.drawArc(this.viW, this.hcR, this.hcS, false, this.aFY);
            this.hcR += this.viS;
            this.hcS += this.viT;
            if (this.hcS >= 360.0f) {
                this.viT = -this.viT;
                this.viS = 5.0f;
            } else if (this.hcS <= 0.0f) {
                this.viT = -this.viT;
                this.viS = 0.0f;
                this.hcR = -90.0f;
                this.hcS = 0.0f;
            }
        }
        if ((this.currentState == 6 || this.currentState == 7) && !j(canvas)) {
            this.aFY.setStyle(Style.FILL);
            this.aFY.setColor(this.mMA);
            canvas.drawCircle((float) (canvas.getWidth() >> 1), (float) (canvas.getHeight() >> 1), (float) this.mMB, this.aFY);
        }
        AppMethodBeat.o(27551);
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getIntrinsicWidth() {
        AppMethodBeat.i(27552);
        if (this.context == null) {
            AppMethodBeat.o(27552);
            return 0;
        }
        int gd = a.gd(this.context);
        AppMethodBeat.o(27552);
        return gd;
    }

    public final int getIntrinsicHeight() {
        return this.mMB * 2;
    }

    public final int getOpacity() {
        return -3;
    }

    private static boolean j(Canvas canvas) {
        AppMethodBeat.i(27553);
        if (canvas == null || canvas.getWidth() == 0 || canvas.getHeight() == 0) {
            AppMethodBeat.o(27553);
            return true;
        }
        AppMethodBeat.o(27553);
        return false;
    }
}
