package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.webview.luggage.c.c;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.b;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;

public class bb extends bd<d> {
    public final String name() {
        return "uploadMediaFile";
    }

    public final int biG() {
        return 0;
    }

    public final void b(final a aVar) {
        AppMethodBeat.i(6388);
        ab.i("MicroMsg.JsApiUploadMediaFile", "invokeInOwn");
        String optString = aVar.bPa.bOf.optString("appId");
        String optString2 = aVar.bPa.bOf.optString("localId");
        ab.i("MicroMsg.JsApiUploadMediaFile", "uploadMediaFile, appid = %s, localid = %s, isShowProgressTips = %b", optString, optString2, Boolean.valueOf(aVar.bPa.bOf.optInt("isShowProgressTips", 0) == 1));
        if (bo.isNullOrNil(optString) || bo.isNullOrNil(optString2)) {
            ab.e("MicroMsg.JsApiUploadMediaFile", "appId or localid is null or nil.");
            aVar.a("missing arguments", null);
            AppMethodBeat.o(6388);
            return;
        }
        final LuggageUploadMediaFileManager luggageUploadMediaFileManager = new LuggageUploadMediaFileManager();
        MMActivity mMActivity = (MMActivity) ((d) aVar.bOZ).mContext;
        d dVar = (d) aVar.bOZ;
        AnonymousClass1 anonymousClass1 = new b() {
            public final void a(boolean z, HashMap<String, Object> hashMap) {
                AppMethodBeat.i(6387);
                ab.i("MicroMsg.JsApiUploadMediaFile", "sucess = %b", Boolean.valueOf(z));
                if (z) {
                    aVar.c("", hashMap);
                } else {
                    aVar.a("fail", null);
                }
                LuggageUploadMediaFileManager luggageUploadMediaFileManager = luggageUploadMediaFileManager;
                luggageUploadMediaFileManager.knn = null;
                luggageUploadMediaFileManager.uiI = null;
                luggageUploadMediaFileManager.mAppId = null;
                luggageUploadMediaFileManager.ukB = null;
                luggageUploadMediaFileManager.ukD = null;
                AppMethodBeat.o(6387);
            }
        };
        luggageUploadMediaFileManager.knn = mMActivity;
        luggageUploadMediaFileManager.uiI = dVar;
        luggageUploadMediaFileManager.mAppId = optString;
        luggageUploadMediaFileManager.ukB = optString2;
        luggageUploadMediaFileManager.ukC = r2;
        luggageUploadMediaFileManager.ukD = anonymousClass1;
        WebViewJSSDKFileItem aeo = c.aeo(luggageUploadMediaFileManager.ukB);
        if (aeo == null) {
            ab.e("MicroMsg.UploadMediaFileHelp", "item is null");
            luggageUploadMediaFileManager.ukD.a(false, null);
            AppMethodBeat.o(6388);
        } else if (aeo.cyQ == 1) {
            luggageUploadMediaFileManager.cXq();
            AppMethodBeat.o(6388);
        } else if (bo.isNullOrNil(aeo.heo) || !e.ct(aeo.heo)) {
            ab.e("MicroMsg.UploadMediaFileHelp", "origFilePath is not exist");
            luggageUploadMediaFileManager.ukD.a(false, null);
            AppMethodBeat.o(6388);
        } else if (com.tencent.mm.network.ab.ch(luggageUploadMediaFileManager.knn)) {
            luggageUploadMediaFileManager.cXp();
            AppMethodBeat.o(6388);
        } else {
            String my = bo.my((long) e.cs(aeo.heo));
            h.a(luggageUploadMediaFileManager.knn, luggageUploadMediaFileManager.knn.getString(R.string.fyw, new Object[]{my}), luggageUploadMediaFileManager.knn.getString(R.string.tz), false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(6392);
                    LuggageUploadMediaFileManager.a(LuggageUploadMediaFileManager.this);
                    AppMethodBeat.o(6392);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(6393);
                    LuggageUploadMediaFileManager.this.ukD.a(false, null);
                    AppMethodBeat.o(6393);
                }
            });
            AppMethodBeat.o(6388);
        }
    }

    public final void a(Context context, String str, bc.a aVar) {
    }
}
