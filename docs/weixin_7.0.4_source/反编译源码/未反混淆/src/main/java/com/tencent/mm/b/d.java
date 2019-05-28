package com.tencent.mm.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.b.a;

public final class d extends b {
    public a ccv;
    public float ccw;
    public float ccx;
    public boolean ccy = true;
    public boolean ccz = false;
    public float mScale = 1.0f;
    public ValueAnimator rD;

    /* renamed from: com.tencent.mm.b.d$1 */
    public class AnonymousClass1 implements AnimatorUpdateListener {
        int ccA = 0;
        float ccB = ((float) Math.pow((double) (d.this.mScale / this.ccC), 0.25d));
        final /* synthetic */ float ccC;
        float ccs = 0.0f;
        float cct = 0.0f;

        public AnonymousClass1(float f) {
            this.ccC = f;
            AppMethodBeat.i(116143);
            AppMethodBeat.o(116143);
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float f;
            float f2 = 0.0f;
            AppMethodBeat.i(116144);
            float floatValue = ((Float) valueAnimator.getAnimatedValue("deltaY")).floatValue();
            float floatValue2 = ((Float) valueAnimator.getAnimatedValue("deltaX")).floatValue();
            if (this.ccA < 4 && d.this.ccy) {
                d.this.ccv.getMainMatrix().postScale(this.ccB, this.ccB);
                this.ccA++;
            }
            RectF curImageRect = d.this.ccv.getCurImageRect();
            Rect boardRect = d.this.ccv.getBoardRect();
            if (d.this.ccz) {
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
                d dVar = d.this;
                dVar.ccw += floatValue2 - this.cct;
                dVar = d.this;
                dVar.ccx += floatValue - this.ccs;
                f2 = d.this.ccw - curImageRect.centerX();
                f = d.this.ccx - curImageRect.centerY();
            }
            d.this.ccv.getMainMatrix().postTranslate(f2, f);
            d.this.ccv.postInvalidate();
            this.ccs = floatValue;
            this.cct = floatValue2;
            AppMethodBeat.o(116144);
        }
    }

    public d(a aVar) {
        this.ccv = aVar;
    }
}
