package com.tencent.p177mm.plugin.appbrand.config;

import android.database.Cursor;
import android.net.Uri;
import com.tencent.luggage.wxa.storage.C41714a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.appbrand.config.s */
public final class C42409s {
    private static final Uri URI = Uri.parse("content://" + C41714a.AUTHORITY + "/WxaAttributesTable");
    private static final C42409s hiu = new C42409s();

    static {
        AppMethodBeat.m2504i(94156);
        AppMethodBeat.m2505o(94156);
    }

    public static C42409s ayO() {
        return hiu;
    }

    /* renamed from: zB */
    public static WxaAttributes m75085zB(String str) {
        AppMethodBeat.m2504i(94154);
        WxaAttributes f = C42409s.m75084f(String.format("%s=?", new Object[]{"appId"}), new String[]{str});
        AppMethodBeat.m2505o(94154);
        return f;
    }

    /* renamed from: f */
    public static WxaAttributes m75084f(String str, String[] strArr) {
        WxaAttributes wxaAttributes = null;
        AppMethodBeat.m2504i(94155);
        Cursor query = C4996ah.getContext().getContentResolver().query(URI, null, str, strArr, null);
        if (query == null) {
            AppMethodBeat.m2505o(94155);
        } else {
            if (!query.isClosed() && query.moveToFirst()) {
                wxaAttributes = new WxaAttributes();
                wxaAttributes.mo8995d(query);
            }
            query.close();
            AppMethodBeat.m2505o(94155);
        }
        return wxaAttributes;
    }
}
