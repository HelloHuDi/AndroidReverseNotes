package com.p081b.p082a.p083a;

import android.content.Context;
import android.os.Handler;
import com.p081b.p082a.p083a.C8482d.C8483a;

/* renamed from: com.b.a.a.a */
abstract class C41541a extends C8482d implements C0735m {
    private final C8482d[] bCF;
    private final Handler[] bCG = new Handler[this.bCF.length];
    private final C8483a[] bCH = new C8483a[this.bCG.length];

    /* renamed from: a */
    public abstract void mo42414a(Handler handler, Handler[] handlerArr);

    /* renamed from: a */
    public abstract void mo42415a(C8483a c8483a, C8483a[] c8483aArr);

    C41541a(C8482d... c8482dArr) {
        this.bCF = c8482dArr;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: at */
    public final void mo18560at(Context context) {
        for (C8482d a : this.bCF) {
            try {
                a.mo18558a(context, this);
            } catch (Exception e) {
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo18557a(Context context, Handler handler, C8483a c8483a) {
        mo42414a(handler, this.bCG);
        mo42415a(c8483a, this.bCH);
        for (int i = 0; i < this.bCF.length; i++) {
            try {
                this.bCF[i].mo18559a(this.bCG[i], this.bCH[i]);
            } catch (Exception e) {
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: au */
    public final void mo18561au(Context context) {
        for (C8482d stop : this.bCF) {
            stop.stop();
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: vV */
    public final void mo18564vV() {
        for (C8482d vY : this.bCF) {
            vY.mo18565vY();
        }
    }
}
