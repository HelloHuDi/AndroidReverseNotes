package com.tencent.p177mm.plugin.p1014q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5141c;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.q.b */
public final class C28723b {
    public static String oFb = "afterLogin";
    public static String oFc = "afterSleep";
    public static String oFd = "getMore";
    public static int oFe = 0;
    public static int oFf = 1644429312;
    public static int oFg = 302122240;
    public static int oFh = 50;
    public static int oFi = 20;
    public static int oFj = 100;
    public static int oFk = 3;
    public static int oFl = 1;
    public static int oFm = 1;
    public static int oFn = 1000;

    public static void bQV() {
        AppMethodBeat.m2504i(22890);
        C5141c ll = C18624c.abi().mo17131ll("100224");
        if (ll.isValid()) {
            Map dru = ll.dru();
            oFe = C5046bo.getInt((String) dru.get("SyncOpen"), 0);
            oFf = C5046bo.getInt((String) dru.get("WindowsVersion"), 1644429312);
            oFg = C5046bo.getInt((String) dru.get("MacVersion"), 302122240);
            oFh = C5046bo.getInt((String) dru.get("MsgSyncSessionCount"), 50);
            oFi = C5046bo.getInt((String) dru.get("MsgSyncMsgCount"), 20);
            oFj = C5046bo.getInt((String) dru.get("MsgSyncSessionListCount"), 100);
            oFk = C5046bo.getInt((String) dru.get("MsgSyncTimeLimit"), 3);
            oFl = C5046bo.getInt((String) dru.get("MsgSyncAfterSleepSwitch"), 1);
            oFm = C5046bo.getInt((String) dru.get("MsgSyncGetMoreSwitch"), 1);
            oFn = C5046bo.getInt((String) dru.get("MsgSyncGetMoreMaxMsgCount"), 1000);
        }
        C4990ab.m7417i("MicroMsg.MsgSynchronizeConstants", "initMsgSynchronizeAbtest, SYNC_CLOSE:%d, WINDOWS_VERSION:%d, MAC_VERSION:%d, SESSION_COUNT:%d, MSG_COUNT%d, MSG_LIST_COUNT:%d, TIME_LIMIT:%d, AFTER_SLEEP_SWITCH:%d, GET_MORE_SWITCH:%d, GET_MORE_MAX_MSG_COUNT:%d", Integer.valueOf(oFe), Integer.valueOf(oFf), Integer.valueOf(oFg), Integer.valueOf(oFh), Integer.valueOf(oFi), Integer.valueOf(oFj), Integer.valueOf(oFk), Integer.valueOf(oFl), Integer.valueOf(oFm), Integer.valueOf(oFn));
        AppMethodBeat.m2505o(22890);
    }

    /* renamed from: a */
    public static void m45646a(long j, long j2, long j3, long j4, int i, int i2, String str) {
        AppMethodBeat.m2504i(22891);
        int i3 = 0;
        if (str.equals(oFb)) {
            i3 = 1;
        } else {
            if (str.equals(oFc)) {
                i3 = 2;
            } else {
                if (str.equals(oFd)) {
                    i3 = 3;
                }
            }
        }
        C7060h.pYm.mo8381e(14108, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.m2505o(22891);
    }

    /* renamed from: l */
    public static void m45647l(long j, int i, int i2) {
        AppMethodBeat.m2504i(22892);
        C7060h.pYm.mo8381e(14108, Long.valueOf(0), Long.valueOf(j), Long.valueOf(0), Long.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(22892);
    }
}
