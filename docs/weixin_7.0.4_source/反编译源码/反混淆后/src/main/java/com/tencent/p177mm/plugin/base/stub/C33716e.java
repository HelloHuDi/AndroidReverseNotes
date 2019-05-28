package com.tencent.p177mm.plugin.base.stub;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelsimple.C26475z;
import com.tencent.p177mm.p1174aa.C41726i;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C26102cf;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.rtmp.TXLivePushConfig;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/* renamed from: com.tencent.mm.plugin.base.stub.e */
public final class C33716e {

    /* renamed from: com.tencent.mm.plugin.base.stub.e$1 */
    static class C199961 implements C1202f {
        final /* synthetic */ Runnable jDJ;
        final /* synthetic */ Activity val$activity;

        /* renamed from: com.tencent.mm.plugin.base.stub.e$1$1 */
        class C199971 implements Runnable {
            C199971() {
            }

            public final void run() {
                AppMethodBeat.m2504i(18157);
                C199961.this.val$activity.finish();
                AppMethodBeat.m2505o(18157);
            }
        }

        C199961(Activity activity, Runnable runnable) {
            this.val$activity = activity;
            this.jDJ = runnable;
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(18158);
            C9638aw.m17182Rg().mo14546b((int) TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, (C1202f) this);
            C4990ab.m7417i("MicroMsg.WXBizLogic", "dealWithHandleScanResult translateLink: errType = %d; errCode = %d; errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i == 0 && i2 == 0) {
                C4990ab.m7417i("MicroMsg.WXBizLogic", "dealWithHandleScanResult respUriStr=%s", ((C26475z) c1207m).ajD());
                try {
                    Uri parse = Uri.parse(((C26475z) c1207m).ajD());
                    if (parse == null) {
                        C4990ab.m7412e("MicroMsg.WXBizLogic", "dealWithHandleScanResult: respUri null");
                        C33716e.m55100y(this.val$activity);
                        AppMethodBeat.m2505o(18158);
                        return;
                    }
                    String queryParameter = parse.getQueryParameter("result");
                    if (queryParameter != null) {
                        C4990ab.m7411d("MicroMsg.WXBizLogic", "dealWithHandleScanResult: result=%s", URLDecoder.decode(queryParameter));
                        C26102cf c26102cf = new C26102cf();
                        c26102cf.cvm.activity = this.val$activity;
                        c26102cf.cvm.ctB = queryParameter;
                        c26102cf.cvm.cvn = 19;
                        c26102cf.cvm.from = 3;
                        c26102cf.cvm.cvq = parse.getQueryParameter("appid");
                        c26102cf.cvm.cvs = this.val$activity.getIntent().getBundleExtra("_stat_obj");
                        C4879a.xxA.mo10055m(c26102cf);
                        if (this.jDJ != null) {
                            this.jDJ.run();
                        }
                        C5004al.m7442n(new C199971(), 100);
                    }
                    AppMethodBeat.m2505o(18158);
                    return;
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.WXBizLogic", "dealWithHandleScanResult: respUri parse exp=%s", e);
                    C33716e.m55100y(this.val$activity);
                    AppMethodBeat.m2505o(18158);
                    return;
                }
            }
            C4990ab.m7416i("MicroMsg.WXBizLogic", "dealWithHandleScanResult: translate failed");
            C33716e.m55100y(this.val$activity);
            AppMethodBeat.m2505o(18158);
        }
    }

    /* renamed from: a */
    public static boolean m55098a(Context context, String[] strArr, String[] strArr2) {
        AppMethodBeat.m2504i(18159);
        if (context == null) {
            C4990ab.m7412e("MicroMsg.WXBizLogic", "context is null");
            AppMethodBeat.m2505o(18159);
            return false;
        }
        String str = null;
        String str2 = null;
        if (strArr2 != null && strArr2.length > 0) {
            str = strArr2[0];
            str2 = C1178g.m2591x(C35799p.m58691bx(context, strArr2[0])[0].toByteArray());
        }
        C4990ab.m7417i("MicroMsg.WXBizLogic", "openBusinessWebview packageName = %s, sig = %s", str, str2);
        if (strArr == null || strArr.length < 3) {
            C4990ab.m7412e("MicroMsg.WXBizLogic", "args is null");
            AppMethodBeat.m2505o(18159);
            return false;
        }
        String str3 = strArr[0];
        if (C5046bo.isNullOrNil(str3)) {
            C4990ab.m7412e("MicroMsg.WXBizLogic", "appId is null");
            AppMethodBeat.m2505o(18159);
            return false;
        }
        if (C5046bo.getInt(strArr[1], 0) <= 0) {
            C4990ab.m7413e("MicroMsg.WXBizLogic", "businessType(%d) invalid", Integer.valueOf(C5046bo.getInt(strArr[1], 0)));
            AppMethodBeat.m2505o(18159);
            return false;
        }
        C4990ab.m7417i("MicroMsg.WXBizLogic", "openBusinessWebview, appid = %s, businessType = %d, queryInfo = %s", str3, Integer.valueOf(r5), C5046bo.nullAsNil(strArr[2]));
        String str4 = "";
        try {
            str4 = URLEncoder.encode(C5046bo.nullAsNil(C5046bo.nullAsNil(strArr[2])), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            C4990ab.printErrStackTrace("MicroMsg.WXBizLogic", e, "", new Object[0]);
        }
        C4990ab.m7417i("MicroMsg.WXBizLogic", "openBusinessWebview url format = %s", String.format("weixin://dl/openbusinesswebview/link?appid=%s&type=%d&query=%s", new Object[]{str3, Integer.valueOf(r5), str4}));
        Intent intent = new Intent(context, WXBizEntryActivity.class);
        intent.setData(Uri.parse(str4));
        intent.addFlags(268435456);
        intent.putExtra("key_package_name", str);
        intent.putExtra("key_app_id", str3);
        intent.putExtra("translate_link_scene", 1);
        intent.putExtra("key_package_signature", str2);
        intent.putExtra("key_command_id", 25);
        context.startActivity(intent);
        AppMethodBeat.m2505o(18159);
        return true;
    }

    /* renamed from: b */
    public static boolean m55099b(Context context, String[] strArr, String[] strArr2) {
        AppMethodBeat.m2504i(18160);
        if (context == null) {
            C4990ab.m7412e("MicroMsg.WXBizLogic", "context is null");
            AppMethodBeat.m2505o(18160);
            return false;
        }
        String str = null;
        String str2 = null;
        if (strArr2 != null && strArr2.length > 0) {
            str = strArr2[0];
            str2 = C1178g.m2591x(C35799p.m58691bx(context, strArr2[0])[0].toByteArray());
        }
        C4990ab.m7417i("MicroMsg.WXBizLogic", "openBusinessView packageName = %s, sig = %s", str, str2);
        if (strArr == null || strArr.length < 4) {
            C4990ab.m7412e("MicroMsg.WXBizLogic", "args is null");
            AppMethodBeat.m2505o(18160);
            return false;
        }
        String str3 = strArr[0];
        if (C5046bo.isNullOrNil(str3)) {
            C4990ab.m7412e("MicroMsg.WXBizLogic", "appId is null");
            AppMethodBeat.m2505o(18160);
            return false;
        }
        String str4 = strArr[1];
        if (C5046bo.isNullOrNil(str4)) {
            C4990ab.m7412e("MicroMsg.WXBizLogic", "businessType isEmpty");
            AppMethodBeat.m2505o(18160);
            return false;
        }
        int optInt;
        Intent intent;
        C32800b y;
        String nullAsNil = C5046bo.nullAsNil(strArr[2]);
        String nullAsNil2 = C5046bo.nullAsNil(strArr[3]);
        boolean startsWith = str4.startsWith(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE);
        String str5 = "weixin://dl/%s/?appid=%s&businessType=%s";
        Object[] objArr = new Object[3];
        objArr[0] = startsWith ? "openNativeView" : "jumpFakeWxa";
        objArr[1] = str3;
        objArr[2] = str4;
        C4990ab.m7417i("MicroMsg.WXBizLogic", "openBusinessView url format = %s,query=%s,extInfo=%s", String.format(str5, objArr), nullAsNil, nullAsNil2);
        if (!(startsWith || C5046bo.isNullOrNil(nullAsNil2))) {
            try {
                optInt = new C41726i(nullAsNil2).optInt("miniProgramType", 0);
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
            y = C37922v.m64076Zp().mo60676y("key_data_center_session_id", true);
            y.mo53356j("key_launch_miniprogram_type", Integer.valueOf(optInt));
            y.mo53356j("key_launch_miniprogram_query_info", nullAsNil);
            y.mo53356j("key_open_business_view_ext_info", nullAsNil2);
            AppMethodBeat.m2505o(18160);
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
        y = C37922v.m64076Zp().mo60676y("key_data_center_session_id", true);
        y.mo53356j("key_launch_miniprogram_type", Integer.valueOf(optInt));
        y.mo53356j("key_launch_miniprogram_query_info", nullAsNil);
        y.mo53356j("key_open_business_view_ext_info", nullAsNil2);
        AppMethodBeat.m2505o(18160);
        return true;
    }

    /* renamed from: y */
    static /* synthetic */ void m55100y(Activity activity) {
        AppMethodBeat.m2504i(18161);
        Intent intent = new Intent();
        intent.setFlags(268435456);
        intent.setClassName(C4996ah.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
        intent.putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
        intent.putExtra("showShare", false);
        C4996ah.getContext().startActivity(intent);
        if (activity != null) {
            activity.finish();
        }
        AppMethodBeat.m2505o(18161);
    }
}
