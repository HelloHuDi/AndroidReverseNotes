package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.cwa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class h implements f {
    Object cli = new Object();
    Set<String> fwm = new HashSet();
    public LinkedList<a> fwn = new LinkedList();

    public interface a {
        String aeI();

        void e(LinkedList<cwa> linkedList);
    }

    public h() {
        AppMethodBeat.i(11385);
        AppMethodBeat.o(11385);
    }

    /* JADX WARNING: Missing block: B:17:0x0058, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(11386);
     */
    /* JADX WARNING: Missing block: B:30:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(a aVar) {
        AppMethodBeat.i(11386);
        synchronized (this.cli) {
            try {
                if (!this.fwn.contains(aVar)) {
                    Iterator it = this.fwn.iterator();
                    while (it.hasNext()) {
                        a aVar2 = (a) it.next();
                        if (aVar2 != null && bo.nullAsNil(aVar.aeI()).equals(bo.nullAsNil(aVar2.aeI()))) {
                            ab.i("MicroMsg.BizKFService", "the same callbacker %s, return", aVar.aeI());
                        }
                    }
                    this.fwn.add(aVar);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(11386);
            }
        }
    }

    public final void b(a aVar) {
        AppMethodBeat.i(11387);
        synchronized (this.cli) {
            try {
                if (this.fwn.contains(aVar)) {
                    this.fwn.remove(aVar);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(11387);
            }
        }
    }

    public final void ax(String str, String str2) {
        AppMethodBeat.i(11388);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.BizKFService", "doKFGetBindList null brandname");
            AppMethodBeat.o(11388);
            return;
        }
        g.RO().eJo.a(new u(str, str2), 0);
        ab.v("MicroMsg.BizKFService", "doKFGetBindList %s, %d", str, Integer.valueOf(this.fwn.size()));
        AppMethodBeat.o(11388);
    }

    public final void ay(String str, String str2) {
        AppMethodBeat.i(11389);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            ab.e("MicroMsg.BizKFService", "doKFGetDefaultList error args, %s, %s", str, str2);
            AppMethodBeat.o(11389);
        } else if (this.fwm.contains(str2)) {
            ab.i("MicroMsg.BizKFService", "doKFGetInfoList: same is running, %s", str2);
            AppMethodBeat.o(11389);
        } else {
            this.fwm.add(str2);
            LinkedList linkedList = new LinkedList();
            linkedList.add(str2);
            m wVar = new w(str, linkedList);
            wVar.tag = str2;
            g.RO().eJo.a(wVar, 0);
            ab.i("MicroMsg.BizKFService", "doKFGetInfoList %s, %s, %d", str, str2, Integer.valueOf(this.fwn.size()));
            AppMethodBeat.o(11389);
        }
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(11390);
        ab.i("MicroMsg.BizKFService", "onSceneEnd errType = %s, errCode = %s, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (mVar == null) {
            ab.e("MicroMsg.BizKFService", "scene == null");
            d(null);
            AppMethodBeat.o(11390);
        } else if (i == 0 && i2 == 0) {
            ab.i("MicroMsg.BizKFService", "scene.getType() = %s", Integer.valueOf(mVar.getType()));
            i act = o.act();
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = null;
            long currentTimeMillis = System.currentTimeMillis();
            LinkedList linkedList3;
            Iterator it;
            cwa cwa;
            com.tencent.mm.ah.h hVar;
            if (mVar.getType() == 672) {
                if (((v) mVar).aeN() == null) {
                    ab.e("MicroMsg.BizKFService", "resp is null, type = %s", Integer.valueOf(mVar.getType()));
                    d(null);
                    AppMethodBeat.o(11390);
                    return;
                }
                linkedList3 = ((v) mVar).aeN().wBb;
                if (linkedList3 == null || linkedList3.size() <= 0) {
                    ab.e("MicroMsg.BizKFService", "empty workers");
                    d(null);
                    AppMethodBeat.o(11390);
                    return;
                }
                it = linkedList3.iterator();
                while (it.hasNext()) {
                    cwa = (cwa) it.next();
                    linkedList.add(new g(cwa.xrU, ((v) mVar).fwO, cwa.mZW, cwa.wCW, 1, currentTimeMillis));
                    if (act != null) {
                        hVar = new com.tencent.mm.ah.h();
                        hVar.username = cwa.xrU;
                        hVar.frV = cwa.mZW;
                        hVar.cB(false);
                        hVar.dtR = 3;
                        act.b(hVar);
                        o.acv().qa(cwa.xrU);
                    }
                }
                linkedList2 = linkedList3;
            } else if (mVar.getType() == 675) {
                this.fwm.remove(((w) mVar).tag);
                if (((w) mVar).aeO() == null) {
                    ab.e("MicroMsg.BizKFService", "KFGetInfoList resp is null, type = %s", Integer.valueOf(mVar.getType()));
                    d(null);
                    AppMethodBeat.o(11390);
                    return;
                }
                linkedList3 = ((w) mVar).aeO().wBb;
                if (linkedList3 == null || linkedList3.size() <= 0) {
                    ab.e("MicroMsg.BizKFService", "empty workers");
                    d(null);
                    AppMethodBeat.o(11390);
                    return;
                }
                it = linkedList3.iterator();
                while (it.hasNext()) {
                    cwa = (cwa) it.next();
                    ab.i("MicroMsg.BizKFService", "onScenEnd: workers=%s, tag=%s", cwa.xrU, ((w) mVar).tag);
                    linkedList.add(new g(cwa.xrU, ((w) mVar).fwO, cwa.mZW, cwa.wCW, ((w) mVar).fwP, currentTimeMillis));
                    if (act != null) {
                        hVar = new com.tencent.mm.ah.h();
                        hVar.username = cwa.xrU;
                        hVar.frV = cwa.mZW;
                        hVar.cB(false);
                        hVar.dtR = 3;
                        act.b(hVar);
                        o.acv().qa(cwa.xrU);
                    }
                }
                linkedList2 = linkedList3;
            } else if (mVar.getType() == 674) {
                if (((u) mVar).aeM() == null) {
                    ab.e("MicroMsg.BizKFService", "resp is null, type = %s", Integer.valueOf(mVar.getType()));
                    d(null);
                    AppMethodBeat.o(11390);
                    return;
                }
                linkedList3 = ((u) mVar).aeM().wBb;
                if (linkedList3 == null || linkedList3.size() <= 0) {
                    ab.e("MicroMsg.BizKFService", "empty workers");
                    d(null);
                    AppMethodBeat.o(11390);
                    return;
                }
                it = linkedList3.iterator();
                while (it.hasNext()) {
                    cwa = (cwa) it.next();
                    linkedList.add(new g(cwa.xrU, ((u) mVar).fwO, cwa.mZW, cwa.wCW, 2, currentTimeMillis));
                    if (act != null) {
                        hVar = new com.tencent.mm.ah.h();
                        hVar.username = cwa.xrU;
                        hVar.frV = cwa.mZW;
                        hVar.cB(false);
                        hVar.dtR = 3;
                        act.b(hVar);
                        o.acv().qa(cwa.xrU);
                    }
                }
                linkedList2 = linkedList3;
            }
            ab.i("MicroMsg.BizKFService", "insertOrUpdateBizKFs %d", Integer.valueOf(z.aeQ().f(linkedList)));
            d(linkedList2);
            AppMethodBeat.o(11390);
        } else {
            ab.e("MicroMsg.BizKFService", "scene.getType() = %s", Integer.valueOf(mVar.getType()));
            d(null);
            if (mVar.getType() == 675) {
                this.fwm.remove(((w) mVar).tag);
            }
            AppMethodBeat.o(11390);
        }
    }

    private void d(LinkedList<cwa> linkedList) {
        AppMethodBeat.i(11391);
        synchronized (this.cli) {
            try {
                ArrayList arrayList = new ArrayList(this.fwn);
                for (int i = 0; i < arrayList.size(); i++) {
                    a aVar = (a) arrayList.get(i);
                    if (aVar != null) {
                        aVar.e(linkedList);
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(11391);
            }
        }
    }
}
