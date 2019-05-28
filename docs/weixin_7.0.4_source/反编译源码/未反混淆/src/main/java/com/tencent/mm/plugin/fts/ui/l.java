package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashSet;

public final class l extends d implements b {
    private ak ilv = new ak();
    private boolean mIF;
    private com.tencent.mm.plugin.fts.ui.d.l mJL;

    public l(e eVar, String str, int i) {
        super(eVar);
        AppMethodBeat.i(61943);
        this.mJL = new com.tencent.mm.plugin.fts.ui.d.l(eVar.getContext(), this, i);
        this.mJL.mEq = str;
        AppMethodBeat.o(61943);
    }

    /* Access modifiers changed, original: protected|final */
    public final a vZ(int i) {
        AppMethodBeat.i(61944);
        a vZ = this.mJL.vZ(i);
        if (vZ != null) {
            vZ.pageType = 3;
        }
        AppMethodBeat.o(61944);
        return vZ;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAL() {
        AppMethodBeat.i(61945);
        this.mIF = false;
        this.mJL.a(this.query, this.ilv, new HashSet());
        AppMethodBeat.o(61945);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean a(View view, a aVar, boolean z) {
        AppMethodBeat.i(61946);
        boolean a = this.mJL.a(view, aVar, z);
        if (aVar.mFt && !this.mIF) {
            this.mIF = true;
            k.c(this.query, true, this.mJL.bAK(), -2);
        }
        if (a) {
            clearCache();
            setCount(this.mJL.vY(0));
            notifyDataSetChanged();
            T(getCount(), true);
        }
        AppMethodBeat.o(61946);
        return a;
    }

    public final void a(e eVar, String str) {
        AppMethodBeat.i(61947);
        setCount(eVar.vY(0));
        notifyDataSetChanged();
        T(getCount(), true);
        AppMethodBeat.o(61947);
    }

    public final void finish() {
        AppMethodBeat.i(61948);
        super.finish();
        if (!this.mIF) {
            this.mIF = true;
            k.c(this.query, false, this.mJL.bAK(), -2);
        }
        AppMethodBeat.o(61948);
    }

    /* Access modifiers changed, original: protected|final */
    public final int bAt() {
        AppMethodBeat.i(139152);
        int bAK = this.mJL.bAK();
        AppMethodBeat.o(139152);
        return bAK;
    }
}
