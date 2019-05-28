package com.tencent.p177mm.p834b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.view.p1096b.C30844a;

/* renamed from: com.tencent.mm.b.d */
public final class C41784d extends C9065b {
    public C30844a ccv;
    public float ccw;
    public float ccx;
    public boolean ccy = true;
    public boolean ccz = false;
    public float mScale = 1.0f;
    /* renamed from: rD */
    public ValueAnimator f17165rD;

    /* renamed from: com.tencent.mm.b.d$2 */
    public class C375032 implements AnimatorListener {
        public final void onAnimationStart(Animator animator) {
            C41784d.this.cco = false;
        }

        public final void onAnimationEnd(Animator animator) {
            C41784d.this.cco = true;
        }

        public final void onAnimationCancel(Animator animator) {
            C41784d.this.cco = true;
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    /* renamed from: com.tencent.mm.b.d$1 */
    public class C417831 implements AnimatorUpdateListener {
        int ccA = 0;
        float ccB = ((float) Math.pow((double) (C41784d.this.mScale / this.ccC), 0.25d));
        final /* synthetic */ float ccC;
        float ccs = 0.0f;
        float cct = 0.0f;

        public C417831(float f) {
            this.ccC = f;
            AppMethodBeat.m2504i(116143);
            AppMethodBeat.m2505o(116143);
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float f;
            float f2 = 0.0f;
            AppMethodBeat.m2504i(116144);
            float floatValue = ((Float) valueAnimator.getAnimatedValue("deltaY")).floatValue();
            float floatValue2 = ((Float) valueAnimator.getAnimatedValue("deltaX")).floatValue();
            if (this.ccA < 4 && C41784d.this.ccy) {
                C41784d.this.ccv.getMainMatrix().postScale(this.ccB, this.ccB);
                this.ccA++;
            }
            RectF curImageRect = C41784d.this.ccv.getCurImageRect();
            Rect boardRect = C41784d.this.ccv.getBoardRect();
            if (C41784d.this.ccz) {
                if (curImageRect.top > ((float) boardRect.top)) {
                    f = ((float) boardRect.top) - curImageRect.top;
                } else {
                    f = 0.0f;
                }
                if (curImageRect.right < ((float) boardRect.right)) {
                    f2 = ((float) boardRect.right) - curImageRect.right;
                }
                if (curImageRect.bottom < ((float) boardRect.bottom)) {
                    f = ((float) boardRect.bottom) - curImageRect.bottom;
                }
                if (curImageRect.left > ((float) boardRect.left)) {
                    f2 = ((float) boardRect.left) - curImageRect.left;
                }
            } else {
                C41784d c41784d = C41784d.this;
                c41784d.ccw += floatValue2 - this.cct;
                c41784d = C41784d.this;
                c41784d.ccx += floatValue - this.ccs;
                f2 = C41784d.this.ccw - curImageRect.centerX();
                f = C41784d.this.ccx - curImageRect.centerY();
            }
            C41784d.this.ccv.getMainMatrix().postTranslate(f2, f);
            C41784d.this.ccv.postInvalidate();
            this.ccs = floatValue;
            this.cct = floatValue2;
            AppMethodBeat.m2505o(116144);
        }
    }

    public C41784d(C30844a c30844a) {
        this.ccv = c30844a;
    }
}
