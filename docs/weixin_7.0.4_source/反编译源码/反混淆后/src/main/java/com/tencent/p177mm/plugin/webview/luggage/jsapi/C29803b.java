package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Base64;
import android.view.View;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.modelsfs.FileOp;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p190at.p191a.p193c.C1282i;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.model.EmojiLogic;
import com.tencent.p177mm.plugin.emoji.p383h.C2933b;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.plugin.webview.luggage.p1420c.C29782c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.io.File;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.b */
public class C29803b extends C46419bd<C24905d> {
    /* renamed from: b */
    static /* synthetic */ void m47253b(Context context, String str, String str2, C22841a c22841a) {
        AppMethodBeat.m2504i(6276);
        C29803b.m47252a(context, str, str2, c22841a);
        AppMethodBeat.m2505o(6276);
    }

    public final String name() {
        return "addToEmoticon";
    }

    public final int biG() {
        return 2;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
        AppMethodBeat.m2504i(6274);
        C4990ab.m7416i("MicroMsg.JsApiAddToEmotion", "invoke");
        JSONObject AI = C29782c.m47225AI(str);
        if (AI == null) {
            C4990ab.m7412e("MicroMsg.JsApiAddToEmotion", "bundle is null");
            c22841a.mo26722d("null_data", null);
            AppMethodBeat.m2505o(6274);
            return;
        }
        String optString = AI.optString("base64DataString");
        final String optString2 = AI.optString("thumbUrl");
        final String optString3 = AI.optString("url");
        if (!C5046bo.isNullOrNil(optString)) {
            C4990ab.m7416i("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon use base64DataString");
            int indexOf = optString.indexOf(";base64,");
            String str2 = "";
            if (indexOf != -1) {
                str2 = optString.substring(indexOf + 8, optString.length());
            }
            try {
                byte[] decode = Base64.decode(str2, 0);
                if (C5046bo.m7540cb(decode)) {
                    c22841a.mo26722d("fail", null);
                    AppMethodBeat.m2505o(6274);
                    return;
                }
                optString = C1178g.m2591x(decode);
                optString3 = EmojiLogic.m44073L(C2933b.m5221Yb(), "", optString);
                if (!(C1173e.m2561ct(optString3) && C1178g.m2587cz(optString3).equalsIgnoreCase(optString))) {
                    C1173e.m2559b(optString3, decode, decode.length);
                }
                C29803b.m47252a(context, optString, optString2, c22841a);
                AppMethodBeat.m2505o(6274);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon error:" + e.getMessage());
                c22841a.mo26722d("fail", null);
                AppMethodBeat.m2505o(6274);
            }
        } else if (C5046bo.isNullOrNil(optString3)) {
            C4990ab.m7412e("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon base64DataString is null and url is null");
            c22841a.mo26722d("base64DataString_and_url_is_null", null);
            AppMethodBeat.m2505o(6274);
        } else {
            C4990ab.m7417i("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon use url:%s", optString3);
            File file = new File(context.getCacheDir(), C1178g.m2591x(optString3.getBytes()));
            if (file.exists()) {
                optString = C1178g.m2589v(file);
                optString3 = EmojiLogic.m44073L(C2933b.m5221Yb(), "", optString);
                if (!FileOp.m64138ct(optString3)) {
                    FileOp.m64149y(file.getAbsolutePath(), optString3);
                }
                C29803b.m47252a(context, optString, optString2, c22841a);
                AppMethodBeat.m2505o(6274);
                return;
            }
            C17927a c17927a = new C17927a();
            c17927a.ePH = true;
            c17927a.ePJ = file.getAbsolutePath();
            c17927a.eQd = new Object[]{file.getAbsolutePath()};
            final Context context2 = context;
            final C22841a c22841a2 = c22841a;
            C42952j.bjW().mo43768a(optString3, null, c17927a.ahG(), new C1282i() {
                /* renamed from: a */
                public final void mo4581a(String str, View view, Bitmap bitmap, Object... objArr) {
                    AppMethodBeat.m2504i(6273);
                    C4990ab.m7417i("MicroMsg.JsApiAddToEmotion", "imageLoaderListener onImageLoadComplete %s", str);
                    if (bitmap != null && objArr != null && objArr.length > 0 && objArr[0] != null && (objArr[0] instanceof String) && str.equals(optString3)) {
                        File file = new File(objArr[0].toString());
                        if (file.exists()) {
                            String v = C1178g.m2589v(file);
                            FileOp.m64149y(file.getAbsolutePath(), EmojiLogic.m44073L(C2933b.m5221Yb(), "", v));
                            C29803b.m47253b(context2, v, optString2, c22841a2);
                            AppMethodBeat.m2505o(6273);
                            return;
                        }
                    }
                    c22841a2.mo26722d("fail", null);
                    AppMethodBeat.m2505o(6273);
                }
            });
            AppMethodBeat.m2505o(6274);
        }
    }

    /* renamed from: a */
    private static void m47252a(Context context, String str, String str2, C22841a c22841a) {
        AppMethodBeat.m2504i(6275);
        String L = EmojiLogic.m44073L(C2933b.m5221Yb(), "", str);
        EmojiInfo aqi = C42952j.getEmojiStorageMgr().xYn.aqi(str);
        if (aqi == null && C1173e.m2561ct(L)) {
            int i = C5063r.amo(L) ? EmojiInfo.zYS : EmojiInfo.zYR;
            EmojiInfo emojiInfo = new EmojiInfo();
            emojiInfo.field_md5 = str;
            emojiInfo.field_catalog = EmojiInfo.yau;
            emojiInfo.field_type = i;
            emojiInfo.field_size = C1173e.m2560cs(L);
            emojiInfo.field_temp = 1;
            emojiInfo.field_thumbUrl = str2;
            C42952j.getEmojiStorageMgr().xYn.mo48553E(emojiInfo);
            aqi = emojiInfo;
        }
        if (aqi != null) {
            C4990ab.m7417i("MicroMsg.JsApiAddToEmotion", "doAddAction %b", Boolean.valueOf(C42952j.bki().mo35621a(context, aqi, 18, C1853r.m3846Yz())));
            if (C42952j.bki().mo35621a(context, aqi, 18, C1853r.m3846Yz())) {
                c22841a.mo26722d(null, null);
                AppMethodBeat.m2505o(6275);
                return;
            }
            c22841a.mo26722d("fail", null);
            AppMethodBeat.m2505o(6275);
            return;
        }
        c22841a.mo26722d("fail", null);
        AppMethodBeat.m2505o(6275);
    }
}
