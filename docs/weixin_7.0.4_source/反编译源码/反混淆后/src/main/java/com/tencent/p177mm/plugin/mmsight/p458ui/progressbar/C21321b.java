package com.tencent.p177mm.plugin.mmsight.p458ui.progressbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.mmsight.ui.progressbar.b */
public final class C21321b {
    ValueAnimator jcQ;
    C28527a oDU;
    C28527a oDV;
    boolean oDW = false;
    public C21322a oDX;
    PointF oDY;
    PointF oDZ;
    PointF oEa;
    PointF oEb;
    PointF oEc;
    PointF oEd;
    float oEe = 0.0f;
    float oEf = 0.0f;
    float oEg = 0.0f;
    float oEh = 0.0f;
    Path oEi;
    private Paint oEj = null;
    float progress = 0.0f;

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.progressbar.b$2 */
    class C35102 extends AnimatorListenerAdapter {
        C35102() {
        }

        public final void onAnimationStart(Animator animator) {
            C21321b.this.oDW = true;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(55342);
            C21321b.this.oDW = true;
            if (C21321b.this.oDX != null) {
                C21321b.this.oDX.mo36742a(C21321b.this.oDV);
            }
            AppMethodBeat.m2505o(55342);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.progressbar.b$1 */
    class C213201 implements AnimatorUpdateListener {
        C213201() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(55341);
            C21321b.this.progress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            C21321b c21321b = C21321b.this;
            float f = C21321b.this.progress;
            c21321b.oEh = (float) ((int) (((float) Math.round((float) (MMSightProgressBar.oDH + (MMSightProgressBar.lEk * 2)))) * (f / 100.0f)));
            c21321b.oEe = c21321b.oEf - ((f / 100.0f) * (c21321b.oEf - c21321b.oEg));
            c21321b.oDY = new PointF((float) MMSightProgressBar.lEk, 0.0f);
            c21321b.oDZ = new PointF(((float) MMSightProgressBar.lEk) + (c21321b.oEh / 2.0f), ((float) MMSightProgressBar.lEk) - (c21321b.oEe / 2.0f));
            c21321b.oEa = new PointF(((float) MMSightProgressBar.lEk) + c21321b.oEh, 0.0f);
            c21321b.oEb = new PointF((float) MMSightProgressBar.lEk, (float) (MMSightProgressBar.lEk * 2));
            c21321b.oEc = new PointF(((float) MMSightProgressBar.lEk) + (c21321b.oEh / 2.0f), ((float) MMSightProgressBar.lEk) + (c21321b.oEe / 2.0f));
            c21321b.oEd = new PointF(((float) MMSightProgressBar.lEk) + c21321b.oEh, ((float) MMSightProgressBar.lEk) * 2.0f);
            C4990ab.m7411d("MicroMsg.MMSightProgressPointSplitter", "calPoints, currentPointDistance: %s, curveCenterDistance: %s", Float.valueOf(c21321b.oEh), Float.valueOf(c21321b.oEe));
            C4990ab.m7411d("MicroMsg.MMSightProgressPointSplitter", "calPoints, point1: %s, point2: %s, point3: %s, point4: %s, point5: %s, point6: %s", c21321b.oDY, c21321b.oDZ, c21321b.oEa, c21321b.oEb, c21321b.oEc, c21321b.oEd);
            if (C21321b.this.oDX != null) {
                C21321b.this.oDX.bQN();
            }
            AppMethodBeat.m2505o(55341);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.progressbar.b$a */
    public interface C21322a {
        /* renamed from: a */
        void mo36742a(C28527a c28527a);

        void bQN();
    }

    public C21321b(C28527a c28527a, C28527a c28527a2, C21322a c21322a) {
        AppMethodBeat.m2504i(55343);
        this.oDU = c28527a;
        this.oDV = c28527a2;
        this.oDX = c21322a;
        this.oEf = ((float) MMSightProgressBar.lEk) * 2.0f;
        this.oEg = ((float) (-MMSightProgressBar.lEk)) * 0.5f;
        this.oEi = new Path();
        this.oEj = new Paint();
        this.oEj.setAntiAlias(true);
        this.oEj.setStyle(Style.FILL);
        AppMethodBeat.m2505o(55343);
    }
}
