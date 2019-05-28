package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.tz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelappbrand.o;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.d;
import com.tencent.mm.protocal.protobuf.cfx;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.t;
import java.util.LinkedList;

public final class b {
    public static void k(final Context context, final String str, final boolean z) {
        int i = 1;
        AppMethodBeat.i(29954);
        tz tzVar = new tz();
        tzVar.cQf.csl = str;
        tzVar.cQf.action = z ? 2 : 1;
        tzVar.cQf.cQh = 2;
        a.xxA.m(tzVar);
        LinkedList linkedList = new LinkedList();
        cfx cfx = new cfx();
        cfx.xeX = str;
        if (!z) {
            i = 0;
        }
        cfx.xeW = i;
        cfx.jCt = 3;
        linkedList.add(cfx);
        aw.Rg().a(1176, new f() {
            public final void onSceneEnd(int i, int i2, String str, m mVar) {
                int i3 = 1;
                AppMethodBeat.i(29952);
                aw.Rg().b(1176, (f) this);
                ab.d("MicroMsg.AppBrandServiceHelper", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.TRUE);
                if (i == 0 && i2 == 0) {
                    AppMethodBeat.o(29952);
                    return;
                }
                t.makeText(context, R.string.d_u, 0).show();
                tz tzVar = new tz();
                tzVar.cQf.csl = str;
                tz.a aVar = tzVar.cQf;
                if (!z) {
                    i3 = 2;
                }
                aVar.action = i3;
                tzVar.cQf.cQh = 2;
                a.xxA.m(tzVar);
                AppMethodBeat.o(29952);
            }
        });
        aw.Rg().a(new o(linkedList), 0);
        AppMethodBeat.o(29954);
    }

    public static String aqJ(String str) {
        AppMethodBeat.i(29955);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(29955);
            return null;
        }
        WxaAttributes zb = ((d) g.K(d.class)).zb(str);
        if (zb == null || zb.ayJ() == null) {
            ab.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
            AppMethodBeat.o(29955);
            return null;
        }
        String str2 = zb.ayJ().hhY;
        AppMethodBeat.o(29955);
        return str2;
    }

    public static String zm(String str) {
        AppMethodBeat.i(29956);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(29956);
            return null;
        }
        WxaAttributes zb = ((d) g.K(d.class)).zb(str);
        if (zb == null || zb.ayJ() == null) {
            ab.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
            AppMethodBeat.o(29956);
            return null;
        }
        String str2 = zb.field_appId;
        AppMethodBeat.o(29956);
        return str2;
    }

    public static String aqK(String str) {
        AppMethodBeat.i(29957);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(29957);
            return null;
        }
        WxaAttributes zb = ((d) g.K(d.class)).zb(str);
        if (zb != null) {
            String str2 = zb.field_nickname;
            AppMethodBeat.o(29957);
            return str2;
        }
        ab.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
        AppMethodBeat.o(29957);
        return null;
    }
}
