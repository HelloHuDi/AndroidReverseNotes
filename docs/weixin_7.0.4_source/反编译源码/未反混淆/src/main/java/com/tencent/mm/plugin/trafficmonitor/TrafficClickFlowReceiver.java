package com.tencent.mm.plugin.trafficmonitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.downloader.model.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TrafficClickFlowReceiver extends BroadcastReceiver {
    private static boolean hop = false;
    private static c sJP = new c();
    private static String sJQ;
    private static Map<Long, b> sJR = Collections.synchronizedMap(new HashMap());
    private static List<c> sJS = Collections.synchronizedList(new ArrayList());
    private static List<b> sJT = Collections.synchronizedList(new ArrayList());
    private static List<a> sJU = Collections.synchronizedList(new ArrayList());
    private static int sJW = 0;
    private static com.tencent.mm.plugin.downloader.model.b sJX = new com.tencent.mm.plugin.downloader.model.b();
    private int sJV = 0;

    static class a {
        public String sJY;
        public long time;

        a() {
        }

        public final String toString() {
            AppMethodBeat.i(114767);
            String str = "ClickObject{ui='" + this.sJY + '\'' + ", time=" + this.time + '}';
            AppMethodBeat.o(114767);
            return str;
        }
    }

    static class b {
        public long endTime;
        public long startTime;

        b() {
        }

        public final String toString() {
            AppMethodBeat.i(114768);
            String str = "DownLoadObject{startTime=" + this.startTime + ", endTime=" + this.endTime + '}';
            AppMethodBeat.o(114768);
            return str;
        }
    }

    static class c {
        public long endTime;
        public String sJY;
        public long startTime;

        c() {
        }

        public final String toString() {
            AppMethodBeat.i(114769);
            String str = "UIObject{ui='" + this.sJY + '\'' + ", startTime=" + this.startTime + ", endTime=" + this.endTime + '}';
            AppMethodBeat.o(114769);
            return str;
        }
    }

    static {
        AppMethodBeat.i(114777);
        com.tencent.mm.plugin.downloader.model.b.a(new k() {
            public final void onTaskStarted(long j, String str) {
                AppMethodBeat.i(114760);
                TrafficClickFlowReceiver.F(11, j);
                AppMethodBeat.o(114760);
            }

            public final void b(long j, String str, boolean z) {
                AppMethodBeat.i(114761);
                TrafficClickFlowReceiver.F(13, j);
                AppMethodBeat.o(114761);
            }

            public final void b(long j, int i, boolean z) {
                AppMethodBeat.i(114762);
                TrafficClickFlowReceiver.F(13, j);
                AppMethodBeat.o(114762);
            }

            public final void onTaskRemoved(long j) {
                AppMethodBeat.i(114763);
                TrafficClickFlowReceiver.F(13, j);
                AppMethodBeat.o(114763);
            }

            public final void onTaskPaused(long j) {
                AppMethodBeat.i(114764);
                TrafficClickFlowReceiver.F(13, j);
                AppMethodBeat.o(114764);
            }

            public final void gm(long j) {
                AppMethodBeat.i(114765);
                TrafficClickFlowReceiver.F(12, j);
                AppMethodBeat.o(114765);
            }

            public final void i(long j, String str) {
                AppMethodBeat.i(114766);
                TrafficClickFlowReceiver.F(11, j);
                AppMethodBeat.o(114766);
            }

            public final void gn(long j) {
            }
        });
        AppMethodBeat.o(114777);
    }

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(114770);
        if (intent == null || !intent.getAction().equals("com.tencent.mm.Intent.ACTION_NET_STATS")) {
            AppMethodBeat.o(114770);
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
            a aVar = new a();
            aVar.sJY = stringExtra;
            aVar.time = System.currentTimeMillis();
            sJU.add(aVar);
            ab.i("MicroMsg.TrafficClickFlow", "onReceive Click : %s", stringExtra);
            AppMethodBeat.o(114770);
            return;
        }
        if (intExtra == 1) {
            sJQ = stringExtra;
        } else if (intExtra == 3) {
            if (hop) {
                c cVar = new c();
                cVar.sJY = "Background";
                cVar.startTime = sJP.startTime;
                cVar.endTime = System.currentTimeMillis();
                sJS.add(cVar);
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
            sJP = new c();
            boolean gR = bo.gR(ah.getContext());
            boolean gl = o.gl(ah.getContext());
            if (!(gR && gl)) {
                sJP.startTime = System.currentTimeMillis();
                sJQ = "Background";
                hop = true;
                ab.i("MicroMsg.TrafficClickFlow", "come to background isTopApp : %b, isScreenOn : %b", Boolean.valueOf(gR), Boolean.valueOf(gl));
            }
        } else if (intExtra == 5 && sJS.contains(stringExtra)) {
            sJQ = "Background";
        }
        this.sJV = intExtra;
        AppMethodBeat.o(114770);
    }

    protected static boolean lD(long j) {
        AppMethodBeat.i(114771);
        ab.i("MicroMsg.TrafficClickFlow", "hasDownloadObjects downLoadObjects : %s", sJT.toString());
        for (int i = 0; i < sJT.size(); i++) {
            if (((b) sJT.get(i)).endTime > j) {
                AppMethodBeat.o(114771);
                return true;
            }
        }
        ab.i("MicroMsg.TrafficClickFlow", "hasDownloadObjects currentDownloadMap : %s", sJR.toString());
        if (sJR.size() > 0) {
            AppMethodBeat.o(114771);
            return true;
        }
        AppMethodBeat.o(114771);
        return false;
    }

    protected static boolean lE(long j) {
        AppMethodBeat.i(114772);
        if (sJT == null) {
            AppMethodBeat.o(114772);
            return true;
        }
        ab.i("MicroMsg.TrafficClickFlow", "isDownloadFileNormal downLoadObjects : %s", sJT.toString());
        int i = 0;
        while (i < sJT.size()) {
            b bVar = (b) sJT.get(i);
            if (bVar.endTime <= j || lF(bVar.startTime)) {
                i++;
            } else {
                AppMethodBeat.o(114772);
                return false;
            }
        }
        if (sJR == null) {
            AppMethodBeat.o(114772);
            return true;
        }
        ab.i("MicroMsg.TrafficClickFlow", "isDownloadFileNormal currentDownloadMap : %s", sJR.toString());
        if (sJR.size() > 0) {
            for (Entry value : sJR.entrySet()) {
                if (!lF(((b) value.getValue()).startTime)) {
                    AppMethodBeat.o(114772);
                    return false;
                }
            }
        }
        AppMethodBeat.o(114772);
        return true;
    }

    private static boolean lF(long j) {
        AppMethodBeat.i(114773);
        if (sJU == null) {
            AppMethodBeat.o(114773);
            return false;
        }
        ab.i("MicroMsg.TrafficClickFlow", "clickObjects : %s", sJU.toString());
        for (int i = 0; i < sJU.size(); i++) {
            if (Math.abs(j - ((a) sJU.get(i)).time) < 10000) {
                AppMethodBeat.o(114773);
                return true;
            }
        }
        AppMethodBeat.o(114773);
        return false;
    }

    protected static int a(int i, long j, List<c> list) {
        c cVar;
        AppMethodBeat.i(114774);
        Object obj = 1;
        while (i < sJS.size()) {
            try {
                Object obj2;
                cVar = (c) sJS.get(i);
                if (obj == null || cVar.endTime <= j) {
                    list.add(cVar);
                    obj2 = obj;
                } else {
                    c cVar2 = new c();
                    cVar2.sJY = cVar.sJY;
                    cVar2.startTime = j;
                    cVar2.endTime = cVar.endTime;
                    list.add(cVar2);
                    obj2 = null;
                }
                i++;
                obj = obj2;
            } catch (Exception e) {
                AppMethodBeat.o(114774);
                return -1;
            }
        }
        if (list.size() == 0) {
            cVar = new c();
            cVar.sJY = sJQ;
            cVar.startTime = j;
            cVar.endTime = System.currentTimeMillis();
            list.add(cVar);
        } else {
            cVar = new c();
            cVar.sJY = sJQ;
            cVar.startTime = sJP.startTime;
            cVar.endTime = System.currentTimeMillis();
            list.add(cVar);
        }
        int size = sJS.size();
        AppMethodBeat.o(114774);
        return size;
    }

    protected static void cHC() {
        AppMethodBeat.i(114775);
        if (sJS == null) {
            AppMethodBeat.o(114775);
            return;
        }
        sJS.clear();
        AppMethodBeat.o(114775);
    }

    static /* synthetic */ void F(int i, long j) {
        AppMethodBeat.i(114776);
        b bVar;
        if (i == 11) {
            bVar = new b();
            bVar.startTime = System.currentTimeMillis();
            sJR.put(Long.valueOf(j), bVar);
            AppMethodBeat.o(114776);
            return;
        }
        if (i == 12) {
            if (!sJR.containsKey(Long.valueOf(j))) {
                new b().startTime = System.currentTimeMillis();
                AppMethodBeat.o(114776);
                return;
            }
        } else if (i == 13) {
            bVar = (b) sJR.get(Long.valueOf(j));
            if (bVar != null) {
                bVar.endTime = System.currentTimeMillis();
                sJT.add(bVar);
                sJR.remove(Long.valueOf(j));
            }
        }
        AppMethodBeat.o(114776);
    }
}
