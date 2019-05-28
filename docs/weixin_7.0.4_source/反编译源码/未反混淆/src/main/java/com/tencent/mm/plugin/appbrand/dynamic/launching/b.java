package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.x;
import com.tencent.mm.g.b.a.ad;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.as;
import com.tencent.mm.plugin.appbrand.appcache.as.a;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appcache.az;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.dynamic.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.arc;
import com.tencent.mm.protocal.protobuf.cwv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.rtmp.TXLiveConstants;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public final class b implements Callable<WxaPkgWrappingInfo> {
    public static int hoi = 0;
    public static int hoj = 1;
    final String appId;
    final int cBc;
    volatile int gVu;
    String hlm;
    int hog;
    volatile String hok;
    String hol;
    final String id;

    public final /* synthetic */ Object call() {
        AppMethodBeat.i(10923);
        WxaPkgWrappingInfo azZ = azZ();
        AppMethodBeat.o(10923);
        return azZ;
    }

    public b(String str, String str2, String str3, int i, int i2, int i3, String str4) {
        this(str, str2, str3, i, i2, i3, str4, "");
    }

    public b(String str, String str2, String str3, int i, int i2, int i3, String str4, String str5) {
        this.id = str;
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
        AppMethodBeat.i(10920);
        Pair v = as.v(this.appId, this.cBc, this.gVu);
        WxaPkgWrappingInfo wxaPkgWrappingInfo;
        if (v.second != null) {
            j.azE().ba(this.appId, 29);
            wxaPkgWrappingInfo = (WxaPkgWrappingInfo) v.second;
            AppMethodBeat.o(10920);
            return wxaPkgWrappingInfo;
        }
        int i2;
        j.azE().ba(this.appId, 3);
        if (a.gUM.equals(v.first)) {
            String str;
            u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "pkg broken appid %s, pkgType %d, pkgVersion %d", this.appId, Integer.valueOf(this.cBc), Integer.valueOf(this.gVu));
            if (this.cBc == 10002 || this.cBc == 10102) {
                at a = ((d) g.K(d.class)).xF().a(this.appId, this.cBc, "version", "versionMd5", "versionState");
                if (a == null) {
                    u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "pkgRecord is null", new Object[0]);
                    a((a) v.first);
                    AppMethodBeat.o(10920);
                    return null;
                }
                arc arc;
                arc arc2;
                if (this.cBc == 10102) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                v.kT(4);
                ad eZ = new ad().eZ(this.appId);
                eZ.cYw = (long) u.pq(this.id);
                eZ.cYs = 13;
                eZ = eZ.eY(this.id);
                eZ.cYt = System.currentTimeMillis();
                eZ.cYu = 2;
                eZ.fa(com.tencent.mm.sdk.platformtools.at.gB(ah.getContext())).ajK();
                if (TextUtils.isEmpty(this.hol)) {
                    arc = null;
                } else {
                    arc = new arc();
                    arc.parseFrom(Base64.decode(this.hol, 0));
                    if (TextUtils.isEmpty(arc.url)) {
                        arc = null;
                    } else {
                        u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "use preload download data", new Object[0]);
                    }
                }
                if (arc == null) {
                    com.tencent.mm.ai.a.a a2 = x.a(new com.tencent.mm.plugin.appbrand.appcache.d(this.appId, a.field_version, a.field_versionMd5, i2));
                    if (a2 != null && a2.errType == 0 && a2.errCode == 0) {
                        arc2 = (arc) a2.fsy;
                    } else {
                        v.kT(6);
                        ad eZ2 = new ad().eZ(this.appId);
                        eZ2.cYw = (long) u.pq(this.id);
                        eZ2.cYs = 3;
                        eZ2 = eZ2.eY(this.id);
                        eZ2.cYt = System.currentTimeMillis();
                        eZ2.cYu = 2;
                        eZ2.fa(com.tencent.mm.sdk.platformtools.at.gB(ah.getContext())).ajK();
                        if (this.hog == 1 && this.id != null && this.id.length() > 0) {
                            Bundle bundle = new Bundle();
                            bundle.putString("id", this.id);
                            bundle.putInt("widgetState", TXLiveConstants.PLAY_WARNING_VIDEO_PLAY_LAG);
                            f.a(i.azC().zV(this.id), bundle, com.tencent.mm.plugin.appbrand.dynamic.f.a.class, null);
                        }
                        u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "get widget download url fail", new Object[0]);
                        AppMethodBeat.o(10920);
                        return null;
                    }
                }
                arc2 = arc;
                if (arc2 == null) {
                    AppMethodBeat.o(10920);
                    return null;
                }
                eZ = new ad().eZ(u.pr(this.id));
                eZ.cYw = (long) u.pq(this.id);
                eZ.cYs = 3;
                eZ = eZ.eY(this.id);
                eZ.cYt = System.currentTimeMillis();
                eZ.cYu = 1;
                eZ.fa(com.tencent.mm.sdk.platformtools.at.gB(ah.getContext())).ajK();
                String str2 = arc2.wuP;
                v.kT(5);
                u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "get widget downlonad info succ", new Object[0]);
                if (bo.isNullOrNil(arc2.url)) {
                    u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "get widget download url fail, reason url empty", new Object[0]);
                    AppMethodBeat.o(10920);
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
                ((d) g.K(d.class)).xF().a(this.appId, cwv, this.cBc);
                str = str2;
            } else {
                str = null;
            }
            wxaPkgWrappingInfo = Aj(str);
            if (wxaPkgWrappingInfo != null) {
                if (this.hog == 1) {
                    h.pYm.e(14452, this.hlm + "-" + this.appId, Integer.valueOf(7), Long.valueOf(System.currentTimeMillis()));
                }
                AppMethodBeat.o(10920);
                return wxaPkgWrappingInfo;
            } else if (this.hog == 1) {
                h.pYm.e(14452, this.hlm + "-" + this.appId, Integer.valueOf(8), Long.valueOf(System.currentTimeMillis()));
            }
        } else if (!a.gUI.equals(v.first)) {
            ab.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "WxaPkgIntegrityChecker.checkPkg  appid %s, pkgType %d,pkgVersion %d return %d", this.appId, Integer.valueOf(this.cBc), Integer.valueOf(this.gVu), Integer.valueOf(((a) v.first).awj()));
        }
        if (this.cBc == 10002 || this.cBc == 10102) {
            int[] xF = ((d) g.K(d.class)).xF().xF(this.appId);
            if (xF != null && xF.length > 1) {
                while (true) {
                    i2 = i + 1;
                    Pair v2 = as.v(this.appId, this.cBc, xF[i]);
                    if (v2 != null && v2.first == a.gUI && v2.second != null) {
                        wxaPkgWrappingInfo = (WxaPkgWrappingInfo) v2.second;
                        AppMethodBeat.o(10920);
                        return wxaPkgWrappingInfo;
                    } else if (i2 >= xF.length) {
                        break;
                    } else {
                        i = i2;
                    }
                }
            }
        }
        a((a) v.first);
        AppMethodBeat.o(10920);
        return null;
    }

    private WxaPkgWrappingInfo Aj(String str) {
        AppMethodBeat.i(10921);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final com.tencent.mm.plugin.appbrand.r.j jVar = new com.tencent.mm.plugin.appbrand.r.j();
        az.a anonymousClass1 = new az.a() {
            public final /* synthetic */ void a(String str, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a aVar, Object obj) {
                AppMethodBeat.i(10919);
                com.tencent.mm.plugin.appbrand.appcache.az.b bVar = (com.tencent.mm.plugin.appbrand.appcache.az.b) obj;
                u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "onPkgUpdateResult, appId = %s, return = %s", str, aVar.name());
                ad eZ;
                if (com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.OK.equals(aVar)) {
                    WxaPkgWrappingInfo xM = WxaPkgWrappingInfo.xM(bVar.filePath);
                    if (xM == null) {
                        u.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "onPkgUpdateResult, ret=OK but obtain null appPkgInfo", new Object[0]);
                    } else {
                        xM.gVu = bVar.version;
                        xM.gVv = bo.anT();
                        xM.gVt = bVar.gVs;
                        jVar.value = xM;
                    }
                    v.kT(8);
                    eZ = new ad().eZ(u.pr(b.this.id));
                    eZ.cYw = (long) u.pq(b.this.id);
                    eZ.cYs = 4;
                    eZ = eZ.eY(b.this.id);
                    eZ.cYt = System.currentTimeMillis();
                    eZ.cYu = 1;
                    eZ.fa(com.tencent.mm.sdk.platformtools.at.gB(ah.getContext())).ajK();
                } else if (com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.SEVER_FILE_NOT_FOUND.equals(aVar)) {
                    v.kT(9);
                    eZ = new ad().eZ(u.pr(b.this.id));
                    eZ.cYw = (long) u.pq(b.this.id);
                    eZ.cYs = 4;
                    eZ = eZ.eY(b.this.id);
                    eZ.cYt = System.currentTimeMillis();
                    eZ.cYu = 2;
                    eZ.fa(com.tencent.mm.sdk.platformtools.at.gB(ah.getContext())).ajK();
                } else {
                    v.kT(9);
                    eZ = new ad().eZ(u.pr(b.this.id));
                    eZ.cYw = (long) u.pq(b.this.id);
                    eZ.cYs = 4;
                    eZ = eZ.eY(b.this.id);
                    eZ.cYt = System.currentTimeMillis();
                    eZ.cYu = 2;
                    eZ.fa(com.tencent.mm.sdk.platformtools.at.gB(ah.getContext())).ajK();
                }
                countDownLatch.countDown();
                AppMethodBeat.o(10919);
            }

            public final /* bridge */ /* synthetic */ void bl(Object obj) {
            }
        };
        v.kT(7);
        if (this.cBc == 10002 || this.cBc == 10102) {
            boolean b;
            u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, debug type is release, start download appId(%s), pkgVersion(%d)", this.appId, Integer.valueOf(this.gVu));
            if (bo.isNullOrNil(str)) {
                b = az.b(this.appId, this.cBc, this.gVu, this.hok, anonymousClass1);
            } else {
                b = bd.a(str, this.appId, this.gVu, this.cBc, anonymousClass1);
            }
            if (!b) {
                v.kT(9);
                ad eZ = new ad().eZ(u.pr(this.id));
                eZ.cYw = (long) u.pq(this.id);
                eZ.cYs = 4;
                eZ = eZ.eY(this.id);
                eZ.cYt = System.currentTimeMillis();
                eZ.cYu = 2;
                eZ.fa(com.tencent.mm.sdk.platformtools.at.gB(ah.getContext())).ajK();
                a(a.gUN);
                AppMethodBeat.o(10921);
                return null;
            }
        }
        u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, appId = %s, debug type is %d", this.appId, Integer.valueOf(this.cBc));
        if (((d) g.K(d.class)).xF() == null) {
            ab.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, null storage");
            a(a.gUN);
            AppMethodBeat.o(10921);
            return null;
        }
        String at = ((d) g.K(d.class)).xF().at(this.appId, this.cBc);
        if (bo.isNullOrNil(at)) {
            u.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, url is null or nil", new Object[0]);
            a(a.gUJ);
            AppMethodBeat.o(10921);
            return null;
        }
        az.a(this.appId, this.cBc, at, anonymousClass1);
        try {
            countDownLatch.await();
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", e, "tryDownload semaphore exp ", new Object[0]);
        }
        WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) jVar.value;
        AppMethodBeat.o(10921);
        return wxaPkgWrappingInfo;
    }

    private static void a(a aVar) {
        AppMethodBeat.i(10922);
        u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "pkgRecordError %s", aVar.toString());
        if (a.gUJ.equals(aVar)) {
            AppMethodBeat.o(10922);
        } else if (a.gUL.equals(aVar) || a.gUK.equals(aVar)) {
            AppMethodBeat.o(10922);
        } else {
            AppMethodBeat.o(10922);
        }
    }
}
