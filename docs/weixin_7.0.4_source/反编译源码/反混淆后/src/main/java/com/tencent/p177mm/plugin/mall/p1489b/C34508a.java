package com.tencent.p177mm.plugin.mall.p1489b;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p230g.p231a.C18395su;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.text.SimpleDateFormat;

/* renamed from: com.tencent.mm.plugin.mall.b.a */
public final class C34508a {
    private static SimpleDateFormat krM = null;
    private static SimpleDateFormat krN = null;
    private static final String onW = (C6457e.eSn + "wallet/mall");

    static {
        AppMethodBeat.m2504i(43283);
        AppMethodBeat.m2505o(43283);
    }

    public static void bNu() {
        AppMethodBeat.m2504i(43279);
        C18395su c18395su = new C18395su();
        c18395su.cOT.cOU = false;
        C4879a.xxA.mo10055m(c18395su);
        AppMethodBeat.m2505o(43279);
    }

    /* renamed from: n */
    public static void m56568n(ImageView imageView, String str) {
        AppMethodBeat.m2504i(43280);
        C34508a.m56567d(imageView, str, 0);
        AppMethodBeat.m2505o(43280);
    }

    /* renamed from: d */
    public static void m56567d(ImageView imageView, String str, int i) {
        AppMethodBeat.m2504i(43281);
        if (imageView == null) {
            AppMethodBeat.m2505o(43281);
            return;
        }
        imageView.setImageBitmap(null);
        if (C5046bo.isNullOrNil(str)) {
            if (i != 0) {
                imageView.setImageResource(i);
            }
            AppMethodBeat.m2505o(43281);
            return;
        }
        C17927a c17927a = new C17927a();
        c17927a.ePK = C34508a.m56566Qq(str);
        c17927a.ePH = true;
        c17927a.ePZ = true;
        c17927a.eQf = false;
        if (i != 0) {
            c17927a.ePT = i;
        }
        C32291o.ahp().mo43766a(str, imageView, c17927a.ahG());
        AppMethodBeat.m2505o(43281);
    }

    /* renamed from: Qq */
    private static String m56566Qq(String str) {
        AppMethodBeat.m2504i(43282);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(43282);
            return null;
        }
        String format = String.format("%s/%s", new Object[]{onW, C1178g.m2591x(str.getBytes())});
        AppMethodBeat.m2505o(43282);
        return format;
    }
}
