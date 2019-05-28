package com.tencent.mm.plugin.appbrand.launching.b;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.d;
import com.tencent.mm.plugin.appbrand.dynamic.k.b;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.aa;
import com.tencent.mm.plugin.appbrand.launching.l;
import com.tencent.mm.plugin.appbrand.launching.z;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.FilterEnum4Shaka;

public abstract class a {

    public enum a {
        OK,
        ERR_URL_INVALID,
        ERR_UIN_INVALID,
        ERR_DEV_CODE_EXPIRED;

        static {
            AppMethodBeat.o(132031);
        }
    }

    public abstract void a(String str, Uri uri, a aVar);

    public final a a(Context context, String str, int i, Bundle bundle) {
        a aVar;
        ab.i("MicroMsg.AppBrand.AbsLinkOpener", "handle url = %s", str);
        Uri uri = null;
        if (bo.isNullOrNil(str)) {
            aVar = a.ERR_URL_INVALID;
        } else {
            int indexOf = str.indexOf(35);
            int indexOf2 = str.indexOf(63);
            if (indexOf > 0 && indexOf2 > 0 && indexOf < indexOf2) {
                str = str.substring(0, indexOf) + str.substring(indexOf2, str.length());
                ab.i("MicroMsg.AppBrand.AbsLinkOpener", "replace url for parsing %s", str);
            }
            Uri parse = Uri.parse(str);
            String queryParameter;
            String queryParameter2;
            if ((bo.getInt(parse.getQueryParameter("debug"), 0) > 0 ? 1 : null) != null) {
                indexOf = bo.getInt(parse.getQueryParameter("ret"), 0);
                if (indexOf == 1) {
                    aVar = a.ERR_UIN_INVALID;
                    uri = parse;
                } else if (indexOf == 2) {
                    aVar = a.ERR_DEV_CODE_EXPIRED;
                    uri = parse;
                } else {
                    String queryParameter3 = parse.getQueryParameter("appid");
                    String queryParameter4 = parse.getQueryParameter("username");
                    String nullAsNil = bo.nullAsNil(parse.getQueryParameter("path"));
                    queryParameter = parse.getQueryParameter("codeurl");
                    queryParameter2 = parse.getQueryParameter("md5");
                    String queryParameter5 = parse.getQueryParameter("pageurl");
                    String queryParameter6 = parse.getQueryParameter("pagemd5");
                    long j = bo.getLong(parse.getQueryParameter("test_lifespan"), 7200);
                    if (bo.isNullOrNil(queryParameter3) || bo.isNullOrNil(queryParameter4) || bo.isNullOrNil(queryParameter)) {
                        ab.i("MicroMsg.AppBrand.AbsLinkOpener", "appId = %s, username = %s, codeURL = %s, invalid, return", queryParameter3, queryParameter4, queryParameter);
                        aVar = a.ERR_URL_INVALID;
                        uri = parse;
                    } else {
                        boolean a = f.auV().a(queryParameter3, 1, queryParameter, queryParameter2, 0, bo.anT() + j);
                        if (!(bo.isNullOrNil(queryParameter5) || bo.isNullOrNil(queryParameter6))) {
                            f.auV().a(queryParameter3, Downloads.MIN_WAIT_FOR_NETWORK, queryParameter5, queryParameter6, 0, bo.anT() + j);
                            indexOf = b.cX(0, 1);
                            if (indexOf == Downloads.MIN_WAIT_FOR_NETWORK) {
                                Bundle bundle2 = new Bundle();
                                bundle2.putString("appId", queryParameter3);
                                bundle2.putInt("debugType", indexOf);
                                com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", bundle2, d.class, null);
                            }
                        }
                        if (a) {
                            h.bt(queryParameter3, 1);
                        }
                        String queryParameter7 = parse.getQueryParameter("json_extinfo");
                        LaunchParamsOptional launchParamsOptional = new LaunchParamsOptional();
                        launchParamsOptional.fpI = queryParameter7;
                        ((l) f.E(l.class)).n(queryParameter3, 1, queryParameter7);
                        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                        a(str, i, appBrandStatObject, bundle);
                        AppBrandLaunchProxyUI.a(context, queryParameter4, nullAsNil, 1, -1, appBrandStatObject, null, launchParamsOptional);
                    }
                }
            } else {
                queryParameter2 = parse.getQueryParameter("username");
                if (bo.isNullOrNil(queryParameter2)) {
                    ab.i("MicroMsg.AppBrand.AbsLinkOpener", "username = %s, invalid, return", queryParameter2);
                    aVar = a.ERR_URL_INVALID;
                    uri = parse;
                } else {
                    queryParameter = bundle != null ? bundle.getString("stat_app_id") : null;
                    if (bo.isNullOrNil(queryParameter)) {
                        a(context, str, parse, i, bundle, queryParameter2);
                    } else {
                        final Context context2 = context;
                        final String str2 = str;
                        final Uri uri2 = parse;
                        final int i2 = i;
                        final Bundle bundle3 = bundle;
                        AnonymousClass1 anonymousClass1 = new com.tencent.mm.plugin.appbrand.launching.b.h.a() {
                            public final void aHG() {
                                AppMethodBeat.i(132027);
                                ab.i("MicroMsg.AppBrand.AbsLinkOpener", "[banjump] should ban, from appid:%s, to username:%s", queryParameter, queryParameter2);
                                new ak(Looper.getMainLooper()).post(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(132026);
                                        Toast.makeText(ah.getContext(), R.string.h5, 1).show();
                                        AppMethodBeat.o(132026);
                                    }
                                });
                                AppMethodBeat.o(132027);
                            }

                            public final void aHH() {
                                AppMethodBeat.i(132028);
                                ab.i("MicroMsg.AppBrand.AbsLinkOpener", "[banjump] not ban, from appid:%s, to username:%s", queryParameter, queryParameter2);
                                a.a(context2, str2, uri2, i2, bundle3, queryParameter2);
                                AppMethodBeat.o(132028);
                            }
                        };
                        aa aaVar = new aa();
                        aaVar.field_appId = queryParameter;
                        z auP = f.auP();
                        if (auP == null) {
                            ab.w("MicroMsg.AppBrand.WxaBanJumpHelper", "[banjump] shouldBanJump false, wxapp cache storage is null");
                            h.a(anonymousClass1);
                        } else {
                            if (auP.a(aaVar, "appId")) {
                                Object obj;
                                if (aaVar.Cj("banJumpApp") || aaVar.Cj("banJumpGame")) {
                                    obj = 1;
                                } else {
                                    obj = null;
                                }
                                if (obj != null) {
                                    ((com.tencent.mm.plugin.appbrand.service.d) g.K(com.tencent.mm.plugin.appbrand.service.d.class)).a(queryParameter2, new com.tencent.mm.plugin.appbrand.launching.b.h.AnonymousClass1(anonymousClass1, aaVar));
                                }
                            }
                            ab.i("MicroMsg.AppBrand.WxaBanJumpHelper", "[banjump] shouldBanJump, no ban info for appid:%s", queryParameter);
                            h.a(anonymousClass1);
                        }
                    }
                }
            }
            aVar = a.OK;
            uri = parse;
        }
        a(str, uri, aVar);
        return aVar;
    }

    static void a(Context context, String str, Uri uri, int i, Bundle bundle, String str2) {
        String nullAsNil = bo.nullAsNil(uri.getQueryParameter("path"));
        int i2 = bo.getInt(uri.getQueryParameter("version"), 0);
        int i3 = bo.getInt(uri.getQueryParameter("type"), 0);
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        a(str, i, appBrandStatObject, bundle);
        AppBrandLaunchProxyUI.a(context, str2, nullAsNil, i3, i2, appBrandStatObject, null, null);
    }

    private static void a(String str, int i, AppBrandStatObject appBrandStatObject, Bundle bundle) {
        appBrandStatObject.scene = i;
        appBrandStatObject.cst = q.encode(str);
        appBrandStatObject.cOq = com.tencent.mm.plugin.appbrand.report.f.h(i, bundle);
        appBrandStatObject.cOr = com.tencent.mm.plugin.appbrand.report.f.i(i, bundle);
        if (i == FilterEnum4Shaka.MIC_SHAKA_ADD2_2 || i == 1018) {
            appBrandStatObject.cOo = 0;
        } else {
            appBrandStatObject.cOo = i;
        }
    }
}
