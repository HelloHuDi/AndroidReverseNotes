package com.tencent.p177mm.p707ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C37907bv;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p230g.p231a.C6523mp;
import com.tencent.p177mm.protocal.protobuf.axd;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.ba.p */
public final class C25855p extends C4884c<C6523mp> {
    public C25855p() {
        AppMethodBeat.m2504i(78501);
        this.xxI = C6523mp.class.getName().hashCode();
        AppMethodBeat.m2505o(78501);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(78503);
        boolean aiv = C25855p.aiv();
        AppMethodBeat.m2505o(78503);
        return aiv;
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean aiv() {
        int i;
        AppMethodBeat.m2504i(78502);
        if (C1720g.m3534RN().mo5161QY()) {
            C1720g.m3534RN();
            if (!C1668a.m3393QT()) {
                i = 1;
                if (i != 0) {
                    if (C5046bo.m7549fp(C5046bo.m7514a((Long) C1720g.m3536RP().mo5239Ry().get(68097, null), 0)) * 1000 > 3600000) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (i != 0) {
                        LinkedList linkedList = new LinkedList();
                        byte[] f = C1173e.m2571f(C1720g.m3536RP().cachePath + "eggresult.rep", 0, -1);
                        if (f == null) {
                            AppMethodBeat.m2505o(78502);
                            return false;
                        }
                        try {
                            Iterator it = ((C6338h) new C6338h().parseFrom(f)).fMm.iterator();
                            while (it.hasNext()) {
                                axd axd;
                                C9066g c9066g = (C9066g) it.next();
                                if (c9066g.fMk != 0) {
                                    axd = new axd();
                                    axd.pXC = 17;
                                    axd.pXM = c9066g.cKB + "," + c9066g.fMk;
                                    linkedList.add(axd);
                                }
                                if (c9066g.fMl != 0) {
                                    axd = new axd();
                                    axd.pXC = 18;
                                    axd.pXM = c9066g.cKB + "," + c9066g.fMl;
                                    linkedList.add(axd);
                                }
                            }
                            C1173e.deleteFile(C1720g.m3536RP().cachePath + "eggresult.rep");
                        } catch (Exception e) {
                            C4990ab.m7413e("MicroMsg.PostTaskReportEgg", "exception:%s", C5046bo.m7574l(e));
                        }
                        if (!linkedList.isEmpty()) {
                            C37907bv.m64019b(linkedList);
                            C1720g.m3536RP().mo5239Ry().set(68097, Long.valueOf(C5046bo.anT()));
                        }
                    }
                }
                C4990ab.m7410d("MicroMsg.PostTaskReportEgg", "report egg done");
                AppMethodBeat.m2505o(78502);
                return false;
            }
        }
        i = 0;
        if (i != 0) {
        }
        C4990ab.m7410d("MicroMsg.PostTaskReportEgg", "report egg done");
        AppMethodBeat.m2505o(78502);
        return false;
    }
}
