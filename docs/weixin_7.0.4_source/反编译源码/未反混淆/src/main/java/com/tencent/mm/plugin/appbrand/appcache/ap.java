package com.tencent.mm.plugin.appbrand.appcache;

import android.net.Uri;
import android.os.StatFs;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.compatible.e.y;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.appbrand.r.j;
import com.tencent.mm.pluginsdk.g.a.c.k;
import com.tencent.mm.pluginsdk.g.a.c.l;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.pluginsdk.g.a.c.n;
import com.tencent.mm.pluginsdk.g.a.c.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLException;

public final class ap {
    final b gUn = new b();

    static final class a {

        static abstract class a implements com.tencent.mm.i.g.a {
            private final c gUu;

            public abstract void b(m mVar);

            a(c cVar) {
                this.gUu = cVar;
            }

            public final int a(String str, int i, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
                if (i != 0) {
                    b(new m(this.gUu, new SSLException(String.format(Locale.US, "CdnHttpsAddTaskFailed$%s$%d", new Object[]{this.gUu.dib(), Integer.valueOf(i)})), 3));
                    ab.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "urlKey %s, startRet %d", this.gUu.dib(), Integer.valueOf(i));
                    return 0;
                } else if (cVar != null) {
                    com.tencent.mm.pluginsdk.g.a.c.c cVar2 = this.gUu.vft;
                    if (cVar2 != null) {
                        cVar2.a(this.gUu.dib(), new WxaPkgLoadProgress((int) ((((float) cVar.field_finishedLength) / ((float) cVar.field_toltalLength)) * 100.0f), (long) cVar.field_finishedLength, (long) cVar.field_toltalLength));
                    }
                    return 0;
                } else {
                    if (dVar != null) {
                        ab.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "urlKey %s, retCode %d, responseHeader %s", this.gUu.dib(), Integer.valueOf(dVar.field_retCode), dVar.field_httpResponseHeader);
                        if (dVar.field_retCode != 0) {
                            m mVar;
                            if (dVar.field_fileLength <= 0 || this.gUu.gh((long) dVar.field_fileLength)) {
                                mVar = new m(this.gUu, new SSLException(String.format(Locale.US, "CdnHttpsDownloadFailed$%s$%d", new Object[]{this.gUu.dib(), Integer.valueOf(dVar.field_retCode)})), dVar.field_httpStatusCode, 3);
                            } else {
                                mVar = new m(this.gUu, new com.tencent.mm.pluginsdk.g.a.b.a(), dVar.field_httpStatusCode, 3);
                            }
                            b(mVar);
                        } else {
                            b(new m(this.gUu, (long) dVar.field_fileLength, null));
                            int asZ = (int) e.asZ(this.gUu.avZ().getFilePath());
                            if (com.tencent.mm.model.ao.a.flv != null) {
                                com.tencent.mm.model.ao.a.flv.cm(asZ, 0);
                            }
                        }
                    }
                    return 0;
                }
            }

            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            public final byte[] l(String str, byte[] bArr) {
                return new byte[0];
            }
        }

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final m a(c cVar) {
            AppMethodBeat.i(59485);
            String dib = cVar.dib();
            ab.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "downloadUsingCDN, url %s", cVar.getURL());
            try {
                com.tencent.mm.sdk.platformtools.ap apVar;
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                final j jVar = new j();
                final com.tencent.mm.plugin.appbrand.appcache.a.a avZ = cVar.avZ();
                final String str = avZ.vdC;
                final com.tencent.mm.plugin.appbrand.appcache.z.a aVar = cVar.gUy;
                if (cVar.avZ().gVz) {
                    apVar = new com.tencent.mm.sdk.platformtools.ap(com.tencent.mm.ce.a.dvQ().getLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
                        public final boolean BI() {
                            AppMethodBeat.i(59483);
                            f.afx().rO(str);
                            aVar.avq();
                            e.deleteFile(avZ.getFilePath());
                            jVar.value = null;
                            countDownLatch.countDown();
                            AppMethodBeat.o(59483);
                            return false;
                        }
                    }, false);
                } else {
                    apVar = null;
                }
                final j jVar2 = jVar;
                final CountDownLatch countDownLatch2 = countDownLatch;
                AnonymousClass2 anonymousClass2 = new a(cVar) {
                    /* Access modifiers changed, original: final */
                    public final void b(m mVar) {
                        AppMethodBeat.i(59484);
                        if (apVar != null) {
                            apVar.stopTimer();
                        }
                        jVar2.value = mVar;
                        countDownLatch2.countDown();
                        AppMethodBeat.o(59484);
                    }
                };
                g gVar = new g();
                gVar.field_mediaId = str;
                gVar.field_fullpath = avZ.getFilePath();
                gVar.egm = avZ.url;
                gVar.cRY = false;
                gVar.egl = anonymousClass2;
                gVar.egn = (int) TimeUnit.MILLISECONDS.toSeconds((long) avZ.getConnectTimeout());
                gVar.ego = (int) TimeUnit.MILLISECONDS.toSeconds((long) avZ.getReadTimeout());
                gVar.field_fileType = com.tencent.mm.i.a.efP;
                if (avZ instanceof l) {
                    gVar.egq = false;
                }
                String host = Uri.parse(gVar.egm).getHost();
                if (!bo.isNullOrNil(host)) {
                    ArrayList arrayList = new ArrayList();
                    try {
                        com.tencent.mm.kernel.g.RO().eJo.ftA.getHostByName(host, arrayList);
                        gVar.egp = new String[arrayList.size()];
                        arrayList.toArray(gVar.egp);
                    } catch (Exception e) {
                        ab.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https getHostByName e = %s", e);
                    }
                }
                f.afx().b(gVar, -1);
                if (apVar != null) {
                    long readTimeout = (long) avZ.getReadTimeout();
                    apVar.ae(readTimeout, readTimeout);
                }
                try {
                    countDownLatch.await();
                    m mVar = (m) jVar.value;
                    AppMethodBeat.o(59485);
                    return mVar;
                } catch (Exception e2) {
                    ab.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https perform, urlKey %s semaphore await e = %s", dib, e2);
                    AppMethodBeat.o(59485);
                    return null;
                }
            } catch (Exception e22) {
                ab.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https perform urlKey %s exp %s", dib, e22);
                AppMethodBeat.o(59485);
                return null;
            }
        }
    }

    final class b extends n {
        b() {
            super(new u("WxaPkgDownloaderPool", "WxaPkgDownloaderThread"), new d());
            AppMethodBeat.i(59486);
            AppMethodBeat.o(59486);
        }

        public final void shutdown() {
            AppMethodBeat.i(59487);
            super.shutdown();
            ((d) this.vfq).gUz.getLooper().quit();
            AppMethodBeat.o(59487);
        }

        public final com.tencent.mm.pluginsdk.g.a.c.f.d a(l lVar) {
            AppMethodBeat.i(59488);
            c cVar = new c((com.tencent.mm.plugin.appbrand.appcache.a.a) lVar);
            cVar.vft = this.vfq;
            AppMethodBeat.o(59488);
            return cVar;
        }

        public final int b(l lVar) {
            AppMethodBeat.i(59489);
            int b = super.b(lVar);
            if (b == 1) {
                super.b(lVar);
                AppMethodBeat.o(59489);
                return 2;
            }
            AppMethodBeat.o(59489);
            return b;
        }
    }

    final class d implements com.tencent.mm.pluginsdk.g.a.c.c {
        final ak gUz = new ak(new al("WxaPkgDownloadPerformerEventDispatchThread").oAl.getLooper());

        d() {
            AppMethodBeat.i(59500);
            AppMethodBeat.o(59500);
        }

        public final void a(final com.tencent.mm.pluginsdk.g.a.c.e eVar, final m mVar) {
            AppMethodBeat.i(59501);
            this.gUz.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(59499);
                    switch (mVar.status) {
                        case 2:
                            d.c(eVar, mVar);
                            AppMethodBeat.o(59499);
                            return;
                        case 3:
                            d.b(eVar, mVar);
                            break;
                        case 4:
                            d.d(eVar, mVar);
                            AppMethodBeat.o(59499);
                            return;
                    }
                    AppMethodBeat.o(59499);
                }
            });
            AppMethodBeat.o(59501);
        }

        public final void u(String str, int i, int i2) {
        }

        public final void w(String str, long j) {
        }

        public static void b(com.tencent.mm.pluginsdk.g.a.c.e eVar, m mVar) {
            AppMethodBeat.i(59502);
            a((c) eVar, mVar);
            AppMethodBeat.o(59502);
        }

        public static void c(com.tencent.mm.pluginsdk.g.a.c.e eVar, m mVar) {
            AppMethodBeat.i(59503);
            com.tencent.mm.plugin.appbrand.appcache.a.a avZ = ((c) eVar).avZ();
            com.tencent.mm.plugin.appbrand.appcache.z.a aVar;
            ax xF;
            at a;
            if (avZ instanceof al) {
                al alVar = (al) avZ;
                aVar = ((c) eVar).gUy;
                xF = ((com.tencent.mm.plugin.appbrand.a.d) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.a.d.class)).xF();
                if (xF == null) {
                    az.a(alVar.vdC, alVar.appId, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.ENV_ERR, null);
                    AppMethodBeat.o(59503);
                    return;
                }
                String str = alVar.appId;
                int i = alVar.gTP;
                int i2 = alVar.gTQ;
                String avR = alVar.avR();
                at a2 = xF.a(str, i, 0, "pkgPath");
                at a3 = xF.a(str, i2, 0, "versionMd5");
                if (a2 == null || a3 == null) {
                    az.a(alVar.vdC, alVar.appId, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.ENV_ERR, null);
                    AppMethodBeat.o(59503);
                    return;
                }
                aVar.avs();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                int A = p.A(a2.field_pkgPath, avR, alVar.getFilePath());
                elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime;
                ab.i("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "applyPkgPatch, appId[%s], oldPath[%s], newPath[%s], patchPath[%s], cost %d, ret %d", alVar.appId, a2.field_pkgPath, avR, alVar.getFilePath(), Long.valueOf(elapsedRealtime), Integer.valueOf(A));
                aVar.nq(A);
                if (A == 0) {
                    az.a(alVar.vdC, alVar.appId, avR, i2, 0, aVar);
                    AppMethodBeat.o(59503);
                    return;
                }
                e.deleteFile(avR);
                a = xF.a(alVar.appId, alVar.gTQ, 0, "downloadURL");
                if (a == null) {
                    az.a(alVar.vdC, alVar.appId, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.ENV_ERR, null);
                    AppMethodBeat.o(59503);
                    return;
                }
                az.xJ(alVar.vdC);
                az.b(alVar.appId, 0, alVar.gTQ, a.field_downloadURL, alVar.gTR);
                AppMethodBeat.o(59503);
            } else if (avZ instanceof bc) {
                bc bcVar = (bc) avZ;
                aVar = ((c) eVar).gUy;
                xF = ((com.tencent.mm.plugin.appbrand.a.d) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.a.d.class)).xF();
                if (xF == null) {
                    az.a(bcVar.vdC, bcVar.appId, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.ENV_ERR, null);
                    AppMethodBeat.o(59503);
                    return;
                }
                aVar.avv();
                boolean a4 = bd.a(bcVar);
                aVar.dA(a4);
                ab.i("MicroMsg.AppBrand.ZstdLogic", "processZstd suc:%b", Boolean.valueOf(a4));
                if (a4) {
                    az.a(bcVar.vdC, bcVar.appId, bcVar.aws(), bcVar.gVu, bcVar.cBc, aVar);
                    AppMethodBeat.o(59503);
                    return;
                }
                e.deleteFile(bcVar.aws());
                a = xF.a(bcVar.appId, bcVar.gVu, bcVar.cBc, "downloadURL");
                if (a == null) {
                    az.a(bcVar.vdC, bcVar.appId, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.ENV_ERR, null);
                    AppMethodBeat.o(59503);
                    return;
                }
                az.xJ(bcVar.vdC);
                az.b(bcVar.appId, bcVar.cBc, bcVar.gVu, a.field_downloadURL, bcVar.gTR);
                AppMethodBeat.o(59503);
            } else if (avZ instanceof l) {
                k.gSx.a((l) avZ, mVar);
                AppMethodBeat.o(59503);
            } else {
                String str2 = ((c) eVar).avZ().appId;
                try {
                    az.a(mVar.vdC, str2, mVar.filePath, ((c) eVar).avZ().version, ((c) eVar).avZ().cBc, ((c) eVar).gUy);
                    AppMethodBeat.o(59503);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.AppBrandWxaPkgDownloadPerformer", e, "dispatchComplete", new Object[0]);
                    az.br(mVar.vdC, str2);
                    AppMethodBeat.o(59503);
                }
            }
        }

        public static void d(com.tencent.mm.pluginsdk.g.a.c.e eVar, m mVar) {
            AppMethodBeat.i(59504);
            a((c) eVar, mVar);
            AppMethodBeat.o(59504);
        }

        public final void a(String str, k kVar) {
            AppMethodBeat.i(59505);
            az.a(str, (WxaPkgLoadProgress) kVar);
            AppMethodBeat.o(59505);
        }

        private static void a(c cVar, m mVar) {
            AppMethodBeat.i(59506);
            e.deleteFile(mVar.filePath);
            if (cVar.avZ() instanceof l) {
                k.gSx.a((l) cVar.avZ(), mVar);
                AppMethodBeat.o(59506);
            } else if (cVar.avZ() instanceof al) {
                p.a((al) cVar.avZ(), mVar, cVar.gUy);
                AppMethodBeat.o(59506);
            } else if (cVar.avZ() instanceof bc) {
                bd.a((bc) cVar.avZ(), mVar, cVar.gUy);
                AppMethodBeat.o(59506);
            } else {
                com.tencent.mm.plugin.appbrand.appcache.a.b.a.a aVar;
                String str = cVar.avZ().appId;
                if (!(mVar.vfo instanceof com.tencent.mm.pluginsdk.g.a.b.a)) {
                    switch (mVar.httpStatusCode) {
                        case 403:
                        case 404:
                            aVar = com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.SEVER_FILE_NOT_FOUND;
                            break;
                        default:
                            aVar = com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.FAILED;
                            break;
                    }
                }
                aVar = com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.DISK_FULL;
                az.a(mVar.vdC, str, aVar);
                AppMethodBeat.o(59506);
            }
        }
    }

    static final class c extends com.tencent.mm.pluginsdk.g.a.c.n.a<com.tencent.mm.plugin.appbrand.appcache.a.a> {
        private static final ThreadLocal<a> gUw = new ThreadLocal<a>() {
            /* Access modifiers changed, original: protected|final|synthetic */
            public final /* synthetic */ Object initialValue() {
                AppMethodBeat.i(59491);
                a aVar = new a();
                AppMethodBeat.o(59491);
                return aVar;
            }
        };
        private String gUx = null;
        final com.tencent.mm.plugin.appbrand.appcache.z.a gUy;

        static {
            AppMethodBeat.i(59498);
            AppMethodBeat.o(59498);
        }

        c(com.tencent.mm.plugin.appbrand.appcache.a.a aVar) {
            super(aVar);
            AppMethodBeat.i(59492);
            com.tencent.mm.plugin.appbrand.appcache.z.a a = z.a(aVar);
            if (a == null) {
                a = m.gSB;
            }
            this.gUy = a;
            AppMethodBeat.o(59492);
        }

        /* Access modifiers changed, original: protected|final */
        public final com.tencent.mm.plugin.appbrand.appcache.a.a avZ() {
            AppMethodBeat.i(59493);
            com.tencent.mm.plugin.appbrand.appcache.a.a aVar = (com.tencent.mm.plugin.appbrand.appcache.a.a) super.awh();
            AppMethodBeat.o(59493);
            return aVar;
        }

        public final String getURL() {
            return this.gUx;
        }

        public final boolean gh(long j) {
            AppMethodBeat.i(59495);
            StatFs statFs = new StatFs(com.tencent.mm.vfs.j.w(new com.tencent.mm.vfs.b(getFilePath()).dMC().dMD()));
            long availableBlocks = (long) (statFs.getAvailableBlocks() * statFs.getBlockSize());
            if (availableBlocks < 0 || availableBlocks > j) {
                AppMethodBeat.o(59495);
                return true;
            }
            AppMethodBeat.o(59495);
            return false;
        }

        public final String awa() {
            return "AppBrandWxaPkgDownloader";
        }

        public final boolean awb() {
            return true;
        }

        public final boolean awc() {
            return false;
        }

        public final boolean awd() {
            return true;
        }

        public final boolean awe() {
            return false;
        }

        public final boolean awf() {
            return true;
        }

        public final boolean awg() {
            AppMethodBeat.i(59496);
            switch (y.Me()) {
                case 0:
                    AppMethodBeat.o(59496);
                    return false;
                case 1:
                    boolean awg = super.awg();
                    AppMethodBeat.o(59496);
                    return awg;
                default:
                    AppMethodBeat.o(59496);
                    return false;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:36:0x00aa  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0060 A:{Catch:{ Exception -> 0x00a6 }} */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00a8  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0063 A:{Catch:{ Exception -> 0x00a6 }} */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x00a2  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x007e  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x007e  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x00a2  */
        /* JADX WARNING: Missing block: B:6:0x0038, code skipped:
            if (r1.status == 3) goto L_0x003a;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final m a(com.tencent.mm.pluginsdk.g.a.c.j jVar) {
            Throwable e;
            m a;
            Exception exception;
            AppMethodBeat.i(59494);
            try {
                int i;
                int i2;
                com.tencent.mm.plugin.appbrand.appcache.a.a aVar = (com.tencent.mm.plugin.appbrand.appcache.a.a) super.awh();
                e.deleteFile(aVar.getFilePath());
                this.gUx = aVar.url;
                com.tencent.mm.plugin.appbrand.appcache.z.a aVar2 = this.gUy;
                this.gUx.startsWith("https");
                aVar2.avp();
                m a2 = ((a) gUw.get()).a(this);
                if (a2 != null) {
                    try {
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
                if (this.gUx.startsWith("http://")) {
                    i = 1;
                    if ((a2 != null || a2.status == 3) && this.gUx.startsWith("https")) {
                        this.gUy.avr();
                        if (aVar instanceof ak) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        if (i2 == 0) {
                            this.gUx = this.gUx.replaceFirst("https", "http");
                            a = super.a(jVar);
                        } else {
                            a = a2;
                        }
                        a2 = a;
                    } else if (a2 == null || i != 0) {
                        a2 = super.a(jVar);
                    }
                    this.gUy.a(a2);
                    a = a2;
                    if (a == null) {
                        a = new m(this, null, -1, 3);
                        AppMethodBeat.o(59494);
                        return a;
                    }
                    AppMethodBeat.o(59494);
                    return a;
                }
                i = 0;
                if (a2 != null) {
                }
                this.gUy.avr();
                if (aVar instanceof ak) {
                }
                if (i2 == 0) {
                }
                a2 = a;
                this.gUy.a(a2);
                a = a2;
            } catch (Exception e3) {
                e = e3;
                exception = null;
            }
            if (a == null) {
            }
            ab.printErrStackTrace("MicroMsg.AppBrandWxaPkgDownloadPerformer", e, "perform failed", new Object[0]);
            Object obj = exception;
            if (a == null) {
            }
        }

        public final /* bridge */ /* synthetic */ com.tencent.mm.pluginsdk.g.a.c.f.b awh() {
            AppMethodBeat.i(59497);
            com.tencent.mm.plugin.appbrand.appcache.a.a aVar = (com.tencent.mm.plugin.appbrand.appcache.a.a) super.awh();
            AppMethodBeat.o(59497);
            return aVar;
        }
    }

    ap() {
        AppMethodBeat.i(59507);
        AppMethodBeat.o(59507);
    }

    public static String avY() {
        AppMethodBeat.i(59508);
        String str = com.tencent.mm.kernel.g.RP().cachePath;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        str = str + "appbrand/pkg/";
        com.tencent.mm.sdk.platformtools.j.aih(str);
        AppMethodBeat.o(59508);
        return str;
    }

    public final int b(com.tencent.mm.plugin.appbrand.appcache.a.a aVar) {
        AppMethodBeat.i(59509);
        if (this.gUn.ajd(aVar.vdC)) {
            ab.i("MicroMsg.AppBrandWxaPkgDownloadPerformer", "addRequestIfNotRunning, urlKey %s already in queue", aVar.vdC);
            AppMethodBeat.o(59509);
            return 0;
        }
        ab.i("MicroMsg.AppBrandWxaPkgDownloadPerformer", "addRequestIfNotRunning, urlKey %s, addResult %d", aVar.vdC, Integer.valueOf(this.gUn.b(aVar)));
        AppMethodBeat.o(59509);
        return this.gUn.b(aVar);
    }
}
