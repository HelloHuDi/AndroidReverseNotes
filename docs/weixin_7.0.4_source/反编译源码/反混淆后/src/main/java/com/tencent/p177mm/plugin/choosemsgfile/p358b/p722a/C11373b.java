package com.tencent.p177mm.plugin.choosemsgfile.p358b.p722a;

import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b.C11376a;
import com.tencent.p177mm.vending.p639e.C5685b;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.mm.plugin.choosemsgfile.b.a.b */
public final class C11373b {
    private static final ThreadPoolExecutor iBq = new ThreadPoolExecutor(0, 1, 1, TimeUnit.SECONDS, new LinkedBlockingDeque());

    static {
        AppMethodBeat.m2504i(54254);
        AppMethodBeat.m2505o(54254);
    }

    /* renamed from: a */
    public static void m19132a(C11376a c11376a, C11372a c11372a, C5685b c5685b) {
        AppMethodBeat.m2504i(54253);
        C45124d.m82930i("MicroMsg.MsgFileMgr", "sumbit() item:%s", c11376a);
        C6824c c6824c = null;
        switch (c11376a.getType()) {
            case 1:
                c6824c = new C45807e(c11376a, c11372a, c5685b);
                break;
            case 2:
                c6824c = new C42880f(c11376a, c11372a, c5685b);
                break;
            case 3:
                c6824c = new C45808g(c11376a, c11372a, c5685b);
                break;
            case 4:
                c6824c = new C11375d(c11376a, c11372a, c5685b);
                break;
        }
        if (c6824c == null) {
            C45124d.m82927e("MicroMsg.MsgFileMgr", "downloadTask is null, return");
            c11372a.bfe();
            AppMethodBeat.m2505o(54253);
        } else if (c6824c.checkValid()) {
            if (!c6824c.bfh()) {
                iBq.submit(c6824c);
            }
            AppMethodBeat.m2505o(54253);
        } else {
            C45124d.m82927e("MicroMsg.MsgFileMgr", "downloadTask is invalid, return");
            c11372a.bfg();
            AppMethodBeat.m2505o(54253);
        }
    }
}
