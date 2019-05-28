package com.tencent.p177mm.pluginsdk.p592g.p593a.p596c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C18172y;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C14856q.C14857a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.pluginsdk.g.a.c.p */
final class C30046p {

    /* renamed from: com.tencent.mm.pluginsdk.g.a.c.p$1 */
    static class C300471 implements Runnable {
        C300471() {
        }

        public final void run() {
            List list = null;
            AppMethodBeat.m2504i(79610);
            C14856q diy = C14857a.vfA;
            int networkType = C30046p.getNetworkType();
            C4990ab.m7417i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, networkType = %d", Integer.valueOf(networkType));
            if (networkType == 0) {
                C4990ab.m7416i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, networkType is unavailable");
                AppMethodBeat.m2505o(79610);
            } else if (diy.hrm) {
                if (diy.hrm) {
                    long anU = C5046bo.anU();
                    Cursor baR = diy.vfx.baR();
                    if (baR != null) {
                        if (baR.getCount() <= 0) {
                            baR.close();
                        } else {
                            list = new LinkedList();
                            baR.moveToFirst();
                            do {
                                C44049s c44049s = new C44049s();
                                c44049s.mo8995d(baR);
                                list.add(c44049s);
                            } while (baR.moveToNext());
                            baR.close();
                        }
                    }
                    C4990ab.m7417i("MicroMsg.ResDownloaderCore", "queryAll: cost = %d", Long.valueOf(C5046bo.m7566gb(anU)));
                }
                if (C5046bo.m7548ek(list)) {
                    C4990ab.m7416i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, no record stored, skip this resumeAll-op");
                    AppMethodBeat.m2505o(79610);
                    return;
                }
                for (C44049s c44049s2 : list) {
                    if (!C5046bo.isNullOrNil(c44049s2.field_groupId1)) {
                        int hashCode = c44049s2.field_groupId1.hashCode();
                        for (C4721g c4721g : C46489r.diz()) {
                            if (hashCode == C5046bo.nullAsNil(c4721g.awa()).hashCode()) {
                                c4721g.cYu().mo9857a(c44049s2, networkType);
                            }
                        }
                    }
                }
                AppMethodBeat.m2505o(79610);
            } else {
                C4990ab.m7412e("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, core can not work");
                AppMethodBeat.m2505o(79610);
            }
        }
    }

    public static void dix() {
        AppMethodBeat.m2504i(79611);
        if (C1720g.m3534RN().mo5161QY()) {
            C1720g.m3534RN();
            if (!C1668a.m3393QT()) {
                if (C30046p.getNetworkType() == 0) {
                    AppMethodBeat.m2505o(79611);
                    return;
                }
                long anT = C5046bo.anT();
                if (C5046bo.m7514a((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_RES_DOWNLOADER_CHECK_RESUME_INTERVAL_LONG, null), 0) < anT) {
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_RES_DOWNLOADER_CHECK_RESUME_INTERVAL_LONG, Long.valueOf(7200 + anT));
                    C4990ab.m7416i("MicroMsg.PostTaskCheckResume", "doCheckResume");
                    C14857a.vfA.aNS().mo10302aa(new C300471());
                }
                AppMethodBeat.m2505o(79611);
                return;
            }
        }
        AppMethodBeat.m2505o(79611);
    }

    static int getNetworkType() {
        AppMethodBeat.m2504i(79612);
        switch (C18172y.m28611Me()) {
            case 0:
                AppMethodBeat.m2505o(79612);
                return 0;
            case 1:
                AppMethodBeat.m2505o(79612);
                return 1;
            default:
                AppMethodBeat.m2505o(79612);
                return 2;
        }
    }
}
