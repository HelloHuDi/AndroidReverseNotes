package com.tencent.p177mm.plugin.appbrand.launching;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.modelappbrand.LaunchParamsOptional;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.plugin.appbrand.C38450n;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.p177mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil;
import com.tencent.p177mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil.C19360a;
import com.tencent.p177mm.plugin.appbrand.launching.params.AppBrandWeishiParams;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.report.C19693f;
import com.tencent.p177mm.plugin.appbrand.service.C45691e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.util.VideoMaterialUtil;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.an */
public final class C42609an implements C45691e {
    private C44275p eir;
    private boolean hJm = false;

    /* renamed from: b */
    static /* synthetic */ void m75438b(C42609an c42609an) {
        AppMethodBeat.m2504i(132016);
        c42609an.aDw();
        AppMethodBeat.m2505o(132016);
    }

    /* renamed from: b */
    public final void mo68051b(Context context, String str, String str2, String str3, int i, String str4, int i2) {
        AppMethodBeat.m2504i(132006);
        if (C5046bo.isNullOrNil(str3)) {
            AppMethodBeat.m2505o(132006);
        } else if (C5046bo.isNullOrNil(str3) || C5046bo.isNullOrNil(str2)) {
            C4990ab.m7412e("MicroMsg.WeAppLauncher", "targetAppId %s referrerAppId %s, Null Or Nil");
            AppMethodBeat.m2505o(132006);
        } else {
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1055;
            appBrandStatObject.cst = C18178q.encode(C5046bo.nullAsNil(str)) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str2 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + i2;
            AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
            appBrandLaunchReferrer.appId = str2;
            appBrandLaunchReferrer.hgQ = 2;
            appBrandLaunchReferrer.url = str;
            AppBrandLaunchProxyUI.m25694a(context, null, str3, str4, i, -1, appBrandStatObject, appBrandLaunchReferrer, null);
            Assert.assertTrue(true);
            AppMethodBeat.m2505o(132006);
        }
    }

    /* renamed from: a */
    public final void mo68045a(Context context, String str, String str2, int i, int i2, String str3, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.m2504i(132007);
        AppBrandLaunchProxyUI.m25694a(context, str, str2, str3, i, i2, appBrandStatObject, null, null);
        AppMethodBeat.m2505o(132007);
    }

    /* renamed from: a */
    public final void mo68046a(Context context, String str, String str2, int i, int i2, String str3, AppBrandStatObject appBrandStatObject, String str4) {
        AppMethodBeat.m2504i(132008);
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
        AppBrandLaunchProxyUI.m25694a(context, str, str2, str3, i, i2, appBrandStatObject, appBrandLaunchReferrer, null);
        AppMethodBeat.m2505o(132008);
    }

    /* renamed from: a */
    public final void mo68049a(Context context, String str, String str2, boolean z, C8910b c8910b) {
        AppMethodBeat.m2504i(132009);
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = 1036;
        appBrandStatObject.cst = C5046bo.nullAsNil(c8910b.appId) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + C5046bo.nullAsNil(C18178q.encode(c8910b.url));
        appBrandStatObject.cOq = z ? 2 : 1;
        if (z) {
            str2 = String.format("%s:%s", new Object[]{str, str2});
        }
        appBrandStatObject.cOr = str2;
        LaunchParamsOptional launchParamsOptional = new LaunchParamsOptional();
        if (C5046bo.isNullOrNil(c8910b.fiV)) {
            appBrandStatObject.cst += ":0";
        } else {
            launchParamsOptional.bQh = str;
            launchParamsOptional.bQi = c8910b.fiV;
            appBrandStatObject.cst += ":1";
        }
        AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
        appBrandLaunchReferrer.hgQ = 4;
        appBrandLaunchReferrer.appId = c8910b.appId;
        AppBrandLaunchProxyUI.m25694a(context, c8910b.fiP, c8910b.fiQ, c8910b.fiO, c8910b.fiZ, c8910b.fja, appBrandStatObject, appBrandLaunchReferrer, launchParamsOptional);
        AppMethodBeat.m2505o(132009);
    }

    /* renamed from: a */
    public final void mo68050a(Context context, String str, String str2, boolean z, C8910b c8910b, Bundle bundle) {
        AppMethodBeat.m2504i(132010);
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        LaunchParamsOptional launchParamsOptional = new LaunchParamsOptional();
        AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
        Object obj = bundle.getBoolean("stat_weishi_from_opensdk", false) ? 1 : null;
        if (obj != null) {
            appBrandStatObject.scene = 1036;
            appBrandStatObject.cst = C5046bo.nullAsNil(c8910b.appId) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + C5046bo.nullAsNil(C18178q.encode(c8910b.url));
            appBrandStatObject.cOq = z ? 2 : 1;
            if (z) {
                str2 = String.format("%s:%s", new Object[]{str, str2});
            }
            appBrandStatObject.cOr = str2;
            C4990ab.m7417i("MicroMsg.WeAppLauncher", "launchWeishiVideoMiniProgram, from opensdk appmsg, scene:%s", Integer.valueOf(appBrandStatObject.scene));
            if (C5046bo.isNullOrNil(c8910b.fiV)) {
                appBrandStatObject.cst += ":0";
            } else {
                appBrandStatObject.cst += ":1";
            }
            appBrandLaunchReferrer.appId = c8910b.appId;
            appBrandLaunchReferrer.hgQ = 4;
        } else {
            String str3 = c8910b.fiU;
            if (z) {
                appBrandStatObject.scene = 1008;
                appBrandStatObject.cst = str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str2 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str3;
            } else {
                appBrandStatObject.scene = 1007;
                appBrandStatObject.cst = str2 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str3;
            }
            appBrandStatObject.cOq = C19693f.m30514h(appBrandStatObject.scene, bundle);
            appBrandStatObject.cOr = C19693f.m30515i(appBrandStatObject.scene, bundle);
            C4990ab.m7417i("MicroMsg.WeAppLauncher", "launchWeishiVideoMiniProgram, from chatting appmsg, scene:%s", Integer.valueOf(appBrandStatObject.scene));
            appBrandLaunchReferrer.appId = c8910b.appId;
            appBrandLaunchReferrer.hgQ = 6;
        }
        if (!C5046bo.isNullOrNil(c8910b.fiV)) {
            launchParamsOptional.bQh = str;
            launchParamsOptional.bQi = c8910b.fiV;
        }
        if ("wxfe02ecfe70800f46".equalsIgnoreCase(c8910b.fiQ)) {
            AppBrandWeishiParams appBrandWeishiParams = new AppBrandWeishiParams();
            appBrandWeishiParams.ffp = obj != null ? 1 : 0;
            appBrandWeishiParams.thumbUrl = bundle.getString("stat_weishi_thumb_url", null);
            appBrandWeishiParams.ijv = bundle.getString("stat_weishi_thumb_path", null);
            appBrandWeishiParams.ijw = bundle.getString("stat_weishi_msg_img_path", null);
            appBrandWeishiParams.appId = bundle.getString("stat_app_id", null);
            appBrandWeishiParams.appName = bundle.getString("stat_weishi_app_name", null);
            appBrandWeishiParams.ijx = bundle.getString("stat_weishi_source_username", null);
            launchParamsOptional.bQj = appBrandWeishiParams;
            C4990ab.m7417i("MicroMsg.WeAppLauncher", "launchWeishiVideoMiniProgram, weishi params:%s", appBrandWeishiParams);
        }
        AppBrandLaunchProxyUI.m25694a(context, c8910b.fiP, c8910b.fiQ, c8910b.fiO, c8910b.fiZ, c8910b.fja, appBrandStatObject, appBrandLaunchReferrer, launchParamsOptional);
        AppMethodBeat.m2505o(132010);
    }

    /* renamed from: a */
    public final void mo68044a(Context context, String str, int i, String str2, AppBrandStatObject appBrandStatObject, String str3, String str4) {
        AppMethodBeat.m2504i(132011);
        AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
        appBrandLaunchReferrer.hgQ = 7;
        appBrandLaunchReferrer.appId = str3;
        appBrandLaunchReferrer.hgT = str4;
        AppBrandLaunchProxyUI.m25694a(context, str, null, str2, i, 0, appBrandStatObject, appBrandLaunchReferrer, null);
        AppMethodBeat.m2505o(132011);
    }

    /* renamed from: a */
    public final void mo68048a(Context context, String str, String str2, final String str3, String str4, int i, int i2) {
        AppMethodBeat.m2504i(132012);
        this.hJm = false;
        m75436a(context, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(132000);
                C4990ab.m7420w("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, user canceled");
                C42609an.this.hJm = true;
                OpenBusinessViewUtil.m30043p(str3, null, -3);
                AppMethodBeat.m2505o(132000);
            }
        });
        final String str5 = str3;
        final String str6 = str;
        final String str7 = str2;
        final int i3 = i2;
        final Context context2 = context;
        final int i4 = i;
        OpenBusinessViewUtil.m30037a(2, str3, str4, str2, str, new C19360a() {
            /* renamed from: ce */
            public final void mo6278ce(String str, String str2) {
                AppMethodBeat.m2504i(132001);
                C42609an.m75438b(C42609an.this);
                if (C42609an.this.hJm) {
                    AppMethodBeat.m2505o(132001);
                } else if (C5046bo.isNullOrNil(str)) {
                    C4990ab.m7412e("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, invalid businessType");
                    OpenBusinessViewUtil.m30043p(str5, null, -4);
                    AppMethodBeat.m2505o(132001);
                } else {
                    AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                    appBrandStatObject.scene = 1055;
                    appBrandStatObject.cst = C18178q.encode(C5046bo.nullAsNil(str6)) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str7 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + i3;
                    AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
                    appBrandLaunchReferrer.appId = str7;
                    appBrandLaunchReferrer.hgQ = 2;
                    appBrandLaunchReferrer.url = str6;
                    appBrandLaunchReferrer.businessType = str5;
                    appBrandLaunchReferrer.cvp = 5;
                    if (AppBrandLaunchProxyUI.m25694a(context2, null, str, str2, i4, -1, appBrandStatObject, appBrandLaunchReferrer, null)) {
                        C38450n.m65049xb(str).gPl = false;
                        C38450n.m65049xb(str).gPn = false;
                        C38450n.m65049xb(str).gPm = false;
                        C4990ab.m7416i("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, launch success");
                        AppMethodBeat.m2505o(132001);
                        return;
                    }
                    C4990ab.m7412e("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, launch fail");
                    OpenBusinessViewUtil.m30043p(str5, null, -1);
                    AppMethodBeat.m2505o(132001);
                }
            }

            /* renamed from: R */
            public final void mo6277R(int i, String str) {
                AppMethodBeat.m2504i(132002);
                C4990ab.m7413e("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, launch fail, CGI errCode:%d, errMsg:%s", Integer.valueOf(i), str);
                C42609an.m75438b(C42609an.this);
                OpenBusinessViewUtil.m30043p(str5, null, -2);
                AppMethodBeat.m2505o(132002);
            }
        });
        AppMethodBeat.m2505o(132012);
    }

    /* renamed from: a */
    public final void mo68047a(Context context, final String str, final String str2, String str3, int i) {
        AppMethodBeat.m2504i(132013);
        this.hJm = false;
        m75436a(context, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(132003);
                C4990ab.m7420w("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, user canceled");
                C42609an.this.hJm = true;
                OpenBusinessViewUtil.m30042o(str, str2, -2);
                AppMethodBeat.m2505o(132003);
            }
        });
        final String str4 = str;
        final String str5 = str2;
        final Context context2 = context;
        final int i2 = i;
        OpenBusinessViewUtil.m30037a(1, str2, str3, str, null, new C19360a() {
            /* renamed from: ce */
            public final void mo6278ce(String str, String str2) {
                AppMethodBeat.m2504i(132004);
                C42609an.m75438b(C42609an.this);
                if (C42609an.this.hJm) {
                    AppMethodBeat.m2505o(132004);
                } else if (C5046bo.isNullOrNil(str)) {
                    C4990ab.m7412e("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, invalid businessType");
                    OpenBusinessViewUtil.m30042o(str4, str5, -3);
                    AppMethodBeat.m2505o(132004);
                } else {
                    AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                    appBrandStatObject.scene = FilterEnum4Shaka.MIC_WEISHI_SHUILAN;
                    appBrandStatObject.cst = str4;
                    AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
                    appBrandLaunchReferrer.appId = str4;
                    appBrandLaunchReferrer.hgQ = 4;
                    appBrandLaunchReferrer.businessType = str5;
                    appBrandLaunchReferrer.cvp = 5;
                    if (AppBrandLaunchProxyUI.m25694a(context2, null, str, str2, i2, -1, appBrandStatObject, appBrandLaunchReferrer, null)) {
                        C38450n.m65049xb(str).gPl = false;
                        C38450n.m65049xb(str).gPn = false;
                        C38450n.m65049xb(str).gPm = false;
                        C4990ab.m7416i("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, launch success");
                        AppMethodBeat.m2505o(132004);
                        return;
                    }
                    C4990ab.m7412e("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, launch fail");
                    OpenBusinessViewUtil.m30042o(str4, str5, -3);
                    AppMethodBeat.m2505o(132004);
                }
            }

            /* renamed from: R */
            public final void mo6277R(int i, String str) {
                AppMethodBeat.m2504i(132005);
                C4990ab.m7413e("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, launch fail, CGI errCode:%d, errMsg:%s", Integer.valueOf(i), str);
                C42609an.m75438b(C42609an.this);
                OpenBusinessViewUtil.m30042o(str4, str5, -3);
                AppMethodBeat.m2505o(132005);
            }
        });
        AppMethodBeat.m2505o(132013);
    }

    /* renamed from: a */
    private void m75436a(Context context, OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(132014);
        aDw();
        context.getString(C25738R.string.f9238tz);
        this.eir = C30379h.m48458b(context, context.getString(C25738R.string.f9260un), true, onCancelListener);
        AppMethodBeat.m2505o(132014);
    }

    private void aDw() {
        AppMethodBeat.m2504i(132015);
        if (this.eir != null) {
            this.eir.dismiss();
            this.eir = null;
        }
        AppMethodBeat.m2505o(132015);
    }
}
