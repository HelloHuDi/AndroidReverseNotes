package com.tencent.mm.plugin.appbrand;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.sdk.platformtools.bo;

public final class t implements com.tencent.mm.modelappbrand.b.a {

    static class a {
        static t gQg = new t();

        static {
            AppMethodBeat.i(129115);
            AppMethodBeat.o(129115);
        }
    }

    public static t auu() {
        return a.gQg;
    }

    public final Intent a(String str, int i, String str2, String str3, String[] strArr, String str4, int i2, int i3) {
        AppMethodBeat.i(129116);
        String Fv = c.Fv(str2);
        if (bo.isNullOrNil(Fv)) {
            AppMethodBeat.o(129116);
            return null;
        }
        if (!TextUtils.isEmpty(str3)) {
            str2 = str3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : strArr) {
            stringBuilder.append(append);
        }
        String x = g.x((str2 + stringBuilder.toString()).getBytes());
        Intent intent = new Intent("com.tencent.mm.action.WX_SHORTCUT");
        intent.putExtra("type", i3);
        intent.putExtra("id", Fv);
        intent.putExtra("ext_info", c.Fv(str4));
        intent.putExtra("token", c.db(str4, String.valueOf(i2)));
        intent.putExtra("digest", x);
        intent.putExtra("ext_info_1", i);
        intent.setPackage(str);
        intent.addFlags(67108864);
        AppMethodBeat.o(129116);
        return intent;
    }
}
