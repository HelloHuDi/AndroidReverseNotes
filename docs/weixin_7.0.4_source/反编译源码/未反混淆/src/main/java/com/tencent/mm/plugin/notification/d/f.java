package com.tencent.mm.plugin.notification.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.g.a.ck;
import com.tencent.mm.g.a.gd;
import com.tencent.mm.g.a.lh;
import com.tencent.mm.g.a.li;
import com.tencent.mm.g.a.ot;
import com.tencent.mm.g.a.ou;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.notification.a.a;
import com.tencent.mm.plugin.notification.c.c;
import com.tencent.mm.plugin.notification.ui.FailSendMsgNotification;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class f implements at {
    private static f oWl = null;
    c oWm = null;
    c oWn = null;
    private a oWo = null;
    private boolean oWp = false;
    private com.tencent.mm.sdk.b.c oWq = new com.tencent.mm.sdk.b.c<ot>() {
        {
            AppMethodBeat.i(23173);
            this.xxI = ot.class.getName().hashCode();
            AppMethodBeat.o(23173);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(23174);
            f.this.oWm.bWu();
            AppMethodBeat.o(23174);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c oWr = new com.tencent.mm.sdk.b.c<ou>() {
        {
            AppMethodBeat.i(23175);
            this.xxI = ou.class.getName().hashCode();
            AppMethodBeat.o(23175);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(23176);
            f.this.oWn.bWu();
            AppMethodBeat.o(23176);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c oWs = new com.tencent.mm.sdk.b.c<lh>() {
        {
            AppMethodBeat.i(23177);
            this.xxI = lh.class.getName().hashCode();
            AppMethodBeat.o(23177);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(23178);
            f.this.oWm.bWz();
            AppMethodBeat.o(23178);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c oWt = new com.tencent.mm.sdk.b.c<li>() {
        {
            AppMethodBeat.i(23179);
            this.xxI = li.class.getName().hashCode();
            AppMethodBeat.o(23179);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(23180);
            f.this.oWn.bWz();
            AppMethodBeat.o(23180);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c oWu = new com.tencent.mm.sdk.b.c<ck>() {
        {
            AppMethodBeat.i(23181);
            this.xxI = ck.class.getName().hashCode();
            AppMethodBeat.o(23181);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(23182);
            f.this.oWm.bWB().dismiss();
            f.this.oWn.bWB().dismiss();
            ab.i("MicroMsg.SubCoreNotification", "dismiss all fail msg notification");
            AppMethodBeat.o(23182);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c oWv = new com.tencent.mm.sdk.b.c<gd>() {
        {
            AppMethodBeat.i(23183);
            this.xxI = gd.class.getName().hashCode();
            AppMethodBeat.o(23183);
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(23184);
            f.this.oWp = ((gd) bVar).cAs.csi;
            AppMethodBeat.o(23184);
            return false;
        }
    };

    private f() {
        AppMethodBeat.i(23185);
        b.init();
        if (this.oWn == null) {
            this.oWn = new e();
        }
        if (this.oWm == null) {
            this.oWm = new d();
        }
        AppMethodBeat.o(23185);
    }

    public static FailSendMsgNotification At(int i) {
        AppMethodBeat.i(23186);
        FailSendMsgNotification bWB;
        if (i == 2 && bWP().oWn != null) {
            ab.d("MicroMsg.SubCoreNotification", "get sns notificaiton");
            bWB = bWP().oWn.bWB();
            AppMethodBeat.o(23186);
            return bWB;
        } else if (i != 1 || bWP().oWm == null) {
            AppMethodBeat.o(23186);
            return null;
        } else {
            ab.d("MicroMsg.SubCoreNotification", "get msg notificaiton");
            bWB = bWP().oWm.bWB();
            AppMethodBeat.o(23186);
            return bWB;
        }
    }

    public static f bWP() {
        AppMethodBeat.i(23187);
        if (oWl == null) {
            oWl = new f();
            aw.ZE().a("plugin.notification", oWl);
        }
        f fVar = oWl;
        AppMethodBeat.o(23187);
        return fVar;
    }

    public final HashMap<Integer, d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(23188);
        this.oWm.bWK();
        this.oWm.bWL();
        this.oWn.bWK();
        this.oWn.bWL();
        if (this.oWo == null) {
            this.oWo = new a();
        }
        a aVar = this.oWo;
        if (aw.RK()) {
            ab.d("MicroMsg.NotificationObserver", "added");
            try {
                aw.ZK();
                com.tencent.mm.model.c.XR().b(aVar);
                aw.ZK();
                com.tencent.mm.model.c.XR().a(aVar);
                aVar.oVn = true;
            } catch (Exception e) {
                ab.e("MicroMsg.NotificationObserver", "exception:%s", bo.l(e));
            }
        } else {
            ab.e("MicroMsg.NotificationObserver", "account not ready!");
        }
        com.tencent.mm.sdk.b.a.xxA.c(this.oWq);
        com.tencent.mm.sdk.b.a.xxA.c(this.oWr);
        com.tencent.mm.sdk.b.a.xxA.c(this.oWs);
        com.tencent.mm.sdk.b.a.xxA.c(this.oWt);
        com.tencent.mm.sdk.b.a.xxA.c(this.oWu);
        com.tencent.mm.sdk.b.a.xxA.c(this.oWv);
        aw.getNotification().ik(com.tencent.mm.m.f.Nr());
        aw.getNotification().bw(false);
        ab.d("MicroMsg.SubCoreNotification", "onAccountPostReset");
        AppMethodBeat.o(23188);
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(23189);
        this.oWm.bWM();
        this.oWm.bWN();
        this.oWn.bWM();
        this.oWn.bWN();
        if (this.oWo != null) {
            a aVar = this.oWo;
            if (aw.RK()) {
                try {
                    aw.ZK();
                    com.tencent.mm.model.c.XR().b(aVar);
                } catch (Exception e) {
                    ab.e("MicroMsg.NotificationObserver", "exception:%s", bo.l(e));
                }
            }
        }
        com.tencent.mm.sdk.b.a.xxA.d(this.oWq);
        com.tencent.mm.sdk.b.a.xxA.d(this.oWr);
        com.tencent.mm.sdk.b.a.xxA.d(this.oWs);
        com.tencent.mm.sdk.b.a.xxA.d(this.oWt);
        com.tencent.mm.sdk.b.a.xxA.d(this.oWu);
        com.tencent.mm.sdk.b.a.xxA.d(this.oWv);
        aw.getNotification().ik(0);
        aw.getNotification().bw(true);
        ab.d("MicroMsg.SubCoreNotification", "onAccountRelease");
        AppMethodBeat.o(23189);
    }

    public static boolean aJt() {
        AppMethodBeat.i(23190);
        boolean z = bWP().oWp;
        AppMethodBeat.o(23190);
        return z;
    }

    public static ArrayList<Long> ae(bi biVar) {
        AppMethodBeat.i(23191);
        if (biVar == null) {
            AppMethodBeat.o(23191);
            return null;
        }
        aw.ZK();
        com.tencent.mm.model.c.XO().a(biVar.field_msgId, biVar);
        ArrayList bOC = ((j) g.K(j.class)).bOr().bOC();
        ArrayList<Long> arrayList = new ArrayList();
        Iterator it = bOC.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((bi) it.next()).field_msgId));
        }
        AppMethodBeat.o(23191);
        return arrayList;
    }
}
