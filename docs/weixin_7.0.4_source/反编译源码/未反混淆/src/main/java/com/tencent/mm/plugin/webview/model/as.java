package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.o;
import com.tencent.mm.aj.z;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.w.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ad;
import java.util.HashSet;
import java.util.Set;

public final class as extends a {
    public static String unx = "";

    public final int getType() {
        return 2;
    }

    public final void l(Context context, Intent intent) {
        AppMethodBeat.i(6801);
        final String decrypt = c.decrypt(w.n(intent, "id"));
        final String decrypt2 = c.decrypt(w.n(intent, "ext_info"));
        String n = w.n(intent, "token");
        if (TextUtils.isEmpty(decrypt) || TextUtils.isEmpty(decrypt2) || TextUtils.isEmpty(n)) {
            ab.e("MicroMsg.WebViewShortcutEntry", "jump to webview  failed, username or appId or token is null or nil.");
            AppMethodBeat.o(6801);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        g.RN();
        if (!n.equals(at.db(decrypt2, stringBuilder.append(com.tencent.mm.kernel.a.QF()).toString()))) {
            SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("app_brand_global_sp", 0);
            if (sharedPreferences == null) {
                ab.w("MicroMsg.WebViewShortcutEntry", "jump to webview failed, sp is null.");
                AppMethodBeat.o(6801);
                return;
            }
            Set<String> stringSet = sharedPreferences.getStringSet("uin_set", new HashSet());
            if (stringSet == null || stringSet.isEmpty()) {
                ab.w("MicroMsg.WebViewShortcutEntry", "jump to webview failed, uin set is null or nil.");
                AppMethodBeat.o(6801);
                return;
            }
            HashSet hashSet = new HashSet();
            for (String db : stringSet) {
                hashSet.add(c.db(decrypt2, db));
            }
            if (!hashSet.contains(n)) {
                ab.e("MicroMsg.WebViewShortcutEntry", "jump to webview failed, illegal token(%s).", n);
                Toast.makeText(context, context.getString(R.string.g2k), 1).show();
                AppMethodBeat.o(6801);
                return;
            }
        }
        intent.putExtra("type", 0);
        intent.putExtra("id", "");
        String db2 = "https://game.weixin.qq.com/cgi-bin/h5/static/gameloading/index.html?wegame_ssid=25&appid=".concat(String.valueOf(decrypt2));
        if (!bo.isNullOrNil(unx)) {
            db2 = db2 + "&" + unx;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("rawUrl", db2);
        intent2.putExtra("from_shortcut", true);
        intent2.putExtra("game_hv_menu_appid", decrypt2);
        intent2.addFlags(67108864);
        intent2.addFlags(268435456);
        d.b(context, "webview", ".ui.tools.game.H5GameWebViewUI", intent2);
        z.afd().qB(decrypt);
        n = w.n(intent, "digest");
        if (TextUtils.isEmpty(n)) {
            ab.i("MicroMsg.WebViewShortcutEntry", "digest is null");
            AppMethodBeat.o(6801);
            return;
        }
        ad aoO = ((j) g.K(j.class)).XM().aoO(decrypt);
        if (aoO == null || bo.isNullOrNil(aoO.Oi())) {
            ab.i("MicroMsg.WebViewShortcutEntry", "no need update, displayName is null");
            AppMethodBeat.o(6801);
            return;
        }
        db2 = aoO.Oi();
        h qo = o.act().qo(decrypt);
        if (qo == null || bo.isNullOrNil(qo.acl())) {
            ab.i("MicroMsg.WebViewShortcutEntry", "no need update, imgFlag is null");
            AppMethodBeat.o(6801);
        } else if (n.equals(com.tencent.mm.a.g.x((db2 + qo.acl()).getBytes()))) {
            ab.i("MicroMsg.WebViewShortcutEntry", "no need update, digest is same");
            AppMethodBeat.o(6801);
        } else {
            Bitmap a = b.a(decrypt, false, -1);
            if (a == null || a.isRecycled()) {
                ab.i("MicroMsg.WebViewShortcutEntry", "icon is not downloaded, next time update");
                AppMethodBeat.o(6801);
                return;
            }
            ab.i("MicroMsg.WebViewShortcutEntry", "update shortcut, displayName = %s", db2);
            at.f(context, decrypt, decrypt2, c.decrypt(w.n(intent, "ext_info_1")));
            al.n(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(6800);
                    at.a(ah.getContext(), decrypt, decrypt2, null);
                    AppMethodBeat.o(6800);
                }
            }, 1000);
            AppMethodBeat.o(6801);
        }
    }
}
