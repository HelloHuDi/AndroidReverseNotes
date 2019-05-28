package com.tencent.p177mm.model.p871b;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.tencent.mm.model.b.b */
public class C45437b {
    private boolean fog = false;
    public ArrayList<C9645a> mListeners = new ArrayList();

    /* renamed from: com.tencent.mm.model.b.b$a */
    public interface C9645a {
        void aaW();
    }

    /* renamed from: com.tencent.mm.model.b.b$b */
    public enum C9646b {
        Main,
        Chatting;

        static {
            AppMethodBeat.m2505o(16354);
        }
    }

    public C45437b() {
        AppMethodBeat.m2504i(16355);
        AppMethodBeat.m2505o(16355);
    }

    public static String aaN() {
        AppMethodBeat.m2504i(16356);
        C9638aw.m17190ZK();
        String str = (String) C18628c.m29072Ry().get(C5127a.USERINFO_MAIN_MONITOR_MAIN_WORDING_STRING_SYNC, (Object) "");
        AppMethodBeat.m2505o(16356);
        return str;
    }

    public static String aaO() {
        AppMethodBeat.m2504i(16357);
        C9638aw.m17190ZK();
        String str = (String) C18628c.m29072Ry().get(C5127a.USERINFO_MAIN_MONITOR_MAIN_URL_STRING_SYNC, (Object) "");
        AppMethodBeat.m2505o(16357);
        return str;
    }

    public static boolean aaP() {
        AppMethodBeat.m2504i(16358);
        C9638aw.m17190ZK();
        boolean booleanValue = ((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_MAIN_MONITOR_MAIN_CLOSABLE_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
        AppMethodBeat.m2505o(16358);
        return booleanValue;
    }

    public static String aaQ() {
        AppMethodBeat.m2504i(16359);
        C9638aw.m17190ZK();
        String str = (String) C18628c.m29072Ry().get(C5127a.USERINFO_CHATTING_MONITOR_MAIN_WORDING_STRING_SYNC, (Object) "");
        AppMethodBeat.m2505o(16359);
        return str;
    }

    public static String aaR() {
        AppMethodBeat.m2504i(16360);
        C9638aw.m17190ZK();
        String str = (String) C18628c.m29072Ry().get(C5127a.USERINFO_CHATTING_MONITOR_MAIN_URL_STRING_SYNC, (Object) "");
        AppMethodBeat.m2505o(16360);
        return str;
    }

    public static boolean aaS() {
        AppMethodBeat.m2504i(16361);
        C9638aw.m17190ZK();
        boolean booleanValue = ((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_CHATTING_MONITOR_MAIN_CLOSABLE_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
        AppMethodBeat.m2505o(16361);
        return booleanValue;
    }

    private static boolean aaT() {
        AppMethodBeat.m2504i(16362);
        C9638aw.m17190ZK();
        boolean booleanValue = ((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_CHATTING_MONITOR_MAIN_AUTOTRIGGER_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
        AppMethodBeat.m2505o(16362);
        return booleanValue;
    }

    private static boolean isTriggered() {
        AppMethodBeat.m2504i(16363);
        C9638aw.m17190ZK();
        boolean booleanValue = ((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_MONITOR_IS_TRIGGERED_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
        AppMethodBeat.m2505o(16363);
        return booleanValue;
    }

    /* renamed from: a */
    private void m83690a(String str, String str2, long j, boolean z, boolean z2, String str3, String str4, long j2, boolean z3, boolean z4, String str5) {
        AppMethodBeat.m2504i(16364);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_CHATTING_MONITOR_MAIN_WORDING_STRING_SYNC, (Object) str3);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_CHATTING_MONITOR_MAIN_URL_STRING_SYNC, (Object) str4);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_CHATTING_MONITOR_MAIN_INTERVAL_LONG_SYNC, Long.valueOf(j2));
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_CHATTING_MONITOR_MAIN_CLOSABLE_BOOLEAN_SYNC, Boolean.valueOf(z3));
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_CHATTING_MONITOR_MAIN_AUTOTRIGGER_BOOLEAN_SYNC, Boolean.valueOf(z4));
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_CHATTING_MONITOR_FINGER_PRINT_STRING_SYNC, (Object) str5);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_CHATTING_BANNER_CLOSED_BOOLEAN_SYNC, Boolean.FALSE);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_MAIN_MONITOR_MAIN_WORDING_STRING_SYNC, (Object) str);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_MAIN_MONITOR_MAIN_URL_STRING_SYNC, (Object) str2);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_MAIN_MONITOR_MAIN_INTERVAL_LONG_SYNC, Long.valueOf(j));
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_MAIN_MONITOR_MAIN_CLOSABLE_BOOLEAN_SYNC, Boolean.valueOf(z));
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_MAIN_MONITOR_MAIN_AUTOTRIGGER_BOOLEAN_SYNC, Boolean.valueOf(z2));
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_MONITOR_BANNER_MSG_COME_TIME_TICKS_LONG_SYNC, Long.valueOf(C5046bo.anT()));
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_MAIN_BANNER_CLOSED_BOOLEAN_SYNC, Boolean.FALSE);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_MONITOR_IS_TRIGGERED_BOOLEAN_SYNC, Boolean.FALSE);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().dsb();
        aaU();
        AppMethodBeat.m2505o(16364);
    }

    /* renamed from: n */
    public final void mo73241n(Map<String, String> map) {
        AppMethodBeat.m2504i(16365);
        if (map == null) {
            AppMethodBeat.m2505o(16365);
            return;
        }
        C7060h.pYm.mo8378a(633, 3, 1, false);
        C4990ab.m7410d("MicroMsg.ChattingMonitoredBannerStorage", "origin values: ".concat(String.valueOf(map)));
        m83692h(".sysmsg.banner.monitorbanner_n.", map);
        m83692h(".sysmsg.banner.monitorbanner_o.", map);
        AppMethodBeat.m2505o(16365);
    }

    /* renamed from: h */
    private void m83692h(String str, Map<String, String> map) {
        AppMethodBeat.m2504i(16366);
        String str2 = str + "chatting.";
        String nullAsNil = C5046bo.nullAsNil((String) map.get(str2 + FingerprintManagerProxy.FINGERPRINT_SERVICE));
        if (!str2.equals(".sysmsg.banner.monitorbanner_n.") || C5046bo.isNullOrNil(nullAsNil)) {
            String nullAsNil2 = C5046bo.nullAsNil((String) map.get(str2 + "url"));
            String nullAsNil3 = C5046bo.nullAsNil((String) map.get(str2 + "wording"));
            long j = C5046bo.getLong((String) map.get(str2 + FFmpegMetadataRetriever.METADATA_KEY_DURATION), 0);
            boolean z = C5046bo.getInt((String) map.get(new StringBuilder().append(str2).append("autotrigger").toString()), 0) == 1;
            boolean z2 = C5046bo.getInt((String) map.get(new StringBuilder().append(str2).append("closable").toString()), 0) == 1;
            str2 = str + "mainframe.";
            String nullAsNil4 = C5046bo.nullAsNil((String) map.get(str2 + "url"));
            String nullAsNil5 = C5046bo.nullAsNil((String) map.get(str2 + "wording"));
            long j2 = C5046bo.getLong((String) map.get(str2 + FFmpegMetadataRetriever.METADATA_KEY_DURATION), 0);
            boolean z3 = C5046bo.getInt((String) map.get(new StringBuilder().append(str2).append("autotrigger").toString()), 0) == 1;
            boolean z4 = C5046bo.getInt((String) map.get(new StringBuilder().append(str2).append("closable").toString()), 0) == 1;
            if (!(C5046bo.isNullOrNil(nullAsNil5) && C5046bo.isNullOrNil(nullAsNil3))) {
                C4990ab.m7410d("MicroMsg.ChattingMonitoredBannerStorage", "received msg:\nchattingUrl = " + nullAsNil2 + "\nchattingWording = " + nullAsNil3 + "\nchattingDuration = " + j + "\nchattingAutotrigger = " + z + "\nchattingCloseable = " + z2 + "\nfingerPrint = " + nullAsNil);
                m83690a(nullAsNil5, nullAsNil4, j2, z4, z3, nullAsNil3, nullAsNil2, j, z2, z, nullAsNil);
            }
            AppMethodBeat.m2505o(16366);
            return;
        }
        C4990ab.m7412e("MicroMsg.ChattingMonitoredBannerStorage", "monitorbanner_n must NOT contain fingerprint.");
        AppMethodBeat.m2505o(16366);
    }

    /* renamed from: a */
    public static boolean m83691a(C9646b c9646b) {
        long longValue;
        boolean booleanValue;
        boolean aaT;
        String aaQ;
        AppMethodBeat.m2504i(16367);
        C4990ab.m7411d("MicroMsg.ChattingMonitoredBannerStorage", "hy: is checking monitor banner scene: %s", c9646b);
        long anT = C5046bo.anT();
        C9638aw.m17190ZK();
        long longValue2 = ((Long) C18628c.m29072Ry().get(C5127a.USERINFO_MONITOR_BANNER_MSG_COME_TIME_TICKS_LONG_SYNC, Long.valueOf(-1))).longValue();
        C9638aw.m17190ZK();
        String str = (String) C18628c.m29072Ry().get(C5127a.USERINFO_CHATTING_MONITOR_FINGER_PRINT_STRING_SYNC, (Object) "");
        if (c9646b == C9646b.Chatting) {
            C9638aw.m17190ZK();
            longValue = ((Long) C18628c.m29072Ry().get(C5127a.USERINFO_CHATTING_MONITOR_MAIN_INTERVAL_LONG_SYNC, Long.valueOf(0))).longValue();
            C9638aw.m17190ZK();
            booleanValue = ((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_CHATTING_BANNER_CLOSED_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
            aaT = C45437b.aaT();
            aaQ = C45437b.aaQ();
        } else {
            C9638aw.m17190ZK();
            longValue = ((Long) C18628c.m29072Ry().get(C5127a.USERINFO_MAIN_MONITOR_MAIN_INTERVAL_LONG_SYNC, Long.valueOf(0))).longValue();
            C9638aw.m17190ZK();
            booleanValue = ((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_MAIN_BANNER_CLOSED_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
            C9638aw.m17190ZK();
            aaT = ((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_MAIN_MONITOR_MAIN_AUTOTRIGGER_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
            aaQ = C45437b.aaN();
        }
        if (!C5046bo.isNullOrNil(str)) {
            if (str.equals(Build.FINGERPRINT)) {
                C4990ab.m7411d("MicroMsg.ChattingMonitoredBannerStorage", "ocr banner: fingerprint [%s] equals current device's [%s] , should show banner", str, Build.FINGERPRINT);
            } else {
                C7060h.pYm.mo8378a(633, 5, 1, false);
                C4990ab.m7411d("MicroMsg.ChattingMonitoredBannerStorage", "ocr banner: fingerprint [%s] NOT equals current device's [%s] , should NOT show banner", str, Build.FINGERPRINT);
                AppMethodBeat.m2505o(16367);
                return false;
            }
        }
        if (C5046bo.isNullOrNil(aaQ)) {
            C4990ab.m7410d("MicroMsg.ChattingMonitoredBannerStorage", "hy: not get wording");
            AppMethodBeat.m2505o(16367);
            return false;
        } else if (booleanValue) {
            C4990ab.m7410d("MicroMsg.ChattingMonitoredBannerStorage", "hy: not check trigger and already closed");
            AppMethodBeat.m2505o(16367);
            return false;
        } else if (longValue2 < 0) {
            C4990ab.m7410d("MicroMsg.ChattingMonitoredBannerStorage", "hy: no msg occurs");
            AppMethodBeat.m2505o(16367);
            return false;
        } else if (aaT && !C45437b.isTriggered()) {
            C4990ab.m7410d("MicroMsg.ChattingMonitoredBannerStorage", "hy: should check triggered but not triggered");
            AppMethodBeat.m2505o(16367);
            return false;
        } else if (longValue == -1) {
            C4990ab.m7416i("MicroMsg.ChattingMonitoredBannerStorage", "hy: should always show");
            AppMethodBeat.m2505o(16367);
            return true;
        } else if (longValue2 + longValue > anT) {
            C4990ab.m7416i("MicroMsg.ChattingMonitoredBannerStorage", "hy: still in show time. show banner");
            AppMethodBeat.m2505o(16367);
            return true;
        } else {
            C4990ab.m7416i("MicroMsg.ChattingMonitoredBannerStorage", "hy: expired.");
            AppMethodBeat.m2505o(16367);
            return false;
        }
    }

    private void aaU() {
        AppMethodBeat.m2504i(16368);
        synchronized (C45437b.class) {
            try {
                Iterator it = this.mListeners.iterator();
                while (it.hasNext()) {
                    ((C9645a) it.next()).aaW();
                }
            } finally {
                AppMethodBeat.m2505o(16368);
            }
        }
    }

    public final void aaV() {
        AppMethodBeat.m2504i(16369);
        if (!C45437b.isTriggered()) {
            C4990ab.m7410d("MicroMsg.ChattingMonitoredBannerStorage", "hy: monitored illegal set text. mark now as the start time ");
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_MONITOR_BANNER_MSG_COME_TIME_TICKS_LONG_SYNC, Long.valueOf(C5046bo.anT()));
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_MONITOR_IS_TRIGGERED_BOOLEAN_SYNC, Boolean.TRUE);
            aaU();
        }
        AppMethodBeat.m2505o(16369);
    }

    /* renamed from: b */
    public final void mo73239b(C9646b c9646b) {
        AppMethodBeat.m2504i(16370);
        if (c9646b == C9646b.Main) {
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_MAIN_BANNER_CLOSED_BOOLEAN_SYNC, Boolean.FALSE);
        } else {
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_CHATTING_BANNER_CLOSED_BOOLEAN_SYNC, Boolean.FALSE);
        }
        aaU();
        AppMethodBeat.m2505o(16370);
    }

    /* renamed from: c */
    public final void mo73240c(C9646b c9646b) {
        AppMethodBeat.m2504i(16371);
        if (c9646b == C9646b.Main) {
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_MAIN_MONITOR_MAIN_INTERVAL_LONG_SYNC, Long.valueOf(0));
        } else {
            if (c9646b == C9646b.Chatting) {
                if (C45437b.aaT()) {
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(C5127a.USERINFO_CHATTING_BANNER_CLOSED_BOOLEAN_SYNC, Boolean.TRUE);
                } else {
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(C5127a.USERINFO_CHATTING_MONITOR_MAIN_INTERVAL_LONG_SYNC, Long.valueOf(0));
                }
            }
            AppMethodBeat.m2505o(16371);
        }
        aaU();
        AppMethodBeat.m2505o(16371);
    }
}
