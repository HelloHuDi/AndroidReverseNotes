package com.tencent.mm.sdk.platformtools;

import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import junit.framework.Assert;

public final class af {
    private static b ebD;
    private static int xyU;
    private static Map<Integer, af> xyW = new HashMap();
    private static boolean xyY = false;
    private static boolean xyZ;
    private final boolean fqL;
    private long interval = 0;
    private long ts = 0;
    private final int xyV;
    private final a xyX;

    public interface a {
        boolean BI();
    }

    public interface b {
        void cancel();

        void prepare();
    }

    static {
        AppMethodBeat.i(52050);
        AppMethodBeat.o(52050);
    }

    public static void a(b bVar) {
        xyY = true;
        ebD = bVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.i(52044);
        stopTimer();
        super.finalize();
        AppMethodBeat.o(52044);
    }

    public af(a aVar) {
        AppMethodBeat.i(52045);
        Assert.assertTrue("bumper not initialized", xyY);
        this.xyX = aVar;
        this.fqL = true;
        if (xyU >= Utility.DEFAULT_STREAM_BUFFER_SIZE) {
            xyU = 0;
        }
        int i = xyU + 1;
        xyU = i;
        this.xyV = i;
        AppMethodBeat.o(52045);
    }

    public static long dov() {
        AppMethodBeat.i(52046);
        xyZ = false;
        LinkedList linkedList = new LinkedList();
        HashSet<Integer> hashSet = new HashSet();
        hashSet.addAll(xyW.keySet());
        long j = Long.MAX_VALUE;
        for (Integer num : hashSet) {
            af afVar = (af) xyW.get(num);
            if (afVar != null) {
                long az = bo.az(afVar.ts);
                if (az < 0) {
                    az = 0;
                }
                if (az > afVar.interval) {
                    if (afVar.xyX.BI() && afVar.fqL) {
                        j = afVar.interval;
                    } else {
                        linkedList.add(num);
                    }
                    afVar.ts = bo.yz();
                } else if (afVar.interval - az < j) {
                    j = afVar.interval - az;
                }
            }
            j = j;
        }
        for (int i = 0; i < linkedList.size(); i++) {
            xyW.remove(linkedList.get(i));
        }
        if (!(xyZ || j != Long.MAX_VALUE || ebD == null)) {
            ebD.cancel();
            ab.v("MicroMsg.MAlarmHandler", "cancel bumper for no more handler");
        }
        AppMethodBeat.o(52046);
        return j;
    }

    public final void dow() {
        AppMethodBeat.i(52047);
        xyZ = true;
        this.interval = 50000;
        this.ts = bo.yz();
        boolean mr = mr(this.interval);
        stopTimer();
        xyW.put(Integer.valueOf(this.xyV), this);
        if (ebD != null && mr) {
            ab.v("MicroMsg.MAlarmHandler", "prepare bumper");
            ebD.prepare();
        }
        AppMethodBeat.o(52047);
    }

    public final void stopTimer() {
        AppMethodBeat.i(52048);
        xyW.remove(Integer.valueOf(this.xyV));
        AppMethodBeat.o(52048);
    }

    private static boolean mr(long j) {
        long j2;
        AppMethodBeat.i(52049);
        ab.d("MicroMsg.MAlarmHandler", "check need prepare: check=".concat(String.valueOf(j)));
        long j3 = Long.MAX_VALUE;
        Iterator it = xyW.entrySet().iterator();
        while (true) {
            j2 = j3;
            if (!it.hasNext()) {
                break;
            }
            af afVar = (af) ((Entry) it.next()).getValue();
            if (afVar != null) {
                long az = bo.az(afVar.ts);
                if (az < 0) {
                    az = 0;
                }
                if (az > afVar.interval) {
                    j3 = afVar.interval;
                } else if (afVar.interval - az < j2) {
                    j2 = afVar.interval - az;
                }
            }
            j3 = j2;
        }
        if (j2 > j) {
            AppMethodBeat.o(52049);
            return true;
        }
        AppMethodBeat.o(52049);
        return false;
    }
}
