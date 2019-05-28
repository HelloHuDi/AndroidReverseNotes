package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Base64;
import android.view.View;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.modelsfs.FileOp;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p190at.p191a.p193c.C1282i;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p230g.p231a.C18372qb;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.model.EmojiLogic;
import com.tencent.p177mm.plugin.emoji.p383h.C2933b;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.plugin.webview.luggage.p1420c.C29782c;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.io.File;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.aw */
public class C14496aw extends C46419bd<C24905d> {
    /* renamed from: a */
    static /* synthetic */ void m22698a(C14496aw c14496aw, Context context, String str, C22841a c22841a) {
        AppMethodBeat.m2504i(6381);
        c14496aw.m22699b(context, str, c22841a);
        AppMethodBeat.m2505o(6381);
    }

    public final String name() {
        return "shareEmoticon";
    }

    public final int biG() {
        return 2;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
    }

    /* renamed from: a */
    public final void mo9617a(final Context context, String str, final C22841a c22841a) {
        AppMethodBeat.m2504i(6379);
        C4990ab.m7416i("MicroMsg.JsApiShareEmotion", "invoke");
        JSONObject AI = C29782c.m47225AI(str);
        if (AI == null) {
            C4990ab.m7412e("MicroMsg.JsApiShareEmotion", "data is null");
            c22841a.mo26722d("null_data", null);
            AppMethodBeat.m2505o(6379);
            return;
        }
        String optString = AI.optString("base64DataString");
        final String optString2 = AI.optString("url");
        String L;
        if (C5046bo.isNullOrNil(optString)) {
            C4990ab.m7417i("MicroMsg.JsApiShareEmotion", "doShareEmoticon use url:%s", optString2);
            File file = new File(context.getCacheDir(), C1178g.m2591x(optString2.getBytes()));
            if (file.exists()) {
                optString2 = C1178g.m2589v(file);
                L = EmojiLogic.m44073L(C2933b.m5221Yb(), "", optString2);
                if (!FileOp.m64138ct(L)) {
                    FileOp.m64149y(file.getAbsolutePath(), L);
                }
                m22699b(context, optString2, c22841a);
                AppMethodBeat.m2505o(6379);
                return;
            }
            C17927a c17927a = new C17927a();
            c17927a.ePH = true;
            c17927a.ePJ = file.getAbsolutePath();
            c17927a.eQd = new Object[]{file.getAbsolutePath()};
            C42952j.bjW().mo43768a(optString2, null, c17927a.ahG(), new C1282i() {
                /* renamed from: a */
                public final void mo4581a(String str, View view, Bitmap bitmap, Object... objArr) {
                    AppMethodBeat.m2504i(6377);
                    C4990ab.m7417i("MicroMsg.JsApiShareEmotion", "imageLoaderListener onImageLoadComplete %s", str);
                    if (bitmap != null && objArr != null && objArr.length > 0 && objArr[0] != null && (objArr[0] instanceof String) && str.equals(optString2)) {
                        File file = new File(objArr[0].toString());
                        if (file.exists()) {
                            String v = C1178g.m2589v(file);
                            FileOp.m64149y(file.getAbsolutePath(), EmojiLogic.m44073L(C2933b.m5221Yb(), "", v));
                            C14496aw.m22698a(C14496aw.this, context, v, c22841a);
                            AppMethodBeat.m2505o(6377);
                            return;
                        }
                    }
                    c22841a.mo26722d("fail", null);
                    AppMethodBeat.m2505o(6377);
                }
            });
            AppMethodBeat.m2505o(6379);
            return;
        }
        C4990ab.m7416i("MicroMsg.JsApiShareEmotion", "use base64DataString");
        int indexOf = optString.indexOf(";base64,");
        optString2 = "";
        if (indexOf != -1) {
            optString2 = optString.substring(indexOf + 8, optString.length());
        }
        try {
            byte[] decode = Base64.decode(optString2, 0);
            if (C5046bo.m7540cb(decode)) {
                c22841a.mo26722d("fail", null);
                AppMethodBeat.m2505o(6379);
                return;
            }
            optString = C1178g.m2591x(decode);
            L = EmojiLogic.m44073L(C2933b.m5221Yb(), "", optString);
            if (!(C1173e.m2561ct(L) && C1178g.m2587cz(L).equalsIgnoreCase(optString))) {
                C1173e.m2559b(L, decode, decode.length);
            }
            m22699b(context, optString, c22841a);
            AppMethodBeat.m2505o(6379);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.JsApiShareEmotion", "doShareEmoticon error:" + e.getMessage());
            c22841a.mo26722d("base64_decode_fail", null);
            AppMethodBeat.m2505o(6379);
        }
    }

    /* renamed from: b */
    private void m22699b(final Context context, String str, final C22841a c22841a) {
        AppMethodBeat.m2504i(6380);
        Intent intent = new Intent();
        intent.putExtra("scene_from", 4);
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("Retr_Msg_Type", 5);
        intent.putExtra("Retr_Msg_thumb_path", str);
        intent.putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, C25738R.anim.f8332b5);
        if (context instanceof MMActivity) {
            ((MMActivity) context).ifE = new C5186a() {
                /* JADX WARNING: Removed duplicated region for block: B:17:0x00b6  */
                /* JADX WARNING: Removed duplicated region for block: B:23:0x00d6  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                /* renamed from: c */
                public final void mo6069c(int i, int i2, Intent intent) {
                    AppMethodBeat.m2504i(6378);
                    C4990ab.m7417i("MicroMsg.JsApiShareEmotion", "mmOnActivityResult, %d", Integer.valueOf(i));
                    if (i == (C14496aw.this.hashCode() & CdnLogic.kBizGeneric)) {
                        C4990ab.m7417i("MicroMsg.JsApiShareEmotion", "share emmotion resultCode: %d", Integer.valueOf(i2));
                        switch (i2) {
                            case -1:
                                EmojiInfo b;
                                String stringExtra;
                                String bc = C5046bo.m7532bc(intent.getStringExtra("Select_Conv_User"), "");
                                String bc2 = C5046bo.m7532bc(intent.getStringExtra("emoji_thumb_path"), "");
                                EmojiInfo aqi = C42952j.getEmojiStorageMgr().xYn.aqi(bc2);
                                if (aqi == null) {
                                    String L = EmojiLogic.m44073L(C2933b.m5221Yb(), "", bc2);
                                    if (C1173e.m2561ct(L)) {
                                        b = C42952j.getEmojiStorageMgr().xYn.mo48573b(bc2, "", EmojiInfo.yau, C5063r.amo(L) ? EmojiInfo.zYS : EmojiInfo.zYR, C1173e.m2560cs(L), null, "");
                                        for (String stringExtra2 : C5046bo.m7508P(C5046bo.m7532bc(bc, "").split(","))) {
                                            if (b != null) {
                                                C42952j.bki().mo35620a(stringExtra2, b, null);
                                            }
                                        }
                                        stringExtra2 = intent.getStringExtra("custom_send_text");
                                        if (!C5046bo.isNullOrNil(stringExtra2)) {
                                            C18372qb c18372qb = new C18372qb();
                                            c18372qb.cMq.cMr = bc;
                                            c18372qb.cMq.content = stringExtra2;
                                            c18372qb.cMq.type = C1855t.m3925nK(bc);
                                            c18372qb.cMq.flags = 0;
                                            C4879a.xxA.mo10055m(c18372qb);
                                        }
                                        C30379h.m48465bQ(context, context.getResources().getString(C25738R.string.f9229to));
                                        break;
                                    }
                                }
                                b = aqi;
                                for (String stringExtra22 : C5046bo.m7508P(C5046bo.m7532bc(bc, "").split(","))) {
                                }
                                stringExtra22 = intent.getStringExtra("custom_send_text");
                                if (C5046bo.isNullOrNil(stringExtra22)) {
                                }
                                C30379h.m48465bQ(context, context.getResources().getString(C25738R.string.f9229to));
                            case 0:
                                c22841a.mo26722d(null, null);
                                AppMethodBeat.m2505o(6378);
                                return;
                        }
                        c22841a.mo26722d(null, null);
                    }
                    AppMethodBeat.m2505o(6378);
                }
            };
            C25985d.m41466b(context, ".ui.transmit.SelectConversationUI", intent, hashCode() & CdnLogic.kBizGeneric);
        }
        AppMethodBeat.m2505o(6380);
    }
}
