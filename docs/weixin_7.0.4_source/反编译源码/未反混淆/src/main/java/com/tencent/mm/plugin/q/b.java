package com.tencent.mm.plugin.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class b {
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
        AppMethodBeat.i(22890);
        c ll = com.tencent.mm.model.c.c.abi().ll("100224");
        if (ll.isValid()) {
            Map dru = ll.dru();
            oFe = bo.getInt((String) dru.get("SyncOpen"), 0);
            oFf = bo.getInt((String) dru.get("WindowsVersion"), 1644429312);
            oFg = bo.getInt((String) dru.get("MacVersion"), 302122240);
            oFh = bo.getInt((String) dru.get("MsgSyncSessionCount"), 50);
            oFi = bo.getInt((String) dru.get("MsgSyncMsgCount"), 20);
            oFj = bo.getInt((String) dru.get("MsgSyncSessionListCount"), 100);
            oFk = bo.getInt((String) dru.get("MsgSyncTimeLimit"), 3);
            oFl = bo.getInt((String) dru.get("MsgSyncAfterSleepSwitch"), 1);
            oFm = bo.getInt((String) dru.get("MsgSyncGetMoreSwitch"), 1);
            oFn = bo.getInt((String) dru.get("MsgSyncGetMoreMaxMsgCount"), 1000);
        }
        ab.i("MicroMsg.MsgSynchronizeConstants", "initMsgSynchronizeAbtest, SYNC_CLOSE:%d, WINDOWS_VERSION:%d, MAC_VERSION:%d, SESSION_COUNT:%d, MSG_COUNT%d, MSG_LIST_COUNT:%d, TIME_LIMIT:%d, AFTER_SLEEP_SWITCH:%d, GET_MORE_SWITCH:%d, GET_MORE_MAX_MSG_COUNT:%d", Integer.valueOf(oFe), Integer.valueOf(oFf), Integer.valueOf(oFg), Integer.valueOf(oFh), Integer.valueOf(oFi), Integer.valueOf(oFj), Integer.valueOf(oFk), Integer.valueOf(oFl), Integer.valueOf(oFm), Integer.valueOf(oFn));
        AppMethodBeat.o(22890);
    }

    public static void a(long j, long j2, long j3, long j4, int i, int i2, String str) {
        AppMethodBeat.i(22891);
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
        h.pYm.e(14108, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(22891);
    }

    public static void l(long j, int i, int i2) {
        AppMethodBeat.i(22892);
        h.pYm.e(14108, Long.valueOf(0), Long.valueOf(j), Long.valueOf(0), Long.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(22892);
    }
}
