package com.tencent.p177mm.plugin.appbrand.launching;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.loader.C32473a;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p183ai.C8920x;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.C10100y;
import com.tencent.p177mm.plugin.appbrand.appcache.C19035as;
import com.tencent.p177mm.plugin.appbrand.appcache.C2055az;
import com.tencent.p177mm.plugin.appbrand.appcache.C31281at;
import com.tencent.p177mm.plugin.appbrand.appcache.C41221e;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.p177mm.plugin.appbrand.appcache.p881a.C10065a.C10066a;
import com.tencent.p177mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrand404PageUI;
import com.tencent.p177mm.plugin.appbrand.report.C19690c;
import com.tencent.p177mm.protocal.protobuf.aoz;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.VError;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.w */
final class C27181w extends C42620u {
    final String appId;
    int cBc;
    final int cvn;
    final String gTy;
    private final int[] ihE;

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.w$2 */
    class C271832 implements C10066a {
        C271832() {
        }

        public final String avJ() {
            AppMethodBeat.m2504i(131899);
            String str = "_" + C42340f.auV().mo60842a(C27181w.this.ihz.toString(), C27181w.this.cvn, "versionMd5").field_versionMd5;
            AppMethodBeat.m2505o(131899);
            return str;
        }
    }

    C27181w(String str, String str2, int i) {
        this(str, str2, i, 0);
    }

    C27181w(String str, String str2, int i, int i2) {
        super(new C10100y(str, str2, i2));
        AppMethodBeat.m2504i(131900);
        this.cBc = 4;
        this.ihE = new int[]{14, 12, 13};
        this.appId = str;
        this.gTy = str2;
        this.cvn = i;
        if (C32473a.contains(this.ihE, i2)) {
            this.cBc = i2;
        }
        AppMethodBeat.m2505o(131900);
    }

    public final String aHu() {
        AppMethodBeat.m2504i(131901);
        String format = String.format(Locale.US, "appId %s, module %s, codeType %d, pkgType %d,queryKey:%s", new Object[]{this.appId, this.gTy, Integer.valueOf(this.cvn), Integer.valueOf(this.cBc), this.ihz});
        AppMethodBeat.m2505o(131901);
        return format;
    }

    public final void prepare() {
        int i = -1;
        AppMethodBeat.m2504i(131902);
        Pair v = C19035as.m29615v(this.ihz.toString(), this.cvn, 1);
        if (v.second != null) {
            ((WxaPkgWrappingInfo) v.second).name = this.gTy;
            mo68061e((WxaPkgWrappingInfo) v.second);
            C4990ab.m7417i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s prepare ok", aHu());
            aHs();
            AppMethodBeat.m2505o(131902);
            return;
        }
        String at;
        if (C5046bo.isNullOrNil(this.gTy)) {
            at = C42340f.auV().mo60852at(this.appId, this.cvn);
        } else {
            C31281at a = C42340f.auV().mo60842a(this.ihz.toString(), this.cvn, "versionMd5", "downloadURL");
            if (a == null) {
                C4990ab.m7413e("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s, NULL record", aHu());
                at = null;
            } else if (!DebuggerShell.ayT() || TextUtils.isEmpty(a.field_downloadURL)) {
                C4990ab.m7417i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s, record md5:%s", aHu(), a.field_versionMd5);
                C37441a a2 = C8920x.m16081a(new C41221e(this.appId, this.gTy, a.field_versionMd5, this.cvn, this.cBc));
                if (a2 != null && a2.errType == 0 && a2.errCode == 0) {
                    C4990ab.m7417i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "resp.errcode %d, resp.errmsg %s, resp.url %s", Integer.valueOf(((aoz) a2.fsy).error_code), ((aoz) a2.fsy).error_msg, ((aoz) a2.fsy).egm);
                    if (C5046bo.isNullOrNil(((aoz) a2.fsy).egm)) {
                        if (((aoz) a2.fsy).error_code == VError.ERROR_FACE_TXT_INIT) {
                            AppBrand404PageUI.show(C25738R.string.f9027mx);
                            C19690c.m30494K(this.appId, 4, this.cvn + 1);
                        } else {
                            C42608ag.m75434Ck(C42677e.getMMString(C25738R.string.f9009ma, Integer.valueOf(5), Integer.valueOf(((aoz) a2.fsy).error_code)));
                        }
                    }
                    at = ((aoz) a2.fsy).egm;
                } else {
                    String str = "MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode";
                    String str2 = "%s, cgi failed, %d %d";
                    Object[] objArr = new Object[3];
                    objArr[0] = aHu();
                    objArr[1] = Integer.valueOf(a2 == null ? -1 : a2.errType);
                    objArr[2] = Integer.valueOf(a2 == null ? -1 : a2.errCode);
                    C4990ab.m7413e(str, str2, objArr);
                    Object[] objArr2 = new Object[2];
                    objArr2[0] = Integer.valueOf(a2 == null ? -1 : a2.errType);
                    if (a2 != null) {
                        i = a2.errCode;
                    }
                    objArr2[1] = Integer.valueOf(i);
                    C42608ag.m75434Ck(C42608ag.getMMString(C25738R.string.f9006m8, objArr2));
                    at = null;
                }
            } else {
                C4990ab.m7417i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "getDownloadURL, with appId[%s], module[%s] hit monkey pushed url[%s]", this.appId, this.gTy, a.field_downloadURL);
                at = a.field_downloadURL;
            }
        }
        C271821 c271821 = new C44702t(this.cvn) {
            /* Access modifiers changed, original: final */
            public final String aHr() {
                AppMethodBeat.m2504i(131896);
                String aHu = C27181w.this.aHu();
                AppMethodBeat.m2505o(131896);
                return aHu;
            }

            /* Access modifiers changed, original: final */
            /* renamed from: d */
            public final void mo6276d(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                AppMethodBeat.m2504i(131897);
                C27181w.this.mo68061e(wxaPkgWrappingInfo);
                C27181w.this.mo68062f(wxaPkgWrappingInfo);
                AppMethodBeat.m2505o(131897);
            }

            /* Access modifiers changed, original: protected|final */
            /* renamed from: b */
            public final void mo22090b(WxaPkgLoadProgress wxaPkgLoadProgress) {
                AppMethodBeat.m2504i(131898);
                super.mo22090b(wxaPkgLoadProgress);
                C27181w.this.mo68060c(wxaPkgLoadProgress);
                AppMethodBeat.m2505o(131898);
            }
        };
        C4990ab.m7417i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s before download, url(%s)", aHu(), at);
        if (C5046bo.isNullOrNil(at)) {
            mo68061e(null);
            AppMethodBeat.m2505o(131902);
        } else if (C2055az.m4223a(this.ihz.toString(), this.cvn, at, c271821, new C271832())) {
            aHt();
            AppMethodBeat.m2505o(131902);
        } else {
            C4990ab.m7413e("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s start downloadPkg failed", aHu());
            mo68061e(null);
            AppMethodBeat.m2505o(131902);
        }
    }
}
