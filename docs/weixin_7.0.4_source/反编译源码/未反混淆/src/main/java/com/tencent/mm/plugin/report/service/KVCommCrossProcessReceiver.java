package com.tencent.mm.plugin.report.service;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.tencent.mars.BaseEvent;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.l;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.Iterator;

public class KVCommCrossProcessReceiver extends BroadcastReceiver {
    private static String className = "";
    private static Object lock = new Object();
    private static ak pXF;
    private static int pXG = Downloads.MIN_WAIT_FOR_NETWORK;
    private static volatile long pXH = 10000;
    private static volatile int pXI = -1;
    private static BroadCastData pXJ = new BroadCastData();

    static /* synthetic */ void access$000() {
        AppMethodBeat.i(72715);
        cgl();
        AppMethodBeat.o(72715);
    }

    static {
        AppMethodBeat.i(72717);
        HandlerThread anM = d.anM("kv_report");
        anM.start();
        pXF = new ak(anM.getLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(72703);
                super.handleMessage(message);
                if (message.what == 1) {
                    KVCommCrossProcessReceiver.access$000();
                }
                AppMethodBeat.o(72703);
            }
        };
        AppMethodBeat.o(72717);
    }

    public void onReceive(Context context, final Intent intent) {
        AppMethodBeat.i(72706);
        if (intent == null) {
            ab.e("MicroMsg.ReportManagerKvCheck", "onReceive intent == null");
            AppMethodBeat.o(72706);
            return;
        }
        pXF.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(72704);
                ab.i("MicroMsg.ReportManagerKvCheck", "summeranrt true report runnable run tid:%d", Long.valueOf(Thread.currentThread().getId()));
                KVCommCrossProcessReceiver.a(KVCommCrossProcessReceiver.this, intent);
                AppMethodBeat.o(72704);
            }
        });
        AppMethodBeat.o(72706);
    }

    public static void cgj() {
        if (100 >= 0) {
            pXH = 100;
        }
    }

    public static void cgk() {
        pXI = 1000;
    }

    private static void cgl() {
        BroadCastData broadCastData;
        AppMethodBeat.i(72707);
        synchronized (lock) {
            try {
                broadCastData = new BroadCastData(pXJ);
                BroadCastData broadCastData2 = pXJ;
                broadCastData2.pXw.clear();
                broadCastData2.pXx.clear();
                broadCastData2.pXy.clear();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(72707);
            }
        }
        ArrayList arrayList = broadCastData.pXy;
        ArrayList arrayList2 = broadCastData.pXx;
        ArrayList arrayList3 = broadCastData.pXw;
        if (l.bM(ah.getContext()) || !ah.doI()) {
            ab.i("MicroMsg.ReportManagerKvCheck", "sendKVBroadcast shut_down_weixin, no need to notify worker");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GroupIDKeyDataInfo groupIDKeyDataInfo = (GroupIDKeyDataInfo) it.next();
                f.e(groupIDKeyDataInfo.pXz, groupIDKeyDataInfo.pXA);
            }
            it = arrayList2.iterator();
            while (it.hasNext()) {
                StIDKeyDataInfo stIDKeyDataInfo = (StIDKeyDataInfo) it.next();
                f.d((int) stIDKeyDataInfo.lhy, (int) stIDKeyDataInfo.key, (int) stIDKeyDataInfo.value, stIDKeyDataInfo.pXA);
            }
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                KVReportDataInfo kVReportDataInfo = (KVReportDataInfo) it2.next();
                f.a((int) kVReportDataInfo.pXX, (int) kVReportDataInfo.ctk, kVReportDataInfo.value, kVReportDataInfo.pXY, kVReportDataInfo.pXA, kVReportDataInfo.pXZ);
            }
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver");
        intent.setComponent(new ComponentName(ah.getPackageName(), getClassName()));
        intent.putExtra("type", 1);
        Bundle bundle = new Bundle();
        bundle.putParcelable("BUNDLE_IDKEYGROUP", broadCastData);
        intent.putExtra("INTENT_IDKEYGROUP", bundle);
        ab.d("MicroMsg.ReportManagerKvCheck", "try sendBroadcast kvdata lenght: %d, idkey data lenght:%d,group lenght:%d", Integer.valueOf(arrayList3.size()), Integer.valueOf(arrayList2.size()), Integer.valueOf(arrayList.size()));
        try {
            ah.getContext().sendBroadcast(intent);
            AppMethodBeat.o(72707);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.ReportManagerKvCheck", e, "sendBroadcastMessageDirectly", new Object[0]);
            AppMethodBeat.o(72707);
        }
    }

    private static String getClassName() {
        AppMethodBeat.i(72708);
        if (bo.isNullOrNil(className)) {
            className = ah.getPackageName() + ".plugin.report.service.KVCommCrossProcessReceiver";
        }
        String str = className;
        AppMethodBeat.o(72708);
        return str;
    }

    public static void a(KVReportDataInfo kVReportDataInfo) {
        AppMethodBeat.i(72709);
        ab.d("MicroMsg.ReportManagerKvCheck", "receive kv logid:%d, type:%d, isImportant: %b,isReportNow: %b, ignoreFreqLimit", Long.valueOf(kVReportDataInfo.pXX), Long.valueOf(kVReportDataInfo.ctk), Boolean.valueOf(kVReportDataInfo.pXA), Boolean.valueOf(kVReportDataInfo.pXY));
        synchronized (lock) {
            try {
                pXJ.pXw.add(kVReportDataInfo);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(72709);
            }
        }
        if (pXH == 0) {
            cgl();
        } else if (pXF.hasMessages(1)) {
            AppMethodBeat.o(72709);
        } else {
            pXF.sendEmptyMessageDelayed(1, pXH);
            AppMethodBeat.o(72709);
        }
    }

    public static void a(StIDKeyDataInfo stIDKeyDataInfo) {
        AppMethodBeat.i(72710);
        ab.d("MicroMsg.ReportManagerKvCheck", "receive id ID:%d, key:%d,value:%d, isImportant:%b", Long.valueOf(stIDKeyDataInfo.lhy), Long.valueOf(stIDKeyDataInfo.key), Long.valueOf(stIDKeyDataInfo.value), Boolean.valueOf(stIDKeyDataInfo.pXA));
        synchronized (lock) {
            try {
                pXJ.pXx.add(stIDKeyDataInfo);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(72710);
                }
            }
        }
        if (pXH == 0 || cgm()) {
            cgl();
            AppMethodBeat.o(72710);
        } else if (pXF.hasMessages(1)) {
            AppMethodBeat.o(72710);
        } else {
            pXF.sendEmptyMessageDelayed(1, pXH);
            AppMethodBeat.o(72710);
        }
    }

    public static void P(ArrayList<IDKey> arrayList) {
        AppMethodBeat.i(72711);
        ab.d("MicroMsg.ReportManagerKvCheck", "receive group id size:%d, isImportant:%b", Integer.valueOf(arrayList.size()), Boolean.FALSE);
        synchronized (lock) {
            try {
                BroadCastData broadCastData = pXJ;
                broadCastData.pXy.add(new GroupIDKeyDataInfo((ArrayList) arrayList));
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(72711);
                }
            }
        }
        if (pXH == 0 || cgm()) {
            cgl();
            AppMethodBeat.o(72711);
        } else if (pXF.hasMessages(1)) {
            AppMethodBeat.o(72711);
        } else {
            pXF.sendEmptyMessageDelayed(1, pXH);
            AppMethodBeat.o(72711);
        }
    }

    private static boolean cgm() {
        AppMethodBeat.i(72712);
        if (pXI <= 0) {
            AppMethodBeat.o(72712);
            return false;
        } else if (pXJ == null) {
            AppMethodBeat.o(72712);
            return false;
        } else {
            try {
                if ((pXJ.pXx.size() + pXJ.pXy.size()) + pXJ.pXw.size() >= pXI) {
                    AppMethodBeat.o(72712);
                    return true;
                }
            } catch (Exception e) {
                ab.e("MicroMsg.ReportManagerKvCheck", "checkExceedCacheItemCountLimit e = %s", e);
            }
            AppMethodBeat.o(72712);
            return false;
        }
    }

    public static void cgn() {
        AppMethodBeat.i(72713);
        if (l.bM(ah.getContext()) || !ah.doI()) {
            ab.w("MicroMsg.ReportManagerKvCheck", "sendOnCrashOrExceptionBroadCast shut_down_weixin, NO MM Process , return.");
            AppMethodBeat.o(72713);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver");
        intent.setComponent(new ComponentName(ah.getPackageName(), getClassName()));
        intent.putExtra("type", 2);
        ah.getContext().sendBroadcast(intent);
        AppMethodBeat.o(72713);
    }

    public static void cgo() {
        AppMethodBeat.i(72714);
        if (pXF == null) {
            AppMethodBeat.o(72714);
            return;
        }
        pXF.removeMessages(1);
        ak akVar = pXF;
        akVar.handleMessage(akVar.obtainMessage(1));
        AppMethodBeat.o(72714);
    }

    static /* synthetic */ void a(KVCommCrossProcessReceiver kVCommCrossProcessReceiver, Intent intent) {
        AppMethodBeat.i(72716);
        try {
            switch (w.a(intent, "type", 0)) {
                case 1:
                    Bundle bundleExtra = intent.getBundleExtra("INTENT_IDKEYGROUP");
                    if (bundleExtra != null) {
                        BroadCastData broadCastData = (BroadCastData) bundleExtra.getParcelable("BUNDLE_IDKEYGROUP");
                        ArrayList arrayList = broadCastData.pXy;
                        ArrayList arrayList2 = broadCastData.pXx;
                        ab.i("MicroMsg.ReportManagerKvCheck", "KVBroadCast onReceive kvdata lenght: %d, idkey data lenght:%d,group lenght:%d", Integer.valueOf(broadCastData.pXw.size()), Integer.valueOf(arrayList2.size()), Integer.valueOf(arrayList.size()));
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            GroupIDKeyDataInfo groupIDKeyDataInfo = (GroupIDKeyDataInfo) it.next();
                            if (groupIDKeyDataInfo != null) {
                                e.d(groupIDKeyDataInfo.pXz, groupIDKeyDataInfo.pXA);
                            }
                        }
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            StIDKeyDataInfo stIDKeyDataInfo = (StIDKeyDataInfo) it2.next();
                            if (stIDKeyDataInfo != null) {
                                e.b(stIDKeyDataInfo.lhy, stIDKeyDataInfo.key, stIDKeyDataInfo.value, stIDKeyDataInfo.pXA);
                            }
                        }
                        Iterator it3 = r7.iterator();
                        while (it3.hasNext()) {
                            KVReportDataInfo kVReportDataInfo = (KVReportDataInfo) it3.next();
                            if (kVReportDataInfo != null) {
                                e.a(kVReportDataInfo.pXX, kVReportDataInfo.value, kVReportDataInfo.pXY, kVReportDataInfo.pXA, kVReportDataInfo.pXZ);
                            }
                        }
                        break;
                    }
                    break;
                case 2:
                    ab.i("MicroMsg.ReportManagerKvCheck", "KVBroadCast onReceive TYPE_ONCRASHOREXCEPTION");
                    BaseEvent.onSingalCrash(0);
                    break;
            }
            if (l.bM(ah.getContext())) {
                new ak(Looper.myLooper()).postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(72705);
                        if (l.bM(ah.getContext())) {
                            ab.e("MicroMsg.ReportManagerKvCheck", "KVCommCrossProcessReceiver shut_down_weixin need to kill process");
                            ab.dou();
                            BaseEvent.onSingalCrash(0);
                            Process.killProcess(Process.myPid());
                        }
                        AppMethodBeat.o(72705);
                    }
                }, 5000);
            }
            AppMethodBeat.o(72716);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.ReportManagerKvCheck", e, "", new Object[0]);
            AppMethodBeat.o(72716);
        }
    }
}
