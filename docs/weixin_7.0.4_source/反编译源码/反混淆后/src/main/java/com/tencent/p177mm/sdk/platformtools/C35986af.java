package com.tencent.p177mm.sdk.platformtools;

import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.sdk.platformtools.af */
public final class C35986af {
    private static C30282b ebD;
    private static int xyU;
    private static Map<Integer, C35986af> xyW = new HashMap();
    private static boolean xyY = false;
    private static boolean xyZ;
    private final boolean fqL;
    private long interval = 0;
    /* renamed from: ts */
    private long f15078ts = 0;
    private final int xyV;
    private final C23496a xyX;

    /* renamed from: com.tencent.mm.sdk.platformtools.af$a */
    public interface C23496a {
        /* renamed from: BI */
        boolean mo39161BI();
    }

    /* renamed from: com.tencent.mm.sdk.platformtools.af$b */
    public interface C30282b {
        void cancel();

        void prepare();
    }

    static {
        AppMethodBeat.m2504i(52050);
        AppMethodBeat.m2505o(52050);
    }

    /* renamed from: a */
    public static void m59195a(C30282b c30282b) {
        xyY = true;
        ebD = c30282b;
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.m2504i(52044);
        stopTimer();
        super.finalize();
        AppMethodBeat.m2505o(52044);
    }

    public C35986af(C23496a c23496a) {
        AppMethodBeat.m2504i(52045);
        Assert.assertTrue("bumper not initialized", xyY);
        this.xyX = c23496a;
        this.fqL = true;
        if (xyU >= Utility.DEFAULT_STREAM_BUFFER_SIZE) {
            xyU = 0;
        }
        int i = xyU + 1;
        xyU = i;
        this.xyV = i;
        AppMethodBeat.m2505o(52045);
    }

    public static long dov() {
        AppMethodBeat.m2504i(52046);
        xyZ = false;
        LinkedList linkedList = new LinkedList();
        HashSet<Integer> hashSet = new HashSet();
        hashSet.addAll(xyW.keySet());
        long j = Long.MAX_VALUE;
        for (Integer num : hashSet) {
            C35986af c35986af = (C35986af) xyW.get(num);
            if (c35986af != null) {
                long az = C5046bo.m7525az(c35986af.f15078ts);
                if (az < 0) {
                    az = 0;
                }
                if (az > c35986af.interval) {
                    if (c35986af.xyX.mo39161BI() && c35986af.fqL) {
                        j = c35986af.interval;
                    } else {
                        linkedList.add(num);
                    }
                    c35986af.f15078ts = C5046bo.m7588yz();
                } else if (c35986af.interval - az < j) {
                    j = c35986af.interval - az;
                }
            }
            j = j;
        }
        for (int i = 0; i < linkedList.size(); i++) {
            xyW.remove(linkedList.get(i));
        }
        if (!(xyZ || j != Long.MAX_VALUE || ebD == null)) {
            ebD.cancel();
            C4990ab.m7418v("MicroMsg.MAlarmHandler", "cancel bumper for no more handler");
        }
        AppMethodBeat.m2505o(52046);
        return j;
    }

    public final void dow() {
        AppMethodBeat.m2504i(52047);
        xyZ = true;
        this.interval = 50000;
        this.f15078ts = C5046bo.m7588yz();
        boolean mr = C35986af.m59196mr(this.interval);
        stopTimer();
        xyW.put(Integer.valueOf(this.xyV), this);
        if (ebD != null && mr) {
            C4990ab.m7418v("MicroMsg.MAlarmHandler", "prepare bumper");
            ebD.prepare();
        }
        AppMethodBeat.m2505o(52047);
    }

    public final void stopTimer() {
        AppMethodBeat.m2504i(52048);
        xyW.remove(Integer.valueOf(this.xyV));
        AppMethodBeat.m2505o(52048);
    }

    /* renamed from: mr */
    private static boolean m59196mr(long j) {
        long j2;
        AppMethodBeat.m2504i(52049);
        C4990ab.m7410d("MicroMsg.MAlarmHandler", "check need prepare: check=".concat(String.valueOf(j)));
        long j3 = Long.MAX_VALUE;
        Iterator it = xyW.entrySet().iterator();
        while (true) {
            j2 = j3;
            if (!it.hasNext()) {
                break;
            }
            C35986af c35986af = (C35986af) ((Entry) it.next()).getValue();
            if (c35986af != null) {
                long az = C5046bo.m7525az(c35986af.f15078ts);
                if (az < 0) {
                    az = 0;
                }
                if (az > c35986af.interval) {
                    j3 = c35986af.interval;
                } else if (c35986af.interval - az < j2) {
                    j2 = c35986af.interval - az;
                }
            }
            j3 = j2;
        }
        if (j2 > j) {
            AppMethodBeat.m2505o(52049);
            return true;
        }
        AppMethodBeat.m2505o(52049);
        return false;
    }
}
