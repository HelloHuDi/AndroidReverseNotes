package com.tencent.mm.model.b;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class b {
    private boolean fog = false;
    public ArrayList<a> mListeners = new ArrayList();

    public interface a {
        void aaW();
    }

    public enum b {
        Main,
        Chatting;

        static {
            AppMethodBeat.o(16354);
        }
    }

    public b() {
        AppMethodBeat.i(16355);
        AppMethodBeat.o(16355);
    }

    public static String aaN() {
        AppMethodBeat.i(16356);
        aw.ZK();
        String str = (String) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_MAIN_MONITOR_MAIN_WORDING_STRING_SYNC, (Object) "");
        AppMethodBeat.o(16356);
        return str;
    }

    public static String aaO() {
        AppMethodBeat.i(16357);
        aw.ZK();
        String str = (String) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_MAIN_MONITOR_MAIN_URL_STRING_SYNC, (Object) "");
        AppMethodBeat.o(16357);
        return str;
    }

    public static boolean aaP() {
        AppMethodBeat.i(16358);
        aw.ZK();
        boolean booleanValue = ((Boolean) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_MAIN_MONITOR_MAIN_CLOSABLE_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
        AppMethodBeat.o(16358);
        return booleanValue;
    }

    public static String aaQ() {
        AppMethodBeat.i(16359);
        aw.ZK();
        String str = (String) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_CHATTING_MONITOR_MAIN_WORDING_STRING_SYNC, (Object) "");
        AppMethodBeat.o(16359);
        return str;
    }

    public static String aaR() {
        AppMethodBeat.i(16360);
        aw.ZK();
        String str = (String) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_CHATTING_MONITOR_MAIN_URL_STRING_SYNC, (Object) "");
        AppMethodBeat.o(16360);
        return str;
    }

    public static boolean aaS() {
        AppMethodBeat.i(16361);
        aw.ZK();
        boolean booleanValue = ((Boolean) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_CHATTING_MONITOR_MAIN_CLOSABLE_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
        AppMethodBeat.o(16361);
        return booleanValue;
    }

    private static boolean aaT() {
        AppMethodBeat.i(16362);
        aw.ZK();
        boolean booleanValue = ((Boolean) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_CHATTING_MONITOR_MAIN_AUTOTRIGGER_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
        AppMethodBeat.o(16362);
        return booleanValue;
    }

    private static boolean isTriggered() {
        AppMethodBeat.i(16363);
        aw.ZK();
        boolean booleanValue = ((Boolean) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_MONITOR_IS_TRIGGERED_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
        AppMethodBeat.o(16363);
        return booleanValue;
    }

    private void a(String str, String str2, long j, boolean z, boolean z2, String str3, String str4, long j2, boolean z3, boolean z4, String str5) {
        AppMethodBeat.i(16364);
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_CHATTING_MONITOR_MAIN_WORDING_STRING_SYNC, (Object) str3);
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_CHATTING_MONITOR_MAIN_URL_STRING_SYNC, (Object) str4);
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_CHATTING_MONITOR_MAIN_INTERVAL_LONG_SYNC, Long.valueOf(j2));
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_CHATTING_MONITOR_MAIN_CLOSABLE_BOOLEAN_SYNC, Boolean.valueOf(z3));
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_CHATTING_MONITOR_MAIN_AUTOTRIGGER_BOOLEAN_SYNC, Boolean.valueOf(z4));
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_CHATTING_MONITOR_FINGER_PRINT_STRING_SYNC, (Object) str5);
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_CHATTING_BANNER_CLOSED_BOOLEAN_SYNC, Boolean.FALSE);
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_MAIN_MONITOR_MAIN_WORDING_STRING_SYNC, (Object) str);
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_MAIN_MONITOR_MAIN_URL_STRING_SYNC, (Object) str2);
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_MAIN_MONITOR_MAIN_INTERVAL_LONG_SYNC, Long.valueOf(j));
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_MAIN_MONITOR_MAIN_CLOSABLE_BOOLEAN_SYNC, Boolean.valueOf(z));
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_MAIN_MONITOR_MAIN_AUTOTRIGGER_BOOLEAN_SYNC, Boolean.valueOf(z2));
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_MONITOR_BANNER_MSG_COME_TIME_TICKS_LONG_SYNC, Long.valueOf(bo.anT()));
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_MAIN_BANNER_CLOSED_BOOLEAN_SYNC, Boolean.FALSE);
        aw.ZK();
        c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_MONITOR_IS_TRIGGERED_BOOLEAN_SYNC, Boolean.FALSE);
        aw.ZK();
        c.Ry().dsb();
        aaU();
        AppMethodBeat.o(16364);
    }

    public final void n(Map<String, String> map) {
        AppMethodBeat.i(16365);
        if (map == null) {
            AppMethodBeat.o(16365);
            return;
        }
        h.pYm.a(633, 3, 1, false);
        ab.d("MicroMsg.ChattingMonitoredBannerStorage", "origin values: ".concat(String.valueOf(map)));
        h(".sysmsg.banner.monitorbanner_n.", map);
        h(".sysmsg.banner.monitorbanner_o.", map);
        AppMethodBeat.o(16365);
    }

    private void h(String str, Map<String, String> map) {
        AppMethodBeat.i(16366);
        String str2 = str + "chatting.";
        String nullAsNil = bo.nullAsNil((String) map.get(str2 + FingerprintManagerProxy.FINGERPRINT_SERVICE));
        if (!str2.equals(".sysmsg.banner.monitorbanner_n.") || bo.isNullOrNil(nullAsNil)) {
            String nullAsNil2 = bo.nullAsNil((String) map.get(str2 + "url"));
            String nullAsNil3 = bo.nullAsNil((String) map.get(str2 + "wording"));
            long j = bo.getLong((String) map.get(str2 + FFmpegMetadataRetriever.METADATA_KEY_DURATION), 0);
            boolean z = bo.getInt((String) map.get(new StringBuilder().append(str2).append("autotrigger").toString()), 0) == 1;
            boolean z2 = bo.getInt((String) map.get(new StringBuilder().append(str2).append("closable").toString()), 0) == 1;
            str2 = str + "mainframe.";
            String nullAsNil4 = bo.nullAsNil((String) map.get(str2 + "url"));
            String nullAsNil5 = bo.nullAsNil((String) map.get(str2 + "wording"));
            long j2 = bo.getLong((String) map.get(str2 + FFmpegMetadataRetriever.METADATA_KEY_DURATION), 0);
            boolean z3 = bo.getInt((String) map.get(new StringBuilder().append(str2).append("autotrigger").toString()), 0) == 1;
            boolean z4 = bo.getInt((String) map.get(new StringBuilder().append(str2).append("closable").toString()), 0) == 1;
            if (!(bo.isNullOrNil(nullAsNil5) && bo.isNullOrNil(nullAsNil3))) {
                ab.d("MicroMsg.ChattingMonitoredBannerStorage", "received msg:\nchattingUrl = " + nullAsNil2 + "\nchattingWording = " + nullAsNil3 + "\nchattingDuration = " + j + "\nchattingAutotrigger = " + z + "\nchattingCloseable = " + z2 + "\nfingerPrint = " + nullAsNil);
                a(nullAsNil5, nullAsNil4, j2, z4, z3, nullAsNil3, nullAsNil2, j, z2, z, nullAsNil);
            }
            AppMethodBeat.o(16366);
            return;
        }
        ab.e("MicroMsg.ChattingMonitoredBannerStorage", "monitorbanner_n must NOT contain fingerprint.");
        AppMethodBeat.o(16366);
    }

    public static boolean a(b bVar) {
        long longValue;
        boolean booleanValue;
        boolean aaT;
        String aaQ;
        AppMethodBeat.i(16367);
        ab.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: is checking monitor banner scene: %s", bVar);
        long anT = bo.anT();
        aw.ZK();
        long longValue2 = ((Long) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_MONITOR_BANNER_MSG_COME_TIME_TICKS_LONG_SYNC, Long.valueOf(-1))).longValue();
        aw.ZK();
        String str = (String) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_CHATTING_MONITOR_FINGER_PRINT_STRING_SYNC, (Object) "");
        if (bVar == b.Chatting) {
            aw.ZK();
            longValue = ((Long) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_CHATTING_MONITOR_MAIN_INTERVAL_LONG_SYNC, Long.valueOf(0))).longValue();
            aw.ZK();
            booleanValue = ((Boolean) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_CHATTING_BANNER_CLOSED_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
            aaT = aaT();
            aaQ = aaQ();
        } else {
            aw.ZK();
            longValue = ((Long) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_MAIN_MONITOR_MAIN_INTERVAL_LONG_SYNC, Long.valueOf(0))).longValue();
            aw.ZK();
            booleanValue = ((Boolean) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_MAIN_BANNER_CLOSED_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
            aw.ZK();
            aaT = ((Boolean) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_MAIN_MONITOR_MAIN_AUTOTRIGGER_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
            aaQ = aaN();
        }
        if (!bo.isNullOrNil(str)) {
            if (str.equals(Build.FINGERPRINT)) {
                ab.d("MicroMsg.ChattingMonitoredBannerStorage", "ocr banner: fingerprint [%s] equals current device's [%s] , should show banner", str, Build.FINGERPRINT);
            } else {
                h.pYm.a(633, 5, 1, false);
                ab.d("MicroMsg.ChattingMonitoredBannerStorage", "ocr banner: fingerprint [%s] NOT equals current device's [%s] , should NOT show banner", str, Build.FINGERPRINT);
                AppMethodBeat.o(16367);
                return false;
            }
        }
        if (bo.isNullOrNil(aaQ)) {
            ab.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: not get wording");
            AppMethodBeat.o(16367);
            return false;
        } else if (booleanValue) {
            ab.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: not check trigger and already closed");
            AppMethodBeat.o(16367);
            return false;
        } else if (longValue2 < 0) {
            ab.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: no msg occurs");
            AppMethodBeat.o(16367);
            return false;
        } else if (aaT && !isTriggered()) {
            ab.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: should check triggered but not triggered");
            AppMethodBeat.o(16367);
            return false;
        } else if (longValue == -1) {
            ab.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: should always show");
            AppMethodBeat.o(16367);
            return true;
        } else if (longValue2 + longValue > anT) {
            ab.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: still in show time. show banner");
            AppMethodBeat.o(16367);
            return true;
        } else {
            ab.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: expired.");
            AppMethodBeat.o(16367);
            return false;
        }
    }

    private void aaU() {
        AppMethodBeat.i(16368);
        synchronized (b.class) {
            try {
                Iterator it = this.mListeners.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).aaW();
                }
            } finally {
                AppMethodBeat.o(16368);
            }
        }
    }

    public final void aaV() {
        AppMethodBeat.i(16369);
        if (!isTriggered()) {
            ab.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: monitored illegal set text. mark now as the start time ");
            aw.ZK();
            c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_MONITOR_BANNER_MSG_COME_TIME_TICKS_LONG_SYNC, Long.valueOf(bo.anT()));
            aw.ZK();
            c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_MONITOR_IS_TRIGGERED_BOOLEAN_SYNC, Boolean.TRUE);
            aaU();
        }
        AppMethodBeat.o(16369);
    }

    public final void b(b bVar) {
        AppMethodBeat.i(16370);
        if (bVar == b.Main) {
            aw.ZK();
            c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_MAIN_BANNER_CLOSED_BOOLEAN_SYNC, Boolean.FALSE);
        } else {
            aw.ZK();
            c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_CHATTING_BANNER_CLOSED_BOOLEAN_SYNC, Boolean.FALSE);
        }
        aaU();
        AppMethodBeat.o(16370);
    }

    public final void c(b bVar) {
        AppMethodBeat.i(16371);
        if (bVar == b.Main) {
            aw.ZK();
            c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_MAIN_MONITOR_MAIN_INTERVAL_LONG_SYNC, Long.valueOf(0));
        } else {
            if (bVar == b.Chatting) {
                if (aaT()) {
                    aw.ZK();
                    c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_CHATTING_BANNER_CLOSED_BOOLEAN_SYNC, Boolean.TRUE);
                } else {
                    aw.ZK();
                    c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_CHATTING_MONITOR_MAIN_INTERVAL_LONG_SYNC, Long.valueOf(0));
                }
            }
            AppMethodBeat.o(16371);
        }
        aaU();
        AppMethodBeat.o(16371);
    }
}
