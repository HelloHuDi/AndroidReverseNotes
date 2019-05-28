package com.tencent.p177mm.plugin.trafficmonitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.plugin.downloader.model.C11511k;
import com.tencent.p177mm.plugin.downloader.model.C2886b;
import com.tencent.p177mm.sdk.platformtools.C40618o;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.trafficmonitor.TrafficClickFlowReceiver */
public class TrafficClickFlowReceiver extends BroadcastReceiver {
    private static boolean hop = false;
    private static C22441c sJP = new C22441c();
    private static String sJQ;
    private static Map<Long, C22440b> sJR = Collections.synchronizedMap(new HashMap());
    private static List<C22441c> sJS = Collections.synchronizedList(new ArrayList());
    private static List<C22440b> sJT = Collections.synchronizedList(new ArrayList());
    private static List<C22439a> sJU = Collections.synchronizedList(new ArrayList());
    private static int sJW = 0;
    private static C2886b sJX = new C2886b();
    private int sJV = 0;

    /* renamed from: com.tencent.mm.plugin.trafficmonitor.TrafficClickFlowReceiver$1 */
    static class C224381 implements C11511k {
        C224381() {
        }

        public final void onTaskStarted(long j, String str) {
            AppMethodBeat.m2504i(114760);
            TrafficClickFlowReceiver.m34120F(11, j);
            AppMethodBeat.m2505o(114760);
        }

        /* renamed from: b */
        public final void mo7665b(long j, String str, boolean z) {
            AppMethodBeat.m2504i(114761);
            TrafficClickFlowReceiver.m34120F(13, j);
            AppMethodBeat.m2505o(114761);
        }

        /* renamed from: b */
        public final void mo7664b(long j, int i, boolean z) {
            AppMethodBeat.m2504i(114762);
            TrafficClickFlowReceiver.m34120F(13, j);
            AppMethodBeat.m2505o(114762);
        }

        public final void onTaskRemoved(long j) {
            AppMethodBeat.m2504i(114763);
            TrafficClickFlowReceiver.m34120F(13, j);
            AppMethodBeat.m2505o(114763);
        }

        public final void onTaskPaused(long j) {
            AppMethodBeat.m2504i(114764);
            TrafficClickFlowReceiver.m34120F(13, j);
            AppMethodBeat.m2505o(114764);
        }

        /* renamed from: gm */
        public final void mo7667gm(long j) {
            AppMethodBeat.m2504i(114765);
            TrafficClickFlowReceiver.m34120F(12, j);
            AppMethodBeat.m2505o(114765);
        }

        /* renamed from: i */
        public final void mo7669i(long j, String str) {
            AppMethodBeat.m2504i(114766);
            TrafficClickFlowReceiver.m34120F(11, j);
            AppMethodBeat.m2505o(114766);
        }

        /* renamed from: gn */
        public final void mo7668gn(long j) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.trafficmonitor.TrafficClickFlowReceiver$a */
    static class C22439a {
        public String sJY;
        public long time;

        C22439a() {
        }

        public final String toString() {
            AppMethodBeat.m2504i(114767);
            String str = "ClickObject{ui='" + this.sJY + '\'' + ", time=" + this.time + '}';
            AppMethodBeat.m2505o(114767);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.trafficmonitor.TrafficClickFlowReceiver$b */
    static class C22440b {
        public long endTime;
        public long startTime;

        C22440b() {
        }

        public final String toString() {
            AppMethodBeat.m2504i(114768);
            String str = "DownLoadObject{startTime=" + this.startTime + ", endTime=" + this.endTime + '}';
            AppMethodBeat.m2505o(114768);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.trafficmonitor.TrafficClickFlowReceiver$c */
    static class C22441c {
        public long endTime;
        public String sJY;
        public long startTime;

        C22441c() {
        }

        public final String toString() {
            AppMethodBeat.m2504i(114769);
            String str = "UIObject{ui='" + this.sJY + '\'' + ", startTime=" + this.startTime + ", endTime=" + this.endTime + '}';
            AppMethodBeat.m2505o(114769);
            return str;
        }
    }

    static {
        AppMethodBeat.m2504i(114777);
        C2886b.m5129a(new C224381());
        AppMethodBeat.m2505o(114777);
    }

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(114770);
        if (intent == null || !intent.getAction().equals("com.tencent.mm.Intent.ACTION_NET_STATS")) {
            AppMethodBeat.m2505o(114770);
            return;
        }
        String stringExtra = intent.getStringExtra("ui");
        if (stringExtra == null) {
            stringExtra = BuildConfig.COMMAND;
        }
        if (stringExtra.contains(".")) {
            stringExtra = stringExtra.substring(stringExtra.lastIndexOf(".") + 1);
        }
        int intExtra = intent.getIntExtra("opCode", 0);
        if (intExtra == 10) {
            C22439a c22439a = new C22439a();
            c22439a.sJY = stringExtra;
            c22439a.time = System.currentTimeMillis();
            sJU.add(c22439a);
            C4990ab.m7417i("MicroMsg.TrafficClickFlow", "onReceive Click : %s", stringExtra);
            AppMethodBeat.m2505o(114770);
            return;
        }
        if (intExtra == 1) {
            sJQ = stringExtra;
        } else if (intExtra == 3) {
            if (hop) {
                C22441c c22441c = new C22441c();
                c22441c.sJY = "Background";
                c22441c.startTime = sJP.startTime;
                c22441c.endTime = System.currentTimeMillis();
                sJS.add(c22441c);
                hop = false;
            }
            sJQ = stringExtra;
            if (stringExtra != sJP.sJY) {
                sJP.sJY = stringExtra;
                sJP.startTime = System.currentTimeMillis();
            }
        } else if (intExtra == 4) {
            sJP.endTime = System.currentTimeMillis();
            if (sJP.sJY != null) {
                sJS.add(sJP);
            }
            sJP = new C22441c();
            boolean gR = C5046bo.m7556gR(C4996ah.getContext());
            boolean gl = C40618o.m70062gl(C4996ah.getContext());
            if (!(gR && gl)) {
                sJP.startTime = System.currentTimeMillis();
                sJQ = "Background";
                hop = true;
                C4990ab.m7417i("MicroMsg.TrafficClickFlow", "come to background isTopApp : %b, isScreenOn : %b", Boolean.valueOf(gR), Boolean.valueOf(gl));
            }
        } else if (intExtra == 5 && sJS.contains(stringExtra)) {
            sJQ = "Background";
        }
        this.sJV = intExtra;
        AppMethodBeat.m2505o(114770);
    }

    /* renamed from: lD */
    protected static boolean m34122lD(long j) {
        AppMethodBeat.m2504i(114771);
        C4990ab.m7417i("MicroMsg.TrafficClickFlow", "hasDownloadObjects downLoadObjects : %s", sJT.toString());
        for (int i = 0; i < sJT.size(); i++) {
            if (((C22440b) sJT.get(i)).endTime > j) {
                AppMethodBeat.m2505o(114771);
                return true;
            }
        }
        C4990ab.m7417i("MicroMsg.TrafficClickFlow", "hasDownloadObjects currentDownloadMap : %s", sJR.toString());
        if (sJR.size() > 0) {
            AppMethodBeat.m2505o(114771);
            return true;
        }
        AppMethodBeat.m2505o(114771);
        return false;
    }

    /* renamed from: lE */
    protected static boolean m34123lE(long j) {
        AppMethodBeat.m2504i(114772);
        if (sJT == null) {
            AppMethodBeat.m2505o(114772);
            return true;
        }
        C4990ab.m7417i("MicroMsg.TrafficClickFlow", "isDownloadFileNormal downLoadObjects : %s", sJT.toString());
        int i = 0;
        while (i < sJT.size()) {
            C22440b c22440b = (C22440b) sJT.get(i);
            if (c22440b.endTime <= j || TrafficClickFlowReceiver.m34124lF(c22440b.startTime)) {
                i++;
            } else {
                AppMethodBeat.m2505o(114772);
                return false;
            }
        }
        if (sJR == null) {
            AppMethodBeat.m2505o(114772);
            return true;
        }
        C4990ab.m7417i("MicroMsg.TrafficClickFlow", "isDownloadFileNormal currentDownloadMap : %s", sJR.toString());
        if (sJR.size() > 0) {
            for (Entry value : sJR.entrySet()) {
                if (!TrafficClickFlowReceiver.m34124lF(((C22440b) value.getValue()).startTime)) {
                    AppMethodBeat.m2505o(114772);
                    return false;
                }
            }
        }
        AppMethodBeat.m2505o(114772);
        return true;
    }

    /* renamed from: lF */
    private static boolean m34124lF(long j) {
        AppMethodBeat.m2504i(114773);
        if (sJU == null) {
            AppMethodBeat.m2505o(114773);
            return false;
        }
        C4990ab.m7417i("MicroMsg.TrafficClickFlow", "clickObjects : %s", sJU.toString());
        for (int i = 0; i < sJU.size(); i++) {
            if (Math.abs(j - ((C22439a) sJU.get(i)).time) < 10000) {
                AppMethodBeat.m2505o(114773);
                return true;
            }
        }
        AppMethodBeat.m2505o(114773);
        return false;
    }

    /* renamed from: a */
    protected static int m34121a(int i, long j, List<C22441c> list) {
        C22441c c22441c;
        AppMethodBeat.m2504i(114774);
        Object obj = 1;
        while (i < sJS.size()) {
            try {
                Object obj2;
                c22441c = (C22441c) sJS.get(i);
                if (obj == null || c22441c.endTime <= j) {
                    list.add(c22441c);
                    obj2 = obj;
                } else {
                    C22441c c22441c2 = new C22441c();
                    c22441c2.sJY = c22441c.sJY;
                    c22441c2.startTime = j;
                    c22441c2.endTime = c22441c.endTime;
                    list.add(c22441c2);
                    obj2 = null;
                }
                i++;
                obj = obj2;
            } catch (Exception e) {
                AppMethodBeat.m2505o(114774);
                return -1;
            }
        }
        if (list.size() == 0) {
            c22441c = new C22441c();
            c22441c.sJY = sJQ;
            c22441c.startTime = j;
            c22441c.endTime = System.currentTimeMillis();
            list.add(c22441c);
        } else {
            c22441c = new C22441c();
            c22441c.sJY = sJQ;
            c22441c.startTime = sJP.startTime;
            c22441c.endTime = System.currentTimeMillis();
            list.add(c22441c);
        }
        int size = sJS.size();
        AppMethodBeat.m2505o(114774);
        return size;
    }

    protected static void cHC() {
        AppMethodBeat.m2504i(114775);
        if (sJS == null) {
            AppMethodBeat.m2505o(114775);
            return;
        }
        sJS.clear();
        AppMethodBeat.m2505o(114775);
    }

    /* renamed from: F */
    static /* synthetic */ void m34120F(int i, long j) {
        AppMethodBeat.m2504i(114776);
        C22440b c22440b;
        if (i == 11) {
            c22440b = new C22440b();
            c22440b.startTime = System.currentTimeMillis();
            sJR.put(Long.valueOf(j), c22440b);
            AppMethodBeat.m2505o(114776);
            return;
        }
        if (i == 12) {
            if (!sJR.containsKey(Long.valueOf(j))) {
                new C22440b().startTime = System.currentTimeMillis();
                AppMethodBeat.m2505o(114776);
                return;
            }
        } else if (i == 13) {
            c22440b = (C22440b) sJR.get(Long.valueOf(j));
            if (c22440b != null) {
                c22440b.endTime = System.currentTimeMillis();
                sJT.add(c22440b);
                sJR.remove(Long.valueOf(j));
            }
        }
        AppMethodBeat.m2505o(114776);
    }
}
