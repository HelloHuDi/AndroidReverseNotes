package com.tencent.mm.plugin.scanner.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.plugin.scanner.util.o.a;
import com.tencent.mm.sdk.platformtools.bo;

public final class j {
    public static String a(Context context, a aVar) {
        AppMethodBeat.i(80853);
        b bVar = new b();
        bVar.appId = BT(aVar.field_functionType);
        bVar.title = aVar.field_title;
        bVar.description = aVar.field_source;
        bVar.type = 10;
        bVar.url = aVar.field_shareurl;
        bVar.action = "";
        bVar.appName = o.T(context, aVar.field_type);
        bVar.thumburl = aVar.field_thumburl;
        bVar.fgP = aVar.field_type;
        bVar.fgQ = o.c(aVar);
        String a = b.a(bVar, null, null);
        AppMethodBeat.o(80853);
        return a;
    }

    public static String BT(int i) {
        if (i == 4) {
            return "wxfbc915ff7c30e335";
        }
        if (i == 3) {
            return "wx482a4001c37e2b74";
        }
        return "wxfbc915ff7c30e335";
    }

    public static a cV(String str, int i) {
        AppMethodBeat.i(80854);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(80854);
            return null;
        }
        int Wn = o.Wn(str);
        a cW;
        if (Wn == 3) {
            cW = o.cW(str, i);
            AppMethodBeat.o(80854);
            return cW;
        } else if (Wn == 4) {
            cW = o.Wq(str);
            AppMethodBeat.o(80854);
            return cW;
        } else {
            AppMethodBeat.o(80854);
            return null;
        }
    }
}
