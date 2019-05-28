package com.tencent.p177mm.plugin.appbrand.launching.p906b;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelappbrand.LaunchParamsOptional;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.dynamic.p289j.C19194a.C19191d;
import com.tencent.p177mm.plugin.appbrand.dynamic.p892k.C33167b;
import com.tencent.p177mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.p177mm.plugin.appbrand.launching.C27157aa;
import com.tencent.p177mm.plugin.appbrand.launching.C38432z;
import com.tencent.p177mm.plugin.appbrand.launching.C42611l;
import com.tencent.p177mm.plugin.appbrand.launching.p906b.C38419h.C27162a;
import com.tencent.p177mm.plugin.appbrand.launching.p906b.C38419h.C384201;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.report.C19693f;
import com.tencent.p177mm.plugin.appbrand.service.C42686d;
import com.tencent.p177mm.plugin.appbrand.task.C45694h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.b.a */
public abstract class C10590a {

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.b.a$a */
    public enum C10593a {
        OK,
        ERR_URL_INVALID,
        ERR_UIN_INVALID,
        ERR_DEV_CODE_EXPIRED;

        static {
            AppMethodBeat.m2505o(132031);
        }
    }

    /* renamed from: a */
    public abstract void mo22104a(String str, Uri uri, C10593a c10593a);

    /* renamed from: a */
    public final C10593a mo22103a(Context context, String str, int i, Bundle bundle) {
        C10593a c10593a;
        C4990ab.m7417i("MicroMsg.AppBrand.AbsLinkOpener", "handle url = %s", str);
        Uri uri = null;
        if (C5046bo.isNullOrNil(str)) {
            c10593a = C10593a.ERR_URL_INVALID;
        } else {
            int indexOf = str.indexOf(35);
            int indexOf2 = str.indexOf(63);
            if (indexOf > 0 && indexOf2 > 0 && indexOf < indexOf2) {
                str = str.substring(0, indexOf) + str.substring(indexOf2, str.length());
                C4990ab.m7417i("MicroMsg.AppBrand.AbsLinkOpener", "replace url for parsing %s", str);
            }
            Uri parse = Uri.parse(str);
            String queryParameter;
            String queryParameter2;
            if ((C5046bo.getInt(parse.getQueryParameter("debug"), 0) > 0 ? 1 : null) != null) {
                indexOf = C5046bo.getInt(parse.getQueryParameter("ret"), 0);
                if (indexOf == 1) {
                    c10593a = C10593a.ERR_UIN_INVALID;
                    uri = parse;
                } else if (indexOf == 2) {
                    c10593a = C10593a.ERR_DEV_CODE_EXPIRED;
                    uri = parse;
                } else {
                    String queryParameter3 = parse.getQueryParameter("appid");
                    String queryParameter4 = parse.getQueryParameter("username");
                    String nullAsNil = C5046bo.nullAsNil(parse.getQueryParameter("path"));
                    queryParameter = parse.getQueryParameter("codeurl");
                    queryParameter2 = parse.getQueryParameter("md5");
                    String queryParameter5 = parse.getQueryParameter("pageurl");
                    String queryParameter6 = parse.getQueryParameter("pagemd5");
                    long j = C5046bo.getLong(parse.getQueryParameter("test_lifespan"), 7200);
                    if (C5046bo.isNullOrNil(queryParameter3) || C5046bo.isNullOrNil(queryParameter4) || C5046bo.isNullOrNil(queryParameter)) {
                        C4990ab.m7417i("MicroMsg.AppBrand.AbsLinkOpener", "appId = %s, username = %s, codeURL = %s, invalid, return", queryParameter3, queryParameter4, queryParameter);
                        c10593a = C10593a.ERR_URL_INVALID;
                        uri = parse;
                    } else {
                        boolean a = C42340f.auV().mo60848a(queryParameter3, 1, queryParameter, queryParameter2, 0, C5046bo.anT() + j);
                        if (!(C5046bo.isNullOrNil(queryParameter5) || C5046bo.isNullOrNil(queryParameter6))) {
                            C42340f.auV().mo60848a(queryParameter3, Downloads.MIN_WAIT_FOR_NETWORK, queryParameter5, queryParameter6, 0, C5046bo.anT() + j);
                            indexOf = C33167b.m54217cX(0, 1);
                            if (indexOf == Downloads.MIN_WAIT_FOR_NETWORK) {
                                Bundle bundle2 = new Bundle();
                                bundle2.putString("appId", queryParameter3);
                                bundle2.putInt("debugType", indexOf);
                                C9549f.m17012a("com.tencent.mm", bundle2, C19191d.class, null);
                            }
                        }
                        if (a) {
                            C45694h.m84422bt(queryParameter3, 1);
                        }
                        String queryParameter7 = parse.getQueryParameter("json_extinfo");
                        LaunchParamsOptional launchParamsOptional = new LaunchParamsOptional();
                        launchParamsOptional.fpI = queryParameter7;
                        ((C42611l) C42340f.m74878E(C42611l.class)).mo68053n(queryParameter3, 1, queryParameter7);
                        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                        C10590a.m18269a(str, i, appBrandStatObject, bundle);
                        AppBrandLaunchProxyUI.m25693a(context, queryParameter4, nullAsNil, 1, -1, appBrandStatObject, null, launchParamsOptional);
                    }
                }
            } else {
                queryParameter2 = parse.getQueryParameter("username");
                if (C5046bo.isNullOrNil(queryParameter2)) {
                    C4990ab.m7417i("MicroMsg.AppBrand.AbsLinkOpener", "username = %s, invalid, return", queryParameter2);
                    c10593a = C10593a.ERR_URL_INVALID;
                    uri = parse;
                } else {
                    queryParameter = bundle != null ? bundle.getString("stat_app_id") : null;
                    if (C5046bo.isNullOrNil(queryParameter)) {
                        C10590a.m18268a(context, str, parse, i, bundle, queryParameter2);
                    } else {
                        final Context context2 = context;
                        final String str2 = str;
                        final Uri uri2 = parse;
                        final int i2 = i;
                        final Bundle bundle3 = bundle;
                        C105911 c105911 = new C27162a() {

                            /* renamed from: com.tencent.mm.plugin.appbrand.launching.b.a$1$1 */
                            class C105921 implements Runnable {
                                C105921() {
                                }

                                public final void run() {
                                    AppMethodBeat.m2504i(132026);
                                    Toast.makeText(C4996ah.getContext(), C25738R.string.f8853h5, 1).show();
                                    AppMethodBeat.m2505o(132026);
                                }
                            }

                            public final void aHG() {
                                AppMethodBeat.m2504i(132027);
                                C4990ab.m7417i("MicroMsg.AppBrand.AbsLinkOpener", "[banjump] should ban, from appid:%s, to username:%s", queryParameter, queryParameter2);
                                new C7306ak(Looper.getMainLooper()).post(new C105921());
                                AppMethodBeat.m2505o(132027);
                            }

                            public final void aHH() {
                                AppMethodBeat.m2504i(132028);
                                C4990ab.m7417i("MicroMsg.AppBrand.AbsLinkOpener", "[banjump] not ban, from appid:%s, to username:%s", queryParameter, queryParameter2);
                                C10590a.m18268a(context2, str2, uri2, i2, bundle3, queryParameter2);
                                AppMethodBeat.m2505o(132028);
                            }
                        };
                        C27157aa c27157aa = new C27157aa();
                        c27157aa.field_appId = queryParameter;
                        C38432z auP = C42340f.auP();
                        if (auP == null) {
                            C4990ab.m7420w("MicroMsg.AppBrand.WxaBanJumpHelper", "[banjump] shouldBanJump false, wxapp cache storage is null");
                            C38419h.m65005a(c105911);
                        } else {
                            if (auP.mo61133a(c27157aa, "appId")) {
                                Object obj;
                                if (c27157aa.mo44828Cj("banJumpApp") || c27157aa.mo44828Cj("banJumpGame")) {
                                    obj = 1;
                                } else {
                                    obj = null;
                                }
                                if (obj != null) {
                                    ((C42686d) C1720g.m3528K(C42686d.class)).mo44615a(queryParameter2, new C384201(c105911, c27157aa));
                                }
                            }
                            C4990ab.m7417i("MicroMsg.AppBrand.WxaBanJumpHelper", "[banjump] shouldBanJump, no ban info for appid:%s", queryParameter);
                            C38419h.m65005a(c105911);
                        }
                    }
                }
            }
            c10593a = C10593a.OK;
            uri = parse;
        }
        mo22104a(str, uri, c10593a);
        return c10593a;
    }

    /* renamed from: a */
    static void m18268a(Context context, String str, Uri uri, int i, Bundle bundle, String str2) {
        String nullAsNil = C5046bo.nullAsNil(uri.getQueryParameter("path"));
        int i2 = C5046bo.getInt(uri.getQueryParameter("version"), 0);
        int i3 = C5046bo.getInt(uri.getQueryParameter("type"), 0);
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        C10590a.m18269a(str, i, appBrandStatObject, bundle);
        AppBrandLaunchProxyUI.m25693a(context, str2, nullAsNil, i3, i2, appBrandStatObject, null, null);
    }

    /* renamed from: a */
    private static void m18269a(String str, int i, AppBrandStatObject appBrandStatObject, Bundle bundle) {
        appBrandStatObject.scene = i;
        appBrandStatObject.cst = C18178q.encode(str);
        appBrandStatObject.cOq = C19693f.m30514h(i, bundle);
        appBrandStatObject.cOr = C19693f.m30515i(i, bundle);
        if (i == FilterEnum4Shaka.MIC_SHAKA_ADD2_2 || i == 1018) {
            appBrandStatObject.cOo = 0;
        } else {
            appBrandStatObject.cOo = i;
        }
    }
}
