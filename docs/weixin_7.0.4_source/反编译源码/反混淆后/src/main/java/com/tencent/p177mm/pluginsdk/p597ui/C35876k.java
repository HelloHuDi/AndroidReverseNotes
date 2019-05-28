package com.tencent.p177mm.pluginsdk.p597ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Random;

/* renamed from: com.tencent.mm.pluginsdk.ui.k */
public final class C35876k extends Drawable {
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

    /* renamed from: com.tencent.mm.pluginsdk.ui.k$1 */
    class C149481 implements AnimatorUpdateListener {
        C149481() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(27542);
            C35876k.this.mYY = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            C35876k.this.invalidateSelf();
            AppMethodBeat.m2505o(27542);
        }
    }

    public C35876k(Context context) {
        AppMethodBeat.m2504i(27543);
        this.jcQ.setInterpolator(this.viK);
        this.jcQ.addUpdateListener(new C149481());
        this.viW = new RectF();
        this.context = context;
        this.mMv = C1338a.m2872i(context, C25738R.color.a61);
        this.mMw = C1338a.m2872i(context, C25738R.color.f12208w0);
        this.viJ = context.getResources().getDrawable(C1318a.voiceinput_icon_button);
        this.viO = C1338a.m2857am(context, C25738R.dimen.aae);
        this.viP = C1338a.m2857am(context, C25738R.dimen.aad);
        this.viQ = C1338a.m2857am(context, C25738R.dimen.aa4);
        this.mMB = C1338a.m2857am(context, C25738R.dimen.aa9);
        this.mMx = C1338a.m2872i(context, C25738R.color.a42);
        this.viN = C1338a.m2857am(context, C25738R.dimen.aa6);
        this.viR = C1338a.m2857am(context, C25738R.dimen.aa5);
        this.mMA = C1338a.m2872i(context, C25738R.color.a43);
        this.viU = this.viR;
        this.viV = this.viU;
        this.mMD = C1338a.m2857am(context, C25738R.dimen.aa8);
        this.mMy = C1338a.m2857am(context, C25738R.dimen.aa8);
        this.mMz = C1338a.m2857am(context, C25738R.dimen.aa7);
        this.viM = C1338a.m2857am(context, C25738R.dimen.aaf);
        AppMethodBeat.m2505o(27543);
    }

    public final void djl() {
        AppMethodBeat.m2504i(27544);
        C4990ab.m7411d("MicroMsg.VoiceInputDrawable", "longClickState %s", Integer.valueOf(this.currentState));
        this.currentState = 7;
        this.jcQ.cancel();
        this.mYY = 0.0f;
        invalidateSelf();
        AppMethodBeat.m2505o(27544);
    }

    public final void bBx() {
        AppMethodBeat.m2504i(27545);
        C4990ab.m7411d("MicroMsg.VoiceInputDrawable", "readyState %s", Integer.valueOf(this.currentState));
        this.currentState = 2;
        this.jcQ.cancel();
        this.mYY = 0.0f;
        this.hcR = -90.0f;
        this.viS = 0.0f;
        this.hcS = 0.0f;
        this.viT = 5.0f;
        invalidateSelf();
        AppMethodBeat.m2505o(27545);
    }

    public final void djm() {
        AppMethodBeat.m2504i(27546);
        C4990ab.m7411d("MicroMsg.VoiceInputDrawable", "readyPressState %s", Integer.valueOf(this.currentState));
        this.currentState = 6;
        this.jcQ.cancel();
        this.mYY = 0.0f;
        invalidateSelf();
        AppMethodBeat.m2505o(27546);
    }

    /* renamed from: oy */
    public final void mo56678oy(boolean z) {
        AppMethodBeat.m2504i(27547);
        C4990ab.m7411d("MicroMsg.VoiceInputDrawable", "recordingStartState() called with: maxAmplitudeRate = [%s] fromLongCkick = %s", Integer.valueOf(0), Boolean.valueOf(z));
        if (!z) {
            this.currentState = 3;
        }
        this.mMC = true;
        invalidateSelf();
        AppMethodBeat.m2505o(27547);
    }

    /* renamed from: KO */
    public final void mo56668KO(int i) {
        boolean z = true;
        AppMethodBeat.m2504i(27548);
        C4990ab.m7411d("MicroMsg.VoiceInputDrawable", "recordingState() called with: maxAmplitudeRate = [%s]", Integer.valueOf(i));
        if (i >= 28) {
            z = false;
        }
        this.mMC = z;
        invalidateSelf();
        AppMethodBeat.m2505o(27548);
    }

    public final void djn() {
        AppMethodBeat.m2504i(27549);
        C4990ab.m7411d("MicroMsg.VoiceInputDrawable", "recognizingState %s", Integer.valueOf(this.currentState));
        this.currentState = 4;
        this.jcQ.cancel();
        this.mYY = 0.0f;
        this.jcQ.setInterpolator(new AccelerateDecelerateInterpolator());
        this.jcQ.setDuration(1000);
        this.jcQ.setRepeatCount(-1);
        this.jcQ.start();
        AppMethodBeat.m2505o(27549);
    }

    public final void djo() {
        AppMethodBeat.m2504i(27550);
        C4990ab.m7411d("MicroMsg.VoiceInputDrawable", "disableState %s", Integer.valueOf(this.currentState));
        this.currentState = 5;
        this.jcQ.cancel();
        this.mYY = 0.0f;
        invalidateSelf();
        AppMethodBeat.m2505o(27550);
    }

    public final void draw(Canvas canvas) {
        int width;
        int height;
        AppMethodBeat.m2504i(27551);
        if ((this.currentState == 6 || this.currentState == 7) && !C35876k.m58812j(canvas)) {
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
        if (!(this.viJ == null || C35876k.m58812j(canvas))) {
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
        if ((this.currentState == 6 || this.currentState == 7) && !C35876k.m58812j(canvas)) {
            this.aFY.setStyle(Style.FILL);
            this.aFY.setColor(this.mMA);
            canvas.drawCircle((float) (canvas.getWidth() >> 1), (float) (canvas.getHeight() >> 1), (float) this.mMB, this.aFY);
        }
        AppMethodBeat.m2505o(27551);
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getIntrinsicWidth() {
        AppMethodBeat.m2504i(27552);
        if (this.context == null) {
            AppMethodBeat.m2505o(27552);
            return 0;
        }
        int gd = C1338a.m2868gd(this.context);
        AppMethodBeat.m2505o(27552);
        return gd;
    }

    public final int getIntrinsicHeight() {
        return this.mMB * 2;
    }

    public final int getOpacity() {
        return -3;
    }

    /* renamed from: j */
    private static boolean m58812j(Canvas canvas) {
        AppMethodBeat.m2504i(27553);
        if (canvas == null || canvas.getWidth() == 0 || canvas.getHeight() == 0) {
            AppMethodBeat.m2505o(27553);
            return true;
        }
        AppMethodBeat.m2505o(27553);
        return false;
    }
}
