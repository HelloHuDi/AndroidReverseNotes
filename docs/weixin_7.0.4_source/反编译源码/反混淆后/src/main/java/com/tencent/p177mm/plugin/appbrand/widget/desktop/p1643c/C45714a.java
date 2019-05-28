package com.tencent.p177mm.plugin.appbrand.widget.desktop.p1643c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.tools.C5584f;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.c.a */
public final class C45714a {
    /* renamed from: Ey */
    public static String m84464Ey(String str) {
        AppMethodBeat.m2504i(134251);
        if (str != null) {
            try {
                if (C5584f.asg(str) <= 12) {
                    AppMethodBeat.m2505o(134251);
                } else {
                    char[] toCharArray = str.toCharArray();
                    int length = toCharArray.length;
                    int i = 0;
                    int i2 = 0;
                    int i3 = 0;
                    while (i < length) {
                        i3 += C5584f.asg(String.valueOf(toCharArray[i]));
                        if (i3 >= 12) {
                            str = str.substring(0, i2) + 8230;
                            AppMethodBeat.m2505o(134251);
                            break;
                        }
                        i++;
                        i2++;
                    }
                }
            } catch (Exception e) {
                AppMethodBeat.m2505o(134251);
            }
            return str;
        }
        AppMethodBeat.m2505o(134251);
        return str;
    }
}
