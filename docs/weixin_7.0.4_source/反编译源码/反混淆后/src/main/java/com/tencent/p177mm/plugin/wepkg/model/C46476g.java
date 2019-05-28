package com.tencent.p177mm.plugin.wepkg.model;

import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.p177mm.plugin.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.p177mm.plugin.wepkg.model.C40404h.C3001512;
import com.tencent.p177mm.plugin.wepkg.model.C40404h.C4040111;
import com.tencent.p177mm.plugin.wepkg.utils.C30022d;
import com.tencent.p177mm.plugin.wepkg.utils.C35765a;
import com.tencent.p177mm.protocal.protobuf.acc;
import com.tencent.p177mm.protocal.protobuf.bkj;
import com.tencent.p177mm.protocal.protobuf.cte;
import com.tencent.p177mm.protocal.protobuf.cvm;
import com.tencent.p177mm.protocal.protobuf.cvq;
import com.tencent.p177mm.protocal.protobuf.cvt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wepkg.model.g */
public final class C46476g {

    /* renamed from: com.tencent.mm.plugin.wepkg.model.g$a */
    public interface C4700a {
        /* renamed from: U */
        void mo9823U(JSONObject jSONObject);
    }

    /* renamed from: com.tencent.mm.plugin.wepkg.model.g$b */
    static class C4701b {
        String rgC;
        List<String> uXq;
        String version;

        private C4701b() {
        }

        /* synthetic */ C4701b(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.wepkg.model.g$3 */
    static class C170073 extends C14805a {
        C170073() {
        }

        /* renamed from: a */
        public final void mo9822a(BaseWepkgProcessTask baseWepkgProcessTask) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.wepkg.model.g$2 */
    static class C357632 extends C14805a {
        C357632() {
        }

        /* renamed from: a */
        public final void mo9822a(BaseWepkgProcessTask baseWepkgProcessTask) {
        }
    }

    public static synchronized C40398f ahU(String str) {
        C40398f c40398f;
        synchronized (C46476g.class) {
            AppMethodBeat.m2504i(63554);
            C4990ab.m7410d("MicroMsg.Wepkg.WepkgManager", "loadWepkg");
            String aid = C30022d.aid(str);
            String aie = C30022d.aie(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (C5046bo.isNullOrNil(aid) || C5046bo.isNullOrNil(aie)) {
                C4990ab.m7413e("MicroMsg.Wepkg.WepkgManager", "pkgId = %s, domain = %s", aid, aie);
                c40398f = null;
                AppMethodBeat.m2505o(63554);
            } else {
                C7060h.pYm.mo8378a(859, 6, 1, false);
                WepkgVersion ahX = C40404h.ahX(aid);
                if (ahX == null) {
                    C4990ab.m7417i("MicroMsg.Wepkg.WepkgManager", "DB dont have valid record, pkgid:%s, domain:%s, version:%s:", aid, "", "");
                    C35765a.m58633b("EnterWeb", str, aid, null, 0, 0, C35765a.m58632Kl(14));
                    C7060h.pYm.mo8378a(859, 7, 1, false);
                    c40398f = null;
                    AppMethodBeat.m2505o(63554);
                } else if (!aie.equalsIgnoreCase(ahX.cSx)) {
                    C4990ab.m7417i("MicroMsg.Wepkg.WepkgManager", "the domain not match, pkgid:%s, version:%s, UrlDomain[%s] != DBDomain[%s]", aid, ahX.version, aie, ahX.cSx);
                    C35765a.m58633b("EnterWeb", str, aid, null, 0, 0, C35765a.m58632Kl(13));
                    C7060h.pYm.mo8378a(859, 8, 1, false);
                    c40398f = null;
                    AppMethodBeat.m2505o(63554);
                } else if (C5046bo.isNullOrNil(ahX.version)) {
                    C4990ab.m7417i("MicroMsg.Wepkg.WepkgManager", "this pkgid(%s) is disable form server", aid);
                    C35765a.m58633b("EnterWeb", str, aid, null, 0, 0, C35765a.m58632Kl(15));
                    C7060h.pYm.mo8378a(859, 9, 1, false);
                    c40398f = null;
                    AppMethodBeat.m2505o(63554);
                } else if (!ahX.uXM || (!ahX.uXN && ahX.uXO)) {
                    C4990ab.m7417i("MicroMsg.Wepkg.WepkgManager", "local cache disable, pkgid:%s, version:%s, bigPackageReady:%s, preloadFilesReady:%s, preloadFilesAtomic:%s", ahX.eBS, ahX.version, Boolean.valueOf(ahX.uXM), Boolean.valueOf(ahX.uXN), Boolean.valueOf(ahX.uXO));
                    C35765a.m58633b("EnterWeb", str, aid, ahX.version, 0, 0, C35765a.m58632Kl(16));
                    C7060h.pYm.mo8378a(859, 10, 1, false);
                    c40398f = null;
                    AppMethodBeat.m2505o(63554);
                } else {
                    C46475e a = C46476g.m87670a(aid, ahX.version, ahX.gSP, ahX.cvZ, ahX.uXK);
                    if (a != null || C5046bo.isNullOrNil(ahX.gSP)) {
                        Map map;
                        boolean z = ahX.uXO;
                        if (C5046bo.isNullOrNil(aid)) {
                            map = null;
                        } else {
                            map = new HashMap();
                            List<WepkgPreloadFile> aia = C40404h.aia(aid);
                            if (!C5046bo.m7548ek(aia)) {
                                Object obj = null;
                                for (WepkgPreloadFile wepkgPreloadFile : aia) {
                                    if (wepkgPreloadFile != null) {
                                        if (C5046bo.isNullOrNil(wepkgPreloadFile.filePath)) {
                                            C4990ab.m7417i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, pkgPath is null, isAtomic:%s", Boolean.valueOf(z));
                                            if (z) {
                                                C46476g.m87674hz(wepkgPreloadFile.eBS, wepkgPreloadFile.uXe);
                                                obj = 1;
                                            } else {
                                                C40404h.m69309a(aid, wepkgPreloadFile.uXe, "", null);
                                            }
                                        } else {
                                            File file = new File(wepkgPreloadFile.filePath);
                                            if (!file.exists()) {
                                                C4990ab.m7417i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, pkgPath:%s, file dont exist, isAtomic:%s", wepkgPreloadFile.filePath, Boolean.valueOf(z));
                                                if (z) {
                                                    C46476g.m87674hz(wepkgPreloadFile.eBS, wepkgPreloadFile.uXe);
                                                    obj = 1;
                                                } else {
                                                    C40404h.m69309a(aid, wepkgPreloadFile.uXe, "", null);
                                                }
                                            } else if (file.length() != ((long) wepkgPreloadFile.size)) {
                                                C4990ab.m7417i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, [server_pkgSize:%d] != [local_pkgSize:%d], isAtomic:%s", Integer.valueOf(wepkgPreloadFile.size), Long.valueOf(file.length()), Boolean.valueOf(z));
                                                if (z) {
                                                    C46476g.m87674hz(wepkgPreloadFile.eBS, wepkgPreloadFile.uXe);
                                                    file.delete();
                                                    obj = 1;
                                                } else {
                                                    C40404h.m69309a(aid, wepkgPreloadFile.uXe, "", null);
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
                            C35765a.m58633b("EnterWeb", str, aid, ahX.version, 0, 0, C35765a.m58632Kl(18));
                            C7060h.pYm.mo8378a(859, 11, 1, false);
                            c40398f = null;
                            AppMethodBeat.m2505o(63554);
                        } else {
                            c40398f = new C40398f(ahX, a, map);
                            C4990ab.m7417i("MicroMsg.Wepkg.WepkgManager", "loadWepkg time:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            C7060h.pYm.mo8378a(859, 12, 1, false);
                            AppMethodBeat.m2505o(63554);
                        }
                    } else {
                        C35765a.m58633b("EnterWeb", str, aid, ahX.version, 0, 0, C35765a.m58632Kl(17));
                        C7060h.pYm.mo8378a(859, 11, 1, false);
                        c40398f = null;
                        AppMethodBeat.m2505o(63554);
                    }
                }
            }
        }
        return c40398f;
    }

    /* renamed from: a */
    public static List<String> m87671a(bkj bkj) {
        AppMethodBeat.m2504i(63555);
        if (bkj == null || bkj.wNw == null) {
            AppMethodBeat.m2505o(63555);
            return null;
        }
        cvm cvm = bkj.wNw.xrL;
        cvt cvt = bkj.wNw.xrM;
        ArrayList arrayList = new ArrayList();
        if (!(cvm == null || cvm.xrx == null)) {
            arrayList.add(C4995ag.m7428ck(bkj.mZV + cvm.xrx.vMJ));
        }
        if (!(cvt == null || C5046bo.m7548ek(cvt.xrI))) {
            Iterator it = cvt.xrI.iterator();
            while (it.hasNext()) {
                cvq cvq = (cvq) it.next();
                if (!(cvq == null || cvq.xrx == null)) {
                    arrayList.add(C4995ag.m7428ck(bkj.mZV + cvq.xrx.vMJ));
                }
            }
        }
        AppMethodBeat.m2505o(63555);
        return arrayList;
    }

    /* renamed from: a */
    public static C46475e m87670a(String str, String str2, String str3, String str4, int i) {
        AppMethodBeat.m2504i(63556);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str3) || C5046bo.isNullOrNil(str4)) {
            C4990ab.m7416i("MicroMsg.Wepkg.WepkgManager", "pkgid or pkgPath or md5 is null, pkg invalid");
            AppMethodBeat.m2505o(63556);
            return null;
        }
        File file = new File(str3);
        if (!file.exists()) {
            C4990ab.m7417i("MicroMsg.Wepkg.WepkgManager", "readCacheWepkg, pkgPath:%s, file dont exist", str3);
            C46476g.ahV(str);
            C35765a.m58633b("PkgModified", null, str, str2, 1, 0, null);
            AppMethodBeat.m2505o(63556);
            return null;
        } else if (file.length() != ((long) i)) {
            C4990ab.m7417i("MicroMsg.Wepkg.WepkgManager", "readCacheWepkg, [server_pkgSize:%d] != [local_pkgSize:%d]", Integer.valueOf(i), Long.valueOf(file.length()));
            file.delete();
            C46476g.ahV(str);
            C35765a.m58633b("PkgModified", null, str, str2, 2, 0, null);
            AppMethodBeat.m2505o(63556);
            return null;
        } else {
            if (file.length() <= 5242880) {
                if (!str4.equalsIgnoreCase(C1178g.m2589v(file))) {
                    C4990ab.m7417i("MicroMsg.Wepkg.WepkgManager", "readCacheBigPackage, [server_md5:%s] != [local_md5:%s]", str4, C1178g.m2589v(file));
                    file.delete();
                    C46476g.ahV(str);
                    C35765a.m58633b("PkgModified", null, str, str2, 3, 0, null);
                    AppMethodBeat.m2505o(63556);
                    return null;
                }
            }
            C4990ab.m7417i("MicroMsg.Wepkg.WepkgManager", "readCacheBigPackage fileLength(%d) > checkSize(%d). dont check md5", Long.valueOf(file.length()), Long.valueOf(5242880));
            C4990ab.m7417i("MicroMsg.Wepkg.WepkgManager", "this is big package. localPath: %s", str3);
            C46475e c46475e = new C46475e(file);
            if (!c46475e.gUe || c46475e.uWV == null) {
                C30011b.dgz();
                C30011b.m47500dQ(str, 2);
                AppMethodBeat.m2505o(63556);
                return null;
            }
            AppMethodBeat.m2505o(63556);
            return c46475e;
        }
    }

    /* renamed from: a */
    public static void m87672a(final C4700a c4700a) {
        AppMethodBeat.m2504i(63557);
        final String str = C14807c.uWL;
        final File file = new File(str);
        if (!(file.exists() && file.isDirectory())) {
            c4700a.mo9823U(null);
        }
        final WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.f2968Cn = 1001;
        wepkgCrossProcessTask.hww = new Runnable() {

            /* renamed from: com.tencent.mm.plugin.wepkg.model.g$1$1 */
            class C403991 implements Runnable {
                C403991() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(63551);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("rootDir", str);
                        HashMap hashMap = new HashMap();
                        C46476g.m87673a(file, hashMap);
                        JSONArray jSONArray = new JSONArray();
                        for (Entry entry : hashMap.entrySet()) {
                            if (((List) entry.getValue()).size() != 0) {
                                JSONArray jSONArray2;
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("pkgId", entry.getKey());
                                WepkgVersion ahW = C40404h.ahW((String) entry.getKey());
                                if (ahW != null) {
                                    jSONObject2.put("controlInfo", ahW.dgC());
                                }
                                List<WepkgPreloadFile> aia = C40404h.aia((String) entry.getKey());
                                if (!C5046bo.m7548ek(aia)) {
                                    jSONArray2 = new JSONArray();
                                    for (WepkgPreloadFile dgC : aia) {
                                        jSONArray2.put(dgC.dgC());
                                    }
                                    jSONObject2.put("preloadFilesInfo", jSONArray2);
                                }
                                jSONArray2 = new JSONArray();
                                for (C4701b c4701b : (List) entry.getValue()) {
                                    JSONObject jSONObject3 = new JSONObject();
                                    jSONObject3.put("version", c4701b.version);
                                    if (!C5046bo.isNullOrNil(c4701b.rgC)) {
                                        File file = new File(c4701b.rgC);
                                        if (file.exists() && file.isFile()) {
                                            jSONObject3.put("md5", C1178g.m2589v(file));
                                            jSONObject3.put("size", file.length());
                                            cte cte = new C46475e(file).uWV;
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
                                    List<String> list = c4701b.uXq;
                                    if (!C5046bo.m7548ek(list)) {
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
                        if (c4700a != null) {
                            c4700a.mo9823U(jSONObject);
                        }
                        AppMethodBeat.m2505o(63551);
                    } catch (Exception e) {
                        if (c4700a != null) {
                            c4700a.mo9823U(null);
                        }
                        AppMethodBeat.m2505o(63551);
                    }
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(63552);
                if (wepkgCrossProcessTask.csN) {
                    C30022d.aNS().mo10302aa(new C403991());
                }
                wepkgCrossProcessTask.aBW();
                AppMethodBeat.m2505o(63552);
            }
        };
        wepkgCrossProcessTask.aBV();
        WepkgMainProcessService.m87655a(wepkgCrossProcessTask);
        AppMethodBeat.m2505o(63557);
    }

    private static void ahV(String str) {
        AppMethodBeat.m2504i(63558);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(63558);
            return;
        }
        C40404h.m69310a(str, "", false, new C357632());
        AppMethodBeat.m2505o(63558);
    }

    /* renamed from: hz */
    private static void m87674hz(final String str, String str2) {
        AppMethodBeat.m2504i(63559);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(63559);
            return;
        }
        final C170073 c170073 = new C170073();
        C40404h.m69309a(str, str2, "", new C14805a() {
            /* renamed from: a */
            public final void mo9822a(BaseWepkgProcessTask baseWepkgProcessTask) {
                AppMethodBeat.m2504i(63553);
                String str = str;
                C14805a c14805a = c170073;
                WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                wepkgCrossProcessTask.f2968Cn = AuthApiStatusCodes.AUTH_APP_CERT_ERROR;
                wepkgCrossProcessTask.uWY.eBS = str;
                wepkgCrossProcessTask.uWY.uXN = false;
                if (C4996ah.bqo()) {
                    C30022d.aNS().mo10302aa(new C4040111(wepkgCrossProcessTask, c14805a));
                    AppMethodBeat.m2505o(63553);
                    return;
                }
                wepkgCrossProcessTask.hww = new C3001512(c14805a, wepkgCrossProcessTask);
                wepkgCrossProcessTask.aBV();
                WepkgMainProcessService.m87655a(wepkgCrossProcessTask);
                AppMethodBeat.m2505o(63553);
            }
        });
        AppMethodBeat.m2505o(63559);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m87673a(File file, Map map) {
        AppMethodBeat.m2504i(63560);
        if (file == null || !file.isDirectory()) {
            AppMethodBeat.m2505o(63560);
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            AppMethodBeat.m2505o(63560);
            return false;
        }
        for (File file2 : listFiles) {
            File[] listFiles2 = file2.listFiles();
            if (!(listFiles2 == null || listFiles2.length == 0)) {
                ArrayList arrayList = new ArrayList();
                for (File file3 : listFiles2) {
                    C4701b c4701b = new C4701b();
                    c4701b.version = file3.getName();
                    String str = file3.getAbsolutePath() + File.separator + "package";
                    if (C1173e.m2561ct(str)) {
                        c4701b.rgC = str;
                    }
                    File file4 = new File(file3.getAbsolutePath() + File.separator + "preload_files");
                    if (file4.isDirectory()) {
                        File[] listFiles3 = file4.listFiles();
                        if (listFiles3 == null || listFiles3.length == 0) {
                            arrayList.add(c4701b);
                        } else {
                            ArrayList arrayList2 = new ArrayList();
                            for (File name : listFiles3) {
                                arrayList2.add(name.getName());
                            }
                            c4701b.uXq = arrayList2;
                            arrayList.add(c4701b);
                        }
                    } else {
                        arrayList.add(c4701b);
                    }
                }
                map.put(file2.getName(), arrayList);
            }
        }
        AppMethodBeat.m2505o(63560);
        return true;
    }
}
