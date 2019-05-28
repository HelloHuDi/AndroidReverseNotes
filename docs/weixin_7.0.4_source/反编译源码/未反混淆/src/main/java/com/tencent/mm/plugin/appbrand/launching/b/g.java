package com.tencent.mm.plugin.appbrand.launching.b;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.ttpic.FilterEnum4Shaka;

public final class g implements f {
    private static final int[] ijo = new int[]{1025, 1031, FilterEnum4Shaka.MIC_SHAKA_ADD_13};
    private static final int[] ijp = new int[]{1011, 1012, 1013, FilterEnum4Shaka.MIC_SHAKA_ADD2_12, 1049, 1048, 1050, 1124, 1125, 1126};
    private final d ijq = new d();
    private final f ijr = new f();
    private final c ijs = new c();

    public g() {
        AppMethodBeat.i(132041);
        AppMethodBeat.o(132041);
    }

    public final boolean Cl(String str) {
        AppMethodBeat.i(132042);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(132042);
            return false;
        }
        b bVar;
        ab.i("MicroMsg.WeAppLinkOpener", "handle appLink = %s", str);
        for (b bVar2 : b.values()) {
            int i;
            if (bo.isNullOrNil(str) || !str.startsWith(bVar2.fNY)) {
                boolean i2 = false;
            } else {
                i2 = 1;
            }
            if (i2 != 0) {
                bVar = bVar2;
                break;
            }
        }
        bVar = null;
        if (bVar != null) {
            Uri parse;
            try {
                parse = Uri.parse(str);
            } catch (Exception e) {
                ab.e("MicroMsg.WeAppLinkOpener", "handle nativeLink = %s, exp = %s", str, e);
                parse = null;
            }
            if (parse == null) {
                AppMethodBeat.o(132042);
                return false;
            }
            String queryParameter = parse.getQueryParameter("username");
            String queryParameter2 = parse.getQueryParameter("path");
            if (bo.isNullOrNil(queryParameter) || !ad.mg(queryParameter)) {
                AppMethodBeat.o(132042);
                return false;
            }
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = bVar.scene;
            appBrandStatObject.cst = b.aHI();
            appBrandStatObject.cOq = 0;
            appBrandStatObject.cOr = b.aHJ();
            AppBrandLaunchProxyUI.a(null, queryParameter, queryParameter2, 0, -1, appBrandStatObject, null, null);
            AppMethodBeat.o(132042);
            return true;
        }
        AppMethodBeat.o(132042);
        return false;
    }

    public final boolean b(Context context, String str, int i, Bundle bundle) {
        AppMethodBeat.i(132043);
        if (a.contains(ijo, i)) {
            if (a.a.OK == this.ijq.a(context, str, i, bundle)) {
                AppMethodBeat.o(132043);
                return true;
            }
            AppMethodBeat.o(132043);
            return false;
        } else if (a.contains(ijp, i)) {
            if (a.a.OK == this.ijr.a(context, str, i, bundle)) {
                AppMethodBeat.o(132043);
                return true;
            }
            AppMethodBeat.o(132043);
            return false;
        } else if (FilterEnum4Shaka.MIC_WEISHI_BAIHUA != i && FilterEnum4Shaka.MIC_WEISHI_v4_4_NORMAL != i) {
            ab.e("MicroMsg.WeAppLinkOpener", "handleScanCodeLink, unhandled case link[ %s ], scene[ %d ]", str, Integer.valueOf(i));
            AppMethodBeat.o(132043);
            return false;
        } else if (a.a.OK == this.ijs.a(context, str, i, bundle)) {
            AppMethodBeat.o(132043);
            return true;
        } else {
            AppMethodBeat.o(132043);
            return false;
        }
    }
}
