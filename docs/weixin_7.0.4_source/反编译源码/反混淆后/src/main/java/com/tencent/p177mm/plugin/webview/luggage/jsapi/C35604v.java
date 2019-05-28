package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.p177mm.plugin.webview.modeltools.C29833g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.xweb.C44576b;
import java.util.ArrayList;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.v */
public class C35604v extends C46419bd<C24905d> {
    public final String name() {
        return "imagePreview";
    }

    public final int biG() {
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
        AppMethodBeat.m2504i(6317);
        C4990ab.m7416i("MicroMsg.JsApiImagePreview", "invokeInOwn");
        String optString = c32183a.bPa.bOf.optString("current");
        JSONArray optJSONArray = c32183a.bPa.bOf.optJSONArray("urls");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray == null || optJSONArray.length() == 0) {
            C4990ab.m7412e("MicroMsg.JsApiImagePreview", "fail, urls is null");
            c32183a.mo52824a("invalid_url", null);
            AppMethodBeat.m2505o(6317);
            return;
        }
        String str;
        String str2;
        Intent intent;
        for (int i = 0; i < optJSONArray.length(); i++) {
            Object optString2 = optJSONArray.optString(i);
            if (C5046bo.isNullOrNil(optString2) || optString2.equalsIgnoreCase(BuildConfig.COMMAND)) {
                C4990ab.m7413e("MicroMsg.JsApiImagePreview", "null url, i = %d", Integer.valueOf(i));
            } else {
                if (C5046bo.nullAsNil(optString2).startsWith("weixin://resourceid/")) {
                    WebViewJSSDKFileItem aex = C29833g.cYF().aex(optString2);
                    if (aex != null) {
                        optString2 = aex.heo;
                    }
                }
                arrayList.add(optString2);
            }
        }
        String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        if (C5046bo.isNullOrNil(optString)) {
            str = strArr[0];
        } else if (optString.startsWith("weixin://resourceid/")) {
            WebViewJSSDKFileItem aex2 = C29833g.cYF().aex(optString);
            str = aex2 != null ? aex2.heo : "";
        } else {
            str2 = optString;
            intent = new Intent();
            str = C44576b.dTR().getCookie(((C24905d) c32183a.bOZ).getUrl());
            if (!C5046bo.isNullOrNil(str)) {
                intent.putExtra("cookie", str);
            }
            intent.putExtra("nowUrl", str2);
            intent.putExtra("urlList", strArr);
            intent.putExtra("type", -255);
            intent.putExtra("isFromWebView", true);
            C25985d.m41467b(((C24905d) c32183a.bOZ).mContext, "subapp", ".ui.gallery.GestureGalleryUI", intent);
            c32183a.mo52824a("", null);
            AppMethodBeat.m2505o(6317);
        }
        str2 = str;
        intent = new Intent();
        str = C44576b.dTR().getCookie(((C24905d) c32183a.bOZ).getUrl());
        if (C5046bo.isNullOrNil(str)) {
        }
        intent.putExtra("nowUrl", str2);
        intent.putExtra("urlList", strArr);
        intent.putExtra("type", -255);
        intent.putExtra("isFromWebView", true);
        C25985d.m41467b(((C24905d) c32183a.bOZ).mContext, "subapp", ".ui.gallery.GestureGalleryUI", intent);
        c32183a.mo52824a("", null);
        AppMethodBeat.m2505o(6317);
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
    }
}
