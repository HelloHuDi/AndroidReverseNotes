package com.tencent.mm.plugin.appbrand.launching;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.x;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.as;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appcache.az;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.appcache.y;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;
import com.tencent.mm.protocal.protobuf.aoz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.VError;
import java.util.Locale;

final class w extends u {
    final String appId;
    int cBc;
    final int cvn;
    final String gTy;
    private final int[] ihE;

    w(String str, String str2, int i) {
        this(str, str2, i, 0);
    }

    w(String str, String str2, int i, int i2) {
        super(new y(str, str2, i2));
        AppMethodBeat.i(131900);
        this.cBc = 4;
        this.ihE = new int[]{14, 12, 13};
        this.appId = str;
        this.gTy = str2;
        this.cvn = i;
        if (a.contains(this.ihE, i2)) {
            this.cBc = i2;
        }
        AppMethodBeat.o(131900);
    }

    public final String aHu() {
        AppMethodBeat.i(131901);
        String format = String.format(Locale.US, "appId %s, module %s, codeType %d, pkgType %d,queryKey:%s", new Object[]{this.appId, this.gTy, Integer.valueOf(this.cvn), Integer.valueOf(this.cBc), this.ihz});
        AppMethodBeat.o(131901);
        return format;
    }

    public final void prepare() {
        int i = -1;
        AppMethodBeat.i(131902);
        Pair v = as.v(this.ihz.toString(), this.cvn, 1);
        if (v.second != null) {
            ((WxaPkgWrappingInfo) v.second).name = this.gTy;
            e((WxaPkgWrappingInfo) v.second);
            ab.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s prepare ok", aHu());
            aHs();
            AppMethodBeat.o(131902);
            return;
        }
        String at;
        if (bo.isNullOrNil(this.gTy)) {
            at = f.auV().at(this.appId, this.cvn);
        } else {
            at a = f.auV().a(this.ihz.toString(), this.cvn, "versionMd5", "downloadURL");
            if (a == null) {
                ab.e("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s, NULL record", aHu());
                at = null;
            } else if (!DebuggerShell.ayT() || TextUtils.isEmpty(a.field_downloadURL)) {
                ab.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s, record md5:%s", aHu(), a.field_versionMd5);
                com.tencent.mm.ai.a.a a2 = x.a(new e(this.appId, this.gTy, a.field_versionMd5, this.cvn, this.cBc));
                if (a2 != null && a2.errType == 0 && a2.errCode == 0) {
                    ab.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "resp.errcode %d, resp.errmsg %s, resp.url %s", Integer.valueOf(((aoz) a2.fsy).error_code), ((aoz) a2.fsy).error_msg, ((aoz) a2.fsy).egm);
                    if (bo.isNullOrNil(((aoz) a2.fsy).egm)) {
                        if (((aoz) a2.fsy).error_code == VError.ERROR_FACE_TXT_INIT) {
                            AppBrand404PageUI.show(R.string.mx);
                            c.K(this.appId, 4, this.cvn + 1);
                        } else {
                            ag.Ck(com.tencent.mm.plugin.appbrand.s.e.getMMString(R.string.ma, Integer.valueOf(5), Integer.valueOf(((aoz) a2.fsy).error_code)));
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
                    ab.e(str, str2, objArr);
                    Object[] objArr2 = new Object[2];
                    objArr2[0] = Integer.valueOf(a2 == null ? -1 : a2.errType);
                    if (a2 != null) {
                        i = a2.errCode;
                    }
                    objArr2[1] = Integer.valueOf(i);
                    ag.Ck(ag.getMMString(R.string.m8, objArr2));
                    at = null;
                }
            } else {
                ab.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "getDownloadURL, with appId[%s], module[%s] hit monkey pushed url[%s]", this.appId, this.gTy, a.field_downloadURL);
                at = a.field_downloadURL;
            }
        }
        AnonymousClass1 anonymousClass1 = new t(this.cvn) {
            /* Access modifiers changed, original: final */
            public final String aHr() {
                AppMethodBeat.i(131896);
                String aHu = w.this.aHu();
                AppMethodBeat.o(131896);
                return aHu;
            }

            /* Access modifiers changed, original: final */
            public final void d(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                AppMethodBeat.i(131897);
                w.this.e(wxaPkgWrappingInfo);
                w.this.f(wxaPkgWrappingInfo);
                AppMethodBeat.o(131897);
            }

            /* Access modifiers changed, original: protected|final */
            public final void b(WxaPkgLoadProgress wxaPkgLoadProgress) {
                AppMethodBeat.i(131898);
                super.b(wxaPkgLoadProgress);
                w.this.c(wxaPkgLoadProgress);
                AppMethodBeat.o(131898);
            }
        };
        ab.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s before download, url(%s)", aHu(), at);
        if (bo.isNullOrNil(at)) {
            e(null);
            AppMethodBeat.o(131902);
        } else if (az.a(this.ihz.toString(), this.cvn, at, anonymousClass1, new com.tencent.mm.plugin.appbrand.appcache.a.a.a() {
            public final String avJ() {
                AppMethodBeat.i(131899);
                String str = "_" + f.auV().a(w.this.ihz.toString(), w.this.cvn, "versionMd5").field_versionMd5;
                AppMethodBeat.o(131899);
                return str;
            }
        })) {
            aHt();
            AppMethodBeat.o(131902);
        } else {
            ab.e("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s start downloadPkg failed", aHu());
            e(null);
            AppMethodBeat.o(131902);
        }
    }
}
