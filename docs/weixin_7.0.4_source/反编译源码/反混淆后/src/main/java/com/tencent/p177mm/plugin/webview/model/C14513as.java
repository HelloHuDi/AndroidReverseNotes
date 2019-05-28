package com.tencent.p177mm.plugin.webview.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.base.model.C11157c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.p1622w.C44774a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5068w;
import com.tencent.p177mm.storage.C7616ad;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.webview.model.as */
public final class C14513as extends C44774a {
    public static String unx = "";

    public final int getType() {
        return 2;
    }

    /* renamed from: l */
    public final void mo26753l(Context context, Intent intent) {
        AppMethodBeat.m2504i(6801);
        final String decrypt = C11157c.decrypt(C5068w.m7689n(intent, "id"));
        final String decrypt2 = C11157c.decrypt(C5068w.m7689n(intent, "ext_info"));
        String n = C5068w.m7689n(intent, "token");
        if (TextUtils.isEmpty(decrypt) || TextUtils.isEmpty(decrypt2) || TextUtils.isEmpty(n)) {
            C4990ab.m7412e("MicroMsg.WebViewShortcutEntry", "jump to webview  failed, username or appId or token is null or nil.");
            AppMethodBeat.m2505o(6801);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        if (!n.equals(C35610at.m58453db(decrypt2, stringBuilder.append(C1668a.m3383QF()).toString()))) {
            SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("app_brand_global_sp", 0);
            if (sharedPreferences == null) {
                C4990ab.m7420w("MicroMsg.WebViewShortcutEntry", "jump to webview failed, sp is null.");
                AppMethodBeat.m2505o(6801);
                return;
            }
            Set<String> stringSet = sharedPreferences.getStringSet("uin_set", new HashSet());
            if (stringSet == null || stringSet.isEmpty()) {
                C4990ab.m7420w("MicroMsg.WebViewShortcutEntry", "jump to webview failed, uin set is null or nil.");
                AppMethodBeat.m2505o(6801);
                return;
            }
            HashSet hashSet = new HashSet();
            for (String db : stringSet) {
                hashSet.add(C11157c.m18864db(decrypt2, db));
            }
            if (!hashSet.contains(n)) {
                C4990ab.m7413e("MicroMsg.WebViewShortcutEntry", "jump to webview failed, illegal token(%s).", n);
                Toast.makeText(context, context.getString(C25738R.string.g2k), 1).show();
                AppMethodBeat.m2505o(6801);
                return;
            }
        }
        intent.putExtra("type", 0);
        intent.putExtra("id", "");
        String db2 = "https://game.weixin.qq.com/cgi-bin/h5/static/gameloading/index.html?wegame_ssid=25&appid=".concat(String.valueOf(decrypt2));
        if (!C5046bo.isNullOrNil(unx)) {
            db2 = db2 + "&" + unx;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("rawUrl", db2);
        intent2.putExtra("from_shortcut", true);
        intent2.putExtra("game_hv_menu_appid", decrypt2);
        intent2.addFlags(67108864);
        intent2.addFlags(268435456);
        C25985d.m41467b(context, "webview", ".ui.tools.game.H5GameWebViewUI", intent2);
        C41747z.afd().mo52930qB(decrypt);
        n = C5068w.m7689n(intent, "digest");
        if (TextUtils.isEmpty(n)) {
            C4990ab.m7416i("MicroMsg.WebViewShortcutEntry", "digest is null");
            AppMethodBeat.m2505o(6801);
            return;
        }
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(decrypt);
        if (aoO == null || C5046bo.isNullOrNil(aoO.mo16706Oi())) {
            C4990ab.m7416i("MicroMsg.WebViewShortcutEntry", "no need update, displayName is null");
            AppMethodBeat.m2505o(6801);
            return;
        }
        db2 = aoO.mo16706Oi();
        C17880h qo = C17884o.act().mo33392qo(decrypt);
        if (qo == null || C5046bo.isNullOrNil(qo.acl())) {
            C4990ab.m7416i("MicroMsg.WebViewShortcutEntry", "no need update, imgFlag is null");
            AppMethodBeat.m2505o(6801);
        } else if (n.equals(C1178g.m2591x((db2 + qo.acl()).getBytes()))) {
            C4990ab.m7416i("MicroMsg.WebViewShortcutEntry", "no need update, digest is same");
            AppMethodBeat.m2505o(6801);
        } else {
            Bitmap a = C41730b.m73490a(decrypt, false, -1);
            if (a == null || a.isRecycled()) {
                C4990ab.m7416i("MicroMsg.WebViewShortcutEntry", "icon is not downloaded, next time update");
                AppMethodBeat.m2505o(6801);
                return;
            }
            C4990ab.m7417i("MicroMsg.WebViewShortcutEntry", "update shortcut, displayName = %s", db2);
            C35610at.m58454f(context, decrypt, decrypt2, C11157c.decrypt(C5068w.m7689n(intent, "ext_info_1")));
            C5004al.m7442n(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(6800);
                    C35610at.m58448a(C4996ah.getContext(), decrypt, decrypt2, null);
                    AppMethodBeat.m2505o(6800);
                }
            }, 1000);
            AppMethodBeat.m2505o(6801);
        }
    }
}
