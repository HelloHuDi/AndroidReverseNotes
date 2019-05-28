package com.tencent.mm.pluginsdk.ui.e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;
import java.util.regex.Matcher;

public final class a {
    public static ArrayList<m> bB(Context context, String str) {
        AppMethodBeat.i(79806);
        ArrayList arrayList = new ArrayList();
        Matcher matcher = com.tencent.mm.pluginsdk.ui.e.i.a.vrN.matcher(str);
        while (matcher.find()) {
            m a = a(context, matcher.group(), matcher.start(), matcher.end());
            if (a != null) {
                arrayList.add(a);
            }
        }
        AppMethodBeat.o(79806);
        return arrayList;
    }

    public static m a(Context context, String str, int i, int i2) {
        AppMethodBeat.i(79807);
        m a = a(context, str, i, i2, 0, 0);
        AppMethodBeat.o(79807);
        return a;
    }

    public static m a(Context context, String str, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(79808);
        if (context == null) {
            context = ah.getContext();
        }
        m y = com.tencent.mm.pluginsdk.ui.e.b.a.vrC.y(context, str);
        if (y != null) {
            y.start = i;
            y.end = i2;
            y.linkColor = i3;
            y.backgroundColor = i4;
        }
        AppMethodBeat.o(79808);
        return y;
    }
}
