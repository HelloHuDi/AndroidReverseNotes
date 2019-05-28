package com.tencent.mm.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.model.WMElement;

public final class a extends b {
    private int ccc = 200;
    c ccd;
    public float cce;
    public float ccf;
    public float ccg;
    public Rect cch;
    public RectF cci;
    Matrix ccj;
    public long cck = 0;
    private ValueAnimator rD;
    public AnimatorListener uw;

    public a(c cVar) {
        AppMethodBeat.i(116138);
        this.ccd = cVar;
        this.ccj = new Matrix();
        this.cci = new RectF();
        AppMethodBeat.o(116138);
    }

    public final void play() {
        AppMethodBeat.i(116139);
        ab.i("MicroMsg.CropActionUpAnim", "[play]");
        if (this.cco) {
            this.aFV = false;
            this.cco = false;
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(WMElement.ANIMATE_TYPE_SCALE, new float[]{1.0f, this.cce});
            PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("deltaX", new float[]{0.0f, this.ccf});
            PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("deltaY", new float[]{0.0f, this.ccg});
            PropertyValuesHolder ofFloat4 = PropertyValuesHolder.ofFloat("background_alpha", new float[]{0.0f, 255.0f});
            this.rD = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofFloat, ofFloat2, ofFloat3, ofFloat4});
            this.rD.addUpdateListener(new AnimatorUpdateListener() {
                Matrix ccl = new Matrix(a.this.ccd.getMainMatrix());
                Rect ccm = new Rect(a.this.cch);

                {
                    AppMethodBeat.i(116135);
                    AppMethodBeat.o(116135);
                }

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(116136);
                    float floatValue = ((Float) valueAnimator.getAnimatedValue("deltaY")).floatValue();
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue("deltaX")).floatValue();
                    float floatValue3 = ((Float) valueAnimator.getAnimatedValue(WMElement.ANIMATE_TYPE_SCALE)).floatValue();
                    float floatValue4 = ((Float) valueAnimator.getAnimatedValue("background_alpha")).floatValue();
                    a.this.ccj.reset();
                    a.this.ccj.postTranslate(floatValue2, floatValue);
                    RectF rectF = new RectF(this.ccm);
                    a.this.ccj.mapRect(rectF);
                    rectF.round(a.this.cch);
                    a.this.ccj.postScale(floatValue3, floatValue3, (float) a.this.cch.centerX(), (float) a.this.cch.centerY());
                    Matrix matrix = new Matrix(this.ccl);
                    matrix.postConcat(a.this.ccj);
                    a.this.ccd.getMainMatrix().set(matrix);
                    com.tencent.mm.y.a.jA((int) floatValue4);
                    RectF rectF2 = new RectF(this.ccm);
                    a.this.ccj.mapRect(rectF2);
                    rectF2.round(a.this.cch);
                    a.this.ccd.CP();
                    AppMethodBeat.o(116136);
                }
            });
            this.rD.addListener(new AnimatorListener() {
                public final void onAnimationStart(Animator animator) {
                    a.this.ccd.cjE = true;
                    a.this.cco = false;
                    a.this.aFV = true;
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(116137);
                    a.this.cco = true;
                    a.this.aFV = false;
                    a.this.cck = 0;
                    a.this.ccd.CS();
                    a.this.ccd.CQ();
                    if (a.this.uw != null) {
                        a.this.uw.onAnimationEnd(animator);
                    }
                    AppMethodBeat.o(116137);
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
            this.rD.setInterpolator(new LinearInterpolator());
            this.rD.setDuration((long) this.ccc);
            this.rD.setStartDelay(this.cck);
            this.rD.start();
            AppMethodBeat.o(116139);
            return;
        }
        AppMethodBeat.o(116139);
    }

    public final void cancel() {
        AppMethodBeat.i(116140);
        ab.d("MicroMsg.CropActionUpAnim", "[cancel]");
        this.aFV = false;
        this.cco = true;
        if (this.rD != null) {
            this.rD.cancel();
        }
        AppMethodBeat.o(116140);
    }
}
