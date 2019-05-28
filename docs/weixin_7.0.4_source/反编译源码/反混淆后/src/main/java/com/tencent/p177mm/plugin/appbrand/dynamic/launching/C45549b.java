package com.tencent.p177mm.plugin.appbrand.dynamic.launching;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelappbrand.C18652u;
import com.tencent.p177mm.modelappbrand.C26439v;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p183ai.C8920x;
import com.tencent.p177mm.p230g.p232b.p233a.C26273ad;
import com.tencent.p177mm.plugin.appbrand.appcache.C10089bd;
import com.tencent.p177mm.plugin.appbrand.appcache.C19035as;
import com.tencent.p177mm.plugin.appbrand.appcache.C19035as.C19036a;
import com.tencent.p177mm.plugin.appbrand.appcache.C2055az;
import com.tencent.p177mm.plugin.appbrand.appcache.C2055az.C2056b;
import com.tencent.p177mm.plugin.appbrand.appcache.C2055az.C2057a;
import com.tencent.p177mm.plugin.appbrand.appcache.C31281at;
import com.tencent.p177mm.plugin.appbrand.appcache.C33094d;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.p177mm.plugin.appbrand.appcache.p881a.C26735b.C26734a.C10067a;
import com.tencent.p177mm.plugin.appbrand.dynamic.C10211f.C10213a;
import com.tencent.p177mm.plugin.appbrand.dynamic.C33164i;
import com.tencent.p177mm.plugin.appbrand.dynamic.C38203j;
import com.tencent.p177mm.plugin.appbrand.p1468a.C33065d;
import com.tencent.p177mm.plugin.appbrand.p328r.C19681j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.arc;
import com.tencent.p177mm.protocal.protobuf.cwv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.rtmp.TXLiveConstants;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.launching.b */
public final class C45549b implements Callable<WxaPkgWrappingInfo> {
    public static int hoi = 0;
    public static int hoj = 1;
    final String appId;
    final int cBc;
    volatile int gVu;
    String hlm;
    int hog;
    volatile String hok;
    String hol;
    /* renamed from: id */
    final String f17883id;

    public final /* synthetic */ Object call() {
        AppMethodBeat.m2504i(10923);
        WxaPkgWrappingInfo azZ = azZ();
        AppMethodBeat.m2505o(10923);
        return azZ;
    }

    public C45549b(String str, String str2, String str3, int i, int i2, int i3, String str4) {
        this(str, str2, str3, i, i2, i3, str4, "");
    }

    public C45549b(String str, String str2, String str3, int i, int i2, int i3, String str4, String str5) {
        this.f17883id = str;
        this.appId = str2;
        this.cBc = i;
        this.gVu = i2;
        this.hok = str4;
        this.hog = i3;
        this.hlm = str3;
        this.hol = str5;
    }

    public final WxaPkgWrappingInfo azZ() {
        int i = 1;
        AppMethodBeat.m2504i(10920);
        Pair v = C19035as.m29615v(this.appId, this.cBc, this.gVu);
        WxaPkgWrappingInfo wxaPkgWrappingInfo;
        if (v.second != null) {
            C38203j.azE().mo60939ba(this.appId, 29);
            wxaPkgWrappingInfo = (WxaPkgWrappingInfo) v.second;
            AppMethodBeat.m2505o(10920);
            return wxaPkgWrappingInfo;
        }
        int i2;
        C38203j.azE().mo60939ba(this.appId, 3);
        if (C19036a.gUM.equals(v.first)) {
            String str;
            C18652u.m29151i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "pkg broken appid %s, pkgType %d, pkgVersion %d", this.appId, Integer.valueOf(this.cBc), Integer.valueOf(this.gVu));
            if (this.cBc == 10002 || this.cBc == 10102) {
                C31281at a = ((C33065d) C1720g.m3528K(C33065d.class)).mo53635xF().mo60842a(this.appId, this.cBc, "version", "versionMd5", "versionState");
                if (a == null) {
                    C18652u.m29151i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "pkgRecord is null", new Object[0]);
                    C45549b.m84002a((C19036a) v.first);
                    AppMethodBeat.m2505o(10920);
                    return null;
                }
                arc arc;
                arc arc2;
                if (this.cBc == 10102) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                C26439v.m42099kT(4);
                C26273ad eZ = new C26273ad().mo43951eZ(this.appId);
                eZ.cYw = (long) C18652u.m29153pq(this.f17883id);
                eZ.cYs = 13;
                eZ = eZ.mo43950eY(this.f17883id);
                eZ.cYt = System.currentTimeMillis();
                eZ.cYu = 2;
                eZ.mo43952fa(C5023at.m7471gB(C4996ah.getContext())).ajK();
                if (TextUtils.isEmpty(this.hol)) {
                    arc = null;
                } else {
                    arc = new arc();
                    arc.parseFrom(Base64.decode(this.hol, 0));
                    if (TextUtils.isEmpty(arc.url)) {
                        arc = null;
                    } else {
                        C18652u.m29151i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "use preload download data", new Object[0]);
                    }
                }
                if (arc == null) {
                    C37441a a2 = C8920x.m16081a(new C33094d(this.appId, a.field_version, a.field_versionMd5, i2));
                    if (a2 != null && a2.errType == 0 && a2.errCode == 0) {
                        arc2 = (arc) a2.fsy;
                    } else {
                        C26439v.m42099kT(6);
                        C26273ad eZ2 = new C26273ad().mo43951eZ(this.appId);
                        eZ2.cYw = (long) C18652u.m29153pq(this.f17883id);
                        eZ2.cYs = 3;
                        eZ2 = eZ2.mo43950eY(this.f17883id);
                        eZ2.cYt = System.currentTimeMillis();
                        eZ2.cYu = 2;
                        eZ2.mo43952fa(C5023at.m7471gB(C4996ah.getContext())).ajK();
                        if (this.hog == 1 && this.f17883id != null && this.f17883id.length() > 0) {
                            Bundle bundle = new Bundle();
                            bundle.putString("id", this.f17883id);
                            bundle.putInt("widgetState", TXLiveConstants.PLAY_WARNING_VIDEO_PLAY_LAG);
                            C9549f.m17012a(C33164i.azC().mo53694zV(this.f17883id), bundle, C10213a.class, null);
                        }
                        C18652u.m29151i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "get widget download url fail", new Object[0]);
                        AppMethodBeat.m2505o(10920);
                        return null;
                    }
                }
                arc2 = arc;
                if (arc2 == null) {
                    AppMethodBeat.m2505o(10920);
                    return null;
                }
                eZ = new C26273ad().mo43951eZ(C18652u.m29154pr(this.f17883id));
                eZ.cYw = (long) C18652u.m29153pq(this.f17883id);
                eZ.cYs = 3;
                eZ = eZ.mo43950eY(this.f17883id);
                eZ.cYt = System.currentTimeMillis();
                eZ.cYu = 1;
                eZ.mo43952fa(C5023at.m7471gB(C4996ah.getContext())).ajK();
                String str2 = arc2.wuP;
                C26439v.m42099kT(5);
                C18652u.m29151i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "get widget downlonad info succ", new Object[0]);
                if (C5046bo.isNullOrNil(arc2.url)) {
                    C18652u.m29151i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "get widget download url fail, reason url empty", new Object[0]);
                    AppMethodBeat.m2505o(10920);
                    return null;
                }
                cwv cwv = new cwv();
                str = arc2.url;
                this.hok = str;
                cwv.xsy = str;
                i2 = a.field_version;
                this.gVu = i2;
                cwv.vMG = i2;
                cwv.xsw = a.field_versionState;
                cwv.xsx = a.field_versionMd5;
                ((C33065d) C1720g.m3528K(C33065d.class)).mo53635xF().mo60850a(this.appId, cwv, this.cBc);
                str = str2;
            } else {
                str = null;
            }
            wxaPkgWrappingInfo = m84001Aj(str);
            if (wxaPkgWrappingInfo != null) {
                if (this.hog == 1) {
                    C7060h.pYm.mo8381e(14452, this.hlm + "-" + this.appId, Integer.valueOf(7), Long.valueOf(System.currentTimeMillis()));
                }
                AppMethodBeat.m2505o(10920);
                return wxaPkgWrappingInfo;
            } else if (this.hog == 1) {
                C7060h.pYm.mo8381e(14452, this.hlm + "-" + this.appId, Integer.valueOf(8), Long.valueOf(System.currentTimeMillis()));
            }
        } else if (!C19036a.gUI.equals(v.first)) {
            C4990ab.m7413e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "WxaPkgIntegrityChecker.checkPkg  appid %s, pkgType %d,pkgVersion %d return %d", this.appId, Integer.valueOf(this.cBc), Integer.valueOf(this.gVu), Integer.valueOf(((C19036a) v.first).awj()));
        }
        if (this.cBc == 10002 || this.cBc == 10102) {
            int[] xF = ((C33065d) C1720g.m3528K(C33065d.class)).mo53635xF().mo60866xF(this.appId);
            if (xF != null && xF.length > 1) {
                while (true) {
                    i2 = i + 1;
                    Pair v2 = C19035as.m29615v(this.appId, this.cBc, xF[i]);
                    if (v2 != null && v2.first == C19036a.gUI && v2.second != null) {
                        wxaPkgWrappingInfo = (WxaPkgWrappingInfo) v2.second;
                        AppMethodBeat.m2505o(10920);
                        return wxaPkgWrappingInfo;
                    } else if (i2 >= xF.length) {
                        break;
                    } else {
                        i = i2;
                    }
                }
            }
        }
        C45549b.m84002a((C19036a) v.first);
        AppMethodBeat.m2505o(10920);
        return null;
    }

    /* renamed from: Aj */
    private WxaPkgWrappingInfo m84001Aj(String str) {
        AppMethodBeat.m2504i(10921);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final C19681j c19681j = new C19681j();
        C2057a c446941 = new C2057a() {
            /* renamed from: a */
            public final /* synthetic */ void mo14965a(String str, C10067a c10067a, Object obj) {
                AppMethodBeat.m2504i(10919);
                C2056b c2056b = (C2056b) obj;
                C18652u.m29151i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "onPkgUpdateResult, appId = %s, return = %s", str, c10067a.name());
                C26273ad eZ;
                if (C10067a.OK.equals(c10067a)) {
                    WxaPkgWrappingInfo xM = WxaPkgWrappingInfo.m54056xM(c2056b.filePath);
                    if (xM == null) {
                        C18652u.m29150e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "onPkgUpdateResult, ret=OK but obtain null appPkgInfo", new Object[0]);
                    } else {
                        xM.gVu = c2056b.version;
                        xM.gVv = C5046bo.anT();
                        xM.gVt = c2056b.gVs;
                        c19681j.value = xM;
                    }
                    C26439v.m42099kT(8);
                    eZ = new C26273ad().mo43951eZ(C18652u.m29154pr(C45549b.this.f17883id));
                    eZ.cYw = (long) C18652u.m29153pq(C45549b.this.f17883id);
                    eZ.cYs = 4;
                    eZ = eZ.mo43950eY(C45549b.this.f17883id);
                    eZ.cYt = System.currentTimeMillis();
                    eZ.cYu = 1;
                    eZ.mo43952fa(C5023at.m7471gB(C4996ah.getContext())).ajK();
                } else if (C10067a.SEVER_FILE_NOT_FOUND.equals(c10067a)) {
                    C26439v.m42099kT(9);
                    eZ = new C26273ad().mo43951eZ(C18652u.m29154pr(C45549b.this.f17883id));
                    eZ.cYw = (long) C18652u.m29153pq(C45549b.this.f17883id);
                    eZ.cYs = 4;
                    eZ = eZ.mo43950eY(C45549b.this.f17883id);
                    eZ.cYt = System.currentTimeMillis();
                    eZ.cYu = 2;
                    eZ.mo43952fa(C5023at.m7471gB(C4996ah.getContext())).ajK();
                } else {
                    C26439v.m42099kT(9);
                    eZ = new C26273ad().mo43951eZ(C18652u.m29154pr(C45549b.this.f17883id));
                    eZ.cYw = (long) C18652u.m29153pq(C45549b.this.f17883id);
                    eZ.cYs = 4;
                    eZ = eZ.mo43950eY(C45549b.this.f17883id);
                    eZ.cYt = System.currentTimeMillis();
                    eZ.cYu = 2;
                    eZ.mo43952fa(C5023at.m7471gB(C4996ah.getContext())).ajK();
                }
                countDownLatch.countDown();
                AppMethodBeat.m2505o(10919);
            }

            /* renamed from: bl */
            public final /* bridge */ /* synthetic */ void mo14966bl(Object obj) {
            }
        };
        C26439v.m42099kT(7);
        if (this.cBc == 10002 || this.cBc == 10102) {
            boolean b;
            C18652u.m29151i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, debug type is release, start download appId(%s), pkgVersion(%d)", this.appId, Integer.valueOf(this.gVu));
            if (C5046bo.isNullOrNil(str)) {
                b = C2055az.m4224b(this.appId, this.cBc, this.gVu, this.hok, c446941);
            } else {
                b = C10089bd.m17684a(str, this.appId, this.gVu, this.cBc, c446941);
            }
            if (!b) {
                C26439v.m42099kT(9);
                C26273ad eZ = new C26273ad().mo43951eZ(C18652u.m29154pr(this.f17883id));
                eZ.cYw = (long) C18652u.m29153pq(this.f17883id);
                eZ.cYs = 4;
                eZ = eZ.mo43950eY(this.f17883id);
                eZ.cYt = System.currentTimeMillis();
                eZ.cYu = 2;
                eZ.mo43952fa(C5023at.m7471gB(C4996ah.getContext())).ajK();
                C45549b.m84002a(C19036a.gUN);
                AppMethodBeat.m2505o(10921);
                return null;
            }
        }
        C18652u.m29151i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, appId = %s, debug type is %d", this.appId, Integer.valueOf(this.cBc));
        if (((C33065d) C1720g.m3528K(C33065d.class)).mo53635xF() == null) {
            C4990ab.m7412e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, null storage");
            C45549b.m84002a(C19036a.gUN);
            AppMethodBeat.m2505o(10921);
            return null;
        }
        String at = ((C33065d) C1720g.m3528K(C33065d.class)).mo53635xF().mo60852at(this.appId, this.cBc);
        if (C5046bo.isNullOrNil(at)) {
            C18652u.m29150e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, url is null or nil", new Object[0]);
            C45549b.m84002a(C19036a.gUJ);
            AppMethodBeat.m2505o(10921);
            return null;
        }
        C2055az.m4222a(this.appId, this.cBc, at, c446941);
        try {
            countDownLatch.await();
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", e, "tryDownload semaphore exp ", new Object[0]);
        }
        WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) c19681j.value;
        AppMethodBeat.m2505o(10921);
        return wxaPkgWrappingInfo;
    }

    /* renamed from: a */
    private static void m84002a(C19036a c19036a) {
        AppMethodBeat.m2504i(10922);
        C18652u.m29151i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "pkgRecordError %s", c19036a.toString());
        if (C19036a.gUJ.equals(c19036a)) {
            AppMethodBeat.m2505o(10922);
        } else if (C19036a.gUL.equals(c19036a) || C19036a.gUK.equals(c19036a)) {
            AppMethodBeat.m2505o(10922);
        } else {
            AppMethodBeat.m2505o(10922);
        }
    }
}
