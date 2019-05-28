package com.tencent.mm.plugin.downloader_app.detail.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.webview.luggage.jsapi.bc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import org.json.JSONArray;

public class b extends bc<n> {
    public final String name() {
        return "imagePreview";
    }

    public final int biG() {
        return 0;
    }

    public final void b(a aVar) {
        AppMethodBeat.i(136069);
        ab.i("MicroMsg.JsApiImagePreview", "invokeInOwn");
        String optString = aVar.bPa.bOf.optString("current");
        JSONArray optJSONArray = aVar.bPa.bOf.optJSONArray("urls");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray == null || optJSONArray.length() == 0) {
            ab.e("MicroMsg.JsApiImagePreview", "fail, urls is null");
            aVar.a("invalid_url", null);
            AppMethodBeat.o(136069);
            return;
        }
        String str;
        for (int i = 0; i < optJSONArray.length(); i++) {
            String optString2 = optJSONArray.optString(i);
            if (bo.isNullOrNil(optString2) || optString2.equalsIgnoreCase(BuildConfig.COMMAND)) {
                ab.e("MicroMsg.JsApiImagePreview", "null url, i = %d", Integer.valueOf(i));
            } else {
                arrayList.add(optString2);
            }
        }
        String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        if (bo.isNullOrNil(optString)) {
            str = strArr[0];
        } else {
            str = optString;
        }
        Intent intent = new Intent();
        intent.putExtra("nowUrl", str);
        intent.putExtra("urlList", strArr);
        intent.putExtra("type", -255);
        intent.putExtra("isFromWebView", true);
        Context context = (Activity) ((n) aVar.bOZ).mContext;
        d.b(context, "subapp", ".ui.gallery.GestureGalleryUI", intent);
        context.overridePendingTransition(R.anim.bi, R.anim.bi);
        aVar.a("", null);
        AppMethodBeat.o(136069);
    }

    public final void a(Context context, String str, bc.a aVar) {
    }
}
