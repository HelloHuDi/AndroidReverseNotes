package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.c.e;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.u;

public final class f extends d implements l {
    private ak ilv = new ak();
    private j mEm;
    private String mEp;
    private a mEx;
    private u mIy;

    public f(e eVar, String str) {
        super(eVar);
        AppMethodBeat.i(61785);
        this.mEp = str;
        if (t.mN(str)) {
            this.mIy = ((c) g.K(c.class)).XV().oa(str);
        }
        AppMethodBeat.o(61785);
    }

    /* Access modifiers changed, original: protected|final */
    public final com.tencent.mm.plugin.fts.a.d.a.a vZ(int i) {
        AppMethodBeat.i(61786);
        d dVar = new d(i);
        dVar.hpS = (com.tencent.mm.plugin.fts.a.a.l) this.mEm.mEy.get(i);
        dVar.mDz = this.mEm.mDz;
        dVar.mFl = -14;
        dVar.mIy = this.mIy;
        dVar.mFm = i;
        dVar.pageType = 6;
        if (dVar.position == getCount() - 1) {
            dVar.mFk = true;
        }
        AppMethodBeat.o(61786);
        return dVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAL() {
        AppMethodBeat.i(61787);
        clearCache();
        if (this.mEx != null) {
            ((n) g.M(n.class)).cancelSearchTask(this.mEx);
        }
        i iVar = new i();
        iVar.query = this.query;
        iVar.mEp = this.mEp;
        iVar.mEv = e.mEY;
        iVar.mEu.add("create_talker_message​");
        iVar.mEw = this;
        iVar.handler = this.ilv;
        iVar.hbo = 3;
        this.mEx = ((n) g.M(n.class)).search(3, iVar);
        ab.i("MicroMSsg.FTS.FTSChattingConvAdapter", "do search %s", this.query);
        AppMethodBeat.o(61787);
    }

    public final void b(j jVar) {
        AppMethodBeat.i(61788);
        switch (jVar.bFZ) {
            case -3:
            case -2:
            case -1:
                setCount(0);
                notifyDataSetChanged();
                T(getCount(), true);
                break;
            case 0:
                this.mEm = jVar;
                setCount(jVar.mEy.size());
                notifyDataSetChanged();
                T(getCount(), true);
                AppMethodBeat.o(61788);
                return;
        }
        AppMethodBeat.o(61788);
    }

    public final void finish() {
        AppMethodBeat.i(61789);
        super.finish();
        if (this.mEx != null) {
            ((n) g.M(n.class)).cancelSearchTask(this.mEx);
        }
        AppMethodBeat.o(61789);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean a(View view, com.tencent.mm.plugin.fts.a.d.a.a aVar, boolean z) {
        return false;
    }
}
