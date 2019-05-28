package com.tencent.p177mm.plugin.wepkg.utils;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C9447pz;
import com.tencent.p177mm.p230g.p231a.C9497vv;
import com.tencent.p177mm.p230g.p231a.C9497vv.C9498a;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.wepkg.C40393b;
import com.tencent.p177mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.p177mm.plugin.wepkg.model.C30011b;
import com.tencent.p177mm.plugin.wepkg.model.C30011b.C300132;
import com.tencent.p177mm.plugin.wepkg.model.C30020i;
import com.tencent.p177mm.plugin.wepkg.model.C40404h;
import com.tencent.p177mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.p177mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.p177mm.plugin.wepkg.p1076b.C41334e;
import com.tencent.p177mm.plugin.wepkg.p1076b.C44021f;
import com.tencent.p177mm.plugin.wepkg.version.WepkgVersionUpdater;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.wepkg.utils.c */
public final class C35769c {
    public C4884c uXW = new C357671();
    public final C4884c uXX = new C357682();

    /* renamed from: com.tencent.mm.plugin.wepkg.utils.c$a */
    static class C14811a implements C37866a {
        private C14811a() {
        }

        /* renamed from: a */
        public final void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(63635);
            C40393b.dgh();
            AppMethodBeat.m2505o(63635);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wepkg.utils.c$1 */
    class C357671 extends C4884c<C9447pz> {
        C357671() {
            AppMethodBeat.m2504i(63627);
            this.xxI = C9447pz.class.getName().hashCode();
            AppMethodBeat.m2505o(63627);
        }

        /* renamed from: a */
        private boolean m58636a(C9447pz c9447pz) {
            AppMethodBeat.m2504i(63628);
            C4990ab.m7417i("MicroMsg.Wepkg.WepkgListener", "sendEntranceStateListener isInFindEntrance:%b", Boolean.valueOf(c9447pz.cMo.cCt));
            if (c9447pz.cMo.cCt && C5046bo.m7549fp(C5046bo.m7534c((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WEPKG_ENTRANCE_TRIGGER_DOWNLOAD_TIME_LONG, Long.valueOf(0)))) > 60) {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WEPKG_ENTRANCE_TRIGGER_DOWNLOAD_TIME_LONG, Long.valueOf(C5046bo.anT()));
                C35769c.m58640a(C35769c.this, 2);
            }
            AppMethodBeat.m2505o(63628);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wepkg.utils.c$2 */
    class C357682 extends C4884c<C9497vv> {

        /* renamed from: com.tencent.mm.plugin.wepkg.utils.c$2$1 */
        class C47021 implements Runnable {
            C47021() {
            }

            public final void run() {
                AppMethodBeat.m2504i(63630);
                WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                wepkgCrossProcessTask.f2968Cn = 2003;
                if (C4996ah.bqo()) {
                    wepkgCrossProcessTask.asP();
                } else {
                    WepkgMainProcessService.m87660b(wepkgCrossProcessTask);
                }
                WepkgVersion wepkgVersion = wepkgCrossProcessTask.uWY;
                if (!(wepkgVersion == null || C5046bo.isNullOrNil(wepkgVersion.eBS))) {
                    C30020i.dgD().mo48257bQ(wepkgVersion.eBS, true);
                }
                AppMethodBeat.m2505o(63630);
            }
        }

        C357682() {
            AppMethodBeat.m2504i(63631);
            this.xxI = C9497vv.class.getName().hashCode();
            AppMethodBeat.m2505o(63631);
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        private boolean m58638a(C9497vv c9497vv) {
            boolean Ni;
            AppMethodBeat.m2504i(63632);
            if (C4996ah.bqo()) {
                Ni = C26373g.m41965Nv().mo5296Ni();
            } else {
                Ni = C35766b.uXV;
            }
            C4990ab.m7411d("MicroMsg.Wepkg.WepkgListener", "wepkg notify event operation:%d", Integer.valueOf(c9497vv.cSX.cuy));
            switch (c9497vv.cSX.cuy) {
                case 0:
                    if (Ni) {
                        AppMethodBeat.m2505o(63632);
                        break;
                    }
                    C30022d.aNS().mo10302aa(new C47021());
                case 1:
                    if (Ni) {
                        AppMethodBeat.m2505o(63632);
                        break;
                    }
                    String str = c9497vv.cSX.cSY;
                    int i = c9497vv.cSX.cTb;
                    HashSet hashSet = new HashSet();
                    if (!C5046bo.isNullOrNil(str)) {
                        hashSet.add(str);
                    }
                    WepkgVersionUpdater.m23051a(hashSet, 1, i, false);
                case 2:
                    if (Ni) {
                        AppMethodBeat.m2505o(63632);
                        break;
                    }
                    C9498a c9498a = c9497vv.cSX;
                    C44021f dgp = C44021f.dgp();
                    String str2 = c9497vv.cSX.cSY;
                    if (!dgp.hrm || C5046bo.isNullOrNil(str2)) {
                        Ni = false;
                    } else {
                        C41334e ahF = dgp.ahF(str2);
                        if (ahF != null && ahF.field_bigPackageReady && ahF.field_preloadFilesReady) {
                            Ni = true;
                        } else {
                            Ni = false;
                        }
                    }
                    c9498a.cSZ = Ni;
                    break;
                case 3:
                    if (C4996ah.bqo()) {
                        C30011b.dgz().dgA();
                    }
                    AppMethodBeat.m2505o(63632);
                    break;
                case 4:
                    if (Ni) {
                        AppMethodBeat.m2505o(63632);
                        break;
                    }
                    WepkgVersion ahX = C40404h.ahX(c9497vv.cSX.cSY);
                    if (ahX != null) {
                        c9497vv.cSX.cTa = ahX.uXP;
                        C4990ab.m7417i("MicroMsg.Wepkg.WepkgListener", "total download count:%s", Integer.valueOf(c9497vv.cSX.cTa));
                    }
                case 5:
                    if (Ni) {
                        AppMethodBeat.m2505o(63632);
                        break;
                    }
                    if (C5046bo.m7549fp(C5046bo.m7534c((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WEPKG_FRONT_TRIGGER_DOWNLOAD_TIME_LONG, Long.valueOf(0)))) > 60) {
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WEPKG_FRONT_TRIGGER_DOWNLOAD_TIME_LONG, Long.valueOf(C5046bo.anT()));
                        Ni = C35769c.m58640a(C35769c.this, 1);
                    } else {
                        Ni = false;
                    }
                    if (!Ni && C5046bo.m7549fp(C5046bo.m7534c((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WEPKG_CHECK_DOWNLOAD_TIME_LONG, Long.valueOf(0)))) > 1800) {
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WEPKG_CHECK_DOWNLOAD_TIME_LONG, Long.valueOf(C5046bo.anT()));
                        C9497vv c9497vv2 = new C9497vv();
                        c9497vv2.cSX.cuy = 0;
                        C4879a.xxA.mo10055m(c9497vv2);
                    }
                case 6:
                    if (C5046bo.isNullOrNil(c9497vv.cSX.cSY)) {
                        C30011b dgz = C30011b.dgz();
                        if (Looper.getMainLooper() == Looper.myLooper()) {
                            C30022d.aNS().mo10302aa(new C300132());
                        } else {
                            C30011b.m47500dQ(null, 0);
                        }
                    } else {
                        C30011b.dgz().mo48248dP(c9497vv.cSX.cSY, 2);
                    }
                    AppMethodBeat.m2505o(63632);
                    break;
                case 7:
                    C9549f.m17012a("com.tencent.mm:tools", null, C14811a.class, null);
                    AppMethodBeat.m2505o(63632);
                    break;
                case 8:
                    int i2 = c9497vv.cSX.scene;
                    List list = c9497vv.cSX.cTc;
                    if (!C5046bo.m7548ek(list)) {
                        switch (i2) {
                            case 0:
                                WepkgVersionUpdater.m23054r(list, 4);
                            case 1:
                                WepkgVersionUpdater.m23054r(list, 3);
                        }
                    }
                    AppMethodBeat.m2505o(63632);
                    break;
            }
            AppMethodBeat.m2505o(63632);
            return false;
        }
    }

    public C35769c() {
        AppMethodBeat.m2504i(63636);
        AppMethodBeat.m2505o(63636);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m58640a(C35769c c35769c, int i) {
        AppMethodBeat.m2504i(63637);
        if (!C26373g.m41965Nv().mo5296Ni()) {
            Set set;
            C4990ab.m7417i("MicroMsg.Wepkg.WepkgListener", "triggerDownload downloadTriggerType:%d", Integer.valueOf(i));
            C44021f dgp = C44021f.dgp();
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
                            if (!C5046bo.isNullOrNil(string2)) {
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
                            if (!C5046bo.isNullOrNil(string)) {
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
                            if (!C5046bo.isNullOrNil(string)) {
                                hashSet2.add(string);
                            }
                        } while (rawQuery3.moveToNext());
                    }
                    rawQuery3.close();
                }
                hashSet.addAll(hashSet2);
                set.retainAll(hashSet);
                C4990ab.m7417i("MicroMsg.Wepkg.WepkgVersionStorage", "trigger Predownload size:%d, List:%s", Integer.valueOf(set.size()), set.toString());
            }
            if (!(set == null || set.size() == 0)) {
                final ArrayList arrayList = new ArrayList(set);
                C30022d.aNS().mo10302aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(63634);
                        int i = 0;
                        while (i < arrayList.size() && i < 5) {
                            C30020i.dgD().mo48257bQ((String) arrayList.get(i), false);
                            i++;
                        }
                        AppMethodBeat.m2505o(63634);
                    }
                });
                AppMethodBeat.m2505o(63637);
                return true;
            }
        }
        AppMethodBeat.m2505o(63637);
        return false;
    }
}
