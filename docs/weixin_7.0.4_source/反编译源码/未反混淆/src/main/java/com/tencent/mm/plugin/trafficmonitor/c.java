package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.mm.sdk.platformtools.ab;

public abstract class c {
    private final String TAG = "MicroMsg.TrafficInspector";
    int currentIndex;
    int id;
    long interval;
    d sJZ;
    a sKa;
    int type;

    public interface a {
    }

    public abstract void cHB();

    static boolean lG(long j) {
        if (!TrafficClickFlowReceiver.lD(j)) {
            return false;
        }
        boolean lE = TrafficClickFlowReceiver.lE(j);
        ab.i("MicroMsg.TrafficInspector", "hasDownload");
        return lE;
    }

    /* Access modifiers changed, original: final */
    public final void cHD() {
        e.cHE();
        if (this.id == e.cHH()) {
            TrafficClickFlowReceiver.cHC();
            e.cHE();
            e.cHG();
        }
    }
}
