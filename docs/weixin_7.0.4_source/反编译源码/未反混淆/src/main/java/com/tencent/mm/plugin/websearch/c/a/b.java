package com.tencent.mm.plugin.websearch.c.a;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.c.a.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class b implements c {
    Map<a, a> jxd = new HashMap();
    Map<a, CountDownLatch> uce = new ConcurrentHashMap();
    private l ucf = new l() {
        public final void b(j jVar) {
            AppMethodBeat.i(91368);
            a aVar = (a) jVar.mEx.mDs;
            if (aVar == null) {
                AppMethodBeat.o(91368);
                return;
            }
            CountDownLatch countDownLatch = (CountDownLatch) b.this.uce.remove(aVar);
            switch (jVar.bFZ) {
                case -3:
                case -2:
                case -1:
                    aVar.dZ(Collections.emptyList());
                    break;
                case 0:
                    if (jVar.mEy != null && jVar.mEy.size() != 0) {
                        aVar.dZ(jVar.mEy);
                        break;
                    }
                    ab.i("FTSMatchContact", "local contact search size 0");
                    aVar.dZ(Collections.emptyList());
                    countDownLatch.countDown();
                    AppMethodBeat.o(91368);
                    return;
                    break;
            }
            countDownLatch.countDown();
            AppMethodBeat.o(91368);
        }
    };
    private l ucg = new l() {
        public final void b(j jVar) {
            AppMethodBeat.i(91369);
            a aVar = (a) jVar.mEx.mDs;
            if (aVar == null) {
                AppMethodBeat.o(91369);
                return;
            }
            a aVar2 = (a) b.this.jxd.remove(aVar);
            if (aVar2 == null) {
                AppMethodBeat.o(91369);
                return;
            }
            switch (jVar.bFZ) {
                case -3:
                case -2:
                case -1:
                    aVar.dZ(Collections.emptyList());
                    break;
                case 0:
                    if (jVar.mEy != null && jVar.mEy.size() != 0) {
                        aVar.dZ(jVar.mEy);
                        break;
                    }
                    ab.i("FTSMatchContact", "local contact search size 0");
                    aVar2.cVJ();
                    AppMethodBeat.o(91369);
                    return;
                    break;
            }
            aVar2.cVJ();
            AppMethodBeat.o(91369);
        }
    };

    public b() {
        AppMethodBeat.i(91370);
        AppMethodBeat.o(91370);
    }

    public final a adR(String str) {
        AppMethodBeat.i(91371);
        a eVar = new e(str);
        CountDownLatch countDownLatch = (CountDownLatch) this.uce.get(eVar);
        if (countDownLatch != null) {
            ab.i("FTSMatchContact", "have a running task ,wait for result, query %s,maxMatch %d", str, Integer.valueOf(BaseClientBuilder.API_PRIORITY_OTHER));
        } else if (a(eVar, this.ucf)) {
            ab.i("FTSMatchContact", "not have a running task ,start new task, query %s,maxMatch %d", str, Integer.valueOf(BaseClientBuilder.API_PRIORITY_OTHER));
            countDownLatch = new CountDownLatch(1);
            this.uce.put(eVar, countDownLatch);
        } else {
            ab.i("FTSMatchContact", "start new task fail, query %s,maxMatch %d", str, Integer.valueOf(BaseClientBuilder.API_PRIORITY_OTHER));
        }
        if (countDownLatch != null) {
            try {
                countDownLatch.await(FaceGestureDetGLThread.BRIGHTNESS_DURATION, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                ab.printErrStackTrace("FTSMatchContact", e, "", new Object[0]);
            }
        }
        this.uce.remove(eVar);
        AppMethodBeat.o(91371);
        return eVar;
    }

    public final void a(a aVar, a aVar2) {
        AppMethodBeat.i(91372);
        this.jxd.put(aVar, aVar2);
        a(aVar, this.ucg);
        AppMethodBeat.o(91372);
    }

    private static boolean a(a aVar, l lVar) {
        AppMethodBeat.i(91373);
        if (bo.isNullOrNil(aVar.query)) {
            AppMethodBeat.o(91373);
            return false;
        }
        int[] iArr = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
        int[] iArr2 = new int[]{1, 5};
        i iVar = new i();
        iVar.query = aVar.query;
        iVar.mEr = iArr;
        iVar.mEs = iArr2;
        iVar.mEt = aVar.ucd;
        iVar.mEv = com.tencent.mm.plugin.fts.a.c.b.mEV;
        iVar.mEu = new HashSet();
        iVar.mEw = lVar;
        iVar.scene = 1;
        ((n) g.M(n.class)).search(2, iVar).mDs = aVar;
        AppMethodBeat.o(91373);
        return true;
    }
}
