package com.tencent.mm.plugin.account.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.jy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.account.a.a.b;
import com.tencent.mm.plugin.account.friend.a.al;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.appbrand.jsapi.g.e;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class a implements f {
    b fAY = new b() {
        public final void cN(boolean z) {
            AppMethodBeat.i(124656);
            ab.i("MicroMsg.ContactsAutoSyncLogic ", "performSync end, succ:%b", Boolean.valueOf(z));
            if (!z) {
                AppMethodBeat.o(124656);
            } else if (l.aqb().size() > 0) {
                ab.i("MicroMsg.ContactsAutoSyncLogic ", "start to upload mobile list");
                g.Rg().a((int) e.CTRL_INDEX, a.this);
                System.currentTimeMillis();
                l.apX();
                g.Rg().a(new al(l.aqb(), l.aqa()), 0);
                AppMethodBeat.o(124656);
            } else {
                ab.i("MicroMsg.ContactsAutoSyncLogic ", "update mobile friend list");
                String[] strArr = (String[]) a.this.gyz.toArray(new String[0]);
                a.this.gyz.clear();
                ArrayList arrayList = new ArrayList();
                for (String vT : strArr) {
                    com.tencent.mm.plugin.account.friend.a.a vT2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().vT(vT);
                    if (vT2 == null || bo.isNullOrNil(vT2.apG())) {
                        ab.i("MicroMsg.ContactsAutoSyncLogic ", "not find mobile username %s", vT);
                    } else {
                        arrayList.add(vT2.apG());
                        ab.i("MicroMsg.ContactsAutoSyncLogic ", "find mobile %s username %s", vT2.apG(), vT);
                    }
                }
                g.Rg().a(32, a.this);
                if (arrayList.size() == 0) {
                    ab.i("MicroMsg.ContactsAutoSyncLogic ", "sync mobile list is zero");
                    g.Rg().a(new com.tencent.mm.plugin.account.friend.a.ab(), 0);
                    AppMethodBeat.o(124656);
                    return;
                }
                ab.i("MicroMsg.ContactsAutoSyncLogic ", "sync mobile list is %d", Integer.valueOf(arrayList.size()));
                g.Rg().a(new com.tencent.mm.plugin.account.friend.a.ab(arrayList, null), 0);
                AppMethodBeat.o(124656);
            }
        }
    };
    boolean fPO = false;
    c gyA = new c<jy>() {
        {
            AppMethodBeat.i(124653);
            this.xxI = jy.class.getName().hashCode();
            AppMethodBeat.o(124653);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(124654);
            ab.i("MicroMsg.ContactsAutoSyncLogic ", "sync username=%s isUploading=%b", ((jy) bVar).cFk.username, Boolean.valueOf(a.this.fPO));
            a.this.gyz.add(r8.cFk.username);
            if (!a.this.fPO) {
                a.this.gyB.removeMessages(0);
                a.this.gyB.sendEmptyMessageDelayed(0, 10000);
            }
            AppMethodBeat.o(124654);
            return false;
        }
    };
    ak gyB = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(124655);
            switch (message.what) {
                case 0:
                    a.this.fPO = true;
                    if (!com.tencent.mm.platformtools.a.syncAddrBook(a.this.fAY)) {
                        a.this.fPO = false;
                    }
                    ab.i("MicroMsg.ContactsAutoSyncLogic ", "sync result %b", Boolean.valueOf(r0));
                    break;
            }
            AppMethodBeat.o(124655);
        }
    };
    Set<String> gyz = Collections.synchronizedSet(new HashSet());

    public a() {
        AppMethodBeat.i(124657);
        com.tencent.mm.sdk.b.a.xxA.c(this.gyA);
        AppMethodBeat.o(124657);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(124658);
        if (mVar.getType() == e.CTRL_INDEX) {
            g.Rg().b((int) e.CTRL_INDEX, (f) this);
            if (i == 0 && i2 == 0) {
                g.Rg().a(32, (f) this);
                al alVar = (al) mVar;
                g.Rg().a(new com.tencent.mm.plugin.account.friend.a.ab(alVar.gwp, alVar.gwq), 0);
            } else {
                ab.e("MicroMsg.ContactsAutoSyncLogic ", "MMFunc_UploadMContact onSceneEnd: errType = " + i + ", errCode = " + i2);
                this.fPO = false;
            }
        }
        if (mVar.getType() == 32) {
            this.fPO = false;
            g.Rg().b(32, (f) this);
            if (i == 0 && i2 == 0) {
                ab.i("MicroMsg.ContactsAutoSyncLogic ", "update All Contact");
                w.co(ah.getContext());
            } else {
                ab.e("MicroMsg.ContactsAutoSyncLogic ", "rtGETMFRIEND onSceneEnd: errType = " + i + ", errCode = " + i2);
                AppMethodBeat.o(124658);
                return;
            }
        }
        AppMethodBeat.o(124658);
    }
}
