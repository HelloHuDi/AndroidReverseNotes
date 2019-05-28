package com.tencent.mm.plugin.appbrand.widget.desktop.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.f;

public final class a {
    public static String Ey(String str) {
        AppMethodBeat.i(134251);
        if (str != null) {
            try {
                if (f.asg(str) <= 12) {
                    AppMethodBeat.o(134251);
                } else {
                    char[] toCharArray = str.toCharArray();
                    int length = toCharArray.length;
                    int i = 0;
                    int i2 = 0;
                    int i3 = 0;
                    while (i < length) {
                        i3 += f.asg(String.valueOf(toCharArray[i]));
                        if (i3 >= 12) {
                            str = str.substring(0, i2) + 8230;
                            AppMethodBeat.o(134251);
                            break;
                        }
                        i++;
                        i2++;
                    }
                }
            } catch (Exception e) {
                AppMethodBeat.o(134251);
            }
            return str;
        }
        AppMethodBeat.o(134251);
        return str;
    }
}
