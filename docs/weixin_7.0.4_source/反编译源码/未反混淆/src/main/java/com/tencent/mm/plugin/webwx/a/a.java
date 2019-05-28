package com.tencent.mm.plugin.webwx.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bl;
import java.io.IOException;
import java.util.HashMap;

public final class a implements f, com.tencent.mm.modelvideo.t.a {
    private static int uKZ = 1048576;
    private static int uLa = 26214400;
    private bk uLb = new bk();
    private HashMap<String, bi> uLc = new HashMap();

    public a() {
        AppMethodBeat.i(26484);
        StringBuilder stringBuilder = new StringBuilder();
        g.RQ();
        byte[] f = e.f(stringBuilder.append(g.RP().cachePath).append("syncmsgid.ini").toString(), 0, -1);
        if (!bo.cb(f)) {
            try {
                this.uLb.parseFrom(f);
            } catch (Exception e) {
                ab.w("MicroMsg.MultiTerminalSyncMgr", "task parse Error");
            }
        }
        o.all().a(this, Looper.getMainLooper());
        g.Rg().a(221, (f) this);
        AppMethodBeat.o(26484);
    }

    public final void lU(final long j) {
        AppMethodBeat.i(26485);
        aw.ZK();
        if (((Boolean) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WEIXIN_MUL_TERMINAL_AUTOSYNC_BOOLEAN, Boolean.TRUE)).booleanValue()) {
            new ak(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(26480);
                    a.a(a.this, j);
                    AppMethodBeat.o(26480);
                }
            });
            AppMethodBeat.o(26485);
            return;
        }
        ab.i("MicroMsg.MultiTerminalSyncMgr", "autoSyncState close");
        AppMethodBeat.o(26485);
    }

    public final void lV(final long j) {
        AppMethodBeat.i(26486);
        new ak(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(26481);
                a.b(a.this, j);
                AppMethodBeat.o(26481);
            }
        });
        AppMethodBeat.o(26486);
    }

    public final void ddd() {
        AppMethodBeat.i(26487);
        new ak(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(26482);
                a.a(a.this);
                AppMethodBeat.o(26482);
            }
        });
        AppMethodBeat.o(26487);
    }

    private void dde() {
        AppMethodBeat.i(26488);
        try {
            byte[] toByteArray = this.uLb.toByteArray();
            StringBuilder stringBuilder = new StringBuilder();
            g.RQ();
            e.b(stringBuilder.append(g.RP().cachePath).append("syncmsgid.ini").toString(), toByteArray, toByteArray.length);
            AppMethodBeat.o(26488);
        } catch (IOException e) {
            ab.w("MicroMsg.MultiTerminalSyncMgr", "task to file Error");
            AppMethodBeat.o(26488);
        }
    }

    public final void a(com.tencent.mm.modelvideo.t.a.a aVar) {
        AppMethodBeat.i(26489);
        bi biVar = (bi) this.uLc.get(aVar.fileName);
        if (biVar == null) {
            AppMethodBeat.o(26489);
            return;
        }
        s ut = u.ut(biVar.field_imgPath);
        if (ut == null) {
            AppMethodBeat.o(26489);
        } else if (biVar.dtH() || ut.status == 199) {
            ab.i("MicroMsg.MultiTerminalSyncMgr", "download video end: %d, status:%d", Long.valueOf(biVar.field_msgId), Integer.valueOf(ut.status));
            lV(biVar.field_msgId);
            this.uLc.remove(biVar.field_imgPath);
            AppMethodBeat.o(26489);
        } else {
            if (biVar.field_status == com.tencent.mm.plugin.appbrand.jsapi.k.o.CTRL_INDEX) {
                this.uLc.remove(biVar.field_imgPath);
            }
            AppMethodBeat.o(26489);
        }
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(26490);
        if (i == 0 && i2 == 0 && (mVar instanceof com.tencent.mm.plugin.record.b.e)) {
            lV(((com.tencent.mm.plugin.record.b.e) mVar).cvx);
            ab.i("MicroMsg.MultiTerminalSyncMgr", "download attach end: %d", Long.valueOf(r0));
        }
        AppMethodBeat.o(26490);
    }

    static /* synthetic */ void a(a aVar, long j) {
        AppMethodBeat.i(26491);
        bl blVar = new bl();
        blVar.cvx = j;
        blVar.cmn = bo.anT();
        aVar.uLb.xZQ.add(blVar);
        aVar.dde();
        aVar.ddd();
        AppMethodBeat.o(26491);
    }

    static /* synthetic */ void b(a aVar, long j) {
        AppMethodBeat.i(26492);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < aVar.uLb.xZQ.size()) {
                bl blVar = (bl) aVar.uLb.xZQ.get(i2);
                if (blVar.cvx == j) {
                    aVar.uLb.xZQ.remove(blVar);
                    aVar.dde();
                    AppMethodBeat.o(26492);
                    return;
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(26492);
                return;
            }
        }
    }
}
