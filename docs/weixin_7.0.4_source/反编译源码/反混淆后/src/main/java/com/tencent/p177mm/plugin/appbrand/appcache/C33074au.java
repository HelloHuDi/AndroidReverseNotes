package com.tencent.p177mm.plugin.appbrand.appcache;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p232b.p233a.C18440bo;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.C19054n.C10096a;
import com.tencent.p177mm.plugin.appbrand.task.C45694h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.au */
final class C33074au {
    static final C19054n gUS = new C330751();

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.au$1 */
    static class C330751 implements C19054n {

        /* renamed from: com.tencent.mm.plugin.appbrand.appcache.au$1$1 */
        class C330731 implements FileFilter {
            C330731() {
            }

            public final boolean accept(File file) {
                AppMethodBeat.m2504i(129425);
                boolean isFile = file.isFile();
                AppMethodBeat.m2505o(129425);
                return isFile;
            }
        }

        C330751() {
        }

        private void awm() {
            AppMethodBeat.m2504i(129426);
            File file = new File(C10072ap.avY());
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles(new C330731())) {
                    if (!C42340f.auV().mo60868xH(file2.getAbsolutePath())) {
                        C10096a.m17689xo(file2.getAbsolutePath());
                    }
                }
                AppMethodBeat.m2505o(129426);
                return;
            }
            AppMethodBeat.m2505o(129426);
        }

        public final void run() {
            AppMethodBeat.m2504i(129427);
            try {
                List<C31281at> awo = C42340f.auV().awo();
                if (!C5046bo.m7548ek(awo)) {
                    long anT = C5046bo.anT();
                    for (C31281at c31281at : awo) {
                        if (c31281at.field_endTime > 0 && c31281at.field_endTime <= anT && c31281at.field_debugType == 999) {
                            C10096a.m17689xo(c31281at.field_pkgPath);
                            C42340f.auV().mo60844a(c31281at);
                            C45694h.m84422bt(c31281at.field_appId, c31281at.field_debugType);
                        }
                    }
                }
                if (C1720g.m3531RK()) {
                    C38105ax auV = C42340f.auV();
                    Cursor a = auV.gVj.mo10104a(String.format("select distinct %s from %s ", new Object[]{"appId", "AppBrandWxaPkgManifestRecord"}), null, 2);
                    ArrayList<String> arrayList = new ArrayList();
                    while (a.moveToNext()) {
                        arrayList.add(a.getString(0));
                    }
                    a.close();
                    List list;
                    if (C5046bo.m7548ek(arrayList)) {
                        list = null;
                    } else {
                        LinkedList linkedList = new LinkedList();
                        for (String xI : arrayList) {
                            list = auV.mo60869xI(xI);
                            if (!C5046bo.m7548ek(list)) {
                                linkedList.addAll(list);
                            }
                        }
                        Object list2 = linkedList;
                    }
                    if (!C5046bo.m7548ek(awo)) {
                        for (C31281at c31281at2 : awo) {
                            if (c31281at2.field_appId.indexOf(36) <= 0 && !C45694h.m84416DS(c31281at2.field_appId)) {
                                C10096a.m17689xo(c31281at2.field_pkgPath);
                                C42340f.auV().mo60844a(c31281at2);
                                C42340f.ava().mo34271ao(c31281at2.field_appId, c31281at2.field_version);
                                C18440bo c18440bo = new C18440bo();
                                c18440bo.dcY = 2;
                                C18440bo gk = c18440bo.mo33703gk(c31281at2.field_appId);
                                gk.dda = 0;
                                gk.ddb = 1;
                                gk.dcW = 0;
                                gk.ajK();
                            }
                        }
                    }
                }
                awm();
                AppMethodBeat.m2505o(129427);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AppBrand.WxaPkgPruner", "prune running, exp = %s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(129427);
            }
        }
    }

    static {
        AppMethodBeat.m2504i(129428);
        AppMethodBeat.m2505o(129428);
    }
}
