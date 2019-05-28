package com.tencent.p177mm.plugin.mmsight;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.concurrent.ConcurrentSkipListSet;

/* renamed from: com.tencent.mm.plugin.mmsight.c */
public final class C21290c {
    private static ConcurrentSkipListSet<Integer> oss = new ConcurrentSkipListSet();

    static {
        AppMethodBeat.m2504i(60270);
        AppMethodBeat.m2505o(60270);
    }

    /* renamed from: yK */
    public static synchronized void m32668yK(int i) {
        synchronized (C21290c.class) {
            AppMethodBeat.m2504i(60267);
            try {
                C4990ab.m7417i("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxing: %s", Integer.valueOf(i));
                oss.add(Integer.valueOf(i));
                AppMethodBeat.m2505o(60267);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxing error: %s", e.getMessage());
                AppMethodBeat.m2505o(60267);
            }
        }
        return;
    }

    /* renamed from: yL */
    public static synchronized void m32669yL(int i) {
        synchronized (C21290c.class) {
            AppMethodBeat.m2504i(60268);
            try {
                C4990ab.m7417i("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxingFinish: %s", Integer.valueOf(i));
                oss.remove(Integer.valueOf(i));
                AppMethodBeat.m2505o(60268);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxingFinish error: %s", e.getMessage());
                AppMethodBeat.m2505o(60268);
            }
        }
        return;
    }

    /* renamed from: yM */
    public static synchronized boolean m32670yM(int i) {
        boolean contains;
        synchronized (C21290c.class) {
            AppMethodBeat.m2504i(60269);
            try {
                contains = oss.contains(Integer.valueOf(i));
                C4990ab.m7411d("MicroMsg.MMSightCaptureVideoRemuxStatus", "isMsgRemuxing: %s, %s", Integer.valueOf(i), Boolean.valueOf(contains));
                AppMethodBeat.m2505o(60269);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.MMSightCaptureVideoRemuxStatus", "isMsgRemuxing error: %s", e.getMessage());
                AppMethodBeat.m2505o(60269);
                contains = false;
            }
        }
        return contains;
    }
}
