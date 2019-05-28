package com.b.a.a;

import android.content.Context;
import android.os.Handler;

abstract class a extends d implements m {
    private final d[] bCF;
    private final Handler[] bCG = new Handler[this.bCF.length];
    private final a[] bCH = new a[this.bCG.length];

    public abstract void a(Handler handler, Handler[] handlerArr);

    public abstract void a(a aVar, a[] aVarArr);

    a(d... dVarArr) {
        this.bCF = dVarArr;
    }

    /* Access modifiers changed, original: final */
    public final void at(Context context) {
        for (d a : this.bCF) {
            try {
                a.a(context, this);
            } catch (Exception e) {
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void a(Context context, Handler handler, a aVar) {
        a(handler, this.bCG);
        a(aVar, this.bCH);
        for (int i = 0; i < this.bCF.length; i++) {
            try {
                this.bCF[i].a(this.bCG[i], this.bCH[i]);
            } catch (Exception e) {
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void au(Context context) {
        for (d stop : this.bCF) {
            stop.stop();
        }
    }

    /* Access modifiers changed, original: final */
    public final void vV() {
        for (d vY : this.bCF) {
            vY.vY();
        }
    }
}
