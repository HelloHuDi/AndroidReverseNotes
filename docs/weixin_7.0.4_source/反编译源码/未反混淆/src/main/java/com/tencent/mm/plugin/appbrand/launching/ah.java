package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.x;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ae;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.appcache.as;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appcache.az;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.d;
import com.tencent.mm.plugin.appbrand.appcache.p;
import com.tencent.mm.plugin.appbrand.appcache.r;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.e;
import com.tencent.mm.plugin.appbrand.r.j;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.arc;
import com.tencent.mm.protocal.protobuf.cwv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.VError;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import junit.framework.Assert;

abstract class ah extends af<WxaPkgWrappingInfo> implements m {
    final String appId;
    final int cDB;
    private final int gVu;
    final int har;
    final e hhO;
    String hok = null;
    private WxaPkgWrappingInfo iir;

    final class b implements Callable<WxaPkgWrappingInfo> {
        private final int iix;

        /* synthetic */ b(ah ahVar, int i, byte b) {
            this(i);
        }

        public final /* synthetic */ Object call() {
            AppMethodBeat.i(131966);
            WxaPkgWrappingInfo azZ = azZ();
            AppMethodBeat.o(131966);
            return azZ;
        }

        private b(int i) {
            this.iix = i;
        }

        public final WxaPkgWrappingInfo azZ() {
            AppMethodBeat.i(131965);
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final j jVar = new j();
            com.tencent.mm.plugin.appbrand.appcache.az.a anonymousClass1 = new t(ah.this.har) {
                /* Access modifiers changed, original: final */
                public final String aHr() {
                    AppMethodBeat.i(131961);
                    String format = String.format(Locale.US, "NonIncremental %d", new Object[]{Integer.valueOf(b.this.iix)});
                    AppMethodBeat.o(131961);
                    return format;
                }

                /* Access modifiers changed, original: final */
                public final void d(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                    AppMethodBeat.i(131962);
                    jVar.value = wxaPkgWrappingInfo;
                    countDownLatch.countDown();
                    AppMethodBeat.o(131962);
                }

                /* Access modifiers changed, original: protected|final */
                public final void b(WxaPkgLoadProgress wxaPkgLoadProgress) {
                    AppMethodBeat.i(131963);
                    ab.d("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "hy: onPkgUpdateProgress %s", wxaPkgLoadProgress.toString());
                    if (wxaPkgLoadProgress.progress >= 100) {
                        AppMethodBeat.o(131963);
                        return;
                    }
                    ah.this.onDownloadProgress(wxaPkgLoadProgress.progress);
                    AppMethodBeat.o(131963);
                }
            };
            ab.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, not incremental before start appId(%s), type(%d), pkgVersion(%d)", ah.this.appId, Integer.valueOf(ah.this.har), Integer.valueOf(this.iix));
            if (com.tencent.mm.plugin.appbrand.appcache.j.a.kR(ah.this.har)) {
                final at a = f.auV().a(ah.this.appId, ah.this.har, "versionMd5", "downloadURL");
                if (a == null || bo.isNullOrNil(a.field_downloadURL)) {
                    ab.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, get EMPTY url appId(%s), type(%d), record(%s)", ah.this.appId, Integer.valueOf(ah.this.har), a);
                    ah.this.a(com.tencent.mm.plugin.appbrand.appcache.as.a.gUJ);
                    AppMethodBeat.o(131965);
                    return null;
                }
                ah.this.hok = a.field_downloadURL;
                if (!az.a(ah.this.appId, ah.this.har, ah.this.hok, anonymousClass1, new com.tencent.mm.plugin.appbrand.appcache.a.a.a() {
                    public final String avJ() {
                        AppMethodBeat.i(131964);
                        String str = "_" + a.field_versionMd5;
                        AppMethodBeat.o(131964);
                        return str;
                    }
                })) {
                    ab.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, not incremental FATAL ERROR appId(%s), type(%d), pkgVersion(%d)", ah.this.appId, Integer.valueOf(ah.this.har), Integer.valueOf(this.iix));
                    ah.this.a(com.tencent.mm.plugin.appbrand.appcache.as.a.gUN);
                    AppMethodBeat.o(131965);
                    return null;
                }
            } else if (!az.a(ah.this.appId, ah.this.har, this.iix, ah.this.hhO.him, ah.this.hok, anonymousClass1)) {
                ab.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, not incremental FATAL ERROR appId(%s), type(%d), pkgVersion(%d)", ah.this.appId, Integer.valueOf(ah.this.har), Integer.valueOf(this.iix));
                ah.this.a(com.tencent.mm.plugin.appbrand.appcache.as.a.gUN);
                AppMethodBeat.o(131965);
                return null;
            }
            try {
                countDownLatch.await();
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckAppPkg", e, "downloadNonIncremental semaphore exp ", new Object[0]);
            }
            WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) jVar.value;
            AppMethodBeat.o(131965);
            return wxaPkgWrappingInfo;
        }
    }

    final class c implements Callable<WxaPkgWrappingInfo> {
        private final arc iiu;
        private final int iix;

        /* synthetic */ c(ah ahVar, int i, arc arc, byte b) {
            this(i, arc);
        }

        private c(int i, arc arc) {
            this.iix = i;
            this.iiu = arc;
        }

        /* Access modifiers changed, original: final */
        public final WxaPkgWrappingInfo aHA() {
            AppMethodBeat.i(131968);
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final j jVar = new j();
            if (bd.a(this.iiu.wuP, ah.this.appId, this.iix, 0, new t(ah.this.har) {
                /* Access modifiers changed, original: final */
                public final String aHr() {
                    return "Zstd";
                }

                /* Access modifiers changed, original: final */
                public final void d(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                    AppMethodBeat.i(131967);
                    jVar.value = wxaPkgWrappingInfo;
                    countDownLatch.countDown();
                    AppMethodBeat.o(131967);
                }
            })) {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    ab.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckAppPkg", e, "doZstdJob semaphore exp ", new Object[0]);
                }
                WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) jVar.value;
                AppMethodBeat.o(131968);
                return wxaPkgWrappingInfo;
            }
            AppMethodBeat.o(131968);
            return null;
        }

        public final /* synthetic */ Object call() {
            AppMethodBeat.i(131969);
            WxaPkgWrappingInfo aHA = aHA();
            AppMethodBeat.o(131969);
            return aHA;
        }
    }

    final class a implements Callable<WxaPkgWrappingInfo> {
        private final int iis;
        private final int iit;
        private final arc iiu;

        /* synthetic */ a(ah ahVar, int i, int i2, arc arc, byte b) {
            this(i, i2, arc);
        }

        private a(int i, int i2, arc arc) {
            this.iis = i;
            this.iit = i2;
            this.iiu = arc;
        }

        private WxaPkgWrappingInfo aHz() {
            AppMethodBeat.i(131959);
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final j jVar = new j();
            if (p.a(ah.this.appId, this.iis, this.iit, this.iiu.cDL, new t(ah.this.har) {
                /* Access modifiers changed, original: final */
                public final String aHr() {
                    AppMethodBeat.i(131957);
                    String format = String.format(Locale.US, "Incremental %d|%d", new Object[]{Integer.valueOf(a.this.iis), Integer.valueOf(a.this.iit)});
                    AppMethodBeat.o(131957);
                    return format;
                }

                /* Access modifiers changed, original: final */
                public final void d(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                    AppMethodBeat.i(131958);
                    jVar.value = wxaPkgWrappingInfo;
                    countDownLatch.countDown();
                    AppMethodBeat.o(131958);
                }
            })) {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    ab.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckAppPkg", e, "downloadIncremental semaphore exp ", new Object[0]);
                }
                WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) jVar.value;
                AppMethodBeat.o(131959);
                return wxaPkgWrappingInfo;
            }
            AppMethodBeat.o(131959);
            return null;
        }

        public final /* synthetic */ Object call() {
            AppMethodBeat.i(131960);
            Object aHz;
            if (!bo.isNullOrNil(this.iiu.cDL) && r.avD()) {
                aHz = aHz();
                AppMethodBeat.o(131960);
                return aHz;
            } else if (bo.isNullOrNil(this.iiu.wuP)) {
                WxaPkgWrappingInfo azZ = new b(ah.this, this.iit, (byte) 0).azZ();
                AppMethodBeat.o(131960);
                return azZ;
            } else {
                aHz = new c(ah.this, this.iit, this.iiu, (byte) 0).aHA();
                AppMethodBeat.o(131960);
                return aHz;
            }
        }
    }

    public /* synthetic */ Object call() {
        return azZ();
    }

    ah(String str, int i, int i2, int i3, e eVar) {
        this.appId = str;
        this.har = i;
        this.gVu = i2;
        this.cDB = i3;
        this.hhO = eVar;
    }

    public void aHe() {
    }

    public void aHj() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x01dd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private WxaPkgWrappingInfo azZ() {
        Pair v = as.v(this.appId, this.har, this.gVu);
        if (v.second != null) {
            ab.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "call, using existing pkg with appId(%s) versionType(%d) pkgVersion(%d)", this.appId, Integer.valueOf(this.har), Integer.valueOf(this.gVu));
            try {
                ((com.tencent.mm.plugin.appbrand.appcache.b.d.a) f.E(com.tencent.mm.plugin.appbrand.appcache.b.d.a.class)).ay(this.appId, this.gVu);
            } catch (Throwable th) {
                ab.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckAppPkg", th, "checkReportOnLocalPkgFound, appId[%s], version[%d]", this.appId, Integer.valueOf(this.gVu));
            }
            return (WxaPkgWrappingInfo) v.second;
        }
        String str;
        Pair v2;
        try {
            com.tencent.mm.plugin.appbrand.appcache.b.d.a aVar = (com.tencent.mm.plugin.appbrand.appcache.b.d.a) f.E(com.tencent.mm.plugin.appbrand.appcache.b.d.a.class);
            str = this.appId;
            int i = this.gVu;
            com.tencent.mm.plugin.appbrand.appcache.b.d.b bVar = new com.tencent.mm.plugin.appbrand.appcache.b.d.b();
            bVar.field_appId = str;
            bVar.field_version = i;
            boolean b = aVar.b(bVar, new String[0]);
            bVar.field_hitCount++;
            if (b) {
                aVar.c(bVar, new String[0]);
            } else {
                aVar.b((com.tencent.mm.sdk.e.c) bVar);
            }
        } catch (Throwable th2) {
            ab.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckAppPkg", th2, "increaseHitCount, appId[%s], version[%d]", this.appId, Integer.valueOf(this.gVu));
        }
        if (com.tencent.mm.plugin.appbrand.appcache.j.a.np(this.har)) {
            ae s = ((af) f.E(af.class)).s(this.appId, 1, this.gVu);
            if (s != null) {
                PLong pLong = new PLong();
                ab.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "decrypt ret %b, with appId(%s) version(%d)", Boolean.valueOf(com.tencent.mm.plugin.appbrand.appcache.b.b.f.a(s, com.tencent.mm.plugin.appbrand.appcache.b.b.f.a.WXA_LAUNCH, pLong)), this.appId, Integer.valueOf(this.gVu));
                if (com.tencent.mm.plugin.appbrand.appcache.b.b.f.a(s, com.tencent.mm.plugin.appbrand.appcache.b.b.f.a.WXA_LAUNCH, pLong)) {
                    v2 = as.v(this.appId, this.har, this.gVu);
                    com.tencent.mm.plugin.appbrand.appcache.b.c.a aVar2;
                    if (v2.second != null) {
                        aVar2 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gWl;
                        com.tencent.mm.plugin.appbrand.appcache.b.c.a.z(pLong.value, 180);
                        return (WxaPkgWrappingInfo) v2.second;
                    }
                    aVar2 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gWl;
                    com.tencent.mm.plugin.appbrand.appcache.b.c.a.z(pLong.value, 181);
                    if (com.tencent.mm.plugin.appbrand.appcache.as.a.gUJ.equals(v2.first)) {
                        ab.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "call, manifest NULL, appId(%s) type(%d) version(%d)", this.appId, Integer.valueOf(this.har), Integer.valueOf(this.gVu));
                        f.auV().a(this.appId, this.hhO);
                        if (f.auV().a(this.appId, this.gVu, this.har, new String[0]) == null) {
                            ab.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "call, insert manifest fail again!!! appId(%s) type(%d) version(%d)", this.appId, Integer.valueOf(this.har), Integer.valueOf(this.gVu));
                        } else {
                            v2 = Pair.create(com.tencent.mm.plugin.appbrand.appcache.as.a.gUM, null);
                        }
                    }
                    if (com.tencent.mm.plugin.appbrand.appcache.as.a.gUM.equals(v2.first)) {
                        if (this.har == 0) {
                            this.iir = h.bm(this.appId, 1);
                            WxaPkgWrappingInfo c;
                            try {
                                at a = f.auV().a(this.appId, 0, "version", "versionMd5", "versionState");
                                if (a == null) {
                                    throw new a().n(com.tencent.mm.plugin.appbrand.s.e.getMMString(R.string.md, com.tencent.mm.plugin.appbrand.appcache.b.no(this.har)), new Object[0]).o("get NULL record with md5", new Object[0]).aHl();
                                }
                                long anU = bo.anU();
                                int i2 = a.field_version;
                                int i3 = this.iir == null ? 0 : this.iir.gVu;
                                com.tencent.mm.ai.a.a a2 = x.a(new d(this.appId, a.field_version, a.field_versionMd5, 0, i3));
                                String str2;
                                if (a2 != null && a2.errType == 0 && a2.errCode == 0) {
                                    y.a(com.tencent.mm.plugin.appbrand.launching.y.b.GET_DOWNLOAD_URL, this.appId, i2, this.har, this.cDB, bo.anU() - anU);
                                    if (bo.isNullOrNil(((arc) a2.fsy).url)) {
                                        throw new a().o("CgiGetDownloadURL return EMPTY url, ret = %d", Integer.valueOf(((arc) a2.fsy).ret)).aHl();
                                    }
                                    cwv cwv = new cwv();
                                    str2 = ((arc) a2.fsy).url;
                                    this.hok = str2;
                                    cwv.xsy = str2;
                                    cwv.vMG = a.field_version;
                                    cwv.xsw = a.field_versionState;
                                    cwv.xsx = a.field_versionMd5;
                                    f.auV().a(this.appId, cwv, 0);
                                    if (this.hhO.him > 0) {
                                        long anU2 = bo.anU();
                                        com.tencent.mm.plugin.appbrand.appcache.x.b gg = com.tencent.mm.plugin.appbrand.appcache.x.gg((long) this.hhO.him);
                                        anU2 = bo.anU() - anU2;
                                        ab.d("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "trimOff %d, cost %d, result %s", Integer.valueOf(this.hhO.him), Long.valueOf(anU2), gg.name());
                                    }
                                    c = c(new a(this, i3, i2, (arc) a2.fsy, (byte) 0));
                                    if (c != null) {
                                        return c;
                                    }
                                    throw new a().o("Download Fail", new Object[0]).aHl();
                                }
                                if (a2 == null || a2.errCode != VError.ERROR_FACE_TXT_INIT) {
                                    Object[] objArr = new Object[2];
                                    objArr[0] = Integer.valueOf(a2 == null ? -1 : a2.errType);
                                    objArr[1] = Integer.valueOf(a2 == null ? -1 : a2.errCode);
                                    str = ag.getMMString(R.string.m8, objArr);
                                } else {
                                    str = ag.getMMString(R.string.m_, new Object[0]);
                                }
                                a aVar3 = new a();
                                String str3 = "fail get download url, resp %s";
                                Object[] objArr2 = new Object[1];
                                if (a2 == null) {
                                    str2 = null;
                                } else {
                                    str2 = String.format(Locale.US, "(%d, %d)", new Object[]{Integer.valueOf(a2.errType), Integer.valueOf(a2.errCode)});
                                }
                                objArr2[0] = str2;
                                throw aVar3.o(str3, objArr2).n(str, new Object[0]).aHl();
                            } catch (com.tencent.mm.plugin.appbrand.launching.m.a e) {
                                com.tencent.mm.plugin.appbrand.launching.m.a aVar4 = e;
                                ab.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "release_pkg APP_BROKEN obtain appId %s, message %s", this.appId, aVar4.getMessage());
                                if (this.gVu <= 0) {
                                    c = h.bm(this.appId, 1);
                                    if (c != null) {
                                        return c;
                                    }
                                }
                                if (!bo.isNullOrNil(aVar4.ihb)) {
                                    ag.Ck(aVar4.ihb);
                                }
                                return null;
                            }
                        }
                        WxaPkgWrappingInfo c2 = c(new b(this, 0, (byte) 0));
                        if (c2 != null) {
                            return c2;
                        }
                    }
                    a((com.tencent.mm.plugin.appbrand.appcache.as.a) v2.first);
                    return null;
                }
            }
        }
        v2 = v;
        if (com.tencent.mm.plugin.appbrand.appcache.as.a.gUJ.equals(v2.first)) {
        }
        if (com.tencent.mm.plugin.appbrand.appcache.as.a.gUM.equals(v2.first)) {
        }
        a((com.tencent.mm.plugin.appbrand.appcache.as.a) v2.first);
        return null;
    }

    private WxaPkgWrappingInfo c(Callable<WxaPkgWrappingInfo> callable) {
        if (callable == this) {
            Assert.assertTrue("Why the hell you pass 'this' to this method", false);
            return null;
        }
        WxaPkgWrappingInfo wxaPkgWrappingInfo;
        aHe();
        try {
            wxaPkgWrappingInfo = (WxaPkgWrappingInfo) callable.call();
        } catch (Exception e) {
            wxaPkgWrappingInfo = null;
        }
        aHj();
        return wxaPkgWrappingInfo;
    }

    /* Access modifiers changed, original: final */
    public final void a(com.tencent.mm.plugin.appbrand.appcache.as.a aVar) {
        int i = R.string.km;
        if (com.tencent.mm.plugin.appbrand.appcache.as.a.gUJ.equals(aVar)) {
            String mMString;
            if (this.har == 1) {
                mMString = com.tencent.mm.plugin.appbrand.s.e.getMMString(R.string.km, new Object[0]);
            } else {
                mMString = com.tencent.mm.plugin.appbrand.s.e.getMMString(R.string.md, com.tencent.mm.plugin.appbrand.appcache.b.no(this.har));
            }
            if (this.har == 1) {
                h.bt(this.appId, this.har);
                com.tencent.mm.plugin.appbrand.report.c.K(this.appId, 10, this.har + 1);
            }
            ag.Ck(mMString);
        } else if (com.tencent.mm.plugin.appbrand.appcache.as.a.gUL.equals(aVar) || com.tencent.mm.plugin.appbrand.appcache.as.a.gUK.equals(aVar)) {
            if (this.har == 0) {
                i = R.string.kp;
            }
            ag.oZ(i);
            if (this.har == 1) {
                com.tencent.mm.plugin.appbrand.report.c.K(this.appId, 10, this.har + 1);
            }
            h.bt(this.appId, this.har);
        } else {
            ag.Ck(com.tencent.mm.plugin.appbrand.s.e.getMMString(R.string.ma, Integer.valueOf(1), Integer.valueOf(aVar.awj())));
        }
    }

    /* Access modifiers changed, original: final */
    public final String getTag() {
        return "MicroMsg.AppBrand.PrepareStepCheckAppPkg";
    }
}
