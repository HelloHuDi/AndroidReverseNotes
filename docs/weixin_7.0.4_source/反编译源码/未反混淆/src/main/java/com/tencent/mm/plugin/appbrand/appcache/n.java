package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.os.Build.VERSION;
import android.os.StatFs;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.FileFilter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public interface n extends Runnable {

    public static class a {
        static void xo(String str) {
            AppMethodBeat.i(129335);
            com.tencent.mm.a.e.deleteFile(str);
            try {
                Runtime.getRuntime().exec("rm -r " + str + "_xdir");
                AppMethodBeat.o(129335);
            } catch (Exception e) {
                ab.e("MicroMsg.AppBrand.PkgCleanupLogic.CleanupUtil", "rm -r %s, e = %s", str + "_xdir", e);
                AppMethodBeat.o(129335);
            }
        }
    }

    public static class c {
        private static final d gSC = new d();

        static {
            AppMethodBeat.i(129339);
            AppMethodBeat.o(129339);
        }

        public static n avx() {
            AppMethodBeat.i(129337);
            if (r.avG()) {
                d dVar = gSC;
                AppMethodBeat.o(129337);
                return dVar;
            }
            n nVar = au.gUS;
            AppMethodBeat.o(129337);
            return nVar;
        }

        public static void interrupt() {
            AppMethodBeat.i(129338);
            d dVar = gSC;
            try {
                h.pYm.k(1007, 2, 1);
            } catch (Throwable th) {
                ab.printErrStackTrace("MicroMsg.AppBrand.PkgCleanupNewLogic", th, "cleanup interrupted report", new Object[0]);
            }
            dVar.gSD.set(true);
            AppMethodBeat.o(129338);
        }
    }

    public static class d implements n {
        final AtomicBoolean gSD = new AtomicBoolean();

        public d() {
            AppMethodBeat.i(129343);
            AppMethodBeat.o(129343);
        }

        private void avy() {
            AppMethodBeat.i(129344);
            if (this.gSD.get()) {
                InterruptedException interruptedException = new InterruptedException();
                AppMethodBeat.o(129344);
                throw interruptedException;
            }
            AppMethodBeat.o(129344);
        }

        public final void run() {
            AppMethodBeat.i(129345);
            if (f.auV() == null) {
                ab.e("MicroMsg.AppBrand.PkgCleanupNewLogic", "run() entered but storage not ready");
                AppMethodBeat.o(129345);
                return;
            }
            this.gSD.set(false);
            try {
                h.pYm.k(1007, 1, 1);
            } catch (Throwable th) {
                ab.printErrStackTrace("MicroMsg.AppBrand.PkgCleanupNewLogic", th, "cleanup start report", new Object[0]);
            }
            try {
                long anT;
                List<at> awo = f.auV().awo();
                if (!bo.ek(awo)) {
                    avy();
                    anT = bo.anT();
                    for (at atVar : awo) {
                        if (com.tencent.mm.plugin.appbrand.task.h.DS(atVar.field_appId)) {
                            ab.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processDebug appID(%s) is running, skip", atVar.field_appId);
                        } else {
                            avy();
                            if (atVar.field_endTime <= 0 || atVar.field_endTime > anT) {
                                if (atVar.field_debugType == 999) {
                                    ab.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processDebug, debug library not exceed time range[%d %d]", Long.valueOf(atVar.field_startTime), Long.valueOf(atVar.field_endTime));
                                }
                            } else if (atVar.field_debugType == 999) {
                                a.xo(atVar.field_pkgPath);
                                f.auV().a(atVar);
                                ab.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processDebug, (%s, %d) exceed time range[%d, %d]", atVar.field_appId, Integer.valueOf(atVar.field_debugType), Long.valueOf(atVar.field_startTime), Long.valueOf(atVar.field_endTime));
                            }
                        }
                    }
                }
                avy();
                com.tencent.mm.platformtools.t.a auK = f.auK();
                int avM = ai.avM();
                if (avM <= 0) {
                    WxaPkgWrappingInfo bm = com.tencent.mm.plugin.appbrand.launching.h.bm("@LibraryAppId", 0);
                    avM = bm == null ? 0 : bm.gVu;
                }
                if (avM > 0) {
                    ab.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease, delete libraries record < %d", Integer.valueOf(avM));
                    f.auV().av("@LibraryAppId", avM);
                }
                Cursor a = auK.a("select distinct appId from AppBrandWxaPkgManifestRecord where debugType=? and appId!=? and appId not like '%%$%%'", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, "@LibraryAppId"}, 0);
                if (!(a == null || a.isClosed())) {
                    LinkedList<String> linkedList = new LinkedList();
                    if (a.moveToFirst()) {
                        do {
                            String string = a.getString(0);
                            if (com.tencent.mm.plugin.appbrand.task.h.DS(string)) {
                                ab.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease appID(%s) is running, skip", string);
                            } else {
                                linkedList.add(string);
                            }
                        } while (a.moveToNext());
                    }
                    a.close();
                    LinkedList linkedList2 = new LinkedList();
                    avy();
                    for (String str : linkedList) {
                        WxaAttributes e = f.auO().e(str, "versionInfo");
                        if (e == null || bo.isNullOrNil(e.field_versionInfo)) {
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
                                int av = f.auV().av(str, i);
                                if (av > 0) {
                                    ab.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease, delete record(%s) < %d, count(%d)", str, Integer.valueOf(i), Integer.valueOf(av));
                                    com.tencent.mm.g.b.a.bo boVar = new com.tencent.mm.g.b.a.bo();
                                    boVar.dcY = 2;
                                    boVar = boVar.gk(str);
                                    boVar.dda = 0;
                                    boVar.ddb = (long) av;
                                    boVar.dcW = 1;
                                    boVar.ajK();
                                }
                                f.auV().aw(str, i);
                            }
                        }
                    }
                    ay(linkedList2);
                }
                avz();
                avA();
                avy();
                StatFs statFs = new StatFs(ap.avY());
                anT = VERSION.SDK_INT >= 18 ? statFs.getBlockCountLong() : (long) statFs.getBlockCount();
                long avw = b.avw();
                double blockSizeLong = ((double) (avw / (VERSION.SDK_INT >= 18 ? statFs.getBlockSizeLong() : (long) statFs.getBlockSize()))) / ((double) anT);
                double d = (double) (((float) AppBrandGlobalSystemConfig.ayC().hgf.hgx) / 100.0f);
                boolean z = blockSizeLong > d && avw > AppBrandGlobalSystemConfig.ayC().hgf.hgw * 1048576;
                ab.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processByFilesystemUsage, usedPercent(%f), maxPercent(%f), usedBytes(%d), maxMB(%d), shouldCleanup=%B", Double.valueOf(blockSizeLong), Double.valueOf(d), Long.valueOf(avw), Long.valueOf(AppBrandGlobalSystemConfig.ayC().hgf.hgw), Boolean.valueOf(z));
                if (z) {
                    ab.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processByFilesystemUsage, cleanup by conditions usedPercent(%f) > maxPercent(%f)", Double.valueOf(blockSizeLong), Double.valueOf(d));
                    long blockSizeLong2 = (long) (((double) (VERSION.SDK_INT >= 18 ? statFs.getBlockSizeLong() : (long) statFs.getBlockSize())) * (((double) anT) * (blockSizeLong - d)));
                    if (blockSizeLong2 < 0) {
                        ab.e("MicroMsg.AppBrand.PkgCleanupNewLogic", "processByFilesystemUsage, calculated bytesToTrim is minus");
                        AppMethodBeat.o(129345);
                        return;
                    }
                    avy();
                    x.a(blockSizeLong2, new com.tencent.mm.plugin.appbrand.appcache.x.a() {
                        public final boolean avo() {
                            AppMethodBeat.i(129341);
                            boolean z = d.this.gSD.get();
                            AppMethodBeat.o(129341);
                            return z;
                        }
                    });
                    if (r.avH()) {
                        g.a(blockSizeLong2 / 5, new com.tencent.mm.plugin.appbrand.appcache.g.a() {
                            public final boolean avo() {
                                AppMethodBeat.i(129342);
                                boolean z = d.this.gSD.get();
                                AppMethodBeat.o(129342);
                                return z;
                            }
                        });
                    }
                }
                AppMethodBeat.o(129345);
            } catch (InterruptedException e2) {
                ab.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "interrupted %s", Log.getStackTraceString(e2));
                AppMethodBeat.o(129345);
            } catch (Throwable th2) {
                ab.e("MicroMsg.AppBrand.PkgCleanupNewLogic", "process occur exception %s", th2);
                AppMethodBeat.o(129345);
            }
        }

        private static void ay(List<String> list) {
            AppMethodBeat.i(129346);
            if (bo.ek(list)) {
                AppMethodBeat.o(129346);
                return;
            }
            long anT = bo.anT() - AppBrandGlobalSystemConfig.ayC().hgf.hgv;
            for (String str : list) {
                if (bo.isNullOrNil(str) || !str.endsWith("__CODELIB__")) {
                    WxaPkgWrappingInfo bm = com.tencent.mm.plugin.appbrand.launching.h.bm(str, 0);
                    if (bm == null) {
                        if (com.tencent.mm.plugin.appbrand.launching.h.bm(str + '$' + "__APP__", 0) == null) {
                        }
                    } else if (TimeUnit.MILLISECONDS.toSeconds(new File(bm.gSP).lastModified()) < anT) {
                        ab.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processReleaseWithoutContact, delete record(%s) < %d", str, Integer.valueOf(bm.gVu));
                        f.auV().av(str, bm.gVu);
                        f.auV().aw(str, bm.gVu);
                    }
                }
            }
            AppMethodBeat.o(129346);
        }

        private void avz() {
            AppMethodBeat.i(129347);
            avy();
            long anT = bo.anT() - AppBrandGlobalSystemConfig.ayC().hgf.hgv;
            Cursor baR = ((af) f.E(af.class)).baR();
            if (baR == null || baR.isClosed()) {
                AppMethodBeat.o(129347);
                return;
            }
            LinkedList<ae> linkedList = new LinkedList();
            if (baR.moveToFirst()) {
                do {
                    ae aeVar = new ae();
                    aeVar.d(baR);
                    linkedList.add(aeVar);
                } while (baR.moveToNext());
            }
            baR.close();
            avy();
            for (ae aeVar2 : linkedList) {
                if (com.tencent.mm.a.e.ct(aeVar2.field_pkgPath)) {
                    avy();
                    if (TimeUnit.MILLISECONDS.toSeconds(new File(aeVar2.field_pkgPath).lastModified()) < anT) {
                        ab.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processEncrypted, delete record(%s %d %d)", aeVar2.field_appId, Integer.valueOf(aeVar2.field_type), Integer.valueOf(aeVar2.field_version));
                        ((af) f.E(af.class)).a((com.tencent.mm.sdk.e.c) aeVar2, new String[0]);
                        com.tencent.mm.a.e.cu(aeVar2.field_pkgPath);
                    }
                }
            }
            AppMethodBeat.o(129347);
        }

        private void avA() {
            AppMethodBeat.i(129348);
            File file = new File(ap.avY());
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles(new FileFilter() {
                    public final boolean accept(File file) {
                        AppMethodBeat.i(129340);
                        boolean isFile = file.isFile();
                        AppMethodBeat.o(129340);
                        return isFile;
                    }
                })) {
                    if (!f.auV().xH(file2.getAbsolutePath())) {
                        a.xo(file2.getAbsolutePath());
                    }
                }
                AppMethodBeat.o(129348);
                return;
            }
            AppMethodBeat.o(129348);
        }
    }

    public static class b {
        public static long avw() {
            AppMethodBeat.i(129336);
            long C = l.C(new File(ap.avY()));
            AppMethodBeat.o(129336);
            return C;
        }
    }

    public static class e {
        public static int avB() {
            AppMethodBeat.i(129349);
            HashSet hashSet = new HashSet();
            Cursor a = f.auK().a("select distinct appId from AppBrandWxaPkgManifestRecord where  ( appId not like '%%$%%' or appId like " + String.format(Locale.US, "'%%$%s'", new Object[]{"__APP__"}) + " )  and  ( pkgPath is not null  and pkgPath != ''  ) ", null, 2);
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
            Cursor a2 = f.auK().a("select distinct appId from PredownloadEncryptPkgInfo where pkgPath is not null  and pkgPath != '' ", null, 2);
            if (!(a2 == null || a2.isClosed())) {
                if (a2.moveToFirst()) {
                    hashSet.add(a2.getString(0));
                }
                do {
                } while (a2.moveToNext());
                a2.close();
            }
            int size = hashSet.size();
            AppMethodBeat.o(129349);
            return size;
        }
    }
}
