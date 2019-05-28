package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.ui.d.g;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashSet;

public final class h extends d implements b {
    private ak ilv = new ak();
    private boolean mIF;
    private g mII;

    public h(e eVar, String str, String str2, String str3, int i, int i2) {
        super(eVar);
        AppMethodBeat.i(61824);
        this.mII = new g(eVar.getContext(), this, i);
        this.mII.mEq = str2;
        this.mII.talker = str;
        this.mII.mEp = str3;
        this.mII.showType = i2;
        AppMethodBeat.o(61824);
    }

    /* Access modifiers changed, original: protected|final */
    public final a vZ(int i) {
        AppMethodBeat.i(61825);
        a vZ = this.mII.vZ(i);
        if (vZ != null) {
            vZ.pageType = 5;
        }
        AppMethodBeat.o(61825);
        return vZ;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAL() {
        AppMethodBeat.i(61826);
        this.mIF = false;
        this.mII.a(this.query, this.ilv, new HashSet());
        AppMethodBeat.o(61826);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean a(View view, a aVar, boolean z) {
        AppMethodBeat.i(61827);
        boolean a = this.mII.a(view, aVar, z);
        if (aVar.mFt && !this.mIF) {
            this.mIF = true;
            k.c(this.query, true, this.mII.bAK(), -2);
        }
        if (a) {
            clearCache();
            setCount(this.mII.vY(0));
            notifyDataSetChanged();
            T(getCount(), true);
        }
        AppMethodBeat.o(61827);
        return a;
    }

    public final void a(e eVar, String str) {
        AppMethodBeat.i(61828);
        setCount(eVar.vY(0));
        notifyDataSetChanged();
        T(getCount(), true);
        AppMethodBeat.o(61828);
    }

    public final void finish() {
        AppMethodBeat.i(61829);
        super.finish();
        if (!this.mIF) {
            this.mIF = true;
            k.c(this.query, false, this.mII.bAK(), -2);
        }
        AppMethodBeat.o(61829);
    }

    /* Access modifiers changed, original: protected|final */
    public final int bAt() {
        AppMethodBeat.i(139151);
        int bAK = this.mII.bAK();
        AppMethodBeat.o(139151);
        return bAK;
    }
}
