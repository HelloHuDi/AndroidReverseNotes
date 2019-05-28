package com.tencent.mm.ui.transmit;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.m;
import java.util.ArrayList;

public final class b extends m {
    private ak handler = new ak(Looper.getMainLooper());
    j mEm;
    private a mEx;
    String query;
    private MMCreateChatroomUI zIJ;
    private l zIK = new l() {
        public final void b(j jVar) {
            AppMethodBeat.i(35034);
            if (jVar.bFZ == 0) {
                b.this.mEm = jVar;
            } else {
                b.this.mEm = null;
            }
            if (jVar.mEy.size() == 0) {
                com.tencent.mm.plugin.fts.a.a.l lVar = new com.tencent.mm.plugin.fts.a.a.l();
                lVar.mDx = "no_result​";
                jVar.mEy = new ArrayList();
                jVar.mEy.add(lVar);
            }
            b.this.clearCache();
            b.this.notifyDataSetChanged();
            b.this.zmU.w(jVar.mAJ.query, jVar.mEy.size(), true);
            AppMethodBeat.o(35034);
        }
    };

    public b(MMCreateChatroomUI mMCreateChatroomUI, int i) {
        super(mMCreateChatroomUI, false, i);
        AppMethodBeat.i(35035);
        this.zIJ = mMCreateChatroomUI;
        AppMethodBeat.o(35035);
    }

    public final void a(String str, int[] iArr, boolean z) {
        AppMethodBeat.i(35036);
        this.query = str;
        i iVar = new i();
        iVar.handler = this.handler;
        iVar.mEw = this.zIK;
        iVar.query = str;
        iVar.mEv = com.tencent.mm.plugin.fts.a.c.b.mEV;
        iVar.mEr = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
        iVar.mEu.add("filehelper");
        iVar.mEu.add(r.Yz());
        iVar.mEu.addAll(this.zIJ.zIN.dKe());
        this.mEx = ((n) g.M(n.class)).search(2, iVar);
        AppMethodBeat.o(35036);
    }

    public final void clearData() {
        AppMethodBeat.i(35037);
        if (this.mEx != null) {
            ((n) g.M(n.class)).cancelSearchTask(this.mEx);
        }
        this.query = null;
        AppMethodBeat.o(35037);
    }

    public final com.tencent.mm.ui.contact.a.a mP(int i) {
        com.tencent.mm.ui.contact.a.a iVar;
        AppMethodBeat.i(35038);
        com.tencent.mm.plugin.fts.a.a.l lVar = (com.tencent.mm.plugin.fts.a.a.l) this.mEm.mEy.get(i);
        if (lVar.mDx.equals("no_result​")) {
            iVar = new com.tencent.mm.ui.contact.a.i(i);
        } else {
            com.tencent.mm.ui.contact.a.a eVar = new e(i);
            eVar.hpS = lVar;
            eVar.mDz = this.mEm.mDz;
            eVar.zmW = clI();
            eVar.eDk = true;
            eVar.mFm = i + 1;
            eVar.ej(eVar.hpS.type, eVar.hpS.mDw);
            iVar = eVar;
        }
        iVar.query = this.query;
        iVar.scene = this.scene;
        iVar.zmW = false;
        AppMethodBeat.o(35038);
        return iVar;
    }

    public final int getCount() {
        AppMethodBeat.i(35039);
        if (this.mEm == null || this.mEm.mEy == null) {
            AppMethodBeat.o(35039);
            return 0;
        }
        int size = this.mEm.mEy.size();
        AppMethodBeat.o(35039);
        return size;
    }
}
