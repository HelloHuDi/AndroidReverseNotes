package com.tencent.p177mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p183ai.C8920x;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.C10089bd;
import com.tencent.p177mm.plugin.appbrand.appcache.C19035as;
import com.tencent.p177mm.plugin.appbrand.appcache.C19035as.C19036a;
import com.tencent.p177mm.plugin.appbrand.appcache.C19063p;
import com.tencent.p177mm.plugin.appbrand.appcache.C19071r;
import com.tencent.p177mm.plugin.appbrand.appcache.C2055az;
import com.tencent.p177mm.plugin.appbrand.appcache.C2055az.C2057a;
import com.tencent.p177mm.plugin.appbrand.appcache.C31281at;
import com.tencent.p177mm.plugin.appbrand.appcache.C33094d;
import com.tencent.p177mm.plugin.appbrand.appcache.C33098x;
import com.tencent.p177mm.plugin.appbrand.appcache.C33098x.C33100b;
import com.tencent.p177mm.plugin.appbrand.appcache.C38114b;
import com.tencent.p177mm.plugin.appbrand.appcache.C41220ae;
import com.tencent.p177mm.plugin.appbrand.appcache.C42346af;
import com.tencent.p177mm.plugin.appbrand.appcache.C45515j.C33097a;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p278d.C2058a;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p278d.C33091b;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p882b.C42350f;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p882b.C42350f.C42349a;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p883c.C19050a;
import com.tencent.p177mm.plugin.appbrand.appcache.p881a.C10065a.C10066a;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes.C31283e;
import com.tencent.p177mm.plugin.appbrand.launching.C27173m.C27174a;
import com.tencent.p177mm.plugin.appbrand.launching.C27173m.C27174a.C27175a;
import com.tencent.p177mm.plugin.appbrand.launching.C33438y.C33439b;
import com.tencent.p177mm.plugin.appbrand.p328r.C19681j;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.plugin.appbrand.report.C19690c;
import com.tencent.p177mm.plugin.appbrand.task.C45694h;
import com.tencent.p177mm.pointers.PLong;
import com.tencent.p177mm.protocal.protobuf.arc;
import com.tencent.p177mm.protocal.protobuf.cwv;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.VError;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.ah */
abstract class C44701ah extends C42607af<WxaPkgWrappingInfo> implements C27173m {
    final String appId;
    final int cDB;
    private final int gVu;
    final int har;
    final C31283e hhO;
    String hok = null;
    private WxaPkgWrappingInfo iir;

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.ah$b */
    final class C10584b implements Callable<WxaPkgWrappingInfo> {
        private final int iix;

        /* synthetic */ C10584b(C44701ah c44701ah, int i, byte b) {
            this(i);
        }

        public final /* synthetic */ Object call() {
            AppMethodBeat.m2504i(131966);
            WxaPkgWrappingInfo azZ = azZ();
            AppMethodBeat.m2505o(131966);
            return azZ;
        }

        private C10584b(int i) {
            this.iix = i;
        }

        public final WxaPkgWrappingInfo azZ() {
            AppMethodBeat.m2504i(131965);
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final C19681j c19681j = new C19681j();
            C2057a c105821 = new C44702t(C44701ah.this.har) {
                /* Access modifiers changed, original: final */
                public final String aHr() {
                    AppMethodBeat.m2504i(131961);
                    String format = String.format(Locale.US, "NonIncremental %d", new Object[]{Integer.valueOf(C10584b.this.iix)});
                    AppMethodBeat.m2505o(131961);
                    return format;
                }

                /* Access modifiers changed, original: final */
                /* renamed from: d */
                public final void mo6276d(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                    AppMethodBeat.m2504i(131962);
                    c19681j.value = wxaPkgWrappingInfo;
                    countDownLatch.countDown();
                    AppMethodBeat.m2505o(131962);
                }

                /* Access modifiers changed, original: protected|final */
                /* renamed from: b */
                public final void mo22090b(WxaPkgLoadProgress wxaPkgLoadProgress) {
                    AppMethodBeat.m2504i(131963);
                    C4990ab.m7411d("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "hy: onPkgUpdateProgress %s", wxaPkgLoadProgress.toString());
                    if (wxaPkgLoadProgress.progress >= 100) {
                        AppMethodBeat.m2505o(131963);
                        return;
                    }
                    C44701ah.this.onDownloadProgress(wxaPkgLoadProgress.progress);
                    AppMethodBeat.m2505o(131963);
                }
            };
            C4990ab.m7417i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, not incremental before start appId(%s), type(%d), pkgVersion(%d)", C44701ah.this.appId, Integer.valueOf(C44701ah.this.har), Integer.valueOf(this.iix));
            if (C33097a.m54089kR(C44701ah.this.har)) {
                final C31281at a = C42340f.auV().mo60842a(C44701ah.this.appId, C44701ah.this.har, "versionMd5", "downloadURL");
                if (a == null || C5046bo.isNullOrNil(a.field_downloadURL)) {
                    C4990ab.m7413e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, get EMPTY url appId(%s), type(%d), record(%s)", C44701ah.this.appId, Integer.valueOf(C44701ah.this.har), a);
                    C44701ah.this.mo71742a(C19036a.gUJ);
                    AppMethodBeat.m2505o(131965);
                    return null;
                }
                C44701ah.this.hok = a.field_downloadURL;
                if (!C2055az.m4223a(C44701ah.this.appId, C44701ah.this.har, C44701ah.this.hok, c105821, new C10066a() {
                    public final String avJ() {
                        AppMethodBeat.m2504i(131964);
                        String str = "_" + a.field_versionMd5;
                        AppMethodBeat.m2505o(131964);
                        return str;
                    }
                })) {
                    C4990ab.m7413e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, not incremental FATAL ERROR appId(%s), type(%d), pkgVersion(%d)", C44701ah.this.appId, Integer.valueOf(C44701ah.this.har), Integer.valueOf(this.iix));
                    C44701ah.this.mo71742a(C19036a.gUN);
                    AppMethodBeat.m2505o(131965);
                    return null;
                }
            } else if (!C2055az.m4220a(C44701ah.this.appId, C44701ah.this.har, this.iix, C44701ah.this.hhO.him, C44701ah.this.hok, c105821)) {
                C4990ab.m7413e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, not incremental FATAL ERROR appId(%s), type(%d), pkgVersion(%d)", C44701ah.this.appId, Integer.valueOf(C44701ah.this.har), Integer.valueOf(this.iix));
                C44701ah.this.mo71742a(C19036a.gUN);
                AppMethodBeat.m2505o(131965);
                return null;
            }
            try {
                countDownLatch.await();
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckAppPkg", e, "downloadNonIncremental semaphore exp ", new Object[0]);
            }
            WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) c19681j.value;
            AppMethodBeat.m2505o(131965);
            return wxaPkgWrappingInfo;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.ah$c */
    final class C10585c implements Callable<WxaPkgWrappingInfo> {
        private final arc iiu;
        private final int iix;

        /* synthetic */ C10585c(C44701ah c44701ah, int i, arc arc, byte b) {
            this(i, arc);
        }

        private C10585c(int i, arc arc) {
            this.iix = i;
            this.iiu = arc;
        }

        /* Access modifiers changed, original: final */
        public final WxaPkgWrappingInfo aHA() {
            AppMethodBeat.m2504i(131968);
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final C19681j c19681j = new C19681j();
            if (C10089bd.m17684a(this.iiu.wuP, C44701ah.this.appId, this.iix, 0, new C44702t(C44701ah.this.har) {
                /* Access modifiers changed, original: final */
                public final String aHr() {
                    return "Zstd";
                }

                /* Access modifiers changed, original: final */
                /* renamed from: d */
                public final void mo6276d(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                    AppMethodBeat.m2504i(131967);
                    c19681j.value = wxaPkgWrappingInfo;
                    countDownLatch.countDown();
                    AppMethodBeat.m2505o(131967);
                }
            })) {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    C4990ab.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckAppPkg", e, "doZstdJob semaphore exp ", new Object[0]);
                }
                WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) c19681j.value;
                AppMethodBeat.m2505o(131968);
                return wxaPkgWrappingInfo;
            }
            AppMethodBeat.m2505o(131968);
            return null;
        }

        public final /* synthetic */ Object call() {
            AppMethodBeat.m2504i(131969);
            WxaPkgWrappingInfo aHA = aHA();
            AppMethodBeat.m2505o(131969);
            return aHA;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.ah$a */
    final class C27160a implements Callable<WxaPkgWrappingInfo> {
        private final int iis;
        private final int iit;
        private final arc iiu;

        /* synthetic */ C27160a(C44701ah c44701ah, int i, int i2, arc arc, byte b) {
            this(i, i2, arc);
        }

        private C27160a(int i, int i2, arc arc) {
            this.iis = i;
            this.iit = i2;
            this.iiu = arc;
        }

        private WxaPkgWrappingInfo aHz() {
            AppMethodBeat.m2504i(131959);
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final C19681j c19681j = new C19681j();
            if (C19063p.m29630a(C44701ah.this.appId, this.iis, this.iit, this.iiu.cDL, new C44702t(C44701ah.this.har) {
                /* Access modifiers changed, original: final */
                public final String aHr() {
                    AppMethodBeat.m2504i(131957);
                    String format = String.format(Locale.US, "Incremental %d|%d", new Object[]{Integer.valueOf(C27160a.this.iis), Integer.valueOf(C27160a.this.iit)});
                    AppMethodBeat.m2505o(131957);
                    return format;
                }

                /* Access modifiers changed, original: final */
                /* renamed from: d */
                public final void mo6276d(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                    AppMethodBeat.m2504i(131958);
                    c19681j.value = wxaPkgWrappingInfo;
                    countDownLatch.countDown();
                    AppMethodBeat.m2505o(131958);
                }
            })) {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    C4990ab.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckAppPkg", e, "downloadIncremental semaphore exp ", new Object[0]);
                }
                WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) c19681j.value;
                AppMethodBeat.m2505o(131959);
                return wxaPkgWrappingInfo;
            }
            AppMethodBeat.m2505o(131959);
            return null;
        }

        public final /* synthetic */ Object call() {
            AppMethodBeat.m2504i(131960);
            Object aHz;
            if (!C5046bo.isNullOrNil(this.iiu.cDL) && C19071r.avD()) {
                aHz = aHz();
                AppMethodBeat.m2505o(131960);
                return aHz;
            } else if (C5046bo.isNullOrNil(this.iiu.wuP)) {
                WxaPkgWrappingInfo azZ = new C10584b(C44701ah.this, this.iit, (byte) 0).azZ();
                AppMethodBeat.m2505o(131960);
                return azZ;
            } else {
                aHz = new C10585c(C44701ah.this, this.iit, this.iiu, (byte) 0).aHA();
                AppMethodBeat.m2505o(131960);
                return aHz;
            }
        }
    }

    public /* synthetic */ Object call() {
        return azZ();
    }

    C44701ah(String str, int i, int i2, int i3, C31283e c31283e) {
        this.appId = str;
        this.har = i;
        this.gVu = i2;
        this.cDB = i3;
        this.hhO = c31283e;
    }

    public void aHe() {
    }

    public void aHj() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x01dd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private WxaPkgWrappingInfo azZ() {
        Pair v = C19035as.m29615v(this.appId, this.har, this.gVu);
        if (v.second != null) {
            C4990ab.m7417i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "call, using existing pkg with appId(%s) versionType(%d) pkgVersion(%d)", this.appId, Integer.valueOf(this.har), Integer.valueOf(this.gVu));
            try {
                ((C2058a) C42340f.m74878E(C2058a.class)).mo5823ay(this.appId, this.gVu);
            } catch (Throwable th) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckAppPkg", th, "checkReportOnLocalPkgFound, appId[%s], version[%d]", this.appId, Integer.valueOf(this.gVu));
            }
            return (WxaPkgWrappingInfo) v.second;
        }
        String str;
        Pair v2;
        try {
            C2058a c2058a = (C2058a) C42340f.m74878E(C2058a.class);
            str = this.appId;
            int i = this.gVu;
            C33091b c33091b = new C33091b();
            c33091b.field_appId = str;
            c33091b.field_version = i;
            boolean b = c2058a.mo10102b(c33091b, new String[0]);
            c33091b.field_hitCount++;
            if (b) {
                c2058a.mo10103c(c33091b, new String[0]);
            } else {
                c2058a.mo10101b((C4925c) c33091b);
            }
        } catch (Throwable th2) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckAppPkg", th2, "increaseHitCount, appId[%s], version[%d]", this.appId, Integer.valueOf(this.gVu));
        }
        if (C33097a.m54090np(this.har)) {
            C41220ae s = ((C42346af) C42340f.m74878E(C42346af.class)).mo67860s(this.appId, 1, this.gVu);
            if (s != null) {
                PLong pLong = new PLong();
                C4990ab.m7417i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "decrypt ret %b, with appId(%s) version(%d)", Boolean.valueOf(C42350f.m74898a(s, C42349a.WXA_LAUNCH, pLong)), this.appId, Integer.valueOf(this.gVu));
                if (C42350f.m74898a(s, C42349a.WXA_LAUNCH, pLong)) {
                    v2 = C19035as.m29615v(this.appId, this.har, this.gVu);
                    C19050a c19050a;
                    if (v2.second != null) {
                        c19050a = C19050a.gWl;
                        C19050a.m29623z(pLong.value, 180);
                        return (WxaPkgWrappingInfo) v2.second;
                    }
                    c19050a = C19050a.gWl;
                    C19050a.m29623z(pLong.value, 181);
                    if (C19036a.gUJ.equals(v2.first)) {
                        C4990ab.m7413e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "call, manifest NULL, appId(%s) type(%d) version(%d)", this.appId, Integer.valueOf(this.har), Integer.valueOf(this.gVu));
                        C42340f.auV().mo60849a(this.appId, this.hhO);
                        if (C42340f.auV().mo60841a(this.appId, this.gVu, this.har, new String[0]) == null) {
                            C4990ab.m7413e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "call, insert manifest fail again!!! appId(%s) type(%d) version(%d)", this.appId, Integer.valueOf(this.har), Integer.valueOf(this.gVu));
                        } else {
                            v2 = Pair.create(C19036a.gUM, null);
                        }
                    }
                    if (C19036a.gUM.equals(v2.first)) {
                        if (this.har == 0) {
                            this.iir = C19573h.m30345bm(this.appId, 1);
                            WxaPkgWrappingInfo c;
                            try {
                                C31281at a = C42340f.auV().mo60842a(this.appId, 0, "version", "versionMd5", "versionState");
                                if (a == null) {
                                    throw new C27175a().mo44848n(C42677e.getMMString(C25738R.string.f9011md, C38114b.m64485no(this.har)), new Object[0]).mo44849o("get NULL record with md5", new Object[0]).aHl();
                                }
                                long anU = C5046bo.anU();
                                int i2 = a.field_version;
                                int i3 = this.iir == null ? 0 : this.iir.gVu;
                                C37441a a2 = C8920x.m16081a(new C33094d(this.appId, a.field_version, a.field_versionMd5, 0, i3));
                                String str2;
                                if (a2 != null && a2.errType == 0 && a2.errCode == 0) {
                                    C33438y.m54643a(C33439b.GET_DOWNLOAD_URL, this.appId, i2, this.har, this.cDB, C5046bo.anU() - anU);
                                    if (C5046bo.isNullOrNil(((arc) a2.fsy).url)) {
                                        throw new C27175a().mo44849o("CgiGetDownloadURL return EMPTY url, ret = %d", Integer.valueOf(((arc) a2.fsy).ret)).aHl();
                                    }
                                    cwv cwv = new cwv();
                                    str2 = ((arc) a2.fsy).url;
                                    this.hok = str2;
                                    cwv.xsy = str2;
                                    cwv.vMG = a.field_version;
                                    cwv.xsw = a.field_versionState;
                                    cwv.xsx = a.field_versionMd5;
                                    C42340f.auV().mo60850a(this.appId, cwv, 0);
                                    if (this.hhO.him > 0) {
                                        long anU2 = C5046bo.anU();
                                        C33100b gg = C33098x.m54094gg((long) this.hhO.him);
                                        anU2 = C5046bo.anU() - anU2;
                                        C4990ab.m7411d("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "trimOff %d, cost %d, result %s", Integer.valueOf(this.hhO.him), Long.valueOf(anU2), gg.name());
                                    }
                                    c = m81338c(new C27160a(this, i3, i2, (arc) a2.fsy, (byte) 0));
                                    if (c != null) {
                                        return c;
                                    }
                                    throw new C27175a().mo44849o("Download Fail", new Object[0]).aHl();
                                }
                                if (a2 == null || a2.errCode != VError.ERROR_FACE_TXT_INIT) {
                                    Object[] objArr = new Object[2];
                                    objArr[0] = Integer.valueOf(a2 == null ? -1 : a2.errType);
                                    objArr[1] = Integer.valueOf(a2 == null ? -1 : a2.errCode);
                                    str = C42608ag.getMMString(C25738R.string.f9006m8, objArr);
                                } else {
                                    str = C42608ag.getMMString(C25738R.string.f9008m_, new Object[0]);
                                }
                                C27175a c27175a = new C27175a();
                                String str3 = "fail get download url, resp %s";
                                Object[] objArr2 = new Object[1];
                                if (a2 == null) {
                                    str2 = null;
                                } else {
                                    str2 = String.format(Locale.US, "(%d, %d)", new Object[]{Integer.valueOf(a2.errType), Integer.valueOf(a2.errCode)});
                                }
                                objArr2[0] = str2;
                                throw c27175a.mo44849o(str3, objArr2).mo44848n(str, new Object[0]).aHl();
                            } catch (C27174a e) {
                                C27174a c27174a = e;
                                C4990ab.m7413e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "release_pkg APP_BROKEN obtain appId %s, message %s", this.appId, c27174a.getMessage());
                                if (this.gVu <= 0) {
                                    c = C19573h.m30345bm(this.appId, 1);
                                    if (c != null) {
                                        return c;
                                    }
                                }
                                if (!C5046bo.isNullOrNil(c27174a.ihb)) {
                                    C42608ag.m75434Ck(c27174a.ihb);
                                }
                                return null;
                            }
                        }
                        WxaPkgWrappingInfo c2 = m81338c(new C10584b(this, 0, (byte) 0));
                        if (c2 != null) {
                            return c2;
                        }
                    }
                    mo71742a((C19036a) v2.first);
                    return null;
                }
            }
        }
        v2 = v;
        if (C19036a.gUJ.equals(v2.first)) {
        }
        if (C19036a.gUM.equals(v2.first)) {
        }
        mo71742a((C19036a) v2.first);
        return null;
    }

    /* renamed from: c */
    private WxaPkgWrappingInfo m81338c(Callable<WxaPkgWrappingInfo> callable) {
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
    /* renamed from: a */
    public final void mo71742a(C19036a c19036a) {
        int i = C25738R.string.f8953km;
        if (C19036a.gUJ.equals(c19036a)) {
            String mMString;
            if (this.har == 1) {
                mMString = C42677e.getMMString(C25738R.string.f8953km, new Object[0]);
            } else {
                mMString = C42677e.getMMString(C25738R.string.f9011md, C38114b.m64485no(this.har));
            }
            if (this.har == 1) {
                C45694h.m84422bt(this.appId, this.har);
                C19690c.m30494K(this.appId, 10, this.har + 1);
            }
            C42608ag.m75434Ck(mMString);
        } else if (C19036a.gUL.equals(c19036a) || C19036a.gUK.equals(c19036a)) {
            if (this.har == 0) {
                i = C25738R.string.f8956kp;
            }
            C42608ag.m75435oZ(i);
            if (this.har == 1) {
                C19690c.m30494K(this.appId, 10, this.har + 1);
            }
            C45694h.m84422bt(this.appId, this.har);
        } else {
            C42608ag.m75434Ck(C42677e.getMMString(C25738R.string.f9009ma, Integer.valueOf(1), Integer.valueOf(c19036a.awj())));
        }
    }

    /* Access modifiers changed, original: final */
    public final String getTag() {
        return "MicroMsg.AppBrand.PrepareStepCheckAppPkg";
    }
}
