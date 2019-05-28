package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import org.json.JSONObject;

public final class f extends a<s> {
    public static final int CTRL_INDEX = 74;
    public static final String NAME = "shareTimeline";
    private static boolean hWB = false;

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(131451);
        final s sVar = (s) cVar;
        if (hWB) {
            hWB = false;
            if (jSONObject != null) {
                sVar.getRuntime().atH();
                final Context context = (MMActivity) sVar.ad(MMActivity.class);
                if (context == null) {
                    sVar.M(i, j("fail", null));
                    AppMethodBeat.o(131451);
                    return;
                }
                String str;
                try {
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        str = (String) keys.next();
                        ab.i("MicroMsg.JsApiShareTimeline", "%s, %s", str, jSONObject.get(str));
                    }
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.JsApiShareTimeline", e, "", new Object[0]);
                }
                final String optString = jSONObject.optString("path");
                final String appId = sVar.getAppId();
                str = jSONObject.optString("desc");
                String optString2 = jSONObject.optString("title");
                String str2 = sVar.getRuntime().atI().username;
                String optString3 = jSONObject.optString("imgUrl");
                String xh = v.xh(sVar.getAppId());
                ab.i("MicroMsg.JsApiShareTimeline", "doSendMessage, title = %s, description = %s ,username = %s , path = %s ,thumbIconUrl = %s", optString2, str, str2, optString, optString3);
                ab.i("MicroMsg.JsApiShareTimeline", "doTimeline, errorUrl:[%s]", xh);
                ab.i("MicroMsg.JsApiShareTimeline", "doTimeline, init intent");
                Intent intent = new Intent();
                intent.putExtra("Ksnsupload_link", xh);
                intent.putExtra("Ksnsupload_title", optString2);
                intent.putExtra("Ksnsupload_contentattribute", 0);
                if (u.t(optString3, "http://") || u.t(optString3, "https://")) {
                    intent.putExtra("Ksnsupload_imgurl", optString3);
                } else {
                    Bitmap j = com.tencent.mm.plugin.appbrand.page.s.j(sVar.getRuntime(), optString3);
                    byte[] bArr = new byte[0];
                    if (j == null || j.isRecycled()) {
                        ab.e("MicroMsg.JsApiShareTimeline", "thumb image is null");
                    } else {
                        ab.i("MicroMsg.JsApiShareTimeline", "thumb image is not null");
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
                ab.d("MicroMsg.JsApiShareTimeline", "report, appId : %s, path: %s", appId, optString);
                str = com.tencent.mm.model.v.nW("wxapp_" + appId + optString);
                com.tencent.mm.model.v.Zp().y(str, true).j("prePublishId", "wxapp_" + appId + optString);
                intent.putExtra("reportSessionId", str);
                ab.i("MicroMsg.JsApiShareTimeline", "doTimeline, start activity");
                intent.putExtra("need_result", true);
                final int i2 = i;
                context.ifE = new MMActivity.a() {
                    public final void c(int i, int i2, Intent intent) {
                        AppMethodBeat.i(131450);
                        if (i == 0) {
                            if (i2 == -1) {
                                h.bQ(context, context.getResources().getString(R.string.to));
                                f.b(appId, optString, "", 1, i2);
                                ab.i("MicroMsg.JsApiShareTimeline", "result is success");
                                sVar.M(i2, f.this.j("success", null));
                                AppMethodBeat.o(131450);
                                return;
                            }
                            ab.i("MicroMsg.JsApiShareTimeline", "result is cancel");
                            sVar.M(i2, f.this.j("cancel", null));
                            f.b(appId, optString, "", 3, i2);
                        }
                        AppMethodBeat.o(131450);
                    }
                };
                d.a(context, "sns", ".ui.SnsUploadUI", intent, 0, false);
                AppMethodBeat.o(131451);
                return;
            }
            ab.i("MicroMsg.JsApiShareTimeline", "data is null");
            sVar.M(i, j("fail", null));
            AppMethodBeat.o(131451);
            return;
        }
        sVar.M(i, j("fail", null));
        AppMethodBeat.o(131451);
    }

    public static void aES() {
        hWB = true;
    }

    static /* synthetic */ void b(String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.i(131452);
        com.tencent.mm.plugin.appbrand.report.c.a(str, str2, 3, str3, bo.anT(), i, i2);
        AppMethodBeat.o(131452);
    }
}
