package com.tencent.p177mm.plugin.gallery.p1267a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.gallery.a.a */
public final class C20902a {
    public static void swap(List<?> list, int i, int i2) {
        AppMethodBeat.m2504i(21620);
        if (i > i2) {
            while (i > i2) {
                Collections.swap(list, i, i - 1);
                i--;
            }
            AppMethodBeat.m2505o(21620);
            return;
        }
        while (i < i2) {
            Collections.swap(list, i, i + 1);
            i++;
        }
        AppMethodBeat.m2505o(21620);
    }
}
