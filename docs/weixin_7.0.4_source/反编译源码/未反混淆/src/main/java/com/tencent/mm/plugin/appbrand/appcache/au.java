package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.n.a;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

final class au {
    static final n gUS = new n() {
        private void awm() {
            AppMethodBeat.i(129426);
            File file = new File(ap.avY());
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles(new FileFilter() {
                    public final boolean accept(File file) {
                        AppMethodBeat.i(129425);
                        boolean isFile = file.isFile();
                        AppMethodBeat.o(129425);
                        return isFile;
                    }
                })) {
                    if (!f.auV().xH(file2.getAbsolutePath())) {
                        a.xo(file2.getAbsolutePath());
                    }
                }
                AppMethodBeat.o(129426);
                return;
            }
            AppMethodBeat.o(129426);
        }

        public final void run() {
            AppMethodBeat.i(129427);
            try {
                List<at> awo = f.auV().awo();
                if (!bo.ek(awo)) {
                    long anT = bo.anT();
                    for (at atVar : awo) {
                        if (atVar.field_endTime > 0 && atVar.field_endTime <= anT && atVar.field_debugType == 999) {
                            a.xo(atVar.field_pkgPath);
                            f.auV().a(atVar);
                            h.bt(atVar.field_appId, atVar.field_debugType);
                        }
                    }
                }
                if (g.RK()) {
                    ax auV = f.auV();
                    Cursor a = auV.gVj.a(String.format("select distinct %s from %s ", new Object[]{"appId", "AppBrandWxaPkgManifestRecord"}), null, 2);
                    ArrayList<String> arrayList = new ArrayList();
                    while (a.moveToNext()) {
                        arrayList.add(a.getString(0));
                    }
                    a.close();
                    List list;
                    if (bo.ek(arrayList)) {
                        list = null;
                    } else {
                        LinkedList linkedList = new LinkedList();
                        for (String xI : arrayList) {
                            list = auV.xI(xI);
                            if (!bo.ek(list)) {
                                linkedList.addAll(list);
                            }
                        }
                        Object list2 = linkedList;
                    }
                    if (!bo.ek(awo)) {
                        for (at atVar2 : awo) {
                            if (atVar2.field_appId.indexOf(36) <= 0 && !h.DS(atVar2.field_appId)) {
                                a.xo(atVar2.field_pkgPath);
                                f.auV().a(atVar2);
                                f.ava().ao(atVar2.field_appId, atVar2.field_version);
                                com.tencent.mm.g.b.a.bo boVar = new com.tencent.mm.g.b.a.bo();
                                boVar.dcY = 2;
                                com.tencent.mm.g.b.a.bo gk = boVar.gk(atVar2.field_appId);
                                gk.dda = 0;
                                gk.ddb = 1;
                                gk.dcW = 0;
                                gk.ajK();
                            }
                        }
                    }
                }
                awm();
                AppMethodBeat.o(129427);
            } catch (Exception e) {
                ab.e("MicroMsg.AppBrand.WxaPkgPruner", "prune running, exp = %s", bo.l(e));
                AppMethodBeat.o(129427);
            }
        }
    };

    static {
        AppMethodBeat.i(129428);
        AppMethodBeat.o(129428);
    }
}
