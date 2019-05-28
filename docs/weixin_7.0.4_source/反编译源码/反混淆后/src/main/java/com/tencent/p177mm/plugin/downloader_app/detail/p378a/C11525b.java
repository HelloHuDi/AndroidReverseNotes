package com.tencent.p177mm.plugin.downloader_app.detail.p378a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.p146d.C17821n;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.downloader_app.detail.a.b */
public class C11525b extends C22840bc<C17821n> {
    public final String name() {
        return "imagePreview";
    }

    public final int biG() {
        return 0;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
        AppMethodBeat.m2504i(136069);
        C4990ab.m7416i("MicroMsg.JsApiImagePreview", "invokeInOwn");
        String optString = c32183a.bPa.bOf.optString("current");
        JSONArray optJSONArray = c32183a.bPa.bOf.optJSONArray("urls");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray == null || optJSONArray.length() == 0) {
            C4990ab.m7412e("MicroMsg.JsApiImagePreview", "fail, urls is null");
            c32183a.mo52824a("invalid_url", null);
            AppMethodBeat.m2505o(136069);
            return;
        }
        String str;
        for (int i = 0; i < optJSONArray.length(); i++) {
            String optString2 = optJSONArray.optString(i);
            if (C5046bo.isNullOrNil(optString2) || optString2.equalsIgnoreCase(BuildConfig.COMMAND)) {
                C4990ab.m7413e("MicroMsg.JsApiImagePreview", "null url, i = %d", Integer.valueOf(i));
            } else {
                arrayList.add(optString2);
            }
        }
        String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        if (C5046bo.isNullOrNil(optString)) {
            str = strArr[0];
        } else {
            str = optString;
        }
        Intent intent = new Intent();
        intent.putExtra("nowUrl", str);
        intent.putExtra("urlList", strArr);
        intent.putExtra("type", -255);
        intent.putExtra("isFromWebView", true);
        Context context = (Activity) ((C17821n) c32183a.bOZ).mContext;
        C25985d.m41467b(context, "subapp", ".ui.gallery.GestureGalleryUI", intent);
        context.overridePendingTransition(C25738R.anim.f8344bi, C25738R.anim.f8344bi);
        c32183a.mo52824a("", null);
        AppMethodBeat.m2505o(136069);
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
    }
}
