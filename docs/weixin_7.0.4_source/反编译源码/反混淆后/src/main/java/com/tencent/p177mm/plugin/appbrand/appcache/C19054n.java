package com.tencent.p177mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.os.Build.VERSION;
import android.os.StatFs;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p230g.p232b.p233a.C18440bo;
import com.tencent.p177mm.platformtools.C1952t.C1953a;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.C10091g.C10093a;
import com.tencent.p177mm.plugin.appbrand.appcache.C33098x.C33099a;
import com.tencent.p177mm.plugin.appbrand.appstorage.C42367l;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.launching.C19573h;
import com.tencent.p177mm.plugin.appbrand.task.C45694h;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;
import java.io.FileFilter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.n */
public interface C19054n extends Runnable {

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.n$a */
    public static class C10096a {
        /* renamed from: xo */
        static void m17689xo(String str) {
            AppMethodBeat.m2504i(129335);
            C1173e.deleteFile(str);
            try {
                Runtime.getRuntime().exec("rm -r " + str + "_xdir");
                AppMethodBeat.m2505o(129335);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AppBrand.PkgCleanupLogic.CleanupUtil", "rm -r %s, e = %s", str + "_xdir", e);
                AppMethodBeat.m2505o(129335);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.n$c */
    public static class C19055c {
        private static final C19056d gSC = new C19056d();

        static {
            AppMethodBeat.m2504i(129339);
            AppMethodBeat.m2505o(129339);
        }

        public static C19054n avx() {
            AppMethodBeat.m2504i(129337);
            if (C19071r.avG()) {
                C19056d c19056d = gSC;
                AppMethodBeat.m2505o(129337);
                return c19056d;
            }
            C19054n c19054n = C33074au.gUS;
            AppMethodBeat.m2505o(129337);
            return c19054n;
        }

        public static void interrupt() {
            AppMethodBeat.m2504i(129338);
            C19056d c19056d = gSC;
            try {
                C7060h.pYm.mo15419k(1007, 2, 1);
            } catch (Throwable th) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrand.PkgCleanupNewLogic", th, "cleanup interrupted report", new Object[0]);
            }
            c19056d.gSD.set(true);
            AppMethodBeat.m2505o(129338);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.n$d */
    public static class C19056d implements C19054n {
        final AtomicBoolean gSD = new AtomicBoolean();

        /* renamed from: com.tencent.mm.plugin.appbrand.appcache.n$d$2 */
        class C190572 implements C33099a {
            C190572() {
            }

            public final boolean avo() {
                AppMethodBeat.m2504i(129341);
                boolean z = C19056d.this.gSD.get();
                AppMethodBeat.m2505o(129341);
                return z;
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.appcache.n$d$1 */
        class C190581 implements FileFilter {
            C190581() {
            }

            public final boolean accept(File file) {
                AppMethodBeat.m2504i(129340);
                boolean isFile = file.isFile();
                AppMethodBeat.m2505o(129340);
                return isFile;
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.appcache.n$d$3 */
        class C190593 implements C10093a {
            C190593() {
            }

            public final boolean avo() {
                AppMethodBeat.m2504i(129342);
                boolean z = C19056d.this.gSD.get();
                AppMethodBeat.m2505o(129342);
                return z;
            }
        }

        public C19056d() {
            AppMethodBeat.m2504i(129343);
            AppMethodBeat.m2505o(129343);
        }

        private void avy() {
            AppMethodBeat.m2504i(129344);
            if (this.gSD.get()) {
                InterruptedException interruptedException = new InterruptedException();
                AppMethodBeat.m2505o(129344);
                throw interruptedException;
            }
            AppMethodBeat.m2505o(129344);
        }

        public final void run() {
            AppMethodBeat.m2504i(129345);
            if (C42340f.auV() == null) {
                C4990ab.m7412e("MicroMsg.AppBrand.PkgCleanupNewLogic", "run() entered but storage not ready");
                AppMethodBeat.m2505o(129345);
                return;
            }
            this.gSD.set(false);
            try {
                C7060h.pYm.mo15419k(1007, 1, 1);
            } catch (Throwable th) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrand.PkgCleanupNewLogic", th, "cleanup start report", new Object[0]);
            }
            try {
                long anT;
                List<C31281at> awo = C42340f.auV().awo();
                if (!C5046bo.m7548ek(awo)) {
                    avy();
                    anT = C5046bo.anT();
                    for (C31281at c31281at : awo) {
                        if (C45694h.m84416DS(c31281at.field_appId)) {
                            C4990ab.m7417i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processDebug appID(%s) is running, skip", c31281at.field_appId);
                        } else {
                            avy();
                            if (c31281at.field_endTime <= 0 || c31281at.field_endTime > anT) {
                                if (c31281at.field_debugType == 999) {
                                    C4990ab.m7417i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processDebug, debug library not exceed time range[%d %d]", Long.valueOf(c31281at.field_startTime), Long.valueOf(c31281at.field_endTime));
                                }
                            } else if (c31281at.field_debugType == 999) {
                                C10096a.m17689xo(c31281at.field_pkgPath);
                                C42340f.auV().mo60844a(c31281at);
                                C4990ab.m7417i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processDebug, (%s, %d) exceed time range[%d, %d]", c31281at.field_appId, Integer.valueOf(c31281at.field_debugType), Long.valueOf(c31281at.field_startTime), Long.valueOf(c31281at.field_endTime));
                            }
                        }
                    }
                }
                avy();
                C1953a auK = C42340f.auK();
                int avM = C19034ai.avM();
                if (avM <= 0) {
                    WxaPkgWrappingInfo bm = C19573h.m30345bm("@LibraryAppId", 0);
                    avM = bm == null ? 0 : bm.gVu;
                }
                if (avM > 0) {
                    C4990ab.m7417i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease, delete libraries record < %d", Integer.valueOf(avM));
                    C42340f.auV().mo60854av("@LibraryAppId", avM);
                }
                Cursor a = auK.mo10104a("select distinct appId from AppBrandWxaPkgManifestRecord where debugType=? and appId!=? and appId not like '%%$%%'", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, "@LibraryAppId"}, 0);
                if (!(a == null || a.isClosed())) {
                    LinkedList<String> linkedList = new LinkedList();
                    if (a.moveToFirst()) {
                        do {
                            String string = a.getString(0);
                            if (C45694h.m84416DS(string)) {
                                C4990ab.m7417i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease appID(%s) is running, skip", string);
                            } else {
                                linkedList.add(string);
                            }
                        } while (a.moveToNext());
                    }
                    a.close();
                    LinkedList linkedList2 = new LinkedList();
                    avy();
                    for (String str : linkedList) {
                        WxaAttributes e = C42340f.auO().mo21573e(str, "versionInfo");
                        if (e == null || C5046bo.isNullOrNil(e.field_versionInfo)) {
                            linkedList2.add(str);
                        } else {
                            int i;
                            avy();
                            if (e.ayL() == null) {
                                i = 0;
                            } else {
                                i = e.ayL().axy;
                            }
                            if (i > 0) {
                                int av = C42340f.auV().mo60854av(str, i);
                                if (av > 0) {
                                    C4990ab.m7417i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease, delete record(%s) < %d, count(%d)", str, Integer.valueOf(i), Integer.valueOf(av));
                                    C18440bo c18440bo = new C18440bo();
                                    c18440bo.dcY = 2;
                                    c18440bo = c18440bo.mo33703gk(str);
                                    c18440bo.dda = 0;
                                    c18440bo.ddb = (long) av;
                                    c18440bo.dcW = 1;
                                    c18440bo.ajK();
                                }
                                C42340f.auV().mo60855aw(str, i);
                            }
                        }
                    }
                    C19056d.m29627ay(linkedList2);
                }
                avz();
                avA();
                avy();
                StatFs statFs = new StatFs(C10072ap.avY());
                anT = VERSION.SDK_INT >= 18 ? statFs.getBlockCountLong() : (long) statFs.getBlockCount();
                long avw = C19060b.avw();
                double blockSizeLong = ((double) (avw / (VERSION.SDK_INT >= 18 ? statFs.getBlockSizeLong() : (long) statFs.getBlockSize()))) / ((double) anT);
                double d = (double) (((float) AppBrandGlobalSystemConfig.ayC().hgf.hgx) / 100.0f);
                boolean z = blockSizeLong > d && avw > AppBrandGlobalSystemConfig.ayC().hgf.hgw * 1048576;
                C4990ab.m7417i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processByFilesystemUsage, usedPercent(%f), maxPercent(%f), usedBytes(%d), maxMB(%d), shouldCleanup=%B", Double.valueOf(blockSizeLong), Double.valueOf(d), Long.valueOf(avw), Long.valueOf(AppBrandGlobalSystemConfig.ayC().hgf.hgw), Boolean.valueOf(z));
                if (z) {
                    C4990ab.m7417i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processByFilesystemUsage, cleanup by conditions usedPercent(%f) > maxPercent(%f)", Double.valueOf(blockSizeLong), Double.valueOf(d));
                    long blockSizeLong2 = (long) (((double) (VERSION.SDK_INT >= 18 ? statFs.getBlockSizeLong() : (long) statFs.getBlockSize())) * (((double) anT) * (blockSizeLong - d)));
                    if (blockSizeLong2 < 0) {
                        C4990ab.m7412e("MicroMsg.AppBrand.PkgCleanupNewLogic", "processByFilesystemUsage, calculated bytesToTrim is minus");
                        AppMethodBeat.m2505o(129345);
                        return;
                    }
                    avy();
                    C33098x.m54091a(blockSizeLong2, new C190572());
                    if (C19071r.avH()) {
                        C10091g.m17685a(blockSizeLong2 / 5, new C190593());
                    }
                }
                AppMethodBeat.m2505o(129345);
            } catch (InterruptedException e2) {
                C4990ab.m7417i("MicroMsg.AppBrand.PkgCleanupNewLogic", "interrupted %s", Log.getStackTraceString(e2));
                AppMethodBeat.m2505o(129345);
            } catch (Throwable th2) {
                C4990ab.m7413e("MicroMsg.AppBrand.PkgCleanupNewLogic", "process occur exception %s", th2);
                AppMethodBeat.m2505o(129345);
            }
        }

        /* renamed from: ay */
        private static void m29627ay(List<String> list) {
            AppMethodBeat.m2504i(129346);
            if (C5046bo.m7548ek(list)) {
                AppMethodBeat.m2505o(129346);
                return;
            }
            long anT = C5046bo.anT() - AppBrandGlobalSystemConfig.ayC().hgf.hgv;
            for (String str : list) {
                if (C5046bo.isNullOrNil(str) || !str.endsWith("__CODELIB__")) {
                    WxaPkgWrappingInfo bm = C19573h.m30345bm(str, 0);
                    if (bm == null) {
                        if (C19573h.m30345bm(str + '$' + "__APP__", 0) == null) {
                        }
                    } else if (TimeUnit.MILLISECONDS.toSeconds(new File(bm.gSP).lastModified()) < anT) {
                        C4990ab.m7417i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processReleaseWithoutContact, delete record(%s) < %d", str, Integer.valueOf(bm.gVu));
                        C42340f.auV().mo60854av(str, bm.gVu);
                        C42340f.auV().mo60855aw(str, bm.gVu);
                    }
                }
            }
            AppMethodBeat.m2505o(129346);
        }

        private void avz() {
            AppMethodBeat.m2504i(129347);
            avy();
            long anT = C5046bo.anT() - AppBrandGlobalSystemConfig.ayC().hgf.hgv;
            Cursor baR = ((C42346af) C42340f.m74878E(C42346af.class)).baR();
            if (baR == null || baR.isClosed()) {
                AppMethodBeat.m2505o(129347);
                return;
            }
            LinkedList<C41220ae> linkedList = new LinkedList();
            if (baR.moveToFirst()) {
                do {
                    C41220ae c41220ae = new C41220ae();
                    c41220ae.mo8995d(baR);
                    linkedList.add(c41220ae);
                } while (baR.moveToNext());
            }
            baR.close();
            avy();
            for (C41220ae c41220ae2 : linkedList) {
                if (C1173e.m2561ct(c41220ae2.field_pkgPath)) {
                    avy();
                    if (TimeUnit.MILLISECONDS.toSeconds(new File(c41220ae2.field_pkgPath).lastModified()) < anT) {
                        C4990ab.m7417i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processEncrypted, delete record(%s %d %d)", c41220ae2.field_appId, Integer.valueOf(c41220ae2.field_type), Integer.valueOf(c41220ae2.field_version));
                        ((C42346af) C42340f.m74878E(C42346af.class)).mo16760a((C4925c) c41220ae2, new String[0]);
                        C1173e.m2562cu(c41220ae2.field_pkgPath);
                    }
                }
            }
            AppMethodBeat.m2505o(129347);
        }

        private void avA() {
            AppMethodBeat.m2504i(129348);
            File file = new File(C10072ap.avY());
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles(new C190581())) {
                    if (!C42340f.auV().mo60868xH(file2.getAbsolutePath())) {
                        C10096a.m17689xo(file2.getAbsolutePath());
                    }
                }
                AppMethodBeat.m2505o(129348);
                return;
            }
            AppMethodBeat.m2505o(129348);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.n$b */
    public static class C19060b {
        public static long avw() {
            AppMethodBeat.m2504i(129336);
            long C = C42367l.m74939C(new File(C10072ap.avY()));
            AppMethodBeat.m2505o(129336);
            return C;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.n$e */
    public static class C19061e {
        public static int avB() {
            AppMethodBeat.m2504i(129349);
            HashSet hashSet = new HashSet();
            Cursor a = C42340f.auK().mo10104a("select distinct appId from AppBrandWxaPkgManifestRecord where  ( appId not like '%%$%%' or appId like " + String.format(Locale.US, "'%%$%s'", new Object[]{"__APP__"}) + " )  and  ( pkgPath is not null  and pkgPath != ''  ) ", null, 2);
            if (!(a == null || a.isClosed())) {
                if (a.moveToFirst()) {
                    do {
                        Object string = a.getString(0);
                        int indexOf = string.indexOf(36);
                        if (indexOf > 0) {
                            string = string.substring(0, indexOf);
                        }
                        hashSet.add(string);
                    } while (a.moveToNext());
                }
                a.close();
            }
            Cursor a2 = C42340f.auK().mo10104a("select distinct appId from PredownloadEncryptPkgInfo where pkgPath is not null  and pkgPath != '' ", null, 2);
            if (!(a2 == null || a2.isClosed())) {
                if (a2.moveToFirst()) {
                    hashSet.add(a2.getString(0));
                }
                do {
                } while (a2.moveToNext());
                a2.close();
            }
            int size = hashSet.size();
            AppMethodBeat.m2505o(129349);
            return size;
        }
    }
}
