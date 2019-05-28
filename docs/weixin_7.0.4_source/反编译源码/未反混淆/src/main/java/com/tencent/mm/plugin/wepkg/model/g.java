package com.tencent.mm.plugin.wepkg.model;

import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.plugin.wepkg.model.h.AnonymousClass11;
import com.tencent.mm.plugin.wepkg.model.h.AnonymousClass12;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.bkj;
import com.tencent.mm.protocal.protobuf.cte;
import com.tencent.mm.protocal.protobuf.cvm;
import com.tencent.mm.protocal.protobuf.cvq;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g {

    public interface a {
        void U(JSONObject jSONObject);
    }

    static class b {
        String rgC;
        List<String> uXq;
        String version;

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    public static synchronized f ahU(String str) {
        f fVar;
        synchronized (g.class) {
            AppMethodBeat.i(63554);
            ab.d("MicroMsg.Wepkg.WepkgManager", "loadWepkg");
            String aid = d.aid(str);
            String aie = d.aie(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (bo.isNullOrNil(aid) || bo.isNullOrNil(aie)) {
                ab.e("MicroMsg.Wepkg.WepkgManager", "pkgId = %s, domain = %s", aid, aie);
                fVar = null;
                AppMethodBeat.o(63554);
            } else {
                h.pYm.a(859, 6, 1, false);
                WepkgVersion ahX = h.ahX(aid);
                if (ahX == null) {
                    ab.i("MicroMsg.Wepkg.WepkgManager", "DB dont have valid record, pkgid:%s, domain:%s, version:%s:", aid, "", "");
                    com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", str, aid, null, 0, 0, com.tencent.mm.plugin.wepkg.utils.a.Kl(14));
                    h.pYm.a(859, 7, 1, false);
                    fVar = null;
                    AppMethodBeat.o(63554);
                } else if (!aie.equalsIgnoreCase(ahX.cSx)) {
                    ab.i("MicroMsg.Wepkg.WepkgManager", "the domain not match, pkgid:%s, version:%s, UrlDomain[%s] != DBDomain[%s]", aid, ahX.version, aie, ahX.cSx);
                    com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", str, aid, null, 0, 0, com.tencent.mm.plugin.wepkg.utils.a.Kl(13));
                    h.pYm.a(859, 8, 1, false);
                    fVar = null;
                    AppMethodBeat.o(63554);
                } else if (bo.isNullOrNil(ahX.version)) {
                    ab.i("MicroMsg.Wepkg.WepkgManager", "this pkgid(%s) is disable form server", aid);
                    com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", str, aid, null, 0, 0, com.tencent.mm.plugin.wepkg.utils.a.Kl(15));
                    h.pYm.a(859, 9, 1, false);
                    fVar = null;
                    AppMethodBeat.o(63554);
                } else if (!ahX.uXM || (!ahX.uXN && ahX.uXO)) {
                    ab.i("MicroMsg.Wepkg.WepkgManager", "local cache disable, pkgid:%s, version:%s, bigPackageReady:%s, preloadFilesReady:%s, preloadFilesAtomic:%s", ahX.eBS, ahX.version, Boolean.valueOf(ahX.uXM), Boolean.valueOf(ahX.uXN), Boolean.valueOf(ahX.uXO));
                    com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", str, aid, ahX.version, 0, 0, com.tencent.mm.plugin.wepkg.utils.a.Kl(16));
                    h.pYm.a(859, 10, 1, false);
                    fVar = null;
                    AppMethodBeat.o(63554);
                } else {
                    e a = a(aid, ahX.version, ahX.gSP, ahX.cvZ, ahX.uXK);
                    if (a != null || bo.isNullOrNil(ahX.gSP)) {
                        Map map;
                        boolean z = ahX.uXO;
                        if (bo.isNullOrNil(aid)) {
                            map = null;
                        } else {
                            map = new HashMap();
                            List<WepkgPreloadFile> aia = h.aia(aid);
                            if (!bo.ek(aia)) {
                                Object obj = null;
                                for (WepkgPreloadFile wepkgPreloadFile : aia) {
                                    if (wepkgPreloadFile != null) {
                                        if (bo.isNullOrNil(wepkgPreloadFile.filePath)) {
                                            ab.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, pkgPath is null, isAtomic:%s", Boolean.valueOf(z));
                                            if (z) {
                                                hz(wepkgPreloadFile.eBS, wepkgPreloadFile.uXe);
                                                obj = 1;
                                            } else {
                                                h.a(aid, wepkgPreloadFile.uXe, "", null);
                                            }
                                        } else {
                                            File file = new File(wepkgPreloadFile.filePath);
                                            if (!file.exists()) {
                                                ab.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, pkgPath:%s, file dont exist, isAtomic:%s", wepkgPreloadFile.filePath, Boolean.valueOf(z));
                                                if (z) {
                                                    hz(wepkgPreloadFile.eBS, wepkgPreloadFile.uXe);
                                                    obj = 1;
                                                } else {
                                                    h.a(aid, wepkgPreloadFile.uXe, "", null);
                                                }
                                            } else if (file.length() != ((long) wepkgPreloadFile.size)) {
                                                ab.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, [server_pkgSize:%d] != [local_pkgSize:%d], isAtomic:%s", Integer.valueOf(wepkgPreloadFile.size), Long.valueOf(file.length()), Boolean.valueOf(z));
                                                if (z) {
                                                    hz(wepkgPreloadFile.eBS, wepkgPreloadFile.uXe);
                                                    file.delete();
                                                    obj = 1;
                                                } else {
                                                    h.a(aid, wepkgPreloadFile.uXe, "", null);
                                                }
                                            } else {
                                                map.put(wepkgPreloadFile.uXe, wepkgPreloadFile);
                                            }
                                        }
                                    }
                                }
                                if (obj != null) {
                                    map = null;
                                }
                            }
                        }
                        if (map == null) {
                            com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", str, aid, ahX.version, 0, 0, com.tencent.mm.plugin.wepkg.utils.a.Kl(18));
                            h.pYm.a(859, 11, 1, false);
                            fVar = null;
                            AppMethodBeat.o(63554);
                        } else {
                            fVar = new f(ahX, a, map);
                            ab.i("MicroMsg.Wepkg.WepkgManager", "loadWepkg time:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            h.pYm.a(859, 12, 1, false);
                            AppMethodBeat.o(63554);
                        }
                    } else {
                        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", str, aid, ahX.version, 0, 0, com.tencent.mm.plugin.wepkg.utils.a.Kl(17));
                        h.pYm.a(859, 11, 1, false);
                        fVar = null;
                        AppMethodBeat.o(63554);
                    }
                }
            }
        }
        return fVar;
    }

    public static List<String> a(bkj bkj) {
        AppMethodBeat.i(63555);
        if (bkj == null || bkj.wNw == null) {
            AppMethodBeat.o(63555);
            return null;
        }
        cvm cvm = bkj.wNw.xrL;
        cvt cvt = bkj.wNw.xrM;
        ArrayList arrayList = new ArrayList();
        if (!(cvm == null || cvm.xrx == null)) {
            arrayList.add(ag.ck(bkj.mZV + cvm.xrx.vMJ));
        }
        if (!(cvt == null || bo.ek(cvt.xrI))) {
            Iterator it = cvt.xrI.iterator();
            while (it.hasNext()) {
                cvq cvq = (cvq) it.next();
                if (!(cvq == null || cvq.xrx == null)) {
                    arrayList.add(ag.ck(bkj.mZV + cvq.xrx.vMJ));
                }
            }
        }
        AppMethodBeat.o(63555);
        return arrayList;
    }

    public static e a(String str, String str2, String str3, String str4, int i) {
        AppMethodBeat.i(63556);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str3) || bo.isNullOrNil(str4)) {
            ab.i("MicroMsg.Wepkg.WepkgManager", "pkgid or pkgPath or md5 is null, pkg invalid");
            AppMethodBeat.o(63556);
            return null;
        }
        File file = new File(str3);
        if (!file.exists()) {
            ab.i("MicroMsg.Wepkg.WepkgManager", "readCacheWepkg, pkgPath:%s, file dont exist", str3);
            ahV(str);
            com.tencent.mm.plugin.wepkg.utils.a.b("PkgModified", null, str, str2, 1, 0, null);
            AppMethodBeat.o(63556);
            return null;
        } else if (file.length() != ((long) i)) {
            ab.i("MicroMsg.Wepkg.WepkgManager", "readCacheWepkg, [server_pkgSize:%d] != [local_pkgSize:%d]", Integer.valueOf(i), Long.valueOf(file.length()));
            file.delete();
            ahV(str);
            com.tencent.mm.plugin.wepkg.utils.a.b("PkgModified", null, str, str2, 2, 0, null);
            AppMethodBeat.o(63556);
            return null;
        } else {
            if (file.length() <= 5242880) {
                if (!str4.equalsIgnoreCase(com.tencent.mm.a.g.v(file))) {
                    ab.i("MicroMsg.Wepkg.WepkgManager", "readCacheBigPackage, [server_md5:%s] != [local_md5:%s]", str4, com.tencent.mm.a.g.v(file));
                    file.delete();
                    ahV(str);
                    com.tencent.mm.plugin.wepkg.utils.a.b("PkgModified", null, str, str2, 3, 0, null);
                    AppMethodBeat.o(63556);
                    return null;
                }
            }
            ab.i("MicroMsg.Wepkg.WepkgManager", "readCacheBigPackage fileLength(%d) > checkSize(%d). dont check md5", Long.valueOf(file.length()), Long.valueOf(5242880));
            ab.i("MicroMsg.Wepkg.WepkgManager", "this is big package. localPath: %s", str3);
            e eVar = new e(file);
            if (!eVar.gUe || eVar.uWV == null) {
                b.dgz();
                b.dQ(str, 2);
                AppMethodBeat.o(63556);
                return null;
            }
            AppMethodBeat.o(63556);
            return eVar;
        }
    }

    public static void a(final a aVar) {
        AppMethodBeat.i(63557);
        final String str = c.uWL;
        final File file = new File(str);
        if (!(file.exists() && file.isDirectory())) {
            aVar.U(null);
        }
        final WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.Cn = 1001;
        wepkgCrossProcessTask.hww = new Runnable() {
            public final void run() {
                AppMethodBeat.i(63552);
                if (wepkgCrossProcessTask.csN) {
                    d.aNS().aa(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(63551);
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("rootDir", str);
                                HashMap hashMap = new HashMap();
                                g.a(file, hashMap);
                                JSONArray jSONArray = new JSONArray();
                                for (Entry entry : hashMap.entrySet()) {
                                    if (((List) entry.getValue()).size() != 0) {
                                        JSONArray jSONArray2;
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put("pkgId", entry.getKey());
                                        WepkgVersion ahW = h.ahW((String) entry.getKey());
                                        if (ahW != null) {
                                            jSONObject2.put("controlInfo", ahW.dgC());
                                        }
                                        List<WepkgPreloadFile> aia = h.aia((String) entry.getKey());
                                        if (!bo.ek(aia)) {
                                            jSONArray2 = new JSONArray();
                                            for (WepkgPreloadFile dgC : aia) {
                                                jSONArray2.put(dgC.dgC());
                                            }
                                            jSONObject2.put("preloadFilesInfo", jSONArray2);
                                        }
                                        jSONArray2 = new JSONArray();
                                        for (b bVar : (List) entry.getValue()) {
                                            JSONObject jSONObject3 = new JSONObject();
                                            jSONObject3.put("version", bVar.version);
                                            if (!bo.isNullOrNil(bVar.rgC)) {
                                                File file = new File(bVar.rgC);
                                                if (file.exists() && file.isFile()) {
                                                    jSONObject3.put("md5", com.tencent.mm.a.g.v(file));
                                                    jSONObject3.put("size", file.length());
                                                    cte cte = new e(file).uWV;
                                                    if (cte != null) {
                                                        jSONObject3.put("charset", cte.xql);
                                                        jSONObject3.put("desc", cte.Desc);
                                                        if (cte.xqk != null) {
                                                            JSONArray jSONArray3 = new JSONArray();
                                                            Iterator it = cte.xqk.iterator();
                                                            while (it.hasNext()) {
                                                                acc acc = (acc) it.next();
                                                                JSONObject jSONObject4 = new JSONObject();
                                                                jSONObject4.put("rid", acc.wjQ);
                                                                jSONObject4.put("offset", acc.wjR);
                                                                jSONObject4.put("size", acc.jCo);
                                                                jSONObject4.put("mimeType", acc.wjS);
                                                                jSONArray3.put(jSONObject4);
                                                            }
                                                            jSONObject3.put("resList", jSONArray3);
                                                        }
                                                    }
                                                }
                                            }
                                            List<String> list = bVar.uXq;
                                            if (!bo.ek(list)) {
                                                JSONArray jSONArray4 = new JSONArray();
                                                for (String put : list) {
                                                    jSONArray4.put(put);
                                                }
                                                jSONObject3.put("preloadFiles", jSONArray4);
                                            }
                                            jSONArray2.put(jSONObject3);
                                        }
                                        jSONObject2.put("versionList", jSONArray2);
                                        jSONArray.put(jSONObject2);
                                    }
                                }
                                jSONObject.put("pkgList", jSONArray);
                                if (aVar != null) {
                                    aVar.U(jSONObject);
                                }
                                AppMethodBeat.o(63551);
                            } catch (Exception e) {
                                if (aVar != null) {
                                    aVar.U(null);
                                }
                                AppMethodBeat.o(63551);
                            }
                        }
                    });
                }
                wepkgCrossProcessTask.aBW();
                AppMethodBeat.o(63552);
            }
        };
        wepkgCrossProcessTask.aBV();
        WepkgMainProcessService.a(wepkgCrossProcessTask);
        AppMethodBeat.o(63557);
    }

    private static void ahV(String str) {
        AppMethodBeat.i(63558);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(63558);
            return;
        }
        h.a(str, "", false, new a() {
            public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
            }
        });
        AppMethodBeat.o(63558);
    }

    private static void hz(final String str, String str2) {
        AppMethodBeat.i(63559);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            AppMethodBeat.o(63559);
            return;
        }
        final AnonymousClass3 anonymousClass3 = new a() {
            public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
            }
        };
        h.a(str, str2, "", new a() {
            public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
                AppMethodBeat.i(63553);
                String str = str;
                a aVar = anonymousClass3;
                WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                wepkgCrossProcessTask.Cn = AuthApiStatusCodes.AUTH_APP_CERT_ERROR;
                wepkgCrossProcessTask.uWY.eBS = str;
                wepkgCrossProcessTask.uWY.uXN = false;
                if (ah.bqo()) {
                    d.aNS().aa(new AnonymousClass11(wepkgCrossProcessTask, aVar));
                    AppMethodBeat.o(63553);
                    return;
                }
                wepkgCrossProcessTask.hww = new AnonymousClass12(aVar, wepkgCrossProcessTask);
                wepkgCrossProcessTask.aBV();
                WepkgMainProcessService.a(wepkgCrossProcessTask);
                AppMethodBeat.o(63553);
            }
        });
        AppMethodBeat.o(63559);
    }

    static /* synthetic */ boolean a(File file, Map map) {
        AppMethodBeat.i(63560);
        if (file == null || !file.isDirectory()) {
            AppMethodBeat.o(63560);
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            AppMethodBeat.o(63560);
            return false;
        }
        for (File file2 : listFiles) {
            File[] listFiles2 = file2.listFiles();
            if (!(listFiles2 == null || listFiles2.length == 0)) {
                ArrayList arrayList = new ArrayList();
                for (File file3 : listFiles2) {
                    b bVar = new b();
                    bVar.version = file3.getName();
                    String str = file3.getAbsolutePath() + File.separator + "package";
                    if (e.ct(str)) {
                        bVar.rgC = str;
                    }
                    File file4 = new File(file3.getAbsolutePath() + File.separator + "preload_files");
                    if (file4.isDirectory()) {
                        File[] listFiles3 = file4.listFiles();
                        if (listFiles3 == null || listFiles3.length == 0) {
                            arrayList.add(bVar);
                        } else {
                            ArrayList arrayList2 = new ArrayList();
                            for (File name : listFiles3) {
                                arrayList2.add(name.getName());
                            }
                            bVar.uXq = arrayList2;
                            arrayList.add(bVar);
                        }
                    } else {
                        arrayList.add(bVar);
                    }
                }
                map.put(file2.getName(), arrayList);
            }
        }
        AppMethodBeat.o(63560);
        return true;
    }
}
