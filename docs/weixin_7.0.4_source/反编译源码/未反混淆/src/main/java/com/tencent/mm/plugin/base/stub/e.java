package com.tencent.mm.plugin.base.stub;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.aa.i;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.rtmp.TXLivePushConfig;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public final class e {

    /* renamed from: com.tencent.mm.plugin.base.stub.e$1 */
    static class AnonymousClass1 implements f {
        final /* synthetic */ Runnable jDJ;
        final /* synthetic */ Activity val$activity;

        AnonymousClass1(Activity activity, Runnable runnable) {
            this.val$activity = activity;
            this.jDJ = runnable;
        }

        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(18158);
            aw.Rg().b((int) TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, (f) this);
            ab.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult translateLink: errType = %d; errCode = %d; errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i == 0 && i2 == 0) {
                ab.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult respUriStr=%s", ((z) mVar).ajD());
                try {
                    Uri parse = Uri.parse(((z) mVar).ajD());
                    if (parse == null) {
                        ab.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult: respUri null");
                        e.y(this.val$activity);
                        AppMethodBeat.o(18158);
                        return;
                    }
                    String queryParameter = parse.getQueryParameter("result");
                    if (queryParameter != null) {
                        ab.d("MicroMsg.WXBizLogic", "dealWithHandleScanResult: result=%s", URLDecoder.decode(queryParameter));
                        cf cfVar = new cf();
                        cfVar.cvm.activity = this.val$activity;
                        cfVar.cvm.ctB = queryParameter;
                        cfVar.cvm.cvn = 19;
                        cfVar.cvm.from = 3;
                        cfVar.cvm.cvq = parse.getQueryParameter("appid");
                        cfVar.cvm.cvs = this.val$activity.getIntent().getBundleExtra("_stat_obj");
                        a.xxA.m(cfVar);
                        if (this.jDJ != null) {
                            this.jDJ.run();
                        }
                        al.n(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(18157);
                                AnonymousClass1.this.val$activity.finish();
                                AppMethodBeat.o(18157);
                            }
                        }, 100);
                    }
                    AppMethodBeat.o(18158);
                    return;
                } catch (Exception e) {
                    ab.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult: respUri parse exp=%s", e);
                    e.y(this.val$activity);
                    AppMethodBeat.o(18158);
                    return;
                }
            }
            ab.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult: translate failed");
            e.y(this.val$activity);
            AppMethodBeat.o(18158);
        }
    }

    public static boolean a(Context context, String[] strArr, String[] strArr2) {
        AppMethodBeat.i(18159);
        if (context == null) {
            ab.e("MicroMsg.WXBizLogic", "context is null");
            AppMethodBeat.o(18159);
            return false;
        }
        String str = null;
        String str2 = null;
        if (strArr2 != null && strArr2.length > 0) {
            str = strArr2[0];
            str2 = g.x(p.bx(context, strArr2[0])[0].toByteArray());
        }
        ab.i("MicroMsg.WXBizLogic", "openBusinessWebview packageName = %s, sig = %s", str, str2);
        if (strArr == null || strArr.length < 3) {
            ab.e("MicroMsg.WXBizLogic", "args is null");
            AppMethodBeat.o(18159);
            return false;
        }
        String str3 = strArr[0];
        if (bo.isNullOrNil(str3)) {
            ab.e("MicroMsg.WXBizLogic", "appId is null");
            AppMethodBeat.o(18159);
            return false;
        }
        if (bo.getInt(strArr[1], 0) <= 0) {
            ab.e("MicroMsg.WXBizLogic", "businessType(%d) invalid", Integer.valueOf(bo.getInt(strArr[1], 0)));
            AppMethodBeat.o(18159);
            return false;
        }
        ab.i("MicroMsg.WXBizLogic", "openBusinessWebview, appid = %s, businessType = %d, queryInfo = %s", str3, Integer.valueOf(r5), bo.nullAsNil(strArr[2]));
        String str4 = "";
        try {
            str4 = URLEncoder.encode(bo.nullAsNil(bo.nullAsNil(strArr[2])), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            ab.printErrStackTrace("MicroMsg.WXBizLogic", e, "", new Object[0]);
        }
        ab.i("MicroMsg.WXBizLogic", "openBusinessWebview url format = %s", String.format("weixin://dl/openbusinesswebview/link?appid=%s&type=%d&query=%s", new Object[]{str3, Integer.valueOf(r5), str4}));
        Intent intent = new Intent(context, WXBizEntryActivity.class);
        intent.setData(Uri.parse(str4));
        intent.addFlags(268435456);
        intent.putExtra("key_package_name", str);
        intent.putExtra("key_app_id", str3);
        intent.putExtra("translate_link_scene", 1);
        intent.putExtra("key_package_signature", str2);
        intent.putExtra("key_command_id", 25);
        context.startActivity(intent);
        AppMethodBeat.o(18159);
        return true;
    }

    public static boolean b(Context context, String[] strArr, String[] strArr2) {
        AppMethodBeat.i(18160);
        if (context == null) {
            ab.e("MicroMsg.WXBizLogic", "context is null");
            AppMethodBeat.o(18160);
            return false;
        }
        String str = null;
        String str2 = null;
        if (strArr2 != null && strArr2.length > 0) {
            str = strArr2[0];
            str2 = g.x(p.bx(context, strArr2[0])[0].toByteArray());
        }
        ab.i("MicroMsg.WXBizLogic", "openBusinessView packageName = %s, sig = %s", str, str2);
        if (strArr == null || strArr.length < 4) {
            ab.e("MicroMsg.WXBizLogic", "args is null");
            AppMethodBeat.o(18160);
            return false;
        }
        String str3 = strArr[0];
        if (bo.isNullOrNil(str3)) {
            ab.e("MicroMsg.WXBizLogic", "appId is null");
            AppMethodBeat.o(18160);
            return false;
        }
        String str4 = strArr[1];
        if (bo.isNullOrNil(str4)) {
            ab.e("MicroMsg.WXBizLogic", "businessType isEmpty");
            AppMethodBeat.o(18160);
            return false;
        }
        int optInt;
        Intent intent;
        b y;
        String nullAsNil = bo.nullAsNil(strArr[2]);
        String nullAsNil2 = bo.nullAsNil(strArr[3]);
        boolean startsWith = str4.startsWith(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE);
        String str5 = "weixin://dl/%s/?appid=%s&businessType=%s";
        Object[] objArr = new Object[3];
        objArr[0] = startsWith ? "openNativeView" : "jumpFakeWxa";
        objArr[1] = str3;
        objArr[2] = str4;
        ab.i("MicroMsg.WXBizLogic", "openBusinessView url format = %s,query=%s,extInfo=%s", String.format(str5, objArr), nullAsNil, nullAsNil2);
        if (!(startsWith || bo.isNullOrNil(nullAsNil2))) {
            try {
                optInt = new i(nullAsNil2).optInt("miniProgramType", 0);
                if (optInt < 0 || optInt > 2) {
                    optInt = 0;
                }
            } catch (Exception e) {
            }
            intent = new Intent(context, WXBizEntryActivity.class);
            intent.setData(Uri.parse(str5));
            intent.addFlags(268435456);
            intent.putExtra("key_package_name", str);
            intent.putExtra("key_app_id", str3);
            intent.putExtra("key_business_type", str4);
            intent.putExtra("translate_link_scene", 1);
            intent.putExtra("key_package_signature", str2);
            intent.putExtra("key_command_id", 26);
            context.startActivity(intent);
            y = v.Zp().y("key_data_center_session_id", true);
            y.j("key_launch_miniprogram_type", Integer.valueOf(optInt));
            y.j("key_launch_miniprogram_query_info", nullAsNil);
            y.j("key_open_business_view_ext_info", nullAsNil2);
            AppMethodBeat.o(18160);
            return true;
        }
        optInt = 0;
        intent = new Intent(context, WXBizEntryActivity.class);
        intent.setData(Uri.parse(str5));
        intent.addFlags(268435456);
        intent.putExtra("key_package_name", str);
        intent.putExtra("key_app_id", str3);
        intent.putExtra("key_business_type", str4);
        intent.putExtra("translate_link_scene", 1);
        intent.putExtra("key_package_signature", str2);
        intent.putExtra("key_command_id", 26);
        context.startActivity(intent);
        y = v.Zp().y("key_data_center_session_id", true);
        y.j("key_launch_miniprogram_type", Integer.valueOf(optInt));
        y.j("key_launch_miniprogram_query_info", nullAsNil);
        y.j("key_open_business_view_ext_info", nullAsNil2);
        AppMethodBeat.o(18160);
        return true;
    }

    static /* synthetic */ void y(Activity activity) {
        AppMethodBeat.i(18161);
        Intent intent = new Intent();
        intent.setFlags(268435456);
        intent.setClassName(ah.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
        intent.putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
        intent.putExtra("showShare", false);
        ah.getContext().startActivity(intent);
        if (activity != null) {
            activity.finish();
        }
        AppMethodBeat.o(18161);
    }
}
