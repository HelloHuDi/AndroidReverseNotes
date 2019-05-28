package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.j.b;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil.a;
import com.tencent.mm.plugin.appbrand.launching.params.AppBrandWeishiParams;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.f;
import com.tencent.mm.plugin.appbrand.service.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.util.VideoMaterialUtil;
import junit.framework.Assert;

public final class an implements e {
    private p eir;
    private boolean hJm = false;

    static /* synthetic */ void b(an anVar) {
        AppMethodBeat.i(132016);
        anVar.aDw();
        AppMethodBeat.o(132016);
    }

    public final void b(Context context, String str, String str2, String str3, int i, String str4, int i2) {
        AppMethodBeat.i(132006);
        if (bo.isNullOrNil(str3)) {
            AppMethodBeat.o(132006);
        } else if (bo.isNullOrNil(str3) || bo.isNullOrNil(str2)) {
            ab.e("MicroMsg.WeAppLauncher", "targetAppId %s referrerAppId %s, Null Or Nil");
            AppMethodBeat.o(132006);
        } else {
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1055;
            appBrandStatObject.cst = q.encode(bo.nullAsNil(str)) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str2 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + i2;
            AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
            appBrandLaunchReferrer.appId = str2;
            appBrandLaunchReferrer.hgQ = 2;
            appBrandLaunchReferrer.url = str;
            AppBrandLaunchProxyUI.a(context, null, str3, str4, i, -1, appBrandStatObject, appBrandLaunchReferrer, null);
            Assert.assertTrue(true);
            AppMethodBeat.o(132006);
        }
    }

    public final void a(Context context, String str, String str2, int i, int i2, String str3, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.i(132007);
        AppBrandLaunchProxyUI.a(context, str, str2, str3, i, i2, appBrandStatObject, null, null);
        AppMethodBeat.o(132007);
    }

    public final void a(Context context, String str, String str2, int i, int i2, String str3, AppBrandStatObject appBrandStatObject, String str4) {
        AppMethodBeat.i(132008);
        AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
        switch (appBrandStatObject.scene) {
            case 1020:
            case 1035:
            case FilterEnum4Shaka.MIC_SHAKA_ADD2_8 /*1043*/:
                appBrandLaunchReferrer.hgQ = 5;
                break;
            case 1036:
            case FilterEnum4Shaka.MIC_WEISHI_SHUILAN /*1069*/:
                appBrandLaunchReferrer.hgQ = 4;
                break;
            case 1055:
                appBrandLaunchReferrer.hgQ = 2;
                break;
        }
        appBrandLaunchReferrer.appId = str4;
        AppBrandLaunchProxyUI.a(context, str, str2, str3, i, i2, appBrandStatObject, appBrandLaunchReferrer, null);
        AppMethodBeat.o(132008);
    }

    public final void a(Context context, String str, String str2, boolean z, b bVar) {
        AppMethodBeat.i(132009);
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = 1036;
        appBrandStatObject.cst = bo.nullAsNil(bVar.appId) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + bo.nullAsNil(q.encode(bVar.url));
        appBrandStatObject.cOq = z ? 2 : 1;
        if (z) {
            str2 = String.format("%s:%s", new Object[]{str, str2});
        }
        appBrandStatObject.cOr = str2;
        LaunchParamsOptional launchParamsOptional = new LaunchParamsOptional();
        if (bo.isNullOrNil(bVar.fiV)) {
            appBrandStatObject.cst += ":0";
        } else {
            launchParamsOptional.bQh = str;
            launchParamsOptional.bQi = bVar.fiV;
            appBrandStatObject.cst += ":1";
        }
        AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
        appBrandLaunchReferrer.hgQ = 4;
        appBrandLaunchReferrer.appId = bVar.appId;
        AppBrandLaunchProxyUI.a(context, bVar.fiP, bVar.fiQ, bVar.fiO, bVar.fiZ, bVar.fja, appBrandStatObject, appBrandLaunchReferrer, launchParamsOptional);
        AppMethodBeat.o(132009);
    }

    public final void a(Context context, String str, String str2, boolean z, b bVar, Bundle bundle) {
        AppMethodBeat.i(132010);
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        LaunchParamsOptional launchParamsOptional = new LaunchParamsOptional();
        AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
        Object obj = bundle.getBoolean("stat_weishi_from_opensdk", false) ? 1 : null;
        if (obj != null) {
            appBrandStatObject.scene = 1036;
            appBrandStatObject.cst = bo.nullAsNil(bVar.appId) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + bo.nullAsNil(q.encode(bVar.url));
            appBrandStatObject.cOq = z ? 2 : 1;
            if (z) {
                str2 = String.format("%s:%s", new Object[]{str, str2});
            }
            appBrandStatObject.cOr = str2;
            ab.i("MicroMsg.WeAppLauncher", "launchWeishiVideoMiniProgram, from opensdk appmsg, scene:%s", Integer.valueOf(appBrandStatObject.scene));
            if (bo.isNullOrNil(bVar.fiV)) {
                appBrandStatObject.cst += ":0";
            } else {
                appBrandStatObject.cst += ":1";
            }
            appBrandLaunchReferrer.appId = bVar.appId;
            appBrandLaunchReferrer.hgQ = 4;
        } else {
            String str3 = bVar.fiU;
            if (z) {
                appBrandStatObject.scene = 1008;
                appBrandStatObject.cst = str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str2 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str3;
            } else {
                appBrandStatObject.scene = 1007;
                appBrandStatObject.cst = str2 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str3;
            }
            appBrandStatObject.cOq = f.h(appBrandStatObject.scene, bundle);
            appBrandStatObject.cOr = f.i(appBrandStatObject.scene, bundle);
            ab.i("MicroMsg.WeAppLauncher", "launchWeishiVideoMiniProgram, from chatting appmsg, scene:%s", Integer.valueOf(appBrandStatObject.scene));
            appBrandLaunchReferrer.appId = bVar.appId;
            appBrandLaunchReferrer.hgQ = 6;
        }
        if (!bo.isNullOrNil(bVar.fiV)) {
            launchParamsOptional.bQh = str;
            launchParamsOptional.bQi = bVar.fiV;
        }
        if ("wxfe02ecfe70800f46".equalsIgnoreCase(bVar.fiQ)) {
            AppBrandWeishiParams appBrandWeishiParams = new AppBrandWeishiParams();
            appBrandWeishiParams.ffp = obj != null ? 1 : 0;
            appBrandWeishiParams.thumbUrl = bundle.getString("stat_weishi_thumb_url", null);
            appBrandWeishiParams.ijv = bundle.getString("stat_weishi_thumb_path", null);
            appBrandWeishiParams.ijw = bundle.getString("stat_weishi_msg_img_path", null);
            appBrandWeishiParams.appId = bundle.getString("stat_app_id", null);
            appBrandWeishiParams.appName = bundle.getString("stat_weishi_app_name", null);
            appBrandWeishiParams.ijx = bundle.getString("stat_weishi_source_username", null);
            launchParamsOptional.bQj = appBrandWeishiParams;
            ab.i("MicroMsg.WeAppLauncher", "launchWeishiVideoMiniProgram, weishi params:%s", appBrandWeishiParams);
        }
        AppBrandLaunchProxyUI.a(context, bVar.fiP, bVar.fiQ, bVar.fiO, bVar.fiZ, bVar.fja, appBrandStatObject, appBrandLaunchReferrer, launchParamsOptional);
        AppMethodBeat.o(132010);
    }

    public final void a(Context context, String str, int i, String str2, AppBrandStatObject appBrandStatObject, String str3, String str4) {
        AppMethodBeat.i(132011);
        AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
        appBrandLaunchReferrer.hgQ = 7;
        appBrandLaunchReferrer.appId = str3;
        appBrandLaunchReferrer.hgT = str4;
        AppBrandLaunchProxyUI.a(context, str, null, str2, i, 0, appBrandStatObject, appBrandLaunchReferrer, null);
        AppMethodBeat.o(132011);
    }

    public final void a(Context context, String str, String str2, final String str3, String str4, int i, int i2) {
        AppMethodBeat.i(132012);
        this.hJm = false;
        a(context, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(132000);
                ab.w("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, user canceled");
                an.this.hJm = true;
                OpenBusinessViewUtil.p(str3, null, -3);
                AppMethodBeat.o(132000);
            }
        });
        final String str5 = str3;
        final String str6 = str;
        final String str7 = str2;
        final int i3 = i2;
        final Context context2 = context;
        final int i4 = i;
        OpenBusinessViewUtil.a(2, str3, str4, str2, str, new a() {
            public final void ce(String str, String str2) {
                AppMethodBeat.i(132001);
                an.b(an.this);
                if (an.this.hJm) {
                    AppMethodBeat.o(132001);
                } else if (bo.isNullOrNil(str)) {
                    ab.e("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, invalid businessType");
                    OpenBusinessViewUtil.p(str5, null, -4);
                    AppMethodBeat.o(132001);
                } else {
                    AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                    appBrandStatObject.scene = 1055;
                    appBrandStatObject.cst = q.encode(bo.nullAsNil(str6)) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str7 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + i3;
                    AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
                    appBrandLaunchReferrer.appId = str7;
                    appBrandLaunchReferrer.hgQ = 2;
                    appBrandLaunchReferrer.url = str6;
                    appBrandLaunchReferrer.businessType = str5;
                    appBrandLaunchReferrer.cvp = 5;
                    if (AppBrandLaunchProxyUI.a(context2, null, str, str2, i4, -1, appBrandStatObject, appBrandLaunchReferrer, null)) {
                        n.xb(str).gPl = false;
                        n.xb(str).gPn = false;
                        n.xb(str).gPm = false;
                        ab.i("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, launch success");
                        AppMethodBeat.o(132001);
                        return;
                    }
                    ab.e("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, launch fail");
                    OpenBusinessViewUtil.p(str5, null, -1);
                    AppMethodBeat.o(132001);
                }
            }

            public final void R(int i, String str) {
                AppMethodBeat.i(132002);
                ab.e("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, launch fail, CGI errCode:%d, errMsg:%s", Integer.valueOf(i), str);
                an.b(an.this);
                OpenBusinessViewUtil.p(str5, null, -2);
                AppMethodBeat.o(132002);
            }
        });
        AppMethodBeat.o(132012);
    }

    public final void a(Context context, final String str, final String str2, String str3, int i) {
        AppMethodBeat.i(132013);
        this.hJm = false;
        a(context, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(132003);
                ab.w("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, user canceled");
                an.this.hJm = true;
                OpenBusinessViewUtil.o(str, str2, -2);
                AppMethodBeat.o(132003);
            }
        });
        final String str4 = str;
        final String str5 = str2;
        final Context context2 = context;
        final int i2 = i;
        OpenBusinessViewUtil.a(1, str2, str3, str, null, new a() {
            public final void ce(String str, String str2) {
                AppMethodBeat.i(132004);
                an.b(an.this);
                if (an.this.hJm) {
                    AppMethodBeat.o(132004);
                } else if (bo.isNullOrNil(str)) {
                    ab.e("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, invalid businessType");
                    OpenBusinessViewUtil.o(str4, str5, -3);
                    AppMethodBeat.o(132004);
                } else {
                    AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                    appBrandStatObject.scene = FilterEnum4Shaka.MIC_WEISHI_SHUILAN;
                    appBrandStatObject.cst = str4;
                    AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
                    appBrandLaunchReferrer.appId = str4;
                    appBrandLaunchReferrer.hgQ = 4;
                    appBrandLaunchReferrer.businessType = str5;
                    appBrandLaunchReferrer.cvp = 5;
                    if (AppBrandLaunchProxyUI.a(context2, null, str, str2, i2, -1, appBrandStatObject, appBrandLaunchReferrer, null)) {
                        n.xb(str).gPl = false;
                        n.xb(str).gPn = false;
                        n.xb(str).gPm = false;
                        ab.i("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, launch success");
                        AppMethodBeat.o(132004);
                        return;
                    }
                    ab.e("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, launch fail");
                    OpenBusinessViewUtil.o(str4, str5, -3);
                    AppMethodBeat.o(132004);
                }
            }

            public final void R(int i, String str) {
                AppMethodBeat.i(132005);
                ab.e("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, launch fail, CGI errCode:%d, errMsg:%s", Integer.valueOf(i), str);
                an.b(an.this);
                OpenBusinessViewUtil.o(str4, str5, -3);
                AppMethodBeat.o(132005);
            }
        });
        AppMethodBeat.o(132013);
    }

    private void a(Context context, OnCancelListener onCancelListener) {
        AppMethodBeat.i(132014);
        aDw();
        context.getString(R.string.tz);
        this.eir = h.b(context, context.getString(R.string.un), true, onCancelListener);
        AppMethodBeat.o(132014);
    }

    private void aDw() {
        AppMethodBeat.i(132015);
        if (this.eir != null) {
            this.eir.dismiss();
            this.eir = null;
        }
        AppMethodBeat.o(132015);
    }
}
