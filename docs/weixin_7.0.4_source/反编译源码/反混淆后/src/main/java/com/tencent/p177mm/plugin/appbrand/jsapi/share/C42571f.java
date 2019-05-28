package com.tencent.p177mm.plugin.appbrand.jsapi.share;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.C19722s;
import com.tencent.p177mm.plugin.appbrand.C42700v;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.page.C38475s;
import com.tencent.p177mm.plugin.appbrand.report.C19690c;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C30152u;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.share.f */
public final class C42571f extends C10296a<C19722s> {
    public static final int CTRL_INDEX = 74;
    public static final String NAME = "shareTimeline";
    private static boolean hWB = false;

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(131451);
        final C19722s c19722s = (C19722s) c2241c;
        if (hWB) {
            hWB = false;
            if (jSONObject != null) {
                c19722s.getRuntime().atH();
                final Context context = (MMActivity) c19722s.mo61197ad(MMActivity.class);
                if (context == null) {
                    c19722s.mo6107M(i, mo73394j("fail", null));
                    AppMethodBeat.m2505o(131451);
                    return;
                }
                String str;
                try {
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        str = (String) keys.next();
                        C4990ab.m7417i("MicroMsg.JsApiShareTimeline", "%s, %s", str, jSONObject.get(str));
                    }
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.JsApiShareTimeline", e, "", new Object[0]);
                }
                final String optString = jSONObject.optString("path");
                final String appId = c19722s.getAppId();
                str = jSONObject.optString("desc");
                String optString2 = jSONObject.optString("title");
                String str2 = c19722s.getRuntime().atI().username;
                String optString3 = jSONObject.optString("imgUrl");
                String xh = C42700v.m75636xh(c19722s.getAppId());
                C4990ab.m7417i("MicroMsg.JsApiShareTimeline", "doSendMessage, title = %s, description = %s ,username = %s , path = %s ,thumbIconUrl = %s", optString2, str, str2, optString, optString3);
                C4990ab.m7417i("MicroMsg.JsApiShareTimeline", "doTimeline, errorUrl:[%s]", xh);
                C4990ab.m7416i("MicroMsg.JsApiShareTimeline", "doTimeline, init intent");
                Intent intent = new Intent();
                intent.putExtra("Ksnsupload_link", xh);
                intent.putExtra("Ksnsupload_title", optString2);
                intent.putExtra("Ksnsupload_contentattribute", 0);
                if (C30152u.m47751t(optString3, "http://") || C30152u.m47751t(optString3, "https://")) {
                    intent.putExtra("Ksnsupload_imgurl", optString3);
                } else {
                    Bitmap j = C38475s.m65114j(c19722s.getRuntime(), optString3);
                    byte[] bArr = new byte[0];
                    if (j == null || j.isRecycled()) {
                        C4990ab.m7412e("MicroMsg.JsApiShareTimeline", "thumb image is null");
                    } else {
                        C4990ab.m7416i("MicroMsg.JsApiShareTimeline", "thumb image is not null");
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        j.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                        bArr = byteArrayOutputStream.toByteArray();
                    }
                    intent.putExtra("Ksnsupload_imgbuf", bArr);
                }
                intent.putExtra("ksnsis_appbrand", true);
                intent.putExtra("Ksnsupload_source", 1);
                intent.putExtra("Ksnsupload_type", 1);
                intent.putExtra("KsnsUpload_BrandUsername", str2);
                intent.putExtra("KsnsUpload_BrandPath", optString);
                C4990ab.m7411d("MicroMsg.JsApiShareTimeline", "report, appId : %s, path: %s", appId, optString);
                str = C37922v.m64078nW("wxapp_" + appId + optString);
                C37922v.m64076Zp().mo60676y(str, true).mo53356j("prePublishId", "wxapp_" + appId + optString);
                intent.putExtra("reportSessionId", str);
                C4990ab.m7416i("MicroMsg.JsApiShareTimeline", "doTimeline, start activity");
                intent.putExtra("need_result", true);
                final int i2 = i;
                context.ifE = new C5186a() {
                    /* renamed from: c */
                    public final void mo6069c(int i, int i2, Intent intent) {
                        AppMethodBeat.m2504i(131450);
                        if (i == 0) {
                            if (i2 == -1) {
                                C30379h.m48465bQ(context, context.getResources().getString(C25738R.string.f9229to));
                                C42571f.m75371b(appId, optString, "", 1, i2);
                                C4990ab.m7416i("MicroMsg.JsApiShareTimeline", "result is success");
                                c19722s.mo6107M(i2, C42571f.this.mo73394j("success", null));
                                AppMethodBeat.m2505o(131450);
                                return;
                            }
                            C4990ab.m7416i("MicroMsg.JsApiShareTimeline", "result is cancel");
                            c19722s.mo6107M(i2, C42571f.this.mo73394j("cancel", null));
                            C42571f.m75371b(appId, optString, "", 3, i2);
                        }
                        AppMethodBeat.m2505o(131450);
                    }
                };
                C25985d.m41453a(context, "sns", ".ui.SnsUploadUI", intent, 0, false);
                AppMethodBeat.m2505o(131451);
                return;
            }
            C4990ab.m7416i("MicroMsg.JsApiShareTimeline", "data is null");
            c19722s.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(131451);
            return;
        }
        c19722s.mo6107M(i, mo73394j("fail", null));
        AppMethodBeat.m2505o(131451);
    }

    public static void aES() {
        hWB = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m75371b(String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.m2504i(131452);
        C19690c.m30500a(str, str2, 3, str3, C5046bo.anT(), i, i2);
        AppMethodBeat.m2505o(131452);
    }
}
