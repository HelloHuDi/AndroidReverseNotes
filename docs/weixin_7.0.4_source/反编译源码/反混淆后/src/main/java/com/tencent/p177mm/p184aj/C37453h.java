package com.tencent.p177mm.p184aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17881i;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.protocal.protobuf.cwa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/* renamed from: com.tencent.mm.aj.h */
public final class C37453h implements C1202f {
    Object cli = new Object();
    Set<String> fwm = new HashSet();
    public LinkedList<C37454a> fwn = new LinkedList();

    /* renamed from: com.tencent.mm.aj.h$a */
    public interface C37454a {
        String aeI();

        /* renamed from: e */
        void mo11035e(LinkedList<cwa> linkedList);
    }

    public C37453h() {
        AppMethodBeat.m2504i(11385);
        AppMethodBeat.m2505o(11385);
    }

    /* JADX WARNING: Missing block: B:17:0x0058, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(11386);
     */
    /* JADX WARNING: Missing block: B:30:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo60362a(C37454a c37454a) {
        AppMethodBeat.m2504i(11386);
        synchronized (this.cli) {
            try {
                if (!this.fwn.contains(c37454a)) {
                    Iterator it = this.fwn.iterator();
                    while (it.hasNext()) {
                        C37454a c37454a2 = (C37454a) it.next();
                        if (c37454a2 != null && C5046bo.nullAsNil(c37454a.aeI()).equals(C5046bo.nullAsNil(c37454a2.aeI()))) {
                            C4990ab.m7417i("MicroMsg.BizKFService", "the same callbacker %s, return", c37454a.aeI());
                        }
                    }
                    this.fwn.add(c37454a);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(11386);
            }
        }
    }

    /* renamed from: b */
    public final void mo60365b(C37454a c37454a) {
        AppMethodBeat.m2504i(11387);
        synchronized (this.cli) {
            try {
                if (this.fwn.contains(c37454a)) {
                    this.fwn.remove(c37454a);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(11387);
            }
        }
    }

    /* renamed from: ax */
    public final void mo60363ax(String str, String str2) {
        AppMethodBeat.m2504i(11388);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.BizKFService", "doKFGetBindList null brandname");
            AppMethodBeat.m2505o(11388);
            return;
        }
        C1720g.m3535RO().eJo.mo14541a(new C17905u(str, str2), 0);
        C4990ab.m7419v("MicroMsg.BizKFService", "doKFGetBindList %s, %d", str, Integer.valueOf(this.fwn.size()));
        AppMethodBeat.m2505o(11388);
    }

    /* renamed from: ay */
    public final void mo60364ay(String str, String str2) {
        AppMethodBeat.m2504i(11389);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            C4990ab.m7413e("MicroMsg.BizKFService", "doKFGetDefaultList error args, %s, %s", str, str2);
            AppMethodBeat.m2505o(11389);
        } else if (this.fwm.contains(str2)) {
            C4990ab.m7417i("MicroMsg.BizKFService", "doKFGetInfoList: same is running, %s", str2);
            AppMethodBeat.m2505o(11389);
        } else {
            this.fwm.add(str2);
            LinkedList linkedList = new LinkedList();
            linkedList.add(str2);
            C1207m c32239w = new C32239w(str, linkedList);
            c32239w.tag = str2;
            C1720g.m3535RO().eJo.mo14541a(c32239w, 0);
            C4990ab.m7417i("MicroMsg.BizKFService", "doKFGetInfoList %s, %s, %d", str, str2, Integer.valueOf(this.fwn.size()));
            AppMethodBeat.m2505o(11389);
        }
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(11390);
        C4990ab.m7417i("MicroMsg.BizKFService", "onSceneEnd errType = %s, errCode = %s, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (c1207m == null) {
            C4990ab.m7412e("MicroMsg.BizKFService", "scene == null");
            m63148d(null);
            AppMethodBeat.m2505o(11390);
        } else if (i == 0 && i2 == 0) {
            C4990ab.m7417i("MicroMsg.BizKFService", "scene.getType() = %s", Integer.valueOf(c1207m.getType()));
            C17881i act = C17884o.act();
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = null;
            long currentTimeMillis = System.currentTimeMillis();
            LinkedList linkedList3;
            Iterator it;
            cwa cwa;
            C17880h c17880h;
            if (c1207m.getType() == 672) {
                if (((C17906v) c1207m).aeN() == null) {
                    C4990ab.m7413e("MicroMsg.BizKFService", "resp is null, type = %s", Integer.valueOf(c1207m.getType()));
                    m63148d(null);
                    AppMethodBeat.m2505o(11390);
                    return;
                }
                linkedList3 = ((C17906v) c1207m).aeN().wBb;
                if (linkedList3 == null || linkedList3.size() <= 0) {
                    C4990ab.m7412e("MicroMsg.BizKFService", "empty workers");
                    m63148d(null);
                    AppMethodBeat.m2505o(11390);
                    return;
                }
                it = linkedList3.iterator();
                while (it.hasNext()) {
                    cwa = (cwa) it.next();
                    linkedList.add(new C46874g(cwa.xrU, ((C17906v) c1207m).fwO, cwa.mZW, cwa.wCW, 1, currentTimeMillis));
                    if (act != null) {
                        c17880h = new C17880h();
                        c17880h.username = cwa.xrU;
                        c17880h.frV = cwa.mZW;
                        c17880h.mo33385cB(false);
                        c17880h.dtR = 3;
                        act.mo33391b(c17880h);
                        C17884o.acv().mo67496qa(cwa.xrU);
                    }
                }
                linkedList2 = linkedList3;
            } else if (c1207m.getType() == 675) {
                this.fwm.remove(((C32239w) c1207m).tag);
                if (((C32239w) c1207m).aeO() == null) {
                    C4990ab.m7413e("MicroMsg.BizKFService", "KFGetInfoList resp is null, type = %s", Integer.valueOf(c1207m.getType()));
                    m63148d(null);
                    AppMethodBeat.m2505o(11390);
                    return;
                }
                linkedList3 = ((C32239w) c1207m).aeO().wBb;
                if (linkedList3 == null || linkedList3.size() <= 0) {
                    C4990ab.m7412e("MicroMsg.BizKFService", "empty workers");
                    m63148d(null);
                    AppMethodBeat.m2505o(11390);
                    return;
                }
                it = linkedList3.iterator();
                while (it.hasNext()) {
                    cwa = (cwa) it.next();
                    C4990ab.m7417i("MicroMsg.BizKFService", "onScenEnd: workers=%s, tag=%s", cwa.xrU, ((C32239w) c1207m).tag);
                    linkedList.add(new C46874g(cwa.xrU, ((C32239w) c1207m).fwO, cwa.mZW, cwa.wCW, ((C32239w) c1207m).fwP, currentTimeMillis));
                    if (act != null) {
                        c17880h = new C17880h();
                        c17880h.username = cwa.xrU;
                        c17880h.frV = cwa.mZW;
                        c17880h.mo33385cB(false);
                        c17880h.dtR = 3;
                        act.mo33391b(c17880h);
                        C17884o.acv().mo67496qa(cwa.xrU);
                    }
                }
                linkedList2 = linkedList3;
            } else if (c1207m.getType() == 674) {
                if (((C17905u) c1207m).aeM() == null) {
                    C4990ab.m7413e("MicroMsg.BizKFService", "resp is null, type = %s", Integer.valueOf(c1207m.getType()));
                    m63148d(null);
                    AppMethodBeat.m2505o(11390);
                    return;
                }
                linkedList3 = ((C17905u) c1207m).aeM().wBb;
                if (linkedList3 == null || linkedList3.size() <= 0) {
                    C4990ab.m7412e("MicroMsg.BizKFService", "empty workers");
                    m63148d(null);
                    AppMethodBeat.m2505o(11390);
                    return;
                }
                it = linkedList3.iterator();
                while (it.hasNext()) {
                    cwa = (cwa) it.next();
                    linkedList.add(new C46874g(cwa.xrU, ((C17905u) c1207m).fwO, cwa.mZW, cwa.wCW, 2, currentTimeMillis));
                    if (act != null) {
                        c17880h = new C17880h();
                        c17880h.username = cwa.xrU;
                        c17880h.frV = cwa.mZW;
                        c17880h.mo33385cB(false);
                        c17880h.dtR = 3;
                        act.mo33391b(c17880h);
                        C17884o.acv().mo67496qa(cwa.xrU);
                    }
                }
                linkedList2 = linkedList3;
            }
            C4990ab.m7417i("MicroMsg.BizKFService", "insertOrUpdateBizKFs %d", Integer.valueOf(C41747z.aeQ().mo67509f(linkedList)));
            m63148d(linkedList2);
            AppMethodBeat.m2505o(11390);
        } else {
            C4990ab.m7413e("MicroMsg.BizKFService", "scene.getType() = %s", Integer.valueOf(c1207m.getType()));
            m63148d(null);
            if (c1207m.getType() == 675) {
                this.fwm.remove(((C32239w) c1207m).tag);
            }
            AppMethodBeat.m2505o(11390);
        }
    }

    /* renamed from: d */
    private void m63148d(LinkedList<cwa> linkedList) {
        AppMethodBeat.m2504i(11391);
        synchronized (this.cli) {
            try {
                ArrayList arrayList = new ArrayList(this.fwn);
                for (int i = 0; i < arrayList.size(); i++) {
                    C37454a c37454a = (C37454a) arrayList.get(i);
                    if (c37454a != null) {
                        c37454a.mo11035e(linkedList);
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(11391);
            }
        }
    }
}
