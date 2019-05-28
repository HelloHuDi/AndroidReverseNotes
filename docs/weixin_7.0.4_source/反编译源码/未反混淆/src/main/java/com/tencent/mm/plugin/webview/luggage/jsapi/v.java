package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.xweb.b;
import java.util.ArrayList;
import org.json.JSONArray;

public class v extends bd<d> {
    public final String name() {
        return "imagePreview";
    }

    public final int biG() {
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(a aVar) {
        AppMethodBeat.i(6317);
        ab.i("MicroMsg.JsApiImagePreview", "invokeInOwn");
        String optString = aVar.bPa.bOf.optString("current");
        JSONArray optJSONArray = aVar.bPa.bOf.optJSONArray("urls");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray == null || optJSONArray.length() == 0) {
            ab.e("MicroMsg.JsApiImagePreview", "fail, urls is null");
            aVar.a("invalid_url", null);
            AppMethodBeat.o(6317);
            return;
        }
        String str;
        String str2;
        Intent intent;
        for (int i = 0; i < optJSONArray.length(); i++) {
            Object optString2 = optJSONArray.optString(i);
            if (bo.isNullOrNil(optString2) || optString2.equalsIgnoreCase(BuildConfig.COMMAND)) {
                ab.e("MicroMsg.JsApiImagePreview", "null url, i = %d", Integer.valueOf(i));
            } else {
                if (bo.nullAsNil(optString2).startsWith("weixin://resourceid/")) {
                    WebViewJSSDKFileItem aex = g.cYF().aex(optString2);
                    if (aex != null) {
                        optString2 = aex.heo;
                    }
                }
                arrayList.add(optString2);
            }
        }
        String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        if (bo.isNullOrNil(optString)) {
            str = strArr[0];
        } else if (optString.startsWith("weixin://resourceid/")) {
            WebViewJSSDKFileItem aex2 = g.cYF().aex(optString);
            str = aex2 != null ? aex2.heo : "";
        } else {
            str2 = optString;
            intent = new Intent();
            str = b.dTR().getCookie(((d) aVar.bOZ).getUrl());
            if (!bo.isNullOrNil(str)) {
                intent.putExtra("cookie", str);
            }
            intent.putExtra("nowUrl", str2);
            intent.putExtra("urlList", strArr);
            intent.putExtra("type", -255);
            intent.putExtra("isFromWebView", true);
            com.tencent.mm.bp.d.b(((d) aVar.bOZ).mContext, "subapp", ".ui.gallery.GestureGalleryUI", intent);
            aVar.a("", null);
            AppMethodBeat.o(6317);
        }
        str2 = str;
        intent = new Intent();
        str = b.dTR().getCookie(((d) aVar.bOZ).getUrl());
        if (bo.isNullOrNil(str)) {
        }
        intent.putExtra("nowUrl", str2);
        intent.putExtra("urlList", strArr);
        intent.putExtra("type", -255);
        intent.putExtra("isFromWebView", true);
        com.tencent.mm.bp.d.b(((d) aVar.bOZ).mContext, "subapp", ".ui.gallery.GestureGalleryUI", intent);
        aVar.a("", null);
        AppMethodBeat.o(6317);
    }

    public final void a(Context context, String str, bc.a aVar) {
    }
}
