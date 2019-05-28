package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.d.f;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashSet;

public final class g extends d implements b {
    private ak mHE = new ak(Looper.getMainLooper());
    private f mIE;
    private boolean mIF;

    public g(e eVar, String str, int i) {
        super(eVar);
        AppMethodBeat.i(61811);
        Context context = eVar.getContext();
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(160));
        f fVar = (f) ((n) com.tencent.mm.kernel.g.M(n.class)).createFTSUIUnitList(hashSet, context, this, i).get(0);
        fVar.mEp = str;
        if (t.kH(str)) {
            fVar.mIy = ((c) com.tencent.mm.kernel.g.K(c.class)).XV().oa(str);
        }
        this.mIE = fVar;
        AppMethodBeat.o(61811);
    }

    public final void a(e eVar, String str) {
        AppMethodBeat.i(61812);
        setCount(eVar.vY(0));
        notifyDataSetChanged();
        T(getCount(), true);
        AppMethodBeat.o(61812);
    }

    /* Access modifiers changed, original: protected|final */
    public final a vZ(int i) {
        AppMethodBeat.i(61813);
        a vZ = this.mIE.vZ(i);
        if (vZ != null) {
            vZ.mFm = i;
            vZ.pageType = 4;
        }
        AppMethodBeat.o(61813);
        return vZ;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAL() {
        AppMethodBeat.i(61814);
        this.mIF = false;
        this.mIE.a(this.query, this.mHE, new HashSet());
        AppMethodBeat.o(61814);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean a(View view, a aVar, boolean z) {
        AppMethodBeat.i(61815);
        this.mIE.a(view, aVar, z);
        if (aVar.mFt && !this.mIF) {
            this.mIF = true;
            k.c(this.query, true, this.mIE.bAK(), -2);
        }
        AppMethodBeat.o(61815);
        return false;
    }

    public final void finish() {
        AppMethodBeat.i(61816);
        super.finish();
        if (!this.mIF) {
            this.mIF = true;
            k.c(this.query, false, this.mIE.bAK(), -2);
        }
        AppMethodBeat.o(61816);
    }

    /* Access modifiers changed, original: protected|final */
    public final int bAt() {
        AppMethodBeat.i(139150);
        int bAK = this.mIE.bAK();
        AppMethodBeat.o(139150);
        return bAK;
    }
}
