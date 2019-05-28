package com.tencent.p177mm.plugin.trafficmonitor;

import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.trafficmonitor.c */
public abstract class C40012c {
    private final String TAG = "MicroMsg.TrafficInspector";
    int currentIndex;
    /* renamed from: id */
    int f16189id;
    long interval;
    C29473d sJZ;
    C29472a sKa;
    int type;

    /* renamed from: com.tencent.mm.plugin.trafficmonitor.c$a */
    public interface C29472a {
    }

    public abstract void cHB();

    /* renamed from: lG */
    static boolean m68518lG(long j) {
        if (!TrafficClickFlowReceiver.m34122lD(j)) {
            return false;
        }
        boolean lE = TrafficClickFlowReceiver.m34123lE(j);
        C4990ab.m7416i("MicroMsg.TrafficInspector", "hasDownload");
        return lE;
    }

    /* Access modifiers changed, original: final */
    public final void cHD() {
        C22442e.cHE();
        if (this.f16189id == C22442e.cHH()) {
            TrafficClickFlowReceiver.cHC();
            C22442e.cHE();
            C22442e.cHG();
        }
    }
}
