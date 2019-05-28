package com.tencent.p177mm.plugin.appbrand.launching.p906b;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.loader.C32473a;
import com.tencent.p177mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.p177mm.plugin.appbrand.launching.p906b.C10590a.C10593a;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.service.C42687f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.b.g */
public final class C45636g implements C42687f {
    private static final int[] ijo = new int[]{1025, 1031, FilterEnum4Shaka.MIC_SHAKA_ADD_13};
    private static final int[] ijp = new int[]{1011, 1012, 1013, FilterEnum4Shaka.MIC_SHAKA_ADD2_12, 1049, 1048, 1050, 1124, 1125, 1126};
    private final C16688d ijq = new C16688d();
    private final C33434f ijr = new C33434f();
    private final C16686c ijs = new C16686c();

    public C45636g() {
        AppMethodBeat.m2504i(132041);
        AppMethodBeat.m2505o(132041);
    }

    /* renamed from: Cl */
    public final boolean mo68089Cl(String str) {
        AppMethodBeat.m2504i(132042);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(132042);
            return false;
        }
        C10594b c10594b;
        C4990ab.m7417i("MicroMsg.WeAppLinkOpener", "handle appLink = %s", str);
        for (C10594b c10594b2 : C10594b.values()) {
            int i;
            if (C5046bo.isNullOrNil(str) || !str.startsWith(c10594b2.fNY)) {
                boolean i2 = false;
            } else {
                i2 = 1;
            }
            if (i2 != 0) {
                c10594b = c10594b2;
                break;
            }
        }
        c10594b = null;
        if (c10594b != null) {
            Uri parse;
            try {
                parse = Uri.parse(str);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.WeAppLinkOpener", "handle nativeLink = %s, exp = %s", str, e);
                parse = null;
            }
            if (parse == null) {
                AppMethodBeat.m2505o(132042);
                return false;
            }
            String queryParameter = parse.getQueryParameter("username");
            String queryParameter2 = parse.getQueryParameter("path");
            if (C5046bo.isNullOrNil(queryParameter) || !C7616ad.m13549mg(queryParameter)) {
                AppMethodBeat.m2505o(132042);
                return false;
            }
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = c10594b.scene;
            appBrandStatObject.cst = C10594b.aHI();
            appBrandStatObject.cOq = 0;
            appBrandStatObject.cOr = C10594b.aHJ();
            AppBrandLaunchProxyUI.m25693a(null, queryParameter, queryParameter2, 0, -1, appBrandStatObject, null, null);
            AppMethodBeat.m2505o(132042);
            return true;
        }
        AppMethodBeat.m2505o(132042);
        return false;
    }

    /* renamed from: b */
    public final boolean mo68090b(Context context, String str, int i, Bundle bundle) {
        AppMethodBeat.m2504i(132043);
        if (C32473a.contains(ijo, i)) {
            if (C10593a.OK == this.ijq.mo22103a(context, str, i, bundle)) {
                AppMethodBeat.m2505o(132043);
                return true;
            }
            AppMethodBeat.m2505o(132043);
            return false;
        } else if (C32473a.contains(ijp, i)) {
            if (C10593a.OK == this.ijr.mo22103a(context, str, i, bundle)) {
                AppMethodBeat.m2505o(132043);
                return true;
            }
            AppMethodBeat.m2505o(132043);
            return false;
        } else if (FilterEnum4Shaka.MIC_WEISHI_BAIHUA != i && FilterEnum4Shaka.MIC_WEISHI_v4_4_NORMAL != i) {
            C4990ab.m7413e("MicroMsg.WeAppLinkOpener", "handleScanCodeLink, unhandled case link[ %s ], scene[ %d ]", str, Integer.valueOf(i));
            AppMethodBeat.m2505o(132043);
            return false;
        } else if (C10593a.OK == this.ijs.mo22103a(context, str, i, bundle)) {
            AppMethodBeat.m2505o(132043);
            return true;
        } else {
            AppMethodBeat.m2505o(132043);
            return false;
        }
    }
}
