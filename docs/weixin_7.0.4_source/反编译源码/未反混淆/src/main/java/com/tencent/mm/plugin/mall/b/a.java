package com.tencent.mm.plugin.mall.b;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.at.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.su;
import com.tencent.mm.sdk.platformtools.bo;
import java.text.SimpleDateFormat;

public final class a {
    private static SimpleDateFormat krM = null;
    private static SimpleDateFormat krN = null;
    private static final String onW = (e.eSn + "wallet/mall");

    static {
        AppMethodBeat.i(43283);
        AppMethodBeat.o(43283);
    }

    public static void bNu() {
        AppMethodBeat.i(43279);
        su suVar = new su();
        suVar.cOT.cOU = false;
        com.tencent.mm.sdk.b.a.xxA.m(suVar);
        AppMethodBeat.o(43279);
    }

    public static void n(ImageView imageView, String str) {
        AppMethodBeat.i(43280);
        d(imageView, str, 0);
        AppMethodBeat.o(43280);
    }

    public static void d(ImageView imageView, String str, int i) {
        AppMethodBeat.i(43281);
        if (imageView == null) {
            AppMethodBeat.o(43281);
            return;
        }
        imageView.setImageBitmap(null);
        if (bo.isNullOrNil(str)) {
            if (i != 0) {
                imageView.setImageResource(i);
            }
            AppMethodBeat.o(43281);
            return;
        }
        com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
        aVar.ePK = Qq(str);
        aVar.ePH = true;
        aVar.ePZ = true;
        aVar.eQf = false;
        if (i != 0) {
            aVar.ePT = i;
        }
        o.ahp().a(str, imageView, aVar.ahG());
        AppMethodBeat.o(43281);
    }

    private static String Qq(String str) {
        AppMethodBeat.i(43282);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(43282);
            return null;
        }
        String format = String.format("%s/%s", new Object[]{onW, g.x(str.getBytes())});
        AppMethodBeat.o(43282);
        return format;
    }
}
