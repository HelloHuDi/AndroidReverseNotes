package com.tencent.mm.plugin.profile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.m;
import java.util.List;

public final class b extends m {
    private ad ehM;
    private ak handler = new ak();
    private a mEx;
    private List<l> mFf;
    private com.tencent.mm.plugin.fts.a.l plf = new com.tencent.mm.plugin.fts.a.l() {
        public final void b(j jVar) {
            AppMethodBeat.i(23334);
            if (jVar.bFZ == 0) {
                b.this.mFf = jVar.mEy;
                if (b.this.zmU != null) {
                    b.this.zmU.w(jVar.mAJ.query, b.this.mFf.size(), true);
                }
            }
            b.this.clearCache();
            b.this.notifyDataSetChanged();
            AppMethodBeat.o(23334);
        }
    };
    private String query;

    public b(com.tencent.mm.ui.contact.l lVar, int i, ad adVar) {
        super(lVar, false, i);
        AppMethodBeat.i(23335);
        this.ehM = adVar;
        AppMethodBeat.o(23335);
    }

    public final com.tencent.mm.ui.contact.a.a mP(int i) {
        AppMethodBeat.i(23336);
        d dVar = new d(i, this.ehM);
        aw.ZK();
        dVar.ehM = c.XM().aoO(((l) this.mFf.get(i)).mDx);
        AppMethodBeat.o(23336);
        return dVar;
    }

    public final int getCount() {
        AppMethodBeat.i(23337);
        if (this.mFf == null) {
            AppMethodBeat.o(23337);
            return 0;
        }
        int size = this.mFf.size();
        AppMethodBeat.o(23337);
        return size;
    }

    public final void a(String str, int[] iArr, boolean z) {
        AppMethodBeat.i(23338);
        this.query = str;
        i iVar = new i();
        iVar.query = str;
        iVar.handler = this.handler;
        iVar.mEw = this.plf;
        iVar.mEp = this.ehM.field_username;
        iVar.hbo = 7;
        this.mEx = ((n) g.M(n.class)).search(2, iVar);
        AppMethodBeat.o(23338);
    }

    public final void clearData() {
        AppMethodBeat.i(23339);
        this.query = null;
        if (this.mEx != null) {
            ((n) g.M(n.class)).cancelSearchTask(this.mEx);
        }
        AppMethodBeat.o(23339);
    }
}
