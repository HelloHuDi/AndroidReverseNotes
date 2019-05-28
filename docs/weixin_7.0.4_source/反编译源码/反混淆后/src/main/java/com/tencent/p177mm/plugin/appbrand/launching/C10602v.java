package com.tencent.p177mm.plugin.appbrand.launching;

import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.loader.C32473a;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.C10089bd;
import com.tencent.p177mm.plugin.appbrand.appcache.C10100y;
import com.tencent.p177mm.plugin.appbrand.appcache.C19063p;
import com.tencent.p177mm.plugin.appbrand.appcache.C19071r;
import com.tencent.p177mm.plugin.appbrand.appcache.C2050aq;
import com.tencent.p177mm.plugin.appbrand.appcache.C2055az;
import com.tencent.p177mm.plugin.appbrand.appcache.C31281at;
import com.tencent.p177mm.plugin.appbrand.appcache.C33094d;
import com.tencent.p177mm.plugin.appbrand.appcache.C38105ax;
import com.tencent.p177mm.plugin.appbrand.appcache.C45515j.C33097a;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.p177mm.protocal.protobuf.arb;
import com.tencent.p177mm.protocal.protobuf.arc;
import com.tencent.p177mm.protocal.protobuf.cwv;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vfs.C5730e;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.v */
public final class C10602v extends C42620u {
    public final String appId;
    public int cBc;
    public final int cvn;
    public final String gTy;
    public final int ihB;
    public final boolean ihC;
    private C31281at ihD;
    private final int[] ihE;

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.v$2 */
    class C106012 extends C44702t {
        C106012() {
            super(0);
        }

        /* Access modifiers changed, original: final */
        public final String aHr() {
            AppMethodBeat.m2504i(131887);
            String aHu = C10602v.this.aHu();
            AppMethodBeat.m2505o(131887);
            return aHu;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: d */
        public final void mo6276d(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
            AppMethodBeat.m2504i(131888);
            C10602v.this.mo68061e(wxaPkgWrappingInfo);
            C10602v.this.mo68062f(wxaPkgWrappingInfo);
            AppMethodBeat.m2505o(131888);
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: b */
        public final void mo22090b(WxaPkgLoadProgress wxaPkgLoadProgress) {
            AppMethodBeat.m2504i(131889);
            C10602v.this.mo68060c(wxaPkgLoadProgress);
            AppMethodBeat.m2505o(131889);
        }
    }

    public C10602v(String str, String str2, int i) {
        this(str, str2, i, true);
    }

    public C10602v(String str, String str2, int i, boolean z) {
        super(new C10100y(str, str2));
        AppMethodBeat.m2504i(131891);
        this.cvn = 0;
        this.cBc = 4;
        this.ihE = new int[]{14, 12};
        this.appId = str;
        this.gTy = str2;
        this.ihB = i;
        this.ihC = z;
        AppMethodBeat.m2505o(131891);
    }

    public C10602v(String str, String str2, int i, int i2) {
        this(str, str2, i, i2, (byte) 0);
    }

    private C10602v(String str, String str2, int i, int i2, byte b) {
        super(new C10100y(str, str2, i2));
        AppMethodBeat.m2504i(131892);
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
        AppMethodBeat.m2505o(131892);
    }

    public final String aHu() {
        AppMethodBeat.m2504i(131893);
        String format = String.format(Locale.US, "pkg %s, targetVersion %d, codeType %d", new Object[]{this.ihz.toString(), Integer.valueOf(this.ihB), Integer.valueOf(0)});
        AppMethodBeat.m2505o(131893);
        return format;
    }

    /* renamed from: Ci */
    private WxaPkgWrappingInfo m18279Ci(String str) {
        WxaPkgWrappingInfo xM;
        AppMethodBeat.m2504i(131894);
        if (C5046bo.isNullOrNil(this.gTy) || !this.gTy.endsWith("__CODELIB__")) {
            xM = WxaPkgWrappingInfo.m54056xM(str);
        } else {
            xM = WxaPkgWrappingInfo.m54057xN(str);
        }
        xM.gVu = this.ihB;
        AppMethodBeat.m2505o(131894);
        return xM;
    }

    public final void prepare() {
        int i = 1;
        AppMethodBeat.m2504i(131895);
        C38105ax auV = C42340f.auV();
        if (auV == null) {
            C4990ab.m7413e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "get NULL storage with %s", aHu());
            mo68061e(null);
            AppMethodBeat.m2505o(131895);
            return;
        }
        this.ihD = auV.mo60841a(this.ihz.toString(), this.ihB, 0, new String[0]);
        final String string;
        if (this.ihD == null) {
            C4990ab.m7413e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "get NULL record with %s", aHu());
            mo68061e(null);
            string = C4996ah.getContext().getString(C25738R.string.f9011md, new Object[]{""});
            if (!this.ihC || TextUtils.isEmpty(string)) {
                AppMethodBeat.m2505o(131895);
                return;
            }
            C7305d.xDG.mo10154d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(131890);
                    Toast.makeText(C4996ah.getContext(), string, 0).show();
                    AppMethodBeat.m2505o(131890);
                }
            });
            AppMethodBeat.m2505o(131895);
        } else if (C5046bo.isNullOrNil(this.ihD.field_versionMd5)) {
            C4990ab.m7413e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "get EMPTY md5 with %s", aHu());
            mo68061e(null);
            AppMethodBeat.m2505o(131895);
        } else {
            try {
                InputStream openRead = C5730e.openRead(this.ihD.field_pkgPath);
                if (this.ihD.field_versionMd5.equals(C1178g.m2585b(openRead, 4096))) {
                    C4990ab.m7417i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s prepare ok", aHu());
                    mo68061e(m18279Ci(this.ihD.field_pkgPath));
                    aHs();
                    C5046bo.m7527b(openRead);
                    AppMethodBeat.m2505o(131895);
                    return;
                }
                C5046bo.m7527b(openRead);
                C5730e.deleteFile(this.ihD.field_pkgPath);
                C31281at a = C19573h.m30344a(this.ihz, 0, this.ihB, this.ihD.field_versionMd5);
                if (a != null) {
                    C4990ab.m7417i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "find reusable record, target (%s), reusable (%s %d)", aHu(), a.field_appId, Integer.valueOf(a.field_version));
                    string = C2050aq.m4207aq(this.ihz.toString(), this.ihB);
                    C5730e.m8644y(a.field_pkgPath, string);
                    C42340f.auV().mo60864d(this.ihz.toString(), 0, this.ihB, string);
                    mo68061e(m18279Ci(string));
                    aHs();
                    AppMethodBeat.m2505o(131895);
                    return;
                }
                String c10100y;
                C4990ab.m7417i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s getDownloadURL", aHu());
                final arb arb = new arb();
                arb.csB = this.appId;
                arb.vOP = this.ihB;
                arb.wtb = 0;
                if (!C5046bo.isNullOrNil(this.gTy)) {
                    arb.wtb = this.cBc;
                    if (!C32473a.contains(this.ihE, this.cBc)) {
                        arb.wsY = this.gTy;
                    }
                }
                arb.wuL = this.ihD.field_versionMd5;
                if (C19071r.avD() && C33097a.m54090np(0)) {
                    c10100y = this.ihz.toString();
                    if (!C5046bo.isNullOrNil(c10100y)) {
                        WxaPkgWrappingInfo bm;
                        if (c10100y.endsWith("__CODELIB__")) {
                            bm = C19573h.m30345bm(c10100y, 0);
                        } else {
                            bm = C19573h.m30345bm(c10100y, 1);
                        }
                        if (bm != null) {
                            arb.wuM = bm.gVu;
                        }
                    }
                }
                c10100y = "MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode";
                String str = "appid:%s,cgirequest pkgtype:%s,modulename:%s,version:%s,old_app_version:%s,record md5:%s,openIncremental:%s";
                Object[] objArr = new Object[7];
                objArr[0] = arb.csB;
                objArr[1] = Integer.valueOf(arb.wtb);
                objArr[2] = arb.wsY;
                objArr[3] = Integer.valueOf(arb.vOP);
                objArr[4] = Integer.valueOf(arb.wuM);
                objArr[5] = arb.wuL;
                if (!C19071r.avD()) {
                    i = 0;
                }
                objArr[6] = Integer.valueOf(i);
                C4990ab.m7417i(c10100y, str, objArr);
                new C33094d(arb).acy().mo60492h(new C5681a<Void, C37441a<arc>>() {
                    public final /* synthetic */ Object call(Object obj) {
                        AppMethodBeat.m2504i(131886);
                        C37441a c37441a = (C37441a) obj;
                        C10602v c10602v = C10602v.this;
                        if (c10602v.ihx != null) {
                            c10602v.ihx.mo6282a(c37441a);
                        }
                        if (c37441a.errCode == 0 && c37441a.errType == 0 && c37441a.fsy != null) {
                            boolean a;
                            C10602v c10602v2 = C10602v.this;
                            arb arb = arb;
                            arc arc = (arc) c37441a.fsy;
                            cwv cwv = new cwv();
                            cwv.xsy = arc.url;
                            cwv.vMG = c10602v2.ihB;
                            cwv.xsx = arb.wuL;
                            C42340f.auV().mo60850a(c10602v2.ihz.toString(), cwv, 0);
                            C106012 c106012 = new C106012();
                            C4990ab.m7417i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s downloadPkg, patch_url(%s), full_url(%s)", c10602v2.aHu(), arc.cDL, arc.url);
                            if (arb.wuM > 0 && !C5046bo.isNullOrNil(arc.cDL)) {
                                a = C19063p.m29630a(c10602v2.ihz.toString(), arb.wuM, c10602v2.ihB, arc.cDL, c106012);
                                if (c10602v2.ihx != null) {
                                    c10602v2.ihx.aHn();
                                }
                            } else if (C5046bo.isNullOrNil(arc.wuP)) {
                                a = C2055az.m4224b(c10602v2.ihz.toString(), 0, c10602v2.ihB, arc.url, c106012);
                                c10602v2.aHt();
                            } else {
                                a = C10089bd.m17684a(arc.wuP, c10602v2.ihz.toString(), c10602v2.ihB, 0, c106012);
                            }
                            if (!a) {
                                C4990ab.m7413e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s start downloadPkg failed", c10602v2.aHu());
                                c10602v2.mo68061e(null);
                            }
                        } else {
                            C4990ab.m7413e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s, getDownloadURL failed %d, %d", C10602v.this.aHu(), Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode));
                            if (C10602v.this.ihC) {
                                C42608ag.m75434Ck(C42608ag.getMMString(C25738R.string.f9006m8, Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode)));
                            }
                            C10602v.this.mo68061e(null);
                        }
                        Void voidR = zXH;
                        AppMethodBeat.m2505o(131886);
                        return voidR;
                    }
                });
                AppMethodBeat.m2505o(131895);
            } catch (FileNotFoundException e) {
                C5046bo.m7527b(null);
            } catch (Throwable th) {
                C5046bo.m7527b(null);
                AppMethodBeat.m2505o(131895);
            }
        }
    }
}
