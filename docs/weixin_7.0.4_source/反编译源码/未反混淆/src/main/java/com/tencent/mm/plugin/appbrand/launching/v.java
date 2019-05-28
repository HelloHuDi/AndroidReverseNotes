package com.tencent.mm.plugin.appbrand.launching;

import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appcache.ax;
import com.tencent.mm.plugin.appbrand.appcache.az;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.appcache.p;
import com.tencent.mm.plugin.appbrand.appcache.r;
import com.tencent.mm.plugin.appbrand.appcache.y;
import com.tencent.mm.protocal.protobuf.arb;
import com.tencent.mm.protocal.protobuf.arc;
import com.tencent.mm.protocal.protobuf.cwv;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Locale;

public final class v extends u {
    public final String appId;
    public int cBc;
    public final int cvn;
    public final String gTy;
    public final int ihB;
    public final boolean ihC;
    private at ihD;
    private final int[] ihE;

    public v(String str, String str2, int i) {
        this(str, str2, i, true);
    }

    public v(String str, String str2, int i, boolean z) {
        super(new y(str, str2));
        AppMethodBeat.i(131891);
        this.cvn = 0;
        this.cBc = 4;
        this.ihE = new int[]{14, 12};
        this.appId = str;
        this.gTy = str2;
        this.ihB = i;
        this.ihC = z;
        AppMethodBeat.o(131891);
    }

    public v(String str, String str2, int i, int i2) {
        this(str, str2, i, i2, (byte) 0);
    }

    private v(String str, String str2, int i, int i2, byte b) {
        super(new y(str, str2, i2));
        AppMethodBeat.i(131892);
        this.cvn = 0;
        this.cBc = 4;
        this.ihE = new int[]{14, 12};
        this.appId = str;
        this.gTy = str2;
        this.ihB = i;
        this.ihC = true;
        if (i2 != 0) {
            this.cBc = i2;
        }
        AppMethodBeat.o(131892);
    }

    public final String aHu() {
        AppMethodBeat.i(131893);
        String format = String.format(Locale.US, "pkg %s, targetVersion %d, codeType %d", new Object[]{this.ihz.toString(), Integer.valueOf(this.ihB), Integer.valueOf(0)});
        AppMethodBeat.o(131893);
        return format;
    }

    private WxaPkgWrappingInfo Ci(String str) {
        WxaPkgWrappingInfo xM;
        AppMethodBeat.i(131894);
        if (bo.isNullOrNil(this.gTy) || !this.gTy.endsWith("__CODELIB__")) {
            xM = WxaPkgWrappingInfo.xM(str);
        } else {
            xM = WxaPkgWrappingInfo.xN(str);
        }
        xM.gVu = this.ihB;
        AppMethodBeat.o(131894);
        return xM;
    }

    public final void prepare() {
        int i = 1;
        AppMethodBeat.i(131895);
        ax auV = f.auV();
        if (auV == null) {
            ab.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "get NULL storage with %s", aHu());
            e(null);
            AppMethodBeat.o(131895);
            return;
        }
        this.ihD = auV.a(this.ihz.toString(), this.ihB, 0, new String[0]);
        final String string;
        if (this.ihD == null) {
            ab.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "get NULL record with %s", aHu());
            e(null);
            string = ah.getContext().getString(R.string.md, new Object[]{""});
            if (!this.ihC || TextUtils.isEmpty(string)) {
                AppMethodBeat.o(131895);
                return;
            }
            d.xDG.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(131890);
                    Toast.makeText(ah.getContext(), string, 0).show();
                    AppMethodBeat.o(131890);
                }
            });
            AppMethodBeat.o(131895);
        } else if (bo.isNullOrNil(this.ihD.field_versionMd5)) {
            ab.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "get EMPTY md5 with %s", aHu());
            e(null);
            AppMethodBeat.o(131895);
        } else {
            try {
                InputStream openRead = e.openRead(this.ihD.field_pkgPath);
                if (this.ihD.field_versionMd5.equals(g.b(openRead, 4096))) {
                    ab.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s prepare ok", aHu());
                    e(Ci(this.ihD.field_pkgPath));
                    aHs();
                    bo.b(openRead);
                    AppMethodBeat.o(131895);
                    return;
                }
                bo.b(openRead);
                e.deleteFile(this.ihD.field_pkgPath);
                at a = h.a(this.ihz, 0, this.ihB, this.ihD.field_versionMd5);
                if (a != null) {
                    ab.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "find reusable record, target (%s), reusable (%s %d)", aHu(), a.field_appId, Integer.valueOf(a.field_version));
                    string = aq.aq(this.ihz.toString(), this.ihB);
                    e.y(a.field_pkgPath, string);
                    f.auV().d(this.ihz.toString(), 0, this.ihB, string);
                    e(Ci(string));
                    aHs();
                    AppMethodBeat.o(131895);
                    return;
                }
                String yVar;
                ab.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s getDownloadURL", aHu());
                final arb arb = new arb();
                arb.csB = this.appId;
                arb.vOP = this.ihB;
                arb.wtb = 0;
                if (!bo.isNullOrNil(this.gTy)) {
                    arb.wtb = this.cBc;
                    if (!a.contains(this.ihE, this.cBc)) {
                        arb.wsY = this.gTy;
                    }
                }
                arb.wuL = this.ihD.field_versionMd5;
                if (r.avD() && j.a.np(0)) {
                    yVar = this.ihz.toString();
                    if (!bo.isNullOrNil(yVar)) {
                        WxaPkgWrappingInfo bm;
                        if (yVar.endsWith("__CODELIB__")) {
                            bm = h.bm(yVar, 0);
                        } else {
                            bm = h.bm(yVar, 1);
                        }
                        if (bm != null) {
                            arb.wuM = bm.gVu;
                        }
                    }
                }
                yVar = "MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode";
                String str = "appid:%s,cgirequest pkgtype:%s,modulename:%s,version:%s,old_app_version:%s,record md5:%s,openIncremental:%s";
                Object[] objArr = new Object[7];
                objArr[0] = arb.csB;
                objArr[1] = Integer.valueOf(arb.wtb);
                objArr[2] = arb.wsY;
                objArr[3] = Integer.valueOf(arb.vOP);
                objArr[4] = Integer.valueOf(arb.wuM);
                objArr[5] = arb.wuL;
                if (!r.avD()) {
                    i = 0;
                }
                objArr[6] = Integer.valueOf(i);
                ab.i(yVar, str, objArr);
                new com.tencent.mm.plugin.appbrand.appcache.d(arb).acy().h(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.ai.a.a<arc>>() {
                    public final /* synthetic */ Object call(Object obj) {
                        AppMethodBeat.i(131886);
                        com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
                        v vVar = v.this;
                        if (vVar.ihx != null) {
                            vVar.ihx.a(aVar);
                        }
                        if (aVar.errCode == 0 && aVar.errType == 0 && aVar.fsy != null) {
                            boolean a;
                            v vVar2 = v.this;
                            arb arb = arb;
                            arc arc = (arc) aVar.fsy;
                            cwv cwv = new cwv();
                            cwv.xsy = arc.url;
                            cwv.vMG = vVar2.ihB;
                            cwv.xsx = arb.wuL;
                            f.auV().a(vVar2.ihz.toString(), cwv, 0);
                            AnonymousClass2 anonymousClass2 = new t() {
                                /* Access modifiers changed, original: final */
                                public final String aHr() {
                                    AppMethodBeat.i(131887);
                                    String aHu = v.this.aHu();
                                    AppMethodBeat.o(131887);
                                    return aHu;
                                }

                                /* Access modifiers changed, original: final */
                                public final void d(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                                    AppMethodBeat.i(131888);
                                    v.this.e(wxaPkgWrappingInfo);
                                    v.this.f(wxaPkgWrappingInfo);
                                    AppMethodBeat.o(131888);
                                }

                                /* Access modifiers changed, original: protected|final */
                                public final void b(WxaPkgLoadProgress wxaPkgLoadProgress) {
                                    AppMethodBeat.i(131889);
                                    v.this.c(wxaPkgLoadProgress);
                                    AppMethodBeat.o(131889);
                                }
                            };
                            ab.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s downloadPkg, patch_url(%s), full_url(%s)", vVar2.aHu(), arc.cDL, arc.url);
                            if (arb.wuM > 0 && !bo.isNullOrNil(arc.cDL)) {
                                a = p.a(vVar2.ihz.toString(), arb.wuM, vVar2.ihB, arc.cDL, anonymousClass2);
                                if (vVar2.ihx != null) {
                                    vVar2.ihx.aHn();
                                }
                            } else if (bo.isNullOrNil(arc.wuP)) {
                                a = az.b(vVar2.ihz.toString(), 0, vVar2.ihB, arc.url, anonymousClass2);
                                vVar2.aHt();
                            } else {
                                a = bd.a(arc.wuP, vVar2.ihz.toString(), vVar2.ihB, 0, anonymousClass2);
                            }
                            if (!a) {
                                ab.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s start downloadPkg failed", vVar2.aHu());
                                vVar2.e(null);
                            }
                        } else {
                            ab.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s, getDownloadURL failed %d, %d", v.this.aHu(), Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
                            if (v.this.ihC) {
                                ag.Ck(ag.getMMString(R.string.m8, Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode)));
                            }
                            v.this.e(null);
                        }
                        Void voidR = zXH;
                        AppMethodBeat.o(131886);
                        return voidR;
                    }
                });
                AppMethodBeat.o(131895);
            } catch (FileNotFoundException e) {
                bo.b(null);
            } catch (Throwable th) {
                bo.b(null);
                AppMethodBeat.o(131895);
            }
        }
    }
}
