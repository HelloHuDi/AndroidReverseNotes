package com.tencent.mm.plugin.fts.ui;

import android.os.Looper;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.ui.d.a;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashSet;

public final class c extends d implements b {
    private a mHC;
    protected boolean mHD;
    private ak mHE = new ak(Looper.getMainLooper());

    public c(e eVar) {
        super(eVar);
        AppMethodBeat.i(61720);
        this.mHC = new a(eVar.getContext(), this, 0);
        AppMethodBeat.o(61720);
    }

    /* Access modifiers changed, original: protected|final */
    public final com.tencent.mm.plugin.fts.a.d.a.a vZ(int i) {
        AppMethodBeat.i(61721);
        com.tencent.mm.plugin.fts.a.d.a.a vZ = this.mHC.vZ(i);
        AppMethodBeat.o(61721);
        return vZ;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAL() {
        AppMethodBeat.i(61722);
        this.mHD = false;
        this.mHC.a(this.query, this.mHE, new HashSet());
        AppMethodBeat.o(61722);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean a(View view, com.tencent.mm.plugin.fts.a.d.a.a aVar, boolean z) {
        return false;
    }

    public final void a(e eVar, String str) {
        AppMethodBeat.i(61723);
        int vY = this.mHC.vY(0);
        setCount(vY);
        notifyDataSetChanged();
        T(vY, true);
        AppMethodBeat.o(61723);
    }

    /* Access modifiers changed, original: protected|final */
    public final int bAt() {
        AppMethodBeat.i(61724);
        int bAK = this.mHC.bAK();
        AppMethodBeat.o(61724);
        return bAK;
    }
}
