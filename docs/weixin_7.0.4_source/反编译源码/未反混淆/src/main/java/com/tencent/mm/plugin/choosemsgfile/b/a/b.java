package com.tencent.mm.plugin.choosemsgfile.b.a;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.choosemsgfile.b.b.a;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class b {
    private static final ThreadPoolExecutor iBq = new ThreadPoolExecutor(0, 1, 1, TimeUnit.SECONDS, new LinkedBlockingDeque());

    static {
        AppMethodBeat.i(54254);
        AppMethodBeat.o(54254);
    }

    public static void a(a aVar, a aVar2, com.tencent.mm.vending.e.b bVar) {
        AppMethodBeat.i(54253);
        d.i("MicroMsg.MsgFileMgr", "sumbit() item:%s", aVar);
        c cVar = null;
        switch (aVar.getType()) {
            case 1:
                cVar = new e(aVar, aVar2, bVar);
                break;
            case 2:
                cVar = new f(aVar, aVar2, bVar);
                break;
            case 3:
                cVar = new g(aVar, aVar2, bVar);
                break;
            case 4:
                cVar = new d(aVar, aVar2, bVar);
                break;
        }
        if (cVar == null) {
            d.e("MicroMsg.MsgFileMgr", "downloadTask is null, return");
            aVar2.bfe();
            AppMethodBeat.o(54253);
        } else if (cVar.checkValid()) {
            if (!cVar.bfh()) {
                iBq.submit(cVar);
            }
            AppMethodBeat.o(54253);
        } else {
            d.e("MicroMsg.MsgFileMgr", "downloadTask is invalid, return");
            aVar2.bfg();
            AppMethodBeat.o(54253);
        }
    }
}
