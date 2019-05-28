package com.tencent.p177mm.plugin.appbrand.launching;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p230g.p231a.C32628se;
import com.tencent.p177mm.p230g.p231a.C32628se.C18390a;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.C38105ax;
import com.tencent.p177mm.plugin.appbrand.appcache.C45515j.C33097a;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.p177mm.plugin.appbrand.config.C26842p;
import com.tencent.p177mm.plugin.appbrand.ipc.C26907a;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.report.C19693f;
import com.tencent.p177mm.plugin.appbrand.task.C45694h;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.a */
public final class C38418a extends C4884c<C32628se> {
    public C38418a() {
        AppMethodBeat.m2504i(131702);
        this.xxI = C32628se.class.getName().hashCode();
        AppMethodBeat.m2505o(131702);
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x026d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(131703);
        C32628se c32628se = (C32628se) c4883b;
        if (C5046bo.isNullOrNil(c32628se.cOf.userName)) {
            c32628se.cOg.cOw = false;
            c32628se.cOg.cOx = "invalid username or appId";
            AppMethodBeat.m2505o(131703);
            return true;
        }
        AppBrandLaunchReferrer appBrandLaunchReferrer;
        if (!(C5046bo.isNullOrNil(c32628se.cOf.appId) || C5046bo.isNullOrNil(c32628se.cOf.cOn.fpI))) {
            ((C42611l) C42340f.m74878E(C42611l.class)).mo68053n(c32628se.cOf.appId, c32628se.cOf.cOi, c32628se.cOf.cOn.fpI);
        }
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = c32628se.cOf.scene;
        appBrandStatObject.cst = c32628se.cOf.cst;
        appBrandStatObject.cOq = C19693f.m30514h(appBrandStatObject.scene, c32628se.cOf.cvs);
        appBrandStatObject.cOr = C19693f.m30515i(appBrandStatObject.scene, c32628se.cOf.cvs);
        if (c32628se.cOf.scene == FilterEnum4Shaka.MIC_SHAKA_ADD2_2 || c32628se.cOf.scene == 1018) {
            appBrandStatObject.cOo = c32628se.cOf.cOo;
        } else {
            appBrandStatObject.cOo = c32628se.cOf.scene;
        }
        if (!C5046bo.isNullOrNil(c32628se.cOf.cOs)) {
            appBrandLaunchReferrer = new AppBrandLaunchReferrer();
            appBrandLaunchReferrer.appId = c32628se.cOf.cOs;
            appBrandLaunchReferrer.hgR = c32628se.cOf.cOu;
            appBrandLaunchReferrer.hgQ = 2;
        } else if (C5046bo.isNullOrNil(c32628se.cOf.cOv)) {
            appBrandLaunchReferrer = null;
        } else {
            appBrandLaunchReferrer = new AppBrandLaunchReferrer();
            appBrandLaunchReferrer.cOv = c32628se.cOf.cOv;
            appBrandLaunchReferrer.hgQ = 6;
        }
        if (c32628se.cOf.cOp != null) {
            c32628se.cOf.cOp.run();
        }
        switch (c32628se.cOf.cOi) {
            case 0:
            case 2:
                int i;
                if (c32628se.cOf.axy <= 0) {
                    i = -1;
                } else {
                    i = c32628se.cOf.axy;
                }
                AppBrandLaunchProxyUI.m25694a(c32628se.cOf.context, c32628se.cOf.userName, c32628se.cOf.appId, c32628se.cOf.cOh, c32628se.cOf.cOi, i, appBrandStatObject, appBrandLaunchReferrer, c32628se.cOf.cOn);
                break;
            case 1:
                if (!c32628se.cOf.cOl) {
                    if (!C5046bo.isNullOrNil(c32628se.cOf.appId)) {
                        if (!C5046bo.isNullOrNil(c32628se.cOf.cOj) && !C5046bo.isNullOrNil(c32628se.cOf.cOk)) {
                            if (C42340f.auV().mo60848a(c32628se.cOf.appId, c32628se.cOf.cOi, c32628se.cOf.cOj, c32628se.cOf.cOk, 0, 0)) {
                                C45694h.m84422bt(c32628se.cOf.appId, c32628se.cOf.cOi);
                            } else if (!C42340f.auV().mo60851as(c32628se.cOf.appId, c32628se.cOf.cOi)) {
                                c32628se.cOg.cOw = false;
                                c32628se.cOg.cOx = "install app failed";
                                AppMethodBeat.m2505o(131703);
                                return true;
                            }
                            appBrandStatObject.cst = c32628se.cOf.cOj;
                            AppBrandLaunchProxyUI.m25693a(c32628se.cOf.context, c32628se.cOf.userName, c32628se.cOf.cOh, c32628se.cOf.cOi, -1, appBrandStatObject, appBrandLaunchReferrer, c32628se.cOf.cOn);
                            break;
                        }
                        c32628se.cOg.cOw = false;
                        c32628se.cOg.cOx = "invalid downloadURL or checkSumMd5";
                        AppMethodBeat.m2505o(131703);
                        return true;
                    }
                    c32628se.cOg.cOw = false;
                    c32628se.cOg.cOx = "invalid username or appId";
                    AppMethodBeat.m2505o(131703);
                    return true;
                }
                C18390a c18390a = c32628se.cOf;
                String zm = C26842p.m42740zm(c32628se.cOf.userName);
                c18390a.appId = zm;
                if (!C5046bo.isNullOrNil(zm)) {
                    String str;
                    C38105ax auV = C42340f.auV();
                    zm = c32628se.cOf.appId;
                    int i2 = c32628se.cOf.cOi;
                    Cursor query = auV.gVj.query("AppBrandWxaPkgManifestRecord", new String[]{"pkgPath"}, String.format(Locale.US, "%s=? and %s=?", new Object[]{"appId", "debugType"}), new String[]{zm, String.valueOf(i2)}, null, null, null);
                    if (query == null) {
                        str = null;
                    } else {
                        str = query.moveToFirst() ? query.getString(0) : null;
                        query.close();
                    }
                    if (C5046bo.isNullOrNil(str) || !C5730e.m8628ct(str)) {
                        Object obj;
                        C38105ax auV2 = C42340f.auV();
                        String str2 = c32628se.cOf.appId;
                        int i3 = c32628se.cOf.cOi;
                        if ((C33097a.m54089kR(i3) ? 1 : auV2.mo60853au(str2, i3)) < 0) {
                            C4990ab.m7413e("MicroMsg.AppBrandWxaPkgStorage", "hasModuleList, appId(%s), type(%s), version(%d), not records", str2, Integer.valueOf(i3), Integer.valueOf(C33097a.m54089kR(i3) ? 1 : auV2.mo60853au(str2, i3)));
                        } else {
                            String format = String.format(Locale.US, "where %s like '%s$%%' and %s=%d and %s=%d", new Object[]{"appId", str2, "debugType", Integer.valueOf(i3), "version", Integer.valueOf(C33097a.m54089kR(i3) ? 1 : auV2.mo60853au(str2, i3))});
                            query = auV2.gVj.mo10104a(String.format(Locale.US, "select count(*) from %s %s", new Object[]{"AppBrandWxaPkgManifestRecord", format}), null, 2);
                            int i4;
                            if (query == null || query.isClosed()) {
                                C4990ab.m7413e("MicroMsg.AppBrandWxaPkgStorage", "hasModuleList, appId(%s), type(%s), version(%d), cursor nil", str2, Integer.valueOf(i3), Integer.valueOf(i4));
                            } else {
                                i4 = query.moveToFirst() ? query.getInt(0) : 0;
                                query.close();
                                if (i4 > 0) {
                                    obj = 1;
                                    if (obj != null) {
                                        c32628se.cOg.cOw = true;
                                        C4990ab.m7417i("MicroMsg.AppBrandLaunchFromOuterEventListener", "callback with appId(%s) type(%d), hasModuleList=true", c32628se.cOf.appId, Integer.valueOf(c32628se.cOf.cOi));
                                        AppBrandLaunchProxyUI.m25693a(c32628se.cOf.context, c32628se.cOf.userName, c32628se.cOf.cOh, c32628se.cOf.cOi, 0, appBrandStatObject, appBrandLaunchReferrer, c32628se.cOf.cOn);
                                        AppMethodBeat.m2505o(131703);
                                        return true;
                                    }
                                }
                            }
                        }
                        obj = null;
                        if (obj != null) {
                        }
                    } else {
                        c32628se.cOg.cOw = true;
                        AppBrandLaunchProxyUI.m25693a(c32628se.cOf.context, c32628se.cOf.userName, c32628se.cOf.cOh, c32628se.cOf.cOi, 0, appBrandStatObject, appBrandLaunchReferrer, c32628se.cOf.cOn);
                        AppMethodBeat.m2505o(131703);
                        return true;
                    }
                }
                c32628se.cOg.cOw = false;
                c32628se.cOg.cOx = "local pkg not exists";
                if (c32628se.cOf.cOm) {
                    zm = null;
                    if (c32628se.cOf.cOi == 1) {
                        zm = C42677e.getMMString(C25738R.string.f8867hl, new Object[0]);
                    } else if (c32628se.cOf.cOi == 2) {
                        zm = C42677e.getMMString(C25738R.string.f8970l7, new Object[0]);
                    }
                    C26907a.m42842a(c32628se.cOf.context, zm, C42677e.getMMString(C25738R.string.f9238tz, new Object[0]), C42677e.getMMString(C25738R.string.f9187s6, new Object[0]), "", null, null, null);
                }
                AppMethodBeat.m2505o(131703);
                return true;
                break;
            default:
                c32628se.cOg.cOw = false;
                c32628se.cOg.cOx = "invalid openType";
                AppMethodBeat.m2505o(131703);
                return true;
        }
        c32628se.cOg.cOw = true;
        AppMethodBeat.m2505o(131703);
        return true;
    }
}
