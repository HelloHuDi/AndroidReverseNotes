package com.tencent.mm.plugin.appbrand.config;

import android.database.Cursor;
import android.net.Uri;
import com.tencent.luggage.wxa.storage.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

public final class s {
    private static final Uri URI = Uri.parse("content://" + a.AUTHORITY + "/WxaAttributesTable");
    private static final s hiu = new s();

    static {
        AppMethodBeat.i(94156);
        AppMethodBeat.o(94156);
    }

    public static s ayO() {
        return hiu;
    }

    public static WxaAttributes zB(String str) {
        AppMethodBeat.i(94154);
        WxaAttributes f = f(String.format("%s=?", new Object[]{"appId"}), new String[]{str});
        AppMethodBeat.o(94154);
        return f;
    }

    public static WxaAttributes f(String str, String[] strArr) {
        WxaAttributes wxaAttributes = null;
        AppMethodBeat.i(94155);
        Cursor query = ah.getContext().getContentResolver().query(URI, null, str, strArr, null);
        if (query == null) {
            AppMethodBeat.o(94155);
        } else {
            if (!query.isClosed() && query.moveToFirst()) {
                wxaAttributes = new WxaAttributes();
                wxaAttributes.d(query);
            }
            query.close();
            AppMethodBeat.o(94155);
        }
        return wxaAttributes;
    }
}
