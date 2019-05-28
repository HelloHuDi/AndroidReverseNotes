package com.tencent.mm.plugin.freewifi.d;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.al;

public abstract class c extends m implements k {
    protected Activity activity;
    protected b ehh;
    protected f ehi;
    protected f mww;

    public abstract void bzd();

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        com.tencent.mm.plugin.freewifi.m.MA("netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " returns [" + i2 + "," + i3 + "]");
        if (this.mww != null) {
            this.mww.onSceneEnd(i2, i3, str, this);
        }
        if ((this.activity == null || !this.activity.isFinishing()) && this.ehi != null) {
            final int i4 = i;
            final int i5 = i2;
            final int i6 = i3;
            final String str2 = str;
            final q qVar2 = qVar;
            final byte[] bArr2 = bArr;
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(20778);
                    c.this.b(i4, i5, i6, str2);
                    if (c.this.ehi != null) {
                        c.this.ehi.onSceneEnd(i5, i6, str2, c.this);
                    }
                    AppMethodBeat.o(20778);
                }
            });
        }
    }

    /* Access modifiers changed, original: protected */
    public void b(int i, int i2, int i3, String str) {
    }

    public final void c(f fVar) {
        this.ehi = fVar;
        com.tencent.mm.plugin.freewifi.m.MA("netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " is started.");
        aw.Rg().a((m) this, 0);
    }

    public final int a(e eVar, f fVar) {
        this.mww = fVar;
        return a(eVar, this.ehh, this);
    }

    public final c O(Activity activity) {
        this.activity = activity;
        return this;
    }
}
