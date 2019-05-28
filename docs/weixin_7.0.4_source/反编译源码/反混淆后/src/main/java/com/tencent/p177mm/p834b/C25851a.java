package com.tencent.p177mm.p834b;

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
import com.tencent.p177mm.p226e.C1497c;
import com.tencent.p177mm.p651y.C24186a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.model.WMElement;

/* renamed from: com.tencent.mm.b.a */
public final class C25851a extends C9065b {
    private int ccc = 200;
    C1497c ccd;
    public float cce;
    public float ccf;
    public float ccg;
    public Rect cch;
    public RectF cci;
    Matrix ccj;
    public long cck = 0;
    /* renamed from: rD */
    private ValueAnimator f13659rD;
    /* renamed from: uw */
    public AnimatorListener f13660uw;

    /* renamed from: com.tencent.mm.b.a$2 */
    class C179702 implements AnimatorListener {
        C179702() {
        }

        public final void onAnimationStart(Animator animator) {
            C25851a.this.ccd.cjE = true;
            C25851a.this.cco = false;
            C25851a.this.aFV = true;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(116137);
            C25851a.this.cco = true;
            C25851a.this.aFV = false;
            C25851a.this.cck = 0;
            C25851a.this.ccd.mo4950CS();
            C25851a.this.ccd.mo20697CQ();
            if (C25851a.this.f13660uw != null) {
                C25851a.this.f13660uw.onAnimationEnd(animator);
            }
            AppMethodBeat.m2505o(116137);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    /* renamed from: com.tencent.mm.b.a$1 */
    class C258521 implements AnimatorUpdateListener {
        Matrix ccl = new Matrix(C25851a.this.ccd.getMainMatrix());
        Rect ccm = new Rect(C25851a.this.cch);

        C258521() {
            AppMethodBeat.m2504i(116135);
            AppMethodBeat.m2505o(116135);
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(116136);
            float floatValue = ((Float) valueAnimator.getAnimatedValue("deltaY")).floatValue();
            float floatValue2 = ((Float) valueAnimator.getAnimatedValue("deltaX")).floatValue();
            float floatValue3 = ((Float) valueAnimator.getAnimatedValue(WMElement.ANIMATE_TYPE_SCALE)).floatValue();
            float floatValue4 = ((Float) valueAnimator.getAnimatedValue("background_alpha")).floatValue();
            C25851a.this.ccj.reset();
            C25851a.this.ccj.postTranslate(floatValue2, floatValue);
            RectF rectF = new RectF(this.ccm);
            C25851a.this.ccj.mapRect(rectF);
            rectF.round(C25851a.this.cch);
            C25851a.this.ccj.postScale(floatValue3, floatValue3, (float) C25851a.this.cch.centerX(), (float) C25851a.this.cch.centerY());
            Matrix matrix = new Matrix(this.ccl);
            matrix.postConcat(C25851a.this.ccj);
            C25851a.this.ccd.getMainMatrix().set(matrix);
            C24186a.m37170jA((int) floatValue4);
            RectF rectF2 = new RectF(this.ccm);
            C25851a.this.ccj.mapRect(rectF2);
            rectF2.round(C25851a.this.cch);
            C25851a.this.ccd.mo20696CP();
            AppMethodBeat.m2505o(116136);
        }
    }

    public C25851a(C1497c c1497c) {
        AppMethodBeat.m2504i(116138);
        this.ccd = c1497c;
        this.ccj = new Matrix();
        this.cci = new RectF();
        AppMethodBeat.m2505o(116138);
    }

    public final void play() {
        AppMethodBeat.m2504i(116139);
        C4990ab.m7416i("MicroMsg.CropActionUpAnim", "[play]");
        if (this.cco) {
            this.aFV = false;
            this.cco = false;
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(WMElement.ANIMATE_TYPE_SCALE, new float[]{1.0f, this.cce});
            PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("deltaX", new float[]{0.0f, this.ccf});
            PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("deltaY", new float[]{0.0f, this.ccg});
            PropertyValuesHolder ofFloat4 = PropertyValuesHolder.ofFloat("background_alpha", new float[]{0.0f, 255.0f});
            this.f13659rD = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofFloat, ofFloat2, ofFloat3, ofFloat4});
            this.f13659rD.addUpdateListener(new C258521());
            this.f13659rD.addListener(new C179702());
            this.f13659rD.setInterpolator(new LinearInterpolator());
            this.f13659rD.setDuration((long) this.ccc);
            this.f13659rD.setStartDelay(this.cck);
            this.f13659rD.start();
            AppMethodBeat.m2505o(116139);
            return;
        }
        AppMethodBeat.m2505o(116139);
    }

    public final void cancel() {
        AppMethodBeat.m2504i(116140);
        C4990ab.m7410d("MicroMsg.CropActionUpAnim", "[cancel]");
        this.aFV = false;
        this.cco = true;
        if (this.f13659rD != null) {
            this.f13659rD.cancel();
        }
        AppMethodBeat.m2505o(116140);
    }
}
