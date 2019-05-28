package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Base64;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.at.a.c.i;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.webview.luggage.c.c;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.plugin.webview.luggage.jsapi.bc.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.File;
import org.json.JSONObject;

public class b extends bd<d> {
    static /* synthetic */ void b(Context context, String str, String str2, a aVar) {
        AppMethodBeat.i(6276);
        a(context, str, str2, aVar);
        AppMethodBeat.o(6276);
    }

    public final String name() {
        return "addToEmoticon";
    }

    public final int biG() {
        return 2;
    }

    public final void b(com.tencent.luggage.d.a.a aVar) {
    }

    public final void a(Context context, String str, a aVar) {
        AppMethodBeat.i(6274);
        ab.i("MicroMsg.JsApiAddToEmotion", "invoke");
        JSONObject AI = c.AI(str);
        if (AI == null) {
            ab.e("MicroMsg.JsApiAddToEmotion", "bundle is null");
            aVar.d("null_data", null);
            AppMethodBeat.o(6274);
            return;
        }
        String optString = AI.optString("base64DataString");
        final String optString2 = AI.optString("thumbUrl");
        final String optString3 = AI.optString("url");
        if (!bo.isNullOrNil(optString)) {
            ab.i("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon use base64DataString");
            int indexOf = optString.indexOf(";base64,");
            String str2 = "";
            if (indexOf != -1) {
                str2 = optString.substring(indexOf + 8, optString.length());
            }
            try {
                byte[] decode = Base64.decode(str2, 0);
                if (bo.cb(decode)) {
                    aVar.d("fail", null);
                    AppMethodBeat.o(6274);
                    return;
                }
                optString = g.x(decode);
                optString3 = EmojiLogic.L(com.tencent.mm.plugin.emoji.h.b.Yb(), "", optString);
                if (!(e.ct(optString3) && g.cz(optString3).equalsIgnoreCase(optString))) {
                    e.b(optString3, decode, decode.length);
                }
                a(context, optString, optString2, aVar);
                AppMethodBeat.o(6274);
            } catch (Exception e) {
                ab.e("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon error:" + e.getMessage());
                aVar.d("fail", null);
                AppMethodBeat.o(6274);
            }
        } else if (bo.isNullOrNil(optString3)) {
            ab.e("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon base64DataString is null and url is null");
            aVar.d("base64DataString_and_url_is_null", null);
            AppMethodBeat.o(6274);
        } else {
            ab.i("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon use url:%s", optString3);
            File file = new File(context.getCacheDir(), g.x(optString3.getBytes()));
            if (file.exists()) {
                optString = g.v(file);
                optString3 = EmojiLogic.L(com.tencent.mm.plugin.emoji.h.b.Yb(), "", optString);
                if (!FileOp.ct(optString3)) {
                    FileOp.y(file.getAbsolutePath(), optString3);
                }
                a(context, optString, optString2, aVar);
                AppMethodBeat.o(6274);
                return;
            }
            com.tencent.mm.at.a.a.c.a aVar2 = new com.tencent.mm.at.a.a.c.a();
            aVar2.ePH = true;
            aVar2.ePJ = file.getAbsolutePath();
            aVar2.eQd = new Object[]{file.getAbsolutePath()};
            final Context context2 = context;
            final a aVar3 = aVar;
            j.bjW().a(optString3, null, aVar2.ahG(), new i() {
                public final void a(String str, View view, Bitmap bitmap, Object... objArr) {
                    AppMethodBeat.i(6273);
                    ab.i("MicroMsg.JsApiAddToEmotion", "imageLoaderListener onImageLoadComplete %s", str);
                    if (bitmap != null && objArr != null && objArr.length > 0 && objArr[0] != null && (objArr[0] instanceof String) && str.equals(optString3)) {
                        File file = new File(objArr[0].toString());
                        if (file.exists()) {
                            String v = g.v(file);
                            FileOp.y(file.getAbsolutePath(), EmojiLogic.L(com.tencent.mm.plugin.emoji.h.b.Yb(), "", v));
                            b.b(context2, v, optString2, aVar3);
                            AppMethodBeat.o(6273);
                            return;
                        }
                    }
                    aVar3.d("fail", null);
                    AppMethodBeat.o(6273);
                }
            });
            AppMethodBeat.o(6274);
        }
    }

    private static void a(Context context, String str, String str2, a aVar) {
        AppMethodBeat.i(6275);
        String L = EmojiLogic.L(com.tencent.mm.plugin.emoji.h.b.Yb(), "", str);
        EmojiInfo aqi = j.getEmojiStorageMgr().xYn.aqi(str);
        if (aqi == null && e.ct(L)) {
            int i = r.amo(L) ? EmojiInfo.zYS : EmojiInfo.zYR;
            EmojiInfo emojiInfo = new EmojiInfo();
            emojiInfo.field_md5 = str;
            emojiInfo.field_catalog = EmojiInfo.yau;
            emojiInfo.field_type = i;
            emojiInfo.field_size = e.cs(L);
            emojiInfo.field_temp = 1;
            emojiInfo.field_thumbUrl = str2;
            j.getEmojiStorageMgr().xYn.E(emojiInfo);
            aqi = emojiInfo;
        }
        if (aqi != null) {
            ab.i("MicroMsg.JsApiAddToEmotion", "doAddAction %b", Boolean.valueOf(j.bki().a(context, aqi, 18, com.tencent.mm.model.r.Yz())));
            if (j.bki().a(context, aqi, 18, com.tencent.mm.model.r.Yz())) {
                aVar.d(null, null);
                AppMethodBeat.o(6275);
                return;
            }
            aVar.d("fail", null);
            AppMethodBeat.o(6275);
            return;
        }
        aVar.d("fail", null);
        AppMethodBeat.o(6275);
    }
}
