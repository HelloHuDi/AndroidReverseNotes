package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.ui.a.m.b;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.u;

public final class d extends m {
    public u mIy;
    public CharSequence mKe;
    private a mKf = new a();

    public class a extends b {
        public a() {
            super();
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            AppMethodBeat.i(61975);
            d dVar = (d) aVar2;
            com.tencent.mm.plugin.fts.ui.a.m.a aVar3 = (com.tencent.mm.plugin.fts.ui.a.m.a) aVar;
            m.p(aVar3.contentView, d.this.mFk);
            if (bo.isNullOrNil(dVar.hpS.talker)) {
                com.tencent.mm.pluginsdk.ui.a.b.b(aVar3.ejo, dVar.hpS.mDx);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.b(aVar3.ejo, dVar.hpS.talker);
            }
            m.a(dVar.mKe, aVar3.ejp);
            m.a(dVar.gny, aVar3.ene);
            m.a(dVar.mKZ, aVar3.enf);
            AppMethodBeat.o(61975);
        }
    }

    public d(int i) {
        super(i);
        AppMethodBeat.i(61976);
        AppMethodBeat.o(61976);
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a.b Ps() {
        return this.mKf;
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, Object... objArr) {
        CharSequence LC;
        AppMethodBeat.i(61977);
        super.a(context, aVar, objArr);
        ad aoO = ((j) g.K(j.class)).XM().aoO(this.hpS.talker);
        if (aoO == null) {
            LC = com.tencent.mm.plugin.fts.a.d.LC(this.hpS.mDx);
        } else if (!bo.isNullOrNil(aoO.field_conRemark)) {
            LC = aoO.field_conRemark;
        } else if (this.mIy != null) {
            LC = this.mIy.mJ(this.hpS.talker);
            if (bo.isNullOrNil(LC)) {
                LC = aoO.field_nickname;
            }
        } else {
            LC = aoO.field_nickname;
        }
        if (!bo.isNullOrNil(LC)) {
            this.mKe = com.tencent.mm.pluginsdk.ui.e.j.d(context, LC, (float) c.mHy);
        }
        AppMethodBeat.o(61977);
    }
}
