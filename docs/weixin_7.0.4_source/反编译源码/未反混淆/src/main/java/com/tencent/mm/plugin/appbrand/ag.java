package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.d;
import com.tencent.mm.plugin.base.model.b;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.ttpic.FilterEnum4Shaka;

public final class ag extends aj {
    public final int getType() {
        return 1;
    }

    public final void l(Context context, Intent intent) {
        AppMethodBeat.i(129167);
        h.pYm.a(443, 2, 1, false);
        super.l(context, intent);
        AppMethodBeat.o(129167);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dx(boolean z) {
        AppMethodBeat.i(129168);
        if (!z) {
            h.pYm.a(443, 3, 1, false);
        }
        AppMethodBeat.o(129168);
    }

    /* Access modifiers changed, original: protected|final */
    public final int y(Intent intent) {
        return FilterEnum4Shaka.MIC_SHAKA_ADD_4;
    }

    /* Access modifiers changed, original: protected|final */
    public final void m(final Context context, Intent intent) {
        AppMethodBeat.i(129169);
        super.m(context, intent);
        String decrypt = c.decrypt(w.n(intent, "id"));
        final int a = w.a(intent, "ext_info_1", 0);
        String n = w.n(intent, "digest");
        if (!TextUtils.isEmpty(n)) {
            final WxaAttributes zb = ((d) g.K(d.class)).zb(decrypt);
            if (zb == null) {
                ab.e("MiroMsg.WxaLauncherShortcutEntry", "no such WeApp(%s)", decrypt);
                AppMethodBeat.o(129169);
                return;
            }
            if (!n.equals(com.tencent.mm.a.g.x((zb.field_nickname + zb.field_roundedSquareIconURL + zb.field_brandIconURL + zb.field_bigHeadURL).getBytes()))) {
                ab.i("MiroMsg.WxaLauncherShortcutEntry", "update shortcut for wxa(%s)", decrypt);
                if (context == null) {
                    ab.e("MicroMsg.AppBrandShortcutManager", "remove fail, context or username is null.");
                } else if (intent == null) {
                    ab.e("MicroMsg.AppBrandShortcutManager", "remove fail, intent is null");
                } else {
                    bw bwVar = new bw();
                    bwVar.cuV.username = decrypt;
                    a.xxA.m(bwVar);
                    if (bwVar.cuW.bQQ == null) {
                        ab.e("MicroMsg.AppBrandShortcutManager", "no such WeApp(%s)", decrypt);
                    } else {
                        String str = TextUtils.isEmpty(bwVar.cuW.nickname) ? decrypt : bwVar.cuW.nickname;
                        Intent intent2 = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
                        intent2.putExtra("android.intent.extra.shortcut.NAME", str);
                        intent2.putExtra("duplicate", false);
                        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
                        b.s(context, intent2);
                        ab.i("MicroMsg.AppBrandShortcutManager", "remove shortcut %s", decrypt);
                    }
                }
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(129166);
                        g.RN();
                        u.a(context, new u.a(com.tencent.mm.kernel.a.QF(), new String[]{zb.field_roundedSquareIconURL, zb.field_brandIconURL, zb.field_bigHeadURL}, zb.field_nickname, zb.field_appId, zb.field_username), a, true);
                        AppMethodBeat.o(129166);
                    }
                }, 1000);
            }
        }
        intent.putExtra("type", 0);
        intent.putExtra("id", "");
        AppMethodBeat.o(129169);
    }
}
