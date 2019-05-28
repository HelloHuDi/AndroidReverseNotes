package com.tencent.mm.plugin.profile.ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.o;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class a extends o implements l {
    ad ehM;
    ak handler = new ak(Looper.getMainLooper());
    private List<com.tencent.mm.plugin.fts.a.a.l> mFf;

    static class a implements Comparator<com.tencent.mm.plugin.fts.a.a.l> {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            com.tencent.mm.plugin.fts.a.a.l lVar = (com.tencent.mm.plugin.fts.a.a.l) obj;
            com.tencent.mm.plugin.fts.a.a.l lVar2 = (com.tencent.mm.plugin.fts.a.a.l) obj2;
            if (lVar2.timestamp > lVar.timestamp) {
                return 1;
            }
            if (lVar2.timestamp < lVar.timestamp) {
                return -1;
            }
            return 0;
        }
    }

    public a(com.tencent.mm.ui.contact.l lVar, int i, ad adVar) {
        super(lVar, new ArrayList(), true, false, i);
        AppMethodBeat.i(23330);
        this.ehM = adVar;
        AppMethodBeat.o(23330);
    }

    public final com.tencent.mm.ui.contact.a.a mP(int i) {
        AppMethodBeat.i(23331);
        d dVar = new d(i, this.ehM);
        aw.ZK();
        dVar.ehM = c.XM().aoO(((com.tencent.mm.plugin.fts.a.a.l) this.mFf.get(i)).mDx);
        AppMethodBeat.o(23331);
        return dVar;
    }

    public final int getCount() {
        AppMethodBeat.i(23332);
        if (this.mFf == null) {
            AppMethodBeat.o(23332);
            return 0;
        }
        int size = this.mFf.size();
        AppMethodBeat.o(23332);
        return size;
    }

    public final void b(j jVar) {
        AppMethodBeat.i(23333);
        if (jVar.bFZ == 0) {
            this.mFf = jVar.mEy;
        }
        notifyDataSetChanged();
        AppMethodBeat.o(23333);
    }
}
