package com.tencent.p177mm.plugin.appbrand.appcache;

import android.net.Uri;
import android.os.StatFs;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C18172y;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.appbrand.appcache.C26751z.C19074a;
import com.tencent.p177mm.plugin.appbrand.appcache.p881a.C10065a;
import com.tencent.p177mm.plugin.appbrand.appcache.p881a.C26735b.C26734a.C10067a;
import com.tencent.p177mm.plugin.appbrand.p1468a.C33065d;
import com.tencent.p177mm.plugin.appbrand.p328r.C19681j;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p595b.C4713a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C30043n;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C30043n.C30044a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C35791j;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C35792l;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C40430c;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C40431k;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C40432m;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C44051u;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C4715e;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C4716f.C4718d;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C4716f.C4719b;
import com.tencent.p177mm.sdk.platformtools.C15428j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLException;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.ap */
public final class C10072ap {
    final C10077b gUn = new C10077b();

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.ap$a */
    static final class C10073a {

        /* renamed from: com.tencent.mm.plugin.appbrand.appcache.ap$a$a */
        static abstract class C10074a implements C1628a {
            private final C10080c gUu;

            /* renamed from: b */
            public abstract void mo21432b(C40432m c40432m);

            C10074a(C10080c c10080c) {
                this.gUu = c10080c;
            }

            /* renamed from: a */
            public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
                if (i != 0) {
                    mo21432b(new C40432m(this.gUu, new SSLException(String.format(Locale.US, "CdnHttpsAddTaskFailed$%s$%d", new Object[]{this.gUu.dib(), Integer.valueOf(i)})), 3));
                    C4990ab.m7413e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "urlKey %s, startRet %d", this.gUu.dib(), Integer.valueOf(i));
                    return 0;
                } else if (c18496c != null) {
                    C40430c c40430c = this.gUu.vft;
                    if (c40430c != null) {
                        c40430c.mo9860a(this.gUu.dib(), new WxaPkgLoadProgress((int) ((((float) c18496c.field_finishedLength) / ((float) c18496c.field_toltalLength)) * 100.0f), (long) c18496c.field_finishedLength, (long) c18496c.field_toltalLength));
                    }
                    return 0;
                } else {
                    if (c9545d != null) {
                        C4990ab.m7417i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "urlKey %s, retCode %d, responseHeader %s", this.gUu.dib(), Integer.valueOf(c9545d.field_retCode), c9545d.field_httpResponseHeader);
                        if (c9545d.field_retCode != 0) {
                            C40432m c40432m;
                            if (c9545d.field_fileLength <= 0 || this.gUu.mo9636gh((long) c9545d.field_fileLength)) {
                                c40432m = new C40432m(this.gUu, new SSLException(String.format(Locale.US, "CdnHttpsDownloadFailed$%s$%d", new Object[]{this.gUu.dib(), Integer.valueOf(c9545d.field_retCode)})), c9545d.field_httpStatusCode, 3);
                            } else {
                                c40432m = new C40432m(this.gUu, new C4713a(), c9545d.field_httpStatusCode, 3);
                            }
                            mo21432b(c40432m);
                        } else {
                            mo21432b(new C40432m(this.gUu, (long) c9545d.field_fileLength, null));
                            int asZ = (int) C5730e.asZ(this.gUu.avZ().getFilePath());
                            if (C26417a.flv != null) {
                                C26417a.flv.mo44184cm(asZ, 0);
                            }
                        }
                    }
                    return 0;
                }
            }

            /* renamed from: a */
            public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            /* renamed from: l */
            public final byte[] mo5084l(String str, byte[] bArr) {
                return new byte[0];
            }
        }

        private C10073a() {
        }

        /* synthetic */ C10073a(byte b) {
            this();
        }

        /* renamed from: a */
        public final C40432m mo21431a(C10080c c10080c) {
            AppMethodBeat.m2504i(59485);
            String dib = c10080c.dib();
            C4990ab.m7417i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "downloadUsingCDN, url %s", c10080c.getURL());
            try {
                C7564ap c7564ap;
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                final C19681j c19681j = new C19681j();
                final C10065a avZ = c10080c.avZ();
                final String str = avZ.vdC;
                final C19074a c19074a = c10080c.gUy;
                if (c10080c.avZ().gVz) {
                    c7564ap = new C7564ap(C26006a.dvQ().getLooper(), new C5015a() {
                        /* renamed from: BI */
                        public final boolean mo4499BI() {
                            AppMethodBeat.m2504i(59483);
                            C37461f.afx().mo51228rO(str);
                            c19074a.avq();
                            C5730e.deleteFile(avZ.getFilePath());
                            c19681j.value = null;
                            countDownLatch.countDown();
                            AppMethodBeat.m2505o(59483);
                            return false;
                        }
                    }, false);
                } else {
                    c7564ap = null;
                }
                final C19681j c19681j2 = c19681j;
                final CountDownLatch countDownLatch2 = countDownLatch;
                C100752 c100752 = new C10074a(c10080c) {
                    /* Access modifiers changed, original: final */
                    /* renamed from: b */
                    public final void mo21432b(C40432m c40432m) {
                        AppMethodBeat.m2504i(59484);
                        if (c7564ap != null) {
                            c7564ap.stopTimer();
                        }
                        c19681j2.value = c40432m;
                        countDownLatch2.countDown();
                        AppMethodBeat.m2505o(59484);
                    }
                };
                C42130g c42130g = new C42130g();
                c42130g.field_mediaId = str;
                c42130g.field_fullpath = avZ.getFilePath();
                c42130g.egm = avZ.url;
                c42130g.cRY = false;
                c42130g.egl = c100752;
                c42130g.egn = (int) TimeUnit.MILLISECONDS.toSeconds((long) avZ.getConnectTimeout());
                c42130g.ego = (int) TimeUnit.MILLISECONDS.toSeconds((long) avZ.getReadTimeout());
                c42130g.field_fileType = C42129a.efP;
                if (avZ instanceof C42357l) {
                    c42130g.egq = false;
                }
                String host = Uri.parse(c42130g.egm).getHost();
                if (!C5046bo.isNullOrNil(host)) {
                    ArrayList arrayList = new ArrayList();
                    try {
                        C1720g.m3535RO().eJo.ftA.getHostByName(host, arrayList);
                        c42130g.egp = new String[arrayList.size()];
                        arrayList.toArray(c42130g.egp);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https getHostByName e = %s", e);
                    }
                }
                C37461f.afx().mo51222b(c42130g, -1);
                if (c7564ap != null) {
                    long readTimeout = (long) avZ.getReadTimeout();
                    c7564ap.mo16770ae(readTimeout, readTimeout);
                }
                try {
                    countDownLatch.await();
                    C40432m c40432m = (C40432m) c19681j.value;
                    AppMethodBeat.m2505o(59485);
                    return c40432m;
                } catch (Exception e2) {
                    C4990ab.m7413e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https perform, urlKey %s semaphore await e = %s", dib, e2);
                    AppMethodBeat.m2505o(59485);
                    return null;
                }
            } catch (Exception e22) {
                C4990ab.m7413e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https perform urlKey %s exp %s", dib, e22);
                AppMethodBeat.m2505o(59485);
                return null;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.ap$b */
    final class C10077b extends C30043n {
        C10077b() {
            super(new C44051u("WxaPkgDownloaderPool", "WxaPkgDownloaderThread"), new C10078d());
            AppMethodBeat.m2504i(59486);
            AppMethodBeat.m2505o(59486);
        }

        public final void shutdown() {
            AppMethodBeat.m2504i(59487);
            super.shutdown();
            ((C10078d) this.vfq).gUz.getLooper().quit();
            AppMethodBeat.m2505o(59487);
        }

        /* renamed from: a */
        public final C4718d mo21433a(C35792l c35792l) {
            AppMethodBeat.m2504i(59488);
            C10080c c10080c = new C10080c((C10065a) c35792l);
            c10080c.vft = this.vfq;
            AppMethodBeat.m2505o(59488);
            return c10080c;
        }

        /* renamed from: b */
        public final int mo21434b(C35792l c35792l) {
            AppMethodBeat.m2504i(59489);
            int b = super.mo21434b(c35792l);
            if (b == 1) {
                super.mo9848b(c35792l);
                AppMethodBeat.m2505o(59489);
                return 2;
            }
            AppMethodBeat.m2505o(59489);
            return b;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.ap$d */
    final class C10078d implements C40430c {
        final C7306ak gUz = new C7306ak(new C5004al("WxaPkgDownloadPerformerEventDispatchThread").oAl.getLooper());

        C10078d() {
            AppMethodBeat.m2504i(59500);
            AppMethodBeat.m2505o(59500);
        }

        /* renamed from: a */
        public final void mo9858a(final C4715e c4715e, final C40432m c40432m) {
            AppMethodBeat.m2504i(59501);
            this.gUz.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(59499);
                    switch (c40432m.status) {
                        case 2:
                            C10078d.m17669c(c4715e, c40432m);
                            AppMethodBeat.m2505o(59499);
                            return;
                        case 3:
                            C10078d.m17668b(c4715e, c40432m);
                            break;
                        case 4:
                            C10078d.m17670d(c4715e, c40432m);
                            AppMethodBeat.m2505o(59499);
                            return;
                    }
                    AppMethodBeat.m2505o(59499);
                }
            });
            AppMethodBeat.m2505o(59501);
        }

        /* renamed from: u */
        public final void mo9861u(String str, int i, int i2) {
        }

        /* renamed from: w */
        public final void mo9862w(String str, long j) {
        }

        /* renamed from: b */
        public static void m17668b(C4715e c4715e, C40432m c40432m) {
            AppMethodBeat.m2504i(59502);
            C10078d.m17667a((C10080c) c4715e, c40432m);
            AppMethodBeat.m2505o(59502);
        }

        /* renamed from: c */
        public static void m17669c(C4715e c4715e, C40432m c40432m) {
            AppMethodBeat.m2504i(59503);
            C10065a avZ = ((C10080c) c4715e).avZ();
            C19074a c19074a;
            C38105ax xF;
            C31281at a;
            if (avZ instanceof C38103al) {
                C38103al c38103al = (C38103al) avZ;
                c19074a = ((C10080c) c4715e).gUy;
                xF = ((C33065d) C1720g.m3528K(C33065d.class)).mo53635xF();
                if (xF == null) {
                    C2055az.m4217a(c38103al.vdC, c38103al.appId, C10067a.ENV_ERR, null);
                    AppMethodBeat.m2505o(59503);
                    return;
                }
                String str = c38103al.appId;
                int i = c38103al.gTP;
                int i2 = c38103al.gTQ;
                String avR = c38103al.avR();
                C31281at a2 = xF.mo60841a(str, i, 0, "pkgPath");
                C31281at a3 = xF.mo60841a(str, i2, 0, "versionMd5");
                if (a2 == null || a3 == null) {
                    C2055az.m4217a(c38103al.vdC, c38103al.appId, C10067a.ENV_ERR, null);
                    AppMethodBeat.m2505o(59503);
                    return;
                }
                c19074a.avs();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                int A = C19063p.m29628A(a2.field_pkgPath, avR, c38103al.getFilePath());
                elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime;
                C4990ab.m7417i("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "applyPkgPatch, appId[%s], oldPath[%s], newPath[%s], patchPath[%s], cost %d, ret %d", c38103al.appId, a2.field_pkgPath, avR, c38103al.getFilePath(), Long.valueOf(elapsedRealtime), Integer.valueOf(A));
                c19074a.mo34299nq(A);
                if (A == 0) {
                    C2055az.m4218a(c38103al.vdC, c38103al.appId, avR, i2, 0, c19074a);
                    AppMethodBeat.m2505o(59503);
                    return;
                }
                C5730e.deleteFile(avR);
                a = xF.mo60841a(c38103al.appId, c38103al.gTQ, 0, "downloadURL");
                if (a == null) {
                    C2055az.m4217a(c38103al.vdC, c38103al.appId, C10067a.ENV_ERR, null);
                    AppMethodBeat.m2505o(59503);
                    return;
                }
                C2055az.m4226xJ(c38103al.vdC);
                C2055az.m4224b(c38103al.appId, 0, c38103al.gTQ, a.field_downloadURL, c38103al.gTR);
                AppMethodBeat.m2505o(59503);
            } else if (avZ instanceof C26746bc) {
                C26746bc c26746bc = (C26746bc) avZ;
                c19074a = ((C10080c) c4715e).gUy;
                xF = ((C33065d) C1720g.m3528K(C33065d.class)).mo53635xF();
                if (xF == null) {
                    C2055az.m4217a(c26746bc.vdC, c26746bc.appId, C10067a.ENV_ERR, null);
                    AppMethodBeat.m2505o(59503);
                    return;
                }
                c19074a.avv();
                boolean a4 = C10089bd.m17683a(c26746bc);
                c19074a.mo34297dA(a4);
                C4990ab.m7417i("MicroMsg.AppBrand.ZstdLogic", "processZstd suc:%b", Boolean.valueOf(a4));
                if (a4) {
                    C2055az.m4218a(c26746bc.vdC, c26746bc.appId, c26746bc.aws(), c26746bc.gVu, c26746bc.cBc, c19074a);
                    AppMethodBeat.m2505o(59503);
                    return;
                }
                C5730e.deleteFile(c26746bc.aws());
                a = xF.mo60841a(c26746bc.appId, c26746bc.gVu, c26746bc.cBc, "downloadURL");
                if (a == null) {
                    C2055az.m4217a(c26746bc.vdC, c26746bc.appId, C10067a.ENV_ERR, null);
                    AppMethodBeat.m2505o(59503);
                    return;
                }
                C2055az.m4226xJ(c26746bc.vdC);
                C2055az.m4224b(c26746bc.appId, c26746bc.cBc, c26746bc.gVu, a.field_downloadURL, c26746bc.gTR);
                AppMethodBeat.m2505o(59503);
            } else if (avZ instanceof C42357l) {
                C42356k.gSx.mo67864a((C42357l) avZ, c40432m);
                AppMethodBeat.m2505o(59503);
            } else {
                String str2 = ((C10080c) c4715e).avZ().appId;
                try {
                    C2055az.m4218a(c40432m.vdC, str2, c40432m.filePath, ((C10080c) c4715e).avZ().version, ((C10080c) c4715e).avZ().cBc, ((C10080c) c4715e).gUy);
                    AppMethodBeat.m2505o(59503);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.AppBrandWxaPkgDownloadPerformer", e, "dispatchComplete", new Object[0]);
                    C2055az.m4225br(c40432m.vdC, str2);
                    AppMethodBeat.m2505o(59503);
                }
            }
        }

        /* renamed from: d */
        public static void m17670d(C4715e c4715e, C40432m c40432m) {
            AppMethodBeat.m2504i(59504);
            C10078d.m17667a((C10080c) c4715e, c40432m);
            AppMethodBeat.m2505o(59504);
        }

        /* renamed from: a */
        public final void mo9860a(String str, C40431k c40431k) {
            AppMethodBeat.m2504i(59505);
            C2055az.m4214a(str, (WxaPkgLoadProgress) c40431k);
            AppMethodBeat.m2505o(59505);
        }

        /* renamed from: a */
        private static void m17667a(C10080c c10080c, C40432m c40432m) {
            AppMethodBeat.m2504i(59506);
            C5730e.deleteFile(c40432m.filePath);
            if (c10080c.avZ() instanceof C42357l) {
                C42356k.gSx.mo67864a((C42357l) c10080c.avZ(), c40432m);
                AppMethodBeat.m2505o(59506);
            } else if (c10080c.avZ() instanceof C38103al) {
                C19063p.m29629a((C38103al) c10080c.avZ(), c40432m, c10080c.gUy);
                AppMethodBeat.m2505o(59506);
            } else if (c10080c.avZ() instanceof C26746bc) {
                C10089bd.m17682a((C26746bc) c10080c.avZ(), c40432m, c10080c.gUy);
                AppMethodBeat.m2505o(59506);
            } else {
                C10067a c10067a;
                String str = c10080c.avZ().appId;
                if (!(c40432m.vfo instanceof C4713a)) {
                    switch (c40432m.httpStatusCode) {
                        case 403:
                        case 404:
                            c10067a = C10067a.SEVER_FILE_NOT_FOUND;
                            break;
                        default:
                            c10067a = C10067a.FAILED;
                            break;
                    }
                }
                c10067a = C10067a.DISK_FULL;
                C2055az.m4216a(c40432m.vdC, str, c10067a);
                AppMethodBeat.m2505o(59506);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.ap$c */
    static final class C10080c extends C30044a<C10065a> {
        private static final ThreadLocal<C10073a> gUw = new C100811();
        private String gUx = null;
        final C19074a gUy;

        /* renamed from: com.tencent.mm.plugin.appbrand.appcache.ap$c$1 */
        static class C100811 extends ThreadLocal<C10073a> {
            C100811() {
            }

            /* Access modifiers changed, original: protected|final|synthetic */
            public final /* synthetic */ Object initialValue() {
                AppMethodBeat.m2504i(59491);
                C10073a c10073a = new C10073a();
                AppMethodBeat.m2505o(59491);
                return c10073a;
            }
        }

        static {
            AppMethodBeat.m2504i(59498);
            AppMethodBeat.m2505o(59498);
        }

        C10080c(C10065a c10065a) {
            super(c10065a);
            AppMethodBeat.m2504i(59492);
            C19074a a = C26751z.m42580a(c10065a);
            if (a == null) {
                a = C42358m.gSB;
            }
            this.gUy = a;
            AppMethodBeat.m2505o(59492);
        }

        /* Access modifiers changed, original: protected|final */
        public final C10065a avZ() {
            AppMethodBeat.m2504i(59493);
            C10065a c10065a = (C10065a) super.awh();
            AppMethodBeat.m2505o(59493);
            return c10065a;
        }

        public final String getURL() {
            return this.gUx;
        }

        /* renamed from: gh */
        public final boolean mo9636gh(long j) {
            AppMethodBeat.m2504i(59495);
            StatFs statFs = new StatFs(C5736j.m8649w(new C5728b(getFilePath()).dMC().dMD()));
            long availableBlocks = (long) (statFs.getAvailableBlocks() * statFs.getBlockSize());
            if (availableBlocks < 0 || availableBlocks > j) {
                AppMethodBeat.m2505o(59495);
                return true;
            }
            AppMethodBeat.m2505o(59495);
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
            AppMethodBeat.m2504i(59496);
            switch (C18172y.m28611Me()) {
                case 0:
                    AppMethodBeat.m2505o(59496);
                    return false;
                case 1:
                    boolean awg = super.awg();
                    AppMethodBeat.m2505o(59496);
                    return awg;
                default:
                    AppMethodBeat.m2505o(59496);
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
        /* renamed from: a */
        public final C40432m mo9630a(C35791j c35791j) {
            Throwable e;
            C40432m a;
            Exception exception;
            AppMethodBeat.m2504i(59494);
            try {
                int i;
                int i2;
                C10065a c10065a = (C10065a) super.awh();
                C5730e.deleteFile(c10065a.getFilePath());
                this.gUx = c10065a.url;
                C19074a c19074a = this.gUy;
                this.gUx.startsWith("https");
                c19074a.avp();
                C40432m a2 = ((C10073a) gUw.get()).mo21431a(this);
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
                        if (c10065a instanceof C26737ak) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        if (i2 == 0) {
                            this.gUx = this.gUx.replaceFirst("https", "http");
                            a = super.mo9630a(c35791j);
                        } else {
                            a = a2;
                        }
                        a2 = a;
                    } else if (a2 == null || i != 0) {
                        a2 = super.mo9630a(c35791j);
                    }
                    this.gUy.mo34289a(a2);
                    a = a2;
                    if (a == null) {
                        a = new C40432m(this, null, -1, 3);
                        AppMethodBeat.m2505o(59494);
                        return a;
                    }
                    AppMethodBeat.m2505o(59494);
                    return a;
                }
                i = 0;
                if (a2 != null) {
                }
                this.gUy.avr();
                if (c10065a instanceof C26737ak) {
                }
                if (i2 == 0) {
                }
                a2 = a;
                this.gUy.mo34289a(a2);
                a = a2;
            } catch (Exception e3) {
                e = e3;
                exception = null;
            }
            if (a == null) {
            }
            C4990ab.printErrStackTrace("MicroMsg.AppBrandWxaPkgDownloadPerformer", e, "perform failed", new Object[0]);
            Object obj = exception;
            if (a == null) {
            }
        }

        public final /* bridge */ /* synthetic */ C4719b awh() {
            AppMethodBeat.m2504i(59497);
            C10065a c10065a = (C10065a) super.awh();
            AppMethodBeat.m2505o(59497);
            return c10065a;
        }
    }

    C10072ap() {
        AppMethodBeat.m2504i(59507);
        AppMethodBeat.m2505o(59507);
    }

    public static String avY() {
        AppMethodBeat.m2504i(59508);
        String str = C1720g.m3536RP().cachePath;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        str = str + "appbrand/pkg/";
        C15428j.aih(str);
        AppMethodBeat.m2505o(59508);
        return str;
    }

    /* renamed from: b */
    public final int mo21430b(C10065a c10065a) {
        AppMethodBeat.m2504i(59509);
        if (this.gUn.ajd(c10065a.vdC)) {
            C4990ab.m7417i("MicroMsg.AppBrandWxaPkgDownloadPerformer", "addRequestIfNotRunning, urlKey %s already in queue", c10065a.vdC);
            AppMethodBeat.m2505o(59509);
            return 0;
        }
        C4990ab.m7417i("MicroMsg.AppBrandWxaPkgDownloadPerformer", "addRequestIfNotRunning, urlKey %s, addResult %d", c10065a.vdC, Integer.valueOf(this.gUn.mo21434b(c10065a)));
        AppMethodBeat.m2505o(59509);
        return this.gUn.mo21434b(c10065a);
    }
}
