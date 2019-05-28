package com.tencent.p177mm.plugin.appbrand;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p230g.p231a.C45312bw;
import com.tencent.p177mm.plugin.appbrand.C19745u.C19744a;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.service.C42686d;
import com.tencent.p177mm.plugin.base.model.C11157c;
import com.tencent.p177mm.plugin.base.model.C42781b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5068w;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.plugin.appbrand.ag */
public final class C42331ag extends C18997aj {
    public final int getType() {
        return 1;
    }

    /* renamed from: l */
    public final void mo26753l(Context context, Intent intent) {
        AppMethodBeat.m2504i(129167);
        C7060h.pYm.mo8378a(443, 2, 1, false);
        super.mo26753l(context, intent);
        AppMethodBeat.m2505o(129167);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: dx */
    public final void mo34255dx(boolean z) {
        AppMethodBeat.m2504i(129168);
        if (!z) {
            C7060h.pYm.mo8378a(443, 3, 1, false);
        }
        AppMethodBeat.m2505o(129168);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: y */
    public final int mo34257y(Intent intent) {
        return FilterEnum4Shaka.MIC_SHAKA_ADD_4;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: m */
    public final void mo34256m(final Context context, Intent intent) {
        AppMethodBeat.m2504i(129169);
        super.mo34256m(context, intent);
        String decrypt = C11157c.decrypt(C5068w.m7689n(intent, "id"));
        final int a = C5068w.m7682a(intent, "ext_info_1", 0);
        String n = C5068w.m7689n(intent, "digest");
        if (!TextUtils.isEmpty(n)) {
            final WxaAttributes zb = ((C42686d) C1720g.m3528K(C42686d.class)).mo44618zb(decrypt);
            if (zb == null) {
                C4990ab.m7413e("MiroMsg.WxaLauncherShortcutEntry", "no such WeApp(%s)", decrypt);
                AppMethodBeat.m2505o(129169);
                return;
            }
            if (!n.equals(C1178g.m2591x((zb.field_nickname + zb.field_roundedSquareIconURL + zb.field_brandIconURL + zb.field_bigHeadURL).getBytes()))) {
                C4990ab.m7417i("MiroMsg.WxaLauncherShortcutEntry", "update shortcut for wxa(%s)", decrypt);
                if (context == null) {
                    C4990ab.m7412e("MicroMsg.AppBrandShortcutManager", "remove fail, context or username is null.");
                } else if (intent == null) {
                    C4990ab.m7412e("MicroMsg.AppBrandShortcutManager", "remove fail, intent is null");
                } else {
                    C45312bw c45312bw = new C45312bw();
                    c45312bw.cuV.username = decrypt;
                    C4879a.xxA.mo10055m(c45312bw);
                    if (c45312bw.cuW.bQQ == null) {
                        C4990ab.m7413e("MicroMsg.AppBrandShortcutManager", "no such WeApp(%s)", decrypt);
                    } else {
                        String str = TextUtils.isEmpty(c45312bw.cuW.nickname) ? decrypt : c45312bw.cuW.nickname;
                        Intent intent2 = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
                        intent2.putExtra("android.intent.extra.shortcut.NAME", str);
                        intent2.putExtra("duplicate", false);
                        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
                        C42781b.m75870s(context, intent2);
                        C4990ab.m7417i("MicroMsg.AppBrandShortcutManager", "remove shortcut %s", decrypt);
                    }
                }
                C5004al.m7442n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(129166);
                        C1720g.m3534RN();
                        C19745u.m30568a(context, new C19744a(C1668a.m3383QF(), new String[]{zb.field_roundedSquareIconURL, zb.field_brandIconURL, zb.field_bigHeadURL}, zb.field_nickname, zb.field_appId, zb.field_username), a, true);
                        AppMethodBeat.m2505o(129166);
                    }
                }, 1000);
            }
        }
        intent.putExtra("type", 0);
        intent.putExtra("id", "");
        AppMethodBeat.m2505o(129169);
    }
}
