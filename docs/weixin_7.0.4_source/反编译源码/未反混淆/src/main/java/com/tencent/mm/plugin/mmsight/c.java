package com.tencent.mm.plugin.mmsight;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.ConcurrentSkipListSet;

public final class c {
    private static ConcurrentSkipListSet<Integer> oss = new ConcurrentSkipListSet();

    static {
        AppMethodBeat.i(60270);
        AppMethodBeat.o(60270);
    }

    public static synchronized void yK(int i) {
        synchronized (c.class) {
            AppMethodBeat.i(60267);
            try {
                ab.i("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxing: %s", Integer.valueOf(i));
                oss.add(Integer.valueOf(i));
                AppMethodBeat.o(60267);
            } catch (Exception e) {
                ab.e("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxing error: %s", e.getMessage());
                AppMethodBeat.o(60267);
            }
        }
        return;
    }

    public static synchronized void yL(int i) {
        synchronized (c.class) {
            AppMethodBeat.i(60268);
            try {
                ab.i("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxingFinish: %s", Integer.valueOf(i));
                oss.remove(Integer.valueOf(i));
                AppMethodBeat.o(60268);
            } catch (Exception e) {
                ab.e("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxingFinish error: %s", e.getMessage());
                AppMethodBeat.o(60268);
            }
        }
        return;
    }

    public static synchronized boolean yM(int i) {
        boolean contains;
        synchronized (c.class) {
            AppMethodBeat.i(60269);
            try {
                contains = oss.contains(Integer.valueOf(i));
                ab.d("MicroMsg.MMSightCaptureVideoRemuxStatus", "isMsgRemuxing: %s, %s", Integer.valueOf(i), Boolean.valueOf(contains));
                AppMethodBeat.o(60269);
            } catch (Exception e) {
                ab.e("MicroMsg.MMSightCaptureVideoRemuxStatus", "isMsgRemuxing error: %s", e.getMessage());
                AppMethodBeat.o(60269);
                contains = false;
            }
        }
        return contains;
    }
}
