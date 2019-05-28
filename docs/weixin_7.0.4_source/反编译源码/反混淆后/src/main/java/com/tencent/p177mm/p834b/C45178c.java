package com.tencent.p177mm.p834b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.cache.C24666c;
import com.tencent.p177mm.p226e.C32495e;
import com.tencent.p177mm.p651y.C36398c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ListIterator;

/* renamed from: com.tencent.mm.b.c */
public final class C45178c extends C9065b {
    public float ccf;
    public float ccg;
    C32495e ccp;
    public C36398c ccq;
    public String ccr;
    float ccs = 0.0f;
    float cct = 0.0f;
    /* renamed from: rD */
    public ValueAnimator f17873rD;

    /* renamed from: com.tencent.mm.b.c$1 */
    public class C258531 implements AnimatorUpdateListener {
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(116141);
            float floatValue = ((Float) valueAnimator.getAnimatedValue("deltaY")).floatValue();
            float floatValue2 = ((Float) valueAnimator.getAnimatedValue("deltaX")).floatValue();
            C4990ab.m7411d("MicroMsg.StickBackAnim", "animatorValueY:%s  %s", Float.valueOf(floatValue), Float.valueOf(floatValue - C45178c.this.ccs));
            C32495e c32495e = C45178c.this.ccp;
            float f = floatValue2 - C45178c.this.cct;
            float f2 = floatValue - C45178c.this.ccs;
            String str = C45178c.this.ccr;
            C24666c c24666c = (C24666c) c32495e.mo20691CI();
            if (c24666c != null) {
                ListIterator Jj = c24666c.mo41559Jj();
                while (Jj.hasPrevious()) {
                    C36398c c36398c = (C36398c) Jj.previous();
                    if (c36398c.eHf.equals(str)) {
                        c36398c.eHi.offset(f, f2);
                        c32495e.mo20696CP();
                        break;
                    }
                }
            }
            C4990ab.m7420w("MicroMsg.EmojiAndTextArtist", "cache is null!");
            C45178c.this.ccs = floatValue;
            C45178c.this.cct = floatValue2;
            AppMethodBeat.m2505o(116141);
        }
    }

    /* renamed from: com.tencent.mm.b.c$2 */
    public class C375022 implements AnimatorListener {
        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(116142);
            C45178c.this.cco = false;
            C45178c.this.ccs = 0.0f;
            C45178c.this.cct = 0.0f;
            C4990ab.m7410d("MicroMsg.StickBackAnim", "onAnimationStart");
            AppMethodBeat.m2505o(116142);
        }

        public final void onAnimationEnd(Animator animator) {
            C45178c.this.cco = true;
            C45178c.this.ccs = 0.0f;
            C45178c.this.cct = 0.0f;
        }

        public final void onAnimationCancel(Animator animator) {
            C45178c.this.cco = true;
            C45178c.this.ccs = 0.0f;
            C45178c.this.cct = 0.0f;
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    public C45178c(C32495e c32495e) {
        this.ccp = c32495e;
    }
}
