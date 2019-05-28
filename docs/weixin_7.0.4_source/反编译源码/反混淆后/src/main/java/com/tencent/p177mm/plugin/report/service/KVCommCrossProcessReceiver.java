package com.tencent.p177mm.plugin.report.service;

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
import com.tencent.p177mm.kernel.C1737l;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5068w;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver */
public class KVCommCrossProcessReceiver extends BroadcastReceiver {
    private static String className = "";
    private static Object lock = new Object();
    private static C7306ak pXF;
    private static int pXG = Downloads.MIN_WAIT_FOR_NETWORK;
    private static volatile long pXH = 10000;
    private static volatile int pXI = -1;
    private static BroadCastData pXJ = new BroadCastData();

    /* renamed from: com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver$3 */
    class C37393 implements Runnable {
        C37393() {
        }

        public final void run() {
            AppMethodBeat.m2504i(72705);
            if (C1737l.m3592bM(C4996ah.getContext())) {
                C4990ab.m7412e("MicroMsg.ReportManagerKvCheck", "KVCommCrossProcessReceiver shut_down_weixin need to kill process");
                C4990ab.dou();
                BaseEvent.onSingalCrash(0);
                Process.killProcess(Process.myPid());
            }
            AppMethodBeat.m2505o(72705);
        }
    }

    static /* synthetic */ void access$000() {
        AppMethodBeat.m2504i(72715);
        KVCommCrossProcessReceiver.cgl();
        AppMethodBeat.m2505o(72715);
    }

    static {
        AppMethodBeat.m2504i(72717);
        HandlerThread anM = C7305d.anM("kv_report");
        anM.start();
        pXF = new C7306ak(anM.getLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(72703);
                super.handleMessage(message);
                if (message.what == 1) {
                    KVCommCrossProcessReceiver.access$000();
                }
                AppMethodBeat.m2505o(72703);
            }
        };
        AppMethodBeat.m2505o(72717);
    }

    public void onReceive(Context context, final Intent intent) {
        AppMethodBeat.m2504i(72706);
        if (intent == null) {
            C4990ab.m7412e("MicroMsg.ReportManagerKvCheck", "onReceive intent == null");
            AppMethodBeat.m2505o(72706);
            return;
        }
        pXF.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(72704);
                C4990ab.m7417i("MicroMsg.ReportManagerKvCheck", "summeranrt true report runnable run tid:%d", Long.valueOf(Thread.currentThread().getId()));
                KVCommCrossProcessReceiver.m6054a(KVCommCrossProcessReceiver.this, intent);
                AppMethodBeat.m2505o(72704);
            }
        });
        AppMethodBeat.m2505o(72706);
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
        AppMethodBeat.m2504i(72707);
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
                AppMethodBeat.m2505o(72707);
            }
        }
        ArrayList arrayList = broadCastData.pXy;
        ArrayList arrayList2 = broadCastData.pXx;
        ArrayList arrayList3 = broadCastData.pXw;
        if (C1737l.m3592bM(C4996ah.getContext()) || !C4996ah.doI()) {
            C4990ab.m7416i("MicroMsg.ReportManagerKvCheck", "sendKVBroadcast shut_down_weixin, no need to notify worker");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GroupIDKeyDataInfo groupIDKeyDataInfo = (GroupIDKeyDataInfo) it.next();
                C3745f.m6067e(groupIDKeyDataInfo.pXz, groupIDKeyDataInfo.pXA);
            }
            it = arrayList2.iterator();
            while (it.hasNext()) {
                StIDKeyDataInfo stIDKeyDataInfo = (StIDKeyDataInfo) it.next();
                C3745f.m6066d((int) stIDKeyDataInfo.lhy, (int) stIDKeyDataInfo.key, (int) stIDKeyDataInfo.value, stIDKeyDataInfo.pXA);
            }
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                KVReportDataInfo kVReportDataInfo = (KVReportDataInfo) it2.next();
                C3745f.m6064a((int) kVReportDataInfo.pXX, (int) kVReportDataInfo.ctk, kVReportDataInfo.value, kVReportDataInfo.pXY, kVReportDataInfo.pXA, kVReportDataInfo.pXZ);
            }
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver");
        intent.setComponent(new ComponentName(C4996ah.getPackageName(), KVCommCrossProcessReceiver.getClassName()));
        intent.putExtra("type", 1);
        Bundle bundle = new Bundle();
        bundle.putParcelable("BUNDLE_IDKEYGROUP", broadCastData);
        intent.putExtra("INTENT_IDKEYGROUP", bundle);
        C4990ab.m7411d("MicroMsg.ReportManagerKvCheck", "try sendBroadcast kvdata lenght: %d, idkey data lenght:%d,group lenght:%d", Integer.valueOf(arrayList3.size()), Integer.valueOf(arrayList2.size()), Integer.valueOf(arrayList.size()));
        try {
            C4996ah.getContext().sendBroadcast(intent);
            AppMethodBeat.m2505o(72707);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.ReportManagerKvCheck", e, "sendBroadcastMessageDirectly", new Object[0]);
            AppMethodBeat.m2505o(72707);
        }
    }

    private static String getClassName() {
        AppMethodBeat.m2504i(72708);
        if (C5046bo.isNullOrNil(className)) {
            className = C4996ah.getPackageName() + ".plugin.report.service.KVCommCrossProcessReceiver";
        }
        String str = className;
        AppMethodBeat.m2505o(72708);
        return str;
    }

    /* renamed from: a */
    public static void m6055a(KVReportDataInfo kVReportDataInfo) {
        AppMethodBeat.m2504i(72709);
        C4990ab.m7411d("MicroMsg.ReportManagerKvCheck", "receive kv logid:%d, type:%d, isImportant: %b,isReportNow: %b, ignoreFreqLimit", Long.valueOf(kVReportDataInfo.pXX), Long.valueOf(kVReportDataInfo.ctk), Boolean.valueOf(kVReportDataInfo.pXA), Boolean.valueOf(kVReportDataInfo.pXY));
        synchronized (lock) {
            try {
                pXJ.pXw.add(kVReportDataInfo);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(72709);
            }
        }
        if (pXH == 0) {
            KVCommCrossProcessReceiver.cgl();
        } else if (pXF.hasMessages(1)) {
            AppMethodBeat.m2505o(72709);
        } else {
            pXF.sendEmptyMessageDelayed(1, pXH);
            AppMethodBeat.m2505o(72709);
        }
    }

    /* renamed from: a */
    public static void m6056a(StIDKeyDataInfo stIDKeyDataInfo) {
        AppMethodBeat.m2504i(72710);
        C4990ab.m7411d("MicroMsg.ReportManagerKvCheck", "receive id ID:%d, key:%d,value:%d, isImportant:%b", Long.valueOf(stIDKeyDataInfo.lhy), Long.valueOf(stIDKeyDataInfo.key), Long.valueOf(stIDKeyDataInfo.value), Boolean.valueOf(stIDKeyDataInfo.pXA));
        synchronized (lock) {
            try {
                pXJ.pXx.add(stIDKeyDataInfo);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(72710);
                }
            }
        }
        if (pXH == 0 || KVCommCrossProcessReceiver.cgm()) {
            KVCommCrossProcessReceiver.cgl();
            AppMethodBeat.m2505o(72710);
        } else if (pXF.hasMessages(1)) {
            AppMethodBeat.m2505o(72710);
        } else {
            pXF.sendEmptyMessageDelayed(1, pXH);
            AppMethodBeat.m2505o(72710);
        }
    }

    /* renamed from: P */
    public static void m6053P(ArrayList<IDKey> arrayList) {
        AppMethodBeat.m2504i(72711);
        C4990ab.m7411d("MicroMsg.ReportManagerKvCheck", "receive group id size:%d, isImportant:%b", Integer.valueOf(arrayList.size()), Boolean.FALSE);
        synchronized (lock) {
            try {
                BroadCastData broadCastData = pXJ;
                broadCastData.pXy.add(new GroupIDKeyDataInfo((ArrayList) arrayList));
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(72711);
                }
            }
        }
        if (pXH == 0 || KVCommCrossProcessReceiver.cgm()) {
            KVCommCrossProcessReceiver.cgl();
            AppMethodBeat.m2505o(72711);
        } else if (pXF.hasMessages(1)) {
            AppMethodBeat.m2505o(72711);
        } else {
            pXF.sendEmptyMessageDelayed(1, pXH);
            AppMethodBeat.m2505o(72711);
        }
    }

    private static boolean cgm() {
        AppMethodBeat.m2504i(72712);
        if (pXI <= 0) {
            AppMethodBeat.m2505o(72712);
            return false;
        } else if (pXJ == null) {
            AppMethodBeat.m2505o(72712);
            return false;
        } else {
            try {
                if ((pXJ.pXx.size() + pXJ.pXy.size()) + pXJ.pXw.size() >= pXI) {
                    AppMethodBeat.m2505o(72712);
                    return true;
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.ReportManagerKvCheck", "checkExceedCacheItemCountLimit e = %s", e);
            }
            AppMethodBeat.m2505o(72712);
            return false;
        }
    }

    public static void cgn() {
        AppMethodBeat.m2504i(72713);
        if (C1737l.m3592bM(C4996ah.getContext()) || !C4996ah.doI()) {
            C4990ab.m7420w("MicroMsg.ReportManagerKvCheck", "sendOnCrashOrExceptionBroadCast shut_down_weixin, NO MM Process , return.");
            AppMethodBeat.m2505o(72713);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver");
        intent.setComponent(new ComponentName(C4996ah.getPackageName(), KVCommCrossProcessReceiver.getClassName()));
        intent.putExtra("type", 2);
        C4996ah.getContext().sendBroadcast(intent);
        AppMethodBeat.m2505o(72713);
    }

    public static void cgo() {
        AppMethodBeat.m2504i(72714);
        if (pXF == null) {
            AppMethodBeat.m2505o(72714);
            return;
        }
        pXF.removeMessages(1);
        C7306ak c7306ak = pXF;
        c7306ak.handleMessage(c7306ak.obtainMessage(1));
        AppMethodBeat.m2505o(72714);
    }

    /* renamed from: a */
    static /* synthetic */ void m6054a(KVCommCrossProcessReceiver kVCommCrossProcessReceiver, Intent intent) {
        AppMethodBeat.m2504i(72716);
        try {
            switch (C5068w.m7682a(intent, "type", 0)) {
                case 1:
                    Bundle bundleExtra = intent.getBundleExtra("INTENT_IDKEYGROUP");
                    if (bundleExtra != null) {
                        BroadCastData broadCastData = (BroadCastData) bundleExtra.getParcelable("BUNDLE_IDKEYGROUP");
                        ArrayList arrayList = broadCastData.pXy;
                        ArrayList arrayList2 = broadCastData.pXx;
                        C4990ab.m7417i("MicroMsg.ReportManagerKvCheck", "KVBroadCast onReceive kvdata lenght: %d, idkey data lenght:%d,group lenght:%d", Integer.valueOf(broadCastData.pXw.size()), Integer.valueOf(arrayList2.size()), Integer.valueOf(arrayList.size()));
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            GroupIDKeyDataInfo groupIDKeyDataInfo = (GroupIDKeyDataInfo) it.next();
                            if (groupIDKeyDataInfo != null) {
                                C3744e.m6061d(groupIDKeyDataInfo.pXz, groupIDKeyDataInfo.pXA);
                            }
                        }
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            StIDKeyDataInfo stIDKeyDataInfo = (StIDKeyDataInfo) it2.next();
                            if (stIDKeyDataInfo != null) {
                                C3744e.m6060b(stIDKeyDataInfo.lhy, stIDKeyDataInfo.key, stIDKeyDataInfo.value, stIDKeyDataInfo.pXA);
                            }
                        }
                        Iterator it3 = r7.iterator();
                        while (it3.hasNext()) {
                            KVReportDataInfo kVReportDataInfo = (KVReportDataInfo) it3.next();
                            if (kVReportDataInfo != null) {
                                C3744e.m6058a(kVReportDataInfo.pXX, kVReportDataInfo.value, kVReportDataInfo.pXY, kVReportDataInfo.pXA, kVReportDataInfo.pXZ);
                            }
                        }
                        break;
                    }
                    break;
                case 2:
                    C4990ab.m7416i("MicroMsg.ReportManagerKvCheck", "KVBroadCast onReceive TYPE_ONCRASHOREXCEPTION");
                    BaseEvent.onSingalCrash(0);
                    break;
            }
            if (C1737l.m3592bM(C4996ah.getContext())) {
                new C7306ak(Looper.myLooper()).postDelayed(new C37393(), 5000);
            }
            AppMethodBeat.m2505o(72716);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.ReportManagerKvCheck", e, "", new Object[0]);
            AppMethodBeat.m2505o(72716);
        }
    }
}
