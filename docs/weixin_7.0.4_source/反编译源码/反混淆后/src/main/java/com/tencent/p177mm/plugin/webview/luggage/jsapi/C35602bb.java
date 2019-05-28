package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.network.C32856ab;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.C228302;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.C35594b;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.C355951;
import com.tencent.p177mm.plugin.webview.luggage.p1420c.C29782c;
import com.tencent.p177mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.bb */
public class C35602bb extends C46419bd<C24905d> {
    public final String name() {
        return "uploadMediaFile";
    }

    public final int biG() {
        return 0;
    }

    /* renamed from: b */
    public final void mo9618b(final C32183a c32183a) {
        AppMethodBeat.m2504i(6388);
        C4990ab.m7416i("MicroMsg.JsApiUploadMediaFile", "invokeInOwn");
        String optString = c32183a.bPa.bOf.optString("appId");
        String optString2 = c32183a.bPa.bOf.optString("localId");
        C4990ab.m7417i("MicroMsg.JsApiUploadMediaFile", "uploadMediaFile, appid = %s, localid = %s, isShowProgressTips = %b", optString, optString2, Boolean.valueOf(c32183a.bPa.bOf.optInt("isShowProgressTips", 0) == 1));
        if (C5046bo.isNullOrNil(optString) || C5046bo.isNullOrNil(optString2)) {
            C4990ab.m7412e("MicroMsg.JsApiUploadMediaFile", "appId or localid is null or nil.");
            c32183a.mo52824a("missing arguments", null);
            AppMethodBeat.m2505o(6388);
            return;
        }
        final LuggageUploadMediaFileManager luggageUploadMediaFileManager = new LuggageUploadMediaFileManager();
        MMActivity mMActivity = (MMActivity) ((C24905d) c32183a.bOZ).mContext;
        C24905d c24905d = (C24905d) c32183a.bOZ;
        C298041 c298041 = new C35594b() {
            /* renamed from: a */
            public final void mo48039a(boolean z, HashMap<String, Object> hashMap) {
                AppMethodBeat.m2504i(6387);
                C4990ab.m7417i("MicroMsg.JsApiUploadMediaFile", "sucess = %b", Boolean.valueOf(z));
                if (z) {
                    c32183a.mo52825c("", hashMap);
                } else {
                    c32183a.mo52824a("fail", null);
                }
                LuggageUploadMediaFileManager luggageUploadMediaFileManager = luggageUploadMediaFileManager;
                luggageUploadMediaFileManager.knn = null;
                luggageUploadMediaFileManager.uiI = null;
                luggageUploadMediaFileManager.mAppId = null;
                luggageUploadMediaFileManager.ukB = null;
                luggageUploadMediaFileManager.ukD = null;
                AppMethodBeat.m2505o(6387);
            }
        };
        luggageUploadMediaFileManager.knn = mMActivity;
        luggageUploadMediaFileManager.uiI = c24905d;
        luggageUploadMediaFileManager.mAppId = optString;
        luggageUploadMediaFileManager.ukB = optString2;
        luggageUploadMediaFileManager.ukC = r2;
        luggageUploadMediaFileManager.ukD = c298041;
        WebViewJSSDKFileItem aeo = C29782c.aeo(luggageUploadMediaFileManager.ukB);
        if (aeo == null) {
            C4990ab.m7412e("MicroMsg.UploadMediaFileHelp", "item is null");
            luggageUploadMediaFileManager.ukD.mo48039a(false, null);
            AppMethodBeat.m2505o(6388);
        } else if (aeo.cyQ == 1) {
            luggageUploadMediaFileManager.cXq();
            AppMethodBeat.m2505o(6388);
        } else if (C5046bo.isNullOrNil(aeo.heo) || !C1173e.m2561ct(aeo.heo)) {
            C4990ab.m7412e("MicroMsg.UploadMediaFileHelp", "origFilePath is not exist");
            luggageUploadMediaFileManager.ukD.mo48039a(false, null);
            AppMethodBeat.m2505o(6388);
        } else if (C32856ab.m53750ch(luggageUploadMediaFileManager.knn)) {
            luggageUploadMediaFileManager.cXp();
            AppMethodBeat.m2505o(6388);
        } else {
            String my = C5046bo.m7580my((long) C1173e.m2560cs(aeo.heo));
            C30379h.m48449a(luggageUploadMediaFileManager.knn, luggageUploadMediaFileManager.knn.getString(C25738R.string.fyw, new Object[]{my}), luggageUploadMediaFileManager.knn.getString(C25738R.string.f9238tz), false, new C355951(), new C228302());
            AppMethodBeat.m2505o(6388);
        }
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
    }
}
