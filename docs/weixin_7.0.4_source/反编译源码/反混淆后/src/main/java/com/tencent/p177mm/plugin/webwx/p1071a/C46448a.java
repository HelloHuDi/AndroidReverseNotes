package com.tencent.p177mm.plugin.webwx.p1071a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t.C9721a;
import com.tencent.p177mm.modelvideo.C9720t.C9721a.C9718a;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C17940d.C9017a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C27011o;
import com.tencent.p177mm.plugin.record.p492b.C43432e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C35999bk;
import com.tencent.p177mm.storage.C36000bl;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7620bi;
import java.io.IOException;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.webwx.a.a */
public final class C46448a implements C1202f, C9721a {
    private static int uKZ = 1048576;
    private static int uLa = 26214400;
    private C35999bk uLb = new C35999bk();
    private HashMap<String, C7620bi> uLc = new HashMap();

    /* renamed from: com.tencent.mm.plugin.webwx.a.a$4 */
    class C170004 implements C9017a {
        C170004() {
        }

        /* renamed from: a */
        public final void mo20450a(long j, long j2, int i, int i2, Object obj, int i3, int i4, C1207m c1207m) {
        }

        /* renamed from: a */
        public final void mo20451a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(26483);
            C4990ab.m7417i("MicroMsg.MultiTerminalSyncMgr", "download image msgid:%d, [%d,%d]", Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i4));
            if (i3 == 0 && i4 == 0) {
                C46448a.this.mo74668lV(j2);
            }
            AppMethodBeat.m2505o(26483);
        }

        /* renamed from: a */
        public final void mo20449a(long j, long j2, int i, int i2, Object obj) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.webwx.a.a$3 */
    class C299723 implements Runnable {
        C299723() {
        }

        public final void run() {
            AppMethodBeat.m2504i(26482);
            C46448a.m87604a(C46448a.this);
            AppMethodBeat.m2505o(26482);
        }
    }

    public C46448a() {
        AppMethodBeat.m2504i(26484);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3537RQ();
        byte[] f = C1173e.m2571f(stringBuilder.append(C1720g.m3536RP().cachePath).append("syncmsgid.ini").toString(), 0, -1);
        if (!C5046bo.m7540cb(f)) {
            try {
                this.uLb.parseFrom(f);
            } catch (Exception e) {
                C4990ab.m7420w("MicroMsg.MultiTerminalSyncMgr", "task parse Error");
            }
        }
        C37961o.all().mo21053a(this, Looper.getMainLooper());
        C1720g.m3540Rg().mo14539a(221, (C1202f) this);
        AppMethodBeat.m2505o(26484);
    }

    /* renamed from: lU */
    public final void mo74667lU(final long j) {
        AppMethodBeat.m2504i(26485);
        C9638aw.m17190ZK();
        if (((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_WEIXIN_MUL_TERMINAL_AUTOSYNC_BOOLEAN, Boolean.TRUE)).booleanValue()) {
            new C7306ak(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(26480);
                    C46448a.m87605a(C46448a.this, j);
                    AppMethodBeat.m2505o(26480);
                }
            });
            AppMethodBeat.m2505o(26485);
            return;
        }
        C4990ab.m7416i("MicroMsg.MultiTerminalSyncMgr", "autoSyncState close");
        AppMethodBeat.m2505o(26485);
    }

    /* renamed from: lV */
    public final void mo74668lV(final long j) {
        AppMethodBeat.m2504i(26486);
        new C7306ak(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(26481);
                C46448a.m87606b(C46448a.this, j);
                AppMethodBeat.m2505o(26481);
            }
        });
        AppMethodBeat.m2505o(26486);
    }

    public final void ddd() {
        AppMethodBeat.m2504i(26487);
        new C7306ak(Looper.getMainLooper()).post(new C299723());
        AppMethodBeat.m2505o(26487);
    }

    private void dde() {
        AppMethodBeat.m2504i(26488);
        try {
            byte[] toByteArray = this.uLb.toByteArray();
            StringBuilder stringBuilder = new StringBuilder();
            C1720g.m3537RQ();
            C1173e.m2559b(stringBuilder.append(C1720g.m3536RP().cachePath).append("syncmsgid.ini").toString(), toByteArray, toByteArray.length);
            AppMethodBeat.m2505o(26488);
        } catch (IOException e) {
            C4990ab.m7420w("MicroMsg.MultiTerminalSyncMgr", "task to file Error");
            AppMethodBeat.m2505o(26488);
        }
    }

    /* renamed from: a */
    public final void mo11381a(C9718a c9718a) {
        AppMethodBeat.m2504i(26489);
        C7620bi c7620bi = (C7620bi) this.uLc.get(c9718a.fileName);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(26489);
            return;
        }
        C26493s ut = C26494u.m42268ut(c7620bi.field_imgPath);
        if (ut == null) {
            AppMethodBeat.m2505o(26489);
        } else if (c7620bi.dtH() || ut.status == 199) {
            C4990ab.m7417i("MicroMsg.MultiTerminalSyncMgr", "download video end: %d, status:%d", Long.valueOf(c7620bi.field_msgId), Integer.valueOf(ut.status));
            mo74668lV(c7620bi.field_msgId);
            this.uLc.remove(c7620bi.field_imgPath);
            AppMethodBeat.m2505o(26489);
        } else {
            if (c7620bi.field_status == C27011o.CTRL_INDEX) {
                this.uLc.remove(c7620bi.field_imgPath);
            }
            AppMethodBeat.m2505o(26489);
        }
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(26490);
        if (i == 0 && i2 == 0 && (c1207m instanceof C43432e)) {
            mo74668lV(((C43432e) c1207m).cvx);
            C4990ab.m7417i("MicroMsg.MultiTerminalSyncMgr", "download attach end: %d", Long.valueOf(r0));
        }
        AppMethodBeat.m2505o(26490);
    }

    /* renamed from: a */
    static /* synthetic */ void m87605a(C46448a c46448a, long j) {
        AppMethodBeat.m2504i(26491);
        C36000bl c36000bl = new C36000bl();
        c36000bl.cvx = j;
        c36000bl.cmn = C5046bo.anT();
        c46448a.uLb.xZQ.add(c36000bl);
        c46448a.dde();
        c46448a.ddd();
        AppMethodBeat.m2505o(26491);
    }

    /* renamed from: b */
    static /* synthetic */ void m87606b(C46448a c46448a, long j) {
        AppMethodBeat.m2504i(26492);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < c46448a.uLb.xZQ.size()) {
                C36000bl c36000bl = (C36000bl) c46448a.uLb.xZQ.get(i2);
                if (c36000bl.cvx == j) {
                    c46448a.uLb.xZQ.remove(c36000bl);
                    c46448a.dde();
                    AppMethodBeat.m2505o(26492);
                    return;
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(26492);
                return;
            }
        }
    }
}
