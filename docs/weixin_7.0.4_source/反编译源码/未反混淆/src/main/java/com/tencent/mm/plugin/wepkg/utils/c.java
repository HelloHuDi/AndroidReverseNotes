package com.tencent.mm.plugin.wepkg.utils;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pz;
import com.tencent.mm.g.a.vv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wepkg.b.e;
import com.tencent.mm.plugin.wepkg.b.f;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.b;
import com.tencent.mm.plugin.wepkg.model.h;
import com.tencent.mm.plugin.wepkg.model.i;
import com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class c {
    public com.tencent.mm.sdk.b.c uXW = new com.tencent.mm.sdk.b.c<pz>() {
        {
            AppMethodBeat.i(63627);
            this.xxI = pz.class.getName().hashCode();
            AppMethodBeat.o(63627);
        }

        private boolean a(pz pzVar) {
            AppMethodBeat.i(63628);
            ab.i("MicroMsg.Wepkg.WepkgListener", "sendEntranceStateListener isInFindEntrance:%b", Boolean.valueOf(pzVar.cMo.cCt));
            if (pzVar.cMo.cCt && bo.fp(bo.c((Long) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WEPKG_ENTRANCE_TRIGGER_DOWNLOAD_TIME_LONG, Long.valueOf(0)))) > 60) {
                g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_WEPKG_ENTRANCE_TRIGGER_DOWNLOAD_TIME_LONG, Long.valueOf(bo.anT()));
                c.a(c.this, 2);
            }
            AppMethodBeat.o(63628);
            return false;
        }
    };
    public final com.tencent.mm.sdk.b.c uXX = new com.tencent.mm.sdk.b.c<vv>() {
        {
            AppMethodBeat.i(63631);
            this.xxI = vv.class.getName().hashCode();
            AppMethodBeat.o(63631);
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean a(vv vvVar) {
            boolean Ni;
            AppMethodBeat.i(63632);
            if (ah.bqo()) {
                Ni = com.tencent.mm.m.g.Nv().Ni();
            } else {
                Ni = b.uXV;
            }
            ab.d("MicroMsg.Wepkg.WepkgListener", "wepkg notify event operation:%d", Integer.valueOf(vvVar.cSX.cuy));
            switch (vvVar.cSX.cuy) {
                case 0:
                    if (Ni) {
                        AppMethodBeat.o(63632);
                        break;
                    }
                    d.aNS().aa(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(63630);
                            WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                            wepkgCrossProcessTask.Cn = 2003;
                            if (ah.bqo()) {
                                wepkgCrossProcessTask.asP();
                            } else {
                                WepkgMainProcessService.b(wepkgCrossProcessTask);
                            }
                            WepkgVersion wepkgVersion = wepkgCrossProcessTask.uWY;
                            if (!(wepkgVersion == null || bo.isNullOrNil(wepkgVersion.eBS))) {
                                i.dgD().bQ(wepkgVersion.eBS, true);
                            }
                            AppMethodBeat.o(63630);
                        }
                    });
                case 1:
                    if (Ni) {
                        AppMethodBeat.o(63632);
                        break;
                    }
                    String str = vvVar.cSX.cSY;
                    int i = vvVar.cSX.cTb;
                    HashSet hashSet = new HashSet();
                    if (!bo.isNullOrNil(str)) {
                        hashSet.add(str);
                    }
                    WepkgVersionUpdater.a(hashSet, 1, i, false);
                case 2:
                    if (Ni) {
                        AppMethodBeat.o(63632);
                        break;
                    }
                    com.tencent.mm.g.a.vv.a aVar = vvVar.cSX;
                    f dgp = f.dgp();
                    String str2 = vvVar.cSX.cSY;
                    if (!dgp.hrm || bo.isNullOrNil(str2)) {
                        Ni = false;
                    } else {
                        e ahF = dgp.ahF(str2);
                        if (ahF != null && ahF.field_bigPackageReady && ahF.field_preloadFilesReady) {
                            Ni = true;
                        } else {
                            Ni = false;
                        }
                    }
                    aVar.cSZ = Ni;
                    break;
                case 3:
                    if (ah.bqo()) {
                        b.dgz().dgA();
                    }
                    AppMethodBeat.o(63632);
                    break;
                case 4:
                    if (Ni) {
                        AppMethodBeat.o(63632);
                        break;
                    }
                    WepkgVersion ahX = h.ahX(vvVar.cSX.cSY);
                    if (ahX != null) {
                        vvVar.cSX.cTa = ahX.uXP;
                        ab.i("MicroMsg.Wepkg.WepkgListener", "total download count:%s", Integer.valueOf(vvVar.cSX.cTa));
                    }
                case 5:
                    if (Ni) {
                        AppMethodBeat.o(63632);
                        break;
                    }
                    if (bo.fp(bo.c((Long) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WEPKG_FRONT_TRIGGER_DOWNLOAD_TIME_LONG, Long.valueOf(0)))) > 60) {
                        g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_WEPKG_FRONT_TRIGGER_DOWNLOAD_TIME_LONG, Long.valueOf(bo.anT()));
                        Ni = c.a(c.this, 1);
                    } else {
                        Ni = false;
                    }
                    if (!Ni && bo.fp(bo.c((Long) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WEPKG_CHECK_DOWNLOAD_TIME_LONG, Long.valueOf(0)))) > 1800) {
                        g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_WEPKG_CHECK_DOWNLOAD_TIME_LONG, Long.valueOf(bo.anT()));
                        vv vvVar2 = new vv();
                        vvVar2.cSX.cuy = 0;
                        com.tencent.mm.sdk.b.a.xxA.m(vvVar2);
                    }
                case 6:
                    if (bo.isNullOrNil(vvVar.cSX.cSY)) {
                        b dgz = b.dgz();
                        if (Looper.getMainLooper() == Looper.myLooper()) {
                            d.aNS().aa(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(63502);
                                    b.dQ(null, 0);
                                    AppMethodBeat.o(63502);
                                }
                            });
                        } else {
                            b.dQ(null, 0);
                        }
                    } else {
                        b.dgz().dP(vvVar.cSX.cSY, 2);
                    }
                    AppMethodBeat.o(63632);
                    break;
                case 7:
                    com.tencent.mm.ipcinvoker.f.a("com.tencent.mm:tools", null, a.class, null);
                    AppMethodBeat.o(63632);
                    break;
                case 8:
                    int i2 = vvVar.cSX.scene;
                    List list = vvVar.cSX.cTc;
                    if (!bo.ek(list)) {
                        switch (i2) {
                            case 0:
                                WepkgVersionUpdater.r(list, 4);
                            case 1:
                                WepkgVersionUpdater.r(list, 3);
                        }
                    }
                    AppMethodBeat.o(63632);
                    break;
            }
            AppMethodBeat.o(63632);
            return false;
        }
    };

    static class a implements com.tencent.mm.ipcinvoker.a {
        private a() {
        }

        public final void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(63635);
            com.tencent.mm.plugin.wepkg.b.dgh();
            AppMethodBeat.o(63635);
        }
    }

    public c() {
        AppMethodBeat.i(63636);
        AppMethodBeat.o(63636);
    }

    static /* synthetic */ boolean a(c cVar, int i) {
        AppMethodBeat.i(63637);
        if (!com.tencent.mm.m.g.Nv().Ni()) {
            Set set;
            ab.i("MicroMsg.Wepkg.WepkgListener", "triggerDownload downloadTriggerType:%d", Integer.valueOf(i));
            f dgp = f.dgp();
            if (!dgp.hrm) {
                set = null;
            } else if (i == -1) {
                set = null;
            } else {
                String string;
                set = new HashSet();
                Cursor rawQuery = dgp.rawQuery(String.format("select distinct %s from %s where %s=?", new Object[]{"pkgId", "WepkgVersion", "downloadTriggerType"}), String.valueOf(i));
                if (rawQuery != null) {
                    if (rawQuery.moveToFirst()) {
                        do {
                            String string2 = rawQuery.getString(0);
                            if (!bo.isNullOrNil(string2)) {
                                set.add(string2);
                            }
                        } while (rawQuery.moveToNext());
                    }
                    rawQuery.close();
                }
                HashSet hashSet = new HashSet();
                Cursor rawQuery2 = dgp.rawQuery(String.format("select distinct %s from %s where (%s=0 or %s=0) and %s=? and %s<?", new Object[]{"pkgId", "WepkgVersion", "bigPackageReady", "preloadFilesReady", "downloadTriggerType", "packageDownloadCount"}), String.valueOf(i), "1");
                if (rawQuery2 != null) {
                    if (rawQuery2.moveToFirst()) {
                        do {
                            string = rawQuery2.getString(0);
                            if (!bo.isNullOrNil(string)) {
                                hashSet.add(string);
                            }
                        } while (rawQuery2.moveToNext());
                    }
                    rawQuery2.close();
                }
                HashSet hashSet2 = new HashSet();
                Cursor rawQuery3 = dgp.rawQuery(String.format("select distinct %s from %s where %s=0 and %s<?", new Object[]{"pkgId", "WepkgPreloadFiles", "completeDownload", "fileDownloadCount"}), "1");
                if (rawQuery3 != null) {
                    if (rawQuery3.moveToFirst()) {
                        do {
                            string = rawQuery3.getString(0);
                            if (!bo.isNullOrNil(string)) {
                                hashSet2.add(string);
                            }
                        } while (rawQuery3.moveToNext());
                    }
                    rawQuery3.close();
                }
                hashSet.addAll(hashSet2);
                set.retainAll(hashSet);
                ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "trigger Predownload size:%d, List:%s", Integer.valueOf(set.size()), set.toString());
            }
            if (!(set == null || set.size() == 0)) {
                final ArrayList arrayList = new ArrayList(set);
                d.aNS().aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(63634);
                        int i = 0;
                        while (i < arrayList.size() && i < 5) {
                            i.dgD().bQ((String) arrayList.get(i), false);
                            i++;
                        }
                        AppMethodBeat.o(63634);
                    }
                });
                AppMethodBeat.o(63637);
                return true;
            }
        }
        AppMethodBeat.o(63637);
        return false;
    }
}
