package com.tencent.mm.pluginsdk.g.a.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.y;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import java.util.LinkedList;
import java.util.List;

final class p {
    public static void dix() {
        AppMethodBeat.i(79611);
        if (g.RN().QY()) {
            g.RN();
            if (!a.QT()) {
                if (getNetworkType() == 0) {
                    AppMethodBeat.o(79611);
                    return;
                }
                long anT = bo.anT();
                if (bo.a((Long) g.RP().Ry().get(ac.a.USERINFO_RES_DOWNLOADER_CHECK_RESUME_INTERVAL_LONG, null), 0) < anT) {
                    g.RP().Ry().set(ac.a.USERINFO_RES_DOWNLOADER_CHECK_RESUME_INTERVAL_LONG, Long.valueOf(7200 + anT));
                    ab.i("MicroMsg.PostTaskCheckResume", "doCheckResume");
                    q.a.vfA.aNS().aa(new Runnable() {
                        public final void run() {
                            List list = null;
                            AppMethodBeat.i(79610);
                            q diy = q.a.vfA;
                            int networkType = p.getNetworkType();
                            ab.i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, networkType = %d", Integer.valueOf(networkType));
                            if (networkType == 0) {
                                ab.i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, networkType is unavailable");
                                AppMethodBeat.o(79610);
                            } else if (diy.hrm) {
                                if (diy.hrm) {
                                    long anU = bo.anU();
                                    Cursor baR = diy.vfx.baR();
                                    if (baR != null) {
                                        if (baR.getCount() <= 0) {
                                            baR.close();
                                        } else {
                                            list = new LinkedList();
                                            baR.moveToFirst();
                                            do {
                                                s sVar = new s();
                                                sVar.d(baR);
                                                list.add(sVar);
                                            } while (baR.moveToNext());
                                            baR.close();
                                        }
                                    }
                                    ab.i("MicroMsg.ResDownloaderCore", "queryAll: cost = %d", Long.valueOf(bo.gb(anU)));
                                }
                                if (bo.ek(list)) {
                                    ab.i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, no record stored, skip this resumeAll-op");
                                    AppMethodBeat.o(79610);
                                    return;
                                }
                                for (s sVar2 : list) {
                                    if (!bo.isNullOrNil(sVar2.field_groupId1)) {
                                        int hashCode = sVar2.field_groupId1.hashCode();
                                        for (g gVar : r.diz()) {
                                            if (hashCode == bo.nullAsNil(gVar.awa()).hashCode()) {
                                                gVar.cYu().a(sVar2, networkType);
                                            }
                                        }
                                    }
                                }
                                AppMethodBeat.o(79610);
                            } else {
                                ab.e("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, core can not work");
                                AppMethodBeat.o(79610);
                            }
                        }
                    });
                }
                AppMethodBeat.o(79611);
                return;
            }
        }
        AppMethodBeat.o(79611);
    }

    static int getNetworkType() {
        AppMethodBeat.i(79612);
        switch (y.Me()) {
            case 0:
                AppMethodBeat.o(79612);
                return 0;
            case 1:
                AppMethodBeat.o(79612);
                return 1;
            default:
                AppMethodBeat.o(79612);
                return 2;
        }
    }
}
