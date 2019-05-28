package com.tencent.p177mm.pluginsdk.p597ui.p598e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14932m;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C40487b.C4758a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44088i.C30131a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.ArrayList;
import java.util.regex.Matcher;

/* renamed from: com.tencent.mm.pluginsdk.ui.e.a */
public final class C46505a {
    /* renamed from: bB */
    public static ArrayList<C14932m> m87788bB(Context context, String str) {
        AppMethodBeat.m2504i(79806);
        ArrayList arrayList = new ArrayList();
        Matcher matcher = C30131a.vrN.matcher(str);
        while (matcher.find()) {
            C14932m a = C46505a.m87786a(context, matcher.group(), matcher.start(), matcher.end());
            if (a != null) {
                arrayList.add(a);
            }
        }
        AppMethodBeat.m2505o(79806);
        return arrayList;
    }

    /* renamed from: a */
    public static C14932m m87786a(Context context, String str, int i, int i2) {
        AppMethodBeat.m2504i(79807);
        C14932m a = C46505a.m87787a(context, str, i, i2, 0, 0);
        AppMethodBeat.m2505o(79807);
        return a;
    }

    /* renamed from: a */
    public static C14932m m87787a(Context context, String str, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(79808);
        if (context == null) {
            context = C4996ah.getContext();
        }
        C14932m y = C4758a.vrC.mo4554y(context, str);
        if (y != null) {
            y.start = i;
            y.end = i2;
            y.linkColor = i3;
            y.backgroundColor = i4;
        }
        AppMethodBeat.m2505o(79808);
        return y;
    }
}
