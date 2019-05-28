package com.tencent.mm.plugin.report.b;

import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.c.a.a.f;
import com.tencent.c.a.a.i;
import com.tencent.c.a.a.n;
import com.tencent.c.a.a.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.bob;
import com.tencent.mm.protocal.protobuf.boc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;

public final class d {
    private static i pXn = i.aG(ah.getContext());
    private static int pXo = 2;

    static /* synthetic */ int Fd() {
        int i = pXo;
        pXo = i - 1;
        return i;
    }

    static {
        AppMethodBeat.i(123501);
        AppMethodBeat.o(123501);
    }

    public static String cgi() {
        AppMethodBeat.i(123498);
        String str;
        try {
            i.a(new f() {
                public final void cm(String str) {
                    AppMethodBeat.i(123497);
                    ab.i("MicroMsg.MidHelper", "QueryMid onDispatch2WXServer req:%s limit:%d", str, Integer.valueOf(d.pXo));
                    if (d.Fd() <= 0) {
                        ab.e("MicroMsg.MidHelper", "THE FUCKING querymid do too much! :%d", Integer.valueOf(d.pXo));
                        AppMethodBeat.o(123497);
                        return;
                    }
                    a aVar = new a();
                    aVar.fsJ = new bob();
                    aVar.fsK = new boc();
                    aVar.uri = "/cgi-bin/micromsg-bin/querymid";
                    aVar.fsI = 684;
                    b acD = aVar.acD();
                    ((bob) acD.fsG.fsP).lWq = str;
                    ((bob) acD.fsG.fsP).nbk = 1;
                    w.a(acD, new w.a() {
                        public final int a(int i, int i2, String str, b bVar, m mVar) {
                            AppMethodBeat.i(123496);
                            ab.i("MicroMsg.MidHelper", "onGYNetEnd errType:%d errCode:%d msg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                            AppMethodBeat.o(123496);
                            return 0;
                        }
                    }, true);
                    AppMethodBeat.o(123497);
                }
            });
            ab.i("MicroMsg.MidHelper", "QueryMid try Get Now getMid:%s getLocalMid:%s", pXn.zR(), pXn.zS());
            AppMethodBeat.o(123498);
            return str;
        } catch (Exception e) {
            ab.e("MicroMsg.MidHelper", "QueryMid Error e:%s", bo.l(e));
            str = "";
            AppMethodBeat.o(123498);
            return str;
        }
    }

    public static void VY(String str) {
        AppMethodBeat.i(123499);
        try {
            i iVar = pXn;
            if (i.mContext != null) {
                i.cbv = System.currentTimeMillis();
                n.cbG = -1;
                try {
                    Editor edit = PreferenceManager.getDefaultSharedPreferences(i.mContext).edit();
                    edit.putLong("__MID_LAST_CHECK_TIME__", i.cbv);
                    edit.commit();
                } catch (Exception e) {
                    s.zZ();
                }
                if (i.mHandler != null) {
                    i.mHandler.post(new com.tencent.c.a.a.i.AnonymousClass1(str));
                }
            }
            ab.i("MicroMsg.MidHelper", "QueryMid local:%s", pXn.zS());
            AppMethodBeat.o(123499);
        } catch (Exception e2) {
            ab.e("MicroMsg.MidHelper", "procReturnData Error e:%s", bo.l(e2));
            AppMethodBeat.o(123499);
        }
    }

    public static int u(int i, int i2, String str) {
        AppMethodBeat.i(123500);
        if (g.RK()) {
            long anT = bo.anT();
            if (i != 3 || bo.a((Long) g.RP().Ry().get(331778, null), 0) < anT) {
                int i3;
                if (at.is2G(ah.getContext())) {
                    i3 = 1;
                } else if (at.isWifi(ah.getContext())) {
                    i3 = 3;
                } else if (at.is3G(ah.getContext())) {
                    i3 = 2;
                } else {
                    i3 = 0;
                }
                String cgi = cgi();
                ab.i("MicroMsg.MidHelper", "querymid checkReportMid moment:%d mid[%s]", Integer.valueOf(i), cgi);
                e.pXa.e(11402, cgi, Integer.valueOf(i), Integer.valueOf(i3), q.LM(), Integer.valueOf(i2), str, at.getISPName(ah.getContext()), Integer.valueOf(0), q.getDeviceID(ah.getContext()));
                g.RP().Ry().set(331778, Long.valueOf(259200 + anT));
                AppMethodBeat.o(123500);
                return 0;
            }
            AppMethodBeat.o(123500);
            return 0;
        }
        ab.i("MicroMsg.MidHelper", "checkReportMid acc not ready");
        AppMethodBeat.o(123500);
        return -1;
    }
}
