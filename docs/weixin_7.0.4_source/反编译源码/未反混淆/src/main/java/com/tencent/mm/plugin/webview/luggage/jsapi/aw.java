package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Base64;
import android.view.View;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.at.a.c.i;
import com.tencent.mm.g.a.qb;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.webview.luggage.c.c;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.plugin.webview.luggage.jsapi.bc.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.h;
import java.io.File;
import org.json.JSONObject;

public class aw extends bd<d> {
    static /* synthetic */ void a(aw awVar, Context context, String str, a aVar) {
        AppMethodBeat.i(6381);
        awVar.b(context, str, aVar);
        AppMethodBeat.o(6381);
    }

    public final String name() {
        return "shareEmoticon";
    }

    public final int biG() {
        return 2;
    }

    public final void b(com.tencent.luggage.d.a.a aVar) {
    }

    public final void a(final Context context, String str, final a aVar) {
        AppMethodBeat.i(6379);
        ab.i("MicroMsg.JsApiShareEmotion", "invoke");
        JSONObject AI = c.AI(str);
        if (AI == null) {
            ab.e("MicroMsg.JsApiShareEmotion", "data is null");
            aVar.d("null_data", null);
            AppMethodBeat.o(6379);
            return;
        }
        String optString = AI.optString("base64DataString");
        final String optString2 = AI.optString("url");
        String L;
        if (bo.isNullOrNil(optString)) {
            ab.i("MicroMsg.JsApiShareEmotion", "doShareEmoticon use url:%s", optString2);
            File file = new File(context.getCacheDir(), g.x(optString2.getBytes()));
            if (file.exists()) {
                optString2 = g.v(file);
                L = EmojiLogic.L(b.Yb(), "", optString2);
                if (!FileOp.ct(L)) {
                    FileOp.y(file.getAbsolutePath(), L);
                }
                b(context, optString2, aVar);
                AppMethodBeat.o(6379);
                return;
            }
            com.tencent.mm.at.a.a.c.a aVar2 = new com.tencent.mm.at.a.a.c.a();
            aVar2.ePH = true;
            aVar2.ePJ = file.getAbsolutePath();
            aVar2.eQd = new Object[]{file.getAbsolutePath()};
            j.bjW().a(optString2, null, aVar2.ahG(), new i() {
                public final void a(String str, View view, Bitmap bitmap, Object... objArr) {
                    AppMethodBeat.i(6377);
                    ab.i("MicroMsg.JsApiShareEmotion", "imageLoaderListener onImageLoadComplete %s", str);
                    if (bitmap != null && objArr != null && objArr.length > 0 && objArr[0] != null && (objArr[0] instanceof String) && str.equals(optString2)) {
                        File file = new File(objArr[0].toString());
                        if (file.exists()) {
                            String v = g.v(file);
                            FileOp.y(file.getAbsolutePath(), EmojiLogic.L(b.Yb(), "", v));
                            aw.a(aw.this, context, v, aVar);
                            AppMethodBeat.o(6377);
                            return;
                        }
                    }
                    aVar.d("fail", null);
                    AppMethodBeat.o(6377);
                }
            });
            AppMethodBeat.o(6379);
            return;
        }
        ab.i("MicroMsg.JsApiShareEmotion", "use base64DataString");
        int indexOf = optString.indexOf(";base64,");
        optString2 = "";
        if (indexOf != -1) {
            optString2 = optString.substring(indexOf + 8, optString.length());
        }
        try {
            byte[] decode = Base64.decode(optString2, 0);
            if (bo.cb(decode)) {
                aVar.d("fail", null);
                AppMethodBeat.o(6379);
                return;
            }
            optString = g.x(decode);
            L = EmojiLogic.L(b.Yb(), "", optString);
            if (!(e.ct(L) && g.cz(L).equalsIgnoreCase(optString))) {
                e.b(L, decode, decode.length);
            }
            b(context, optString, aVar);
            AppMethodBeat.o(6379);
        } catch (Exception e) {
            ab.e("MicroMsg.JsApiShareEmotion", "doShareEmoticon error:" + e.getMessage());
            aVar.d("base64_decode_fail", null);
            AppMethodBeat.o(6379);
        }
    }

    private void b(final Context context, String str, final a aVar) {
        AppMethodBeat.i(6380);
        Intent intent = new Intent();
        intent.putExtra("scene_from", 4);
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("Retr_Msg_Type", 5);
        intent.putExtra("Retr_Msg_thumb_path", str);
        intent.putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, R.anim.b5);
        if (context instanceof MMActivity) {
            ((MMActivity) context).ifE = new MMActivity.a() {
                /* JADX WARNING: Removed duplicated region for block: B:17:0x00b6  */
                /* JADX WARNING: Removed duplicated region for block: B:23:0x00d6  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void c(int i, int i2, Intent intent) {
                    AppMethodBeat.i(6378);
                    ab.i("MicroMsg.JsApiShareEmotion", "mmOnActivityResult, %d", Integer.valueOf(i));
                    if (i == (aw.this.hashCode() & CdnLogic.kBizGeneric)) {
                        ab.i("MicroMsg.JsApiShareEmotion", "share emmotion resultCode: %d", Integer.valueOf(i2));
                        switch (i2) {
                            case -1:
                                EmojiInfo b;
                                String stringExtra;
                                String bc = bo.bc(intent.getStringExtra("Select_Conv_User"), "");
                                String bc2 = bo.bc(intent.getStringExtra("emoji_thumb_path"), "");
                                EmojiInfo aqi = j.getEmojiStorageMgr().xYn.aqi(bc2);
                                if (aqi == null) {
                                    String L = EmojiLogic.L(b.Yb(), "", bc2);
                                    if (e.ct(L)) {
                                        b = j.getEmojiStorageMgr().xYn.b(bc2, "", EmojiInfo.yau, r.amo(L) ? EmojiInfo.zYS : EmojiInfo.zYR, e.cs(L), null, "");
                                        for (String stringExtra2 : bo.P(bo.bc(bc, "").split(","))) {
                                            if (b != null) {
                                                j.bki().a(stringExtra2, b, null);
                                            }
                                        }
                                        stringExtra2 = intent.getStringExtra("custom_send_text");
                                        if (!bo.isNullOrNil(stringExtra2)) {
                                            qb qbVar = new qb();
                                            qbVar.cMq.cMr = bc;
                                            qbVar.cMq.content = stringExtra2;
                                            qbVar.cMq.type = t.nK(bc);
                                            qbVar.cMq.flags = 0;
                                            com.tencent.mm.sdk.b.a.xxA.m(qbVar);
                                        }
                                        h.bQ(context, context.getResources().getString(R.string.to));
                                        break;
                                    }
                                }
                                b = aqi;
                                for (String stringExtra22 : bo.P(bo.bc(bc, "").split(","))) {
                                }
                                stringExtra22 = intent.getStringExtra("custom_send_text");
                                if (bo.isNullOrNil(stringExtra22)) {
                                }
                                h.bQ(context, context.getResources().getString(R.string.to));
                            case 0:
                                aVar.d(null, null);
                                AppMethodBeat.o(6378);
                                return;
                        }
                        aVar.d(null, null);
                    }
                    AppMethodBeat.o(6378);
                }
            };
            com.tencent.mm.bp.d.b(context, ".ui.transmit.SelectConversationUI", intent, hashCode() & CdnLogic.kBizGeneric);
        }
        AppMethodBeat.o(6380);
    }
}
