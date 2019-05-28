package com.tencent.mm.plugin.appbrand.launching;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.se;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.ax;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.Locale;

public final class a extends c<se> {
    public a() {
        AppMethodBeat.i(131702);
        this.xxI = se.class.getName().hashCode();
        AppMethodBeat.o(131702);
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x026d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(131703);
        se seVar = (se) bVar;
        if (bo.isNullOrNil(seVar.cOf.userName)) {
            seVar.cOg.cOw = false;
            seVar.cOg.cOx = "invalid username or appId";
            AppMethodBeat.o(131703);
            return true;
        }
        AppBrandLaunchReferrer appBrandLaunchReferrer;
        if (!(bo.isNullOrNil(seVar.cOf.appId) || bo.isNullOrNil(seVar.cOf.cOn.fpI))) {
            ((l) f.E(l.class)).n(seVar.cOf.appId, seVar.cOf.cOi, seVar.cOf.cOn.fpI);
        }
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = seVar.cOf.scene;
        appBrandStatObject.cst = seVar.cOf.cst;
        appBrandStatObject.cOq = com.tencent.mm.plugin.appbrand.report.f.h(appBrandStatObject.scene, seVar.cOf.cvs);
        appBrandStatObject.cOr = com.tencent.mm.plugin.appbrand.report.f.i(appBrandStatObject.scene, seVar.cOf.cvs);
        if (seVar.cOf.scene == FilterEnum4Shaka.MIC_SHAKA_ADD2_2 || seVar.cOf.scene == 1018) {
            appBrandStatObject.cOo = seVar.cOf.cOo;
        } else {
            appBrandStatObject.cOo = seVar.cOf.scene;
        }
        if (!bo.isNullOrNil(seVar.cOf.cOs)) {
            appBrandLaunchReferrer = new AppBrandLaunchReferrer();
            appBrandLaunchReferrer.appId = seVar.cOf.cOs;
            appBrandLaunchReferrer.hgR = seVar.cOf.cOu;
            appBrandLaunchReferrer.hgQ = 2;
        } else if (bo.isNullOrNil(seVar.cOf.cOv)) {
            appBrandLaunchReferrer = null;
        } else {
            appBrandLaunchReferrer = new AppBrandLaunchReferrer();
            appBrandLaunchReferrer.cOv = seVar.cOf.cOv;
            appBrandLaunchReferrer.hgQ = 6;
        }
        if (seVar.cOf.cOp != null) {
            seVar.cOf.cOp.run();
        }
        switch (seVar.cOf.cOi) {
            case 0:
            case 2:
                int i;
                if (seVar.cOf.axy <= 0) {
                    i = -1;
                } else {
                    i = seVar.cOf.axy;
                }
                AppBrandLaunchProxyUI.a(seVar.cOf.context, seVar.cOf.userName, seVar.cOf.appId, seVar.cOf.cOh, seVar.cOf.cOi, i, appBrandStatObject, appBrandLaunchReferrer, seVar.cOf.cOn);
                break;
            case 1:
                if (!seVar.cOf.cOl) {
                    if (!bo.isNullOrNil(seVar.cOf.appId)) {
                        if (!bo.isNullOrNil(seVar.cOf.cOj) && !bo.isNullOrNil(seVar.cOf.cOk)) {
                            if (f.auV().a(seVar.cOf.appId, seVar.cOf.cOi, seVar.cOf.cOj, seVar.cOf.cOk, 0, 0)) {
                                h.bt(seVar.cOf.appId, seVar.cOf.cOi);
                            } else if (!f.auV().as(seVar.cOf.appId, seVar.cOf.cOi)) {
                                seVar.cOg.cOw = false;
                                seVar.cOg.cOx = "install app failed";
                                AppMethodBeat.o(131703);
                                return true;
                            }
                            appBrandStatObject.cst = seVar.cOf.cOj;
                            AppBrandLaunchProxyUI.a(seVar.cOf.context, seVar.cOf.userName, seVar.cOf.cOh, seVar.cOf.cOi, -1, appBrandStatObject, appBrandLaunchReferrer, seVar.cOf.cOn);
                            break;
                        }
                        seVar.cOg.cOw = false;
                        seVar.cOg.cOx = "invalid downloadURL or checkSumMd5";
                        AppMethodBeat.o(131703);
                        return true;
                    }
                    seVar.cOg.cOw = false;
                    seVar.cOg.cOx = "invalid username or appId";
                    AppMethodBeat.o(131703);
                    return true;
                }
                com.tencent.mm.g.a.se.a aVar = seVar.cOf;
                String zm = p.zm(seVar.cOf.userName);
                aVar.appId = zm;
                if (!bo.isNullOrNil(zm)) {
                    String str;
                    ax auV = f.auV();
                    zm = seVar.cOf.appId;
                    int i2 = seVar.cOf.cOi;
                    Cursor query = auV.gVj.query("AppBrandWxaPkgManifestRecord", new String[]{"pkgPath"}, String.format(Locale.US, "%s=? and %s=?", new Object[]{"appId", "debugType"}), new String[]{zm, String.valueOf(i2)}, null, null, null);
                    if (query == null) {
                        str = null;
                    } else {
                        str = query.moveToFirst() ? query.getString(0) : null;
                        query.close();
                    }
                    if (bo.isNullOrNil(str) || !e.ct(str)) {
                        Object obj;
                        ax auV2 = f.auV();
                        String str2 = seVar.cOf.appId;
                        int i3 = seVar.cOf.cOi;
                        if ((com.tencent.mm.plugin.appbrand.appcache.j.a.kR(i3) ? 1 : auV2.au(str2, i3)) < 0) {
                            ab.e("MicroMsg.AppBrandWxaPkgStorage", "hasModuleList, appId(%s), type(%s), version(%d), not records", str2, Integer.valueOf(i3), Integer.valueOf(com.tencent.mm.plugin.appbrand.appcache.j.a.kR(i3) ? 1 : auV2.au(str2, i3)));
                        } else {
                            String format = String.format(Locale.US, "where %s like '%s$%%' and %s=%d and %s=%d", new Object[]{"appId", str2, "debugType", Integer.valueOf(i3), "version", Integer.valueOf(com.tencent.mm.plugin.appbrand.appcache.j.a.kR(i3) ? 1 : auV2.au(str2, i3))});
                            query = auV2.gVj.a(String.format(Locale.US, "select count(*) from %s %s", new Object[]{"AppBrandWxaPkgManifestRecord", format}), null, 2);
                            int i4;
                            if (query == null || query.isClosed()) {
                                ab.e("MicroMsg.AppBrandWxaPkgStorage", "hasModuleList, appId(%s), type(%s), version(%d), cursor nil", str2, Integer.valueOf(i3), Integer.valueOf(i4));
                            } else {
                                i4 = query.moveToFirst() ? query.getInt(0) : 0;
                                query.close();
                                if (i4 > 0) {
                                    obj = 1;
                                    if (obj != null) {
                                        seVar.cOg.cOw = true;
                                        ab.i("MicroMsg.AppBrandLaunchFromOuterEventListener", "callback with appId(%s) type(%d), hasModuleList=true", seVar.cOf.appId, Integer.valueOf(seVar.cOf.cOi));
                                        AppBrandLaunchProxyUI.a(seVar.cOf.context, seVar.cOf.userName, seVar.cOf.cOh, seVar.cOf.cOi, 0, appBrandStatObject, appBrandLaunchReferrer, seVar.cOf.cOn);
                                        AppMethodBeat.o(131703);
                                        return true;
                                    }
                                }
                            }
                        }
                        obj = null;
                        if (obj != null) {
                        }
                    } else {
                        seVar.cOg.cOw = true;
                        AppBrandLaunchProxyUI.a(seVar.cOf.context, seVar.cOf.userName, seVar.cOf.cOh, seVar.cOf.cOi, 0, appBrandStatObject, appBrandLaunchReferrer, seVar.cOf.cOn);
                        AppMethodBeat.o(131703);
                        return true;
                    }
                }
                seVar.cOg.cOw = false;
                seVar.cOg.cOx = "local pkg not exists";
                if (seVar.cOf.cOm) {
                    zm = null;
                    if (seVar.cOf.cOi == 1) {
                        zm = com.tencent.mm.plugin.appbrand.s.e.getMMString(R.string.hl, new Object[0]);
                    } else if (seVar.cOf.cOi == 2) {
                        zm = com.tencent.mm.plugin.appbrand.s.e.getMMString(R.string.l7, new Object[0]);
                    }
                    com.tencent.mm.plugin.appbrand.ipc.a.a(seVar.cOf.context, zm, com.tencent.mm.plugin.appbrand.s.e.getMMString(R.string.tz, new Object[0]), com.tencent.mm.plugin.appbrand.s.e.getMMString(R.string.s6, new Object[0]), "", null, null, null);
                }
                AppMethodBeat.o(131703);
                return true;
                break;
            default:
                seVar.cOg.cOw = false;
                seVar.cOg.cOx = "invalid openType";
                AppMethodBeat.o(131703);
                return true;
        }
        seVar.cOg.cOw = true;
        AppMethodBeat.o(131703);
        return true;
    }
}
